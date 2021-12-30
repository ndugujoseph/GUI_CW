package GUI_CW;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TeacherRegistration extends JFrame {

    private JPanel contentPane;
    private final JTextField t1;
    private final JTextField t2;
    private final JTextField t3;
    private final JTextField t4;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TeacherRegistration frame = new TeacherRegistration();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public TeacherRegistration() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(10, 26, 100, 14);
        contentPane.add(l1);

        JLabel ln = new JLabel("User Name");
        ln.setBounds(10, 66, 100, 14);
        contentPane.add(ln);

        JLabel l2 = new JLabel("Subject");
        l2.setBounds(10, 123, 100, 14);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Password");
        l3.setBounds(10, 166, 100, 14);
        contentPane.add(l3);





        t1 = new JTextField();
        t1.setBounds(140, 26, 150, 20);
        contentPane.add(t1);
        t1.setColumns(10);

        t2 = new JTextField();
        t2.setBounds(140, 66, 150, 20);
        contentPane.add(t2);
        t2.setColumns(10);

        t3 = new JTextField();
        t3.setBounds(140, 123, 150, 20);
        contentPane.add(t3);
        t3.setColumns(10);

        t4 = new JTextField();
        t4.setBounds(140, 166, 150, 20);
        contentPane.add(t4);
        t4.setColumns(10);


        JButton b1 = new JButton("Save");
        b1.addActionListener(e -> {
            String name=t1.getText();
            String uname=t2.getText();
            String sub=t3.getText();
            String pass=t4.getText();

            // creating one object
            insertData obj= new insertData();
            obj.insert(name,uname, sub, pass);
            JOptionPane.showMessageDialog(null, "Registered successfully");

            RegisterStudent ob =new RegisterStudent();
            ob.setVisible(true);

        });
        b1.setBounds(212, 350, 89, 23);
        contentPane.add(b1);
    }

    public static class insertData{

        void  insert(String str1, String str2,String str3,String str4) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gui_cw","root","");
                Statement st=con.createStatement();

                // Adding record
                String query1="INSERT INTO teachers(name,username, subject,password) VALUES('" +str1+"','"+str2+"','"+str3+"','"+str4+"')";
                st.executeUpdate(query1); // record added.

                con.close();

            }catch(Exception e){ System.out.println(e);}

        }
    }

}