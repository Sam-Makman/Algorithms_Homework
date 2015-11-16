package hw3;

public class StackChecker {

	
	public static boolean stackChecker(Boolean [] values){
		Stack<Boolean> s = new Stack<Boolean>();
		if(values == null){
			System.out.println("Is Null");
			return false;
		}
		for(Boolean b: values){
			s.push(b);
		}
		if(s.size()%2 == 1 ){
			System.out.println("Not Even");
			return false;
		}else{
			System.out.println("Enter Helper");
			return scHelper(s, s.size());
		}
		
	}
	
	private static boolean scHelper(Stack<Boolean> s, int size){
		if(s.isEmpty()){ 
			System.out.println("Is empty");
			return true;
			}
		else if(s.size() > size/2 && s.pop() == false){
			System.out.println("First Half");
			return scHelper(s, size);
		}
		else if(s.size() <= size/2 && s.pop() == true)
		{
			System.out.println("Second Half");
			return scHelper(s, size);
		}
		System.out.println("failed");
		return false;
		
	}
}
