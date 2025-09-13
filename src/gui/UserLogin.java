package gui;
import java.awt.*;

import javax.swing.*;

public class UserLogin extends JFrame {
    private JTextField fieldAccount = new JTextField();
    private JPasswordField fieldPassword = new JPasswordField();
    private JButton buttonLogin = new JButton("登   陆");
    private JButton buttonCancle = new JButton("取   消");



    public UserLogin() {
        this.setTitle("我要请假 登录");
        this.setLocation(700, 300);
        this.setSize(800, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        // 用户账号
        JLabel labelAccount = new JLabel("用户");
        labelAccount.setAlignmentY(CENTER_ALIGNMENT);
        labelAccount.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelAccount.setBounds(100, 100, 100, 60);
        fieldAccount.setBounds(150, 100, 500, 60);
        this.getContentPane().add(labelAccount);
        this.getContentPane().add(fieldAccount);


        // 用户密码
        JLabel labelPwd = new JLabel("密码");
        labelPwd.setAlignmentY(CENTER_ALIGNMENT);
        labelPwd.setFont(new Font("SansSerif", Font.PLAIN, 18));
        labelPwd.setBounds(100, 200, 100, 60);
        fieldPassword.setBounds(150, 200, 500, 60);
        this.getContentPane().add(labelPwd);
        this.getContentPane().add(fieldPassword, BorderLayout.CENTER);

        //角色
        JPanel panel = new JPanel();
        JLabel lable = new JLabel("选择角色");
        lable.setFont(new Font("SansSerif", Font.PLAIN, 18));
        JRadioButton student = new JRadioButton("学生");
        student.setFont(new Font("SansSerif", Font.PLAIN, 18));
        JRadioButton teacher = new JRadioButton("教师");
        teacher.setFont(new Font("SansSerif", Font.PLAIN, 18));
        JRadioButton instrutor = new JRadioButton("辅导员");
        instrutor.setFont(new Font("SansSerif", Font.PLAIN, 18));
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(student);
        buttonGroup.add(teacher);
        buttonGroup.add(instrutor);
        panel.add(lable);
        panel.add(student);
        panel.add(teacher);
        panel.add(instrutor);
        panel.setBounds(100,350,500,80);
        this.getContentPane().add(panel);

        // 登陆按钮
        buttonLogin.setBounds(150, 450, 150, 30);
        buttonLogin.setFont(new Font("SansSerif", Font.PLAIN, 18));
        this.getContentPane().add(buttonLogin);

        buttonCancle.setBounds(500, 450, 150, 30);
        buttonCancle.setFont(new Font("SansSerif", Font.PLAIN, 18));
        this.getContentPane().add(buttonCancle);

        this.setVisible(true);
    }
    public static void main(String[] args) {
        new UserLogin();

    }
}
