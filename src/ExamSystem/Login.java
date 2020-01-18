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
		lo.setTitle("������XСѧ��ѧ�����Զ�ϵͳ���ư�");
		lo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڵĴ�С��λ��
		lo.setSize(720,480);
		lo.setLocation(100,100);
		lo.setLocationRelativeTo(null);
		
		//��������
		Container l = lo.getContentPane();
		l.setLayout(null);
		
		//��ӭ�����ǩ
		JLabel title = new JLabel("��ӭʹ����ֽ������ϵͳ�����������ĸ�����Ϣ��");
		title.setFont(new Font("����", Font.BOLD, 20));
		title.setBounds(113, 10, 458 ,40);
		l.add(title);
		//����������ǩ
		JLabel name = new JLabel("����:");
		name.setFont(new Font("����", Font.BOLD, 20));
		name.setBounds(86, 102, 67, 40);
		l.add(name);
		//�����꼶��ǩ
		JLabel gra = new JLabel("�꼶:");
		gra.setFont(new Font("����", Font.BOLD, 20));
		gra.setBounds(86, 186, 67, 40);
		l.add(gra);
		//����༶��ǩ
		JLabel cla = new JLabel("�༶:");
		cla.setFont(new Font("����", Font.BOLD, 20));
		cla.setBounds(86, 267, 105, 40);
		l.add(cla);
		
		//���������
		name_s = new JTextField();
		name_s.setFont(new Font("����", Font.BOLD, 20));
		name_s.setBounds(269, 102, 239, 33);
		l.add(name_s);
		
		//�꼶�����
		gra_s = new JTextField();
		gra_s.setFont(new Font("����", Font.BOLD, 20));
		gra_s.setBounds(269, 186, 239, 33);
		l.add(gra_s);
		//�༶�����
		cla_s = new JTextField();
		cla_s.setFont(new Font("����", Font.BOLD, 20));
		cla_s.setBounds(269, 270, 239, 33);
		l.add(cla_s);
		
		//��¼��ť
		JButton login = new JButton("�����¼");
		login.setFont(new Font("����", Font.BOLD, 20));
		login.setBounds(158, 357, 120, 33);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter bw;
				String n = name_s.getText().trim();//ȥ������Ŀո�
				String g = gra_s.getText().trim();
				String c = cla_s.getText().trim();
				if(n.equals("")||g.equals("")||c.equals("")) {
					JOptionPane.showMessageDialog(null, "�뽫��Ϣ�������������ԣ�");
				}
				else{
					int result = JOptionPane.showConfirmDialog(null, "���������ϢΪ��\n������"+n+"\n�꼶��"+g
							+"\n�༶��"+c+"\n�Ƿ�ȷ�ϣ�", "ȷ��", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if(result == JOptionPane.OK_OPTION) {
						lo.dispose();
						if(n.equals("����")&&g.equals("����")&&c.equals("123456")) {
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
		
		//�˳���ť
		JButton back = new JButton("����˳�");
		back.setFont(new Font("����", Font.BOLD, 20));
		back.setBounds(388, 357, 120, 33);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ллʹ�ã�");
				//lo.setVisible(false);
				System.exit(0);
			}
		});
		l.add(back);
		
		//�������icon
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
