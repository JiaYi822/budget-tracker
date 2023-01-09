package ssk3408.project.model;

public class Report {
	private double totalIncome;
	private double totalExpense;
	public double getIncome() {
		return totalIncome;
	}
	public void setIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public double getExpense() {
		return totalExpense;
	}
	public void setExpense(double totalExpense) {
		this.totalExpense = totalExpense;
	}
	
	public double calcNetIncome(double totalIncome, double totalExpense) {
		return totalIncome-totalExpense;
		
	}
	
}
