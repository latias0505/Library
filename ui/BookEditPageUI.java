package kr.ac.kopo.ui;

import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO2;

public class BookEditPageUI extends BaseUI {  

	private int menu() {
		 System.out.println("=========================================================================================");
		System.out.println("\t도서 관리 페이지");
		 System.out.println("=========================================================================================");
		System.out.println("1. 도서 조회");
		System.out.println("2. 도서 등록");
		System.out.println("3. 도서 삭제");
		System.out.println("4. 대출중인 도서 조회");
		System.out.println("5. 뒤로가기");
		System.out.println("6. 종료");
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
				List<BoardVO2> bookList = BoardDAO.selectAllBoard2();
				 System.out.println("=========================================================================================");
				System.out.printf("%-10s %-30s %-20s %-20s %-10s\n", 
				        "도서번호", "도서명", "저자명", "출판사", "대여자");
				 System.out.println("=========================================================================================");
				for(BoardVO2 book : bookList) {
					 System.out.println("=========================================================================================");
				    System.out.printf("%-10s %-30s %-20s %-20s %-10s\n", 
				            book.getCode(), book.getBook(), book.getWriter(), 
				            book.getShop(), String.valueOf(book.getWho()));
				}
				 System.out.println("=========================================================================================");
			    break;
			case 2:
				ui = new BookPlusUI();
				break;
			case 3:
				 System.out.println("=========================================================================================");
			    System.out.print("삭제할 도서의 코드를 입력하세요 : ");
			    System.out.println("=========================================================================================");
			    Scanner sc = new Scanner(System.in);
			    String deleteCode = sc.nextLine();
			    int deleteResult = BoardDAO.deleteBook(deleteCode);
			    if(deleteResult > 0) {
			    	 System.out.println("=========================================================================================");
			        System.out.println("도서가 삭제되었습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			    	 System.out.println("=========================================================================================");
			        System.out.println("도서 삭제에 실패하였습니다.");
			        System.out.println("=========================================================================================");
			    }
			    break;
			case 4:
			    List<BoardVO2> rentedBooks = BoardDAO.selectRentedBooks();
			    if (rentedBooks.isEmpty()) {
			    	 System.out.println("=========================================================================================");
			        System.out.println("현재 대출중인 도서가 없습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			    	 System.out.println("=========================================================================================");
			        System.out.printf("%-10s %-30s %-20s %-20s %-10s\n", 
			                "도서번호", "도서명", "저자명", "출판사", "대여자");
			        System.out.println("=========================================================================================");
			        for (BoardVO2 book : rentedBooks) {
			            if (!book.getWho().equals("대여자 없음")) {
			            	System.out.println("=========================================================================================");
			                System.out.printf("%-10s %-30s %-20s %-20s %-10s\n", 
			                        book.getCode(), book.getBook(), book.getWriter(), 
			                        book.getShop(), book.getWho());
			            }
			            System.out.println("=========================================================================================");
			        }
			    }
			    break;
			case 5:
				ui = new AdminPageUI();
				break;
			case 6:
				ui = new ExitUI();
				break;
			}
			
			if(ui != null) {
				ui.execute();
			} else if(type != 1 && type != 2 && type != 3 && type != 4 && type != 5 && type != 6) {
				 System.out.println("=========================================================================================");
				System.out.println("잘못입력하셨습니다");
			}
		}
	}
}









