
package dk.is12b.org.model;

public class Inspection {

	private String date;
	private String status;
	private String type;
	
	public Inspection(String date, String status) {
		this.date = date;
		this.status = status;
		this.type = "";
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
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
}
