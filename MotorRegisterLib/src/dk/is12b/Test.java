package dk.is12b;

import dk.is12b.org.controller.Scraper;
import dk.is12b.org.model.Car;

public class Test {
	
	public static void main(String[] args) {
		new Test();
	}
	
	public Test() {
		Scraper sc = new Scraper();
		Car car = null;
		try {
			car = sc.getCar("FA21984");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Stelnummer: " + car.getChassisNumber());
		System.out.println("Mærke, Model, Variant: " + car.getModel());
		System.out.println("Art: " + car.getType());
		System.out.println("Seneste ændring: " + car.getLatestChangeVehicle());
		System.out.println("Registrerings­nummer: " + car.getRegNumber());
		System.out.println("Første registrerings­dato: " + car.getFirstRegDate());
		System.out.println("Anvendelse: " + car.getUse());
		System.out.println("Seneste ændring: " + car.getLatestChangeReg());
		System.out.println("Status: " + car.getStatus());
		System.out.println("Teknisk totalvægt: " + car.getTecTotalWeight());
		System.out.println("Totalvægt: " + car.getTotalWeight());
		System.out.println("Totalvægt: " + car.getTotalWeight());
		System.out.println("Egenvægt: " + car.getOwnWeight());
		System.out.println("Tilkoblingsanordning: " + car.getCouplingDevice());
		System.out.println("Max påhængvægt m. bremser: " + car.getWeightOfTrailerWithBrakes());
		System.out.println("Max påhængvægt u. bremser: " + car.getWeightOfTrailerWithoutBrakes());
		System.out.println("Drivkraft: " + car.getPropellant());
		System.out.println("Brændstofforbrug: " + car.getFuelConsumption());
		System.out.println("Karrosseritype: " + car.getBodyType());
		System.out.println("Antal døre: " + car.getNumOfDoors());
		
		//Checking Cache
		Car car2 = null;
		try {
			car2 = sc.getCar("FA21984");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(car == car2){
			System.out.println("Yepp!");
		}
	}
}
