package GUI_CW;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TeacherHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TeacherHome frame = new TeacherHome();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public TeacherHome() {

    }

    /**
     * Create the frame.
     */
    public TeacherHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("Register Students\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(e -> {
            RegisterStudent vs = new RegisterStudent();

            vs.setVisible(true);

        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(247, 50, 491, 70);
        contentPane.add(button);

        JButton button1 = new JButton("Record Students Marks\r\n");
        button1.setBackground(UIManager.getColor("Button.disabledForeground"));
        button1.addActionListener(e -> {
            RecordMarks vs = new RecordMarks();

            vs.setVisible(true);

        });
        button1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button1.setBounds(247, 150, 491, 70);
        contentPane.add(button1);

        JButton button2 = new JButton("Registered Students\r\n");
        button2.setBackground(UIManager.getColor("Button.disabledForeground"));
        button2.addActionListener(e -> {
                ViewStudents vs = new ViewStudents();

                vs.setVisible(true);


        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button2.setBounds(247, 250, 491, 70);
        contentPane.add(button2);

        JButton button3 = new JButton("Add Time Table\r\n");
        button3.setBackground(UIManager.getColor("Button.disabledForeground"));
        button3.addActionListener(e -> {
            AddTimetable vs = new AddTimetable();

            vs.setVisible(true);




        });
        button3.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button3.setBounds(247, 350, 491, 70);
        contentPane.add(button3);

        JButton logout = new JButton("Logout");
        logout.setForeground(new Color(0, 0, 0));
        logout.setBackground(UIManager.getColor("Button.disabledForeground"));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 39));
        logout.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
            // JOptionPane.setRootFrame(null);
            if (a == JOptionPane.YES_OPTION) {
                dispose();
                TeacherLogin obj = new TeacherLogin();
                obj.setTitle("Teacher Login Page");
                obj.setVisible(true);
            }
            dispose();
            TeacherHome obj = new TeacherHome();

            obj.setTitle("Teacher Home");
            obj.setVisible(true);

        });
        logout.setBounds(247, 450, 491, 70);
        contentPane.add(logout);
    }
}