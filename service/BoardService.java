package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BoardVO;
import kr.ac.kopo.vo.BoardVO2;

public class BoardService {

	private BoardDAO boardDao;
	
	public BoardService() {
		boardDao = new BoardDAO();
	}
	
	public void insertBoard(BoardVO board) {

		
		boardDao.insertBoard(board);
	}
	
	public List<BoardVO> selectAll() {
		List<BoardVO> boardList = boardDao.selectAllBoard();
		return boardList;
	}
	
	public BoardVO selectByNo(int boardNo) {
		
		BoardVO board = boardDao.selectBoardByNo(boardNo);
		return board;
	}
	
	public void insertBoard2(BoardVO2 board) {

		
		boardDao.insertBoard2(board);
	}
	
	//도서 관련
	public List<BoardVO2> selectAll2() {
		List<BoardVO2> boardList = boardDao.selectAllBoard2();
		return boardList;
	}
	
	public BoardVO2 selectByNo2(int boardNo) {
		
		BoardVO2 board = boardDao.selectBoardByNo2(boardNo);
		return board;
	}
	
	public boolean logincheckUser(String id, String pass) {
		
		return boardDao.login(id, pass);
	}
	
	public boolean admincheckUser(String pass, String adnum) {
		
		return boardDao.admin(pass, adnum);
	}

	public boolean idcheckUser(String id) {
	    List<BoardVO> userList = boardDao.selectAllBoard();
	    for (BoardVO user : userList) {
	        if (user.getId().equals(id)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean namecheckUser(String name) {
	    List<BoardVO> userList = boardDao.selectAllBoard();
	    for (BoardVO user : userList) {
	        if (user.getName().equals(name)) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean emailcheckUser(String email) {
	    List<BoardVO> userList = boardDao.selectAllBoard();
	    for (BoardVO user : userList) {
	        if (user.getEmail().equals(email)) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean hpcheckUser(String hp) {
	    List<BoardVO> userList = boardDao.selectAllBoard();
	    for (BoardVO user : userList) {
	        if (user.getHp().equals(hp)) {
	            return true;
	        }
	    }
	    return false;
	}

	public boolean getAdnumById(String id) {
	    List<BoardVO> userList = boardDao.selectAllBoard();
	    for (BoardVO user : userList) {
	        if (user.getId().equals(id)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	
}


















