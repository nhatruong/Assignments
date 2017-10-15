package dessertShoppe;

public class IceCream extends DessertItem {
	private int cost; //cost is always in cents

	DessertShoppe dS;

	public IceCream() {		

	}



	public IceCream(String name, int cost) {

		super(name);

		this.cost=cost;

		dS = new DessertShoppe();

	}

	@Override

	public int getCost() {

		return cost;

	}

	@Override

	public String toString() {		

		//format name of dessert

		String name = String.format("%-"+dS.itemNameLength+"s", super.getName());

		System.out.print(name);

		//format cost of dessert

		System.out.format("%"+ dS.itemCostWidth+".2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(getCost())));

		return "";

	}

	
}
