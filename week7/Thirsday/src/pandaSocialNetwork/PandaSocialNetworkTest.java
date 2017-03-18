package pandaSocialNetwork;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class PandaSocialNetworkTest {
	PandaSocialNetwork network;
	Panda p1;
	Panda p2;
	Panda p3;
	
	@Before
	public void setUp() {
		network = new PandaSocialNetwork();
		p1 = new Panda("Kiro", "kiro@panda.com", "male");
		p2 = new Panda("Pesho", "pesho@panda.com", "male");
		p3 = new Panda("Vili", "vili@panda.com", "female");
	}
	
	@Test
	public void testAddFriend() {	
		network.makeFriends(p1, p2);
		
		assertTrue(network.areFriends(p1, p2));
		assertTrue(network.areFriends(p2, p1));
	}
	
	@Test
	public void testFriendsLevel() {
		network.makeFriends(p1, p2);
		network.makeFriends(p2, p3);
		
		assertTrue(network.areConnected(p1, p3));
	}
	
	
	
}
