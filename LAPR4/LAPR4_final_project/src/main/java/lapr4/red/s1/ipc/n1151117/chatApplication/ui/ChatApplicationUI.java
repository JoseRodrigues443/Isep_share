/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import lapr4.blue.s2.ipc.n1150630.chatApplication.application.EditProfileController;
import lapr4.blue.s2.ipc.n1150630.chatApplication.ui.EditProfileUI;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoomList;
import lapr4.green.s3.ipc.n1150759.chatApplication.ui.ChatRoomUI;
import lapr4.green.s3.ipc.n1150759.chatApplication.ui.CreateChatRoomUI;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.n1151117.chatApplication.ExtensionChatApplication;
import lapr4.red.s1.ipc.n1151117.chatApplication.IObserver;
import lapr4.red.s1.ipc.n1151117.chatApplication.application.ChatApplicationController;
import lapr4.red.s1.ipc.n1151117.chatApplication.application.SendMessageController;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Chat;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Barros Edited by David Aguiar <1150630>
 * 
 * edited by Jorge Campos (1150759)
 */
public class ChatApplicationUI extends JPanel implements ActionListener, 
        IObserver, IObserverChatRoomList {

    private ChatApplicationController myController;
    private SendMessageController sendMessageController;
    private EditProfileController editProfileController;
    private JList userJList;
    private JList chatJList;
    private JList chatRoomJList;
    private JButton btnStartChat;
    private JButton btnOpenChat;
    private JButton btnProfile;
    private JButton btnNewChatRoom;
    private JButton btnEnterChatRoom;
    private DefaultListModel usersListModel;
    private DefaultListModel chatsListModel;
    private DefaultListModel chatRoomsListModel;

    public ChatApplicationUI(UIController uiController) {
        super(new BorderLayout());
        setName(ExtensionChatApplication.NAME);

        usersListModel = new DefaultListModel();
        chatsListModel = new DefaultListModel();
        chatRoomsListModel = new DefaultListModel();

        this.myController = new ChatApplicationController();
        this.editProfileController = new EditProfileController();
        this.sendMessageController = new SendMessageController(myController.extensionConnectionManager());
        myController.extensionConnectionManager().registNewObserver(this);
        myController.extensionConnectionManager().registNewChatRoomListObserver(this);
        createComponents();
    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel usersPanel = createUserList();
        JPanel chatPanel = createChatList();
        JPanel chatRoomPanel = createChatRoomList();

        TitledBorder border = BorderFactory.createTitledBorder("Online users");
        border.setTitleJustification(TitledBorder.CENTER);
        usersPanel.setBorder(border);

        border = BorderFactory.createTitledBorder("Active Chats");
        border.setTitleJustification(TitledBorder.CENTER);
        chatPanel.setBorder(border);
        
        border = BorderFactory.createTitledBorder("Public Chat Rooms");
        border.setTitleJustification(TitledBorder.CENTER);
        chatRoomPanel.setBorder(border);

        mainPanel.add(usersPanel);
        mainPanel.add(chatPanel);
        mainPanel.add(chatRoomPanel);

        add(mainPanel);
    }

    private JPanel createUserList() {

        createButtonUserList();
        createButtonProfile();
        this.userJList = new JList(usersListModel);
        userJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateUsersDefaultListModel(usersListModel);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());
        panel.add(userJList, BorderLayout.NORTH);
        buttonPanel.add(btnStartChat, BorderLayout.WEST);
        buttonPanel.add(btnProfile, BorderLayout.EAST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createChatList() {

        createButtonChatList();
        this.chatJList = new JList(chatsListModel);
        chatJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateChatsDefaultListModel(chatsListModel);
        chatJList.setCellRenderer(new ChatRenderer());

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());
        panel.add(chatJList, BorderLayout.NORTH);
        buttonPanel.add(btnOpenChat, BorderLayout.WEST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }
    
    private JPanel createChatRoomList() {
        createButtonChatRoom();
        createButtonEnterChatRoom();
        this.chatRoomJList = new JList(chatRoomsListModel);
        chatRoomJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        updateChatRoomsDefaultListModel(chatRoomsListModel);
        chatRoomJList.setCellRenderer(new ChatRoomRenderer());
        
        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new BorderLayout());
        panel.add(chatRoomJList, BorderLayout.NORTH);
        buttonPanel.add(btnNewChatRoom, BorderLayout.WEST);
        buttonPanel.add(btnEnterChatRoom, BorderLayout.EAST);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }

    private void createButtonUserList() {
        btnStartChat = new JButton("Start chat");

        btnStartChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!userJList.isSelectionEmpty()) {
                    String ip = myController.findIPAddressByProfileName(selectedUserAddress(usersListModel, userJList));
                    NetworkAddress address = myController.findNetworkAddressByIP(ip);
                    Message message = new Message(Utils.ownIpAddress(), address);
                    new ChatSendMessageUI(null, true, message, sendMessageController);
                    findOrCreateChat(message);
                    updateChatsDefaultListModel(chatsListModel);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a person to chat first!", "No user seleced", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

    }

    private void createButtonChatList() {
        btnOpenChat = new JButton("Open chat");

        btnOpenChat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!chatJList.isSelectionEmpty()) {
                    Chat c = (Chat) chatJList.getSelectedValue();
                    new ChatUI(c, sendMessageController);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "No chat room selected!", "Chat Room", 
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private void createButtonProfile() {
        btnProfile = new JButton("Profile");

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new EditProfileUI(editProfileController, myController);
            }
        });
    }
    
    private void createButtonChatRoom() {
        btnNewChatRoom = new JButton("Create chat room");
        
        btnNewChatRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new CreateChatRoomUI(myController);
                updateChatRoomsDefaultListModel(chatRoomsListModel);
            }
        });
    }
    
    private void createButtonEnterChatRoom() {
        btnEnterChatRoom = new JButton("Enter chat room");
        
        btnEnterChatRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!chatRoomJList.isSelectionEmpty()) {
                    Chat chat = (Chat) chatRoomJList.getSelectedValue();
                    chat.addChatUser(Utils.ownIpAddress());
                    new ChatRoomUI(chat, myController);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Please select the chat you want to see first!", 
                            "No chat selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    private Chat createChatWithMessage(Message message) {
        return myController.createChat(message);
    }

    private void updateUsersDefaultListModel(DefaultListModel model) {
        for (UserProfile profile : myController.extensionConnectionManager().getMachineProfiles()) {
            if (!model.contains(profile.getNickname())
                    && (!profile.getAddress().getAddress().equals(Utils.ownIpAddress().getAddress()))) {
                model.addElement(profile.getNickname());
                userJList.setCellRenderer(new userRender());
            }
            int n = myController.extensionConnectionManager().getMachineProfiles().size() - 1;
            if (model.getSize() > n) {
                model.clear();
            }
        }
    }

    private void updateChatsDefaultListModel(DefaultListModel model) {
        model.clear();
        Iterator<Chat> it = myController.allActiveChats().iterator();
        while (it.hasNext()) {
            Chat tmp = it.next();
            if (!model.contains(tmp)) {
                model.addElement(tmp);
            }
        }
    }
    
    private void updateChatRoomsDefaultListModel(DefaultListModel model) {
        model.clear();
        Iterator<Chat> it = myController.allPublicChatRooms().iterator();
        while (it.hasNext()) {
            Chat chat = it.next();
            if (!model.contains(chat))
                model.addElement(chat);
        }
     }

    private String selectedUserAddress(DefaultListModel model, JList list) {
        int idx = list.getSelectedIndex();
        return (String) model.getElementAt(idx);
    }

    @Override
    public void showPopUp(Message message) {
        new PopUpNewMessage(null, true, message, sendMessageController);
        findOrCreateChat(message);
        updateChatsDefaultListModel(chatsListModel);
    }

    @Override
    public void updateUsersList() {
        updateUsersDefaultListModel(usersListModel);
    }

    private void findOrCreateChat(Message message) {
        ArrayList<String> addresses = new ArrayList<>();
        addresses.add(message.messageSender().getAddress());
        addresses.add(message.messageReceiver().getAddress());
        Chat chat = myController.findChatFromIPAddresses(addresses);
        if (chat == null) {
            chat = createChatWithMessage(message);
            myController.addChatToList(chat);
        } else {
            chat.addChatMessage(message);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateChatRoomList(Chat chat) {
        myController.addChatRoomToList(chat);
        updateChatRoomsDefaultListModel(chatRoomsListModel);
    }

    class ChatRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);
            Chat chat = (Chat) value;
            setText(myController.findProfileByIP(chat.otherUserInChat().getAddress().trim()));
            return this;
        }
    }

    class ChatRoomRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value,
                    index, isSelected, cellHasFocus);
            Chat chat = (Chat) value;
            setText(chat.getRoomName());
            return this;
        }
    }

    
    /**
     * Nested class, that does the render of the userList
     */
    class userRender extends DefaultListCellRenderer {

        public userRender() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, UserProfile profile, int index,
                boolean isSelected, boolean cellHasFocus) {

            File folder = new File(profile.getImageDir());
            ImageIcon imageIcon;
            try {
                imageIcon = new ImageIcon(ImageIO.read(folder));
                setIcon(imageIcon);
                setText(profile.getNickname());

            } catch (IOException ex) {
                Logger.getLogger(ChatApplicationUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;

        }

    }

}
