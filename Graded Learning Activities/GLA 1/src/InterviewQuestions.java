import java.util.ArrayList;
import java.util.stream.Collectors;

public class InterviewQuestions {

	// O(n)
	public int findPriceyNeighbours(double[] prices)
	{
		//ToDo
	    double sum1 = 0;
	    double sum2 = 0;
	    double prevSum = 0;
	    double overallSum = 0;
	    double max = 0;
	    int index = -1;
	    
	    for (int i = 1; i < prices.length-1; i++) {	    	
	    	sum1 = prices[i] + prices[i - 1];
 	    	sum2 = prices[i] + prices[i + 1];
	    	
	    	overallSum = sum1 + sum2 + prevSum;
	        
	        if (overallSum > max) {
	        	max = overallSum; 
	        	index = i - 1;
	        }
	        
	        prevSum = sum2;
	    }
		
		return index;
	}
	
	
	// O(n)
	public ArrayList<String> commonFriends(ArrayList<String> friendListOne, ArrayList<String> friendListTwo)
	{
		ArrayList<String> common=new ArrayList<String>();
		//ToDo
		friendListOne.retainAll(friendListTwo);
		common = friendListOne;
		
		return common;
	}
	
	// O(n2)
	public int countDivisors(int[] values)
	{
		//ToDo
		int count = 0;
		 
	    for (int i = 0; i < values.length; i++) {
	        for (int j = i + 1; j < values.length; j++) {
		        if (values[i] % values[j] == 0) {
		        	count++;
		        }
	        }
	    }
	    
		return count;
	}
	
	// O(n)
	public int findIndexOfFirstOddNumber(int[] numbers)
	{
		//ToDo
		for(int i = 0; i < numbers.length; i++){
			if (numbers[i] % 2 != 0) {
				return i;
            }
		}
		
		return -1;
	}
}
