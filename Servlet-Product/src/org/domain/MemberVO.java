package org.domain;
 
/*
create table t_member(
	number INT(11) NOT NULL AUTO_INCREMENT,
	id VARCHAR(50) NOT NULL, 
	pw VARCHAR(50) NOT NULL, 
	name VARCHAR(30) NOT NULL, 
	phone VARCHAR(50) NOT NULL, 
	PRIMARY KEY(number, id)
);
 */

public class MemberVO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	
	public String getPw() { return pw; }
	public void setPw(String pw) { this.pw = pw; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + "]";
	}
	
}