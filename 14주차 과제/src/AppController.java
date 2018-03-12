
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
		this._appView.outMessage("<<< 마방진 풀이를 시작합니다. >>>");
		OrderValidity currentOrderValidity;
		
		int order = this._appView.inputOrder(); //메세지를 내보내고 차수를 입력받음
		
		while(order > 0){ // 차수가 음수이면 프로그램 종료
			currentOrderValidity = this._magicSquare.checkOrderValidity(order);
			
			if(currentOrderValidity == OrderValidity.Valid){
				this._appView.outTitleWithOrder(order);
				this._board = this._magicSquare.solve(order);
				//_MagicSquare 객체에게 주어진 차수의 마방진을 풀도록 시킴
				//결과로 마방진 판을 얻음.
				this.showBoard(); //마방진을 보여줌
			}
			else{
				this.showOrderValidityErrorMessage(currentOrderValidity);
			}
			order = this._appView.inputOrder(); // 다음 마방진을 위해 차수를 입력받음
			
		}
		this._appView.outMessage("<<< 마방진 풀이를 종료합니다. >>>");
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
				this._appView.outMessage("오류 : 차수가 너무 작습니다. 3보다 크거나 같아야 합니다.");
				break;
			case TooLarge:
				this._appView.outMessage("오류 : 차수가 너무 큽니다. 99보다 작거나 같아야합니다.");
				break;
			case NotOddNumber: 
				this._appView.outMessage("오류 : 차수가 짝수입니다. 홀수이어야 합니다.");
				break;
			default: 
				break;
		}
	}
	
}
