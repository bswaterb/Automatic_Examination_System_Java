package ExamSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Login {
	JTextField name_s;
	JTextField gra_s;
	JTextField cla_s;
	BufferedWriter bw;
	
	ArrayList<String> info = new ArrayList<String>();
	
	public Login() {
		JFrame lo = new JFrame();
		lo.setTitle("广州市X小学数学考试自动系统重制版");
		lo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口的大小和位置
		lo.setSize(720,480);
		lo.setLocation(100,100);
		lo.setLocationRelativeTo(null);
		
		//生成容器
		Container l = lo.getContentPane();
		l.setLayout(null);
		
		//欢迎标语标签
		JLabel title = new JLabel("欢迎使用无纸化考试系统！请输入您的个人信息！");
		title.setFont(new Font("宋体", Font.BOLD, 20));
		title.setBounds(113, 10, 458 ,40);
		l.add(title);
		//输入姓名标签
		JLabel name = new JLabel("姓名:");
		name.setFont(new Font("宋体", Font.BOLD, 20));
		name.setBounds(86, 102, 67, 40);
		l.add(name);
		//输入年级标签
		JLabel gra = new JLabel("年级:");
		gra.setFont(new Font("宋体", Font.BOLD, 20));
		gra.setBounds(86, 186, 67, 40);
		l.add(gra);
		//输入班级标签
		JLabel cla = new JLabel("班级:");
		cla.setFont(new Font("宋体", Font.BOLD, 20));
		cla.setBounds(86, 267, 105, 40);
		l.add(cla);
		
		//姓名输入框
		name_s = new JTextField();
		name_s.setFont(new Font("宋体", Font.BOLD, 20));
		name_s.setBounds(269, 102, 239, 33);
		l.add(name_s);
		
		//年级输入框
		gra_s = new JTextField();
		gra_s.setFont(new Font("宋体", Font.BOLD, 20));
		gra_s.setBounds(269, 186, 239, 33);
		l.add(gra_s);
		//班级输入框
		cla_s = new JTextField();
		cla_s.setFont(new Font("宋体", Font.BOLD, 20));
		cla_s.setBounds(269, 270, 239, 33);
		l.add(cla_s);
		
		//登录按钮
		JButton login = new JButton("点击登录");
		login.setFont(new Font("宋体", Font.BOLD, 20));
		login.setBounds(158, 357, 120, 33);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter bw;
				String n = name_s.getText().trim();//去掉多余的空格
				String g = gra_s.getText().trim();
				String c = cla_s.getText().trim();
				if(n.equals("")||g.equals("")||c.equals("")) {
					JOptionPane.showMessageDialog(null, "请将信息输入完整后重试！");
				}
				else{
					int result = JOptionPane.showConfirmDialog(null, "您输入的信息为：\n姓名："+n+"\n年级："+g
							+"\n班级："+c+"\n是否确认？", "确认", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.OK_OPTION) {
						lo.dispose();
						if(n.equals("张三")&&g.equals("教务处")&&c.equals("123456")) {
							UI_a ui = new UI_a();
						}
						else {
							UI_s ui = new UI_s();
						}
					}
				}
			}
		});
		l.add(login);
		
		//退出按钮
		JButton back = new JButton("点击退出");
		back.setFont(new Font("宋体", Font.BOLD, 20));
		back.setBounds(388, 357, 120, 33);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "谢谢使用！");
				//lo.setVisible(false);
				System.exit(0);
			}
		});
		l.add(back);
		
		//添加三个icon
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src\\images\\1.png"));
		lblNewLabel.setBounds(31, 102, 38, 40);
		l.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\images\\2.png"));
		lblNewLabel_1.setBounds(31, 263, 38, 40);
		l.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("src\\images\\3.1.png"));
		label_4.setBounds(32, 179, 44, 40);
		l.add(label_4);
		
		lo.setVisible(true);
	}
	
	
	
	public String getname() {
		return name_s.getText();
		}
	
	public String getgra() {
		return gra_s.getText();
	}
	
	public String getcla() {
		return cla_s.getText();
	}

}
