package GLA2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
	//ToDo
	//Declare member variables / stack / Other data structure as per requirements 
	private StringBuilder postfix;
	private Stack<Character> stack;
    
	public  String getInfixToPostfix(String s)
	{
		//ToDo     
        // initialize postfix and operator stack to empty    
    	postfix = new StringBuilder();
        stack = new Stack<>();
        
        String result = "";
        int i = 0; 
        
        while (i < s.length()) {
        	
        	// get next token
            char token = s.charAt(i);

            //check if token is an operand
            if (processOperator(token) < 0) {
            	
            	// append it to postfix
            	postfix.append(token);

            //check if token is an operator
            } else if (processOperator(token) > 0){
            	
            	// check if the operator stack is empty and 
            	// peek the operator stack for the precedence of the operator
                while (stack.isEmpty() == false && 
                	  processOperator(stack.peek()) >= processOperator(token)) {

                	// pop off the stack and append it to postfix
                	postfix.append(" ");
                	postfix.append(stack.pop()); 
                }
                
                // push the operator onto the stack
                stack.push(token);
                
            // Invalid syntax
            } else {

            	result = "Syntax error!";
            }
           
            i++;
        }
        
        // pop remaining operators off the operator stack and append them to postfix
        for (int j = 0; j <= stack.size(); j++) {
        	
        	if (j <= stack.size()) {

        		postfix.append(" ");
        	}

            postfix.append(stack.pop());
        }

        // check if postfix is not empty
        if (postfix != null) {
        	
        	// remove extra whitespace
            result = postfix.toString();
            result = result.trim().replaceAll("[ ]{2,}", " ");
        }

        return result;
	}
	
    int processOperator(char token)
    {
    	// check if the token is an operator then proceed with the precedence
        switch (token) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '%':
                return 3;
        }
        
        return -1;
	}
}
