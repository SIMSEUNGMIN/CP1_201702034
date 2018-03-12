import java.util.Scanner;

public class Main01_4 {
	static Scanner aScanner = new Scanner(System.in);

	public static void main(String[] args) {
		//   ��� ���� ��� �Լ�
		int Korean_Score, English_Score, Computer_Score;
		char Korean_Grade, English_Grade, Computer_Grade;
		double Korean_Point, English_Point, Computer_Point;
		double gpa;
		int count4 = 0;
		int count3 = 0;
		int count2 = 0;
		int count1 = 0;
		int count0 = 0;
		
		System.out.print("> �� ���� (����, ����, ��ǻ��)�� ������ ���ʷ� �Է��Ͻÿ� : ");
		Korean_Score = inputScore();
		English_Score = inputScore();
		Computer_Score = inputScore();
		
		while((Korean_Score >= 0) && (English_Score >= 0) && (Computer_Score >= 0)){
			if((Korean_Score > 100) || (English_Score > 100) || (Computer_Score > 100)){
				System.out.println("���� : 100�� �Ѿ, �������� ������ �ƴմϴ�.");
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
				
				System.out.println("[��   ��] ���� : " + Korean_Score + ", ���� : " + Korean_Grade + ", ���� : " + Korean_Point);
				System.out.println("[��   ��] ���� : " + English_Score + ", ���� : " + English_Grade + ", ���� : " + English_Point);
				System.out.println("[��ǻ��] ���� : " + Computer_Score + ", ���� : " + Computer_Grade + ", ���� : " + Computer_Point);
				System.out.println("�� �л��� ��� ������ " + gpa + " �Դϴ�.");
				
				
			}
			
			System.out.print("> �� ���� (����, ����, ��ǻ��)�� ������ ���ʷ� �Է��Ͻÿ� : ");
			Korean_Score = inputScore();
			English_Score = inputScore();
			Computer_Score = inputScore();
		}
		
		System.out.println("���� ������ �ԷµǾ� �Է��� �����մϴ�.\n");
		
		System.out.println("��� ������ 4.0 �̻��� �л��� " + count4 + "�� �Դϴ�.");
		System.out.println("��� ������ 3.0 �̻� 4.0 �̸��� �л��� " + count3 + "�� �Դϴ�.");
		System.out.println("��� ������ 2.0 �̻� 3.0 �̸��� �л��� " + count2 + "�� �Դϴ�.");
		System.out.println("��� ������ 1.0 �̻� 2.0 �̸��� �л��� " + count1 + "�� �Դϴ�.");
		System.out.println("��� ������  1.0 �̸��� �л��� " + count0 + "�� �Դϴ�.");
		System.out.println("���α׷��� �����մϴ�.");
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
