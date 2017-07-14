package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.ConditionalFormattingRangeExtension;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.FormattingCondition;

/**
 * A user interface for formatting cell ranges
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeUI extends JFrame {

    /**
     * Controller for formatting cell ranges
     */
    private ConditionalFormattingRangeController controller;
    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The list of conditions
     */
    private List<FormattingCondition> conditions;
    /**
     * The condition
     */
    private FormattingCondition condition;
    /**
     * Cell on one end of the range
     */
    private Cell beginning;
    /**
     * Cell on the other end of the range
     */
    private Cell end;
    /**
     * JTextField with the information for the first cell
     */
    private JTextField firstCellName;
    /**
     * JTextField with the information for the final cell
     */
    private JTextField finalCellName;
    /**
     * JTextField with the right operand of the condition
     */
    private JTextField value;
    /**
     * The string with the condition
     */
    private String form;
    /**
     * The variable used to represent the "current" cell
     */
    private TemporaryVariable current;

    /**
     * Creates a new ConditionalFormattingRangeUI
     *
     * @param uiController the user interface controller
     * @param controller the use case controller
     * @param conditions the list of conditions
     */
    public ConditionalFormattingRangeUI(UIController uiController, ConditionalFormattingRangeController controller, List<FormattingCondition> conditions) {
        this.uiController = uiController;
        if (controller == null || conditions == null) {
            this.controller = new ConditionalFormattingRangeController(uiController);
            this.conditions = this.controller.getFormattingConditions();
        } else {
            this.controller = controller;
            this.conditions = conditions;
        }
        createCurrentVariable();

        setTitle("Range Format");

        setPreferredSize(new Dimension(300, 300));
        setLayout(new GridLayout(3, 1));

        JPanel cellRange = cellRangePanel();
        JPanel formula = formulaPanel();
        JPanel applyBtn = applyBtnPanel();

        add(cellRange);
        add(formula);
        add(applyBtn);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        inUse("Range Formatting");
    }

    private JPanel cellRangePanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Cell Range");
        panel.setBorder(title);

        JLabel beginLabel = new JLabel("First Cell:");
        JLabel endLabel = new JLabel("Last Cell:");
        firstCellName = new JTextField(5);
        firstCellName.setToolTipText("Insert row-column of the cell");
        finalCellName = new JTextField(5);
        finalCellName.setToolTipText("Insert row-column of the cell");

        panel.add(beginLabel);
        panel.add(firstCellName);
        panel.add(endLabel);
        panel.add(finalCellName);

        return panel;
    }

    private JPanel formulaPanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Formula");
        panel.setBorder(title);

        value = new JTextField(15);
        value.setText("=_cell");

        panel.add(value);

        return panel;
    }

    private JPanel applyBtnPanel() {
        JPanel panel = new JPanel();
        JButton btnApply = new JButton("Apply");

        btnApply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readyParameters()) {
                    try {
                        controller.formatRange(beginning, end, condition, form);
                    } catch (IllegalValueTypeException ex) {
                        Logger.getLogger(ConditionalFormattingRangeUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(ConditionalFormattingRangeUI.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        inUse("None");
                    }
                    dispose();
                }
            }

        });
        panel.add(btnApply);
        return panel;
    }

    private boolean readyParameters() {
        try {
            String firstCell = firstCellName.getText();
            String finalCell = finalCellName.getText();

            beginning = getCellFromRange(firstCell);

            end = getCellFromRange(finalCell);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Indicate cell range", "No cell range given",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }

        try {

            String[] split = value.getText().split("=_cell");
            if (split[0].equals("")) {
                form = split[1];
            } else {
                form = split[0];
            }
            String[] op = form.split("[0-9]+");
            for (FormattingCondition cond : conditions) {
                if (op[0].trim().equals(cond.operatorIdentifier())) {
                    condition = cond;
                }
            }

        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Indicate formula", "No formula",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private Cell getCellFromRange(String range) {
        char inicio = 'A';
        char temp;
        int column = 0;
        int row = 0;

        String[] split = range.split("");
        row = Integer.parseInt(split[split.length - 1]) - 1;
        for (int i = 0; i < split.length - 1; i++) {
            temp = split[i].charAt(0);
            column += temp - inicio;
        }
        if (split.length > 2) {
            column += (26 * ((split[0].charAt(0) - inicio) + 1));
        }

        return uiController.getActiveSpreadsheet().getCell(column, row);
    }

    /**
     * Alter's the side bar in order to indicate that the current format is the
     * range format
     *
     * @param inUse the format being used
     */
    public void inUse(String inUse) {
        for (UIExtension ext : uiController.getExtensions()) {
            if (ext.getExtension() instanceof ConditionalFormattingRangeExtension) {
                ConditionalFormattingRangeExtension extension = (ConditionalFormattingRangeExtension) ext.
                        getExtension();

                extension.inUse(inUse);

            }
        }
    }

    /**
     * Creates, if needed, the variable that will represent the current cell
     */
    private void createCurrentVariable() {
        Set<TemporaryVariable> currentVariables = this.uiController.getActiveWorkbook().findTemporaryVariable().currentVariables();

        for (TemporaryVariable var : currentVariables) {
            if (var.currentVariableName().equals("_cell")) {
                return;
            }
        }

        this.current = new TemporaryVariable(this.uiController.getActiveSpreadsheet(), null, "_cell", null);
        this.uiController.getActiveWorkbook().findTemporaryVariable().currentVariables().add(current);
    }

}
