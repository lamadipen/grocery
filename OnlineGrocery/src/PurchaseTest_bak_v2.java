import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PurchaseTest_bak_v2 {

	// declare N as a constant.
	// initialise N to a random number in the range 6 to 9.
	public static final int N = (int) (6 + (Math.random() * ((9 - 6) + 1)));
	
	//Arrays to hold postcode, payable amount, total payable amount
	double[] totalPayable;
	public static Purchase purchaseAmountArray[]= new Purchase[N];
	public static Purchase postcodeArray[]= new Purchase[N];
	
	//default constructor
	public PurchaseTest_bak_v2() {		
		//this is just for testing deleted after successfult testing all feature,
		postcodeArray[0] = new Purchase(4121); 
		postcodeArray[1] = new Purchase(4122);
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
				addRecord(customerCounter);
			}
			else if(purchaseAmount > 500)
			{
				System.out.print("Purchase Amount must be greater than $500");
				System.out.print("Try again: ");						
				addRecord(customerCounter);
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

	//main method
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		// object of type Purchase
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
			
			// Switch statement within while to invoke method corresponding to each option.
			switch(choice)
			{
				case 1: 
					PurchaseTest_bak_v2 purchaseTestObj = new PurchaseTest_bak_v2();
					purchaseTestObj.addRecord(customerCount);
				break;

				case 2: 
					purchaseTestObj = new PurchaseTest_bak_v2();
					purchaseTestObj.displayTotalPayable();
				break;

				case 3: 
					purchaseTestObj = new PurchaseTest_bak_v2();
					purchaseObj.displayAbove(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
				break;

				case 4:
					purchaseTestObj = new PurchaseTest_bak_v2();
					purchaseObj.displayHighestPurchase(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
				break;

				case 5:					
					purchaseTestObj = new PurchaseTest_bak_v2();					
					purchaseObj.displayLowestPurchase(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);				
				break;

				case 6:
					purchaseTestObj = new PurchaseTest_bak_v2();					
					purchaseObj.displayTotalPayableDescending(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
				break;
				case 7: 
					purchaseTestObj = new PurchaseTest_bak_v2();
					purchaseObj.searchByPostcode(purchaseTestObj.purchaseAmountArray,purchaseTestObj.postcodeArray);
					break;
				case 8: 
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
	}
	
	
}




