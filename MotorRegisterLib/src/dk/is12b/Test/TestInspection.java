package dk.is12b.Test;

import dk.is12b.org.controller.Scraper;
import dk.is12b.org.model.Car;
import dk.is12b.org.model.Inspection;

public class TestInspection {
	
	public static void main(String[] args){
		new TestInspection();
	}
	
	public TestInspection(){
		
		Scraper sc = new Scraper();
		
		Car car = new Car();
		
		sc.addInspections("FA21984", car);
		
		for(Inspection i : car.getInspections()){
			System.out.println(i);
		}
	}

}
