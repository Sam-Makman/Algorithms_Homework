package hw5;

public class InSort {

	
public static void sort(int [] vals){
	if(vals == null) throw(new NullPointerException());
	
	for(int i = 1; i < vals.length; i++ ){
		for(int j=i; j>0 && vals[j]<vals[j-1]; j--){
			
			int temp = vals[j-1];
			vals[j-1] = vals[j];
			vals[j] = temp;
			
		}
	
	}
}

public static void sortC(Comparable [] vals){
	if(vals == null) throw(new NullPointerException());
	
	for(int i = 1; i < vals.length; i++ ){
		for(int j=i; j>0 && vals[j].compareTo(vals[j-1])<0; j--){
			
			Comparable temp = vals[j-1];
			vals[j-1] = vals[j];
			vals[j] = temp;
			
		}
	}
}
}
