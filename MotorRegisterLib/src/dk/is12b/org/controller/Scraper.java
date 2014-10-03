package dk.is12b.org.controller;

import java.util.List;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import dk.is12b.org.model.Car;
import dk.is12b.org.model.CarContainer;
import dk.is12b.org.model.Inspection;

public class Scraper {
	private HtmlPage finalPage;

	public Scraper(){

	}

	@SuppressWarnings("unchecked")
	public Car getCar(String regNr) throws Exception {
		CarContainer cCont = CarContainer.getInstance();
		Car car = cCont.getCar(regNr);
		
		if(car == null){
			car = new Car();
		    WebClient webClient = new WebClient();
		    HtmlPage page = webClient.getPage("https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_nfpb=true&_pageLabel=vis_koeretoej_side&_nfls=false");
		    
		    ScriptResult result = page.executeJavaScript("document.getElementById('regnr').checked=true;"
	                +"document.getElementById('soegeord').value='"+regNr+"';"
	                +"document.getElementById('searchForm').submit();"
	                +"DMR.WaitForLoad.on();");
		    
		    finalPage = (HtmlPage) result.getNewPage();
		    writeVehicleData(car);
		    
		    page = webClient.getPage("https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=1&_pageLabel=vis_koeretoej_side");
		    result = page.executeJavaScript("DMR.WaitForLoad.on();");
		    finalPage = (HtmlPage) result.getNewPage();
		    writeTechnicalData(car);
		    
		    page = webClient.getPage("https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FvisKoeretoej%2FselectTab&kerne_vis_koeretoejdmr_tabset_tab=2&_pageLabel=vis_koeretoej_side");
		    result = page.executeJavaScript("DMR.WaitForLoad.on();");
		    finalPage = (HtmlPage) result.getNewPage();
		    writeInspectionData(car);
		    		    
		    cCont.addCar(car);
		    webClient.closeAllWindows();
		}
	    return car;
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
		car.setNumOfDoors(getLabelValueByKey("Antal døre:"));
		car.setPosOfChassisNumber(getLabelValueByKey("Anbringelse af stelnummer:"));
	}
	
	private void writeInspectionData(Car car) {
		car.setCalInspectionDate(getLabelValueByKey("Beregnet dato for næste indkaldelse til periodisk syn:"));
		addInspections(car);
			
	}

	private void addInspections(Car car) {
		
		try {
			HtmlTable table = (HtmlTable) finalPage.getByXPath("//table[@class='stripes']").get(0);
			
			boolean firstRow = true;
			boolean firstInsp = true;
		    for (HtmlTableRow row : table.getRows()) {
		    	
		    	if(!firstRow) {
		    		
		    		String status = row.getCell(2).asText();
		    		String date = row.getCell(3).asText();
		    		
		    		Inspection insp = car.addInspection(date, status);
		    		if (firstInsp) {
		    			firstInsp = false;
		    			insp.setType(getSpanValueByKey("Synstype:"));
		    		}
		    	} 
		    	else {
		    		firstRow = false;
		    	}
		    	
		    }
		}
		catch(NullPointerException | IndexOutOfBoundsException e) {
			//No inspections
		}
	}
}
