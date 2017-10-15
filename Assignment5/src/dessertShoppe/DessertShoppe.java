package dessertShoppe;

public class DessertShoppe {
	final float taxRate =0.02f;

	final String storeName ="Best Desserts";

	final int itemNameLength =30;

	final int itemCostWidth =5;

	public DessertShoppe() {}

	

	public String cents2dollarsAndCentsmethod(int cents) {	

		float dollarsandCents = cents/100f;

		return dollarsandCents+"";

	}

	public String getStoreName() {

		return this.storeName;

	}

	public int getItemNameLength() {

		return this.itemNameLength;

	}

	public int getItemCostWidth() {

		return this.itemCostWidth;

	}

	public float getTaxRate() {

		return taxRate;

	}
}
