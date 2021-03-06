package map;

import java.util.LinkedList;

public class Map<K, V> implements MapInterface<K, V>{
	private LinkedBucket<K, V> [] buckets;
	private float loadFactor; // elemetsIn / size
	private int size;
	private int elementsIn;
	
	@SuppressWarnings("unchecked")
	public Map() {
		// TODO Auto-generated constructor stub
		size = 8;
		loadFactor = 5;
		elementsIn = 0;
		buckets = new LinkedBucket [size];
		for(int i=0; i<size; i++) {
			buckets[i] = new LinkedBucket<>();
		}
		
	}
		
	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub

		int bucketIndex = calculateBucketIndex(key);
		buckets[bucketIndex].add(key, value);
		this.elementsIn++;
		if((float)elementsIn/(float)size > loadFactor) {
			this.resize(2*size);
		}
	}

	@Override
	public V get(K key) {
		int bucketIndex = calculateBucketIndex(key);
		return buckets[bucketIndex].get(key);
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		elementsIn--;
		if((double)elementsIn/(double)size > loadFactor) {
			resize (size/2);
		}
		int bucketIndex = calculateBucketIndex(key);
		
		buckets[bucketIndex].remove(key);
		
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		return (get(key) != null);
	}
	
	private int calculateBucketIndex(K key) {
		return key.hashCode() % size;
	}
	
	/*
	 * 1. create new List new LinkedBucket[2*size]
	 * 
	 * 2. oldList = this.list
	 * 3. list = newList
	 * 
	 * 4. for each element in oldList -> call put()
	 */
	
	public void resize(int newSize) {
		int oldSize = this.size;
		this.size = newSize;
		LinkedBucket<K, V> [] newList = new LinkedBucket [size];
		LinkedBucket<K, V> [] oldList = this.buckets;

		for(int i=0; i<size; i++) {
			newList[i] = new LinkedBucket<>();
		}
		this.buckets = newList;
		this.elementsIn = 0;
		for (int i=0; i<oldSize; i++) {
			LinkedList<K> keys = oldList[i].getKeys();
			for(K key: keys){
				V value = oldList[i].get(key);
				this.put(key, value);
			}
		}
 	}
	
	public String toString() {
		String result = "";
		for(int i=0; i<size; i++) {
			result += i + "-> ";
			LinkedList<K> keys = buckets[i].getKeys();
			for(K key: keys){
				V value = buckets[i].get(key);
				result += "[" + key + ": " + value + "] ";
			}
			result += "\n";
		}

		return result;
	}
	
	
	
	
	
}
