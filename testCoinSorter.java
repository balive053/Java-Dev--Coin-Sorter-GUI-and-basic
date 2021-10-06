import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class testCoinSorter extends CoinSorter {

	
	// Main method
	public static void main(String[] args) 
	{
	
		
		// Create dummy coin list to use in CoinSorter(String, int, int, ArrayList)
		List<Integer> testerCoinList = new ArrayList<Integer>();
		//add values to tester coin list
		testerCoinList.add(250);
		testerCoinList.add(50);
		testerCoinList.add(20);
		testerCoinList.add(10);
		
		
		// Main object used in parameters - sortMan
		// sortMan with input parameters to test CoinSorter(String, int, int, ArrayList)
		//CoinSorter sortMan = new CoinSorter("horses", 0, 2000, testerCoinList);
		
		// sortMan without input parameters to test CoinSorter()
		CoinSorter sortMan = new CoinSorter();
		
		
		/* Dummy test methods for report to show they can all be used.
		System.out.println(sortMan.displayProgramConfigs());
		sortMan.setCurrency("twinkles");
		sortMan.setMinCoinIn(100);
		sortMan.setMaxCoinIn(5000);
		System.out.println(sortMan.getCurrency());
		System.out.println(sortMan.MinCoinIn());
		System.out.println(sortMan.MaxCoinIn());
		System.out.println(sortMan.printCoinList());
		System.out.println(sortMan.coinCalculator(520, 50));
		System.out.println(sortMan.multiCoinCalculator(520, 100));
		System.out.println(sortMan.displayProgramConfigs());
		*/		
				
		
		
		
		
		// Scanner and temp int for use in user input
		Scanner sc = new Scanner(System.in);
		int temp;
		
		// Start user interface and run menu
		do {
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			temp = sc.nextInt();
	
			switch (temp) 
			{
	
			case 1: 
				System.out.println("Please enter amount of money you want exchanged:");
				int first = sc.nextInt();
					// Test if input meets min/max parameters
					while (first < sortMan.MinCoinIn() || sortMan.MaxCoinIn() < first )
					{
					System.out.println("Outside range. Please enter a valid amount or change parameters:");
					first = sc.nextInt();
					} 
					
					System.out.println("Please enter demonination of coins you want:");
					int second = sc.nextInt();
								
					// Logic test to see if returnIn is an actual denomination value
					// Create new testCoinSorter and boolean for logic test
					testCoinSorter test = new testCoinSorter();
					boolean logicTest = false;
					// do while loop to check if desired output is within coin range
					do 
					{
						if (test.coinListHolder().contains(second)) 
						{
							logicTest = true;
						} else {
							Scanner newIn = new Scanner(System.in);
							System.out.println("Invalid denomination entered. Please enter again:");
							second = newIn.nextInt();
						}
					}  while (logicTest == false);
				
				System.out.println(sortMan.coinCalculator(first, second) + "\n");
				break;
		
			case 2: 
				System.out.println("Please enter amount of money your want exchanged:");
				int firstIn = sc.nextInt();
				
				// Test if input meets min/max parameters
				while (firstIn < sortMan.MinCoinIn() || sortMan.MaxCoinIn() < firstIn )
				{
				System.out.println("Outside range. Please enter a valid amount or change parameters:");
				firstIn = sc.nextInt();
				} 
				
				System.out.println("Please enter demonination of coins you don't want to receive:");
				int secondIn = sc.nextInt();
				
				
				// Logic test to see if returnIn is an actual denomination value
				testCoinSorter test2 = new testCoinSorter();
				// Do while loop to check conditions
				do 
				{
					// Check for validity of demonination
					if (!test2.coinListHolder().contains(secondIn)) 
					{	
						Scanner newIn = new Scanner(System.in);
						System.out.println("You will have no problem avoiding this as it is an invalid denomination."
								+ "\n" +  "Please enter a valid demonination:");
	
						secondIn = newIn.nextInt();
						// Nested loop to check for change
						if (test2.coinListHolder().contains(secondIn))
							{
							System.out.println(sortMan.multiCoinCalculator(firstIn, secondIn)+ "\n");
							}		
						} else {
						// Run method
						System.out.println(sortMan.multiCoinCalculator(firstIn, secondIn)+ "\n");
					}
				}  while (!test2.coinListHolder().contains(secondIn));
			
				break;
		
			case 3:
				System.out.println("The current coin denominations are in circulation: " 
						+ sortMan.printCoinList() + "." + "\n");
				break;
		
			case 4:
				//Create menu for option 4 within original menu
				int tempTwo;
				do
				{
					System.out.println("***Set Details Sub-Menu***");
					System.out.println("1 - Set currency");
					System.out.println("2 - Set minimum coin input value");
					System.out.println("3 - Set maximum coin input value");
					System.out.println("4 - Return to main menu");
					tempTwo = sc.nextInt();
			
					//switch statements for menu
					switch (tempTwo) 
					{
					case 1:
						String setCur;
						System.out.println("Input currency you would like to use:");
						setCur = sc.next();
						sortMan.setCurrency(setCur);
						break;
			
					case 2:
						int setMinVal;
						System.out.println("Set the minimum valid amount:");
						setMinVal = sc.nextInt();
						
						// Logic check to see if entered mim is below max
						if (setMinVal < sortMan.MaxCoinIn() && setMinVal >= 0) 
						{
							sortMan.setMinCoinIn(setMinVal); 
						}
						else if (setMinVal > sortMan.MaxCoinIn() || setMinVal < 0) 
						{
							do
							{
							// Asks for user correction if min value is below current max
							System.out.println();
							System.out.println("Invalid number. Must 0 or higher and smaller or equal to maximum.");
							System.out.println("Current maximum is: " +  sortMan.MaxCoinIn());
							System.out.println("Please enter valid number:");
							Scanner logicScan = new Scanner(System.in);
							setMinVal = logicScan.nextInt();
							} while (setMinVal > sortMan.MaxCoinIn() || setMinVal < 0);
						
						sortMan.setMinCoinIn(setMinVal); 
							
						} 
						
						break;
						
					case 3:
						int setMaxVal;
						System.out.println("Set the maximum valid amount:");
						setMaxVal = sc.nextInt();
						
						// Logic check to see if entered mim is below max
						if (setMaxVal > sortMan.MinCoinIn() && setMaxVal > 0) {
							sortMan.setMaxCoinIn(setMaxVal); 
						} else if (setMaxVal < sortMan.MinCoinIn() || setMaxVal < 0)
						{
							do
							{
							// Asks for user correction if min value is below current max
							System.out.println();
							System.out.println("Invalid number. Must be positive and greater or equal to minimum.");
							System.out.println("Current minimum is: " +  sortMan.MinCoinIn());
							System.out.println("Please enter valid number:");
							Scanner logicScan = new Scanner(System.in);
							setMaxVal = logicScan.nextInt();
						} while (setMaxVal < sortMan.MinCoinIn());
						sortMan.setMaxCoinIn(setMaxVal);
						} 
											
						break;
		
					}
				} while (tempTwo != 4);
				break;
		
			case 5:	
				System.out.println(sortMan.displayProgramConfigs()+ "\n");
				break;
			}
	
		} while (temp != 6);
	
	}

		// Gets coin list from CoinSorter class for logic tests
		public List<Integer> coinListHolder() 
		{
			List<Integer> a = coinList;
			return a;
		}
		
	
	
}
