/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink;

import csheets.core.Cell;
import csheets.core.CellListener;
import static java.lang.Thread.sleep;
import lapr4.blue.s2.ipc.n1130679.ImportExportLink.FileLink;

/**
 *
 * @author Ana
 */
public class ExportThread implements Runnable {

    private int flag;
    private int interrupt = 0;
    private FileLink fileLink = new FileLink();
    private final CellChangeListenerExport cellChange = new CellChangeListenerExport();

    /**
     *
     * Defines the linked file to the thread
     *
     */
    public ExportThread(FileLink fileLink) {
        this.fileLink = fileLink;
        this.fileLink.getSheet().addCellListener(cellChange);
    }

    /**
     * run method of the thread
     *
     */
    @Override
    public void run() {
        flag = 1;
        for (;;) {
            if (interrupt == 1) {
                Thread.currentThread().interrupt();
                break;
            }
            ExportTxtLink expTxt = new ExportTxtLink();
            expTxt.
                    exportTxt(fileLink.getSheet(), fileLink.getFile(),
                            fileLink.getHeaderOption(), fileLink.
                            getSeparator(), fileLink.getHeader());
            flag = 0;
            while (flag == 0) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    End();
                }
            }
        }
    }

    /**
     * Alerts if any change is made in the sheet
     *
     */
    private class CellChangeListenerExport implements CellListener {

        public CellChangeListenerExport() {
        }

        @Override
        public void valueChanged(Cell cell) {
            flag = 1;
        }

        @Override
        public void contentChanged(Cell cell) {
            flag = 1;
        }

        @Override
        public void dependentsChanged(Cell cell) {
        }

        @Override
        public void cellCleared(Cell cell) {
        }

        @Override
        public void cellCopied(Cell cell, Cell source) {
        }
    }

    private void End() {
        interrupt = 1;
    }
}
