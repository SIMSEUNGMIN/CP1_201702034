
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
		//�־��� ������ ��ȿ���� �˻�
		//�˻� ����� ������ ��ȿ���� (OrderValidity)�� �޴´�
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
			this._board = new Board(this._order); // ���尴ü�� ������ �˷��ش�.
			CellLocation currentLoc = new CellLocation(0, this._order/2); //��� ��ġ(���� �� ���� �� ���)�� ������ ��ġ�� ���Ѵ�.
			CellLocation nextLoc = new CellLocation();
			
			this._board.setCell(currentLoc, 1); //������ ��� ��ġ�� 1�� ä��.
			int lastNumber = this._order * this._order;
			
			for(int number = 2; number <= lastNumber; number++){
				//���� ��ġ�κ��� ���� ��ġ ������ �� ���.
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
				// ���� ��ġ�� ä���� ������ 
				//���� ��ġ�� ������ġ�� �ٷ� �� �� �Ʒ� ĭ ��ġ�� �����Ѵ�.
				if(!this._board.cellsEmpty(nextLoc)){
					nextLoc.setRow(currentLoc.row()+1);
					nextLoc.setCol(currentLoc.col());
				}
				// ���� ��ġ�� ���ο� ���� ��ġ�� �Ѵ�.
				currentLoc.setRow(nextLoc.row());
				currentLoc.setCol(nextLoc.col());
				// ���ο� ���� ��ġ�� number ���� �ִ´�.
				this._board.setCell(currentLoc, number);
			}
			return this._board;
		}
	}
}
