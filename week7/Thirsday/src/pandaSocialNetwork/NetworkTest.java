package pandaSocialNetwork;

public class NetworkTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PandaSocialNetwork network = new PandaSocialNetwork();
		Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");
		Panda rado = new Panda("Rado", "rado@pandamail.com", "male");
		Panda tony = new Panda("Tony", "tony@pandamail.com", "female");
		Panda gosho = new Panda("gosho", "gosho@pandamail.com", "male");

		network.addPanda(ivo);
		network.addPanda(rado);
		network.addPanda(tony);
		network.addPanda(gosho);

		network.makeFriends(ivo, rado);
		network.makeFriends(rado, tony);
		network.makeFriends(tony, gosho);
		network.makeFriends(tony, ivo);
		
		System.out.println(network.connectionLevel(ivo, rado));
		System.out.println(network.connectionLevel(ivo, tony));
		
		System.out.println(network.howManyGenderInNetwork(1, tony, "male"));

	}

}
