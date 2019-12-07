package Finally;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.awt.Font;

public class ChoiseCourse extends JFrame {
	public static void main(String args[]) {
		ChoiseCourse demo = new ChoiseCourse();
    }
	 public ChoiseCourse() {
	        init();
	        this.setTitle("学生选课系统");
			this.setBounds(300, 150, 900, 300);;
			this.setVisible(true);
	    }
	public void init() {
		GainCourse s=new GainCourse();
		Object_in_out file=new Object_in_out();
		String[] s1=s.gainCourse();
		String[] s2=new String[20];
		JFrame frame=new JFrame();
		frame.setTitle("choice");
		JPanel panel2=new JPanel();
		JList list =new JList(s.gainCourse());
		list.setFont(new Font("宋体", Font.PLAIN, 14));
		list.setBounds(10, 5, 864, 179);
		JButton btn1=new JButton("确定");
		btn1.setBounds(195, 204, 162, 34);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "您未选择课程");
					return;
				}
				for(int i=0;i<s2.length;i++) {
					if(list.isSelectedIndex(i)&&file.readFile(file.readFile("identify")).contains(s1[i])==false) {
						s2[i]=s1[i];
					}
				}
			file.WriteFile(s2,file.readFile("identify"));
				JOptionPane.showMessageDialog(null, "选课成功");
				setVisible(false);
			}
		});
		panel2.setLayout(null);
		panel2.add(btn1);
		panel2.add(list);
		getContentPane().add(panel2);
		JButton btn2=new JButton("退出");
		btn2.setBounds(492, 204, 162, 34);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel2.add(btn2);
	}
}