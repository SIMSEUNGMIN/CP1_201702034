import java.util.Scanner;

public class Main01_1 {
	private static Scanner aScanner = new Scanner(System.in);
	private static final int MAZ_SIZE = 100;


	public static void main(String[] args) {
		int score;
		int[] scores = new int[MAZ_SIZE];
		int numberOFstudents = 0;
		int count = 0;
		double average;
		int aboveAverage = 0;
		int minValue = 0;
		int maxValue = 0;
		
		score = inputScore();
		
		while(score >= 0){
			if (score > 100){
				System.out.println("오류 : 100이 넘어서, 정상적인 점수가 아닙니다.");
			}
			else{
				numberOFstudents ++;
				scores[count] = score;
				count ++;
				
			}
			
			score = inputScore();
		}
		
		System.out.println("음의 점수가 입력되어 입력을 종료합니다.");
		
		average = calcAverage(scores, numberOFstudents);
		
		System.out.println("\n모두 " + numberOFstudents + "명의 성적이 입력되었습니다.");
		System.out.println("평균은 " + average + "입니다.");
		
		System.out.println("\n입력된 성적은 다음과 같습니다.");
		
		count = 0;
		while(count < numberOFstudents){
			if(scores[count] >= average){
				System.out.println("[" + count + "] " + scores[count] + " (평균 이상입니다.)");
				aboveAverage ++;
			}
			else{
				System.out.println("[" + count + "] " + scores[count] + " (평균 미만입니다.)");
			}
			
			count ++;
		}
		
		System.out.println("평균 이상인 학생의 수는 " + aboveAverage + "명 입니다.\n");
		
		
		maxValue = calcMax(scores, numberOFstudents);
				
		System.out.println("최고점은 " + maxValue + "점 입니다.");
		
		minValue = calcMin(scores, numberOFstudents);
		
		System.out.println("최저점은 " + minValue + "점 입니다.");
		
		System.out.println("\n성적순은 다음과 같습니다.");
		
		selectionSort(scores, numberOFstudents);
		
		count = 0;
		while(count < numberOFstudents){
			System.out.println("[" + count + "] " + scores[count]);
			count++;
		}
		
		System.out.println("\n프로그램을 종료합니다.");

	}
	
	private static int inputScore(){
		int input;
		
		System.out.print(">점수를 입력하시오 : ");
		input =  aScanner.nextInt();
		
		return input;
	}
	
	private static double calcAverage (int[]elements, int eSize){
		int i = 0;
		int sum;
		double average;
		
		sum = 0;
		
		while (i < eSize){
			sum = sum + elements[i];
			i ++;
		}
		
		average = (double)sum / (double) eSize;
		
		return average;
	}
	
	private static int calcMax (int[]elements, int eSize){
		int count = 0;
		int Max;
		
		Max = elements[count];
		count = 1;
		while(count < eSize){
			if(Max < elements[count]){
				Max = elements[count];
			}
			count++;
		}
		return Max;
	}
	
	private static int calcMin (int[]elements, int eSize){
		int count = 0;
		int Min;
		
		Min = elements[count];
		count = 1;
		while(count < eSize){
			if(Min > elements[count]){
				Min = elements[count];
			}
			count++;
		}
		return Min;
	}
	
	private static void selectionSort(int[] elements, int eSize){
		int lastLoc = eSize - 1;
		int selectionLoc = 0;
		int MaxLoc;
		int MaxValue;
		int culLoc;
		
		while(selectionLoc < lastLoc){
			MaxLoc = selectionLoc;
			MaxValue = elements[MaxLoc];
			culLoc = selectionLoc + 1;
			while(culLoc <= eSize){
				if(elements[culLoc] > MaxValue){
					MaxLoc = culLoc;
					MaxValue = elements[MaxLoc];
				}
				culLoc ++;
			}
			elements[MaxLoc] = elements[selectionLoc];
			elements[MaxLoc] = MaxValue;
			
			
			selectionLoc ++;
			
		}

	}

}
