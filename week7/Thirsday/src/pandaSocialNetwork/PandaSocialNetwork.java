package pandaSocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PandaSocialNetwork {
	
	private HashMap<Panda, HashSet<Panda>> graph = new HashMap<>();

	public void addPanda(Panda panda) {
		checkAndAdd(panda);
	}
	
	public boolean hasPanda(Panda panda) {
		return this.graph.containsKey(panda);
	}
	
	public void makeFriends(Panda panda1, Panda panda2) {
		if (panda1 == panda2) {
			return;
		}
		checkAndAdd(panda1);
		checkAndAdd(panda2);
		this.graph.get(panda1).add(panda2);
		this.graph.get(panda2).add(panda1);
	}

	private void checkAndAdd(Panda panda1) {
		if (!this.graph.containsKey(panda1)) {
			this.graph.put(panda1, new HashSet<Panda>());
		}
	}
	
	public boolean areFriends(Panda panda1, Panda panda2) {
		if (isInFriends(panda1, panda2) && isInFriends(panda2, panda1)) {
			return true;
		}
		return false;
	}

	private boolean isInFriends(Panda panda1, Panda panda2) {
		return this.graph.get(panda1).contains(panda2);
	}
	
	public HashSet<Panda> friendsOf(Panda panda) {
		try {
			return graph.get(panda);
		} catch (NullPointerException e) {
			System.out.println(panda.getFirstName() + "is not a member of the network.");
			return null;
		}
	}
	


	public LinkedList<Panda> getDirections(Panda start, Panda finish){
		HashMap<Panda, Boolean> vis = new HashMap<>();
		HashMap<Panda, Panda> prev = new HashMap<>();
	    LinkedList<Panda> directions = new LinkedList<Panda>();
	    Queue<Panda> q = new LinkedList<Panda>();
	    Panda current = start;
	    q.add(current);
	    vis.put(current, true);
	    while(!q.isEmpty()){
	        current = q.remove();
	        if (current.equals(finish)){
	            break;
	        }else {
	            for(Panda node : graph.get(current)){
	                if(!vis.containsKey(node)){
	                    q.add(node);
	                    vis.put(node, true);
	                    prev.put(node, current);
	                }
	            }
	        }
	    }
	    if (!current.equals(finish)){
	        System.out.println("can't reach destination");
	    }
	    for(Panda node = finish; node != null; node = prev.get(node)) {
	        directions.add(node);
	    }
	    return directions;
	}
	
	public ArrayList<Panda> getLevelFriends(Panda start, int level){
		ArrayList<Panda> distances = new ArrayList<>();
		for (Panda panda : this.graph.keySet()) {
			int distance = getDirections(start, panda).size() - 1;
			if(distance == level) {
				distances.add(panda);
			}
		}
		return distances;
	}
	
	public int connectionLevel(Panda panda1, Panda panda2) {
		return getDirections(panda1, panda2).size() - 1;
	}
	
	public boolean areConnected(Panda panda1, Panda panda2) {
		return connectionLevel(panda1, panda2) != -1;
	}
	
	public int howManyGenderInNetwork(int level, Panda panda, String gender) {
		ArrayList<Panda> distances = getLevelFriends(panda, level);
		int result = 0;
		for (Panda panda2 : distances) {
			if(panda2.getGender() == gender) {
				result++;
			}
		}
		return result;
	}



}
