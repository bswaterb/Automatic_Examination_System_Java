package ExamSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.Timer;
import java.io.*;


class UI_s extends JFrame{
	JPanel panel1,panel3;//存放cardlayout、题目与按钮
	ArrayList<JPanel> panel;//存放组件
	JLabel que,ans,num; //题目字样、答案字样、题序字样
	ArrayList<JLabel> dy;//等于号
	ArrayList<JLabel> qu;//题目标签
	JLabel timelabel; //计时器显示标签
	ArrayList<JTextField> an;//答案填写框
	JButton b1,b2,b3,b4,b5;//首页，上一页，下一个，尾页，交卷 按钮
	ArrayList<String> ans_w;//用户答案存放数组
	ArrayList<String> ans_t;//正确答案存放数组
	Date now = new Date(); //计时器相关
	ArrayList<String> info = new ArrayList<String>();//储存学生成绩
	BufferedReader br;
	BufferedWriter bw;
	int score=0;
	public UI_s(){
	panel = new ArrayList<JPanel>();
	dy = new ArrayList<JLabel>();
	qu = new ArrayList<JLabel>();
	an = new ArrayList<JTextField>();
	//设置主面板
	this.setBounds(100,100,720,480);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("正在考试");
	this.setLocationRelativeTo(null);
	Container u = this.getContentPane();
	u.setLayout(null);
	
	//设置Panel
	panel1 = new JPanel();		//只用来存放cardlayout的部分
	panel1.setBounds(38, 70, 624, 269);
	panel1.setLayout(new CardLayout(0,0));
	u.add(panel1);
	
	panel3 = new JPanel();		//翻页部分
	panel3.setBounds(38, 365, 624, 51);
	u.add(panel3);
	
	//设置题目字样、答案字样、题序字样
	num = new JLabel("题序");
	num.setFont(new Font("宋体", Font.BOLD, 20));
	num.setBounds(71, 24, 102, 36);
	u.add(num);
	
	que = new JLabel("题目");
	que.setFont(new Font("宋体", Font.BOLD, 20));
	que.setBounds(189, 24, 102, 36);
	u.add(que);
	
	ans = new JLabel("答案填写区");
	ans.setFont(new Font("宋体", Font.BOLD, 20));
	ans.setBounds(390, 24, 125, 36);
	u.add(ans);

	//设置计时器
	timelabel = new JLabel();
	timelabel.setBounds(525, 10, 171, 36);
	timelabel.setFont(new Font("宋体", Font.BOLD, 12));
	now.setHours(0);
	now.setMinutes(0);
	now.setSeconds(0);
	Timer time = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Date now2 = new Date(now.getTime() + 1000);
			now = now2;
			timelabel.setText(new SimpleDateFormat("已用时间：HH时:mm分:ss秒").format(now));	
			//设置到时自动交卷
			if(timelabel.getText().equals("已用时间：01时:30分:00秒")) {
				ans_w = new ArrayList<String>();
				for(int i=0;i<=49;i++) {
					ans_w.add(an.get(i).getText());
					if((ans_w.get(i)).equals(ans_t.get(i)))
					{
						score+=2;
					}
				}
				JOptionPane.showMessageDialog(null, "答题时间已到！\n 您的最终得分是: "+score+" 分");
				save();
				System.exit(0);
			}
		}
	});
	time.start();
	u.add(timelabel);
	
	//循环生成每一页的panel(null)	
	panel= new ArrayList<JPanel>();
	for(int i=0;i<=9;i++) {
		String a = String.valueOf(i+1);
		panel.add(new JPanel());
		panel.get(i).setLayout(null);
		panel1.add(panel.get(i),a);		
	}
	
	
	//循环生成题目栏以及答题框
	qu = new ArrayList<JLabel>();
	an = new ArrayList<JTextField>();
	dy = new ArrayList<JLabel>();
	for(int i=0,k=0;i<=49;i++){
		if(i>0) {
			if(i%5==0) {
				k++;	
			}
		}
		String j = String.valueOf(k+1);
		qu.add(new JLabel());
		qu.get(i).setFont(new Font("宋体", Font.BOLD, 20));
		an.add(new JTextField());
		an.get(i).setFont(new Font("宋体", Font.BOLD, 20));
		dy.add(new JLabel("="));
		dy.get(i).setFont(new Font("宋体", Font.BOLD, 25));
		if(i%5==0) {
			qu.get(i).setBounds(34, 24, 193, 33);
			an.get(i).setBounds(353, 32, 66, 21);
			dy.get(i).setBounds(259, 24, 47, 33);
			panel.get(k).add(qu.get(i),j);
			panel.get(k).add(an.get(i),j);
			panel.get(k).add(dy.get(i),j);
		}
		else if(i%5==1) {
			qu.get(i).setBounds(34, 67, 193, 33);
			an.get(i).setBounds(353, 75, 66, 21);
			dy.get(i).setBounds(259, 67, 47, 33);
			panel.get(k).add(qu.get(i),j);
			panel.get(k).add(an.get(i),j);
			panel.get(k).add(dy.get(i),j);
		}
		else if(i%5==2) {
			qu.get(i).setBounds(34, 110, 193, 33);
			an.get(i).setBounds(353, 118, 66, 21);
			dy.get(i).setBounds(259, 110, 47, 33);
			panel.get(k).add(qu.get(i),j);
			panel.get(k).add(an.get(i),j);
			panel.get(k).add(dy.get(i),j);
		}
		else if(i%5==3) {
			qu.get(i).setBounds(34, 153, 193, 33);
			an.get(i).setBounds(353, 161, 66, 21);
			dy.get(i).setBounds(259, 153, 47, 33);
			panel.get(k).add(qu.get(i),j);
			panel.get(k).add(an.get(i),j);
			panel.get(k).add(dy.get(i),j);
		}
		else if(i%5==4) {
			qu.get(i).setBounds(34, 200, 193, 33);
			an.get(i).setBounds(353, 208, 66, 21);
			dy.get(i).setBounds(259, 200, 47, 33);
			panel.get(k).add(qu.get(i),j);
			panel.get(k).add(an.get(i),j);
			panel.get(k).add(dy.get(i),j);
		}
	}

	//五个按钮
	b1 = new JButton("首页");
	b1.setFont(new Font("宋体", Font.BOLD, 20));
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).first(panel1);
		}
	});
	panel3.add(b1);
	
	b2 = new JButton("上一页");
	b2.setFont(new Font("宋体", Font.BOLD, 20));
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).previous(panel1);
		}
	});
	panel3.add(b2);
	
	b3 = new JButton("下一页");
	b3.setFont(new Font("宋体", Font.BOLD, 20));
	b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).next(panel1);
		}
	});
	panel3.add(b3);
	
	b4 = new JButton("尾页");
	b4.setFont(new Font("宋体", Font.BOLD, 20));
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).last(panel1);
		}
	});
	panel3.add(b4);
	
	//添加计算功能
	cacu();
	
	//交卷按钮
	b5 = new JButton("交卷");
	b5.setFont(new Font("宋体", Font.BOLD, 20));
	b5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "是否确认提前交卷？", "确认",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.OK_OPTION) {
				ans_w = new ArrayList<String>();
				for(int i=0;i<=49;i++) {
					ans_w.add(an.get(i).getText());
					if(ans_w.get(i).equals(ans_t.get(i))) {
						score+=2;
					}
				}
				JOptionPane.showMessageDialog(null, "您的最终得分是: "+score+" 分");
				save();
				//aver();
				System.exit(0);
			}
		}
	});
	panel3.add(b5);
	
	
	this.setVisible(true);
	}
	
	//随机生成题目
	public void cacu() {
			int a,b,c;
			String f1,f2;
			String f[] = new String[] {"+","-"};
			ans_t = new ArrayList<String>();  //正确答案存放数组
			for(int i=0;i<=49;) {
				a=(int)(Math.random()*100);
				b=(int)(Math.random()*100);
				c=(int)(Math.random()*100);
				if(a%2==0)			//随机生成正负号
				{
					f1 = f[0];
					f2 = f[1];
					if(a+b-c<=0)
						continue;
						
				}
				else{						
					f1 = f[1];
					f2 = f[0];
					if(a-b+c<=0)
						continue;
				}		
				qu.add(new JLabel());
				qu.get(i).setText((i+1)+".     "+a+f1+b+f2+c);
				switch(f1)
				{					
				case "+": ans_t.add(String.valueOf(a+b-c));break;
				case "-": ans_t.add(String.valueOf(a-b+c));break;
				}
				i++;
		}
	}
	

	//保存数据并写入文档
	public void save() {
		File file = new File("成绩.txt");	
		if(file.exists()) {
				try {
					br = new BufferedReader(new FileReader("成绩.txt"));
					String line=null;
					while((line=br.readLine())!=null) {
						info.add(line+"\n");
					}
					info.add(Main.a.getname()+"\t"+Main.a.getgra()+"\t"+Main.a.getcla()+"\t"+score+"\n");
					bw = new BufferedWriter(new FileWriter("成绩.txt"));
					for(int i=0;i<info.size();i++) {
						bw.write(info.get(i));
					}
					bw.close();
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}		
		}
		else {
			try {
				info.add(Main.a.getname()+"\t"+Main.a.getgra()+"\t"+Main.a.getcla()+"\t"+score+"\n");
				bw = new BufferedWriter(new FileWriter("成绩.txt"));
				for(String s : info) {
					bw.write(s);
					bw.close();
				}
			}catch(IOException e1) {
				e1.printStackTrace();
			}	
		}
	}
	
}

