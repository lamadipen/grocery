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
	public void displayTotalPayableDescending(Purchase[] purchaseAmountArray, Purchase[] postcodeArray)
	{					
		List<Purchase> postacodelist = new ArrayList<Purchase>(Arrays.asList(postcodeArray));
		postacodelist.removeAll(Collections.singleton(null));
	    
	    Purchase[] tempPostcodeArray = postacodelist.toArray(new Purchase[postacodelist.size()]);
       
	    List<Purchase> purchaselist = new ArrayList<Purchase>(Arrays.asList(purchaseAmountArray));
	    purchaselist.removeAll(Collections.singleton(null));
	    
	    Purchase[] tempPurchaseAmountArray= purchaselist.toArray(new Purchase[purchaselist.size()]);
	    	    
	    int arrayKey = tempPurchaseAmountArray.length;
		double [] tempTotalPayable = new double[arrayKey];

		int postcodeArrayLength = tempPostcodeArray.length;
	
		for (int m= 0; m < postcodeArrayLength; m++)
		{					  		
			if(tempPostcodeArray[m].getPostcode() == 4121)
			{
				if(tempPurchaseAmountArray[m].getPurchaseAmount() >= 400)
				{
					tempTotalPayable[m] = tempPurchaseAmountArray[m].getPurchaseAmount();
				}
				else
				{
					tempTotalPayable[m] = tempPurchaseAmountArray[m].getPurchaseAmount() + 8;					
				}
				
			}
			else if(tempPostcodeArray[m].getPostcode() == 4122)
			{
				tempTotalPayable[m] = tempPurchaseAmountArray[m].getPurchaseAmount() + 12 ;				
			}
			else if(tempPostcodeArray[m].getPostcode() == 4123)
			{
				tempTotalPayable[m] = tempPurchaseAmountArray[m].getPurchaseAmount() + 15;				
			}
			else
			{
				tempTotalPayable[m] = tempPurchaseAmountArray[m].getPurchaseAmount();				
			}
						
		}
		
		
		//algorithym to sort array
		int min = 0;
	    double temp;
	    Purchase tempPurchase, tempPostcode;
	    
		for(int i=0 ; i < tempTotalPayable.length; i++)
		{
			min = i;
			for(int j =0; j < tempTotalPayable.length; j++)
			{
				if(tempTotalPayable[j] < tempTotalPayable[i])
				{
					min = j;
				}
				 temp = tempTotalPayable[i];
				 tempTotalPayable[i] = tempTotalPayable[min];
		         tempTotalPayable[min] = temp;
		         
		         tempPurchase = tempPurchaseAmountArray[i];
		         tempPurchaseAmountArray[i] = tempPurchaseAmountArray[min];
		         tempPurchaseAmountArray[min] = tempPurchase;
		         
		         tempPostcode = tempPostcodeArray[i];
		         tempPostcodeArray[i] = tempPostcodeArray[min];
		         tempPostcodeArray[min] = tempPostcode;
			}
		}
		
		System.out.println("Postal code \t\t Purchase Amount \t\t Total Payable");
		// printing all the array values 
		for (int k = 0; k < tempTotalPayable.length; k++) {
			
			System.out.println(tempPostcodeArray[k].getPostcode() + "\t\t\t $" +tempPurchaseAmountArray[k].getPurchaseAmount() + "\t\t\t $"+tempTotalPayable[k] );
		}
	
	    
	   
		
	}
	
	//Method to search and display all purchase amounts and total payables with a given postcode
	public void searchByPostcode()
	{
		
	}	
}
