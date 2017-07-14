/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow.ui;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import lapr4.blue.s1.core.n1150630.insertImage.CellImage;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import lapr4.green.s2.core.n1150835.overlayImageWindow.application.ImageBrowserController;

/**
 *
 * @author Rui Braga
 * @author 1150834(alterations)
 */
public class ImageBrowserUI extends JFrame {

    private final ImageBrowserController controller;
    private final HashMap<String, ImageIcon> imagesMap; // map that relates the name of the image to the image
    private final InsertImageCell cell;
    private static boolean isVisible = false;
    private static ImageBrowserUI currentUI;

    /**
     * Creates new form ImageBrowserUI
     *
     * @param cell
     */
    public ImageBrowserUI(InsertImageCell cell) {
        initComponents();
        currentUI = this;
        this.cell = cell;
        this.setLocation(MouseInfo.getPointerInfo().getLocation());
        this.setTitle("Images of Cell " + cell.getAddress().toString());
        isVisible = true;
        this.controller = new ImageBrowserController(cell);
        this.imagesMap = new HashMap<>();
        imageList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    refreshActiveImage();
                }
            }
        });
        refreshListOfImages();
        refreshActiveImage();
        currentUI.setAlwaysOnTop(true);    //sets this window to always be above other windows.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        imageList.requestFocus();
    }

    /**
     * This method refreshes the list of images
     */
    public void refreshListOfImages() {
        imageList.removeAllItems();
        this.imagesMap.clear();
        for (CellImage image : controller.getImageList()) {
            String path = image.getImagePath();
            File file = new File(path);
            this.imagesMap.put(path, rescaleImage(file));
            this.imageList.addItem(path);
        }
    }

    /**
     * This method refreshes the active image that appears.
     */
    private void refreshActiveImage() {
        this.activeImage.setIcon(imagesMap.get(imageList.getSelectedItem()));
    }

    /**
     * This method returns true if the window is currently visible and false if
     * not
     *
     * @return true if visible, false if not
     */
    public static boolean visible() {
        return isVisible;
    }

    /**
     * This method returns the current UI
     *
     * @return the current UI
     */
    public static ImageBrowserUI getCurrentUI() {
        return currentUI;
    }

    /**
     * This method instanciates a new ImageBrowserUIdd in the selected cell with
     * images
     *
     * @return new ImageBrowserUi in the selected cell with images
     */
    public static ImageBrowserUI instance(InsertImageCell cell) {
        return new ImageBrowserUI(cell);
    }

    /**
     * This method rescales the image the user selected so it can fit the window
     *
     * @param file image chosen by the user
     * @return the rescaled image
     */
    private ImageIcon rescaleImage(File file) {
        if (!file.exists()) {
            activeImage.setText("Invalid image: " + file.getAbsolutePath());
            return new ImageIcon();
        }

        BufferedImage img = null;
        try {
            img = ImageIO.read(file);
        } catch (IOException ex) {
            activeImage.setText("Error: " + ex.toString());
            System.out.println(ex.getMessage());
        }
        Image image = img;
        int width = activeImage.getWidth(), height = activeImage.getHeight();
        float ratio = width / height;
        try {
            image = image.getScaledInstance(width, (int) (height * ratio), java.awt.Image.SCALE_SMOOTH);
        } catch (Exception ex) { // if there is a problem with the scale duo to the ratio
            image = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        }
        return new ImageIcon(image);
    }

    /**
     * This method closes the UI
     */
    public void close() {
        isVisible = false;
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the
     * form.list WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        activeImage = new javax.swing.JLabel();
        imageList = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Image Browser");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        activeImage.setBackground(new java.awt.Color(0, 0, 0));
        activeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activeImage.setInheritsPopupMenu(false);
        activeImage.setMaximumSize(new java.awt.Dimension(320, 240));
        activeImage.setMinimumSize(new java.awt.Dimension(320, 240));
        activeImage.setPreferredSize(new java.awt.Dimension(230, 180));

        imageList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        imageList.setNextFocusableComponent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(activeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageList, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(imageList, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(activeImage, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        //closeUI();
    }//GEN-LAST:event_formMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.isVisible = false;
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activeImage;
    private javax.swing.JComboBox<String> imageList;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
