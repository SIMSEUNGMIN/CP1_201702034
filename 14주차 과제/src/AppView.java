import java.util.Scanner;

public class AppView {
	private Scanner _scanner;
	
	public AppView(){
		this._scanner = new Scanner(System.in);
	}
	
	public int inputOrder(){
		int input;
		System.out.print("\n�������� ������ �Է��Ͻÿ� (������ �Է��ϸ� �����մϴ�.) : ");
		input = _scanner.nextInt();
		
		return input;
		
	}
	
	public void outTitleWithOrder(int anOrder){
		System.out.println("Magic Square Board : Order" + anOrder);
	}

	
	public void outMessage(String aMessage){
		System.out.println(aMessage);
	}
	
	
}
