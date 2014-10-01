package dk.is12b.org.controller;

import java.util.List;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;

import dk.is12b.org.model.Car;
import dk.is12b.org.model.CarContainer;

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
		    		    
		    cCont.addCar(car);
		    webClient.closeAllWindows();
		}
	    return car;
	}
	
	public String getSpanValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//span[contains(., '" + key + "')]");
	    try{
			retS = dE.getNextElementSibling().asText();;
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	public String getLabelValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//label[contains(., '" + key + "')]");
		try{
			retS = dE.getParentNode().getNextSibling().getChildNodes().get(0).asText();
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	public String getIndentedLabelValueByKey(String key){
		String retS = "";
		DomElement dE = (DomElement) finalPage.getFirstByXPath("//label[contains(., '" + key + "')]");
		try{
			retS = dE.getParentNode().getParentNode().getNextSibling().getChildNodes().get(0).asText();
		}catch(NullPointerException e){
			retS = "Ukendt";
		}
	    return retS;
	}
	
	public void writeVehicleData(Car car){
		car.setChassisNumber(getSpanValueByKey("Stelnummer:"));
		car.setModel(getSpanValueByKey("M�rke, Model, Variant:"));
		car.setType(getSpanValueByKey("Art:"));
		car.setLatestChangeVehicle(getSpanValueByKey("Seneste �ndring:"));
		car.setRegNumber(getSpanValueByKey("Registrerings�nummer:"));
		car.setFirstRegDate(getSpanValueByKey("F�rste registrerings�dato:"));
		car.setUse(getSpanValueByKey("Anvendelse:"));
		car.setLatestChangeReg(getSpanValueByKey("Seneste �ndring:"));
		car.setStatus(getLabelValueByKey("Status:"));
	}
	

	public void writeTechnicalData(Car car) {
		car.setTecTotalWeight(getLabelValueByKey("Teknisk totalv�gt:"));
		car.setTotalWeight(getLabelValueByKey("Totalv�gt:"));
		car.setOwnWeight(getLabelValueByKey("Egenv�gt:"));
		car.setCouplingDevice(getLabelValueByKey("Tilkoblingsanordning:"));
		car.setWeightOfTrailerWithBrakes(getIndentedLabelValueByKey("Med bremser:"));
		car.setWeightOfTrailerWithoutBrakes(getIndentedLabelValueByKey("Uden bremser:"));
		car.setPropellant(getLabelValueByKey("Drivkraft:"));
		car.setFuelConsumption(getLabelValueByKey("Br�ndstofforbrug:"));
		car.setBodyType(getLabelValueByKey("Karrosseritype:"));
		car.setNumOfDoors(getLabelValueByKey("Antal d�re:"));
		car.setPosOfChassisNumber(getLabelValueByKey("Anbringelse af stelnummer:"));
	}
}
