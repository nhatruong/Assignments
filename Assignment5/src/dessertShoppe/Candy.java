package dessertShoppe;

public class Candy extends DessertItem {
	private double weight; //in pounds

	private int pricePerPound; //in cents

	DessertShoppe dS;

	public Candy() {		

	}



	public Candy(String name, double weight, int price) {

		super(name);

		this.weight =weight;

		this.pricePerPound =price;

		dS= new DessertShoppe();

	}

	@Override

	public int getCost() {

		//assume price is always in cent

		return (int) Math.round(weight*pricePerPound);		

	}

	@Override

	public String toString() {

		//print pounds and price per pound

		System.out.format("%.2f"+" lbs. @ %.2f /lb.%n",

				weight, Double.parseDouble((dS.cents2dollarsAndCentsmethod(pricePerPound))));

		

		//format name of dessert

		String name = String.format("%-"+dS.itemNameLength+"s", super.getName());

		System.out.print(name);

		//format cost of dessert

		System.out.format("%"+ dS.itemCostWidth+".2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(getCost())));

		

		return "";

	}

}
