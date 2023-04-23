package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class LoginUI extends BaseUI {

	private BoardService boardService;

	public LoginUI() {
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
	 	 	            	System.out.println("=========================================================================================");
	 	 	            	System.out.println("로그인 성공");
	 	 	            	System.out.println("=========================================================================================");
	 	 	            	MainPageUI mainpageUI = new MainPageUI(id);
	 	 		            mainpageUI.execute();
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
