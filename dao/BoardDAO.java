package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BoardVO;
import kr.ac.kopo.vo.BoardVO2;

/**
 * 오라클 DB new_board 테이블에 CRUD하는 DAO클래스
 * @author User
 *
 */
public class BoardDAO {

	//유저데이터
	public void insertBoard(BoardVO board) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into new_board(no, id, pass, name, birth, email, hp, adnum ) ");
		sql.append(" values(new_board_seq.nextval, ? , ? , ? , ? , ? , ? , ? ) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, board.getId());
			pstmt.setString(2, board.getPass());
			pstmt.setString(3, board.getName());
			pstmt.setString(4, board.getBirth());
			pstmt.setString(5, board.getEmail());
			pstmt.setString(6, board.getHp());
			pstmt.setString(7, board.getAdnum());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<BoardVO> selectAllBoard() {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, pass, name ");
		sql.append("     , to_char(birth, 'yyyy-mm-dd') as birth ");
		sql.append("     , email, hp, adnum ");
		sql.append("  from new_board ");
		sql.append(" order by no desc ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String id 	   = rs.getString("id");
				String pass    = rs.getString("pass");
				String name    = rs.getString("name");
				String birth   = rs.getString("birth");
				String email   = rs.getString("email");
				String hp      = rs.getString("hp");
				String adnum   = rs.getString("adnum");
				
				BoardVO board = new BoardVO();
				board.setId(id);
				board.setPass(pass);
				board.setName(name);
				board.setBirth(birth);
				board.setEmail(email);
				board.setHp(hp);
				board.setAdnum(adnum);
				
//				System.out.println(board);
				boardList.add(board);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public BoardVO selectBoardByNo(int boardNo) {
		
		BoardVO board = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, pass, name ");
		sql.append("     , to_char(birth, 'yyyy-mm-dd') as birth ");
		sql.append("     , email, hp, adnum ");
		sql.append("  from new_board ");
		sql.append(" order by no desc ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String id 	   = rs.getString("id");
				String pass    = rs.getString("pass");
				String name    = rs.getString("name");
				String birth   = rs.getString("birth");
				String email   = rs.getString("email");
				String hp      = rs.getString("hp");
				String adnum   = rs.getString("adnum");
				
				board  = new BoardVO(id, pass, name, birth, email, hp, adnum);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	//도서 데이터
	public void insertBoard2(BoardVO2 board) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into book_board(no, code, book, writer, shop, who ) ");
		sql.append(" values(book_board_seq.nextval, ? , ? , ? , ? , ? ) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, board.getCode());
			pstmt.setString(2, board.getBook());
			pstmt.setString(3, board.getWriter());
			pstmt.setString(4, board.getShop());
			pstmt.setString(5, board.getWho());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<BoardVO2> selectAllBoard2() {
		
		List<BoardVO2> boardList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select code, book, writer ");
		sql.append("     , shop, who ");
		sql.append("  from book_board ");
		sql.append(" order by no desc ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String code   = rs.getString("code");
				String book   = rs.getString("book");
				String writer = rs.getString("writer");
				String shop   = rs.getString("shop");
				String who    = rs.getString("who");
				
				BoardVO2 board = new BoardVO2();
				board.setCode(code);
				board.setBook(book);
				board.setWriter(writer);
				board.setShop(shop);
				board.setWho(who);
				
//				System.out.println(board);
				boardList.add(board);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return boardList;
	}
	
	public BoardVO2 selectBoardByNo2(int boardNo) {
		
		BoardVO2 board = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select code, book, writer ");
		sql.append("     , shop, who ");
		sql.append("  from new_board ");
		sql.append(" order by no desc ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, boardNo);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String code   = rs.getString("code");
				String book   = rs.getString("book");
				String writer = rs.getString("writer");
				String shop   = rs.getString("shop");
				String who    = rs.getString("who");
				
				board  = new BoardVO2(code, book, writer, shop, who);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	/**
	 * id, pass에 맞는 회원 존재여부 판단
	 */
	public boolean login(String id, String pass) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select * ");
		sql.append("  from new_board ");
		sql.append(" where id = ? and pass = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString())
		) {
			
			pstmt.setString(1,  id);
			pstmt.setString(2, pass);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs.next();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean admin(String pass, String adnum) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select *");
		sql.append("  from new_board");
		sql.append(" where pass = ? and adnum = ? ");
		
		try (
			 Connection conn = new ConnectionFactory().getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())
		){
			
			pstmt.setString(1, pass);
			pstmt.setString(2, adnum);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static List<BoardVO2> selectRentedBooks() {
	    List<BoardVO2> rentedBooks = new ArrayList<>();
	    try (
	        Connection conn = ConnectionFactory.getConnection();
	        PreparedStatement pstmt = conn.prepareStatement("SELECT code, book, writer, shop, who FROM book_board WHERE who != '대여자 없음'");
	        ResultSet rs = pstmt.executeQuery()
	    ) {
	        while (rs.next()) {
	            BoardVO2 book = new BoardVO2();
	            book.setCode(rs.getString("code"));
	            book.setBook(rs.getString("book"));
	            book.setWriter(rs.getString("writer"));
	            book.setShop(rs.getString("shop"));
	            book.setWho(rs.getString("who"));
	            rentedBooks.add(book);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return rentedBooks;
	}

	public static int deleteBook(String deleteCode) {
	    int result = 0;
	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(
	                 "DELETE FROM book_board WHERE code = ?")) {
	        pstmt.setString(1, deleteCode);
	        result = pstmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public static List<BoardVO2> selectBooksByTitle(String bookName) {
	    List<BoardVO2> books = new ArrayList<>();
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(
	             "SELECT code, book, writer, shop, who FROM book_board WHERE book LIKE ?")) {
	        pstmt.setString(1, "%" + bookName + "%");
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                BoardVO2 book = new BoardVO2();
	                book.setCode(rs.getString("code"));
	                book.setBook(rs.getString("book"));
	                book.setWriter(rs.getString("writer"));
	                book.setShop(rs.getString("shop"));
	                book.setWho(rs.getString("who"));
	                books.add(book);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return books;
	}

	public static void updateBookWho(String bookCode, String userId) throws Exception {
	    String sql = "UPDATE book_board SET who = ? WHERE code = ?";
	    try (Connection conn = ConnectionFactory.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, userId);
	        pstmt.setString(2, bookCode);
	        pstmt.executeUpdate();
	    }
	}
	
	
}






