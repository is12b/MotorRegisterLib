package dk.is12b;

import dk.is12b.org.controller.Scraper;
import dk.is12b.org.model.Car;

public class Test {
	
	public static void main(String[] args) {
		new Test();
	}
	
	public Test() {
		Scraper sc = new Scraper();
		try {
			Car car = sc.getCar("FA21984");
			car.printOut();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
