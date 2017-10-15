package dessertShoppe;

public class Cookie extends DessertItem {
	private int number;

	private int pricePerDozen; // assume price is always in cents

	final private int dozen =12;

	DessertShoppe dS = new DessertShoppe();

	public Cookie() {

		

	}



	public Cookie(String name, int number, int pricePerDozen) {

		super(name);

		this.number=number;

		this.pricePerDozen=pricePerDozen;

	}

	@Override

	public int getCost() {

		//cost in cents

		

		int totalcost;

		if(number <12) {

			totalcost =Math.round((number*pricePerDozen)/dozen);

		}

		else {

			totalcost =Math.round(dozen*pricePerDozen);

		}

		return totalcost;		

	}

	@Override

	public String toString() {

		//print summary

		System.out.format("%d"+" @ %.2f /dz.%n",

				number, Double.parseDouble((dS.cents2dollarsAndCentsmethod(pricePerDozen))));

		//format name of dessert

		String name = String.format("%-"+dS.itemNameLength+"s", super.getName());

		System.out.print(name);

		//format cost of dessert

		System.out.format("%"+ dS.itemCostWidth+".2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(getCost())));

		return "";

	}


}
