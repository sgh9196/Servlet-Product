package org.domain;

/* 
CREATE TABLE t_product(
	number INT(11) NOT NULL AUTO_INCREMENT, 
	pName VARCHAR(100), 
	pCount INT(11), 
	pMoney INT(11), 
	pStandard DOUBLE, 
	firstDate DATETIME DEFAULT CURRENT_TIMESTAMP, 
	inDate DATETIME, 
	Day INT(11) DEFAULT 10, 
	PRIMARY KEY(number, pName)
);
 */

public class ProductVO {
	
	private String pName;				// 상품명
	private int pCount;					// 수량
	private int pMoney;					// 단가
	private double pStandard;			// 규격
	private String firstDate;			// 제조일
	private String inDate;				// 입고일
	private String Day;					// 유통기한
	
	public String getpName() { return pName; }
	public void setpName(String pName) { this.pName = pName; }
	
	public int getpCount() { return pCount; }
	public void setpCount(int pCount) { this.pCount = pCount; }
	
	public int getpMoney() { return pMoney; }
	public void setpMoney(int pMoney) { this.pMoney = pMoney; }
	
	public double getpStandard() { return pStandard; }
	public void setpStandard(double pStandard) { this.pStandard = pStandard; }
	
	public String getFirstDate() { return firstDate; }
	public void setFirstDate(String firstString) { this.firstDate = firstString; }
	
	public String getinDate() { return inDate; }
	public void setinDate(String inDate) { this.inDate = inDate; }
	
	public String getDay() { return Day; }
	public void setDay(String day) { Day = day; }
	
	@Override
	public String toString() {
		return "ProductVO [pName=" + pName + ", pCount=" + pCount + ", pMoney=" + pMoney + ", pStandard=" + pStandard
				+ ", firstString=" + firstDate + ", inDate=" + inDate + ", Day=" + Day + "]";
	}
	
}