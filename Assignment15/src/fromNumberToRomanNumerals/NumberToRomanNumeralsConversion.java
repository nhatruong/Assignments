package fromNumberToRomanNumerals;

public class NumberToRomanNumeralsConversion {
	//max value
	int[] numberValue = new int[13];
	String[] romanNumeral = new String[13];
	//this is  a constructor
	public NumberToRomanNumeralsConversion() {		
		numberValue[0] = 1;
		numberValue[1] = 4;
		numberValue[2] = 5;
		numberValue[3] = 9;
		numberValue[4] = 10;
		numberValue[5] = 40;
		numberValue[6] = 50;
		numberValue[7] = 90;
		numberValue[8] = 100;
		numberValue[9] = 400;
		numberValue[10] = 500;
		numberValue[11] = 900;
		numberValue[12] = 1000;
		
		
		romanNumeral[0] ="I";
		romanNumeral[1] ="IV";
		romanNumeral[2] ="V";
		romanNumeral[3] ="IX";
		romanNumeral[4] ="X";
		romanNumeral[5] ="XL";
		romanNumeral[6] ="L";
		romanNumeral[7] ="XC";
		romanNumeral[8] ="C";
		romanNumeral[9] ="CD";
		romanNumeral[10] ="D";
		romanNumeral[11] ="CM";
		romanNumeral[12] ="M";
		
	}
	
	public String intToRoman(int num) {
		StringBuilder correspondingRomanNumerals = new StringBuilder();
		int highestValue = 0; 
		for(int i= 0; i<= numberValue.length -1; i++) {
			if(numberValue[i] > num) {
				highestValue = numberValue[i-1]; 
				correspondingRomanNumerals.append(romanNumeral[i-1]);
				
				if((num -= highestValue) != 0) {
					//reset loop value
					i =0;
					continue;
				}				
				break;
			}
			else if(i == numberValue.length -1 && numberValue[i] < num) {
				highestValue = numberValue[i];
				correspondingRomanNumerals.append(romanNumeral[i]);
				
				if((num -= highestValue) != 0) {
					//reset loop value
					i =0;
					continue;
				}				
				break;
			}
		}		
		return correspondingRomanNumerals.toString();							
	}

}
