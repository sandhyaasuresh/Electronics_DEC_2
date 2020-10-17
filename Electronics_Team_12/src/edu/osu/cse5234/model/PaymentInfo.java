package edu.osu.cse5234.model;

import java.io.Serializable;

public class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String creditCardNumber;
	private String exprDate;
	private String cvvCode;
	private String cardholderName;
	
	public PaymentInfo() {
		setCreditCardNumber("");
		setExprDate("");
		setCvvCode("");
		setCardholderName("");
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExprDate() {
		return exprDate;
	}

	public void setExprDate(String exprDate) {
		this.exprDate = exprDate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}
}
