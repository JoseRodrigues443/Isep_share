/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames.ui;

import com.sun.java.accessibility.util.AWTEventMonitor;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import lapr4.red.s1.ipc.n1141114.netGames.ExtensionGameCenter;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.n1141114.netGames.application.GameCenterController;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class NetworkingGamesUI extends JPanel implements ActionListener {

    private GameCenterController myController;
    private JList<UserProfile> userList;
    private JList activeGamesList;
    private JButton btnInviteGame;
    private JButton btnRefreshUsers;
    private JButton btnProfile;
    private JButton btnEndGame;
    private DefaultListModel<UserProfile> usersListModel;
    private DefaultListModel activeGamesListModel;
    private JFrame parentFrame;

    private UIController uiController;

    private UserProfile profile;

    private int numberGames;
    private String imageDir = "";

    public NetworkingGamesUI(UIController uiController) {
        super(new BorderLayout());
        setName(ExtensionGameCenter.NAME);

        this.uiController = uiController;

        numberGames = 0;

        usersListModel = new DefaultListModel<>();
        activeGamesListModel = new DefaultListModel();

        this.myController = new GameCenterController();
        createComponents();
      //  updateProfileList();
    }

    /**
     * Nested class, that does the render of the userList
     */
    class userRender extends JLabel implements ListCellRenderer<UserProfile> {

        public userRender() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends UserProfile> list, UserProfile profile, int index,
                boolean isSelected, boolean cellHasFocus) {

            File folder = new File(profile.getImageDir());
            ImageIcon imageIcon;
            try {
                imageIcon = new ImageIcon(ImageIO.read(folder));
                setIcon(imageIcon);
                setText(profile.getName());

            } catch (IOException ex) {
                Logger.getLogger(NetworkingGamesUI.class.getName()).log(Level.SEVERE, null, ex);
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

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel usersPanel = createUserList();
        JPanel gamesPanel = createActiveGamesList();

        TitledBorder border = BorderFactory.createTitledBorder("Online users");
        border.setTitleJustification(TitledBorder.CENTER);
        usersPanel.setBorder(border);

        border = BorderFactory.createTitledBorder("Active Games");
        border.setTitleJustification(TitledBorder.CENTER);
        gamesPanel.setBorder(border);

        mainPanel.add(usersPanel);
        mainPanel.add(gamesPanel);

        add(mainPanel);
    }

    private JPanel createUserList() {

        createButtonUserList();
        this.userList = new JList(usersListModel);

        JPanel panel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        panel.add(userList, BorderLayout.NORTH);
        buttonPanel.add(btnInviteGame);
        buttonPanel.add(btnProfile);
        buttonPanel.add(btnRefreshUsers);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(new JScrollPane(userList));
        return panel;
    }

    private JPanel createActiveGamesList() {

        activeGamesList = new JList(activeGamesListModel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(activeGamesList, BorderLayout.CENTER);
        panel.add(btnEndGame, BorderLayout.SOUTH);
        panel.add(new JScrollPane(activeGamesList));
        return panel;
    }

    private void createButtonUserList() {
        btnInviteGame = new JButton("Invite");
        btnRefreshUsers = new JButton("Refresh");
        btnProfile = new JButton("Profile");
        btnEndGame = new JButton("End Game");

        btnInviteGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<UserProfile> selectedIndice = userList.getSelectedValuesList();
                if (selectedIndice.size() > 0) {
                    NetworkAddress a = myController.discoverMachineAddress();
                    a.setAddress(selectedIndice.get(0).getAddress().getAddress());
                    UserProfile user = selectedIndice.get(0);
                    int tcpPort = myController.returnMapMembers().findTCPPortByProfile(user);
                    myController.sendInvitation(a, tcpPort, profile);
                    JOptionPane.showMessageDialog(null, "Invitation successfully sent!", "Information Message!", JOptionPane.INFORMATION_MESSAGE);
                    if (myController.usersAnswerInvitation().toLowerCase().equals("yes")) {
                        numberGames++;
//                        uiController.getActiveWorkbook().addSpreadsheet();
//                        try {
//                            uiController.getActiveWorkbook().getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount() - 1).getCell(0, 0).setContent("Welcome to the game!");
//                            uiController.getActiveWorkbook().getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount() - 1).getCell(0, 1).setContent("Playing against user:");
//                            uiController.getActiveWorkbook().getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount() - 1).getCell(1, 1).setContent(a.getAddress());
//                            uiController.getActiveWorkbook().getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount() - 1).setTitle("Sheet" + uiController.getActiveWorkbook().getSpreadsheetCount());
//
//                        } catch (FormulaCompilationException ex) {
//                            Logger.getLogger(NetworkingGamesUI.class.getName()).log(Level.SEVERE, null, ex);
//                        }
                        activeGamesListModel.addElement("GameTest" + numberGames
                                + " - " + myController.returnMapMembers().findAllProfilesByTCP(tcpPort).iterator().next().getName());
                    }
                }
            }
        }
        );

        btnRefreshUsers.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                if (!imageDir.isEmpty()) {
                    usersListModel.removeAllElements();
                    ArrayList<UserProfile> test = myController.showOnlineUsers();

                    for (UserProfile profile : test) {
                 //       if (!profile.getAddress().getAddress().equals(Utils.ownIpAddress().getAddress()) && !profile.getName().equals(System.getProperty("user.name"))) {
                            usersListModel.addElement(profile);
                            userList.setCellRenderer(new userRender());
                   //     }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please define your profile before searching for other users!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        );

        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image Only", ImageIO.getReaderFileSuffixes());
                fileChooser.setFileFilter(imageFilter);
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(fileChooser, "File selected!", "Information message", JOptionPane.INFORMATION_MESSAGE);
                    imageDir = String.valueOf(fileChooser.getSelectedFile());
                    profile = new UserProfile(System.getProperty("user.name"), imageDir, Utils.ownIpAddress());
                    myController.updateProfile(imageDir);
                }
            }
        }
        );

        btnEndGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<String> selectedValue = activeGamesList.getSelectedValuesList();
                if (selectedValue.size() > 0) {
                    String tmp[] = selectedValue.get(0).split("-");
                    char indexSheet = tmp[0].charAt(5);
                    int index = Character.getNumericValue(indexSheet);
                    String userName = tmp[1].substring(1, tmp[1].length());
                    for (UserProfile profile : myController.showOnlineUsers()) {
                        if (profile.getName().equals(userName)) {
                            myController.sendExitStatus(profile.getAddress(), profile.getAddress().getTcpPort(), profile);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Game is over!", "Information", JOptionPane.INFORMATION_MESSAGE);
//                    uiController.getActiveWorkbook().removeSpreadsheet(uiController.getActiveWorkbook().getSpreadsheet(index - 1));
                    activeGamesListModel.removeElement(selectedValue.get(0));
                }
            }
        });
    }

    @Override

    public void actionPerformed(ActionEvent ae) {
    }

    public boolean updateProfileList() {
        /*amount of time to the run method be executed again*/
        int timeInterval = 5 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMachineProfileList();
            }

        }, 0, timeInterval);

        return true;
    }

    /**
     * updates de machine list
     */
    public void updateMachineProfileList() {
        ArrayList<UserProfile> onlineUsers = myController.showOnlineUsers();
        usersListModel.removeAllElements();
        if (onlineUsers != null) {
            for (UserProfile profile : onlineUsers) {
                if (!usersListModel.contains(profile)) {
                    usersListModel.addElement(profile);
                    userList.setCellRenderer(new userRender());
                }
            }
        }
        myController.returnMapMembers().allMapMembers().clear();
    }

}
