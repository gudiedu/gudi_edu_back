package kr.happyjob.study.classroom.model;

public class SUserInfoModel {

	private String loginID;
	
	private String user_type;
	
	private String name;
	
	private String password;
	
	private String email;
	
	private String hp;

	public String getLoginID() {
		return loginID;
	}

	public String getUser_type() {
		return user_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	
}
