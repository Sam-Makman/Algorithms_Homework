package lab2;
import stdlib.Stopwatch;
import stdlib.StdOut;
public class Analysis {

	public static void main(String[] args) {
		pageAnalysis2();

	}
	
	public static void maxChecker(){
		for(int j = 2;; j++){
		ScoredDocument [] sd = new ScoredDocument[j];
		for(int i = 0; i<sd.length; i++){
			sd[i]= new ScoredDocument();
		}
		JavaSortedPager jsp = new JavaSortedPager(sd, j/2);
		Stopwatch s = new Stopwatch();
		jsp.max();
		System.out.println(s.elapsedTime());
		}
	}
	
	public static void checker(){
		ScoredDocument [] sd = new ScoredDocument[20];
		for(int i = 0; i<sd.length; i++){
			sd[i]= new ScoredDocument();
		}
		ScoredResultsPager<ScoredDocument> src = new ScoredResultsPager<ScoredDocument>(sd, 5);
		for(int i = 0; i<sd.length;i++){
			System.out.println(((ScoredDocument)src.get(i)).score());
		}
	}
	
	public static void sortedPagerAnalysis(){
		JavaSortedPager<Double> jsp;
		for(int i = 1; ; i*=2){
			Stopwatch s = new Stopwatch();
			jsp = new JavaSortedPager<Double>(Lab2.randomDoubles(i), 10);
			StdOut.println(" n = " + i + " time " + s.elapsedTime());
		}
	}
	public static void pageAnalysis(){
		JavaSortedPager<Double> jsp;
		Double [] dub;
		for(int i = 1; ; i*=2){
			jsp = new JavaSortedPager<Double>(Lab2.randomDoubles(i), i/2);
			Stopwatch s = new Stopwatch();
			dub = jsp.page(2);
			StdOut.println(" n = " + i + " time " + s.elapsedTime());
		}
	}
	
	public static void pageAnalysis2(){
		ScoredResultsPager<ScoredDocument> srp;
		for(int i = 2;; i*=2){
			ScoredDocument [] sd = new ScoredDocument[i];
			for(int j= 0; j<sd.length;j++){
				sd[j] = new ScoredDocument();
			}
			srp = new ScoredResultsPager<ScoredDocument>(sd, i/2);
			Stopwatch s = new Stopwatch();
			srp.page(0);
			System.out.println("N = " + i/2 + " time " + s.elapsedTime());
		}
	}
	public static void scoreDocCheck(){
		ScoredDocument[] docs = new ScoredDocument[20];
		for(ScoredDocument d: docs){
			d = new ScoredDocument();
			System.out.println("score  " + d.score());
		}
	}
	
	public static void sortCompare(){
		ScoredDocument[] docs = new ScoredDocument[10000];
		for(int j = 0; j< docs.length;j++){
			docs[j] = new ScoredDocument();
		}
		for(int i = 10000;; i*=2){
			ScoredDocument[] temp = new ScoredDocument[i];
			for(int j = 0; j< docs.length;j++){
				temp[j] = docs[j];
			}
			for(int j = docs.length; j< i;j++){
				temp[j] = new ScoredDocument();
			} 
			docs=temp;
			System.out.println("N = " + i);
			Stopwatch s = new Stopwatch();
			JavaSortedPager jsp = new JavaSortedPager(docs, 10);
				System.out.println("JSP " + s.elapsedTime());
				s = new Stopwatch();
			ScoredResultsPager srp = new ScoredResultsPager(docs, 10);
			System.out.println("SRP " + s.elapsedTime());
			}
			
		}
	
	}

