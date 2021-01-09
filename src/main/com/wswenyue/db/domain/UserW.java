package main.com.wswenyue.db.domain;

import javax.persistence.criteria.CriteriaBuilder;

public class UserW {
	
	private String username;
	private String password;
	private String name;
	private Integer age;
	private String sex;
	private String ID_number;
	private String phone_number;
	private String Face_ID=null;
	private Integer VIP_level=null;


	private Integer balance=null;
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getID_number() {
		return ID_number;
	}

	public void setID_number(String ID_number) {
		this.ID_number = ID_number;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}



	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public UserW() {
	}

	public UserW(String username, String password, String name, Integer age, String sex, String ID_number, String phone_number, String Face_ID, Integer balance) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.ID_number = ID_number;
		this.phone_number = phone_number;
		Face_ID=null;
		balance=null;

	}

	@Override
	public String toString() {
		return "UserW{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				", sex='" + sex + '\'' +
				", ID_number='" + ID_number + '\'' +
				", phone_number='" + phone_number + '\'' +
				", Face_ID='" + Face_ID + '\'' +
				", VIP_level=" + VIP_level +
				", balance=" + balance +
				'}';
	}
}
