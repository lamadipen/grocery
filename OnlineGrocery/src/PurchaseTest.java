import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PurchaseTest {

	// declare N as a constant.
	// initialise N to a random number in the range 6 to 9.
	public static final int N = (int) (6 + (Math.random() * ((9 - 6) + 1)));
	
	//Arrays/ArrayList
	double[] totalPayable;
	public static Purchase purchaseAmountArray[]= new Purchase[N];
	public static Purchase postcodeArray[]= new Purchase[N];
	
	//constructors
	public PurchaseTest() {		
		
		postcodeArray[0] = new Purchase(4121); 
		postcodeArray[1] = new Purchase(4123);
		postcodeArray[2] = new Purchase(4120);
		postcodeArray[3] = new Purchase(4122);
		
		purchaseAmountArray[0] = new Purchase(450.50);
		purchaseAmountArray[1] = new Purchase(460.23);
		purchaseAmountArray[2] = new Purchase(470.75);
		purchaseAmountArray[3] = new Purchase(460.23);		
	}
	
	//Method to read, validate and store postcode and purchase amount for N customers
	public  void addRecord(int customerCounter) throws IOException
	{
		int postcode;
		double purchaseAmount;
		
		BufferedReader breader= new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Postcode: ");
		postcode= Integer.parseInt(breader.readLine());
		
		if(4121 >postcode)
		{
			System.out.print("Postcode must be greater than 4121");
			System.out.print("Try again: ");			
			addRecord(customerCounter);
		}
		else if(postcode > 4123)
		{
			System.out.print("Postcode must be less than 4123");
			System.out.print("Try again: ");			
			addRecord(customerCounter);
		}
		else
		{
			breader= new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Purchase Amount: ");
			purchaseAmount= Double.parseDouble(breader.readLine());
			
			if(purchaseAmount < 60)
			{
				System.out.print("Purchase Amount must be greater than $60");
				System.out.print("Try again: ");					
				purchaseAmount= Double.parseDouble(breader.readLine());
			}
			else if(purchaseAmount > 500)
			{
				System.out.print("Purchase Amount must be greater than $500");
				System.out.print("Try again: ");						
				purchaseAmount= Double.parseDouble(breader.readLine());
			}
			else
			{
				System.out.print("Done: ");
				System.out.print("purchaseAmount: "+purchaseAmount);
				System.out.print("postcode: "+postcode);
				
				purchaseAmountArray[customerCounter] = new Purchase(purchaseAmount);
				postcodeArray[customerCounter] = new Purchase(postcode);	
				
				System.out.println(purchaseAmountArray[1].getPurchaseAmount());
			}			
		}
		
		
	}
	
	//Method to display the total payable for all customers
	public void displayTotalPayable()
	{
		List<Purchase> postacodelist = new ArrayList<Purchase>(Arrays.asList(postcodeArray));
		postacodelist.removeAll(Collections.singleton(null));
	    
	    Purchase[] tempPostcodeArray = postacodelist.toArray(new Purchase[postacodelist.size()]);
       
	    List<Purchase> purchaselist = new ArrayList<Purchase>(Arrays.asList(purchaseAmountArray));
	    purchaselist.removeAll(Collections.singleton(null));
	    
	    Purchase[] tempPurchaseAmountArray= purchaselist.toArray(new Purchase[purchaselist.size()]);
	    
	    System.out.println(Arrays.deepToString(tempPurchaseAmountArray));
	    System.out.println("Postal code \t\t Total Payable");
	    
		int postcodeArrayLength = tempPostcodeArray.length;
	
		for (int m= 0; m < postcodeArrayLength; m++)
		{					  		
			if(tempPostcodeArray[m].getPostcode() == 4121)
			{
				if(tempPurchaseAmountArray[m].getPurchaseAmount() >= 400)
				{
					System.out.println(tempPostcodeArray[m].getPostcode() +"\t\t\t $"+ (tempPurchaseAmountArray[m].getPurchaseAmount() ));
				}
				else
				{
					System.out.println(tempPostcodeArray[m].getPostcode() +"\t\t\t $"+ (tempPurchaseAmountArray[m].getPurchaseAmount() + 8));
				}
				
			}
			else if(tempPostcodeArray[m].getPostcode() == 4122)
			{
				System.out.println(tempPostcodeArray[m].getPostcode() +"\t\t\t $"+ (tempPurchaseAmountArray[m].getPurchaseAmount() + 12));
			}
			else if(tempPostcodeArray[m].getPostcode() == 4123)
			{
				System.out.println(tempPostcodeArray[m].getPostcode() +"\t\t\t $"+ (tempPurchaseAmountArray[m].getPurchaseAmount() + 15));
			}
			else
			{
				System.out.println(tempPostcodeArray[m].getPostcode() +"\t\t\t $"+ (tempPurchaseAmountArray[m].getPurchaseAmount() ));
			}					
		}
	}
	//Method for displaying information 
	//delete after successful project completion
	public void Display()
	{
		
		
		List<Purchase> postacodelist = new ArrayList<Purchase>(Arrays.asList(postcodeArray));
		postacodelist.removeAll(Collections.singleton(null));
	    
	    Purchase[] tempPostcodeArray = postacodelist.toArray(new Purchase[postacodelist.size()]);
       
	    System.out.println(Arrays.deepToString(tempPostcodeArray));
		int postcodeArrayLength = tempPostcodeArray.length;
		
		System.out.println("ID\tNAME\t\t\tAUTHOR\t\tPRICE\tISBN\t\tPUBLISHER\ttEdition");
		System.out.println();
		for (int m= 0; m < postcodeArrayLength; m++)
		{					  		
			System.out.println(tempPostcodeArray[m].getPostcode());
		}
		System.out.println("\nPress Enter to Return to Main Page Options.");
		
	}
	
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
			//delete after testing
			System.out.println("This customer no" + customerCount);
			
			
			System.out.println("\n");

			System.out.println("\n\t\t\t******Enter your choice******");
			System.out.println("\n\t\t\t\t1.Add purchase amount");
			System.out.println("\n\t\t\t\t2.Display total payable");
			System.out.println("\n\t\t\t\t3.Display postcode, and total payable for purchase amounts of $400 and above");
			System.out.println("\n\t\t\t\t4.Display postcode/s with the highest purchase amount");
			System.out.println("\n\t\t\t\t5.Display postcode/s with the lowest purchase amount");
			System.out.println("\n\t\t\t\t6.Display total payable in descending order");
			System.out.println("\n\t\t\t\t7.Search");	
			System.out.println("\n\t\t\t\t8.Exit");

			System.out.println(" ");
			System.out.print("Make Your Choice:	");
			
			choice= Integer.parseInt(breader.readLine());
			
			switch(choice)
			{
				case 1: 
					PurchaseTest purchaseTestObj = new PurchaseTest();
					purchaseTestObj.addRecord(customerCount);
				break;

				case 2: 
					purchaseTestObj = new PurchaseTest();
					purchaseTestObj.displayTotalPayable();
				break;

				case 3: 
				//Search();	
					purchaseTestObj = new PurchaseTest();
					purchaseTestObj.Display();	
				break;

				case 4:
					purchaseTestObj = new PurchaseTest();
					purchaseObj.displayHighestPurchase(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
				break;

				case 5:
					purchaseTestObj = new PurchaseTest();
					//Find and display the postcode/s with the lowest purchase amount
					purchaseObj.displayLowestPurchase(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);				
				break;

				case 6:
					purchaseTestObj = new PurchaseTest();
					//Sort and display the total payable in descending order
					purchaseObj.displayTotalPayableDescending(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
				break;
				case 7: 
					//Search and display all purchase amount and Total payable with a given postcode
					break;
				case 8: 
					System.out.println("THANKS FOR USING!");
					System.exit(0);
					break;
				case 9:
					purchaseTestObj = new PurchaseTest();
					purchaseTestObj.Display();	
					break;
				default:
				{
				System.out.println("Invalid Input!");
				}
			}

			customerCount++;
		}
		 
		// Switch statement within while to invoke method corresponding to each option.
		
	}
	
	
}




