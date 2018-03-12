
public class MagicSquare {

	private static int DEFAULT_MAX_ORDER = 99;
	
	private int _maxOrder;
	private int _order;
	private Board _board;
	
	public MagicSquare(){
		this._maxOrder = MagicSquare.DEFAULT_MAX_ORDER;
		this._order = 3;
		this._board = null;
	}
	
	public MagicSquare(int givenMaxOrder){
		this._maxOrder = givenMaxOrder;
		this._order = 3;
		this._board = null;
	}
	
	public OrderValidity checkOrderValidity(int anOrder){
		//주어진 차수가 유효한지 검사
		//검사 결과로 차수의 유효상태 (OrderValidity)를 받는다
		if(anOrder < 3 ){
			return OrderValidity.TooSmall;
		}
		else if(anOrder > 99){
			return OrderValidity.TooLarge;
		}
		else if(anOrder%2 == 0){
			return OrderValidity.NotOddNumber;
		}
		else{
			return OrderValidity.Valid;
		}
		
	}
	
	public int maxOrder(){
		return this._maxOrder;
	}
	
	public Board solve(int anOrder){
		this._order = anOrder;
		
		if(this.checkOrderValidity(anOrder) != OrderValidity.Valid){
			return null;
		}
		else{
			this._board = new Board(this._order); // 보드객체에 차수를 알려준다.
			CellLocation currentLoc = new CellLocation(0, this._order/2); //출발 위치(보드 맨 윗줄 한 가운데)를 현재의 위치로 정한다.
			CellLocation nextLoc = new CellLocation();
			
			this._board.setCell(currentLoc, 1); //보드의 출발 위치에 1을 채움.
			int lastNumber = this._order * this._order;
			
			for(int number = 2; number <= lastNumber; number++){
				//현재 위치로부터 다음 위치 오른쪽 위 계산.
				if(currentLoc.row()-1 < 0){
					nextLoc.setRow(anOrder-1);
				}
				else{
					nextLoc.setRow(currentLoc.row()-1);
				}
				if(currentLoc.col()+1 > anOrder -1){
					nextLoc.setCol(0);
				}
				else{
					nextLoc.setCol(currentLoc.col() +1);
				}
				// 다음 위치가 채워져 있으면 
				//다음 위치를 현재위치의 바로 한 줄 아래 칸 위치로 수정한다.
				if(!this._board.cellsEmpty(nextLoc)){
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				// 다음 위치를 새로운 현재 위치로 한다.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				// 새로운 현재 위치에 number 값을 넣는다.
				this._board.setCell(currentLoc, number);
			}
			return this._board;
		}
	}
}
