package model;

public class Issue {
private int employeeid;
private int categoryid;
private int subcategoryid;
private int productid;
private int transactionid;
private String issuedate;
private String issueto;
private String purpose;
private int quantity;
public int getEmployeeid() {
	return employeeid;
}
public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public int getSubcategoryid() {
	return subcategoryid;
}
public void setSubcategoryid(int subcategoryid) {
	this.subcategoryid = subcategoryid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public int getTransactionid() {
	return transactionid;
}
public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}
public String getIssuedate() {
	return issuedate;
}
public void setIssuedate(String issuedate) {
	this.issuedate = issuedate;
}
public String getIssueto() {
	return issueto;
}
public void setIssueto(String issueto) {
	this.issueto = issueto;
}
public String getPurpose() {
	return purpose;
}
public void setPurpose(String purpose) {
	this.purpose = purpose;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
