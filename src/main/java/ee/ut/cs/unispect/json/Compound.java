package ee.ut.cs.unispect.json;

import java.util.List;

public class Compound {
	private String inchi;
	private List<Spectrum> spectra;
	private String standardInchiKey;

	public String getInchi() {
		return inchi;
	}
	public void setInchi(String inchi) {
		this.inchi = inchi;
	}
	public List<Spectrum> getSpectra() {
		return spectra;
	}
	public void setSpectra(List<Spectrum> spectra) {
		this.spectra = spectra;
	}
	public String getStandardInchiKey() {
		return standardInchiKey;
	}
	public void setStandardInchiKey(String standardInchiKey) {
		this.standardInchiKey = standardInchiKey;
	}

}
