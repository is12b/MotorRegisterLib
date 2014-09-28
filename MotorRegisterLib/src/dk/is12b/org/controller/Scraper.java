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

	public static void main(String[] args) {
		new Scraper();
	}

	public Scraper(){
		try {
			homePage("FA21984");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void homePage(String regNr) throws Exception {
	    WebClient webClient = new WebClient();
	    HtmlPage page = webClient.getPage("https://motorregister.skat.dk/dmr-front/appmanager/skat/dmr?_nfpb=true&_windowLabel=kerne_vis_koeretoej&kerne_vis_koeretoej_actionOverride=%2Fdk%2Fskat%2Fdmr%2Ffront%2Fportlets%2Fkoeretoej%2Fnested%2FfremsoegKoeretoej%2Fsearch&_pageLabel=vis_koeretoej_side");
	    
	    ScriptResult result = page.executeJavaScript("document.getElementById('regnr').checked=true;"
                +"document.getElementById('soegeord').value='"+regNr+"';"
                +"document.getElementById('searchForm').submit();"
                +"DMR.WaitForLoad.on();");
	    final HtmlPage finalPage = (HtmlPage) result.getNewPage();
	    
	    // Getting the first Column for Vehicle and Registration data
	    HtmlDivision divColNo1 = (HtmlDivision) finalPage.getByXPath("//div[@class='colNo1 unit']").get(0);	    
	    List<HtmlSpan> divsVehicle = (List<HtmlSpan>) divColNo1.getByXPath("//span[@class='value']");
	    List<HtmlDivision> spans = (List<HtmlDivision>) finalPage.getByXPath("//div[contains(@class,'colValue')]");
	    List<HtmlDivision> blocking = (List<HtmlDivision>) finalPage.getByXPath("//div[contains(@class,'unit formCol colNo1')]");
	    
	    Car car = new Car();
	    
	    
	    writeVehicleData(car, divsVehicle);
	    writeData(car, spans, blocking);
	    
	    System.out.println(car.getChassisNumber() + ", " + car.getModel() + ", " + car.getType() + ", " + car.getLatestChangeVehicle() + ", " + car.getEfType() + ", "
		           + car.getBreakDecleraionNum() + ", " + car.getFurtherUse());
	     
		
	    
	    webClient.closeAllWindows();
	}
	
	public void writeData(Car car, List<HtmlDivision> divs, List<HtmlDivision> blocking){
		//Registration - Registrerings­forhold
		car.setRegNumber(divs.get(0).asText());
		car.setFirstRegDate(divs.get(1).asText());
		car.setUse(divs.get(2).asText());
		car.setLatestChangeReg(divs.get(3).asText());
		car.setStatus(divs.get(4).asText());
		car.setRegType(divs.get(5).asText());
		car.setEuVariation(divs.get(6).asText());
		car.setEuVersion(divs.get(7).asText());
		car.setCategory(divs.get(8).asText());
		car.setManufacturer(divs.get(9).asText());
		
		// Anmodningsårsag
		car.setRequestYear(divs.get(10).asText());
		car.setValuationDescription(divs.get(11).asText());
		car.setValuationMileage(divs.get(12).asText());
		car.setValuationCondition(divs.get(13).asText());
		
		//Identification - Identifikation
		car.setVehicleID(divs.get(14).asText());
		car.setChassisNumSideVagon(divs.get(15).asText());
		car.setColor(divs.get(16).asText());
		car.setModelYear(divs.get(17).asText());
		car.setFirstIdDate(divs.get(18).asText());
		car.setCommissioningDate(divs.get(19).asText());
		car.setNcapTest(divs.get(20).asText());
		car.setVanTax(divs.get(21).asText());
		car.setFuelMode(divs.get(22).asText());
		car.setAirSuspension(divs.get(23).asText());
		
		//Stand - Stand
		car.setMileageStand(divs.get(24).asText());
		car.setMileageDocumentation(divs.get(25).asText());
		car.setStandComments(divs.get(26).asText());
		car.setVehicleStand(divs.get(27).asText());
		car.setTrafficInjury(divs.get(28).asText());
		car.setOriginalVeteran(divs.get(29).asText());
		
		//Electrical installations - El-anlæg
		car.setZoneKlimate1or2(divs.get(30).asText().equals("Ja"));
		car.setZoneKlimate3or4(divs.get(31).asText().equals("Ja"));
		car.setDistanceRadar(divs.get(32).asText().equals("Ja"));
		car.setCruiseControl(divs.get(33).asText().equals("Ja"));
		car.setSeatBeltWarning(Integer.parseInt(divs.get(34).asText()));
		car.setRearViewCam(divs.get(35).asText().equals("Ja"));
		car.setHeatedWindscreen(divs.get(36).asText().equals("Ja"));
		car.setPowerTailgate(divs.get(37).asText().equals("Ja"));
		car.setElectricalClosingDoors(divs.get(38).asText().equals("Ja"));
		car.setHeadupDisplay(divs.get(39).asText().equals("Ja"));
		car.setHifi(divs.get(40).asText().equals("Ja"));
		car.setKeyLess(divs.get(41).asText().equals("Ja"));
		car.setLineGuardian(divs.get(42).asText().equals("Ja"));
		car.setManualAircon(divs.get(43).asText().equals("Ja"));
		car.setNightVision(divs.get(44).asText().equals("Ja"));
		car.setNavigation(divs.get(45).asText().equals("Ja"));
		car.setOrgAlarm(divs.get(46).asText().equals("Ja"));
		car.setParkingAssistant(divs.get(47).asText().equals("Ja"));
		car.setParkingControlRear(divs.get(48).asText().equals("Ja"));
		car.setParkingControlFront(divs.get(49).asText().equals("Ja"));
		car.setSolarCooling(divs.get(50).asText().equals("Ja"));
		car.setVoiceControl(divs.get(51).asText().equals("Ja"));
		car.setLaneSwitchAlarm(divs.get(52).asText().equals("Ja"));
		
		//Body - Karrosseri 
		car.setThreeOrMoreSeatRows(divs.get(53).asText().equals("Ja"));
		car.setDoubleCab(divs.get(54).asText().equals("Ja"));
		car.setElectricSunroof(divs.get(55).asText().equals("Ja"));
		car.setGlassRoof(divs.get(56).asText().equals("Ja"));
		car.setBendLighting(divs.get(57).asText().equals("Ja"));
		car.setRht(divs.get(58).asText().equals("Ja"));
		car.setMetallic(divs.get(59).asText().equals("Ja"));
		car.setBodyRebuilt(divs.get(60).asText().equals("Ja"));
		car.setTarga(divs.get(61).asText().equals("Ja"));
		car.setLoadArea(divs.get(62).asText().equals("Ja"));
		car.setXenon(divs.get(63).asText().equals("Ja"));
		
		//Engine - Motor
		car.setSixGearManual(divs.get(64).asText().equals("Ja"));
		car.setEscStability(divs.get(65).asText().equals("Ja"));
		car.setCompressor(divs.get(66).asText().equals("Ja"));
		car.setEngineHeater(divs.get(67).asText().equals("Ja"));
		car.setEngineNumber(divs.get(68).asText().equals("Ja"));
		car.setDifferentEngine(divs.get(69).asText().equals("Ja"));
		
		//Breaks - Bremser
		car.setAbs(divs.get(70).asText().equals("Ja"));
		car.setCeramicDisc(divs.get(71).asText().equals("Ja"));
		car.setDiscBrakesRear(divs.get(72).asText().equals("Ja"));
		car.setDiscBrakesFront(divs.get(73).asText().equals("Ja"));
		
		//Bearing Elements - Bærende Elementer
		car.setSuspensionFrame(divs.get(74).asText().equals("Ja"));
		car.setElectronicDampers(divs.get(75).asText().equals("Ja"));
		car.setAirSuspensionBearing(divs.get(76).asText().equals("Ja"));
		car.setLevelling(divs.get(77).asText().equals("Ja"));
		car.setRebuiltFrame(divs.get(78).asText().equals("Ja"));
		car.setRigidFrame(divs.get(79).asText().equals("Ja"));
		car.setTiresGreaterThan20(divs.get(80).asText().equals("Ja"));
		
		//Equipment - Udstyr
		car.setAirbags(Integer.parseInt(divs.get(81).asText()));
		car.setRadio(divs.get(82).asText().equals("Ja"));
		
		//Transmission - Transmission
		car.setAutomaticGearing(divs.get(83).asText().equals("Ja"));
		car.setAllWheelDrive(divs.get(84).asText().equals("Ja"));
		car.setSteeringWheelGearShift(divs.get(85).asText().equals("Ja"));
		
		//Interior - Indretning
		car.setPartLeatherSeat(divs.get(86).asText().equals("Ja"));
		car.setBlindsRearDoors(divs.get(87).asText().equals("Ja"));
		car.setBlindsRearWindow(divs.get(88).asText().equals("Ja"));
		car.setElectricAdjustableSeatsBehind(divs.get(89).asText().equals("Ja"));
		car.setSolidPanniers(divs.get(90).asText().equals("Ja"));
		car.setIntegratedChildSeat(Integer.parseInt(divs.get(91).asText()));
		car.setLeatherSeats(divs.get(92).asText().equals("Ja"));
		car.setMassageSeats(divs.get(93).asText().equals("Ja"));
		car.setMemorySeatsFront(divs.get(94).asText().equals("Ja"));
		car.setSportComfortSeats(divs.get(95).asText().equals("Ja"));
		car.setVentilatedSeats(divs.get(96).asText().equals("Ja"));
		
		//Steering - Styreapparat
		car.setElectricAdjustingSteeringWheel(divs.get(97).asText().equals("Ja"));
		car.setRightSteering(divs.get(98).asText().equals("Ja"));
		car.setLongFork(divs.get(99).asText().equals("Ja"));
		car.setMultifunctionSteeringWheel(divs.get(100).asText().equals("Ja"));
		car.setHeatedSteeringWheel(divs.get(101).asText().equals("Ja"));
		
		//Turbo
		car.setTurbo(divs.get(102).asText().equals("Ja"));
		
		//Other
		car.setOther(divs.get(103).asText());
		
		//Blacking State - Blokeringstatus
		car.setBlocked(blocking.get(15).asText());
	}
	
	public void writeVehicleData(Car car, List<HtmlSpan> divs){
		 car.setChassisNumber(divs.get(0).asText());
		 car.setModel(divs.get(1).asText());
		 car.setType(divs.get(2).asText());
		 car.setLatestChangeVehicle(divs.get(3).asText());
		 car.setEfType(divs.get(4).asText());
		 car.setBreakDecleraionNum(divs.get(5).asText());
		 car.setFurtherUse(divs.get(6).asText());
	}
	
	
}
