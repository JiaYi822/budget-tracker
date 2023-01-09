import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import ssk3408.project.BudgetValidation;

class TestCase {

	@Test
	void testCase1() {

		BudgetValidation bv = new BudgetValidation();
		ArrayList<String> expenses = new ArrayList<String>();		
		ArrayList<String> budgets = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> expectedOutput = new ArrayList<String>();
		
		expenses = getExpenses();
		budgets = getBudgets1();
		expectedOutput = getExpectedOutput1();
		
		output = bv.validateBudget(expenses, budgets);
		
		assertArrayEquals(expectedOutput.toArray(), output.toArray());		
	}
	
	@Test
	void testCase2() {

		BudgetValidation bv = new BudgetValidation();
		ArrayList<String> expenses = new ArrayList<String>();		
		ArrayList<String> budgets = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> expectedOutput = new ArrayList<String>();
		
		expenses = getExpenses();
		budgets = getBudgets2();
		expectedOutput = getExpectedOutput2();
		
		output = bv.validateBudget(expenses, budgets);
		
		assertArrayEquals(expectedOutput.toArray(), output.toArray());		
	}
	
	@Test
	void testCase3() {

		BudgetValidation bv = new BudgetValidation();
		ArrayList<String> expenses = new ArrayList<String>();		
		ArrayList<String> budgets = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> expectedOutput = new ArrayList<String>();
		
		expenses = getExpenses();
		budgets = getBudgets3();
		expectedOutput = getExpectedOutput3();
		
		output = bv.validateBudget(expenses, budgets);
		
		assertArrayEquals(expectedOutput.toArray(), output.toArray());		
	}
	
		
	@Test
	void testCase4() {

		BudgetValidation bv = new BudgetValidation();
		ArrayList<String> expenses = new ArrayList<String>();		
		ArrayList<String> budgets = new ArrayList<String>();
		ArrayList<String> output = new ArrayList<String>();
		ArrayList<String> expectedOutput = new ArrayList<String>();
		
		expenses = getExpenses();
		budgets = getBudgets4();
		expectedOutput = getExpectedOutput4();
		
		output = bv.validateBudget(expenses, budgets);
		
		assertArrayEquals(expectedOutput.toArray(), output.toArray());		
	}
	
	
	
	public ArrayList<String> getExpectedOutput1() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Incomplete details");
		
		return output;
	}
	
	public ArrayList<String> getExpectedOutput2() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Details found");
		output.add("Correct values");		
		output.add("Low Monthly Budget : Below than RM1,000.00");
		output.add("Low Yearly Budget : Below than RM12,000.00");		
		
		return output;
	}
	
	public ArrayList<String> getExpectedOutput3() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Accommodation expense within budget");
		output.add("Food expense within budget");
		output.add("Outgoing Transfer expense within budget");
		output.add("Shopping expense within budget");
		output.add("Transportation expense within budget");
		
		return output;
	}
		
	public ArrayList<String> getExpectedOutput4() {
		ArrayList<String> output = new ArrayList<String>();
		
		output.add("Details found");
		output.add("Found string value");		

		
		return output;
	}
	
	public ArrayList<String> getExpenses() {
		
		ArrayList<String> expenses = new ArrayList<String>();		
		
		expenses.add("200");
		expenses.add("200");
		expenses.add("300");
		expenses.add("400");
		expenses.add("500");
		
		return expenses;
	}
	
	
	
	public ArrayList<String> getBudgets1() {
		
		ArrayList<String> budgets = new ArrayList<String>();		
		
		budgets.add("");
		budgets.add("");
		budgets.add("");
		budgets.add("");
		budgets.add("");
		
		return budgets;
	}
	
	public ArrayList<String> getBudgets2() {
		
		ArrayList<String> budgets = new ArrayList<String>();		
		
		budgets.add("200");
		budgets.add("300");
		budgets.add("400");
		budgets.add("500");
		budgets.add("600");
		
		return budgets;
	}
	
	public ArrayList<String> getBudgets3() {
		
		ArrayList<String> budgets = new ArrayList<String>();		
		
		budgets.add("100");
		budgets.add("100");
		budgets.add("100");
		budgets.add("100");
		budgets.add("100");
		
		return budgets;
	}		
	
	public ArrayList<String> getBudgets4() {
		
		ArrayList<String> budgets = new ArrayList<String>();		
		
		budgets.add("100");
		budgets.add("200.50");
		budgets.add("-");
		budgets.add("-");
		budgets.add("-");
		
		return budgets;
	}
	
	
	
//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
