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
	JPanel panel1,panel3;//���cardlayout����Ŀ�밴ť
	ArrayList<JPanel> panel;//������
	JLabel que,ans,num; //��Ŀ����������������������
	ArrayList<JLabel> dy;//���ں�
	ArrayList<JLabel> qu;//��Ŀ��ǩ
	JLabel timelabel; //��ʱ����ʾ��ǩ
	ArrayList<JTextField> an;//����д��
	JButton b1,b2,b3,b4,b5;//��ҳ����һҳ����һ����βҳ������ ��ť
	ArrayList<String> ans_w;//�û��𰸴������
	ArrayList<String> ans_t;//��ȷ�𰸴������
	Date now = new Date(); //��ʱ�����
	ArrayList<String> info = new ArrayList<String>();//����ѧ���ɼ�
	BufferedReader br;
	BufferedWriter bw;
	int score=0;
	public UI_s(){
	panel = new ArrayList<JPanel>();
	dy = new ArrayList<JLabel>();
	qu = new ArrayList<JLabel>();
	an = new ArrayList<JTextField>();
	//���������
	this.setBounds(100,100,720,480);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("���ڿ���");
	this.setLocationRelativeTo(null);
	Container u = this.getContentPane();
	u.setLayout(null);
	
	//����Panel
	panel1 = new JPanel();		//ֻ�������cardlayout�Ĳ���
	panel1.setBounds(38, 70, 624, 269);
	panel1.setLayout(new CardLayout(0,0));
	u.add(panel1);
	
	panel3 = new JPanel();		//��ҳ����
	panel3.setBounds(38, 365, 624, 51);
	u.add(panel3);
	
	//������Ŀ����������������������
	num = new JLabel("����");
	num.setFont(new Font("����", Font.BOLD, 20));
	num.setBounds(71, 24, 102, 36);
	u.add(num);
	
	que = new JLabel("��Ŀ");
	que.setFont(new Font("����", Font.BOLD, 20));
	que.setBounds(189, 24, 102, 36);
	u.add(que);
	
	ans = new JLabel("����д��");
	ans.setFont(new Font("����", Font.BOLD, 20));
	ans.setBounds(390, 24, 125, 36);
	u.add(ans);

	//���ü�ʱ��
	timelabel = new JLabel();
	timelabel.setBounds(525, 10, 171, 36);
	timelabel.setFont(new Font("����", Font.BOLD, 12));
	now.setHours(0);
	now.setMinutes(0);
	now.setSeconds(0);
	Timer time = new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Date now2 = new Date(now.getTime() + 1000);
			now = now2;
			timelabel.setText(new SimpleDateFormat("����ʱ�䣺HHʱ:mm��:ss��").format(now));	
			//���õ�ʱ�Զ�����
			if(timelabel.getText().equals("����ʱ�䣺01ʱ:30��:00��")) {
				ans_w = new ArrayList<String>();
				for(int i=0;i<=49;i++) {
					ans_w.add(an.get(i).getText());
					if((ans_w.get(i)).equals(ans_t.get(i)))
					{
						score+=2;
					}
				}
				JOptionPane.showMessageDialog(null, "����ʱ���ѵ���\n �������յ÷���: "+score+" ��");
				save();
				System.exit(0);
			}
		}
	});
	time.start();
	u.add(timelabel);
	
	//ѭ������ÿһҳ��panel(null)	
	panel= new ArrayList<JPanel>();
	for(int i=0;i<=9;i++) {
		String a = String.valueOf(i+1);
		panel.add(new JPanel());
		panel.get(i).setLayout(null);
		panel1.add(panel.get(i),a);		
	}
	
	
	//ѭ��������Ŀ���Լ������
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
		qu.get(i).setFont(new Font("����", Font.BOLD, 20));
		an.add(new JTextField());
		an.get(i).setFont(new Font("����", Font.BOLD, 20));
		dy.add(new JLabel("="));
		dy.get(i).setFont(new Font("����", Font.BOLD, 25));
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

	//�����ť
	b1 = new JButton("��ҳ");
	b1.setFont(new Font("����", Font.BOLD, 20));
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).first(panel1);
		}
	});
	panel3.add(b1);
	
	b2 = new JButton("��һҳ");
	b2.setFont(new Font("����", Font.BOLD, 20));
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).previous(panel1);
		}
	});
	panel3.add(b2);
	
	b3 = new JButton("��һҳ");
	b3.setFont(new Font("����", Font.BOLD, 20));
	b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).next(panel1);
		}
	});
	panel3.add(b3);
	
	b4 = new JButton("βҳ");
	b4.setFont(new Font("����", Font.BOLD, 20));
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)panel1.getLayout()).last(panel1);
		}
	});
	panel3.add(b4);
	
	//��Ӽ��㹦��
	cacu();
	
	//����ť
	b5 = new JButton("����");
	b5.setFont(new Font("����", Font.BOLD, 20));
	b5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "�Ƿ�ȷ����ǰ����", "ȷ��",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.OK_OPTION) {
				ans_w = new ArrayList<String>();
				for(int i=0;i<=49;i++) {
					ans_w.add(an.get(i).getText());
					if(ans_w.get(i).equals(ans_t.get(i))) {
						score+=2;
					}
				}
				JOptionPane.showMessageDialog(null, "�������յ÷���: "+score+" ��");
				save();
				//aver();
				System.exit(0);
			}
		}
	});
	panel3.add(b5);
	
	
	this.setVisible(true);
	}
	
	//���������Ŀ
	public void cacu() {
			int a,b,c;
			String f1,f2;
			String f[] = new String[] {"+","-"};
			ans_t = new ArrayList<String>();  //��ȷ�𰸴������
			for(int i=0;i<=49;) {
				a=(int)(Math.random()*100);
				b=(int)(Math.random()*100);
				c=(int)(Math.random()*100);
				if(a%2==0)			//�������������
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
	

	//�������ݲ�д���ĵ�
	public void save() {
		File file = new File("�ɼ�.txt");	
		if(file.exists()) {
				try {
					br = new BufferedReader(new FileReader("�ɼ�.txt"));
					String line=null;
					while((line=br.readLine())!=null) {
						info.add(line+"\n");
					}
					info.add(Main.a.getname()+"\t"+Main.a.getgra()+"\t"+Main.a.getcla()+"\t"+score+"\n");
					bw = new BufferedWriter(new FileWriter("�ɼ�.txt"));
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
				bw = new BufferedWriter(new FileWriter("�ɼ�.txt"));
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
	//�����
	this.setBounds(100,100,720,480);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setTitle("���Թ���ϵͳ");
	this.setLocationRelativeTo(null);
	Container v = this.getContentPane();
	v.setLayout(null);

	//��ǩ
	JLabel main = new JLabel("ѧ�����Գɼ�����ϵͳ");
	main.setFont(new Font("����", Font.BOLD, 30));
	main.setBounds(175, 10, 344, 96);
	v.add(main);
	
	//�ĸ���ť
	JButton b1,b2,b3,b4;//�鿴���Խ����������ѯ��ƽ���֡���ѯ���˷������˳�ϵͳ
	
	b2 = new JButton("��ѯ����ƽ����");
	b2.setFont(new Font("����", Font.BOLD, 15));
	b2.setBounds(253, 186, 193, 47);
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showConfirmDialog(null, "����ƽ����Ϊ��"+df.format(aver()));
		}
	});
	v.add(b2);
	
	b4 = new JButton("�˳�ϵͳ");
	b4.setFont(new Font("����", Font.BOLD, 15));
	b4.setBounds(253, 366, 193, 47);
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "ллʹ�ã�");
			System.exit(0);
		}
	});
	v.add(b4);
	
	this.setVisible(true);
	}
	
	
	//����ƽ����
	public double aver() {
		ArrayList<Integer> ave = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader("�ɼ�.txt"));
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
	