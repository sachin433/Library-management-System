package com.comviva.bookshelf;

import java.sql.Date;

public class Transaction {
	String empId;
	String bookNo;
	String bookName;
	String DOIssue;
	String DOReturn;
	Transaction(){
		empId=null;
		bookNo=null;
		DOIssue=DOReturn=null;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String EmpId) {
		this.empId = EmpId;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName=bookName;
	}
	@Override
	public String toString() {
		return "Transaction [empId=" + empId + ", bookNo=" + bookNo + ", bookName=" + bookName + ", DOIssue=" + DOIssue
				+ ", DOReturn=" + DOReturn + "]";
	}
	public String getDOIssue() {
		return DOIssue;
	}
	public void setDOIssue(String dOIssue) {
		DOIssue = dOIssue;
	}
	public String getDOReturn() {
		return DOReturn;
	}
	public void setDOReturn(String dOReturn) {
		DOReturn = dOReturn;
	}
}
