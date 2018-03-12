
public class AppController {
	private static final int MAXSIZE = 50;
	private AppView _appView = null;
	private Ban _ban = null;
	
	public AppController(){
		this._appView = new AppView();
		this._ban = new Ban(MAXSIZE);
	}
	
	public void run(){
		this._appView.outputMessage("<<< 성적처리를 시작합니다. >>>\n");
		this.inputStoreStudentInfo();
		
		if(this._ban.isEmpty()){
			this._appView.outputMessage("오류 : 입력된 학생 정보가 없습니다.");
		}
		else{
			this.showStudentInfo();
			this._ban.processScores();
			this.showAverageInfo();
			this._appView.outputMessage("\n<<<프로그램을 종료합니다. >>>");
		}
		
		
	}
	
	private void inputStoreStudentInfo(){
		boolean moreStudentExist;
		Student currentStudent = null;
		String StudentNo = null;
		int koreanScore;
		int englishScore;
		int computerScore;
		
		
		moreStudentExist = this._appView.inputMoreStudentsExist();
		
		while(moreStudentExist && (!this._ban.isFull())){
			
			StudentNo = this._appView.inputStudentNo();
			koreanScore = this._appView.inputScore("국어");
			englishScore = this._appView.inputScore("영어");
			computerScore = this._appView.inputScore("컴퓨터");
			System.out.println();
			
			Subject korean = new Subject();
			Subject english = new Subject();
			Subject computer = new Subject();
			
			korean.setScore(koreanScore);
			english.setScore(englishScore);
			computer.setScore(computerScore);
			
			currentStudent = new Student();
			
			currentStudent.setStudentNo(StudentNo);
			
			currentStudent.setKorean(korean);
			currentStudent.setEnglish(english);
			currentStudent.setCompuer(computer);
			currentStudent.setGPA(korean.point() + english.point() + computer.point());
			
			this._ban.addStudent(currentStudent);
			
			moreStudentExist = this._appView.inputMoreStudentsExist();
			
		}
		
		System.out.println("입력을 종료합니다.\n");
	}
	
	private void showStudentInfo(){
		Student aStudent = null;
		this._appView.outputMessage("학생수는 모두 " + this._ban.numberofStudents() + "명 입니다.\n");
		
		this._appView.outputMessage("학생들의 성적 목록입니다 : ");
		
		for(int i = 0; i < this._ban.numberofStudents(); i++){
			aStudent = this._ban.studentWithOrderOf(i);
			this._appView.outputStudentinfo(aStudent);
		}
	}
	
	private void showAverageInfo(){
		this._appView.outputAverageInfo(this._ban.classAverageGPA(), this._ban.numberofStudentsAboveAverageGPA());
	}
}
