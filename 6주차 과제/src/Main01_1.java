
public class Main01_1 {
	
	public static void main(String[] args) {
		
		int degree = 1;
		
		while(degree <= 176){
			if(degree < 10){
				System.out.print("sine(00" + degree + "µµ): ");
				
			}
			else if (degree < 100){
				System.out.print("sine(0" + degree + "µµ): ");
			}
			else{
				System.out.print("sine(" + degree + "µµ): ");
			}
			
			printAsterisks(degree);
			System.out.println();
			degree = degree + 5;
	
		}
		
	}
	
	private static void printAsterisks(int N){
		
		double radian;
		double sineValue;
		int numberOfAsterisks;
		int count = 1;
		
		radian = (double)N * (3.141592/180.0);
		sineValue = mySine(radian);
		
		numberOfAsterisks = (int)((sineValue * 40.0) + 0.5);
		
		while(count <= numberOfAsterisks){
			
			System.out.print("*");
			count ++;
		}
		
	}
	
	private static double mySine (double x){
		double xSqure = x*x;
		double currentTerm = x;
		int n = 2;
		double value = currentTerm;
		
		while(Math.abs(currentTerm) >= 0.000001){
			currentTerm = - currentTerm * xSqure / (double)(n*(n+1));
			value = value + currentTerm;
			n = n + 2;
		}
		
		return value;
	}

}
