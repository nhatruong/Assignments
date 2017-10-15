package dessertShoppe;

public class TestCheckOut {

	public static void main(String[] args) {
		CheckOut checkOut = new CheckOut();

		checkOut.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));

		checkOut.enterItem(new IceCream("Vanilla Ice Cream", 105));

		checkOut.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));

		checkOut.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

		checkOut.toString();

		

		checkOut.clear();

	}

}
