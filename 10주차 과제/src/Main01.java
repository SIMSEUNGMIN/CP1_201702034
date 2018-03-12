import java.util.Scanner;

public class Main01 {
	private static Scanner aScanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Student student = new Student();
		GPACounter gpacounter = new GPACounter();

		int Korean_score;
		int English_score;
		int Computer_score;
		
		System.out.print("> 세 과목 (국어, 영어, 컴퓨터) 의 점수를 차례로 입력합니다. :");
		Korean_score = inputScore();
		English_score = inputScore();
		Computer_score = inputScore();
		
		while((Korean_score >= 0) && (English_score >= 0) && (Computer_score >= 0)){
			if((Korean_score > 100) || (English_score > 100) || (Computer_score > 100)){
				System.out.println("오류 : 100이 넘어서, 정상적인 점수가 아닙니다.");
			}
			else{
				student.setScoreKorean(Korean_score);
				student.setScoreEnglish(English_score);
				student.setScoreComputer(Computer_score);
				gpacounter.count(student.gpa());
				
				System.out.println("[국   어] : " + student.scoreKorean() + ", 학점 : " + student.gradeKorean() + ", 평점 : " + student.pointKorean());
				System.out.println("[영   어] : " + student.scoreEnglish() + ", 학점 : " + student.gradeEnglish() + ", 평점 :" + student.pointEnglish());
				System.out.println("[컴퓨터] : " + student.scoreComputer() + ", 학점 : " + student.gradeComputer() + ", 평점 : " + student.pointComputer());
				System.out.println("이 학생의 평균 평점은 " + student.gpa() + "입니다.");
			}
			
			System.out.print("> 세 과목 (국어, 영어, 컴퓨터) 의 점수를 차례로 입력합니다. :");
			Korean_score = inputScore();
			English_score = inputScore();
			Computer_score = inputScore();
			
		}
		
		System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");
		
		System.out.println("평균평점이 3.0 이상인 학생은 " + gpacounter.numberOFGPA3() + "명 입니다.");
		System.out.println("평균평점이 2.0 이상 3.0 미만인 학생은 " + gpacounter.numberOFGPA2() + "명 입니다.");
		System.out.println("평균평점이 1.0 이상 2.0 미만인 학생은 " + gpacounter.numberOFGPA1() + "명 입니다.");
		System.out.println("평균평점이 1.0 미만인 학생은 " + gpacounter.numberOFGPA0() + "명 입니다.");
		System.out.println("프로그램을 종료합니다.");

	}
	
	private static int inputScore(){
		
		return aScanner.nextInt();
		
	}

}
