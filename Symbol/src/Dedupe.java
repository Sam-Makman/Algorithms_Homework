import java.util.Scanner;

public class Dedupe {
	
	public static void main(String [] args) throws CloneNotSupportedException  {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double percent = scan.nextDouble();
		Post [] posts = generatePostsWithDupes(n, percent);
//		shuffle(posts);
		SeparateChainHashST<Post, Post> hashTable = new SeparateChainHashST<Post, Post>(n);
		for(Post p : posts){
			System.out.println(p);
			hashTable.put(p, p);
		}
		System.out.println("hashtable size = " + hashTable.size());
		for(Post key : hashTable.keys()){
			System.out.println(key.hashCode());
		}
		System.out.println("Done");
		
	}
	
	
	/**
	 * 
	 * @param N size of Post array
	 * @param percentage the percentage of entries that should be a duplicate of some other entry
	 * @return list of array containing duplicates.
	 * @throws CloneNotSupportedException 
	 */
	public static Post [] generatePostsWithDupes(int N, double percentage) throws CloneNotSupportedException {
		if (N <= 0) throw new IllegalArgumentException("N must be >= 1");
		if (percentage < 0 || percentage > 1) throw new IllegalArgumentException("percentage must be between 0 and 1");
		int j =  N -  (int) (N * percentage) ;
		Post [] posts = new Post[N];
		int i = 0;
		if(j==0){
			System.out.println("percent is 1");
			posts[0] = new Post();
			for(int m = 1; m< posts.length; m++){
				posts[m] = (Post) posts[0].clone();
			}
					
		}else{
			System.out.println("percent is not 1");
		for(i=0; i < j ;i++){
			posts[i] = new Post();
		}
		for(i=j; i<N;i++){
			posts[i] = (Post) posts[i%j].clone();
		}}
		 return posts;
	}
	
	/**
	 * shuffles an array of posts
	 * 
	 * @param arr
	 */
	public static void shuffle(Post [] arr) {
		// knuth shuffle
		for(int i=0;i<arr.length;i++) {
			Post tp = arr[i];
			int rnd = StdRandom.uniform(i,arr.length);
			arr[i]=arr[rnd];
			arr[rnd]=tp;	
		}
	}
	
	
	/**
	 * generates a random set of Posts
	 * @param N size of set
	 * @return array of posts  (the set)
	 */
	public static Post [] generatePosts(int N) {
		
		if (N <= 0) throw new IllegalArgumentException("N must be >= 1");
		Post [] posts = new Post[N];
		for(int i=0;i<N;i++) {
			posts[i] = new Post();
		}
		
		return posts;
	}
}
