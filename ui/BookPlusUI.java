package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;
import kr.ac.kopo.vo.BoardVO2;

public class BookPlusUI extends BaseUI {

	private BoardService boardService;

	public BookPlusUI() {
		boardService = BoardServiceFactory.getInstance();
	}


	@Override
	public void execute() throws Exception {
		String who = "대여자 없음";
		
		System.out.println("=========================================================================================");
	    System.out.println("\t도서 등록");
	    System.out.println("=========================================================================================");
	
        String code = scanStr("등록할 책 코드를 입력해주세요 : ");
 	       
		String book  = scanStr("책 이름을 입력해주세요 : ");

        String writer = scanStr("작가를 입력해주세요 : ");
 
        String shop = scanStr("출판사를 입력해주세요 : ");
		
		BoardVO2 board = new BoardVO2();
		board.setCode(code);
		board.setBook(book);
		board.setWriter(writer);
		board.setShop(shop);
		board.setWho(who);
		
		boardService.insertBoard2(board);
		
		System.out.println("=========================================================================================");
		System.out.println("도서 등록을 완료했습니다.");
		System.out.println("=========================================================================================");
		
		BookEditPageUI bookEditpage = new BookEditPageUI();
		bookEditpage.execute();
		
	}

	
}
