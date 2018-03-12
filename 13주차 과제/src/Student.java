
public class Student {
	private String StudentNo;
	private Subject _korean;
	private Subject _english;
	private Subject _computer;
	private double _GPA;
	
	public Student(){
		this.StudentNo = new String();
		this._korean = new Subject();
		this._english = new Subject();
		this._computer = new Subject();
		this._GPA = 0.0;
	}
	
	public void setStudentNo(String studentNo){
		this.StudentNo  = studentNo;
	}
	
	public String studentNo(){
		return this.StudentNo;
	}
	
	public void setKorean(Subject aSubject){
		this._korean = aSubject;
	}
	
	public Subject korean(){
		return this._korean;
	}
	
	public void setEnglish(Subject aSubject){
		this._english = aSubject;
	}
	
	public Subject english(){
		return this._english;
	}
	
	public void setCompuer(Subject aSubject){
		this._computer = aSubject;
	}
	
	public Subject computer(){
		return this._computer;
	}
	
	public void setGPA(double aGPA){
		this._GPA = aGPA / 3;
	}
	
	public double GPA(){
		return this._GPA;
	}
	
}
