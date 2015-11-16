package lab2;

import java.util.ArrayList;// I was told I can use array lists
import java.util.Arrays;

public class ScoredResultsPager<T extends Comparable> implements Pageable<T> {

	private T[] objects;
	private int pageSize;

	ScoredResultsPager(T[] objects, int pageSize) {
		if (pageSize <= 0) {
			throw new IllegalArgumentException("Illegal Page Size");
		}
		if (objects == null || objects.length == 0) {
			throw new IllegalArgumentException("Illegal Object Array");
		}
		this.objects = Arrays.copyOfRange(objects, 0, objects.length-1);
		this.pageSize = pageSize;
		ScoredDocument temp = new ScoredDocument();
		if(objects[0].getClass().equals(temp.getClass())){
			ScoredDocSorter((ScoredDocument [] )this.objects);
		}else{
			Arrays.sort(this.objects);
		}
		

	}

	T get(int i) {
		if(i<0 || i >= objects.length){
			throw new IndexOutOfBoundsException();
		}
		return objects[i];
	}

	T max() {
		return objects[0];
	}

	T min() {
		return objects[objects.length -1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return objects.length;
	}

	@Override
	public int pageSize() {
		// TODO Auto-generated method stub
		return pageSize;
	}

	@Override
	public int pages() {
		// TODO Auto-generated method stub
		return (int) Math.ceil((double) objects.length / (double) pageSize);
	}

	@Override
	public T[] page(int i) throws IndexOutOfBoundsException{
		if(i > pages()-1){
			throw new IndexOutOfBoundsException();
		}
		
		T[] page;
		page = (T[]) new Comparable[pageSize];
		for(int j=0;j<pageSize && (i*pageSize + j) < objects.length;j++){
			page[j] = objects[(i*pageSize) + j];
		}
		return page;
	}

	public void ScoredDocSorter(ScoredDocument[] docs) {
		ArrayList<ScoredDocument>[] buckets = new ArrayList[10001];
		int exponent = 1;
		for(int i = 0; i<10001; i++){
			buckets[i] = new ArrayList<ScoredDocument>();
		}
			for (int i = 0; i < docs.length; i++) {
				int bucketNum = ((int) ((10000) * docs[i].score()));
				buckets[bucketNum].add(docs[i]);
			}
			exponent *= 100;
			int loc = 0;
			for (int j = 10000; j >=0; j--) {
				if(!buckets[j].isEmpty()){
				for(ScoredDocument sd : buckets[j]){
					docs[loc] = sd;
					loc++;
					
				}
				}
				}
		}
		}
	

	

