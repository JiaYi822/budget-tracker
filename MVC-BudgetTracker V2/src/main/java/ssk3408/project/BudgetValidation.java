package ssk3408.project;

import java.util.ArrayList;

public class BudgetValidation {
	
	public ArrayList<String> validateBudget(ArrayList<String> expenses, ArrayList<String> budgets) {
		
		ArrayList<String> output = new ArrayList<String>();
				
		// check if the list is empty or not
		
        if (budgets.get(0) == "" || budgets.get(1) == "" || budgets.get(2) == "" || budgets.get(3) == "" || budgets.get(4) == "") {
        	output.add("Incomplete budgets");
        } else {
        	output.add("Budgets found");    
        	
        	int cnt = 0;
        	
        	for (String input : budgets) { 	
        		
        		try {
        	        int i = Integer.parseInt(input);
        	        //int value
        	        cnt++;
        	    } catch (NumberFormatException e) {
        	        if (input.matches("-?\\d+(\\.\\d+)?")) {
        	            double d = Double.parseDouble(input);
        	            //double value
        	            cnt++;
        	        } else {                 
        	        	//string value
        	            System.out.println("string");
        	        }
        	    }        		
        		
            }
        	
        	if (cnt == 5) {
            	output.add("Correct values");   
            	
            	// budget
                double bAccommodation = Double.parseDouble(budgets.get(0));
                double bFood = Double.parseDouble(budgets.get(1));
                double bOutgoingTransfer = Double.parseDouble(budgets.get(2));
                double bShopping = Double.parseDouble(budgets.get(3));
                double bTransportation = Double.parseDouble(budgets.get(4));	      
            	
            	// expenses
                double eAccommodation = Double.parseDouble(expenses.get(0));
                double eFood = Double.parseDouble(expenses.get(1));
                double eOutgoingTransfer = Double.parseDouble(expenses.get(2));
                double eShopping = Double.parseDouble(expenses.get(3));
                double eTransportation = Double.parseDouble(expenses.get(4));	 
                
                // Checking for over spending budget
                if (eAccommodation > bAccommodation)
                	output.add("Accommodation expense over budget");   
                else
                	output.add("Accommodation expense within budget");   
                
                if (eFood > bFood)
                	output.add("Food expense over budget");   
                else
                	output.add("Food expense within budget");   
                
                if (eOutgoingTransfer > bOutgoingTransfer)
                	output.add("Outgoing Transfer expense over budget");   
                else
                	output.add("Outgoing Transfer expense within budget");   
                
                if (eShopping > bShopping)
                	output.add("Shopping expense over budget");   
                else
                	output.add("Shopping expense within budget");   
                
                if (eTransportation > bTransportation)
                	output.add("Transportation expense over budget");   
                else
                	output.add("Transportation expense within budget");   
                        		        		
        	} else {
            	output.add("Found string value");    
        	}	
        
        }	
        
		return output;	
	}

}
