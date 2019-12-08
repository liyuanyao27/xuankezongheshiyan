# 学生选课系统综合实验





#### 本选课系统可以实现的主要功能：  
1.学生登录，学生注册  
2.学生选课  
3.学生退课  
4.打印课表  
5.将登陆的学生所进行的操作保存至文档内登陆后会读取出此学生的信息  
6.添加课程



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
主界面的设计很简单，运用绝对位置把四个按钮分为东南东北西北西南四个位置，在位置上放上按钮。  
![系统主页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095922.png?raw=true)
这部分编程比较简单只需要创界页面，在页面添加按钮，给四个按钮添加上监听器即可。举其中一例  
```		JButton btn1=new JButton("学生选课");
		btn1.setBounds(36, 56, 138, 88);
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			ChoiseCourse choice=new ChoiseCourse();
			}
		});
```
上述程序为学生选课按钮（西北按钮）一例，创建对象后创建监听器，当按钮有动作后会创建新的对象，选课窗口会被打开。  



##### 3.选课界面  
![选课页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208095952.png?raw=true)  
选课界面由两部分构成，一个是JList另外是按钮部分，按钮部分包含两个按钮一个是确认选课按钮，另一个是退出界面的按钮。  
这部分的窗体建立都很简单，比较难的是如何进行参数传递，即怎么将我选的课程加入Student中的属性Course中，后来在同学的启发下我有了一个新的想法。要不就不传参数了，直接将我选的科目保存在文件里，然后需要的时候直接读取，非常方便。
```		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "您未选择课程，请选择课程后再点击");
					return;
				}
				for(int i=0;i<s2.length;i++) {
                if(list.isSelectedIndex(i)&&file.readFile(file.readFile("identify")).contains(s1[i])==false) {
						s2[i]=s1[i];}}
			file.WriteFile(s2,file.readFile("identify"));
				JOptionPane.showMessageDialog(null, "选课成功");
				setVisible(false);}});
```
以上是我的处理方法，关于readFile和writeFile函数在下面的文件处理大块中会介绍。
![选课成功页面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100023.png?raw=true)  

###### 4.打印课表界面  
打印界面也由两部分组成，JList和Button。JList会读取文件中已保存的选课内容，如果没有显示空。之前我们已经选过课了，那我们来看一下选课后的打印界面。  
![打印课表](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100041.png?raw=true)  
这部分除了退出按钮使用了监听器外，其他的在实例化时就已经生成。故这部分只是对JList的又一次应用。  


###### 5.退课界面  
![退课界面](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100623.png?raw=true)  
退课界面由两部分构成，一个是JList另外是按钮部分，按钮部分包含两个按钮一个是确认退课按钮，另一个是退出界面的按钮。  
若是没有选课在List框内是空的。退课的原理是在用户文件中将课程删除，这样用户文件为空，未选课。  
```
		btn1.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent arg0) {
				String[] s2=file.readFile(file.readFile("identify")).split("。");
				if(list.isSelectionEmpty()){
					JOptionPane.showMessageDialog(null, "未退课");
					return;
				}
				for(int i=0;i<s2.length;i++) {
					if(list.isSelectedIndex(i)) {//判断课程是否被选中
						s2[i]=null;//课程信息置为空
					}
					else {
						s2[i]=s2[i]+"。";
					}
				}
				file.WriteFile(s2,file.readFile("identify"));
				JOptionPane.showMessageDialog(null, "退课成功！");
				setVisible(false);
			}
		});

```  

![退课成功](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100716.png?raw=true)  


完成后文件中的内容被删除，若打印课表会出现以下情况。  

![打印课表2](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208100812.png?raw=true)

##### 6.添加课程界面  

![添加课程](https://github.com/liyuanyao27/xuankezongheshiyan/blob/master/%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20191208101244.png?raw=true)  
图片如上，非常简单，加入TextArea即可，按钮有两个，一个确认添加，一个退出界面。限制输入我认为用异常处理过于麻烦，判断异常后抛出异常，再catch异常，不如直接用if语句限制输入，简洁方便。
```
btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				String[] s4={"男","女"};
				if(tf1.getText().trim().length()==0||tf2.getText().trim().length()==0||tf3.getText().trim().length()==0||tf4.getText().trim().length()==0||tf5.getText().trim().length()==0||tf6.getText().trim().length()==0||tf6.getText().trim().length()==0) {

					JOptionPane.showMessageDialog(null, "信息不能为空！");
					return;
				}
				else {
					String str="课程号："+tf1.getText()+" ，课程名称："+tf2.getText()+" ，课程地点："+tf3.getText()+" ，课程时间："+tf4.getText()+"；"+"授课教师:工号："+tf5.getText()+" ,姓名："+tf6.getText()+" ,性别："+tf6.getText()+"。";
					file.writeFile("course",str);
					JOptionPane.showMessageDialog(null, "选课成功");
				}
			}
		});
```  
这里限制了信息不能为空。  

### 三.文件的输入输出  
这一块比较麻烦，因为串起了整个程序，我写了三个方法一个是writeFile另一个是readFile，还有个一个WriteFile，作用看名字就能看出来了。需要自己定一个目录，在目录里可以寻找到给定文件名的txt文件，写入和读入。两个写入是给不同的窗体使用的。详情请见主程序。  




### 四.总结  
这次实验是一个综合性试验，非常考验学生的综合能力。我在这个实验中总结方法思考方法，有想到用二维数组和二维Map储存信息，但是比较难以实现，最后我使用了直接读取输出，这样方便简洁，并且内存占用较小。这次基本上把之前学习到的知识都用上了，让我对java的面向对象的程序设计有了更多的理解。
