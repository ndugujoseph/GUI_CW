package GUI_CW;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegisterStudent extends JFrame {

    private JPanel contentPane;
    private final JTextField t1;
    private final JTextField t2;
    private final JTextField t3;
    private final JTextField t4;
    private final JTextField t5;
    private final JTextField t6;
    private final JTextField t7;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                RegisterStudent frame = new RegisterStudent();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegisterStudent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel l1 = new JLabel("First Name");
        l1.setBounds(10, 26, 100, 14);
        contentPane.add(l1);

        JLabel ln = new JLabel("Last Name");
        ln.setBounds(10, 66, 100, 14);
        contentPane.add(ln);

        JLabel l2 = new JLabel("Class");
        l2.setBounds(10, 123, 100, 14);
        contentPane.add(l2);

        JLabel l3 = new JLabel("Age");
        l3.setBounds(10, 166, 100, 14);
        contentPane.add(l3);

        JLabel g = new JLabel("Gender");
        g.setBounds(10, 209, 100, 14);
        contentPane.add(g);

        JLabel rg = new JLabel("Reg No.");
        rg.setBounds(10, 252, 100, 14);
        contentPane.add(rg);

        JLabel p = new JLabel("Password");
        p.setBounds(10, 295, 100, 14);
        contentPane.add(p);



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

        t5 = new JTextField();
        t5.setBounds(140, 209, 150, 20);
        contentPane.add(t5);
        t5.setColumns(10);

        t6 = new JTextField();
        t6.setBounds(140, 252, 150, 20);
        contentPane.add(t6);
        t6.setColumns(10);

        t7 = new JTextField();
        t7.setBounds(140, 295, 150, 20);
        contentPane.add(t7);
        t7.setColumns(10);


        JButton b1 = new JButton("Save");
        b1.addActionListener(e -> {
            String fname=t1.getText();
            String lname=t2.getText();
            String Class=t3.getText();
            String age=t4.getText();
            String sex=t5.getText();
            String regno=t6.getText();
            String pwd=t7.getText();
            // creating one object
            insertData obj= new insertData();
            obj.insert(fname,lname, Class, age, sex,pwd,regno);
            JOptionPane.showMessageDialog(null, "Registered successfully");

            RegisterStudent ob =new RegisterStudent();
            ob.setVisible(true);

        });
        b1.setBounds(212, 350, 89, 23);
        contentPane.add(b1);
    }

    public static class insertData{

        void  insert(String str1, String str2,String str3,String str4,String str5,String str6,String str7) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/gui_cw","root","");
                Statement st=con.createStatement();
                int age = Integer.parseInt(str4); // Age is an integer
                // Adding record
                String query1="INSERT INTO students(first_name,last_name, class, age, gender,password,regno) VALUES('" +str1+"','"+str2+"','"+str3+"','"+age+"','" +str5+"','"+str6+"','"+str7+"')";
                st.executeUpdate(query1); // record added.

                con.close();

            }catch(Exception e){ System.out.println(e);}

        }
    }

}