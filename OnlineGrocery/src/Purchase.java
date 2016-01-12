import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Purchase {

	//fields
	private int postcode;
	private double purchaseAmount;
	
	// default and parameterised constructors
	public Purchase() {		
	}
	
	public Purchase(int postcode) {
		this.postcode = postcode;
	}
	
	public Purchase(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	//get and set methods
	public int getPostcode() {
		return postcode;
	}


	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}


	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
	//display method
	//Method to display postcode, and total payable for purchase amounts of $400 and above
	public void displayAbove()
	{
		
	}
	
	//Method to find and display the postcode/s with the highest purchase amount
	public void displayHighestPurchase(Purchase[] purchaseAmountArray, Purchase[] postcodeArray)
	{
		List<Purchase> purchaseAmountlist = new ArrayList<Purchase>(Arrays.asList(purchaseAmountArray));
		purchaseAmountlist.removeAll(Collections.singleton(null));
	    
	    purchaseAmountArray = purchaseAmountlist.toArray(new Purchase[purchaseAmountlist.size()]);
       
	    double maxValue = purchaseAmountArray[0].getPurchaseAmount();	   
	    int purchaseAmtIndex = 0 ;
	    
	    System.out.println("Postal code \t\t Purchase Amount");
	    
	    for(int i=0; i < purchaseAmountArray.length; i++)
	    {
	    	double maxPurchase = purchaseAmountArray[i].getPurchaseAmount();
			
	    	if(maxPurchase  > maxValue)
	    	{
	    		maxValue = maxPurchase;
	    		purchaseAmtIndex = i;
	    		
	    		int postcodeWithMaxPurchaseAmt = postcodeArray[purchaseAmtIndex].getPostcode();
	    		System.out.println(postcodeWithMaxPurchaseAmt + "\t\t\t $"+maxValue);
	    	}
	    }
	    if(purchaseAmtIndex == 0)
	    {
	    	int postcodeWithMaxPurchaseAmt = postcodeArray[purchaseAmtIndex].getPostcode();
	    	System.out.println(postcodeWithMaxPurchaseAmt + "\t\t\t $"+maxValue);
	    }
	}
	
	//Method to find and display the postcode/s with the lowest purchase amount
	public void displayLowestPurchase(Purchase[] purchaseAmountArray, Purchase[] postcodeArray)
	{
		List<Purchase> purchaseAmountlist = new ArrayList<Purchase>(Arrays.asList(purchaseAmountArray));
		purchaseAmountlist.removeAll(Collections.singleton(null));
	    
	    purchaseAmountArray = purchaseAmountlist.toArray(new Purchase[purchaseAmountlist.size()]);
       
	    double minValue = purchaseAmountArray[0].getPurchaseAmount();	   
	    int purchaseAmtIndex = 0 ;
	    
	    System.out.println("Postal code \t\t Purchase Amount");
	    
	    for(int i=0; i < purchaseAmountArray.length; i++)
	    {
	    	double minPurchase = purchaseAmountArray[i].getPurchaseAmount();
			
	    	if(minPurchase  < minValue)
	    	{
	    		minValue = minPurchase;
	    		purchaseAmtIndex = i;
	    		
	    		int postcodeWithMinPurchaseAmt = postcodeArray[purchaseAmtIndex].getPostcode();		
	    		System.out.println(postcodeWithMinPurchaseAmt + "\t\t\t $"+minValue);
	    		    
	    	}	    
	    	else if(purchaseAmtIndex != 0 && minValue == minPurchase)
	    	{
	    		minValue = minPurchase;
	    		purchaseAmtIndex = i;	

	    		int postcodeWithMinPurchaseAmt = postcodeArray[purchaseAmtIndex].getPostcode();		
	    		System.out.println(postcodeWithMinPurchaseAmt + "\t\t\t $"+minValue);
	    	}
	    }
	    if(purchaseAmtIndex == 0)
	    {
	    	int postcodeWithMinPurchaseAmt = postcodeArray[purchaseAmtIndex].getPostcode();		
	    	System.out.println(postcodeWithMinPurchaseAmt + "\t\t\t $"+minValue);
	    }
	}
	
	//Method to sort and display the total payable in descending order
	public void displayTotalPayableDescending()
	{
		
	}
	
	//Method to search and display all purchase amounts and total payables with a given postcode
	public void searchByPostcode(Purchase[] purchaseAmountArray, Purchase[] postcodeArray) throws NumberFormatException, IOException
	{
		//Declaring  variables
		int postcode;
		int postcodeArrayCount = postcodeArray.length;
		
		System.out.println("\n");
		System.out.println("\t\t  |*|-----|*| SEARCH PURCHASE  BY POSTCODE|*|-----|*|");
		
		System.out.println("\n\t\t\t   (1) Enter by  postcode");
		
		BufferedReader breader= new BufferedReader(new InputStreamReader(System.in));
		postcode= Integer.parseInt(breader.readLine());
		
		for (int a=0; a<postcodeArrayCount; a++)
		{
			if (postcodeArray[a].getPostcode() == postcode)
			{
				System.out.println("\n\n\t\tHere is your Searched Result.... ");
				System.out.println(postcode);
				break;
			}
			/**
			else
			{
				System.out.println("\n\n\t\tPostcod not found .... ");
				break;
			}	
			**/
		}
		
		
	}	
}
