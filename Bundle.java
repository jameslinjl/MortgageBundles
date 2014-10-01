// James Lin, Columbia University
// jl3782@columbia.edu
// Sapient Global Coding Challenge

// Bundle Object to simulate Bundle
public class Bundle {
	
	private int bundleID;
	
	public Bundle(int id){
		bundleID = id;
	}
	
	public void setBundleID(int bid){
		bundleID = bid;
	}
	
	public int getBundleID(){
		return bundleID;
	}
	
	public void printBundleID(){
		System.out.print("B" + getBundleID());
	}
}
