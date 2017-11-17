package controller;

/**
 *
 * @author Anand
 */
import static controller.AvailableLists.reservationList;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import model.Reservation;

class ViewTable extends JFrame {

    static ViewTable viewTable;

    public static void call() {
        viewTable = new ViewTable();
        viewTable.setSize(500, 500);
        viewTable.setVisible(true);
    }

    public static void desposeIt() {
        viewTable.dispose();
    }

    public ViewTable() {
        Vector<String> columnNames = new Vector<String>();
        Vector<Vector> data = new Vector<Vector>();

        int columns = reservationList.size() + 2;
        System.out.println("Size in viwtab" + reservationList.size());

        columnNames.add("Reservation-Id");
        columnNames.add("Court-Id");
        columnNames.add("Time");
        columnNames.add("Date");
        columnNames.add("Member-Id");
        if (Login.a != 2) {
            columnNames.add("Action1");
            columnNames.add("Action2");
        }

        for (Reservation r : reservationList) {
            Vector row = new Vector(columns);

            row.add(r.getReservationId());
            row.add(r.getReservationCourtId());
            row.add(r.getReservationTime());
            row.add(r.getReservationDate());
            row.add(r.getReservationMemberId());
            if (Login.a != 2) {
                row.add("Delete");
                row.add("Edit");

            }
            data.add(row);
        }

        //System.out.println(data.get(0));
        JTable table = new JTable(data, columnNames);
        if (Login.a != 2) {
            table.getColumn("Action1").setCellRenderer(new ButtonRenderer());
            table.getColumn("Action1").setCellEditor(
                    new ButtonEditor(new JCheckBox(), table, viewTable));
            table.getColumn("Action2").setCellRenderer(new ButtonRenderer());
            table.getColumn("Action2").setCellEditor(
                    new ButtonEditor(new JCheckBox(), table, viewTable));
        }
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        JPanel buttonPanel = new JPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;

    private String label;
    JTable t1;
    private boolean isPushed;
    int index;
    String court, time, date, member;
    ViewTable viewTable;

    public ButtonEditor(JCheckBox checkBox, JTable t1, ViewTable viewTable) {
        super(checkBox);
        this.viewTable = viewTable;
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
        court = (String) t1.getModel().getValueAt(row, 1);
        time = (String) t1.getModel().getValueAt(row, 2);
        date = (String) t1.getModel().getValueAt(row, 3);
        member = (String) t1.getModel().getValueAt(row, 4);

        System.out.println("index " + Integer.parseInt(t1.getModel().getValueAt(row, 0).toString()));

        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    // update, delete
    public Object getCellEditorValue() {
        if (isPushed) {

            if (label.equalsIgnoreCase("Edit")) {

                Iterator<Reservation> iter = reservationList.iterator();

                //System.out.println(reservationList.size());
                while (iter.hasNext()) {
                    Reservation list = iter.next();
                    if (Integer.parseInt(list.getReservationId()) == index) {
                        System.out.println(Integer.parseInt(list.getReservationId()) == index);

                        list.setReservationCourtId(court);
                        list.setReservationTime(time);
                        list.setReservationDate(date);
                        list.setReservationMemberId(member);

                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Update recoed success");

            } else if (label.equalsIgnoreCase("Delete")) {

                Iterator<Reservation> iter = AvailableLists.getReservationList().iterator();

                while (iter.hasNext()) {
                    Reservation list = iter.next();

                    if (Integer.parseInt(list.getReservationId()) == index) {
                        iter.remove();
                    }
                }

                JOptionPane.showMessageDialog(button, label
                        + ":Delete record success");
                viewTable.desposeIt();
                ViewTable.call();

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
