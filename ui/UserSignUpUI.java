package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class UserSignUpUI extends BaseUI {

	private BoardService boardService;

	public UserSignUpUI() {
		boardService = BoardServiceFactory.getInstance();
	}


	@Override
	public void execute() throws Exception {
		
		String pass   = null;
		String id     = null;
		String name   = null;
		String email  = null;
		String hp     = null;
		String adnum  = null;
		String adnum1 = "none";
		
		System.out.println("=========================================================================================");
		System.out.println("\t일반 회원가입");
		System.out.println("=========================================================================================");
		for(int i = 1; i <= 1; i++) {
        	String id1 = scanStr("아이디를 입력해주세요 : ");
        	 
 	        boolean idcheck = boardService.idcheckUser(id1);
 	        if (idcheck) {
 	        	System.out.println("=========================================================================================");
 	        	System.out.println("이미 존재하는 아이디 입니다.");
 	        	System.out.println("=========================================================================================");
 	        	i--;
 	        } else {
 	        	id = id1;
 	        }
 	    }
		for(int i = 1; i <= 1; i++) {
			String pass1  = scanStr("패스워드를 입력해주세요 : ");
			String pass2  = scanStr("패스워드를 한번 더 입력해주세요 : ");
			if(pass1.equals(pass2)) {
				pass = pass1;
			} else {
				System.out.println("=========================================================================================");
				System.out.println("패스워드가 일치하지 않습니다.");
				System.out.println("=========================================================================================");
				i--;
			}
		}
		for(int i = 1; i <= 1; i++) {
        	String name1 = scanStr("이름을 입력해주세요 : ");
        	 
 	        boolean namecheck = boardService.namecheckUser(name1);
 	        if (namecheck) {
 	        	System.out.println("=========================================================================================");
 	        	System.out.println("이미 존재하는 이름 입니다.");
 	        	System.out.println("=========================================================================================");
 	        	i--;
 	        } else {
 	        	name = name1;
 	        }
 	    }
		String birth = scanStr("생년월일을 입력해주세요 : ");
		for(int i = 1; i <= 1; i++) {
        	String email1 = scanStr("이메일을 입력해주세요 : ");
        	 
 	        boolean emailcheck = boardService.emailcheckUser(email1);
 	        if (emailcheck) {
 	        	System.out.println("=========================================================================================");
 	        	System.out.println("이미 존재하는 이메일 입니다.");
 	        	System.out.println("=========================================================================================");
 	        	i--;
 	        } else {
 	        	email = email1;
 	        }
 	    }
		for(int i = 1; i <= 1; i++) {
        	String hp1 = scanStr("핸드폰번호를 입력해주세요 : ");
        	 
 	        boolean hpcheck = boardService.hpcheckUser(hp1);
 	        if (hpcheck) {
 	        	System.out.println("=========================================================================================");
 	        	System.out.println("이미 존재하는 핸드폰번호 입니다.");
 	        	System.out.println("=========================================================================================");
 	        	i--;
 	        } else {
 	        	hp = hp1;
 	        	adnum = adnum1;
 	        }
 	    }
		
		BoardVO board = new BoardVO();
		board.setId(id);
		board.setPass(pass);
		board.setName(name);
		board.setBirth(birth);
		board.setEmail(email);
		board.setHp(hp);
		board.setAdnum(adnum);
		
		boardService.insertBoard(board);
		
		System.out.println("=========================================================================================");
		System.out.println("회원가입을 완료했습니다.");
		
		BoardUI boardUI = new BoardUI();
		boardUI.execute();
		
	}

	
}
