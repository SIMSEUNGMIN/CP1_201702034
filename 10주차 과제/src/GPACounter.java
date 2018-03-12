
public class GPACounter {
	
	private int _numberOFGPA3; // 3.0ÀÌ»ף
	private int _numberOFGPA2; // 2.0 ~ 3.0
	private int _numberOFGPA1; // 1.0 ~ 2.0
	private int _numberOFGPA0; // 0 .0 ~ 1.0
	
	public GPACounter(){
		this._numberOFGPA3 = 0;
		this._numberOFGPA2 = 0;
		this._numberOFGPA1 = 0;
		this._numberOFGPA0 = 0;
	}
	
	public void count (double aGPA){
		if(aGPA >= 3.0){
			this._numberOFGPA3 ++;
		}
		else if(aGPA >= 2.0){
			this._numberOFGPA2 ++;
		}
		else if(aGPA >= 1.0){
			this._numberOFGPA1 ++;
		}
		else{
			this._numberOFGPA0 ++;
		}
	}
	
	public int numberOFGPA3() {
		return this._numberOFGPA3;
	}
	
	public int numberOFGPA2() {
		return this._numberOFGPA2;
	}
	
	public int numberOFGPA1() {
		return this._numberOFGPA1;
	}
	
	public int numberOFGPA0() {
		return this._numberOFGPA0;
	}
	
}
