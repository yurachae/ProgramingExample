package p20181109;

public class Login {
	private String id;
	private String pass;
	
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
	
	public void login(String id, String pass) {
		if(this.id.equals(id) && this.pass.equals(pass))
			System.out.println(id+"님 로그인 되었습니다.");
		else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}
	}
	public void logout() {
		System.out.println(id+"님 로그아웃 되었습니다.");
	}
}
