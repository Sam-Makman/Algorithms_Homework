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
		if(!s.contains(key)){
			count++;			
		}
		s.put(key, value);

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
		count--;
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

			ArrayList<K> allKeys;
			Itable(){
				allKeys = new ArrayList<K>();
			}
			@Override
			public Iterator<K> iterator() {
				for(int i = 0; i < hashTable.length; i++){
					SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[i];
					for(SequentialSearchST.Node n = s.first; n != null; n = n.next){
						allKeys.add((K) n.key);
					}
				}
				return new It(allKeys);
			}
			class It implements Iterator<K>{
				Iterator<K> iter;
				public It(ArrayList<K> k){
					iter = k.iterator();
				}
				@Override
				public boolean hasNext() {
					return iter.hasNext();
				}

				@Override
				public K next() {
					return  iter.next();
				}
				
			}
			}
		
		return new Itable();
		
		
	}
	
	public void print(){
		for(int i = 0; i < hashTable.length; i++){
			SequentialSearchST<K, V> s = (SequentialSearchST<K, V>) hashTable[i];
			System.out.println("Table number " + i + "  ------------------------------");
			for(SequentialSearchST.Node n = s.first; n != null; n = n.next){
				System.out.println(n.key);
			}
		}
	}

}
