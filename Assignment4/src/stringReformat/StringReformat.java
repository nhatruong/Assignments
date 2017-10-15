package stringReformat;

public class StringReformat {

	public StringReformat() {
	}

	public static void main(String[] args) {
		String input="nhat1975-34-53";
		int groupLength = 5;
		System.out.println(formatString(input, groupLength));
	}
	
	public static String formatString(String s, int groupLength) {
		s = s.replaceAll("[-]", "");
		
		int length = s.length();
		StringBuilder sBuilder= new StringBuilder(s);
		
		//number of characters in the first group
		int firstGroupLength = length % groupLength;
		
		if(firstGroupLength != 0) {
			sBuilder.insert(firstGroupLength, "-");
			for(int i= firstGroupLength + 1 + groupLength ; i<= length - 1; i= i + groupLength +1) {
				sBuilder.insert(i,"-");			
			}
		}
		else {
			for(int i= groupLength; i<= length - 1; i =i + groupLength +1) {
				sBuilder.insert(i,"-");	
			}
		}		
		return sBuilder.toString().toUpperCase();
	}
}
