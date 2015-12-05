
public class ParallelEdgeCounter {

	/**
	 * 
	 * @param g graph to process
	 */
	Graph graph;
	public ParallelEdgeCounter(Graph g) {
		graph = g;
	}
	
	/**
	 * 
	 * @return the total// TODO your implementation here # of parallel edges in the graph
	 */
	public int size() { 
		int count = 0;
		for(int i = 0; i < graph.V(); i++ ){
			boolean[] para = new boolean[ graph.V()];
			for(int adj : graph.adj(i)){
				if(para[adj] == false){
					para[adj] = true;
				}else{
					count++;
				}
			}
		}
		count = count/2;
		return count;
	}
}
