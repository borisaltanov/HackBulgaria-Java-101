package Polynomial;

import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//works only with integers
public class Polynomial {
	Vector<Integer> coeffs = new Vector<Integer>(10);
	Vector<Character> signs = new Vector<Character>();
	
	public Polynomial() {}
	public Polynomial(String str) {
		Polynomial temp = fromString(str);
		this.coeffs = temp.coeffs;
		this.signs = temp.signs;
		temp = null;
	}
	
	//adding element to polynomial
	public void add(int coeff, int power) {
		while(power > this.coeffs.size() - 1) {
			this.coeffs.insertElementAt(0, 0);;
		}
		this.coeffs.setElementAt(coeff, power);
	}
	
	//adding sign needed later for evaluation
	public void addSign(char sign) {
		signs.add(sign);
	}
	
	//sum of two polynomial (c=a+b)
	public Polynomial sum (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		int size = lhs.coeffs.size() > rhs.coeffs.size() ? lhs.coeffs.size() : rhs.coeffs.size();
		for(int i = size - 1; i > -1 ; i--) {
			if (i+1 > lhs.coeffs.size()) {
				result.add(rhs.coeffs.elementAt(i), i);
			}
			else if (i+1 > rhs.coeffs.size()) {
				result.add(lhs.coeffs.elementAt(i), i);
			}
			else {
				int tempEl = lhs.coeffs.elementAt(i) + rhs.coeffs.elementAt(i);
				result.add(tempEl, i);
			}

		}
		return result;
	}
	
	//substaction of two polynomial (c=a-b)
	public Polynomial substract (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		//size of the longer polynomial
		int size = lhs.coeffs.size() > rhs.coeffs.size() ? lhs.coeffs.size() : rhs.coeffs.size();
		for(int i = size - 1; i > -1 ; i--) {
			if (i+1 > lhs.coeffs.size()) {
				result.add(rhs.coeffs.elementAt(i), i);
			}
			else if (i+1 > rhs.coeffs.size()) {
				result.add(lhs.coeffs.elementAt(i), i);
			}
			else {
				int tempEl = lhs.coeffs.elementAt(i) - rhs.coeffs.elementAt(i);
				result.add(tempEl, i);
			}

		}
		return result;
	}
	
	//multiplication of two polynomial (c=a*b)
	public Polynomial multiply (Polynomial lhs, Polynomial rhs) {
		Polynomial result = new Polynomial();
		int size = lhs.coeffs.size() > rhs.coeffs.size() ? lhs.coeffs.size() : rhs.coeffs.size();
		for(int i = size - 1; i > -1 ; i--) {
			if (i+1 > lhs.coeffs.size()) {
				result.add(rhs.coeffs.elementAt(i), i);
			}
			else if (i+1 > rhs.coeffs.size()) {
				result.add(lhs.coeffs.elementAt(i), i);
			}
			else {
				int tempEl = lhs.coeffs.elementAt(i) * rhs.coeffs.elementAt(i);
				result.add(tempEl, i);
			}

		}
		return result;
	}
	
	//multiplications of a polynomial and number (c=a*num)
	public Polynomial multiplyNumber (Polynomial lhs, int number) {
		Polynomial result = new Polynomial();
		for(int i = lhs.coeffs.size() - 1; i > -1 ; i--) {
			int tempEl = lhs.coeffs.elementAt(i) * number;
			result.add(tempEl, i);
		}
		return result;
	}
	
	//derivative of a polynomial
	public Polynomial derivative (Polynomial lhs) {
		Polynomial result = new Polynomial();
		for(int i = lhs.coeffs.size() - 1; i > 0 ; i--) {
			result.add(lhs.coeffs.elementAt(i) * i, i - 1);
		}
		return result;
	}
	
	
	//evaluation of a polynomial
	public int evaluate (int valueOfX) {
		int result = 0;
		//vector for all non-zero elemnts ot the polynomial evaluated for value of x
		//e.g 2x^4 for x=3 => 162
		Vector<Integer> elemets = new Vector<Integer>();
		for(int i = 0; i < this.coeffs.size() ; i++) {
			if (this.coeffs.elementAt(i) != 0) {
				int temp = (int)Math.pow((double)valueOfX, (double)i);
				temp *= this.coeffs.elementAt(i);
				elemets.insertElementAt(temp, 0);
			}
		}
		//evaluating the whole polynomial
		result += elemets.elementAt(0);
		for (int j = 0; j < this.signs.size(); j++) {
			char sign = this.signs.elementAt(j);
			switch(sign) {
				case '+': result += elemets.elementAt(j + 1);
				break;
				case '-': result -= elemets.elementAt(j + 1);
				break;
			}
			
		}
		return result;
	}
	
	// helper function for extracting coeff and power from string
	public static int[] coeffPower(String str) {
		int [] result = new int [2];
		if(str.contains("x^")) {
			String[] coeffPower = str.split("x\\^");
			result[0] = Integer.parseInt(coeffPower[0]);
			result[1] = Integer.parseInt(coeffPower[1]);
		}
		else if(str.contains("x")) {
			result[0] = Integer.parseInt(str.substring(0, str.length() - 1));
			result[1] = 1;
		}
		else {
			result[0] = Integer.parseInt(str);
			result[1] = 0;
		}
		return result;
	}
	
	public static Polynomial fromString(String pol) {
		Polynomial result = new Polynomial();
		String pattern = "(-?\\d+x?(\\^\\d+)?)";
		//extracting elements of a polynomial
		//e.g 2x^4 + 3x => {"2x^4", "3x"}
		Pattern pElement = Pattern.compile(pattern);
		Matcher mElelemt = pElement.matcher(pol);

        while(mElelemt.find()) {
        	int[] temp = coeffPower(mElelemt.group());
        	result.add(temp[0], temp[1]);
        }
        
        //extracting signs
        Pattern pSign = Pattern.compile(" [+-] ");
		Matcher mSign = pSign.matcher(pol);
        
        while(mSign.find()) {
        	result.addSign(mSign.group().charAt(1));
        }
        
        return result;
	}
	
	public String toString() {
		String result = "";
		for(int i = coeffs.size() - 1; i > -1; i--) {
/*			if (coeffs.elementAt(i) != 0){*/
				result += coeffs.elementAt(i) + "x^" + i + " ";
		}
		return result;
	}
}
