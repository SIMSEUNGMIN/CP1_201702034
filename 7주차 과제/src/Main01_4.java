import java.util.Scanner;

public class Main01_4 {
	static Scanner aScanner = new Scanner(System.in);

	public static void main(String[] args) {
		//   평균 평점 계산 함수
		int Korean_Score, English_Score, Computer_Score;
		char Korean_Grade, English_Grade, Computer_Grade;
		double Korean_Point, English_Point, Computer_Point;
		double gpa;
		int count4 = 0;
		int count3 = 0;
		int count2 = 0;
		int count1 = 0;
		int count0 = 0;
		
		System.out.print("> 세 과목 (국어, 영어, 컴퓨터)의 점수를 차례로 입력하시오 : ");
		Korean_Score = inputScore();
		English_Score = inputScore();
		Computer_Score = inputScore();
		
		while((Korean_Score >= 0) && (English_Score >= 0) && (Computer_Score >= 0)){
			if((Korean_Score > 100) || (English_Score > 100) || (Computer_Score > 100)){
				System.out.println("오류 : 100이 넘어서, 정상적인 점수가 아닙니다.");
			}
			else{
				Korean_Grade = score2Grade(Korean_Score);
				English_Grade = score2Grade(English_Score);
				Computer_Grade = score2Grade(Computer_Score);
				
				Korean_Point = grade2Point(Korean_Grade);
				English_Point = grade2Point(English_Grade);
				Computer_Point = grade2Point(Computer_Grade);
				
				gpa = calcGPA(Korean_Point, English_Point, Computer_Point);
				
				if (gpa >= 4.0){
					count4 ++;
				}
				else if(gpa >= 3.0){
					count3 ++;
				}
				else if(gpa >= 2.0){
					count2 ++;
				}
				else if(gpa >= 1.0){
					count1 ++;
				}
				else{
					count0 ++;
				}
				
				System.out.println("[국   어] 점수 : " + Korean_Score + ", 학점 : " + Korean_Grade + ", 평점 : " + Korean_Point);
				System.out.println("[영   어] 점수 : " + English_Score + ", 학점 : " + English_Grade + ", 평점 : " + English_Point);
				System.out.println("[컴퓨터] 점수 : " + Computer_Score + ", 학점 : " + Computer_Grade + ", 평점 : " + Computer_Point);
				System.out.println("이 학생의 평균 평점은 " + gpa + " 입니다.");
				
				
			}
			
			System.out.print("> 세 과목 (국어, 영어, 컴퓨터)의 점수를 차례로 입력하시오 : ");
			Korean_Score = inputScore();
			English_Score = inputScore();
			Computer_Score = inputScore();
		}
		
		System.out.println("음의 점수가 입력되어 입력을 종료합니다.\n");
		
		System.out.println("평균 평점이 4.0 이상인 학생은 " + count4 + "명 입니다.");
		System.out.println("평균 평점이 3.0 이상 4.0 미만인 학생은 " + count3 + "명 입니다.");
		System.out.println("평균 평점이 2.0 이상 3.0 미만인 학생은 " + count2 + "명 입니다.");
		System.out.println("평균 평점이 1.0 이상 2.0 미만인 학생은 " + count1 + "명 입니다.");
		System.out.println("평균 평점이  1.0 미만인 학생은 " + count0 + "명 입니다.");
		System.out.println("프로그램을 종료합니다.");
	}
	
	private static int inputScore(){
		int input;
		
		input = aScanner.nextInt();
		
		return input;
	}

	private static char score2Grade(int aScore){
		
		char output;
		
		if((90 <= aScore) && (aScore <= 100)){
			output = 'A';
		}
		else if((80 <= aScore) && (aScore <= 89)){
			output = 'B';
		}
		else if ((70 <= aScore) && (aScore <= 79)){
			output = 'C';
		}
		else if ((60 <= aScore) && (aScore <= 69)){
			output = 'D';
		}	
		else{
			output = 'F';
		}
		
		return output;
	}
	
	private static double grade2Point(char aGrade){
		
		double output2;
		
		if(aGrade == 'A'){
			output2 = 4.0;
		}
		else if(aGrade == 'B'){
			output2 = 3.0;
		}
		else if(aGrade == 'C'){
			output2 = 2.0;
		}
		else if(aGrade == 'D'){
			output2 = 1.0;
		}
		else{
			output2 = 0.0;
		}
		
		return output2;
	}
	
	private static double calcGPA (double K_Point, double E_Point, double C_Point){
		
		double outputGPA;
		
		outputGPA = (K_Point + E_Point + C_Point)/3.0;
		
		return outputGPA;
	}
}
