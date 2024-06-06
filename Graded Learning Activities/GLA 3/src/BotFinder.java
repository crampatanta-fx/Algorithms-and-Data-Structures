import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


//ToDo class

public class BotFinder {

	private Map<String, Map<String, Word>> userMap; // You can change this if you prefer
	private Map<String, String> account_tweets = new HashMap<>();
	
    /**
     * Create a bot finder with a set of accounts and tweets
     * @param accounts the list of account names
     * @param tweets List of each all tweets per account. tweets.get(i) contains
     *               all tweets for the account at accounts.get(i)
     */
    public BotFinder(List<String> accounts, List<String> tweets) {
    	//ToDo
    	    	
    	//calculate word frequency
    	account_tweets.put(accounts.get(0), tweets.get(0));
    	account_tweets.put(accounts.get(1), tweets.get(1));
    	account_tweets.put(accounts.get(2), tweets.get(2));
    }

    /**
     * Find the frequency of use of a specific word by a specific account.
     * @param accountName name of account
     * @param word word to find the frequency of
     * @return the frequency of use for the word by the account
     */
    public double getAccountWordFrequency(String accountName, String word) {
    	//ToDo
   	
    	//calculate the frequency for every word for a specific account (user)
    	int count = 0;
    	double frequency = 0.0;
    	double numberOfWords = 0.0;
    	
        for (Map.Entry<String, String> entry : account_tweets.entrySet()) {
        	
        	if (entry.getKey() == accountName) {

                String[] tweets = entry.getValue().split(" ");
                numberOfWords = tweets.length;

                for (String tweet : tweets) {
                	
                	tweet = cleanString(tweet);
                	tweet.replaceAll("\\W+", "");
                	
                	if (tweet.equals(word)) {
                		count++;
                		frequency = Double.valueOf(count / numberOfWords);
                	}
                }        	
        	}
        }
    	
        return frequency;
    }

    /**
     * Find the similarity of two accounts based off their word use frequency
     * @param accountOne first account to analyze
     * @param accountTwo second account to analyze
     * @return a similarity score between -1 and 1, representing the account similarity
     */
    public double getAccountSimilarity(String accountOne, String accountTwo) {
    	//ToDo

    	//Calculate similarity score between two accounts
    	Map<String, Double> frequenciesOne = new HashMap<>();
    	Map<String, Double> frequenciesTwo = new HashMap<>();
    	Set<String> allWords = new TreeSet<String>(); 
    	double numberOfWords = 0.0;
    	double frequency = 0.0;
    	double accountOneFrequency = 0.0;
    	double accountTwoFrequency = 0.0;
    	double totalFrequencies = 0.0;
    	
        for (Map.Entry<String, String> entry : account_tweets.entrySet()) {

        	if (entry.getKey() == accountOne || entry.getKey() == accountTwo) {

                String[] tweets = entry.getValue().split(" ");
                
                numberOfWords = tweets.length;

                for (String tweet : tweets) {
                	
                	tweet = cleanString(tweet);
                	frequency = getAccountWordFrequency(entry.getKey(), tweet);
                	
                	if (entry.getKey() == accountOne) {
                		frequenciesOne.put(tweet, frequency); 
                		allWords.add(tweet);
                	} else {
                		
                		frequenciesTwo.put(tweet, frequency); 
                		allWords.add(tweet);
                	}
                }              
        	}
        	           
        	numberOfWords = 0.0;
        	frequency = 0.0;
        }
        
        for (String nextItem : allWords) {
        	
        	boolean foundOne = false;
        	boolean foundTwo = false;
        	double frequencies = 0.0;
        	
        	outerloop1:
            for (Map.Entry<String, Double> allWordsOne : frequenciesOne.entrySet()) {
            	String[] wordsOne = allWordsOne.getKey().split(" ");
            	for (String wordOne : wordsOne) {
            		if (nextItem.equals(wordOne)) {
                		accountOneFrequency = allWordsOne.getValue();
                		foundOne = true;
                		break outerloop1;
                	}
                }
            }
        	
        	if (!foundOne) {
        		accountOneFrequency = 0.0;
        	}
        	
        	outerloop2:
            for (Map.Entry<String, Double> allWordsTwo : frequenciesTwo.entrySet()) {
            	String[] wordsTwo = allWordsTwo.getKey().split(" ");
            	for (String wordTwo : wordsTwo) {
            		if (nextItem.equals(wordTwo)) {
                		accountTwoFrequency = allWordsTwo.getValue();
                		foundTwo = true;
                		break outerloop2;
                	}
                }
            }
        	
        	if (!foundTwo) {
        		accountTwoFrequency = 0.0;
        	}
        	
        	frequencies = accountOneFrequency * accountTwoFrequency;
        	totalFrequencies = totalFrequencies + frequencies;
        }

        return totalFrequencies;
    }


    /**
     * Cleans a given string, removing punctuation and converting to lower case
     * @param rawString raw string
     * @return cleaned string
     */
    private static String cleanString(String rawString) {
        return rawString.replaceAll("\\W+", "").toLowerCase();
    }
}
