package dk.is12b.org.model;

public class Car {
	//Vehicle - Køretøj
	private String chassisNumber; // Stelnummer
	private String model; // Mærke, Model, Variant
	private String type; // Art
	private String latestChangeVehicle; // Seneste ændring
	
	//Registration - Registrerings­forhold
	private String regNumber; // Registrerings­nummer
	private String firstRegDate; // Første registrerings­dato
	private String use; // Anvendelse
	private String latestChangeReg; // Seneste ændring
	private String status; // Status
	
	//Weight - Vægt
	private String tecTotalWeight; // Teknisk totalvægt
	private String totalWeight; // Totalvægt
	private String ownWeight; // Egenvægt
	private String couplingDevice; // Tilkoblingsanordning
	private String weightOfTrailerWithBrakes; // Vægt af påhængskøretøj med bremser
	private String weightOfTrailerWithoutBrakes; // Vægt af påhængskøretøj uden bremser
	
	//Motor
	private String propellant; // Drivkraft
	private String fuelConsumption; // Brændstofforbrug
	
	//Body - Karrosseri
	private String bodyType; // Karrosseritype
	private String numOfDoors; // Antal døre
	private String posOfChassisNumber; // Anbringelse af stelnummer
	
	
	
	//ID - Iteration
	private int id;
	private static int idIterator;
	
	public Car() {
		idIterator++;
		this.id = idIterator;
	}
	
	public int getID(){
		return id;
	}
	
	/**
	 * @return the chassisNumber
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}
	
	/**
	 * @param chassisNumber the chassisNumber to set
	 */
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the latestChangeVehicle
	 */
	public String getLatestChangeVehicle() {
		return latestChangeVehicle;
	}
	
	/**
	 * @param latestChangeVehicle the latestChangeVehicle to set
	 */
	public void setLatestChangeVehicle(String latestChangeVehicle) {
		this.latestChangeVehicle = latestChangeVehicle;
	}
	
	/**
	 * @return the regNumber
	 */
	public String getRegNumber() {
		return regNumber;
	}
	
	/**
	 * @param regNumber the regNumber to set
	 */
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	/**
	 * @return the firstRegDate
	 */
	public String getFirstRegDate() {
		return firstRegDate;
	}
	
	/**
	 * @param firstRegDate the firstRegDate to set
	 */
	public void setFirstRegDate(String firstRegDate) {
		this.firstRegDate = firstRegDate;
	}
	
	/**
	 * @return the use
	 */
	public String getUse() {
		return use;
	}
	
	/**
	 * @param use the use to set
	 */
	public void setUse(String use) {
		this.use = use;
	}
	
	/**
	 * @return the latestChangeReg
	 */
	public String getLatestChangeReg() {
		return latestChangeReg;
	}
	
	/**
	 * @param latestChangeReg the latestChangeReg to set
	 */
	public void setLatestChangeReg(String latestChangeReg) {
		this.latestChangeReg = latestChangeReg;
	}
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the tecTotalWeight
	 */
	public String getTecTotalWeight() {
		return tecTotalWeight;
	}

	/**
	 * @param tecTotalWeight the tecTotalWeight to set
	 */
	public void setTecTotalWeight(String tecTotalWeight) {
		this.tecTotalWeight = tecTotalWeight;
	}

	/**
	 * @return the totalWeight
	 */
	public String getTotalWeight() {
		return totalWeight;
	}

	/**
	 * @param totalWeight the totalWeight to set
	 */
	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	/**
	 * @return the ownWeight
	 */
	public String getOwnWeight() {
		return ownWeight;
	}

	/**
	 * @param ownWeight the ownWeight to set
	 */
	public void setOwnWeight(String ownWeight) {
		this.ownWeight = ownWeight;
	}

	/**
	 * @return the couplingDevice
	 */
	public String getCouplingDevice() {
		return couplingDevice;
	}

	/**
	 * @param couplingDevice the couplingDevice to set
	 */
	public void setCouplingDevice(String couplingDevice) {
		this.couplingDevice = couplingDevice;
	}

	/**
	 * @return the weightOfTrailerWithBrakes
	 */
	public String getWeightOfTrailerWithBrakes() {
		return weightOfTrailerWithBrakes;
	}

	/**
	 * @param weightOfTrailerWithBrakes the weightOfTrailerWithBrakes to set
	 */
	public void setWeightOfTrailerWithBrakes(String weightOfTrailerWithBrakes) {
		this.weightOfTrailerWithBrakes = weightOfTrailerWithBrakes;
	}

	/**
	 * @return the weightOfTrailerWithoutBrakes
	 */
	public String getWeightOfTrailerWithoutBrakes() {
		return weightOfTrailerWithoutBrakes;
	}

	/**
	 * @param weightOfTrailerWithoutBrakes the weightOfTrailerWithoutBrakes to set
	 */
	public void setWeightOfTrailerWithoutBrakes(String weightOfTrailerWithoutBrakes) {
		this.weightOfTrailerWithoutBrakes = weightOfTrailerWithoutBrakes;
	}

	/**
	 * @return the propellant
	 */
	public String getPropellant() {
		return propellant;
	}

	/**
	 * @param propellant the propellant to set
	 */
	public void setPropellant(String propellant) {
		this.propellant = propellant;
	}

	/**
	 * @return the fuelConsumption
	 */
	public String getFuelConsumption() {
		return fuelConsumption;
	}

	/**
	 * @param fuelConsumption the fuelConsumption to set
	 */
	public void setFuelConsumption(String fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * @return the bodyType
	 */
	public String getBodyType() {
		return bodyType;
	}

	/**
	 * @param bodyType the bodyType to set
	 */
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	/**
	 * @return the numOfDoors
	 */
	public String getNumOfDoors() {
		return numOfDoors;
	}

	/**
	 * @param numOfDoors the numOfDoors to set
	 */
	public void setNumOfDoors(String numOfDoors) {
		this.numOfDoors = numOfDoors;
	}

	/**
	 * @return the posOfChassisNumber
	 */
	public String getPosOfChassisNumber() {
		return posOfChassisNumber;
	}

	/**
	 * @param posOfChassisNumber the posOfChassisNumber to set
	 */
	public void setPosOfChassisNumber(String posOfChassisNumber) {
		this.posOfChassisNumber = posOfChassisNumber;
	}
	
}
