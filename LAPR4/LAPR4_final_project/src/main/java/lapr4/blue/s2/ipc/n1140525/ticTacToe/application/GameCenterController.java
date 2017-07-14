/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import csheets.core.Spreadsheet;
import csheets.ext.style.StylableCell;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.Game;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.TicTacToe;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.ui.TicTacToeUI;
import lapr4.red.s1.ipc.n1141114.netGames.ExtensionConnectionManagerGameCenter;
import lapr4.red.s1.ipc.n1141114.netGames.NetworkMachinesListProfiles;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.red.s1.ipc.network.library.*;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.GamesList;

/**
 *
 * @author MariaJoão
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class GameCenterController extends Observable implements Serializable {

    private NetworkMachinesListProfiles userProfileList;

    private ExtensionConnectionManagerGameCenter connectionManager;

    private static GameCenterController instance = null;

    public static boolean isup;

    private UIController uictrl;

    private GamesList gamesBeeingPlayed;

    public GameCenterController(UIController controllerUI) {
        this.userProfileList = new NetworkMachinesListProfiles(NetworkExtensionEnum.GAME_CENTER);
        this.isup = false;
        this.uictrl = controllerUI;
        this.connectionManager = new ExtensionConnectionManagerGameCenter(uictrl);
        this.gamesBeeingPlayed = new GamesList();
        instance = this;
    }

    public GameCenterController() {
        this.userProfileList = new NetworkMachinesListProfiles(NetworkExtensionEnum.GAME_CENTER);
        this.connectionManager = new ExtensionConnectionManagerGameCenter(uictrl);
        this.isup = false;
        this.gamesBeeingPlayed = new GamesList();
        instance = this;
    }

    public boolean updateProfile(String imageDir) {
        this.connectionManager.defineProfileActive("Active", imageDir);
        return true;
    }

    public ArrayList<UserProfile> showOnlineUsers() {
        return this.connectionManager.getMachineProfiles();
    }

    public NetworkAddress discoverMachineAddress() {
        return connectionManager.discoverMachineAddress();
    }

    public NetworkMachinesListProfiles returnMapMembers() {
        return connectionManager.returnMapProfileMembers();
    }

    public void sendInvitation(NetworkAddress address, int tcpPort, UserProfile profile, Game game) {
        String sendMessage = "@GameCenter@TCP@" + Utils.ownIpAddress().getAddress() + "@" + tcpPort + "@InviteToGame@" + profile.getName() + "@Game@" + game.getGameName() + "@";

        this.connectionManager.sendTcp(sendMessage, tcpPort, address);
    }

    public String usersAnswerInvitation() {
        return this.connectionManager.userAnswer();
    }

    public void sendExitStatus(NetworkAddress address, int tcpPort, UserProfile profile) {
        String sendMessage = "@GameCenter@TCP@" + Utils.ownIpAddress().getAddress() + "@" + tcpPort + "@ExitStatus@" + profile.getName() + "@";

        this.connectionManager.sendTcp(sendMessage, tcpPort, address);
    }

    public ExtensionConnectionManagerGameCenter extension() {
        return this.getConnectionManager();
    }

    public void StartNewGame(String invitedGame, String senderIp, boolean isInvited, String m) {
        if (invitedGame.equals("Tic Tac Toe")) {
            if(!m.equals("me")){
           uictrl.getActiveWorkbook().addSpreadsheet();
            } 
           //new TicTacToeUI(getUictrl(), senderIp, isInvited);
        }
    }

    /**
     * @return the uictrl
     */
    public UIController getUictrl() {
        return uictrl;
    }

    /**
     * @param uictrl the uictrl to set
     */
    public void setUictrl(UIController uictrl) {
        this.uictrl = uictrl;
    }

    public static void setIsUpdate(boolean b) {
        GameCenterController.isup = b;
    }

    public static boolean isUpdate() {
        return isup;
    }

    /**
     * @return the gamesBeeingPlayed
     */
    public GamesList getGamesBeeingPlayed() {
        return gamesBeeingPlayed;
    }

    /**
     * @param gamesBeeingPlayed the gamesBeeingPlayed to set
     */
    public void setGamesBeeingPlayed(GamesList gamesBeeingPlayed) {
        this.gamesBeeingPlayed = gamesBeeingPlayed;
    }

    /**
     * @return the instance
     */
    public static GameCenterController getInstance() {
        if (instance == null) {
            instance = new GameCenterController();
        }
        return instance;
    }

    /**
     * @param aInstance the instance to set
     */
    public static void setInstance(GameCenterController aInstance) {
        instance = aInstance;
    }

    public void receivePlay(String[][] board, String ip) {
        this.getGamesBeeingPlayed().receivePlay(board, ip);
    }

    public Game getGameByIP(String ip) {
        return getGamesBeeingPlayed().getGame(ip);
    }

    /**
     * Send play to other user by ip.
     *
     * @param ip string ip
     * @param ctr controller
     * @param address adress
     */
    public void sendPlay(String ip, TicTacToeController ctr) {
        if (isInGame(ip)) {
            SendPlayTCP send = new SendPlayTCP(ctr.getGame().getBoardSize(), ip);
            getConnectionManager().sendTcp(send, Integer.parseInt(ip), getConnectionManager().getComputerNetworkAddress());
        }
    }

    /**
     * Check if user is in game by IP.
     *
     * @param IP String
     * @return String
     */
    public boolean isInGame(String IP) {
        return this.getGamesBeeingPlayed().isOpenGame(IP);
    }

    /**
     * @return the connectionManager
     */
    public ExtensionConnectionManagerGameCenter getConnectionManager() {
        return connectionManager;
    }

    public void endGame(String senderIp) {
        this.getGamesBeeingPlayed().endGame(senderIp, this.getUictrl());
    }

//            NetworkThreadController nTCtrl = NetworkThreadController.getInstance();
//            if (nTCtrl.running()) {
//                NetworkThreadController.getInstance().sendTcpRequest(wr, ip);
//                return true;
//            } else {
//                this.needsNetworkAtcive();
//                return false;
//            }
//        }
}
