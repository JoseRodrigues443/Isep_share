/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Pedro Oliveira 1141431
 *
 */
public class Areas implements Serializable {

    private ArrayList<CellsSelected> list;

    public Areas() {
        this.list = new ArrayList();
    }

    /**
     * @return the list
     */
    public ArrayList<CellsSelected> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<CellsSelected> list) {
        this.list = list;
    }

  
}
