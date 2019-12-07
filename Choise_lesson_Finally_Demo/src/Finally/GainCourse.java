package Finally;


public class GainCourse {
	public String[] gainCourse() {
		Teacher teaone=new Teacher("001","李","男","数学");
		Teacher teatwo=new Teacher("002","牛","女","物理");
		Teacher teathree=new Teacher("003","王","男","生物");
		Teacher teafour=new Teacher("004","陈","女","化学");
		Teacher teafive=new Teacher("005","雪","男","英语");
		Course subone=new Course("1","数学","第一教室","8:00",teaone);
		Course subtwo=new Course("2","物理","第二教室","9:00",teatwo);
		Course subthree=new Course("3","生物","第三教室","10:00",teathree);
		Course subfour=new Course("4","化学","第四教室","11:00",teafour);
		Course subfive=new Course("5","英语","第无教室","12:00",teafive);
		String [] Courses= new String[20];
		Courses[0]=subone.toString();
		Courses[1]=subtwo.toString();
		Courses[2]=subthree.toString();
		Courses[3]=subfour.toString();
		Courses[4]=subfive.toString();
		Object_in_out file=new Object_in_out();
		for(int i=0;i<file.readFile("course").split("。").length;i++) {
			Courses[i+5]=file.readFile("course").split("。")[i]+"。";
		}
		return Courses;
		}
}