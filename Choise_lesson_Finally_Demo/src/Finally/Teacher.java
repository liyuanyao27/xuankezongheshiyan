package Finally;

public class Teacher extends People{
	String teachsub;
	public Teacher(String id, String name, String sex,String teachsub) {
		super(id, name, sex);
		this.teachsub=teachsub;
	}
	public String toString() {
		return "\n"+"�ڿν�ʦ:���ţ�"+id+" ,������"+name+" ,�Ա�"+sex+"��";
	}
}