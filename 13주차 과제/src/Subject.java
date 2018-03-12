
public class Subject {

	private int _score;
	
	public Subject(){
		this._score = 0;
	}
	
	public void setScore(int aScore){
		this._score = aScore;
	}
	
	public int score(){
		return this._score;
	}
	
	public char grade(){
		if(this._score >= 90){
			return 'A';
		}
		else if(this._score >= 80){
			return 'B';
		}
		else if(this._score >= 70){
			return 'C';
		}
		else if(this._score >= 60){
			return 'D';
		}
		else{
			return 'F';
		}
	}
	
	public double point(){
		if(grade() == 'A'){
			return 4.0;
		}
		else if(grade() == 'B'){
			return 3.0;
		}
		else if(grade() == 'C'){
			return 2.0;
		}
		else if(grade() == 'D'){
			return 1.0;
		}
		else{
			return 0.0;
		}
	}
}
