
public class Ban {
	private int _maxNumberOfStudents;
	private int _numberofStudents;
	private Student[] _students;
	private double _classAverageGPA;
	private int _numberofStudentsAboveAverageGPA;
	
	public Ban(int givenMaxNumberofStudents){
		this._maxNumberOfStudents = givenMaxNumberofStudents;
		this._numberofStudents = 0;
		this._students = new Student[givenMaxNumberofStudents];
		this._classAverageGPA = 0.0;
		this._numberofStudentsAboveAverageGPA = 0;
	}
	
	public boolean isFull(){
		if(this._numberofStudents > this._maxNumberOfStudents){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isEmpty(){
		if(this._numberofStudents == 0){
			return true;
		}
		else return false;
	}
	
	public int maxNumberofStudents(){
		return this._maxNumberOfStudents;
	}
	
	public int numberofStudents(){
		return this._numberofStudents;
	}
	
	public double classAverageGPA(){
		return this._classAverageGPA;
	}
	
	public int numberofStudentsAboveAverageGPA(){
		return this._numberofStudentsAboveAverageGPA;
	}
	
	public void addStudent(Student aStudent){
		this._students[this._numberofStudents] = aStudent;
		this._numberofStudents ++;
	}
	
	public Student studentWithOrderOf(int i_th){
		return this._students[i_th];
	}
	
	public void processScores(){ //GPA계산, GPA 넘는 학생수 계산
		double sum = 0;
		
		for(int i = 0; i < this._numberofStudents; i++){
			sum = sum + this._students[i].GPA();
		}
		
		this._classAverageGPA = sum / this._numberofStudents;
		
		for(int i = 0; i < this._numberofStudents; i++){
			if(this._students[i].GPA() >= this._classAverageGPA){
				this._numberofStudentsAboveAverageGPA ++;
			}
		}
		
	}

}
