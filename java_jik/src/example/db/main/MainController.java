package example.db.main;

public class MainController {
	
	private SqlSesstion sesstion;
	private StudentDAO studentDao;
	
	public MainController(SqlSesstion session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
	}
	
	/* 학생 추가
	 * 학생 수정
	 * 학생 조회
	 * 프로그램 종료
	 * */
	public void run() {
		switch(menu) {
		case 1 : 
			insertStudent();
			break;
		case 2 : 
			updateStudent();
			break;
		case 3 :
			selectAllStdent();
			break;
		case 4 :
			System.out.println("프로그램 종료");
			break;
		default :
			System.out.println("잘못된 메뉴");
		}
	}
		private void updateStudent() {
		
		
	}

		private void insertStudent() {
			System.out.println("학생 정보 입력");
			System.out.println("학번 : ");
			String st_num = sc.nextLine();
			System.out.println("이름 : ");
			String st_name = sc.nextLine();
			System.out.println("학기 : ");
			int st_semester = sc.nextInt();
			sc.nextLine();
			System.out.println("상태(재학/휴학/자퇴/퇴학/졸업/수료) : ");
			String st_state = sc.nextLine();
			System.out.println("지도교수 번호 : ");
			String st_pr_numString = sc.nextLine();
			StudentVO std = new StudentVO(st_num, st_name, st_semester, st_state, st_pr_num)
		}
}
