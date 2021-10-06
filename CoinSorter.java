
import java.util.*;
import java.util.stream.Stream;
public class CoinSorter {

	String currency; 
	public int minCoinIn;
	public int maxCoinIn;
	public List<Integer> coinList = new ArrayList<Integer>();

	//Constructor method with inputs
	public CoinSorter(String currency, int minValue, int maxValue, List<Integer> coinDenom) 
	{
		this.currency = currency;
		minCoinIn = minValue;
		maxCoinIn = maxValue;
		coinList = coinDenom;
	}
	
	//Constructor method with defaults
	public CoinSorter() 
	{
		currency = "pound";
		minCoinIn = 0;
		maxCoinIn = 10000;
		coinList.add(200);
		coinList.add(100);
		coinList.add(50);
		coinList.add(20);
		coinList.add(10);
	}
	
	
	//Setter classes
	//to set the currency
	public void setCurrency(String setCurrency) 
	{
		currency = setCurrency;
	}
	
	//to set the minimum value
	public void setMinCoinIn(int setMinValue) 
	{
		minCoinIn = setMinValue;
	}
		
	//to set the maximum value
	public void setMaxCoinIn(int setMaxValue) 
	{
		maxCoinIn = setMaxValue;
	}
	
	
	//Getters
	//Get currency
	public String getCurrency() 
	{
		return currency;
	}
	
	//Get minimum coin amount
	public int MinCoinIn() 
	{
		return minCoinIn;
	}	
	
	//Get maximum coin amount
	public int MaxCoinIn() 
	{
		return maxCoinIn;
	}
	
		
	//Print coin list
		public String printCoinList()
		{
			// Create stringbuilder to store each value of ArrayList
			StringBuilder sb = new StringBuilder();
			for (int i= 0; i < coinList.size(); i++)
			{
				int temp = coinList.get(i);
				sb.append(temp + ", ");
			}
			// toString to convert ints to String and remove last comma
			String results = sb.toString();
			results = results.substring(0, results.length() - 2);
			return results;	
		}
	
		
	//Calculate how many of a coin type can be exchanged
	public String coinCalculator(int totalIn, int returnIn)
	{		
		//calculate coins and remainder
		int coins = totalIn/returnIn;
		int remainder = totalIn%returnIn;;
		return "A total of " + coins + " x " + returnIn + "p coins can be exchanged, with a remainder of " + remainder +"p";
	}
	
	
	//Calculate how many of a coin type can be exchanged
	public String multiCoinCalculator(int totalIn, int avoidIn) 
	{
		
		//calculate coins and remainder
		int[] coins = new int[coinList.size()];
		//System.out.print("The coins exchanged are: ");
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < coinList.size(); i++) 
		{
			
			if (coinList.get(i) != avoidIn) 
			{
				// Store results
				coins[i] = (totalIn/coinList.get(i));
				sb.append(coins[i] + " x " + coinList.get(i) + "p, ");
				totalIn = totalIn % coinList.get(i);
			} else 
			//add dummy variable to array to replace excluded coin
			{
				coins[i] = 0;	
			}
		}	
		// toString results together
		String results = sb.toString();
		results = results.substring(0, results.length() - 2);
		
		
		return "The coins exchanged are: " + results; 
	}
	
	
		
	
	public String displayProgramConfigs()
	{
		return "The current currency is: " + currency + "\n" + "The current minimum is: " + minCoinIn + "\n"
				+ "The current maximum is " + maxCoinIn;
	}
	
	
	
}
