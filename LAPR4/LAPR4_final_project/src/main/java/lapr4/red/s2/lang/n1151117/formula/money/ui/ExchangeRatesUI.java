/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import lapr4.red.s2.lang.n1151117.formula.money.ExchangeRatesController;
import lapr4.red.s2.lang.n1151117.formula.money.ExtensionExchangeRates;

/**
 *
 * @author Barros
 */
public class ExchangeRatesUI extends JPanel implements ActionListener {

    private ExchangeRatesController myController;
    private JButton btnSaveExchangeRates;
    private JTextField euroDollar;
    private JTextField euroPound;
    private JTextField dollarPound;
    private JTextField dollarEuro;
    private JTextField poundEuro;
    private JTextField poundDollar;
    private final Dimension textFieldDimension;

    private static final String EURO = "Euro";
    private static final String DOLLAR = "Dollar";
    private static final String POUND = "Pound";

    public ExchangeRatesUI(UIController uiController) {
        super(new BorderLayout());
        setName(ExtensionExchangeRates.NAME);
        this.myController = new ExchangeRatesController();
        this.textFieldDimension = new Dimension(70, 27);

        createComponents();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(4, 1, 1, 7));
        JPanel exchangeMainPanel = createSaveButtonPanel();

        TitledBorder border = BorderFactory.createTitledBorder("Exchange Rates");
        border.setTitleJustification(TitledBorder.CENTER);
        mainPanel.setBorder(border);

        mainPanel.add(createEuroPanel());
        mainPanel.add(createDollarPanel());
        mainPanel.add(createPoundPanel());

        mainPanel.add(exchangeMainPanel);

        add(mainPanel);
    }

    private JPanel createEuroPanel() {
        JPanel euroPanel = new JPanel(new GridLayout(3, 1, 1, 2));
        JLabel lblCur = new JLabel("Euro Currency");
        euroDollar = new JTextField();
        euroDollar.setText(String.valueOf(myController.euroDollarRate()));
        euroDollar.setPreferredSize(textFieldDimension);
        euroPound = new JTextField();
        euroPound.setPreferredSize(textFieldDimension);
        euroPound.setText(String.valueOf(myController.euroPoundRate()));
        JPanel panelLblCur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelLblCur.add(lblCur);
        JPanel panelEuroDollar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dollarLbl = new JLabel(DOLLAR);
        JLabel poundLbl = new JLabel(POUND);
        panelEuroDollar.add(dollarLbl);
        panelEuroDollar.add(euroDollar);
        JPanel panelEuroPound = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelEuroPound.add(poundLbl);
        panelEuroPound.add(euroPound);
        euroPanel.add(panelLblCur);
        euroPanel.add(panelEuroDollar);
        euroPanel.add(panelEuroPound);

        return euroPanel;
    }

    private JPanel createDollarPanel() {
        JPanel dollarPanel = new JPanel(new GridLayout(3, 1, 1, 2));
        JLabel lblCur = new JLabel("Dollar Currency");
        dollarEuro = new JTextField();
        dollarEuro.setText(String.valueOf(myController.dollarEuroRate()));
        dollarEuro.setPreferredSize(textFieldDimension);
        dollarPound = new JTextField();
        dollarPound.setPreferredSize(textFieldDimension);
        dollarPound.setText(String.valueOf(myController.dollarPoundRate()));
        JPanel panelLblCur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelLblCur.add(lblCur);
        JPanel panelDollarEuro = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel euroLbl = new JLabel(EURO);
        JLabel poundLbl = new JLabel(POUND);
        panelDollarEuro.add(euroLbl);
        panelDollarEuro.add(dollarEuro);
        JPanel panelDollarPound = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelDollarPound.add(poundLbl);
        panelDollarPound.add(dollarPound);
        dollarPanel.add(panelLblCur);
        dollarPanel.add(panelDollarEuro);
        dollarPanel.add(panelDollarPound);

        return dollarPanel;
    }

    private JPanel createPoundPanel() {
        JPanel poundPanel = new JPanel(new GridLayout(3, 1, 1, 2));
        JLabel lblCur = new JLabel("Pound Currency");
        poundEuro = new JTextField();
        poundEuro.setText(String.valueOf(myController.poundEuroRate()));
        poundEuro.setPreferredSize(textFieldDimension);
        poundDollar = new JTextField();
        poundDollar.setPreferredSize(textFieldDimension);
        poundDollar.setText(String.valueOf(myController.poundDollarRate()));
        JPanel panelLblCur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelLblCur.add(lblCur);
        JPanel panelPoundEuro = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel dollarLbl = new JLabel(DOLLAR);
        JLabel euroLbl = new JLabel(EURO);
        panelPoundEuro.add(euroLbl);
        panelPoundEuro.add(poundEuro);
        JPanel panelPoundDollar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelPoundDollar.add(dollarLbl);
        panelPoundDollar.add(poundDollar);
        poundPanel.add(panelLblCur);
        poundPanel.add(panelPoundEuro);
        poundPanel.add(panelPoundDollar);

        return poundPanel;
    }

    private JPanel createSaveButtonPanel() {
        JPanel btnPanel = new JPanel(new GridLayout(1, 1, 1, 6));
        createButtonSaveExchangeRates();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnSaveExchangeRates);
        btnPanel.add(buttonPanel);
        return btnPanel;
    }

    private void createButtonSaveExchangeRates() {
        btnSaveExchangeRates = new JButton("Save");

        btnSaveExchangeRates.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double tmp;
                    tmp = Double.parseDouble(euroDollar.getText());
                    myController.changeEuroDollarRate(tmp);
                    tmp = Double.parseDouble(euroPound.getText());
                    myController.changeEuroPoundRate(tmp);
                    tmp = Double.parseDouble(dollarEuro.getText());
                    myController.changeDollarEuroRate(tmp);
                    tmp = Double.parseDouble(dollarPound.getText());
                    myController.changeDollarPoundRate(tmp);
                    tmp = Double.parseDouble(poundEuro.getText());
                    myController.changePoundEuroRate(tmp);
                    tmp = Double.parseDouble(poundDollar.getText());
                    myController.changePoundDollarRate(tmp);
                    JOptionPane.showMessageDialog(null, "All exchange rates have ben updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error setting exchange rate", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please insert only numbers", "Error setting exchange rate", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //does nothing
    }

}
