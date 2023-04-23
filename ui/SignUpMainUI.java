package kr.ac.kopo.ui;

import java.util.Scanner;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class SignUpMainUI extends BaseUI {

	private BoardService boardService;

	public SignUpMainUI() {
		boardService = BoardServiceFactory.getInstance();
	}


	@Override
	public void execute() throws Exception {
		
		System.out.println("=========================================================================================");
		System.out.println("\t회원가입 종류 선택");
		System.out.println("=========================================================================================");
		System.out.println("1. 관리자 회원가입");
		System.out.println("2. 일반 회원가입");
		System.out.println("3. 뒤로가기");
		System.out.println("=========================================================================================");
		System.out.print("회원가입의 종류를 선택해주세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		while(true){
			IBoardUI ui = null;
			switch (type) {
			case 1:
				ui = new AdminSignUpUI();
				break;
			case 2:
				ui = new UserSignUpUI();
				break;
			case 3:
				ui = new BoardUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("=========================================================================================");
				System.out.println("잘못입력하셨습니다");
				break;
			}
		}
		
	}

	
}
