package map;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> m = new Map<>();
		for(int i = 0; i < 200; i ++) {
			m.put(i, i*i);
			if (i % 10 == 0) {
				System.out.println(i);
				System.out.println(m);
			}
		}
/*		m.put(10, 100);
		System.out.println(m);
		m.remove(6);
		System.out.println(m);*/
	}

}
