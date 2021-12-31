package GUI_CW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewMarks extends JFrame {


    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/gui_cw?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM marks";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            String[] columns = {"Subject", "Marks"};


            String[][] data = new String[0][];
            while (rs.next()) {
                String sub = rs.getString("subject");
                String mark = rs.getString("mark");

                data = new String[][]{{sub, mark}};
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Marks");
            JPanel panel = new JPanel();
            panel.add(pane);
            f.add(panel);
            f.setSize(500, 250);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
