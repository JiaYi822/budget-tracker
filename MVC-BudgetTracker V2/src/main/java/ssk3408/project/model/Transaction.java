package ssk3408.project.model;

public class Transaction {
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	//private String type; // Income or expense
	private String category;
	private String amount;
	private String date;
	private String time;
	private String userName;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
