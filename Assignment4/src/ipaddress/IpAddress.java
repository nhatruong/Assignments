package ipaddress;

public class IpAddress {
	String dottedDecimal;
	int firstOctet, secondOctet, thirdOctet, fourthOctet;
	
	public IpAddress(String dottedDecimal) {
		this.dottedDecimal = dottedDecimal;
		String[] octetArray = extracOctets(dottedDecimal); 
		firstOctet = Integer.parseInt(octetArray[0]);
		secondOctet = Integer.parseInt(octetArray[1]);
		thirdOctet = Integer.parseInt(octetArray[2]);
		fourthOctet = Integer.parseInt(octetArray[3]);
	}
	//extract octets
	private String[] extracOctets(String dottedDecimal) {
		return dottedDecimal.split("[.]");
	}
	public String getDottedDecimal() {
		return dottedDecimal;
	}
	public int getOctet(int i) {
		int octet=-1;
		if(i ==1) octet = firstOctet;
		else if(i == 2) octet =secondOctet;
		else if(i ==3) octet =thirdOctet;
		else octet = fourthOctet;
		return octet;		
	}
}
