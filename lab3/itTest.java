
public class itTest {

	public static void main(String [] args){
		SequentialSearchST<Integer,Integer> st = new SequentialSearchST<Integer, Integer>();
		for(int i = 0; i<100;i++){
			st.put(i*2 , i*5);
		}
		st.put(10, 4);
		for(Integer i : st.keys()){
		System.out.println(i);
		}
		
		st.delete(6);
		System.out.println("Delete");
		for(Integer i : st.keys()){
			System.out.println(i);
			}
	}
}
