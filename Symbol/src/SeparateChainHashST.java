import java.util.ArrayList;
import java.util.Iterator;

public class SeparateChainHashST<K, V> implements SymbolTable<K, V> {

	 Object[] hashTable;
	private int count;

	public SeparateChainHashST(int n) {
		count = 0;
		hashTable = new Object[n * 2];
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = new SequentialSearchST<K, V>();
		}
	}

	@Override
	public void put(K key, V value) {
		SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[(key.hashCode() % hashTable.length)];
		s.put(key, value);
		count++;
		Integer i = 1;
		i.hashCode();
	}

	@Override
	public V get(K key) {
		SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[(key.hashCode() % hashTable.length)];
		return s.get(key);
	}

	@Override
	public void delete(K key) {
		SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[(key.hashCode() % hashTable.length)];
		s.delete(key);
	}

	@Override
	public boolean contains(K key) {
		SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[(key.hashCode() % hashTable.length)];
		return s.contains(key);
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterable<K> keys() {
		
		class Itable implements Iterable<K>{

			ArrayList<K> allKeys = new ArrayList<K>();
			@Override
			public Iterator<K> iterator() {
				for (Object st : hashTable) {
					SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) st;
					if (s != null) {
						for (K key : s.keys()) {	
							allKeys.add(key);
						}
					}
				}
				return new It();
			}
			class It implements Iterator<K>{
				Iterator<K> iter = allKeys.iterator();
				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return iter.hasNext();
				}

				@Override
				public K next() {
					// TODO Auto-generated method stub
					return  iter.next();
				}
				
			}
			}
		
		return new Itable();
		
		
	}

}
