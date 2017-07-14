/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileSharingUI;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.application.FileTransferController;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.ui.DownloadProgressUI;
import lapr4.red.s1.ipc.n1140412.fileShareApplication.FileShareController;
import lapr4.red.s1.ipc.n1140412.fileSharing.ExtensionFileShare;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author Tiago
 * @author Filipe Correia <1150524@isep.ipp.pt> (File download)
 */
public class FileShareUI extends JPanel {

    private FileShareController myController;
    private FileTransferController otherCtrl;
    private JList shareFileList;
    private JList downloadList;
    private DefaultListModel shareFileListModel;
    private DefaultListModel downloadFileListModel;
    private JButton btnSetShareDirectory;
    private JButton btnSetDownloadDirectory;
    private JButton btnDownload;
    private String shareDirectoryPath;
    private String downloadDirectoryPath;
    private JScrollPane shareFileScrollPane;
    private JScrollPane downloadFileScrollPane;
    private DownloadProgressUI downloadStatus;

    public FileShareUI(UIController uiController) {
        super(new BorderLayout());
        setName(ExtensionFileShare.NAME);

        this.myController = new FileShareController();
        this.otherCtrl = new FileTransferController(myController);
        createComponents();
        updateDownloadListTimed();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel filesToShare = createFileShareList();
        JPanel filesToDownload = createFileDownloadList();

        TitledBorder border = BorderFactory.createTitledBorder("Files to share");
        border.setTitleJustification(TitledBorder.CENTER);
        filesToShare.setBorder(border);

        border = BorderFactory.createTitledBorder("Files to download");
        border.setTitleJustification(TitledBorder.CENTER);
        filesToDownload.setBorder(border);

        mainPanel.add(filesToShare);
        mainPanel.add(filesToDownload);

        add(mainPanel);

    }

    /**
     * List with files to share Has test data
     *
     * @return
     */
    private JPanel createFileShareList() {

        JPanel panel = new JPanel(new BorderLayout());
        createButtonShareDirectory(panel);

        panel.add(btnSetShareDirectory, BorderLayout.NORTH);
        return panel;
    }

    /**
     * List with files to download Has test data
     *
     * @return
     */
    private JPanel createFileDownloadList() {
        JPanel panel = new JPanel(new BorderLayout());

        createButtonChangeDownloadDirectory();
        createButtonDownload();
        downloadFileListModel = new DefaultListModel();
        downloadList = new JList(downloadFileListModel);
        //downloadFileListModel.addElement("banan");
        this.downloadFileScrollPane = new JScrollPane(downloadList);

        panel.add(btnSetDownloadDirectory, BorderLayout.NORTH);
        panel.add(downloadList, BorderLayout.CENTER);
        panel.add(btnDownload, BorderLayout.SOUTH);
        return panel;
    }

    /**
     * Pressing button
     */
    private void createButtonShareDirectory(JPanel panel) {
        btnSetShareDirectory = new JButton("Select Directory to Share.");

        btnSetShareDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.showOpenDialog(null);
                try {

                    shareDirectoryPath = chooser.getSelectedFile().getPath();
                    myController.setShareDirectoryPath(shareDirectoryPath);
                    otherCtrl.setShareFolder();

                    ArrayList<String> fileInfo = myController.fileNamesSizeList(shareDirectoryPath);

                    shareFileList = new JList(fileInfo.toArray());
                    panel.add(shareFileList, BorderLayout.CENTER);
                } catch (NullPointerException ex) {

                }
            }
        });
    }

    /**
     * Pressing button changes the download directory
     */
    private void createButtonChangeDownloadDirectory() {
        btnSetDownloadDirectory = new JButton("Change Download Directory.");
        if (!myController.currentSaveDownloadPath().isEmpty()) {
            btnSetDownloadDirectory.setToolTipText(myController.currentSaveDownloadPath());
        }
        btnSetDownloadDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);
                chooser.showOpenDialog(null);

                try {
                    downloadDirectoryPath = chooser.getSelectedFile().getPath();
                    myController.saveDownloadPath(downloadDirectoryPath);
                    otherCtrl.setDownloadFolder(downloadDirectoryPath);
                    btnSetDownloadDirectory.setToolTipText(myController.currentSaveDownloadPath());
                } catch (NullPointerException ex) {

                }

            }
        });
    }

    private void createButtonDownload() {
        btnDownload = new JButton("Download");

        btnDownload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String fileName = (String) downloadList.getSelectedValue();

                if (fileName == null) {
                    JOptionPane.showMessageDialog(null, "No File Selected, please select a file from the list!",
                            "Warning", JOptionPane.OK_OPTION);
                } else {
                    int reply = JOptionPane.showConfirmDialog(null, "Do you want this download to be permanent?",
                            "Question", JOptionPane.YES_NO_OPTION);
                    downloadStatus = new DownloadProgressUI(fileName, (reply == JOptionPane.YES_OPTION), myController, otherCtrl);
                    if (downloadStatus.getIpList().size() > 1) {
                        //Select an ip UI
                    } else {
                        NetworkAddress[] a = new NetworkAddress[1];
                        downloadStatus.getIpList().toArray(a);
                        downloadStatus.setAddress(a[0]);
                    }
                    downloadStatus.setVisible(true);
                    downloadStatus.download();

                }
            }
        }
        );
    }

    public boolean updateDownloadListTimed() {
        /*amount of time to the run method be executed again*/
        int timeInterval = 5 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateDownloadList();
            }

        }, 0, timeInterval);

        return true;
    }

    public void updateDownloadList() {
        //fill with received filename,size,source,download status (ENUM in file share package)
        ArrayList<String> downloadFileList = myController.getConnectionManager().filesListToDownloadWithData();
        this.downloadFileListModel.removeAllElements();
        if (downloadFileList != null) {
            for (String s : downloadFileList) {
                if (!downloadFileListModel.contains(s)) {
                    this.downloadFileListModel.addElement(s);
                }
            }
        }
    }
}
