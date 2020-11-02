package edu.osu.cse5234.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "CARD_NUM")
	private String creditCardNumber;
	
	@Column(name = "EXP_DATE")
	private String exprDate;
	
	@Column(name = "CVV")
	private String cvvCode;
	
	@Column(name = "HOLDER_NAME")
	private String cardholderName;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID")
	private int id;
	
	public PaymentInfo() {
		setCreditCardNumber("");
		setExprDate("");
		setCvvCode("");
		setCardholderName("");
		setId(0);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
