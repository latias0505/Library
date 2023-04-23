package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class SearchAllUI extends BaseUI {

	private BoardService boardService;
	
	public SearchAllUI() {
//		boardService = new BoardService();
		boardService = BoardServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {
		List<BoardVO> boardList = boardService.selectAll();
		
		System.out.println("=========================================================================================");
		System.out.println("NO\t글쓴이\t등록일\t\t제목");
		System.out.println("=========================================================================================");
		
		if(boardList == null || boardList.size() == 0) {
			System.out.println("=========================================================================================");
			System.out.println("\t게시글이 존재하지 않습니다");
			System.out.println("=========================================================================================");
		} else {
			for(BoardVO board : boardList) {
				System.out.println(board.getId() + "\t"
							+ board.getName() + "\t" 
							+ board.getBirth() + "\t"
							+ board.getPass());
			}
		}
		System.out.println("=========================================================================================");
	}
}










