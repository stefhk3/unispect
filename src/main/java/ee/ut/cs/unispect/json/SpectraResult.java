package ee.ut.cs.unispect.json;

import java.util.List;

public class SpectraResult {
	private List<Compound> compounds;
	private String response;
	private int totalCompounds=0;
	
	public List<Compound> getCompounds() {
		return compounds;
	}
	public void setCompounds(List<Compound> compounds) {
		this.compounds = compounds;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getTotalCompounds() {
		return totalCompounds;
	}
	public void setTotalCompounds(int totalCompounds) {
		this.totalCompounds = totalCompounds;
	}

}
