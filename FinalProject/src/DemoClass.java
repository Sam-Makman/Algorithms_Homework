
public class DemoClass implements AdvancedCompare<DemoClass>{
	double dval;
	
	public DemoClass(double d){
		dval=d;
	}
	
	public double getValue(){
		return dval;
	}
	
	@Override
	public double advancedCompare(DemoClass cTo) {
		
		return dval - cTo.getValue();
	}

}
