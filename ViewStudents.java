package GUI_CW;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewStudents extends JFrame {


    public static void main(String[] args) {

        try {
            String url = "jdbc:mysql://localhost:3306/gui_cw?autoReconnect=true&useSSL=false";
            String user = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM students";

            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);

            String[] columns = {"First Name", "Last Name", "Gender", "Registration No.", "Age", "Class"};


            String[][] data = new String[0][];
            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String regno = rs.getString("regno");
                String age = rs.getString("age");
                String Class = rs.getString("class");
                data = new String[][]{{first_name, last_name, gender, regno, age, Class}};
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Registered Students");
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
