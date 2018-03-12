import java.util.Scanner;

public class Main01 {
	
	private static Scanner aScanner = new Scanner(System.in);
	private static final int MAXSTUDENTS =50;
	private static Student[] c1;
	private static int numberofStudent = 0;
	private static double average;
	private static int total = 0;
	private static int adoveAverage = 0;
	private static int numberofGradeA = 0;
	private static int numberofGradeB = 0;
	private static int numberofGradeC = 0;
	private static int numberofGradeD = 0;
	private static int numberofGradeF = 0;
	
	public static void main(String[] args) {
		
		c1 = new Student[MAXSTUDENTS];
		
		inputAndStoreStudentinfo();
		showStudentinfo();
		System.out.println();
		CalAverage();
		showAverageinfo();
		countStudentsByGrade();
		showGradeinfo();
		
		
		System.out.println("���α׷��� �����մϴ�.");
	}
	
	private static boolean inputMoreStudentExist(){
		char input;
		
		System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ� : ");
		input = aScanner.next().charAt(0);
		
		if((input == 'Y') || (input == 'y')){
			return true;
		}
		else{
			return false;
		}
	}
	
	private static String inputStudentNo(){
		String input = null;
		input = new String();
		
		System.out.print("- �й��� �Է��Ͻÿ� : ");
		input = aScanner.next();
		
		return input;
	}
	
	private static int inputScore(){
		
		int input;
		System.out.print("- ������ �Է��Ͻÿ� : ");
		input = aScanner.nextInt();
		System.out.println("");
		
		return input;
	}
	
	private static void inputAndStoreStudentinfo(){
		Student currentStudent = null;
		String studentNo = null;
		studentNo = new String();
		int score = 0;
		
		
		boolean moreStudentExist = inputMoreStudentExist();
		
		while(moreStudentExist && numberofStudent < MAXSTUDENTS){
			studentNo = inputStudentNo();
			score = inputScore();
			
			if(score < 0 || score > 100){
				System.out.println("���� : 0���� �۰ų� 100���� Ŀ��, �������� ������ �ƴմϴ�.");
			}
			else{
				currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				addStudent(currentStudent);
			}
			moreStudentExist = inputMoreStudentExist();
		}
		
		System.out.println("�Է��� �����մϴ�.\n");
	}
	
	private static void  showStudentinfo(){
		
		System.out.println("�л����� ���� ��� �Դϴ�.");
		int count = 0;
		while (count < numberofStudent){
			System.out.println("�й� : " + c1[count].studentNo() + ", ���� : " + c1[count].score() + ", ���� : " + c1[count].grade());
			total = total + c1[count].score();
			count++;
		}
	}
	
	private static void CalAverage(){
		
		average = (double)total/(double)(numberofStudent);
		System.out.println("��������� " + average + "�Դϴ�.");
	}
	
	private static void showAverageinfo(){
		int count = 0;
		while(count < numberofStudent){
			if(c1[count].score() >= average){
				adoveAverage ++;
			}
			count++;
		}
		System.out.println("��� �̻��� �л� ���� ��� " + adoveAverage + "�� �Դϴ�.\n");
	}

	private static void countStudentsByGrade(){
		char currentGrade;
		
		for(int i = 0; i < numberofStudent; i++){
			currentGrade = c1[i].grade();
			if(currentGrade == 'A'){
				numberofGradeA ++;
			}
			else if(currentGrade == 'B'){
				numberofGradeB ++;
			}
			else if(currentGrade == 'C'){
				numberofGradeC ++;
			}
			else if(currentGrade == 'D'){
				numberofGradeD ++;
			}
			else{
				numberofGradeF ++;
			}
		}
	}
	
	private static void showGradeinfo(){
		
		System.out.println("A������ ��� " + numberofGradeA + "�� �Դϴ�.");
		System.out.println("B������ ��� " + numberofGradeB + "�� �Դϴ�.");
		System.out.println("C������ ��� " + numberofGradeC + "�� �Դϴ�.");
		System.out.println("D������ ��� " + numberofGradeD + "�� �Դϴ�.");
		System.out.println("F������ ��� " + numberofGradeF + "�� �Դϴ�.\n");
	}
	
	private static void addStudent(Student student){
		c1[numberofStudent] = student;
		numberofStudent ++;
	}
}
