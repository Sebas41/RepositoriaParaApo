package model;

import java.util.Calendar;

public class Transaction {

	private Calendar date;
	private double purchaseValue;

	public Transaction(Calendar date, double purchaseValue) {

		this.date = date;
		this.purchaseValue = purchaseValue;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public void setBookName(String bookName) {
	}

}
