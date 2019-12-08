# 学生选课系统综合实验


[系统主页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095922.png?raw=true)
[选课页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095952.png?raw=true)
[选课成功页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100023.png?raw=true)  
[打印课表](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100041.png?raw=true)
[退课界面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100623.png?raw=true)
[退课成功](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100716.png?raw=true)
[打印课表2](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100812.png?raw=true)
[添加课程](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208101244.png?raw=true)  
#### 本选课系统可以实现的主要功能：  
1.学生登录，学生注册  
2.学生选课  
3.学生退课  
4.打印课表  
5.将登陆的学生所进行的操作保存至文档内登陆后会读取出此学生的信息（序列化，反序列化）



### 一.程序中类的定义  
1.架构与最开始的程序没有什么变化，对其进行了优化，将无用成员方法去掉。People作为父类，Student和Teacher继承了People类。
2.People类包含属性id,name,sex。其子类除其父类包含属性外，Student包含Course类对象，需要将课程对象传进成员方法进行传递。Teacher包含属性teachcour。  
### 二.界面
本次系统大幅度升级，加入了登录界面，主界面，选课界面，退课界面，添加课程界面。
##### 1.登录界面  
![登录界面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095752.png?raw=true)  
登陆界面内有两个文本输入框，三个按钮，运用了监听器，当按下登录后可以读取已注册的账户，判断密码和账号是否匹配。注册账号即用此用户名和密码进行注册。  
```		btn1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg0) {
		if(tf2.getText().trim().length()==0||ps.getText().length()==0){
			JOptionPane.showMessageDialog(null, "用户名密码不允许为空");
			return;}
		if(file.readFile("Admin").contains(tf2.getText()+","+ps.getText())){
			file.writeFile("identify",tf2.getText());
			JOptionPane.showMessageDialog(null, "登录成功");
			Frame_index choice=new Frame_index();
			setVisible(false);}
		if(file.readFile("Admin").contains(ps.getText())==false&&file.readFile("Admin").contains(tf2.getText())) {
			JOptionPane.showMessageDialog(null, "密码错误");}
		if(file.readFile("Admin").contains(tf2.getText())==false) {
			JOptionPane.showMessageDialog(null, "用户名不存在，请先注册再进行登录！");}}});
```
上面的程序是我的登录按钮监听器，当点击登录按钮后会与***Admin***文件中已保存的用户名和密码进行比较。若有相同的则转到下一个界面，既主界面  
`Frame_index choice=new Frame_index();`  
注册很简单，只要写入文件即可。  
![登录成功](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095902.png?raw=true "登陆成功")
##### 2.主界面

