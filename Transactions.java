package tkt_booking;

import java.security.Timestamp;

public class Transactions {
	private int id;
	private Timestamp txnDate;
	private int bookingNumber;
	private double txnAmt;
	private String txnStatus;
	private int paymentMethodId;

	// Getters and setters
	public int getId() {
	    return id;
	}

	public void setId(int id) {
	    this.id = id;
	}

	public Timestamp getTxnDate() {
	    return txnDate;
	}

	public void setTxnDate(Timestamp txnDate) {
	    this.txnDate = txnDate;
	}

	public int getBookingNumber() {
	    return bookingNumber;
	}

	public void setBookingNumber(int bookingNumber) {
	    this.bookingNumber = bookingNumber;
	}

	public double getTxnAmt() {
	    return txnAmt;
	}

	public void setTxnAmt(double txnAmt) {
	    this.txnAmt = txnAmt;
	}

	public String getTxnStatus() {
	    return txnStatus;
	}

	public void setTxnStatus(String txnStatus) {
	    this.txnStatus = txnStatus;
	}

	public int getPaymentMethodId() {
	    return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
	    this.paymentMethodId = paymentMethodId;
	}

}
