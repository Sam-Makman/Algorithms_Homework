package hw6;

public class HeapChecker {

	
	public static int HeapCheck(int [] array) throws IllegalArgumentException{
		if(array.length == 0 || array == null){
			throw new IllegalArgumentException();
		}
		else if(array.length < 1){
			return 1;
		}
		else if(array[0] >= array[1]){
			 if( array[0] >= maxCheck(array,1 )){
				 return 1;
			 }
		}
		else if(array[0] < array[1]){
			if( array[0] < minCheck(array,1 )){
				 return -1;
			 }
		}
		return 0;
	}
	
	
	private static int maxCheck(int [] array, int pos){
		if(pos * 2 > array.length || (pos * 2)+1 > array.length){
			return array[pos];
		}
		else if(array[pos] >= maxCheck(array, pos*2) && array[pos] >= maxCheck(array, (pos*2)+1)){
			return array[pos];
		}
		return (int) Integer.MAX_VALUE;
	}
	
	private static int minCheck(int [] array, int pos){
		if(pos * 2 > array.length || (pos * 2)+1 > array.length){
			return array[pos];
		}
		if(array[pos] <= minCheck(array, pos*2) && array[pos] <= minCheck(array, (pos*2)+1)){
			return array[pos];
		}
		return (int) Integer.MIN_VALUE;
	}
	
}
