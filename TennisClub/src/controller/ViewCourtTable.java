/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.AvailableLists.courtList;
import static controller.ViewMemberTable.viewMemberTable;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import model.Court;

/**
 *
 * @author Anand
 */
class ViewCourtTable extends JFrame {

    JTable table;
    static ViewCourtTable viewCourtTable;

    public static void call() {
        viewCourtTable = new ViewCourtTable();
        viewCourtTable.setSize(500, 500);
        viewCourtTable.setVisible(true);
    }

    public static void disposeIt() {
        viewCourtTable.dispose();
    }

    public ViewCourtTable() {
        Vector<String> columnNames = new Vector<String>();
        Vector<Vector> data = new Vector<Vector>();

        int columns = courtList.size() + 2;
        // System.out.println("Size in viwtab" + Court_Details.getCourtList().size());

        columnNames.add("Court-Id");
        columnNames.add("Name");
        columnNames.add("Type");
        columnNames.add("Lights");
        columnNames.add("Surface");
        columnNames.add("Location");
        columnNames.add("Action1");
        columnNames.add("Action2");

        for (Court c : courtList) {
            Vector row = new Vector(columns);

            row.add(c.getCourtId());
            row.add(c.getCourtName());
            row.add(c.getCourtType());
            row.add(c.getCourtLight());
            row.add(c.getCourtSurface());
            row.add(c.getCourtLocation());
            row.add("Delete");
            row.add("Edit");
            data.add(row);
        }

        table = new JTable(data, columnNames);

        table.getColumn("Action1").setCellRenderer(new ButtonRenderer2());
        table.getColumn("Action1").setCellEditor(
                new ButtonEditor2(new JCheckBox(), table, viewCourtTable));
        table.getColumn("Action2").setCellRenderer(new ButtonRenderer2());
        table.getColumn("Action2").setCellEditor(
                new ButtonEditor2(new JCheckBox(), table, viewCourtTable));

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}

class ButtonRenderer2 extends JButton implements TableCellRenderer {

    public ButtonRenderer2() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor2 extends DefaultCellEditor {

    protected JButton button;

    private String label;
    JTable t1;
    private boolean isPushed;
    int index;
    String name, type, lights, surface, location;
    ViewCourtTable viewCourtTable;

    public ButtonEditor2(JCheckBox checkBox, JTable t1, ViewCourtTable viewCourtTable) {
        super(checkBox);
        this.viewCourtTable = viewCourtTable;
        this.t1 = t1;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {

        index = Integer.parseInt((String) t1.getModel().getValueAt(row, 0));
        name = (String) t1.getModel().getValueAt(row, 1);
        type = (String) t1.getModel().getValueAt(row, 2);
        lights = (String) t1.getModel().getValueAt(row, 3);
        surface = (String) t1.getModel().getValueAt(row, 4);
        location = (String) t1.getModel().getValueAt(row, 5);
        // System.out.println("index " + Integer.parseInt(t1.getModel().getValueAt(row, 0).toString()));

        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    // update, delete
    public Object getCellEditorValue() {
        if (isPushed) {

            if (label.equalsIgnoreCase("Edit")) {

                Iterator<Court> iter = courtList.iterator();

                while (iter.hasNext()) {
                    Court list = iter.next();
                    if (Integer.parseInt(list.getCourtId()) == index) {
                        System.out.println(Integer.parseInt(list.getCourtId()) == index);

//                        System.out.println("name");
//                        System.out.println("type");
//                        System.out.println("lights");
//                        System.out.println("surface");
//                        System.out.println("location");
                        list.setCourtName(name);
                        list.setCourtType(type);
                        list.setCourtLight(lights);
                        list.setCourtSurface(surface);
                        list.setCourtSurface(location);

                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Update recored success");

            } else if (label.equalsIgnoreCase("Delete")) {

                Iterator<Court> iter = courtList.iterator();

                while (iter.hasNext()) {
                    Court list = iter.next();

                    if (Integer.parseInt(list.getCourtId()) == index) {
                        iter.remove();
                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Delete record success");
                viewCourtTable.disposeIt();
                ViewCourtTable.call();

            }

        }
        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
