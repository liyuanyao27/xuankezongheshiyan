package Finally;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame{
	public static void main(String args[]) {
		Login demo = new Login();
    }
	 public Login() {
	        init();
	        this.setTitle("学生选课系统");
			this.setBounds(400, 150, 469, 300);;
			this.setVisible(true);}
	 
	public void init() {
		Object_in_out file=new Object_in_out();
		JFrame frame=new JFrame();
		frame.setTitle("choice");
		JPanel panel2=new JPanel();
		panel2.setLayout(null);

		JLabel lb2=new JLabel("学号：");
		lb2.setBounds(32, 50, 100, 30);
		JTextField tf2=new JTextField(20);
		tf2.setBounds(99, 51, 323, 30);
		JLabel lb3=new JLabel("密码：");
		lb3.setBounds(32, 90, 200, 30);
		JTextField ps=new JTextField(10);
		ps.setBounds(100, 91, 323, 30);
		JButton btn1=new JButton("登录");
		btn1.setBounds(213, 159, 60, 44);
		btn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
			return;
		}
		if(file.readFile("Admin").contains(tf2.getText()+","+ps.getText())){
			file.writeFile("identify",tf2.getText());
			JOptionPane.showMessageDialog(null, "登录成功");
			Frame_index choice=new Frame_index();
			setVisible(false);
		}
		

		if(file.readFile("Admin").contains(ps.getText())==false&&file.readFile("Admin").contains(tf2.getText())) {
			JOptionPane.showMessageDialog(null, "密码错误");
		}
		if(file.readFile("Admin").contains(tf2.getText())==false) {
			JOptionPane.showMessageDialog(null, "用户名不存在，请先注册再进行登录！");
		}
	}
});
		JButton btn2=new JButton("注册");
		btn2.setBounds(100, 159, 60, 44);
		btn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
			return;
		}

		else{
			file.writeFile("Admin",tf2.getText()+","+new String(ps.getText())+"。");
			JOptionPane.showMessageDialog(null, "注册成功！");}}}
		);
		JButton btn3 = new JButton();
		btn3.setText("重置");
		btn3.setBounds(324, 159, 60, 44);
		btn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
			tf2.setText("");
			ps.setText("");
		}
	});
		panel2.add(btn1);
		panel2.add(btn2);
		panel2.add(btn3);

		panel2.add(lb2);
		panel2.add(lb3);

		panel2.add(tf2);
		panel2.add(ps);
		getContentPane().add(panel2);
	}}
