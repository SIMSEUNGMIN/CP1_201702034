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
				System.out.println("0���� �۰ų� 100���� Ŀ��, �������� ������ �ƴմϴ�.");
			}
			else{
				currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				this._ban.addStudent(currentStudent);
			}
			
			moreStudentsExist = inputMoreStudentsExist();
		}
		
		System.out.println("�Է��� �����մϴ�.\n");
	}
	
	private boolean inputMoreStudentsExist(){
		char input;
				
				System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ� : ");
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
		
		System.out.print("- �й��� �Է��Ͻÿ� : ");
		input = _scanner.next();
		
		return input;
	}
	
	private int inputScore(){
		int input;
		
		System.out.print("- ������ �Է��Ͻÿ� : ");
		input = _scanner.nextInt();
		
		return input;
	}
	

	private void showStudentsInfo(){
		Student aStudent = null;
		
		System.out.println("�л����� ���� ����Դϴ�.");
		
		for(int i = 0; i < this._ban.numberofStudents(); i++){
			aStudent = this._ban.studentWithOrderOf(i);
			System.out.println("�й� : " + aStudent.studentNo() + ", ���� : " + aStudent.score() + ", ���� : " + aStudent.grade());
		}
	}
	
	private void showAverageInfo(){
		Student aStudent = null;
		int i = 0;
		
		
		System.out.println("\n��� ������ " + this._ban.average() + "�Դϴ�.");
		System.out.println("��� �̻��� �л��� ���  " + this._ban.numberofStudentsWithAboveAverage() + "�� �Դϴ�.");
		
		while(i < this._ban.numberofStudents()){
			
			aStudent = this._ban.studentWithOrderOf(i);
			if(aStudent.score() >= this._ban.average()){
				System.out.println("�й� : " + aStudent.studentNo() + ", ���� : " + aStudent.score() + ", ���� : " + aStudent.grade());
			}
			else{}
			
			i++;
		}
		
	}
	
	private void showGradeInfo(){
		
		System.out.println("\nA������ ��� " + this._ban.numberofStudentforGradeA() + "�� �Դϴ�.");
		System.out.println("B������ ��� " + this._ban.numberofStudentforGradeB() + "�� �Դϴ�.");
		System.out.println("C������ ��� " + this._ban.numberofStudentforGradeC() + "�� �Դϴ�.");
		System.out.println("D������ ��� " + this._ban.numberofStudentforGradeD() + "�� �Դϴ�.");
		System.out.println("F������ ��� " + this._ban.numberofStudentforGradeF() + "�� �Դϴ�.");
		
		
	}
	
	public void run(){
		
		this.inputAndStoreStudentInfo();
		this.showStudentsInfo();
		this._ban.calAverageInfo();
		this.showAverageInfo();
		this._ban.countStudentsByGrade();
		this.showGradeInfo();
		
		System.out.println("\n���α׷��� �����մϴ�.");
	}
	
		
}

	
	