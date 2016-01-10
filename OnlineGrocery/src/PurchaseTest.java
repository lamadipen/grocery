import java.io.IOException;
import java.util.Scanner;


public class PurchaseTest {

	//Arrays/ArrayList
	double[] purchaseAmount,totalPayable, postcode ;
	
	// declare N as a constant.
	public static final int N = (int) (6 + (Math.random() * ((9 - 6) + 1)));
	
	// initialise N to a random number in the range 6 to 9.
	
	//constructors
	public PurchaseTest() {
		// TODO Auto-generated constructor stub
	}
	
	//Method to read, validate and store postcode and purchase amount for N customers
	
	//Method to display the total payable for all customers
	
	//main method
	public static void main(String[] args)
	{
		// create object of type Purchase
		Purchase purchaseObj = new Purchase();
		
		// While loop to continually display menu and read option
		  int swValue;

		    // Display menu graphics
		    System.out.println(N); 
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
		    
		
		    
		// Switch statement within while to invoke method corresponding to each option.
		
	}
	
}
