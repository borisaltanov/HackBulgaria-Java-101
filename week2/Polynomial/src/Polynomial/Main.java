package Polynomial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial fr = new Polynomial("2x^4 + 3x^2 - 10x + 3");
		System.out.println(fr);
		System.out.println(fr.evaluate(3));
		
		
		Polynomial pol = new Polynomial();
		pol.add(2,4);
		pol.addSign('+');
		pol.add(3,2);
		pol.addSign('-');
		pol.add(10,1);
		pol.addSign('+');
		pol.add(3,0);
		
		Polynomial pol2 = new Polynomial();
		pol2.add(3, 5);
		pol2.add(5, 4);
		pol2.add(6, 3);
		pol2.add(1, 2);
		pol2.add(7, 0);

		Polynomial sum = new Polynomial();
		sum = sum.sum(pol, pol2);
		
		Polynomial substract = new Polynomial();
		substract = substract.substract(pol, pol2);
		
		Polynomial multiply = new Polynomial();
		multiply = multiply.multiply(pol, pol2);
		
		Polynomial multiplyNumber = new Polynomial();
		multiplyNumber = multiplyNumber.multiplyNumber(pol, -2);
		
		Polynomial derivative = new Polynomial();
		derivative = derivative.derivative(pol);
		
		System.out.println(pol.evaluate(3));
		
		
		System.out.println(pol);
		System.out.println(pol2);
		System.out.println(sum);
		System.out.println(substract);
		System.out.println(multiply);
		System.out.println(multiplyNumber);
		System.out.println(derivative);
	}

}
