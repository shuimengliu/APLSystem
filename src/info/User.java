package info;
public class User {

	private String id; //	id
	private String userName; //姓名
	private String password; //密码
	private String number;	//学号
	private String realName; //姓名
	private String character;


	public User(String id, String userName, String password, String number, String realName, String character) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.number = number;
		this.realName = realName;
		this.character = character;
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", number='" + number + '\'' +
				", realName='" + realName + '\'' +
				", character='" + character + '\'' +
				'}';
	}
}
