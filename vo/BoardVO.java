package kr.ac.kopo.vo;

public class BoardVO {

	private String id;
	private String pass;
	private String name;
	private String birth;
	private String email;
	private String hp;
	private String adnum;
	
	public BoardVO() {
		super();
	}

	public BoardVO(String id, String pass, String name, String birth, String email, String hp, String adnum) {
		super();
		this.id     = id;
		this.pass   = pass;
		this.name   = name;
		this.birth  = birth;
		this.email  = email;
		this.hp     = hp;
		this.adnum  = adnum;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}
	
	public String getAdnum() {
		return adnum;
	}

	public void setAdnum(String adnum) {
		this.adnum = adnum;
	}
	

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", pass=" + pass + ", name=" + name + ", birth=" + birth + ", email=" + email + ", hp=" + hp + ", adnum=" + adnum + "]";
	}
	
	
}