class UI_a extends JFrame {
	BufferedReader br;
	 DecimalFormat df = new DecimalFormat(".00");
	ArrayList<String> info = new ArrayList<String>();
	public UI_a() {
	//主面板
	this.setBounds(100,100,720,480);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("考试管理系统");
	this.setLocationRelativeTo(null);
	Container v = this.getContentPane();
	v.setLayout(null);

	//标签
	JLabel main = new JLabel("学生考试成绩管理系统");
	main.setFont(new Font("宋体", Font.BOLD, 30));
	main.setBounds(175, 10, 344, 96);
	v.add(main);
	
	//四个按钮
	JButton b1,b2,b3,b4;//查看考试进行情况、查询总平均分、查询个人分数、退出系统
	
	b2 = new JButton("查询考试平均分");
	b2.setFont(new Font("宋体", Font.BOLD, 15));
	b2.setBounds(253, 186, 193, 47);
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(null, "考试平均分为："+df.format(aver()));
		}
	});
	v.add(b2);
	
	b4 = new JButton("退出系统");
	b4.setFont(new Font("宋体", Font.BOLD, 15));
	b4.setBounds(253, 366, 193, 47);
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "谢谢使用！");
			System.exit(0);
		}
	});
	v.add(b4);
	
	this.setVisible(true);
	}
	
	
	//计算平均分
	public double aver() {
		ArrayList<Integer> ave = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader("成绩.txt"));
			String line=null;
			while((line=br.readLine())!=null) {
				info.add(line+"\n");
				String aver[] = line.split("\t");
				ave.add(Integer.valueOf(aver[3]).intValue());
			}
			br.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		double aver=0,sum=0;
		for(int i=0;i<ave.size();i++) {
			sum+=ave.get(i);
		}
		aver = sum/ave.size();
		return aver;
	}
}
	