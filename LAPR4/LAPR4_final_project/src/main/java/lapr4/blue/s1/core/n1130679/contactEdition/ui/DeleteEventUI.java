/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import lapr4.blue.s1.core.n1130679.contactEdition.application.AgendaController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 *
 * @author Ana
 */
public class DeleteEventUI extends JDialog {

    private AgendaPanel ep;
    private JTextField descriptions, date;
    private static final int DIALOGO_DESVIO_X = 525, DIALOGO_DESVIO_Y = 200;
    private static final Dimension LABEL_TAMANHO = new JLabel("Description Text:sss").
            getPreferredSize();
    private AgendaController controller;
    private Contact contacto;
    private Event event;

    public DeleteEventUI(AgendaPanel pai, Contact c, Event e,
            AgendaController controller) {

        this.setTitle("Delete Event");
        ep = pai;
        this.controller = controller;
        this.contacto = c;
        this.event = e;
        //this.setLayout(new GridLayout(2, 0));

        JPanel p2 = criaPainelInfo();
        JPanel p4 = criarPainelBotoes();

        add(p2, BorderLayout.NORTH);
        add(p4, BorderLayout.CENTER);

        setLocation(pai.getX() + DIALOGO_DESVIO_X, pai.getY() + DIALOGO_DESVIO_Y);
        pack();
        setResizable(false);
        setVisible(true);
    }

    private JPanel criaPainelInfo() {
        String[] info = new String[6];

        info[0] = "-----------Contact Info-----------";
        
            info[1] = "Name: " + contacto.name();
        
        
        info[3] = "-----------Event Info-----------";
        info[4] = "Description : " + event.description();
        info[5] = "Date : " + event.dueDate().get(Calendar.DAY_OF_MONTH) + "/"
                + event.dueDate().get(Calendar.MONTH)+ "/"
                + event.dueDate().get(Calendar.YEAR);

        JList jl = new JList(info);
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(jl);
        return p;
    }

    private JPanel criarPainelBotoes() {
        JButton btnOK = criarBotaoOK();
        getRootPane().setDefaultButton(btnOK);

        JButton btnCancelar = criarBotaoCancelar();

        JPanel p = new JPanel();
        final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 10;
        final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 10;
        p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
                MARGEM_INFERIOR, MARGEM_DIREITA));
        p.add(btnOK);
        p.add(btnCancelar);

        return p;
    }

    private JButton criarBotaoOK() {
        JButton btn = new JButton("OK");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.deleteEvent(event, contacto);
                    JOptionPane.showMessageDialog(DeleteEventUI.this, "Event successfully deleted");
                    
                    dispose();
                } catch (Exception excecao) {
                    JOptionPane.showMessageDialog(DeleteEventUI.this,
                            "Something wrong, event cannot be deleted: " + excecao.
                                    getMessage(),
                            "Create Event",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        );
        return btn;
    }

    private JButton criarBotaoCancelar() {
        JButton btn = new JButton("Cancel");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        return btn;
    }
}
