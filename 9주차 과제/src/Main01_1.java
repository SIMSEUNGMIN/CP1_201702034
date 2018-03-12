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
				System.out.println("���� : 100�� �Ѿ, �������� ������ �ƴմϴ�.");
			}
			else{
				numberOFstudents ++;
				scores[count] = score;
				count ++;
				
			}
			
			score = inputScore();
		}
		
		System.out.println("���� ������ �ԷµǾ� �Է��� �����մϴ�.");
		
		average = calcAverage(scores, numberOFstudents);
		
		System.out.println("\n��� " + numberOFstudents + "���� ������ �ԷµǾ����ϴ�.");
		System.out.println("����� " + average + "�Դϴ�.");
		
		System.out.println("\n�Էµ� ������ ������ �����ϴ�.");
		
		count = 0;
		while(count < numberOFstudents){
			if(scores[count] >= average){
				System.out.println("[" + count + "] " + scores[count] + " (��� �̻��Դϴ�.)");
				aboveAverage ++;
			}
			else{
				System.out.println("[" + count + "] " + scores[count] + " (��� �̸��Դϴ�.)");
			}
			
			count ++;
		}
		
		System.out.println("��� �̻��� �л��� ���� " + aboveAverage + "�� �Դϴ�.\n");
		
		
		maxValue = calcMax(scores, numberOFstudents);
				
		System.out.println("�ְ����� " + maxValue + "�� �Դϴ�.");
		
		minValue = calcMin(scores, numberOFstudents);
		
		System.out.println("�������� " + minValue + "�� �Դϴ�.");
		
		System.out.println("\n�������� ������ �����ϴ�.");
		
		selectionSort(scores, numberOFstudents);
		
		count = 0;
		while(count < numberOFstudents){
			System.out.println("[" + count + "] " + scores[count]);
			count++;
		}
		
		System.out.println("\n���α׷��� �����մϴ�.");

	}
	
	private static int inputScore(){
		int input;
		
		System.out.print(">������ �Է��Ͻÿ� : ");
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
