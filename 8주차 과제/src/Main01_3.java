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
		
		System.out.print(">�� ���� (����, ��ǻ��)�� ������ ���ʷ� �Է��Ͻÿ�: ");
		Korean_score = inputScore();
		Computer_score = inputScore();
		
		while((Korean_score >= 0) && (Computer_score >= 0)){
			if((Korean_score > 100) || (Computer_score > 100)){
				System.out.println("���� : 100�� �Ѿ, �������� ������ �ƴմϴ�.");
			}
			else{
				
				Korean_scores[numberOFstudents] = Korean_score;
				Computer_scores[numberOFstudents] = Computer_score;
				numberOFstudents++;
				
			}
			
			System.out.print(">�� ���� (����, ��ǻ��)�� ������ ���ʷ� �Է��Ͻÿ�: ");
			Korean_score = inputScore();
			Computer_score = inputScore();
		}

		System.out.println("���� ������ �ԷµǾ� �Է��� �����մϴ�.");
		
		System.out.println("\n��� " + numberOFstudents + "���� ������ �ԷµǾ����ϴ�.");
		
		System.out.println("\n�Էµ� ������ ���� ����� ������ �����ϴ�.");
		
		while(count < numberOFstudents){
			
			average = (double)(Korean_scores[count] + Computer_scores[count])/2.0;
			System.out.println("[" + count + "] " + Korean_scores[count] + " " + Computer_scores[count] + " (��� " + average + ")");
			averages[count] = average;
		
			count++;
		}
		
		count = 0;
		while(count < numberOFstudents){
			
			sumOFaverage = sumOFaverage + averages[count];
			count++;
		}
		
		studentAverage = sumOFaverage/(double)numberOFstudents;
		System.out.println("\n�б� ����� " + studentAverage + "�Դϴ�.");
		
		count = 0;
		while(count < numberOFstudents){
			if(averages[count] >= studentAverage){
				aboveAverage ++;
			}
			count++;
		}
		
		System.out.println("��� �̻��� �л��� ���� " + aboveAverage + "�� �Դϴ�.");
		System.out.println("\n���α׷��� �����մϴ�.");
		
		

	}
	private static int inputScore(){
		
		
		int input;
		
		input = aScanner.nextInt();
	
		return input;
	}

}
