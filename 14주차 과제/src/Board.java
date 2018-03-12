
public class Board {
	private static int EMPTY_CELL = -1;
	
	private int _order;
	private int[][] _cell;
	
	public Board(int givenOrder){
		this._order = givenOrder;
		this._cell = new int[givenOrder][givenOrder];
		for(int row = 0; row < givenOrder; row++){
			for(int col = 0; col < givenOrder; col++){
				this._cell[row][col] = Board.EMPTY_CELL;
			}
		}
	}
	
	public int order(){
		return this._order;	
	}
	
	public void setCell(CellLocation aLocation, int aNumber){
		//주어진 수 aNumber를 주어진 위치 aLocation의 cell에 넣는다.
		this._cell[aLocation.row()][aLocation.col()] = aNumber;
	}
	
	public int cell(CellLocation aLocation){
		//주어진 위치 aLocation의 cell 값을 얻는다.
		return this._cell[aLocation.row()][aLocation.col()];
	}
	
	public boolean cellsEmpty(CellLocation aLocation){
		//주어진 위치의 cell이 비어있는지 알려줌, 비면 true, 차있으면 false
		if(this.cell(aLocation) == -1){
			return true;
		}
		else return false;
	}
	
}
