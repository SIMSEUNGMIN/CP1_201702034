
public class AppController {
	private AppView _appView;
	private Board _board;
	private MagicSquare _magicSquare;
	private CellLocation _cellLocation;
	
	public AppController(){
		this._appView = new AppView();
		this._board = null;
		this._magicSquare = new MagicSquare();
		this._cellLocation = new CellLocation();
	}
	
	public void run(){
		this._appView.outMessage("<<< ������ Ǯ�̸� �����մϴ�. >>>");
		OrderValidity currentOrderValidity;
		
		int order = this._appView.inputOrder(); //�޼����� �������� ������ �Է¹���
		
		while(order > 0){ // ������ �����̸� ���α׷� ����
			currentOrderValidity = this._magicSquare.checkOrderValidity(order);
			
			if(currentOrderValidity == OrderValidity.Valid){
				this._appView.outTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				//_MagicSquare ��ü���� �־��� ������ �������� Ǯ���� ��Ŵ
				//����� ������ ���� ����.
				this.showBoard(); //�������� ������
			}
			else{
				this.showOrderValidityErrorMessage(currentOrderValidity);
			}
			order = this._appView.inputOrder(); // ���� �������� ���� ������ �Է¹���
			
		}
		this._appView.outMessage("<<< ������ Ǯ�̸� �����մϴ�. >>>");
	}
	
	private void showBoard(){
		for(int i = 0; i < this._board.order(); i++){
			System.out.print("\t[" + i + "]");
			
		}
		System.out.println();
		
		for(int i = 0; i < this._board.order(); i++){
			System.out.print("[" + i + "]");
			for(int j = 0; j < this._board.order(); j++){
				
				this._cellLocation.setRow(i);
				this._cellLocation.setCol(j);
				
				
				System.out.print("\t" + this._board.cell(_cellLocation));
			}
			System.out.println();
		}
		
	}
	
	private void showOrderValidityErrorMessage(OrderValidity anOrderValidity){
		
		switch (anOrderValidity){
			case TooSmall:
				this._appView.outMessage("���� : ������ �ʹ� �۽��ϴ�. 3���� ũ�ų� ���ƾ� �մϴ�.");
				break;
			case TooLarge:
				this._appView.outMessage("���� : ������ �ʹ� Ů�ϴ�. 99���� �۰ų� ���ƾ��մϴ�.");
				break;
			case NotOddNumber: 
				this._appView.outMessage("���� : ������ ¦���Դϴ�. Ȧ���̾�� �մϴ�.");
				break;
			default: 
				break;
		}
	}
	
}
