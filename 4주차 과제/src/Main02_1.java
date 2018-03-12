import java.util.Scanner;

public class Main02_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int giveN;
		int fact;
		int i;
		char useranswer;
		
		System.out.println("Factorial을 계산하시겠습니까?");
		System.out.print("계산하려면 'Y'를 치십시오. : ");
		useranswer = scan.next().charAt(0);
		
		
		while (useranswer == 'Y'){
			System.out.print("\nN값을 입력하시오 : ");
			giveN = scan.nextInt();
			
			if(giveN < 0){
				System.out.println("입력이 음수이므로, Factorial 값을 계산할 수 없습니다.");
			
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
				System.out.println("Factorial의 값은 " + fact + "입니다.");
				
				System.out.println("\nFactorial을 계산하시겠습니까?");
				System.out.print("계산하려면 'Y'를 치십시오. : ");
				useranswer = scan.next().charAt(0);
				
			}
			
		}
		scan.close();
	}

}
