import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class PurchaseTest_bak_v1 {

	//Arrays/ArrayList
	double[] purchaseAmount,totalPayable, postcode ;
	
	// declare N as a constant.
	public static final int N = (int) (6 + (Math.random() * ((9 - 6) + 1)));
	
	// initialise N to a random number in the range 6 to 9.
	
	//constructors
	public PurchaseTest_bak_v1() {		
		
	}
	
	//Method to read, validate and store postcode and purchase amount for N customers
	
	//Method to display the total payable for all customers
	
	//main method
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// create object of type Purchase
		Purchase purchaseObj = new Purchase();
		
		int customerCount = 1;
		int choice = 0;
		
		BufferedReader breader= new BufferedReader(new InputStreamReader(System.in));
		
		// While loop to continually display menu and read option
		while (customerCount <= N) {
			System.out.println("This customer no" + customerCount);
			
			
			System.out.println("\n");

			System.out.println("\n\t\t\t******Enter your choice******");
			System.out.println("\n\t\t\t\t1.Add new books");
			System.out.println("\n\t\t\t\t2.Display all books");
			System.out.println("\n\t\t\t\t3.Search a particular book");
			System.out.println("\n\t\t\t\t4.Calculate Average");
			System.out.println("\n\t\t\t\t5.Total price of all books");
			System.out.println("\n\t\t\t\t6.Exit");

			System.out.println(" ");
			System.out.print("Make Your Choice:	");
			
			choice= Integer.parseInt(breader.readLine());
			
			switch(choice)
			{
			case 1: 
			//Add();
			break;

			case 2: 
			//Display();
			break;

			case 3: 
			//Search();
			break;

			case 4:
			//average();
			break;

			case 5:
			double totalPrice=0.00;
			/**
			for(int a=0;a<counter;a++)
					{
						totalPrice += items[a].getbookPrice();
						System.out.println("The totla price of all books="+totalPrice);	
					}
			**/


			break;

			case 6: 
			System.out.println("THANKS FOR USING!");
			System.exit(0);
			break;
							
			default:
			{
			System.out.println("Invalid Input!");
			}
			}
			
			
			customerCount++;
		}
		
		/**
		    // Display menu graphics		
		    System.out.println("============================");
		    System.out.println("|   MENU SELECTION DEMO    |");
		    System.out.println("============================");
		    System.out.println("| Options:                 |");
		    System.out.println("|        1. Option 1       |");
		    System.out.println("|        2. Option 2       |");
		    System.out.println("|        3. Exit           |");
		    System.out.println("============================");
		    //swValue = Keyin.inInt(" Select option: ");
	
		    Scanner scanner = new Scanner(System.in);
		    
		 // get the age as an int
		    int choiceentry = scanner.nextInt();
		    
		    switch(choiceentry){
	        case 1:
	           //do logic
	        	System.out.println("Inside one");
	           break;
	        case 2:
	           //do logic
	        	System.out.println("Inside two");
	           break;
	        case 3:
	           //do logic
	        	System.out.println("Inside three");
	           break;
	   }
		**/    
		
		    
		// Switch statement within while to invoke method corresponding to each option.
		
	}
	
	
}




