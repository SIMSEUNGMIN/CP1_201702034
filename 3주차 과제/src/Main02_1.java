import java.util.Scanner;

public class Main02_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int givenN;
		int sum;
		int count;
		
		
		System.out.print("1���� N ���� �հ踦 ���Ϸ��� �մϴ�. N ���� �Է��Ͻʽÿ� : ");
		
		givenN = scan.nextInt();
		sum = 0;
		count = 1;
		
		while (count <= givenN) {
			sum = sum + count;
			System.out.println("�հ� : " + sum);
			count = count + 1;
			
			scan.close();
		}

	}

}
