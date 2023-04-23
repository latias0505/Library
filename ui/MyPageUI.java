package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;

public class MyPageUI extends BaseUI {  
	
	private String userId;
	
	public MyPageUI(String userId) {
		this.userId = userId;
	}

	private int menu() {
		System.out.println("=========================================================================================");
		System.out.println("\t마이페이지");
		System.out.println("=========================================================================================");
		System.out.println("1. 개인정보 출력");
		System.out.println("2. 대여목록 확인");
		System.out.println("3. 개인정보 수정");
		System.out.println("4. 탈퇴");
		System.out.println("5. 뒤로가기");
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
			    try (Connection conn = new ConnectionFactory().getConnection();
			         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM new_board WHERE id = ?")) {
			        pstmt.setString(1, userId);
			        ResultSet rs = pstmt.executeQuery();
			        if (rs.next()) {
			        	System.out.println("=========================================================================================");
			            System.out.println("사용자 정보 출력");
			            System.out.print("아이디 : " + rs.getString("id"));
			            System.out.print("\t비밀번호 : " + rs.getString("pass"));
			            System.out.print("\t이름 : " + rs.getString("name"));
			            System.out.print("\t생년월일 : " + rs.getString("birth"));
			            System.out.print("\t이메일 : " + rs.getString("email"));
			            System.out.println("\t전화번호 : " + rs.getString("hp"));
			            System.out.println("=========================================================================================");
			        } else {
			        	System.out.println("=========================================================================================");
			            System.out.println("해당하는 사용자가 존재하지 않습니다.");
			            System.out.println("=========================================================================================");
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;
			case 2:
			    try (Connection conn = new ConnectionFactory().getConnection();
			         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM book_board WHERE who = ?")) {
			        pstmt.setString(1, userId);
			        ResultSet rs = pstmt.executeQuery();
			        if (!rs.next()) {
			        	System.out.println("=========================================================================================");
			            System.out.println("대여한 책이 없습니다.");
			            System.out.println("=========================================================================================");
			        } else {
			            do {
			            	System.out.println("=========================================================================================");
			                System.out.print("도서코드 : " + rs.getString("code"));
			                System.out.print("\t도서명 : " + rs.getString("book"));
			                System.out.print("\t작가 : " + rs.getString("writer"));
			                System.out.print("\t서점 : " + rs.getString("shop"));
			                System.out.println("\t대여자 : " + rs.getString("who"));
			                System.out.println("=========================================================================================");
			            } while (rs.next());
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;
			case 3:
			    try (Connection conn = new ConnectionFactory().getConnection();
			         PreparedStatement pstmt = conn.prepareStatement(
			                 "UPDATE new_board SET name=?, birth=?, email=?, hp=? WHERE id=?")) {
			    	System.out.println("=========================================================================================");
			        System.out.println("\t개인정보 수정");
			        System.out.println("=========================================================================================");
			        Scanner sc = new Scanner(System.in);
			        
			        System.out.print("새 이름 : ");
			        String name = sc.nextLine();
			       
			        System.out.print("새 생년월일 : ");
			        String birth = sc.nextLine();
			        
			        System.out.print("새 이메일 : ");
			        String email = sc.nextLine();
			       
			        System.out.print("새 전화번호 : ");
			        String hp = sc.nextLine();		       
			 
			        pstmt.setString(1, name);
			        pstmt.setString(2, birth);
			        pstmt.setString(3, email);
			        pstmt.setString(4, hp);
			        pstmt.setString(5, userId);
			        int updatedCount = pstmt.executeUpdate();

			        if(updatedCount > 0) {
			        	System.out.println("=========================================================================================");
			            System.out.println("데이터가 수정되었습니다.");
			        } else {
			        	System.out.println("=========================================================================================");
			            System.out.println("데이터 수정에 실패하였습니다.");
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;
			case 4:
			    try (Connection conn2 = new ConnectionFactory().getConnection();
			         PreparedStatement pstmt2 = conn2.prepareStatement("DELETE FROM new_board WHERE id = ?")) {
			        pstmt2.setString(1, userId);
			        int deletedCount = pstmt2.executeUpdate();

			        if(deletedCount > 0) {
			        	System.out.println("=========================================================================================");
			            System.out.println("데이터가 삭제되었습니다.");
			            System.out.println("=========================================================================================");
			            ui = new BoardUI();
			        } else {
			        	System.out.println("=========================================================================================");
			            System.out.println("데이터 삭제에 실패하였습니다.");
			            System.out.println("=========================================================================================");
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    break;
			case 5:
				ui = new MainPageUI(userId);
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else if(type != 1 && type != 2 && type != 3 && type != 4 && type != 5) {
				System.out.println("=========================================================================================");
				System.out.println("잘못입력하셨습니다");
			}
		}
	}
}









