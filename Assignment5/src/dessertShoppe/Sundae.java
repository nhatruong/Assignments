package dessertShoppe;

public class Sundae extends IceCream {
	String topping;

	int toppingCost;// cost in cents

	DessertShoppe dS = new DessertShoppe();



	public Sundae(String name, int cost, String topping, int toppingCost) {

		super(name, cost);

		this.topping =topping;

		this.toppingCost=toppingCost;

	}

	

	public String getSundaeName() {

		return topping +" with\n" +super.getName();

	}

	@Override

	public int getCost() {

		return super.getCost() + toppingCost;

	}

	@Override

	public String toString() {		

		//format name of dessert

		String name = String.format("%-"+dS.itemNameLength+"s", getSundaeName());				

		System.out.print(name);

		//format cost of dessert

		System.out.format("%"+ 3*dS.itemCostWidth+".2f%n", Double.parseDouble(dS.cents2dollarsAndCentsmethod(getCost())));

		return "";

	}


}
