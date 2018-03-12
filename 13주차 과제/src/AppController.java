
public class AppController {
	private static final int MAXSIZE = 50;
	private AppView _appView = null;
	private Ban _ban = null;
	
	public AppController(){
		this._appView = new AppView();
		this._ban = new Ban(MAXSIZE);
	}
	
	public void run(){
		this._appView.outputMessage("<<< ����ó���� �����մϴ�. >>>\n");
		this.inputStoreStudentInfo();
		
		if(this._ban.isEmpty()){
			this._appView.outputMessage("���� : �Էµ� �л� ������ �����ϴ�.");
		}
		else{
			this.showStudentInfo();
			this._ban.processScores();
			this.showAverageInfo();
			this._appView.outputMessage("\n<<<���α׷��� �����մϴ�. >>>");
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
			koreanScore = this._appView.inputScore("����");
			englishScore = this._appView.inputScore("����");
			computerScore = this._appView.inputScore("��ǻ��");
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
		
		System.out.println("�Է��� �����մϴ�.\n");
	}
	
	private void showStudentInfo(){
		Student aStudent = null;
		this._appView.outputMessage("�л����� ��� " + this._ban.numberofStudents() + "�� �Դϴ�.\n");
		
		this._appView.outputMessage("�л����� ���� ����Դϴ� : ");
		
		for(int i = 0; i < this._ban.numberofStudents(); i++){
			aStudent = this._ban.studentWithOrderOf(i);
			this._appView.outputStudentinfo(aStudent);
		}
	}
	
	private void showAverageInfo(){
		this._appView.outputAverageInfo(this._ban.classAverageGPA(), this._ban.numberofStudentsAboveAverageGPA());
	}
}
