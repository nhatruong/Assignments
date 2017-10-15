package dessertShoppe;

import java.util.Vector;

public class CheckOut {
Vector<DessertItem> desertItemVector;

	

	DessertShoppe dS =null; 



	public CheckOut() {

		desertItemVector = new Vector<DessertItem>();

		dS = new DessertShoppe();

	}

	public int numberOfItems() {

		return desertItemVector.size();

	}

	public void enterItem(DessertItem item) {

		desertItemVector.addElement(item);

	}

	public void clear() {

		desertItemVector.clear();

	}

	//total cost without tax in cents

	public int totalCost() {

		int totalCost=0;

		for(DessertItem item :desertItemVector) {

			totalCost += item.getCost();

		}

		return totalCost;

	}

	//total tax on items in cents

	public int totalTax() {

		int totalTax=0;

		for(DessertItem item :desertItemVector) {

			totalTax += item.getCost()* dS.getTaxRate();

		}

		return totalTax;

	}

	public String toString() {

		String result;

		result="Number of items: "+numberOfItems()+"\n" +"Total Cost: "+totalCost()+"\n"

				+"Total tax: "+totalTax()+"\n"+"Cost + Tax: ";

		result =result.concat(totalCost()+totalTax()+"\n\n"+dS.getStoreName())+"\n";

		System.out.println(result);

		for(DessertItem dItem : desertItemVector) {

			result =result.concat(dItem.toString());

		}

		//print the final tax and cost in dollars

		System.out.println("");

		System.out.print(String.format("%-"+dS.itemNameLength+"s", "Tax"));

		System.out.format("%.2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(totalTax())));

		System.out.print(String.format("%-"+dS.itemNameLength+"s", "Total Cost"));

		System.out.format("%.2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(totalCost()+totalTax())));

		return "";

	}
}
