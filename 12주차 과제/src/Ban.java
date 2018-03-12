
public class Ban {
	private int _capacity;
	private int numberofStudents;
	private Student[] _students;
	private double _average;
	private int _numberofStudentswithAboveAverage;
	private int _numberofStudentforGradeA;
	private int _numberofStudentforGradeB;
	private int _numberofStudentforGradeC;
	private int _numberofStudentforGradeD;
	private int _numberofStudentforGradeF;
	
	public Ban(int givenCapacity){
		this._capacity = givenCapacity;
		this.numberofStudents = 0;
		this._students = new Student[givenCapacity];
		
		this._average = 0;
		this._numberofStudentswithAboveAverage = 0;
		
		this._numberofStudentforGradeA = 0;
		this._numberofStudentforGradeB = 0;
		this._numberofStudentforGradeC = 0;
		this._numberofStudentforGradeD = 0;
		this._numberofStudentforGradeF = 0;
	}
	
	public boolean isFull(){
		if(this.numberofStudents < this._capacity){
			return false;
		}
		else{
			return true;
		}
	}
	
	public int capacity(){
		return this._capacity;
	}
	
	public int numberofStudents(){
		return this.numberofStudents;
	}
	
	public Student studentWithOrderOf (int i_th){
		return this._students[i_th];
	}
	
	public void addStudent (Student aStudent){
		this._students[this.numberofStudents] = aStudent;
		this.numberofStudents ++;
	}
	
	public void calAverageInfo(){
		int count = 0;
		int total = 0;
		
		
		while(count < this.numberofStudents){
			total =  total + this._students[count].score();
			count ++;
		}
		
		this._average = (double)total / (double)this.numberofStudents;
		
		count = 0;
		
		while(count < this.numberofStudents){
			if(this._students[count].score() >= this._average){
				this._numberofStudentswithAboveAverage ++;
			}
			
			count++;
		}
		
	}
	
	public double average(){
		return this._average;
	}
	
	public int numberofStudentsWithAboveAverage(){
		return this._numberofStudentswithAboveAverage;
	}
	
	public void countStudentsByGrade(){
		int count = 0;
		
		while (count < this.numberofStudents){
			if(this._students[count].grade() == 'A'){
				this._numberofStudentforGradeA++;
			}
			else if(this._students[count].grade() == 'B'){
				this._numberofStudentforGradeB ++;
			}
			else if(this._students[count].grade() == 'C'){
				this._numberofStudentforGradeC ++;
			}
			else if(this._students[count].grade() == 'D'){
				this._numberofStudentforGradeD ++;
			}
			else{
				this._numberofStudentforGradeF ++;
			}
			
			count ++;
		}
	}
	
	public int numberofStudentforGradeA(){
		return this._numberofStudentforGradeA;
	}
	
	public int numberofStudentforGradeB(){
		return this._numberofStudentforGradeB;
	}
	
	public int numberofStudentforGradeC(){
		return this._numberofStudentforGradeC;
	} 
	
	public int numberofStudentforGradeD(){
		return this._numberofStudentforGradeD;
	}
	
	public int numberofStudentforGradeF(){
		return this._numberofStudentforGradeF;
	}

}
