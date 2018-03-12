import java.util.Scanner;

public class Main01_3 {
	private static Scanner aScanner = new Scanner(System.in);
	private static final int MAX_SIZE = 100;

	public static void main(String[] args) {
		
		int Korean_score, Computer_score;
		int[] Korean_scores = new int[MAX_SIZE];
		int[] Computer_scores = new int[MAX_SIZE]; 
		int numberOFstudents = 0;
		int count = 0;
		double average;
		double[] averages = new double[MAX_SIZE];
		int aboveAverage = 0;
		double sumOFaverage = 0;
		double studentAverage;
		
		System.out.print(">두 과목 (국어, 컴퓨터)의 점수를 차례로 입력하시오: ");
		Korean_score = inputScore();
		Computer_score = inputScore();
		
		while((Korean_score >= 0) && (Computer_score >= 0)){
			if((Korean_score > 100) || (Computer_score > 100)){
				System.out.println("오류 : 100이 넘어서, 정상적인 점수가 아닙니다.");
			}
			else{
				
				Korean_scores[numberOFstudents] = Korean_score;
				Computer_scores[numberOFstudents] = Computer_score;
				numberOFstudents++;
				
			}
			
			System.out.print(">두 과목 (국어, 컴퓨터)의 점수를 차례로 입력하시오: ");
			Korean_score = inputScore();
			Computer_score = inputScore();
		}

		System.out.println("음의 점수가 입력되어 입력을 종료합니다.");
		
		System.out.println("\n모두 " + numberOFstudents + "명의 성적이 입력되었습니다.");
		
		System.out.println("\n입력된 성적과 개인 평균은 다음과 같습니다.");
		
		while(count < numberOFstudents){
			
			average = (double)(Korean_scores[count] + Computer_scores[count])/2.0;
			System.out.println("[" + count + "] " + Korean_scores[count] + " " + Computer_scores[count] + " (평균 " + average + ")");
			averages[count] = average;
		
			count++;
		}
		
		count = 0;
		while(count < numberOFstudents){
			
			sumOFaverage = sumOFaverage + averages[count];
			count++;
		}
		
		studentAverage = sumOFaverage/(double)numberOFstudents;
		System.out.println("\n학급 평균은 " + studentAverage + "입니다.");
		
		count = 0;
		while(count < numberOFstudents){
			if(averages[count] >= studentAverage){
				aboveAverage ++;
			}
			count++;
		}
		
		System.out.println("평균 이상인 학생의 수는 " + aboveAverage + "명 입니다.");
		System.out.println("\n프로그램을 종료합니다.");
		
		

	}
	private static int inputScore(){
		
		
		int input;
		
		input = aScanner.nextInt();
	
		return input;
	}

}
