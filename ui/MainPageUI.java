package kr.ac.kopo.ui;

import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.dao.BoardDAO;
import kr.ac.kopo.vo.BoardVO2;

public class MainPageUI extends BaseUI { 
	
	private String userId;
    
    public MainPageUI(String userId) {
        this.userId = userId;
    }

	public MainPageUI() {
		
	}

	private int menu() {
		System.out.println("=========================================================================================");
		System.out.println("\t메인페이지");
		System.out.println("=========================================================================================");
		System.out.println("1. 마이페이지");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 대여");
		System.out.println("4. 도서 반납");
		System.out.println("5. 로그아웃");
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
				ui = new MyPageUI(userId);
				break;
			case 2:
				System.out.println("=========================================================================================");
			    System.out.print("도서 이름을 입력하세요 : ");
			    Scanner sc = new Scanner(System.in);
			    String bookName = sc.nextLine();
			    List<BoardVO2> books = BoardDAO.selectBooksByTitle(bookName);
			    if (books.isEmpty()) {
			    	System.out.println("=========================================================================================");
			        System.out.println("검색 결과가 없습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			        for (BoardVO2 book : books) {
			            System.out.printf("%s / %s / %s / %s / %s\n",
			                book.getCode(), book.getBook(), book.getWriter(),
			                book.getShop(), book.getWho());
			        }
			    }
			    break;
			case 3:
				System.out.println("=========================================================================================");
			    System.out.print("도서 이름을 입력하세요 : ");
			    Scanner scanner = new Scanner(System.in);
			    String bookName1 = scanner.nextLine();
			    List<BoardVO2> books1 = BoardDAO.selectBooksByTitle(bookName1);
			    if (books1.isEmpty()) {
			    	System.out.println("=========================================================================================");
			        System.out.println("검색 결과가 없습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			        for (BoardVO2 book : books1) {
			        	System.out.println("=========================================================================================");
			            System.out.printf("%s / %s / %s / %s / %s\n",
			                book.getCode(), book.getBook(), book.getWriter(),
			                book.getShop(), book.getWho());
			        }
			        System.out.println("=========================================================================================");
			        System.out.print("대여할 도서의 코드를 입력하세요 : ");
			        String bookCode = scanner.nextLine();
			        BoardVO2 selectedBook = null;
			        for (BoardVO2 book : books1) {
			            if (book.getCode().equals(bookCode)) {
			                selectedBook = book;
			                break;
			            }
			        }
			        if (selectedBook == null) {
			        	System.out.println("=========================================================================================");
			            System.out.println("해당 도서는 존재하지 않습니다.");
			            System.out.println("=========================================================================================");
			        } else if (!selectedBook.getWho().equals("대여자 없음")) {
			        	System.out.println("=========================================================================================");
			            System.out.println("해당 도서는 이미 대여 중입니다.");
			            System.out.println("=========================================================================================");
			        } else {
			            BoardDAO.updateBookWho(bookCode, userId);
			            System.out.println("=========================================================================================");
			            System.out.println("도서 대여가 완료되었습니다.");
			        }
			    }
			    break;
			case 4:
				System.out.println("=========================================================================================");
			    System.out.print("반납할 도서의 이름을 입력하세요 : ");
			    Scanner scanner1 = new Scanner(System.in);
			    String bookName2 = scanner1.nextLine();
			    List<BoardVO2> books2 = BoardDAO.selectBooksByTitle(bookName2);
			    if (books2.isEmpty()) {
			    	System.out.println("=========================================================================================");
			        System.out.println("검색 결과가 없습니다.");
			        System.out.println("=========================================================================================");
			    } else {
			        for (BoardVO2 book : books2) {
			        	System.out.println("=========================================================================================");
			            System.out.printf("%s / %s / %s / %s / %s\n",
			                book.getCode(), book.getBook(), book.getWriter(),
			                book.getShop(), book.getWho());
			        }
			        System.out.println("=========================================================================================");
			        System.out.print("반납할 도서의 코드를 입력하세요 : ");
			        String bookCode = scanner1.nextLine();
			        BoardVO2 selectedBook = null;
			        for (BoardVO2 book : books2) {
			            if (book.getCode().equals(bookCode)) {
			                selectedBook = book;
			                break;
			            }
			        }
			        if (selectedBook == null) {
			        	System.out.println("=========================================================================================");
			            System.out.println("해당 도서는 존재하지 않습니다.");
			            System.out.println("=========================================================================================");
			        } else if (!selectedBook.getWho().equals(userId)) {
			        	System.out.println("=========================================================================================");
			            System.out.println("해당 도서는 대여하신 도서가 아닙니다.");
			            System.out.println("=========================================================================================");
			        } else {
			            BoardDAO.updateBookWho(bookCode, "대여자 없음");
			            System.out.println("=========================================================================================");
			            System.out.println("도서 반납이 완료되었습니다.");
			        }
			    }
			    break;
			case 5:
				ui = new BoardUI();
				break;
			case 6:
				ui = new ExitUI();
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









