package ee.ut.cs.unispect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;
import org.openscience.nmrshiftdb.om.DBCanonicalNamePeer;
import org.openscience.nmrshiftdb.om.DBMolecule;
import org.openscience.nmrshiftdb.om.DBMoleculePeer;
import org.openscience.nmrshiftdb.om.DBSpectrum;
import org.openscience.nmrshiftdb.util.NmrshiftdbConstants;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ee.ut.cs.unispect.json.Compound;
import ee.ut.cs.unispect.json.SpectraResult;
import ee.ut.cs.unispect.json.Spectrum;

public class Unispect extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Map<Integer,String> ontologies=new HashMap<>();
	static {
		ontologies.put(1,"http://purl.obolibrary.org/obo/CHMO_0000595");
		ontologies.put(2,"http://purl.obolibrary.org/obo/CHMO_0000593");
		ontologies.put(3,"http://purl.obolibrary.org/obo/CHMO_0000567");
		ontologies.put(4,"http://purl.obolibrary.org/obo/CHMO_0000739");
		ontologies.put(5,"http://purl.obolibrary.org/obo/CHMO_0000597");
		ontologies.put(6,"http://purl.obolibrary.org/obo/CHMO_0000594");
		ontologies.put(7,"http://purl.obolibrary.org/obo/CHMO_0001155");
		ontologies.put(8,"http://purl.obolibrary.org/obo/CHMO_0001189");
		ontologies.put(9,"http://purl.obolibrary.org/obo/CHMO_0002128");
		ontologies.put(10,"http://purl.obolibrary.org/obo/CHMO_0002455");
		ontologies.put(11,"http://purl.obolibrary.org/obo/CHMO_0000720");
		ontologies.put(12,"http://purl.obolibrary.org/obo/CHMO_0001150");
		ontologies.put(13,"http://purl.obolibrary.org/obo/CHMO_0001150");
		ontologies.put(14,"http://purl.obolibrary.org/obo/CHMO_0002380");
		ontologies.put(15,"http://purl.obolibrary.org/obo/CHMO_0002380");
		ontologies.put(16,"http://purl.obolibrary.org/obo/CHMO_0001150");
		ontologies.put(17,"http://purl.obolibrary.org/obo/CHMO_0001150");
		ontologies.put(18,"http://purl.obolibrary.org/obo/CHMO_0001149");
		ontologies.put(23,"http://purl.obolibrary.org/obo/CHMO_0002380");
		ontologies.put(24,"http://purl.obolibrary.org/obo/CHMO_0002380");
		ontologies.put(25,"http://purl.obolibrary.org/obo/CHMO_0001149");
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try{
			String TorqueProperties = config.getServletContext().getRealPath("/WEB-INF/conf/Torque.properties");
			Torque.init(TorqueProperties);
		}
		catch(org.apache.torque.TorqueException te){
			te.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendError(HttpServletResponse.SC_FORBIDDEN);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		System.out.println(pathInfo);
		if(pathInfo.equals("/v1/spectra")) {
		    StringTokenizer st = new StringTokenizer(req.getRequestURL().toString(), "/");
		    StringBuffer url = new StringBuffer(st.nextToken());
		    url.append("//");
		    url.append(st.nextToken()+"/");
			req.getReader();
			res.setContentType("application/json");			
			JsonObject requestjson = JsonParser.parseReader(req.getReader()).getAsJsonObject();
			String reqtype = requestjson.get("type").getAsString();
			String reqcompound = requestjson.get("compound").getAsString();
			if(reqtype.equals("inchikey")) {
				try {
					Criteria crit=new Criteria();
					crit.add(DBCanonicalNamePeer.NAME,reqcompound);
					crit.addJoin(DBCanonicalNamePeer.MOLECULE_ID, DBMoleculePeer.MOLECULE_ID);
					List<DBMolecule> mols = DBMoleculePeer.doSelect(crit);
				    SpectraResult response=new SpectraResult();
					if(mols.size()==0) {
						response.setTotalCompounds(0);
						response.setResponse("Failure - no such compound");
					}else {
					    response.setTotalCompounds(1);
					    response.setResponse("Success");
					    Compound compound=new Compound();
					    compound.setInchi(mols.get(0).getInchi());
					    compound.setStandardInchiKey(mols.get(0).getInchiKey());
					    response.setCompounds(new ArrayList<>());
					    response.getCompounds().add(compound);
					    compound.setSpectra(new ArrayList<>());
						List<DBSpectrum> spectra = mols.get(0).getDBSpectrums();
						for(DBSpectrum dbspectrum : spectra) {
							if(dbspectrum.getReviewFlag().equals(NmrshiftdbConstants.TRUE) && ontologies.get(dbspectrum.getDBSpectrumType().getSpectrumTypeId())!=null) {
								Spectrum spectrum=new Spectrum();
								spectrum.setOntologyterm(ontologies.get(dbspectrum.getDBSpectrumType().getSpectrumTypeId()));
								spectrum.setSourceid(1);
								String comment="A "+dbspectrum.getDBSpectrumType().getNameAsString()+" NMR of "+mols.get(0).getChemicalNamesAsOneStringWithFallbackEasy() +" measured in "+dbspectrum.getSolvent()+" on a "+dbspectrum.getFrequency()+" MHz spectrometer";
								spectrum.setComment(comment);
								spectrum.setCompoundURL(url+mols.get(0).getEasylink(req));
								spectrum.setCompoundId(Integer.toString(mols.get(0).getMoleculeId()));
								spectrum.setSpectrumId(Integer.toString(dbspectrum.getSpectrumId()));
								spectrum.setSpectrumURL(url+mols.get(0).getEasylink(req)+"#spectrum"+dbspectrum.getSpectrumId());
								compound.getSpectra().add(spectrum);
							}
						}					
					}
					Gson gson = new Gson();
					res.getWriter().write(gson.toJson(response));
					res.getWriter().close();
				}catch(TorqueException ex) {
					ex.printStackTrace();
					SpectraResult response=new SpectraResult();
					response.setTotalCompounds(0);
					response.setResponse("Failure - no such compound");	
					Gson gson = new Gson();
					res.getWriter().write(gson.toJson(response));
					res.getWriter().close();
					throw new IOException(ex);
				}
			}else {
				res.getWriter().write("Invalid type");
				res.getWriter().close();
				return;
			}			
		}
	}
}