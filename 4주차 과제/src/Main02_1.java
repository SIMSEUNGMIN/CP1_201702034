import java.util.Scanner;

public class Main02_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int giveN;
		int fact;
		int i;
		char useranswer;
		
		System.out.println("Factorial�� ����Ͻðڽ��ϱ�?");
		System.out.print("����Ϸ��� 'Y'�� ġ�ʽÿ�. : ");
		useranswer = scan.next().charAt(0);
		
		
		while (useranswer == 'Y'){
			System.out.print("\nN���� �Է��Ͻÿ� : ");
			giveN = scan.nextInt();
			
			if(giveN < 0){
				System.out.println("�Է��� �����̹Ƿ�, Factorial ���� ����� �� �����ϴ�.");
			
		}
			else{ 
				
				if (giveN == 0) {
					fact = 1;
				
				}
				else{
					
					fact = 1;
					i = 2;
					
					while( i <= giveN ){
						fact = fact*i;
						i++;
					}
					
				}
				System.out.println("Factorial�� ���� " + fact + "�Դϴ�.");
				
				System.out.println("\nFactorial�� ����Ͻðڽ��ϱ�?");
				System.out.print("����Ϸ��� 'Y'�� ġ�ʽÿ�. : ");
				useranswer = scan.next().charAt(0);
				
			}
			
		}
		scan.close();
	}

}
