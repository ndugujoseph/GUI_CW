package GUI_CW;

import javax.swing.*;

public class Login extends JFrame {



    private JPanel mainpanel;
    private JLabel title;
    private JLabel usernamelabel;
    private JButton TEACHERButton;
    private JButton STUDENTButton;

    public Login(){
        super("KATIKAMU PRIMARY SCHOOL");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setContentPane(mainpanel);
//        this.setVisible(true);
        TEACHERButton.addActionListener(actionEvent -> {
            TeacherLogin teacher = new TeacherLogin();
            teacher.setVisible(true);

            teacher.dispose();
        });
        STUDENTButton.addActionListener(actionEvent -> {
            StudentLogin student = new StudentLogin();
            student.setVisible(true);

            student.dispose();

        });
    }
    public static void main(String []args){
         JFrame frame = new Login();
         frame.setVisible(true);
    }


}
