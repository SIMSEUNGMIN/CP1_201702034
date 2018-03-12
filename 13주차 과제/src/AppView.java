import java.util.Scanner;

public class AppView { //출력 관련 함수
	private static Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public boolean inputMoreStudentsExist(){
		char input;
		System.out.print("? 학생정보를 입력하려면 'Y'를, 입력을 종료하려면 'N'를 치시오 : ");
		input = _scanner.next().charAt(0);
		if(input == 'Y' || input == 'y'){
			return true;
		}
		else return false;
	}
	
	public String inputStudentNo(){
		String input = new String();
		
		System.out.print("학번을 입력하시오 : ");
		input = _scanner.next();
		
		return input;
	} 
	
	public int inputScore(String Subjectname){
		System.out.print("- " + Subjectname +"를 입력하시오 : ");
		int input = _scanner.nextInt();
		
		while((input < 0) || (input > 100)){
			System.out.println("[오류] 정상 범위(0~100)의 점수가 아닙니다. 다시 입력하시오.");
			
			System.out.print("- " + Subjectname +"를 입력하시오 : ");
			input = _scanner.nextInt();
			
		}
		
		return input;
	}
	
	public void outputStudentinfo(Student aStudent){ //학생들의 성적 목록 출력
		System.out.println("학번 : " + aStudent.studentNo() + ", 국어 : " + aStudent.korean().score() + "(" + aStudent.korean().grade()+ ")" + ", 영어 : " + aStudent.english().score() + "(" + aStudent.english().grade() + ")" + ", 컴퓨터 : " + aStudent.computer().score() + "(" + aStudent.computer().grade() + ")" + ", 평균평점 : " + aStudent.GPA());
	}
	
	public void outputAverageInfo(double aClassAveragePoint, int numberofStudentsAboveAverageGPA){ //평균 출력
		System.out.println("\n학급의 평균평점은 " + aClassAveragePoint + "점 입니다.");
		System.out.println("평균 평점 이상인 학생수는 " + numberofStudentsAboveAverageGPA + "명 입니다.\n");
	}
	
	public void outputMessage(String aMessage){
		System.out.println(aMessage);
	}
	
	
}
