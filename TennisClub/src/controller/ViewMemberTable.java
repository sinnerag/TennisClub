/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.AvailableLists.memberList;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import model.Member;

/**
 *
 * @author Anand
 */
class ViewMemberTable extends JFrame {

    JTable table;
    static ViewMemberTable viewMemberTable;

    public static void call() {
        viewMemberTable = new ViewMemberTable();
        viewMemberTable.setSize(550, 500);
        viewMemberTable.setVisible(true);
    }

    public static void disposeIt() {
        viewMemberTable.dispose();
    }

    public ViewMemberTable() {

        Vector<String> columnNames = new Vector<String>();
        Vector<Vector> data = new Vector<Vector>();

        int columns = memberList.size() + 2;
        System.out.println("Size in viwtab" + memberList.size());

        columnNames.add("Member-Id");
        columnNames.add("Name");
        columnNames.add("Mobile-no");
        columnNames.add("Email-Id");
        columnNames.add("Address");
        if (Login.a != 2) {
            columnNames.add("Action1");
            columnNames.add("Action2");
        }
        for (Member m : memberList) {
            Vector row = new Vector(columns);

            row.add(m.getId());
            row.add(m.getName());
            row.add(m.getMobile());
            row.add(m.getEmail());
            row.add(m.getAddress());
            if (Login.a != 2) {
                row.add("Delete");
                row.add("Edit");
                }
                data.add(row);
            
        }
        table = new JTable(data, columnNames);
        if (Login.a != 2) {
            table.getColumn("Action1").setCellRenderer(new ButtonRenderer1());
            table.getColumn("Action1").setCellEditor(
                    new ButtonEditor1(new JCheckBox(), table, viewMemberTable));
            table.getColumn("Action2").setCellRenderer(new ButtonRenderer1());
            table.getColumn("Action2").setCellEditor(
                    new ButtonEditor1(new JCheckBox(), table, viewMemberTable));
        }
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}

class ButtonRenderer1 extends JButton implements TableCellRenderer {

    public ButtonRenderer1() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor1 extends DefaultCellEditor {

    protected JButton button;

    private String label;
    JTable t1;
    private boolean isPushed;
    int index;
    String name, mobile, email, address;
    ViewMemberTable viewMemberTable;

    public ButtonEditor1(JCheckBox checkBox, JTable t1, ViewMemberTable viewMemberTable) {
        super(checkBox);
        this.viewMemberTable = viewMemberTable;
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
        mobile = (String) t1.getModel().getValueAt(row, 2);
        email = (String) t1.getModel().getValueAt(row, 3);
        address = (String) t1.getModel().getValueAt(row, 4);

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

                Iterator<Member> iter = memberList.iterator();

                while (iter.hasNext()) {
                    Member list = iter.next();
                    if (Integer.parseInt(list.getId()) == index) {
                        System.out.println(Integer.parseInt(list.getId()) == index);

                        System.out.println("name");
                        System.out.println("mobile");
                        System.out.println("email");
                        System.out.println("address");
                        list.setName(name);
                        list.setMobile(mobile);
                        list.setEmail(email);
                        list.setAddress(address);

                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Update recoed success");

            } else if (label.equalsIgnoreCase("Delete")) {

                Iterator<Member> iter = memberList.iterator();

                while (iter.hasNext()) {
                    Member list = iter.next();

                    if (Integer.parseInt(list.getId()) == index) {
                        iter.remove();
                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Delete record success");
                viewMemberTable.disposeIt();
                ViewMemberTable.call();

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
