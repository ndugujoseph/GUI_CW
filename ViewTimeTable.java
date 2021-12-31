package GUI_CW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewTimeTable extends JFrame {


    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/gui_cw?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM  timetable";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            String[] columns = {"Subject", "Day", "Class", "Time"};


            String[][] data = new String[0][];
            while (rs.next()) {

                String sub = rs.getString("subject");
                String day = rs.getString("day");
                String time = rs.getString("time");
                String Class1 = rs.getString("class");
                data = new String[][]{{sub, day, Class1,time}};
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Time Table");
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
