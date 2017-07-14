/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.ui;

import com.sun.java.accessibility.util.AWTEventMonitor;
import csheets.core.Cell;
import csheets.core.CellListener;
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
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.GameCenterController;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.ShareAutoController;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.Game;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.IObserver;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.TicTacToe;
import lapr4.blue.s2.ipc.n1150662.sharedCells.DTOCell;
import lapr4.blue.s2.ipc.n1150662.sharedCells.ui.SharePanelAuto;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class NetworkingGamesTUI extends JPanel implements ActionListener, IObserver {

    /**
     * @return the myController
     */
    public GameCenterController getMyController() {
        return myController;
    }

    /**
     * @param myController the myController to set
     */
    public void setMyController(GameCenterController myController) {
        this.myController = myController;
    }

    /**
     * @return the profile
     */
    public UserProfile getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

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
    private String gameName;
    private UIController uiController;
    private Game game;
    private UserProfile profile;
    private ShareAutoController controller;
    private int numberGames;
    private String imageDir = "";
    private NetworkAddress a;
    private int tcpPort;
    Cell[] cellIntervall = new Cell[2];

    public NetworkingGamesTUI(UIController uiController) {
        super(new BorderLayout());
        setName(ExtensionGameCenter.NAME);

        this.uiController = uiController;

        numberGames = 0;

        usersListModel = new DefaultListModel<>();
        activeGamesListModel = new DefaultListModel();

        this.myController = new GameCenterController(uiController);
        this.controller= new ShareAutoController(uiController, null,myController.getConnectionManager());
        myController.getConnectionManager().registNewObserver(this);
       // myController.setUictrl(uiController);
        createComponents();
      //  updateProfileList();
    }

    @Override
    public void createSpreadsheet() {
        uiController.getActiveWorkbook().addSpreadsheet();
        GameCenterController g= GameCenterController.getInstance();
        g.StartNewGame("Tic Tac Toe", Utils.ownIpAddress().getAddress(), true, "notMe");
    }

    @Override
    public void changePort() {
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
                Logger.getLogger(NetworkingGamesTUI.class.getName()).log(Level.SEVERE, null, ex);
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
                    int answer;    
                    JOptionPane.showMessageDialog(null,"You sent an invitation of tic tac toe");
                    game= new TicTacToe("X"); 
                    a = getMyController().discoverMachineAddress();
                    a.setAddress(selectedIndice.get(0).getAddress().getAddress());
                    UserProfile user = selectedIndice.get(0);
                    tcpPort = getMyController().returnMapMembers().findTCPPortByProfile(user);
                    getMyController().sendInvitation(a, tcpPort, getProfile(), game);
                    JOptionPane.showMessageDialog(null, "Invitation successfully sent!", "Information Message!", JOptionPane.INFORMATION_MESSAGE);
                    if (getMyController().usersAnswerInvitation().toLowerCase().equals("yes")) {
                        JOptionPane.showMessageDialog(null, "Player Acepted your Invitation. Your game will start.");
                        numberGames++;
                        gameName=game.getGameName();
                        uiController.getActiveWorkbook().addSpreadsheet();
//                        controller.start();
                        DTOCell cdto;

                        Cell c = uiController.getActiveWorkbook()
                                .getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount()-1).getCell(0, 0);
                        
                        
                        cellIntervall[0]= c;
                        cdto = DTOCell.createFromCell(cellIntervall[0]);
                        
                        c= uiController.getActiveWorkbook()                            
                                .getSpreadsheet(uiController.getActiveWorkbook().getSpreadsheetCount()-1).getCell(2, 2);

                        cdto = DTOCell.createFromCell(cellIntervall[0]);
                        
                        cellIntervall[1]= c;
                        
                        addCellListener();                        
                        cdto = DTOCell.createFromCell(cellIntervall[1]);

                        controller.sendTcpCells(controller.selectedCells(
                                    controller.getCells(cellIntervall[0].getAddress(),
                                            cellIntervall[1].getAddress())),
                                    tcpPort, a);
                        
                        GameCenterController g= GameCenterController.getInstance();
                        String m= "me";
                        g.StartNewGame("Tic Tac Toe", Utils.ownIpAddress().getAddress(), true, m);                        //adiciona uma spreadsheet no que convida
                        //codigo adicionado
                  
                    
                    
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
                            userList.setCellRenderer(new NetworkingGamesTUI.userRender());
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
                    userList.setCellRenderer(new NetworkingGamesTUI.userRender());
                }
            }
        }
        myController.returnMapMembers().allMapMembers().clear();
    }

        public void addCellListener() {
        int value = uiController.getActiveWorkbook().getSpreadsheetCount();
        uiController.getActiveWorkbook().getSpreadsheet(value-1).addCellListener(new ChangeCellListener());

    }
            public class ChangeCellListener implements CellListener {

        @Override
        public void valueChanged(Cell cell) {

            controller.sendTcpCells(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, a);

        }

        @Override
        public void contentChanged(Cell cell) {
            controller.sendTcpCells(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, a);

        }

        @Override
        public void dependentsChanged(Cell cell) {
            controller.sendTcpCells(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, a);

        }

        @Override
        public void cellCleared(Cell cell) {
            controller.sendTcpCells(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, a);

        }

        @Override
        public void cellCopied(Cell cell, Cell source) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
     }
   
}
