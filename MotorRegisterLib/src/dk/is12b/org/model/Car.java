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
}
