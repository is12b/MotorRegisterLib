package dk.is12b.org.model;

import java.util.ArrayList;

public class CarContainer {
	private static CarContainer instance;
	private ArrayList<Car> cars;
	
	private CarContainer() {
		cars = new ArrayList<Car>();
	}
	
	public static CarContainer getInstance(){
		if(instance == null){
			instance = new CarContainer();
		}
		
		return instance;
	}
	
	public void addCar(Car car){
		cars.add(car);
	}
	
	public Car getCar(String regNr){
		Car car = null;
		int i = 0;
		boolean found = false;
		while(!found && 0 < cars.size()){
			if(cars.get(i).getRegNumber().equalsIgnoreCase(regNr)){
				car = cars.get(i);
				found = true;
			}
		}
		
		return car;
	}
}
