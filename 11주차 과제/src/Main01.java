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
		
		
		System.out.println("프로그램을 종료합니다.");
	}
	
	private static boolean inputMoreStudentExist(){
		char input;
		
		System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'를 치시오 : ");
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
		
		System.out.print("- 학번을 입력하시오 : ");
		input = aScanner.next();
		
		return input;
	}
	
	private static int inputScore(){
		
		int input;
		System.out.print("- 점수를 입력하시오 : ");
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
				System.out.println("오류 : 0보다 작거나 100보다 커서, 정상적인 점수가 아닙니다.");
			}
			else{
				currentStudent = new Student();
				currentStudent.setStudentNo(studentNo);
				currentStudent.setScore(score);
				addStudent(currentStudent);
			}
			moreStudentExist = inputMoreStudentExist();
		}
		
		System.out.println("입력을 종료합니다.\n");
	}
	
	private static void  showStudentinfo(){
		
		System.out.println("학생들의 성적 목록 입니다.");
		int count = 0;
		while (count < numberofStudent){
			System.out.println("학번 : " + c1[count].studentNo() + ", 점수 : " + c1[count].score() + ", 학점 : " + c1[count].grade());
			total = total + c1[count].score();
			count++;
		}
	}
	
	private static void CalAverage(){
		
		average = (double)total/(double)(numberofStudent);
		System.out.println("평균점수는 " + average + "입니다.");
	}
	
	private static void showAverageinfo(){
		int count = 0;
		while(count < numberofStudent){
			if(c1[count].score() >= average){
				adoveAverage ++;
			}
			count++;
		}
		System.out.println("평균 이상인 학생 수는 모두 " + adoveAverage + "명 입니다.\n");
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
		
		System.out.println("A학점은 모두 " + numberofGradeA + "명 입니다.");
		System.out.println("B학점은 모두 " + numberofGradeB + "명 입니다.");
		System.out.println("C학점은 모두 " + numberofGradeC + "명 입니다.");
		System.out.println("D학점은 모두 " + numberofGradeD + "명 입니다.");
		System.out.println("F학점은 모두 " + numberofGradeF + "명 입니다.\n");
	}
	
	private static void addStudent(Student student){
		c1[numberofStudent] = student;
		numberofStudent ++;
	}
}
