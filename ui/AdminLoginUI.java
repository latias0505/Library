package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class AdminLoginUI extends BaseUI {

	private BoardService boardService;

	public AdminLoginUI() {
		boardService = BoardServiceFactory.getInstance();
	}


	@Override
	public void execute() throws Exception {

		    System.out.println("=========================================================================================");
	        System.out.println("\t로그인 페이지");
	        System.out.println("=========================================================================================");
	        
	        for(int i = 1; i <= 1; i++) {
	        	 String id = scanStr("아이디를 입력해주세요 : ");
	        	 
	 	        boolean idcheck = boardService.idcheckUser(id);
	 	        if (idcheck) {
	 	        	for(int j = 1; j <= 1; j++) {
	 	        		 String pass = scanStr("패스워드를 입력해주세요 : ");
	 	 	            
	 	 	            boolean passcheck = boardService.logincheckUser(id, pass);
	 	 	            
	 	 	            if (passcheck) {
	 	 	            	String adnum = "159159";
	 	 	            	boolean admincheck = boardService.admincheckUser(pass, adnum);
	 	 	            	if (admincheck) {
	 	 	            		System.out.println("=========================================================================================");
	 	 	            		System.out.println("로그인 성공");
		 	 		        	AdminPageUI adminpageUI = new AdminPageUI();
		 	 		            adminpageUI.execute();
	 	 	            	} else {
	 	 	            		System.out.println("=========================================================================================");
	 	 	            		System.out.println("관리자 계정이 아닙니다.");
	 	 	            		System.out.println("=========================================================================================");
	 	 	            		BoardUI boardUI = new BoardUI();
		 	 		            boardUI.execute();
	 	 	            	}
	 	 	            } else {
	 	 	            	System.out.println("=========================================================================================");
	 	 	            	System.out.println("비밀번호가 일치하지 않습니다.");
	 	 	            	System.out.println("=========================================================================================");
	 	 	            	j--;
	 	 	            }
	 	        	}
	 	        } else {
	 	        	System.out.println("=========================================================================================");
	 	            System.out.println("아이디가 일치하지 않습니다.");
	 	            System.out.println("=========================================================================================");
	 	            i--;
	 	        }
	        }

	}

}
