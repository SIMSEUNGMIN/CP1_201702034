
public class Main02_1 {

	public static void main(String[] args) {
		
		double x;
		int n=1;
		double y;
		
		System.out.println("<< Sine �� ��� ���α׷��� �����մϴ�. >>\n");
		
		while(n <= 180){
			x = (double) n * (3.141592 / 180.0); 
			y = Math.sin(x);
			System.out.println("Sine(" + n + "��)��" + y + "�Դϴ�.");
			n++;
		}
		
		System.out.print("\n<< Sine �� ��� ���α׷��� �����մϴ�. >>");
	}

}
