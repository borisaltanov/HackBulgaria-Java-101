package map;

import java.util.LinkedList;

public class LinkedBucket<K, V> implements BucketInterface<K, V> {
	
	private class Entry {
		private K key;
		private V value;
		public K getKey() {
			return key;
		}
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
/*		public void setKey(K key) {
			this.key = key;
		}*/
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	
	private LinkedList<Entry> list;
	//int size;
	
	public LinkedBucket() {
		// TODO Auto-generated constructor stub
		list = new LinkedList<>();
		//size = 0;
	}
	
/*	public int getSize(){
		return this.size;
	}*/
	
	@Override
	public void add(K key, V value) {
		// TODO Auto-generated method stub
		if(get(key) == null) {
			list.add(new Entry(key, value));
		} else {
			Entry entry = getEntry(key);
			entry.setValue(value);
		}
		//size += 1;
	}

	private Entry getEntry(K key) {
		// TODO Auto-generated method stub
		for(Entry entry: list) {
			if(entry.getKey().equals(key)) {
				return entry;
			}
		}
		return null;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		list.remove(getEntry(key));
		//size -= 1;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Entry entry = getEntry(key);
		V value = null;
		if (entry != null) {
			value = entry.getValue();
		}
		return value;
	}
	
	public LinkedList<K> getKeys() {
		LinkedList<K> keys = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			keys.add(list.get(i).getKey());
		}
		return keys;
	}
}
