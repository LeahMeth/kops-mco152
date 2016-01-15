package kops.nypl;

public class Response {
	
	private int numResults;
	private Result[] results;
	private Capture[] captures;
	
	public int getNumResults(){
		return this.numResults;
	}
	
	public Result[] getResults(){
		return this.results;
	}

	public Capture[] getCaptures(){
		return this.captures;
	}
}
