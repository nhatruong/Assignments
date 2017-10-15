package stringReformat;

public class StringReformat2 {

	public StringReformat2() {
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
				
		for(int i = length - groupLength; i >= 0; i= i - groupLength){
			sBuilder.insert(i, "-");
		}
		return sBuilder.toString().toUpperCase();
	}
}

