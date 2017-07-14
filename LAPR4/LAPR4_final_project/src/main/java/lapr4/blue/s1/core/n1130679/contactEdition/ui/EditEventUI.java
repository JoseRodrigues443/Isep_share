/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
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
public class EditEventUI extends JDialog {

	private AgendaPanel ep;
	private JTextField descriptions, date;
	private static final int DIALOGO_DESVIO_X = 525, DIALOGO_DESVIO_Y = 200;
	private static final Dimension LABEL_TAMANHO = new JLabel("Description Text:sss").
		getPreferredSize();
	private final AgendaController controller;
	private Contact c;
	private Event event;

	public EditEventUI(AgendaPanel pai, Contact c, Event e,
							 AgendaController controller) {

		this.setTitle("Edit Event");
		ep = pai;
		this.controller = controller;
		this.c = c;
		this.event = e;
		this.setLayout(new GridLayout(3, 0));

		JPanel p1 = criarPainelText();
		JPanel p2 = criarPainelDate();
		JPanel p4 = criarPainelBotoes();

		add(p1);
		add(p2);
		add(p4);

		setLocation(pai.getX() + DIALOGO_DESVIO_X, pai.getY() + DIALOGO_DESVIO_Y);
		pack();
		setResizable(false);
		setVisible(true);
	}

	private JPanel criarPainelText() {
		JLabel lbl = new JLabel("Description Text:", JLabel.RIGHT);
		lbl.setPreferredSize(LABEL_TAMANHO);
		final int CAMPO_LARGURA = 15;
		descriptions = new JTextField(CAMPO_LARGURA);
		descriptions.requestFocus();
		descriptions.setText(event.description());
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		final int MARGEM_SUPERIOR = 10, MARGEM_INFERIOR = 0;
		final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
		p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
									MARGEM_INFERIOR, MARGEM_DIREITA));

		p.add(lbl);
		p.add(descriptions);

		return p;
	}

	private JPanel criarPainelDate() {
		JLabel lbl = new JLabel("Date (dd/mm/yyyy):", JLabel.RIGHT);
		lbl.setPreferredSize(LABEL_TAMANHO);
		final int CAMPO_LARGURA = 15;
		date = new JTextField(CAMPO_LARGURA);
		date.setText(event.dueDate().
			get(Calendar.DAY_OF_MONTH) + "/"
			+ event.dueDate().get(Calendar.MONTH)+ "/"
			+ event.dueDate().get(Calendar.YEAR));
		date.requestFocus();
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		final int MARGEM_SUPERIOR = 0, MARGEM_INFERIOR = 0;
		final int MARGEM_ESQUERDA = 10, MARGEM_DIREITA = 0;
		p.setBorder(new EmptyBorder(MARGEM_SUPERIOR, MARGEM_ESQUERDA,
									MARGEM_INFERIOR, MARGEM_DIREITA));
		p.add(lbl);
		p.add(date);

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
					String desc = descriptions.getText();
					if (desc == null) {
						throw new IllegalArgumentException("Error. Empty Description");
					}

					String date_read = date.getText();
					if (date_read == null) {
						throw new IllegalArgumentException("Error. Empty Date");
					}

					if (controller.isDateValid(date.getText()) == null) {
						throw new IllegalArgumentException("Error. Wrong Date Format ");
					}
					controller.changeEvent(descriptions.getText(), date.
										   getText(), event, c);
					JOptionPane.showMessageDialog(EditEventUI.this, "Event successfully edited");
				//	ep.updateEventos();
					dispose();
				} catch (Exception excecao) {
					JOptionPane.showMessageDialog(EditEventUI.this,
												  "Something wrong, event cannot be edited: " + excecao.
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
