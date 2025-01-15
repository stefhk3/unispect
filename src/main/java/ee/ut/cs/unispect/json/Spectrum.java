package ee.ut.cs.unispect.json;

public class Spectrum {
	private String ontologyterm;
	private int sourceid;
	private String spectrumURL;
	private String compoundURL;
	private String compoundId;
	private String spectrumId;
	private String comment;

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getSpectrumURL() {
		return spectrumURL;
	}
	public void setSpectrumURL(String spectrumURL) {
		this.spectrumURL = spectrumURL;
	}
	public String getCompoundURL() {
		return compoundURL;
	}
	public void setCompoundURL(String compoundURL) {
		this.compoundURL = compoundURL;
	}
	public String getCompoundId() {
		return compoundId;
	}
	public void setCompoundId(String compoundId) {
		this.compoundId = compoundId;
	}
	public String getSpectrumId() {
		return spectrumId;
	}
	public void setSpectrumId(String spectrumId) {
		this.spectrumId = spectrumId;
	}
	public String getOntologyterm() {
		return ontologyterm;
	}
	public void setOntologyterm(String ontologyterm) {
		this.ontologyterm = ontologyterm;
	}
	public int getSourceid() {
		return sourceid;
	}
	public void setSourceid(int sourceid) {
		this.sourceid = sourceid;
	}
}
