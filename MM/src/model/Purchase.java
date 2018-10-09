package model;

public class Purchase {
private int employeeid;
private int categoryid;
private int subcategoryid;
private int transactionid;
private int productid;
private String invoiceno;
private String dateofinvoice;
private String firmname;
private int quantity;
private String batchno;
private int price;
private int totalamount;
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
public int getTransactionid() {
	return transactionid;
}
public void setTransactionid(int transactionid) {
	this.transactionid = transactionid;
}
public int getProductid() {
	return productid;
}
public void setProductid(int productid) {
	this.productid = productid;
}
public String getInvoiceno() {
	return invoiceno;
}
public void setInvoiceno(String invoiceno) {
	this.invoiceno = invoiceno;
}
public String getDateofinvoice() {
	return dateofinvoice;
}
public void setDateofinvoice(String dateofinvoice) {
	this.dateofinvoice = dateofinvoice;
}
public String getFirmname() {
	return firmname;
}
public void setFirmname(String firmname) {
	this.firmname = firmname;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public String getBatchno() {
	return batchno;
}
public void setBatchno(String batchno) {
	this.batchno = batchno;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getTotalamount() {
	return totalamount;
}
public void setTotalamount(int totalamount) {
	this.totalamount = totalamount;
}

}
