package gui;

import info.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeaveApplication extends JFrame {

    private JTextField studentIdField;
    private JTextField nameField;
    private JTextField startTimeField;
    private JTextField endTimeField;
    private JTextArea reasonArea;
    private JComboBox<String> statusComboBox;
    private JButton applyButton;
    private JButton modifyButton;
    private JButton cancelButton;

    public LeaveApplication(User applicationApplicant,User operator) {
        setTitle("我要请假-"+operator.getCharacter()+"-假条界面");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(500, 350);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        Font labelFont = new Font("宋体", Font.PLAIN, 12);
        Font fieldFont = new Font("宋体", Font.PLAIN, 12);

        gbc.gridx = 0; gbc.gridy = 0;
        JLabel studentLabel = new JLabel("学 号:");
        studentLabel.setFont(labelFont);
        mainPanel.add(studentLabel, gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        studentIdField = new JTextField(applicationApplicant.getNumber(), 15);
        studentIdField.setFont(fieldFont);
        studentIdField.setEditable(false);
        studentIdField.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(studentIdField, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1;
        JLabel nameLabel = new JLabel("姓 名:");
        nameLabel.setFont(labelFont);
        mainPanel.add(nameLabel, gbc);

        gbc.gridx = 4; gbc.gridwidth = 2;
        nameField = new JTextField(applicationApplicant.getRealName(), 15);
        nameField.setFont(fieldFont);
        nameField.setEditable(false);
        nameField.setBackground(Color.LIGHT_GRAY);
        mainPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        JLabel startTimeLabel = new JLabel("开始时间:");
        startTimeLabel.setFont(labelFont);
        mainPanel.add(startTimeLabel, gbc);

        gbc.gridx = 1; gbc.gridwidth = 2;
        startTimeField = new JTextField("输入文本", 15);
        startTimeField.setFont(fieldFont);
        mainPanel.add(startTimeField, gbc);

        gbc.gridx = 3; gbc.gridwidth = 1;
        JLabel endTimeLabel = new JLabel("结束时间:");
        endTimeLabel.setFont(labelFont);
        mainPanel.add(endTimeLabel, gbc);

        gbc.gridx = 4; gbc.gridwidth = 2;
        endTimeField = new JTextField("输入文本", 15);
        endTimeField.setFont(fieldFont);
        mainPanel.add(endTimeField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        JLabel reasonLabel = new JLabel("请假原因:");
        reasonLabel.setFont(labelFont);
        mainPanel.add(reasonLabel, gbc);

        gbc.gridx = 1; gbc.gridwidth = 6; gbc.fill = GridBagConstraints.HORIZONTAL;
        reasonArea = new JTextArea("输入文本", 4, 20);
        reasonArea.setFont(fieldFont);
        reasonArea.setLineWrap(true);
        reasonArea.setWrapStyleWord(true);
        JScrollPane reasonScrollPane = new JScrollPane(reasonArea);
        reasonScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        mainPanel.add(reasonScrollPane, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel statusLabel = new JLabel("状 态:");
        statusLabel.setFont(labelFont);
        mainPanel.add(statusLabel, gbc);

        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        statusComboBox = new JComboBox<>(new String[]{"待审批", "已批准", "已拒绝"});
        statusComboBox.setFont(fieldFont);
        mainPanel.add(statusComboBox, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        applyButton = new JButton("申 请");
        modifyButton = new JButton("修 改");
        cancelButton = new JButton("取 消");

        applyButton.setFont(fieldFont);
        modifyButton.setFont(fieldFont);
        cancelButton.setFont(fieldFont);
        authenticate(operator);

        buttonPanel.add(applyButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(cancelButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        User user = new User();
        user.setId("1001");
        user.setRealName("user");
        user.setNumber("1001");
        user.setCharacter("辅导员");
        User operator = new User();
        operator.setId("1001");
        operator.setRealName("user");
        operator.setNumber("1001");
        operator.setCharacter("辅导员");
        new LeaveApplication(user,operator);
    }

    private void authenticate(User user){
        applyButton.setVisible(false);
        modifyButton.setVisible(false);
        reasonArea.setEditable(false);
        startTimeField.setEditable(false);
        endTimeField.setEditable(false);
        statusComboBox.setEnabled(false);
        if (user.getCharacter().equals("辅导员")){
            modifyButton.setVisible(true);
            statusComboBox.setEnabled(true);

            reasonArea.setBackground(Color.LIGHT_GRAY);
            startTimeField.setBackground(Color.LIGHT_GRAY);
            endTimeField.setBackground(Color.LIGHT_GRAY);
        }else if (user.getCharacter().equals("教师")){

            reasonArea.setBackground(Color.LIGHT_GRAY);
            startTimeField.setBackground(Color.LIGHT_GRAY);
            endTimeField.setBackground(Color.LIGHT_GRAY);
        }else if (user.getCharacter().equals("学生")){
            applyButton.setVisible(true);
            reasonArea.setEditable(true);
            startTimeField.setEditable(true);
            endTimeField.setEditable(true);

        }
    }
}