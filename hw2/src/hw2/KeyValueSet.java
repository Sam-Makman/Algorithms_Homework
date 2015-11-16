package hw2;

public class KeyValueSet<K, V> {

	private int size;
	private K[] keys;
	private V[] values;
	
	public KeyValueSet(){
		keys = (K[]) new Object[1000];
		values = (V[]) new Object[1000];
		size = 0;
	}
	
	int size(){
		return size;
	}
	
	void add(K key, V value){
		keys[size] = key;
		values[size] = value;
		size++;
	}
	
	boolean containsKey(K key){
		for(int i = 0; i<size; i++){
			if(keys[i].equals(key)) return true;
		}
		return false;
	}
	
	boolean containsValue(V value){
		for(int i = 0; i<size; i++){
			if(values[i].equals(value)) return true;
		}
		return false;
	}
}
