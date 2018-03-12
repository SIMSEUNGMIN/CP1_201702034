import java.util.Scanner;

public class AppController {
	private static final int MAXSTUDENTS = 50;
	private Scanner _scanner;
	private Ban _ban;
	
	public AppController(){
		this._scanner = new Scanner(System.in);
		this._ban = new Ban(MAXSTUDENTS);
	}
	
	private void inputAndStoreStudentInfo(){
		boolean moreStudentsExist;
		Student currentStudent = null;
		int score;
		String studentNo = null;
		
		moreStudentsExist = inputMoreStudentsExist();
		
		while(moreStudentsExist && (!this._ban.isFull())){
			studentNo = inputStudentNo();
			score = inputScore();
			
			if (score < 0 || score > 100){
				System.out.println("0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.");
			}
			else{
				currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				this._ban.addStudent(currentStudent);
			}
			
			moreStudentsExist = inputMoreStudentsExist();
		}
		
		System.out.println("입력을 종료합니다.\n");
	}
	
	private boolean inputMoreStudentsExist(){
		char input;
				
				System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'을 치시오 : ");
				input = _scanner.next().charAt(0);
				
				if ((input == 'Y') || (input == 'y')){
					return true;
				}
				else{
					return false;
				}
	}
	
	private String inputStudentNo(){
		String input = null;
		
		System.out.print("- 학번을 입력하시오 : ");
		input = _scanner.next();
		
		return input;
	}
	
	private int inputScore(){
		int input;
		
		System.out.print("- 점수를 입력하시오 : ");
		input = _scanner.nextInt();
		
		return input;
	}
	

	private void showStudentsInfo(){
		Student aStudent = null;
		
		System.out.println("학생들의 성적 목록입니다.");
		
		for(int i = 0; i < this._ban.numberofStudents(); i++){
			aStudent = this._ban.studentWithOrderOf(i);
			System.out.println("학번 : " + aStudent.studentNo() + ", 점수 : " + aStudent.score() + ", 학점 : " + aStudent.grade());
		}
	}
	
	private void showAverageInfo(){
		Student aStudent = null;
		int i = 0;
		
		
		System.out.println("\n평균 점수는 " + this._ban.average() + "입니다.");
		System.out.println("평균 이상인 학생은 모두  " + this._ban.numberofStudentsWithAboveAverage() + "명 입니다.");
		
		while(i < this._ban.numberofStudents()){
			
			aStudent = this._ban.studentWithOrderOf(i);
			if(aStudent.score() >= this._ban.average()){
				System.out.println("학번 : " + aStudent.studentNo() + ", 점수 : " + aStudent.score() + ", 학점 : " + aStudent.grade());
			}
			else{}
			
			i++;
		}
		
	}
	
	private void showGradeInfo(){
		
		System.out.println("\nA학점은 모두 " + this._ban.numberofStudentforGradeA() + "명 입니다.");
		System.out.println("B학점은 모두 " + this._ban.numberofStudentforGradeB() + "명 입니다.");
		System.out.println("C학점은 모두 " + this._ban.numberofStudentforGradeC() + "명 입니다.");
		System.out.println("D학점은 모두 " + this._ban.numberofStudentforGradeD() + "명 입니다.");
		System.out.println("F학점은 모두 " + this._ban.numberofStudentforGradeF() + "명 입니다.");
		
		
	}
	
	public void run(){
		
		this.inputAndStoreStudentInfo();
		this.showStudentsInfo();
		this._ban.calAverageInfo();
		this.showAverageInfo();
		this._ban.countStudentsByGrade();
		this.showGradeInfo();
		
		System.out.println("\n프로그램을 종료합니다.");
	}
	
		
}

	
	