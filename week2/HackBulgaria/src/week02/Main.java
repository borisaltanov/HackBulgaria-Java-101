package week02;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*			int [] arr = new int[3];
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			
			int[] temp = new int[6];
			
			for (int i = 0; i < arr.length; i++) {
				temp[i] = arr[i];
			}
			
			temp[3] = 3;*/
/*		int [] arr = new int[10];

		IntVector v = new IntVector(arr);
		
		for (int i = 0; i < 100; i++) {
			v.add(i);
		}
		
		for(int i = 0; i < 100; i++) {
			System.out.print(v.get(i));
		}
		
		IntVector v1 = new IntVector(arr);
		IntVector v2 = new IntVector();
		
		
		v.size();
		System.out.println();
		System.out.println(v);
		
		Vector<String> vec = new Vector<>();
		for (int i = 0; i < 20; i++) {
			vec.add("hello " + i);
		}*/
/*		
		
		System.out.println(vec);
		*/
		
		Polynomial pol = new Polynomial();
		pol.add(3, 0);
		pol.add(10, 1);
		pol.add(3, 2);
		pol.add(0, 3);
		pol.add(2, 4);
		
		Polynomial pol1 = new Polynomial();
		pol1.add(5, 0);
		pol1.add(3, 1);
		pol1.add(7, 2);
		pol1.add(8, 3);
		pol1.add(1, 4);
		
		Polynomial resultSum = new Polynomial();
		resultSum = resultSum.sum(pol, pol1);
		
		Polynomial resultSubstract = new Polynomial();
		resultSubstract = resultSubstract.substract(pol, pol1);
		
		Polynomial resultMultiply = new Polynomial();
		resultMultiply = resultMultiply.multiply(pol, pol1);
		
		Polynomial resultMultiplyNumber = new Polynomial();
		resultMultiplyNumber = resultMultiplyNumber.multiplyNumber(pol, 3);
		
		Polynomial derivative = new Polynomial();
		derivative = derivative.derivative(pol);

		System.out.println("Pol1: " + pol);
		System.out.println("Pol2: " + pol1);
		System.out.println("Sum:  " + resultSum);
		System.out.println("Subs: " + resultSubstract);
		System.out.println("Mult: " + resultMultiply);
		System.out.println("Pol*N:" + resultMultiplyNumber);
		System.out.println("Deriv:" + derivative);
		
	}

}





