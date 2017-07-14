package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import lapr4.green.s1.lang.n1141431.conditional.formatting.ui.UIConditionalFormattingJFrame;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.FormattingCondition;

/**
 * A side bar for the range format extension
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeSideBar extends JPanel {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * Controller for formatting cell ranges
     */
    private ConditionalFormattingRangeController controller;
    /**
     * The list of conditions
     */
    private List<FormattingCondition> conditions;
    /**
     * Combo Box with the operator options
     */
    private JComboBox<String> comboBox;
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
     * JLabel with the format currently in use
     */
    private JLabel formName;

    /**
     * Creates a new ConditionalFormattingRangeSideBar
     *
     * @param uiController the user interface controller
     */
    public ConditionalFormattingRangeSideBar(UIController uiController) {
        super();
        this.uiController = uiController;
        this.controller = new ConditionalFormattingRangeController(uiController);
        conditions = controller.getFormattingConditions();
        setName("Conditional Formatted");
        setLayout(new GridLayout(4, 1));

        JPanel opBtn = opBtnPanel();
        JPanel inUse = inUsePanel();
        JPanel editBtn = editBtnPanel();
        JPanel removeBtn = removeBtnPanel();

        add(opBtn);
        add(inUse);
        add(editBtn);
        add(removeBtn);
    }

    private JPanel opBtnPanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Formatting Options");
        panel.setBorder(title);
        JButton btnCell = new JButton("Cell Format");
        JButton btnRange = new JButton("Range Format");

        btnCell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UIConditionalFormattingJFrame(uiController);
            }

        });

        btnRange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConditionalFormattingRangeUI(uiController, controller, conditions);
            }

        });
        panel.add(btnCell);
        panel.add(btnRange);
        return panel;
    }

    private JPanel editBtnPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        TitledBorder title = BorderFactory.createTitledBorder("Edit Settings");
        panel.setBorder(title);
        JPanel operatorSelection = operatorSelectionPanel();
        JPanel formatEdition = formatEditionPanel();

        panel.add(operatorSelection, BorderLayout.NORTH);
        panel.add(formatEdition, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel operatorSelectionPanel() {
        JPanel panel = new JPanel();
        comboBox = new JComboBox();

        for (int i = 0; i < conditions.size(); i++) {
            comboBox.addItem(conditions.get(i).operatorIdentifier());
        }

        panel.add(comboBox);

        return panel;
    }

    private JPanel formatEditionPanel() {
        JPanel panel = new JPanel();
        JButton btnTrue = new JButton("True Format");
        JButton btnFalse = new JButton("False Format");

        btnTrue.addActionListener(colorChangeAction(true));
        btnFalse.addActionListener(colorChangeAction(false));

        panel.add(btnTrue);
        panel.add(btnFalse);

        return panel;
    }

    private ActionListener colorChangeAction(boolean choice) {
        if (choice) {
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = comboBox.getSelectedIndex();
                    Color color = JColorChooser.showDialog(null, "Change default color", conditions.get(index).trueFormatColor());
                    conditions.get(index).alterTrueFormatColor(color);
                }
            };
        } else {
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int index = comboBox.getSelectedIndex();
                    Color color = JColorChooser.showDialog(null, "Change default color", conditions.get(index).falseFormatColor());
                    conditions.get(index).alterFalseFormatColor(color);
                }
            };
        }
    }

    private JPanel removeBtnPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        TitledBorder title = BorderFactory.createTitledBorder("Remove Formatting");
        panel.setBorder(title);
        JButton btnRemove = new JButton("Remove");

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readyParameters()) {
                    RemoveFormattingAction action = new RemoveFormattingAction(uiController, beginning, end);
                    action.actionPerformed(e);
                    firstCellName.setText("");
                    finalCellName.setText("");
                }
            }

        });
        panel.add(getCellRangePanel());
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnRemove);
        panel.add(btnPanel);
        return panel;
    }

    private JPanel getCellRangePanel() {
        JPanel panel = new JPanel();

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

    private JPanel inUsePanel() {
        JPanel panel = new JPanel();

        JLabel formInUse = new JLabel("Format in Use: ");
        formName = new JLabel("None");

        panel.add(formInUse);
        panel.add(formName);

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
     * Alter's the label indicating the current format
     *
     * @param inUse the format being used
     */
    public void setinUse(String inUse) {
        formName.setText(inUse);
    }

}
