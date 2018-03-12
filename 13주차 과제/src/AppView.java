import java.util.Scanner;

public class AppView { //��� ���� �Լ�
	private static Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public boolean inputMoreStudentsExist(){
		char input;
		System.out.print("? �л������� �Է��Ϸ��� 'Y'��, �Է��� �����Ϸ��� 'N'�� ġ�ÿ� : ");
		input = _scanner.next().charAt(0);
		if(input == 'Y' || input == 'y'){
			return true;
		}
		else return false;
	}
	
	public String inputStudentNo(){
		String input = new String();
		
		System.out.print("�й��� �Է��Ͻÿ� : ");
		input = _scanner.next();
		
		return input;
	} 
	
	public int inputScore(String Subjectname){
		System.out.print("- " + Subjectname +"�� �Է��Ͻÿ� : ");
		int input = _scanner.nextInt();
		
		while((input < 0) || (input > 100)){
			System.out.println("[����] ���� ����(0~100)�� ������ �ƴմϴ�. �ٽ� �Է��Ͻÿ�.");
			
			System.out.print("- " + Subjectname +"�� �Է��Ͻÿ� : ");
			input = _scanner.nextInt();
			
		}
		
		return input;
	}
	
	public void outputStudentinfo(Student aStudent){ //�л����� ���� ��� ���
		System.out.println("�й� : " + aStudent.studentNo() + ", ���� : " + aStudent.korean().score() + "(" + aStudent.korean().grade()+ ")" + ", ���� : " + aStudent.english().score() + "(" + aStudent.english().grade() + ")" + ", ��ǻ�� : " + aStudent.computer().score() + "(" + aStudent.computer().grade() + ")" + ", ������� : " + aStudent.GPA());
	}
	
	public void outputAverageInfo(double aClassAveragePoint, int numberofStudentsAboveAverageGPA){ //��� ���
		System.out.println("\n�б��� ��������� " + aClassAveragePoint + "�� �Դϴ�.");
		System.out.println("��� ���� �̻��� �л����� " + numberofStudentsAboveAverageGPA + "�� �Դϴ�.\n");
	}
	
	public void outputMessage(String aMessage){
		System.out.println(aMessage);
	}
	
	
}
