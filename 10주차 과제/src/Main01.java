import java.util.Scanner;

public class Main01 {
	private static Scanner aScanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		Student student = new Student();
		GPACounter gpacounter = new GPACounter();

		int Korean_score;
		int English_score;
		int Computer_score;
		
		System.out.print("> �� ���� (����, ����, ��ǻ��) �� ������ ���ʷ� �Է��մϴ�. :");
		Korean_score = inputScore();
		English_score = inputScore();
		Computer_score = inputScore();
		
		while((Korean_score >= 0) && (English_score >= 0) && (Computer_score >= 0)){
			if((Korean_score > 100) || (English_score > 100) || (Computer_score > 100)){
				System.out.println("���� : 100�� �Ѿ, �������� ������ �ƴմϴ�.");
			}
			else{
				student.setScoreKorean(Korean_score);
				student.setScoreEnglish(English_score);
				student.setScoreComputer(Computer_score);
				gpacounter.count(student.gpa());
				
				System.out.println("[��   ��] : " + student.scoreKorean() + ", ���� : " + student.gradeKorean() + ", ���� : " + student.pointKorean());
				System.out.println("[��   ��] : " + student.scoreEnglish() + ", ���� : " + student.gradeEnglish() + ", ���� :" + student.pointEnglish());
				System.out.println("[��ǻ��] : " + student.scoreComputer() + ", ���� : " + student.gradeComputer() + ", ���� : " + student.pointComputer());
				System.out.println("�� �л��� ��� ������ " + student.gpa() + "�Դϴ�.");
			}
			
			System.out.print("> �� ���� (����, ����, ��ǻ��) �� ������ ���ʷ� �Է��մϴ�. :");
			Korean_score = inputScore();
			English_score = inputScore();
			Computer_score = inputScore();
			
		}
		
		System.out.println("���� ������ �ԷµǾ� �Է��� �����մϴ�.\n");
		
		System.out.println("��������� 3.0 �̻��� �л��� " + gpacounter.numberOFGPA3() + "�� �Դϴ�.");
		System.out.println("��������� 2.0 �̻� 3.0 �̸��� �л��� " + gpacounter.numberOFGPA2() + "�� �Դϴ�.");
		System.out.println("��������� 1.0 �̻� 2.0 �̸��� �л��� " + gpacounter.numberOFGPA1() + "�� �Դϴ�.");
		System.out.println("��������� 1.0 �̸��� �л��� " + gpacounter.numberOFGPA0() + "�� �Դϴ�.");
		System.out.println("���α׷��� �����մϴ�.");

	}
	
	private static int inputScore(){
		
		return aScanner.nextInt();
		
	}

}
