package Finally;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PrintCourse extends JFrame {//extends�̳�JFrame��
	public static void main(String args[]) {
		PrintCourse demo = new PrintCourse();//ʵ����demo
    }
	 public PrintCourse() {
	        init();
	        this.setTitle("ѧ��ѡ��ϵͳ���γ̴�ӡ");
			this.setBounds(400, 150, 782, 300);;
			this.setVisible(true);
	    }
	public void init() { 
		Object_in_out file=new Object_in_out();
		String[] s2=new String[5];
		JFrame frame=new JFrame();
		frame.setTitle("Quit");
		JPanel panel2=new JPanel();
		s2=file.readFile(file.readFile("identify")).split("��");
		JList list =new JList(s2);
		list.setBounds(49, 48, 676, 48);
		JButton btn2=new JButton("�˳�");
		btn2.setBounds(296, 188, 145, 48);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel2.setLayout(null);
		panel2.add(btn2);
		panel2.add(list);
		getContentPane().add(panel2);
	}
}