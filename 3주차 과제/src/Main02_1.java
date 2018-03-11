import java.util.Scanner;

public class Main02_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int givenN;
		int sum;
		int count;
		
		
		System.out.print("1부터 N 까지 합계를 구하려고 합니다. N 값을 입력하십시오 : ");
		
		givenN = scan.nextInt();
		sum = 0;
		count = 1;
		
		while (count <= givenN) {
			sum = sum + count;
			System.out.println("합계 : " + sum);
			count = count + 1;
			
			scan.close();
		}

	}

}
