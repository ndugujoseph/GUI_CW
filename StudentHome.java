package GUI_CW;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StudentHome extends JFrame {

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

    public StudentHome() {

    }

    /**
     * Create the frame.
     */
    public StudentHome(String userSes) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton button = new JButton("View Marks\r\n");
        button.setBackground(UIManager.getColor("Button.disabledForeground"));
        button.addActionListener(e -> {
            ViewMarks vs = new ViewMarks();

            vs.setVisible(true);

        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button.setBounds(247, 50, 491, 70);
        contentPane.add(button);

        JButton button1 = new JButton("View Time Table\r\n");
        button1.setBackground(UIManager.getColor("Button.disabledForeground"));
        button1.addActionListener(e -> {
           ViewTimeTable vs = new ViewTimeTable();

            vs.setVisible(true);

        });
        button1.setFont(new Font("Tahoma", Font.PLAIN, 35));
        button1.setBounds(247, 150, 491, 70);
        contentPane.add(button1);


        JButton logout = new JButton("Logout");
        logout.setForeground(new Color(0, 0, 0));
        logout.setBackground(UIManager.getColor("Button.disabledForeground"));
        logout.setFont(new Font("Tahoma", Font.PLAIN, 39));
        logout.addActionListener(e -> {
            int a = JOptionPane.showConfirmDialog(logout, "Are you sure?");
            // JOptionPane.setRootFrame(null);
            if (a == JOptionPane.YES_OPTION) {
                dispose();
                StudentLogin obj = new StudentLogin();
                obj.setTitle("Student Login Page");
                obj.setVisible(true);
            }
            dispose();

        });
        logout.setBounds(247, 450, 491, 70);
        contentPane.add(logout);
    }
}