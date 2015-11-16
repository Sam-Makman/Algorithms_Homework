	package lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaSortedPager<T extends Comparable<T>> implements Pageable<T>{

	private	 T[] objects;
	private int pageSize;
	
	public JavaSortedPager(T [] objects, int pageSize) throws IllegalArgumentException{ // constructor
		if(pageSize <= 0){
			throw new IllegalArgumentException("Illegal Page Size");
		}
		if(objects == null || objects.length == 0){
			throw new IllegalArgumentException("Illegal Object Array");
		}
		this.objects = Arrays.copyOfRange(objects, 0, objects.length-1);
		this.pageSize = pageSize;
		Arrays.sort(this.objects);
		
		
	}//end constructor 
	
	public T get(int i){ // get item at position i
		if(i<0 || i >= objects.length){
			throw new IndexOutOfBoundsException();
		}
		return objects[i];
	}
	
	public T max(){ // return largest item
		return objects[objects.length -1];
	}
	
	public T min(){ // return smallest item
	return objects[0];
	}

	@Override
	public int size() {
		return objects.length;
	}

	@Override
	public int pageSize() {
		return pageSize;
	}

	@Override
	public int pages() {
		return (int)Math.ceil((double)objects.length/(double)pageSize);
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
}
