package Finally;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCourse extends JFrame{
	public static void main(String args[]) {
		AddCourse demo = new AddCourse();
    }
	 public AddCourse() {
	        init();
	        this.setTitle("学生选课系统:");
			this.setBounds(400, 150, 420, 400);;
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
		panel2.setLayout(null);
		JLabel lb1=new JLabel("课程号：");
		lb1.setBounds(10, 10, 100, 30);
		JTextField tf1=new JTextField(20);
		tf1.setBounds(80, 10, 200, 30);
		JLabel lb2=new JLabel("课程名称：");
		lb2.setBounds(10, 50, 100, 30);
		JTextField tf2=new JTextField(20);
		tf2.setBounds(80, 50, 200, 30);
		JLabel lb3=new JLabel("课程地点：");
		lb3.setBounds(10, 90, 200, 30);
		JTextField tf3=new JTextField(20);
		tf3.setBounds(80, 90, 200, 30);
		JLabel lb4=new JLabel("课程时间：");
		lb4.setBounds(10, 130, 200, 30);
		JTextField tf4=new JTextField();
		tf4.setBounds(80, 130, 200, 30);
		JLabel lb5=new JLabel("教师工号：");
		lb5.setBounds(10, 170, 200, 30);
		JTextField tf5=new JTextField(20);
		tf5.setBounds(80, 170, 200, 30);
		JLabel lb6=new JLabel("教师姓名：");
		lb6.setBounds(10, 210, 200, 30);
		JTextField tf6=new JTextField(20);
		tf6.setBounds(80, 210, 200, 30);
		JLabel lb7=new JLabel("性别：");
		lb7.setBounds(10, 250, 200, 30);

		JTextField tf7=new JTextField(20);
		tf7.setBounds(80, 210, 200, 30);
		tf7.setBounds(80, 250, 200, 30);
		JButton btn1=new JButton("添加");
		btn1.setBounds(80, 290, 60, 30);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String[] s4={"M","F"};
				if(tf1.getText().trim().length()==0||tf2.getText().trim().length()==0||tf3.getText().trim().length()==0||tf4.getText().trim().length()==0||tf5.getText().trim().length()==0||tf6.getText().trim().length()==0||tf6.getText().trim().length()==0) {

					JOptionPane.showMessageDialog(null, "信息不能为空！");
					return;
				}
				else {
					String str="课程号："+tf1.getText()+" ，课程名称："+tf2.getText()+" ，课程地点："+tf3.getText()+" ，课程时间："+tf4.getText()+"；"+"授课教师:工号："+tf5.getText()+" ,姓名："+tf6.getText()+" ,性别："+tf6.getText()+"。";
					file.writeFile("course",str);
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		JButton btn2=new JButton("退出");
		btn2.setBounds(180, 290, 60, 30);
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(lb1);
		panel2.add(lb2);
		panel2.add(lb3);
		panel2.add(lb4);
		panel2.add(lb5);
		panel2.add(lb6);
		panel2.add(lb7);
		panel2.add(tf1);
		panel2.add(tf2);
		panel2.add(tf3);
		panel2.add(tf4);
		panel2.add(tf5);
		panel2.add(tf6);
		panel2.add(tf7);
		this.add(panel2);
	}
}
