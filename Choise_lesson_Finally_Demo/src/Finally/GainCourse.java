package Finally;


public class GainCourse {
	public String[] gainCourse() {
		Teacher teaone=new Teacher("001","��","��","��ѧ");
		Teacher teatwo=new Teacher("002","ţ","Ů","����");
		Teacher teathree=new Teacher("003","��","��","����");
		Teacher teafour=new Teacher("004","��","Ů","��ѧ");
		Teacher teafive=new Teacher("005","ѩ","��","Ӣ��");
		Course subone=new Course("1","��ѧ","��һ����","8:00",teaone);
		Course subtwo=new Course("2","����","�ڶ�����","9:00",teatwo);
		Course subthree=new Course("3","����","��������","10:00",teathree);
		Course subfour=new Course("4","��ѧ","���Ľ���","11:00",teafour);
		Course subfive=new Course("5","Ӣ��","���޽���","12:00",teafive);
		String [] Courses= new String[20];
		Courses[0]=subone.toString();
		Courses[1]=subtwo.toString();
		Courses[2]=subthree.toString();
		Courses[3]=subfour.toString();
		Courses[4]=subfive.toString();
		Object_in_out file=new Object_in_out();
		for(int i=0;i<file.readFile("course").split("��").length;i++) {
			Courses[i+5]=file.readFile("course").split("��")[i]+"��";
		}
		return Courses;
		}
}