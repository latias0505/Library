package kr.ac.kopo.ui;

import java.util.Scanner;

public class AdminPageUI extends BaseUI {  

	private int menu() {
		
		System.out.println("=========================================================================================");
		System.out.println("/t관리자 페이지");
		System.out.println("=========================================================================================");
		System.out.println("1. 회원 관리");
		System.out.println("2. 도서 관리");
		System.out.println("3. 로그아웃");
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
				ui = new UserEditPageUI();
				break;
			case 2:
				ui = new BookEditPageUI();
				break;
			case 3:
				ui = new BoardUI();
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









