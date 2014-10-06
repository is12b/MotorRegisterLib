package dk.is12b.org.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import dk.is12b.org.model.Car;
import dk.is12b.org.model.CarContainer;
import dk.is12b.org.model.Inspection;

public class Scraper {
	private HtmlPage finalPage;
	private WebClient webClient;

	public Scraper(){

	}

	@SuppressWarnings("unchecked")
	public Car getCar(String regNr) throws Exception {
		CarContainer cCont = CarContainer.getInstance();
		Car car = cCont.getCar(regNr);
		
		if(car == null){
			car = new Car();
		    webClient = new WebClient();
		    finalPage = getExecutedDMRPage(true, regNr, "https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_nfpb=true&_pageLabel=vis_koeretoej_side&_nfls=false");
		    
		    if(getSpanValueByKey("Stelnummer:") != "Ukendt") {
		    
			    writeVehicleData(car);
			    
			    finalPage = getExecutedDMRPage(false, regNr, "https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=1&_pageLabel=vis_koeretoej_side");
			    writeTechnicalData(car);
			    
			    finalPage = getExecutedDMRPage(false, regNr, "https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=2&_pageLabel=vis_koeretoej_side");
			    writeInspectionData(car, regNr);
			    
			    finalPage = getExecutedDMRPage(false, regNr, "https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=3&_pageLabel=vis_koeretoej_side");
			    writeInsuranceData(car);
			    
			    finalPage = getExecutedDMRPage(false, regNr, "https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=5&_pageLabel=vis_koeretoej_side");
			    writePermissions(car);
		    }
		    
		    cCont.addCar(car);
		    webClient.closeAllWindows();
		}
	    return car;
	}

	private HtmlPage getExecutedDMRPage(boolean firstLoad, String regNr, String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage page = webClient.getPage(url);
		String executeStr;
		if (firstLoad) {
			executeStr = "document.getElementById('regnr').checked=true;"
	                +"document.getElementById('soegeord').value='"+regNr+"';"
	                +"document.getElementById('searchForm').submit();"
	                +"DMR.WaitForLoad.on();";
		} else {
			executeStr = "DMR.WaitForLoad.on();";
		}
		ScriptResult result = page.executeJavaScript(executeStr);
    	return (HtmlPage) result.getNewPage();
	}

	private String getSpanValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//span[contains(., '" + key + "')]");
	    try{
			retS = dE.getNextElementSibling().asText();;
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	private String getLabelValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//label[contains(., '" + key + "')]");
		try{
			retS = dE.getParentNode().getNextSibling().getChildNodes().get(0).asText();
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	private String getIndentedLabelValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//label[contains(., '" + key + "')]");
		try{
			retS = dE.getParentNode().getParentNode().getNextSibling().getChildNodes().get(0).asText();
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	private void writeVehicleData(Car car){
		car.setChassisNumber(getSpanValueByKey("Stelnummer:"));
		car.setModel(getSpanValueByKey("Mærke, Model, Variant:"));
		car.setType(getSpanValueByKey("Art:"));
		car.setLatestChangeVehicle(getSpanValueByKey("Seneste ændring:"));
		car.setRegNumber(getSpanValueByKey("Registrerings­nummer:"));
		car.setFirstRegDate(getSpanValueByKey("Første registrerings­dato:"));
		car.setUse(getSpanValueByKey("Anvendelse:"));
		car.setLatestChangeReg(getSpanValueByKey("Seneste ændring:"));
		car.setStatus(getLabelValueByKey("Status:"));
	}
	

	private void writeTechnicalData(Car car) {
		car.setTecTotalWeight(getLabelValueByKey("Teknisk totalvægt:"));
		car.setTotalWeight(getLabelValueByKey("Totalvægt:"));
		car.setOwnWeight(getLabelValueByKey("Egenvægt:"));
		car.setCouplingDevice(getLabelValueByKey("Tilkoblingsanordning:"));
		car.setWeightOfTrailerWithBrakes(getIndentedLabelValueByKey("Med bremser:"));
		car.setWeightOfTrailerWithoutBrakes(getIndentedLabelValueByKey("Uden bremser:"));
		car.setPropellant(getLabelValueByKey("Drivkraft:"));
		car.setFuelConsumption(getLabelValueByKey("Brændstofforbrug:"));
		car.setBodyType(getLabelValueByKey("Karrosseritype:"));
		car.setPosOfChassisNumber(getLabelValueByKey("Anbringelse af stelnummer:"));
	}
	
	private void writeInspectionData(Car car, String regNr) {
		car.setInspectionFreq(getLabelValueByKey("Frekvens for periodisk syn:"));
		car.setCalInspectionDate(getLabelValueByKey("Beregnet dato for næste indkaldelse til periodisk syn:"));
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//p[contains(., 'Køretøjet har aldrig været synet.')]");
		if(dE == null) {
			addInspections(regNr, car);
		}
	}

	public void addInspections(String regNr, Car car) {
		String url = "http://selvbetjening.trafikstyrelsen.dk/Sider/resultater.aspx?Reg=" + regNr;
		try {
			WebClient webClient = new WebClient();
		    HtmlPage page = webClient.getPage(url);
		    HtmlTableBody table = (HtmlTableBody) page.getByXPath("//table[@id='tblInspections']/tbody").get(0);
			
		    for (HtmlTableRow row : table.getRows()) {
		    	Inspection inspec = new Inspection();
		    	String[] data = new String[row.getChildElementCount()];
		    	int i = 0;
		    	for(HtmlTableCell td : row.getCells()){
		    		if(!td.asXml().contains("<a")){
		    			data[i] = td.asText();
		    		}else{
		    			HtmlAnchor a = (HtmlAnchor) td.getFirstByXPath("//a[@class='saveIcon']");
		    			data[i] = "http://selvbetjening.trafikstyrelsen.dk" + a.getAttribute("href");
		    		}
		    		i++;
		    	}
		    	inspec.setDate(data[0]);
		    	inspec.setResult(data[1]);
		    	inspec.setKm(data[2]);
		    	inspec.setRegNr(data[3]);
		    	inspec.setUrl(data[4]);
		    	
		    	car.addInspection(inspec);
		    }
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	private void writeInsuranceData(Car car) {
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//span[contains(., 'Ingen forsikring:')]");
		if(dE == null) {
			car.setIsInsured(true);
			car.setInsuranceComp(getSpanValueByKey("Selskab:"));
			car.setInsuranceStatus(getSpanValueByKey("Status:"));
			car.setInsuranceCreated(getSpanValueByKey("Oprettet:"));
		}
	}
	
	private void writePermissions(Car car) {
		HtmlTable table = (HtmlTable)  finalPage.getFirstByXPath("//table[@class='stripes']");
		if(table != null) {
			int index = 1;
			List<HtmlTableRow> rows = table.getRows();
			while(index < rows.size() && rows.get(0).getCell(0).asText().equals("Tilladelse")) {
				car.addPermission(rows.get(index).getCell(0).asText());
				index++;
			}
		}
				
	}

}
