
public class Main02_1 {

	public static void main(String[] args) {
		
		double x;
		int n=1;
		double y;
		
		System.out.println("<< Sine 값 출력 프로그램을 시작합니다. >>\n");
		
		while(n <= 180){
			x = (double) n * (3.141592 / 180.0); 
			y = Math.sin(x);
			System.out.println("Sine(" + n + "도)는" + y + "입니다.");
			n++;
		}
		
		System.out.print("\n<< Sine 값 출력 프로그램을 종료합니다. >>");
	}

}
