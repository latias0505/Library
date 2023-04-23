package kr.ac.kopo.ui;

import java.util.Scanner;

public class BoardUI extends BaseUI {  

	private int menu() {
		System.out.println("=========================================================================================");
		System.out.println("\t도서 관리 프로그램");
		System.out.println("=========================================================================================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 관리자 로그인");
		System.out.println("4. 종료");
		System.out.println("=========================================================================================");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true){
			int type = menu();
			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new SignUpMainUI();
				break;
			case 2:
				ui = new LoginUI();
				break;
			case 3:
				ui = new AdminLoginUI();
				break;
			case 4:
				ui = new ExitUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("=========================================================================================");
				System.out.println("잘못입력하셨습니다");
			}
		}
	}
}









