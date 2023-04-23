package kr.ac.kopo.vo;

public class BoardVO2 {

	private String code;
	private String book;
	private String writer;
	private String shop;
	private String who;
	
	public BoardVO2() {
		super();
	}
	
	public BoardVO2(String code, String book, String writer, String shop, String who) {
		super();
		this.code   = code;
		this.book   = book;
		this.writer = writer;
		this.shop   = shop;
		this.who    = who;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
    }
		
	public String getBook() {
		return book;
	}
	
	public void setBook(String book) {
		this.book = book;
	}
		
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
		
	public String getShop() {
		return shop;
	}
	
	public void setShop(String shop) {
		this.shop = shop;
	}
		
	public String getWho() {
		return who;
	}
	
	public void setWho(String who) {
		this.who = who;
	}

	@Override
	public String toString() {
		return "BoardVO2 [code=" + code + ", book=" + book + ", writer=" + writer + ", shop=" + shop + ", who=" + who + "]";
	}
	
	
}
