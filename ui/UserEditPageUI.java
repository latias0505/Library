package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;

public class UserEditPageUI extends BaseUI {  

	private int menu() {
		 System.out.println("=========================================================================================");
		System.out.println("\t회원 관리 페이지");
		 System.out.println("=========================================================================================");
		System.out.println("1. 회원 조회");
		System.out.println("2. 회원 삭제");
		System.out.println("3. 회원 검색");
		System.out.println("4. 뒤로가기");
		System.out.println("5. 종료");
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
			    Connection conn = ConnectionFactory.getConnection();
			    Statement stmt = conn.createStatement();
			    ResultSet rs = stmt.executeQuery("SELECT * FROM new_board WHERE adnum = 'none'");

			    System.out.println("=========================================================================================");
			    System.out.printf("%-5s %-20s %-20s %-20s %-20s %-30s %-20s\n", "NO", "ID", "PASSWORD", "NAME", "BIRTH", "EMAIL", "PHONE NUMBER");
			    System.out.println("=========================================================================================");
			    while(rs.next()) {
			    	 System.out.println("=========================================================================================");
			        System.out.printf("%-5d %-20s %-20s %-20s %-20s %-30s %-20s\n", rs.getInt("no"), rs.getString("id"), rs.getString("pass"), rs.getString("name"), rs.getString("birth"), rs.getString("email"), rs.getString("hp"));
			        System.out.println("=========================================================================================");
			    }
			    rs.close();
			    stmt.close();
			    conn.close();
			    break;
			case 2:
				Scanner sc = new Scanner(System.in);
				 System.out.println("=========================================================================================");
			    System.out.print("삭제할 데이터의 번호를 입력하세요 : ");
			    int no = sc.nextInt();
			    sc.nextLine();
			    
			    Connection conn2 = ConnectionFactory.getConnection();
			    Statement stmt2 = conn2.createStatement();
			    String sql = "DELETE FROM new_board WHERE no = " + no;
			    int deletedCount = stmt2.executeUpdate(sql);

			    if(deletedCount > 0) {
			    	 System.out.println("=========================================================================================");
			        System.out.println("데이터가 삭제되었습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			    	 System.out.println("=========================================================================================");
			        System.out.println("데이터 삭제에 실패하였습니다.");
			        System.out.println("=========================================================================================");
			    }

			    stmt2.close();
			    conn2.close();
			    break;
			case 3:
			    Scanner scanner = new Scanner(System.in);
			    System.out.println("=========================================================================================");
			    System.out.print("검색할 이름을 입력하세요 : ");
			    String name = scanner.nextLine();
			    
			    Connection conn3 = ConnectionFactory.getConnection();
			    Statement stmt3 = conn3.createStatement();
			    ResultSet rs3 = stmt3.executeQuery("SELECT * FROM new_board WHERE name = '" + name + "'");

			    System.out.println("=========================================================================================");
			    System.out.printf("%-5s %-20s %-20s %-20s %-20s %-30s %-20s\n", "NO", "ID", "PASSWORD", "NAME", "BIRTH", "EMAIL", "PHONE NUMBER");
			    System.out.println("=========================================================================================");
			    while(rs3.next()) {
			    	System.out.println("=========================================================================================");
			        System.out.printf("%-5d %-20s %-20s %-20s %-20s %-30s %-20s\n", rs3.getInt("no"), rs3.getString("id"), rs3.getString("pass"), rs3.getString("name"), rs3.getString("birth"), rs3.getString("email"), rs3.getString("hp"));
			        System.out.println("=========================================================================================");
			    }
			    rs3.close();
			    stmt3.close();
			    conn3.close();
			    break;
			case 4:
				ui = new AdminPageUI();
				break;
			case 5:
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









