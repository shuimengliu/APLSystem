/**
 * 
 */
package gui;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;

import info.ApplicationForLeave;
import info.User;

import javax.swing.*;

/**
 * @author techlife
 *
 */
public class MainView extends JFrame {
	public static void main(String[] args) {
		User user = new User();
		user.setId("1001");
		user.setUserName("user");
		user.setNumber("1001");
		user.setCharacter("辅导员");
		new MainView(user);
	}

	/** 
	 */
	private ApplicationForLeave ticket = new ApplicationForLeave();

	private static final String arrayMonth[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};

	private JComboBox JCB_Month = new JComboBox(arrayMonth);

	private JTextField fieldAccount = new JTextField();

	private JButton butAplc = new JButton("请假");
	private JButton butAmend = new JButton("修改");
	private JTable resultTable = null; 
	
	public MainView(User user){
		this.setTitle("我要请假-"+user.getCharacter()+"-主界面");
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		authenticate(user);

		JPanel upper = new JPanel();
		JPanel middle = new JPanel();
		JPanel bottom = new JPanel();
		upper.setLocation(0, 0);
		upper.setSize(800, 100);
		middle.setLocation(0, 100);
		middle.setSize(800, 300);
		bottom.setLocation(0, 400);
		bottom.setSize(800, 100);
	
		// 在上面的面板添加元素

		upper.setLayout(new BorderLayout());
		upper.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		upper.setLayout(new FlowLayout());

		butAplc.setFont(new Font("SansSerif", Font.PLAIN, 18));
		upper.add(butAplc);
		upper.add(Box.createHorizontalStrut(30));

		JButton butSeach = new JButton("查询");
		butSeach.setFont(new Font("SansSerif", Font.PLAIN, 18));
		upper.add(butSeach);

		JLabel labelAccount = new JLabel("学号");
		labelAccount.setAlignmentY(CENTER_ALIGNMENT);
		labelAccount.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelAccount.setSize(100, 60);
		fieldAccount.setPreferredSize(new java.awt.Dimension(100, 35));
		upper.add(labelAccount);
		upper.add(fieldAccount);

		JLabel labelMonth = new JLabel("月份");
		labelMonth.setAlignmentY(CENTER_ALIGNMENT);
		labelMonth.setFont(new Font("SansSerif", Font.PLAIN, 18));
		labelMonth.setSize(100, 60);
		JCB_Month.setToolTipText("月");
		JCB_Month.setPreferredSize(new java.awt.Dimension(100, 35));
		upper.add(labelMonth);
		upper.add(JCB_Month);

		//	设置当前日期
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();

		JCB_Month.setSelectedIndex(date.getMonth());



		this.add(upper);
		
		// 在中间的Panel上添加元素
		middle.setLayout(new BorderLayout());
		// resultTable = 初始化 
		createResultTable();
		resultTable.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 18));
		resultTable.setFont(new Font("SansSerif", Font.PLAIN, 18));
		resultTable.setRowHeight(25);
		JScrollPane scrollPane=new JScrollPane(resultTable);
		middle.add(scrollPane);
		this.add(middle);
		
		// 在下面的Panel上添加元素
		bottom.setLayout(new BorderLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		bottom.setLayout(new FlowLayout());
		JButton butView = new JButton("查看");
		butView.setFont(new Font("SansSerif", Font.PLAIN, 18));

		butAmend.setFont(new Font("SansSerif", Font.PLAIN, 18));
		bottom.add(butView);
		bottom.add(Box.createHorizontalStrut(50));
		bottom.add(butAmend);
		this.add(bottom);
		
		// 显示界面
		this.setVisible(true);
	}
	
	private void createResultTable(){
		if (resultTable != null) return;
		
		Object[][] data = {
				{"20230001", "张三", "2025-09-01", "2025-09-03", "已批准"},
				{"20230002", "李四", "2025-09-05", "2025-09-06", "待审批"},
				{"20230003", "王五", "2025-09-10", "2025-09-12", "已拒绝"},
				{"20230004", "赵六", "2025-09-15", "2025-09-16", "已批准"},
				{"20230005", "钱七", "2025-09-18", "2025-09-20", "待审批"}
		};

		String[] name={"学号", "姓名", "开始","结束","状态"};
		resultTable = new JTable(data, name);
	}

	private void getData(String num,Date date){

	}

	private void authenticate(User user){
		if (user.getCharacter().equals("辅导员")){
			butAplc.setVisible(false);
		}else if (user.getCharacter().equals("教师")){
			butAplc.setVisible(false);
			butAmend.setVisible(false);
		}else if (user.getCharacter().equals("学生")){
			butAmend.setVisible(false);
		}
	}

}
