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

public class Scraper {
	private HtmlPage finalPage;

	public Scraper(){

	}

	@SuppressWarnings("unchecked")
	public Car getCar(String regNr) throws Exception {
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_nfpb=true&_pageLabel=vis_koeretoej_side&_nfls=false");
	    
	    ScriptResult result = page.executeJavaScript("document.getElementById('regnr').checked=true;"
                +"document.getElementById('soegeord').value='"+regNr+"';"
                +"document.getElementById('searchForm').submit();"
                +"DMR.WaitForLoad.on();");
	    
	    finalPage = (HtmlPage) result.getNewPage();
	    
	    Car car = new Car();
	    writeVehicleData(car);
	    webClient.closeAllWindows();
	    
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
	
	public void writeVehicleData(Car car){
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
}
