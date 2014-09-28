package dk.is12b.org.model;

public class Car {
	//Vehicle - Køretøj
	private String chassisNumber; // Stelnummer
	private String model; // Mærke, Model, Variant
	private String type; // Art
	private String latestChangeVehicle; // Seneste ændring
	private String efType; // EF-Type-godkendelsenr.
	private String breakDecleraionNum; // Typeanmeldelses­nummer/bremsedata-erklæringsnummer
	private String furtherUse; // Supplerende anvendelser
	
	//Registration - Registrerings­forhold
	private String regNumber; // Registrerings­nummer
	private String firstRegDate; // Første registrerings­dato
	private String use; // Anvendelse
	private String latestChangeReg; // Seneste ændring
	private String status; // Status
	private String regType; // Type
	private String euVariation; // EU-variant
	private String euVersion; // EU-version
	private String category; // Kategori
	private String manufacturer; // Fabrikant
	
	//Valuation - Anmodning om værdifastsættelse
	private String requestYear; // Anmodningsårsag
	private String valuationDescription; // Beskrivelse
	private String valuationMileage; // Kilometerstand
	private String valuationCondition; // Køretøjes stand
	
	//Identification - Identifikation 
	private String vehicleID; // KøretøjsID
	private String chassisNumSideVagon; // Stelnummer tilkoblet sidevogn
	private String color; // Farve
	private String modelYear; // Model-år
	private String firstIdDate; // 1. registreringsdato
	private String commissioningDate; // Ibrugtagningsdato
	private String ncapTest; // Bestået NCAP test med mindst 5 stjerner
	private String vanTax; // Varevogn 30 procent afgift
	private String fuelMode; // Fuelmode
	private String airSuspension; // Vejvenlig luftaf­fjedring
	
	//Stand - Stand
	private String mileageStand; // Kilometerstand
	private String mileageDocumentation; // Dokumentation for kilometerstand
	private String standComments; // Bemærkninger for stand
	private String vehicleStand; // Køretøj stand
	private String trafficInjury; // Trafikskade
	private String originalVeteran; // Original veterankøretøj
	
	//Electrical installations - El-anlæg
	private boolean zoneKlimate1or2; // 1- eller 2-zone klima
	private boolean zoneKlimate3or4; // 3- eller 4-zone klima
	private boolean distanceRadar; // Afstandsradar
	private boolean cruiseControl; // Aktiv fartpilot
	private int seatBeltWarning; // Antal selealarmer
	private boolean rearViewCam; // Bakkamera
	private boolean heatedWindscreen; // El-opvarmet forrude
	private boolean powerTailgate; // Elektrisk bagklap
	private boolean electricalClosingDoors; // Elektrisk lukning af døre
	private boolean headupDisplay; // Head-up display
	private boolean hifi; // HiFi musikanlæg
	private boolean keyLess; // Key-less go (nøglefri)
	private boolean lineGuardian; // Linievogter
	private boolean manualAircon; // Manuel Aircondition
	private boolean nightVision; // Natsyns-udstyr
	private boolean navigation; // Navigationssystem med skærm
	private boolean orgAlarm; // Original tyverialarm
	private boolean parkingAssistant; // Parkeringsassistent
	private boolean parkingControlRear; // Parkeringskontrol bag
	private boolean parkingControlFront; // Parkeringskontrol for
	private boolean solarCooling; // Solcellekøling, kabine
	private boolean voiceControl; // Stemmestyring
	private boolean laneSwitchAlarm; // Vognbaneskift-alarm
	
	//Body - Karrosseri 
	private boolean threeOrMoreSeatRows; // 3 el. flere sæderækker
	private boolean doubleCab; // Dobbeltkabine
	private boolean electricSunroof; // El-soltag
	private boolean glassRoof; // Glastag
	private boolean bendLighting; // Kurvelys
	private boolean rht; // Metalfoldetag
	private boolean metallic; // Metallak
	private boolean bodyRebuilt; // Ombygget karrosseri
	private boolean Targa; // Targa
	private boolean loadArea; // U. siderude i v. side af varerum
	private boolean xenon; // Xenon forlygter
	
	//Engine - Motor
	private boolean sixGearManual; // 6-gear manuel
	private boolean escStability; // ESC stabilitetskontrol
	private boolean compressor; // Kompressor
	private boolean engineHeater; // Motor/kabinevarmer
	private boolean engineNumber; // Motornummer
	private boolean differentEngine; // Tunet/anden motor
	
	//Breaks - Bremser
	private boolean abs; // ABS bremser
	private boolean ceramicDisc; // Keramiske skiver
	private boolean discBrakesRear; // Skivebremser bag
	private boolean discBrakesFront; // Skivebremser for
	
	//Bearing Elements - Bærende Elementer
	private boolean suspensionFrame; // Affjedret stel
	private boolean electronicDampers; // Elektroniske dæmpere
	private boolean airSuspensionBearing; // Luftaffjedring
	private boolean levelling; // Niveauregulering
	private boolean rebuiltFrame; // Ombygget stel
	private boolean rigidFrame; // Stift stel
	private boolean tiresGreaterThan20; // Større hjul end 20"
	
	//Equipment - Udstyr
	private int airbags; // Antal airbags
	private boolean radio; // Radio
	
	//Transmission - Transmission
	private boolean automaticGearing; // Automatgear
	private boolean allWheelDrive; // Firehjulstræk (4WD)
	private boolean steeringWheelGearShift; // Ratbetjent gear
	
	//Interior - Indretning
	private boolean partLeatherSeat; // Del-lædersæder
	private boolean blindsRearDoors; // El-gardiner i bagdøre
	private boolean blindsRearWindow; // El-gardiner i bagrude
	private boolean electricAdjustableSeatsBehind; // El-indstillelige sæder bag
	private boolean solidPanniers; // Faste sidetasker
	private int integratedChildSeat; // Integreret barnesæde
	private boolean leatherSeats; // Læder/skindsæder
	private boolean massageSeats; // Massagesæder
	private boolean memorySeatsFront; // Memory-sæder for
	private boolean sportComfortSeats; // Sport-/komfortsæder
	private boolean ventilatedSeats; // Ventilation i sæder
	
	//Steering - Styreapparat
	private boolean electricAdjustingSteeringWheel; // El-indstilleligt rat
	private boolean rightSteering; // Højrestyring
	private boolean longFork; // Lang forgaffel
	private boolean multifunctionSteeringWheel; // Multifunktionsrat
	private boolean heatedSteeringWheel; // Opvarmet rat/styr
	
	//Turbo - Turbo
	private boolean turbo; // Turbo
	
	//Other - Andet Udstyr
	private String other; // Andet udstyr
	
	//Blocking State - Blokeringstatus
	private String blocked; // Blokeringsstatus 
	
	//ID - Iteration
	private int id;
	private static int idIterator;
	
	
	
	public Car() {
		idIterator++;
		this.id = idIterator;
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
	 * @return the efType
	 */
	public String getEfType() {
		return efType;
	}
	
	/**
	 * @param efType the efType to set
	 */
	public void setEfType(String efType) {
		this.efType = efType;
	}
	
	/**
	 * @return the breakDecleraionNum
	 */
	public String getBreakDecleraionNum() {
		return breakDecleraionNum;
	}
	
	/**
	 * @param breakDecleraionNum the breakDecleraionNum to set
	 */
	public void setBreakDecleraionNum(String breakDecleraionNum) {
		this.breakDecleraionNum = breakDecleraionNum;
	}
	
	/**
	 * @return the furtherUse
	 */
	public String getFurtherUse() {
		return furtherUse;
	}
	
	/**
	 * @param furtherUse the furtherUse to set
	 */
	public void setFurtherUse(String furtherUse) {
		this.furtherUse = furtherUse;
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
	 * @return the regType
	 */
	public String getRegType() {
		return regType;
	}
	
	/**
	 * @param regType the regType to set
	 */
	public void setRegType(String regType) {
		this.regType = regType;
	}
	
	/**
	 * @return the euVariation
	 */
	public String getEuVariation() {
		return euVariation;
	}
	
	/**
	 * @param euVariation the euVariation to set
	 */
	public void setEuVariation(String euVariation) {
		this.euVariation = euVariation;
	}
	
	/**
	 * @return the euVersion
	 */
	public String getEuVersion() {
		return euVersion;
	}
	
	/**
	 * @param euVersion the euVersion to set
	 */
	public void setEuVersion(String euVersion) {
		this.euVersion = euVersion;
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	/**
	 * @return the requestYear
	 */
	public String getRequestYear() {
		return requestYear;
	}
	
	/**
	 * @param requestYear the requestYear to set
	 */
	public void setRequestYear(String requestYear) {
		this.requestYear = requestYear;
	}
	
	/**
	 * @return the valuationDescription
	 */
	public String getValuationDescription() {
		return valuationDescription;
	}
	
	/**
	 * @param valuationDescription the valuationDescription to set
	 */
	public void setValuationDescription(String valuationDescription) {
		this.valuationDescription = valuationDescription;
	}
	
	/**
	 * @return the valuationMileage
	 */
	public String getValuationMileage() {
		return valuationMileage;
	}
	
	/**
	 * @param valuationMileage the valuationMileage to set
	 */
	public void setValuationMileage(String valuationMileage) {
		this.valuationMileage = valuationMileage;
	}
	
	/**
	 * @return the valuationCondition
	 */
	public String getValuationCondition() {
		return valuationCondition;
	}
	
	/**
	 * @param valuationCondition the valuationCondition to set
	 */
	public void setValuationCondition(String valuationCondition) {
		this.valuationCondition = valuationCondition;
	}
	
	/**
	 * @return the vehicleID
	 */
	public String getVehicleID() {
		return vehicleID;
	}
	
	/**
	 * @param vehicleID the vehicleID to set
	 */
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	
	/**
	 * @return the chassisNumSideVagon
	 */
	public String getChassisNumSideVagon() {
		return chassisNumSideVagon;
	}
	
	/**
	 * @param chassisNumSideVagon the chassisNumSideVagon to set
	 */
	public void setChassisNumSideVagon(String chassisNumSideVagon) {
		this.chassisNumSideVagon = chassisNumSideVagon;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * @return the modelYear
	 */
	public String getModelYear() {
		return modelYear;
	}
	
	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	
	/**
	 * @return the firstIdDate
	 */
	public String getFirstIdDate() {
		return firstIdDate;
	}
	
	/**
	 * @param firstIdDate the firstIdDate to set
	 */
	public void setFirstIdDate(String firstIdDate) {
		this.firstIdDate = firstIdDate;
	}
	
	/**
	 * @return the commissioningDate
	 */
	public String getCommissioningDate() {
		return commissioningDate;
	}
	
	/**
	 * @param commissioningDate the commissioningDate to set
	 */
	public void setCommissioningDate(String commissioningDate) {
		this.commissioningDate = commissioningDate;
	}
	
	/**
	 * @return the ncapTest
	 */
	public String getNcapTest() {
		return ncapTest;
	}
	
	/**
	 * @param ncapTest the ncapTest to set
	 */
	public void setNcapTest(String ncapTest) {
		this.ncapTest = ncapTest;
	}
	
	/**
	 * @return the vanTax
	 */
	public String getVanTax() {
		return vanTax;
	}
	
	/**
	 * @param vanTax the vanTax to set
	 */
	public void setVanTax(String vanTax) {
		this.vanTax = vanTax;
	}
	
	/**
	 * @return the fuelMode
	 */
	public String getFuelMode() {
		return fuelMode;
	}
	
	/**
	 * @param fuelMode the fuelMode to set
	 */
	public void setFuelMode(String fuelMode) {
		this.fuelMode = fuelMode;
	}
	
	/**
	 * @return the airSuspension
	 */
	public String getAirSuspension() {
		return airSuspension;
	}
	
	/**
	 * @param airSuspension the airSuspension to set
	 */
	public void setAirSuspension(String airSuspension) {
		this.airSuspension = airSuspension;
	}
	
	/**
	 * @return the mileageStand
	 */
	public String getMileageStand() {
		return mileageStand;
	}
	
	/**
	 * @param mileageStand the mileageStand to set
	 */
	public void setMileageStand(String mileageStand) {
		this.mileageStand = mileageStand;
	}
	
	/**
	 * @return the mileageDocumentation
	 */
	public String getMileageDocumentation() {
		return mileageDocumentation;
	}
	
	/**
	 * @param mileageDocumentation the mileageDocumentation to set
	 */
	public void setMileageDocumentation(String mileageDocumentation) {
		this.mileageDocumentation = mileageDocumentation;
	}
	
	/**
	 * @return the standComments
	 */
	public String getStandComments() {
		return standComments;
	}
	
	/**
	 * @param standComments the standComments to set
	 */
	public void setStandComments(String standComments) {
		this.standComments = standComments;
	}
	
	/**
	 * @return the vehicleStand
	 */
	public String getVehicleStand() {
		return vehicleStand;
	}
	
	/**
	 * @param vehicleStand the vehicleStand to set
	 */
	public void setVehicleStand(String vehicleStand) {
		this.vehicleStand = vehicleStand;
	}
	
	/**
	 * @return the trafficInjury
	 */
	public String getTrafficInjury() {
		return trafficInjury;
	}
	
	/**
	 * @param trafficInjury the trafficInjury to set
	 */
	public void setTrafficInjury(String trafficInjury) {
		this.trafficInjury = trafficInjury;
	}
	
	/**
	 * @return the originalVeteran
	 */
	public String getOriginalVeteran() {
		return originalVeteran;
	}
	
	/**
	 * @param originalVeteran the originalVeteran to set
	 */
	public void setOriginalVeteran(String originalVeteran) {
		this.originalVeteran = originalVeteran;
	}
	
	/**
	 * @return the zoneKlimate1or2
	 */
	public boolean isZoneKlimate1or2() {
		return zoneKlimate1or2;
	}
	
	/**
	 * @param zoneKlimate1or2 the zoneKlimate1or2 to set
	 */
	public void setZoneKlimate1or2(boolean zoneKlimate1or2) {
		this.zoneKlimate1or2 = zoneKlimate1or2;
	}
	
	/**
	 * @return the zoneKlimate3or4
	 */
	public boolean isZoneKlimate3or4() {
		return zoneKlimate3or4;
	}
	
	/**
	 * @param zoneKlimate3or4 the zoneKlimate3or4 to set
	 */
	public void setZoneKlimate3or4(boolean zoneKlimate3or4) {
		this.zoneKlimate3or4 = zoneKlimate3or4;
	}
	
	/**
	 * @return the distanceRadar
	 */
	public boolean isDistanceRadar() {
		return distanceRadar;
	}
	
	/**
	 * @param distanceRadar the distanceRadar to set
	 */
	public void setDistanceRadar(boolean distanceRadar) {
		this.distanceRadar = distanceRadar;
	}
	
	/**
	 * @return the cruiseControl
	 */
	public boolean getCruiseControl() {
		return cruiseControl;
	}
	
	/**
	 * @param cruiseControl the cruiseControl to set
	 */
	public void setCruiseControl(boolean cruiseControl) {
		this.cruiseControl = cruiseControl;
	}
	
	/**
	 * @return the seatBeltWarning
	 */
	public int isSeatBeltWarning() {
		return seatBeltWarning;
	}
	
	/**
	 * @param seatBeltWarning the seatBeltWarning to set
	 */
	public void setSeatBeltWarning(int seatBeltWarning) {
		this.seatBeltWarning = seatBeltWarning;
	}
	
	/**
	 * @return the rearViewCam
	 */
	public boolean isRearViewCam() {
		return rearViewCam;
	}
	
	/**
	 * @param rearViewCam the rearViewCam to set
	 */
	public void setRearViewCam(boolean rearViewCam) {
		this.rearViewCam = rearViewCam;
	}
	
	/**
	 * @return the heatedWindscreen
	 */
	public boolean isHeatedWindscreen() {
		return heatedWindscreen;
	}
	
	/**
	 * @param heatedWindscreen the heatedWindscreen to set
	 */
	public void setHeatedWindscreen(boolean heatedWindscreen) {
		this.heatedWindscreen = heatedWindscreen;
	}
	
	/**
	 * @return the powerTailgate
	 */
	public boolean isPowerTailgate() {
		return powerTailgate;
	}
	
	/**
	 * @param powerTailgate the powerTailgate to set
	 */
	public void setPowerTailgate(boolean powerTailgate) {
		this.powerTailgate = powerTailgate;
	}
	
	/**
	 * @return the electricalClosingDoors
	 */
	public boolean isElectricalClosingDoors() {
		return electricalClosingDoors;
	}
	
	/**
	 * @param electricalClosingDoors the electricalClosingDoors to set
	 */
	public void setElectricalClosingDoors(boolean electricalClosingDoors) {
		this.electricalClosingDoors = electricalClosingDoors;
	}
	
	/**
	 * @return the headupDisplay
	 */
	public boolean isHeadupDisplay() {
		return headupDisplay;
	}
	
	/**
	 * @param headupDisplay the headupDisplay to set
	 */
	public void setHeadupDisplay(boolean headupDisplay) {
		this.headupDisplay = headupDisplay;
	}
	
	/**
	 * @return the hifi
	 */
	public boolean isHifi() {
		return hifi;
	}
	
	/**
	 * @param hifi the hifi to set
	 */
	public void setHifi(boolean hifi) {
		this.hifi = hifi;
	}
	
	/**
	 * @return the keyLess
	 */
	public boolean isKeyLess() {
		return keyLess;
	}
	
	/**
	 * @param keyLess the keyLess to set
	 */
	public void setKeyLess(boolean keyLess) {
		this.keyLess = keyLess;
	}
	
	/**
	 * @return the lineGuardian
	 */
	public boolean isLineGuardian() {
		return lineGuardian;
	}
	
	/**
	 * @param lineGuardian the lineGuardian to set
	 */
	public void setLineGuardian(boolean lineGuardian) {
		this.lineGuardian = lineGuardian;
	}
	
	/**
	 * @return the manualAircon
	 */
	public boolean isManualAircon() {
		return manualAircon;
	}
	
	/**
	 * @param manualAircon the manualAircon to set
	 */
	public void setManualAircon(boolean manualAircon) {
		this.manualAircon = manualAircon;
	}
	
	/**
	 * @return the nightVision
	 */
	public boolean isNightVision() {
		return nightVision;
	}
	
	/**
	 * @param nightVision the nightVision to set
	 */
	public void setNightVision(boolean nightVision) {
		this.nightVision = nightVision;
	}
	
	/**
	 * @return the navigation
	 */
	public boolean isNavigation() {
		return navigation;
	}
	
	/**
	 * @param navigation the navigation to set
	 */
	public void setNavigation(boolean navigation) {
		this.navigation = navigation;
	}
	
	/**
	 * @return the orgAlarm
	 */
	public boolean isOrgAlarm() {
		return orgAlarm;
	}
	
	/**
	 * @param orgAlarm the orgAlarm to set
	 */
	public void setOrgAlarm(boolean orgAlarm) {
		this.orgAlarm = orgAlarm;
	}
	
	/**
	 * @return the parkingAssistant
	 */
	public boolean isParkingAssistant() {
		return parkingAssistant;
	}
	
	/**
	 * @param parkingAssistant the parkingAssistant to set
	 */
	public void setParkingAssistant(boolean parkingAssistant) {
		this.parkingAssistant = parkingAssistant;
	}
	
	/**
	 * @return the parkingControlRear
	 */
	public boolean isParkingControlRear() {
		return parkingControlRear;
	}
	
	/**
	 * @param parkingControlRear the parkingControlRear to set
	 */
	public void setParkingControlRear(boolean parkingControlRear) {
		this.parkingControlRear = parkingControlRear;
	}
	
	/**
	 * @return the parkingControlFront
	 */
	public boolean isParkingControlFront() {
		return parkingControlFront;
	}
	
	/**
	 * @param parkingControlFront the parkingControlFront to set
	 */
	public void setParkingControlFront(boolean parkingControlFront) {
		this.parkingControlFront = parkingControlFront;
	}
	
	/**
	 * @return the solarCooling
	 */
	public boolean isSolarCooling() {
		return solarCooling;
	}
	
	/**
	 * @param solarCooling the solarCooling to set
	 */
	public void setSolarCooling(boolean solarCooling) {
		this.solarCooling = solarCooling;
	}
	
	/**
	 * @return the voiceControl
	 */
	public boolean isVoiceControl() {
		return voiceControl;
	}
	
	/**
	 * @param voiceControl the voiceControl to set
	 */
	public void setVoiceControl(boolean voiceControl) {
		this.voiceControl = voiceControl;
	}
	
	/**
	 * @return the laneSwitchAlarm
	 */
	public boolean isLaneSwitchAlarm() {
		return laneSwitchAlarm;
	}
	
	/**
	 * @param laneSwitchAlarm the laneSwitchAlarm to set
	 */
	public void setLaneSwitchAlarm(boolean laneSwitchAlarm) {
		this.laneSwitchAlarm = laneSwitchAlarm;
	}
	
	/**
	 * @return the threeOrMoreSeatRows
	 */
	public boolean isThreeOrMoreSeatRows() {
		return threeOrMoreSeatRows;
	}
	
	/**
	 * @param threeOrMoreSeatRows the threeOrMoreSeatRows to set
	 */
	public void setThreeOrMoreSeatRows(boolean threeOrMoreSeatRows) {
		this.threeOrMoreSeatRows = threeOrMoreSeatRows;
	}
	
	/**
	 * @return the doubleCab
	 */
	public boolean isDoubleCab() {
		return doubleCab;
	}
	
	/**
	 * @param doubleCab the doubleCab to set
	 */
	public void setDoubleCab(boolean doubleCab) {
		this.doubleCab = doubleCab;
	}
	
	/**
	 * @return the electricSunroof
	 */
	public boolean isElectricSunroof() {
		return electricSunroof;
	}
	
	/**
	 * @param electricSunroof the electricSunroof to set
	 */
	public void setElectricSunroof(boolean electricSunroof) {
		this.electricSunroof = electricSunroof;
	}
	
	/**
	 * @return the glassRoof
	 */
	public boolean isGlassRoof() {
		return glassRoof;
	}
	
	/**
	 * @param glassRoof the glassRoof to set
	 */
	public void setGlassRoof(boolean glassRoof) {
		this.glassRoof = glassRoof;
	}
	
	/**
	 * @return the bendLighting
	 */
	public boolean isBendLighting() {
		return bendLighting;
	}
	
	/**
	 * @param bendLighting the bendLighting to set
	 */
	public void setBendLighting(boolean bendLighting) {
		this.bendLighting = bendLighting;
	}
	
	/**
	 * @return the rht
	 */
	public boolean isRht() {
		return rht;
	}
	
	/**
	 * @param rht the rht to set
	 */
	public void setRht(boolean rht) {
		this.rht = rht;
	}
	
	/**
	 * @return the metallic
	 */
	public boolean isMetallic() {
		return metallic;
	}
	
	/**
	 * @param metallic the metallic to set
	 */
	public void setMetallic(boolean metallic) {
		this.metallic = metallic;
	}
	
	/**
	 * @return the bodyRebuilt
	 */
	public boolean isBodyRebuilt() {
		return bodyRebuilt;
	}
	
	/**
	 * @param bodyRebuilt the bodyRebuilt to set
	 */
	public void setBodyRebuilt(boolean bodyRebuilt) {
		this.bodyRebuilt = bodyRebuilt;
	}
	
	/**
	 * @return the targa
	 */
	public boolean isTarga() {
		return Targa;
	}
	
	/**
	 * @param targa the targa to set
	 */
	public void setTarga(boolean targa) {
		Targa = targa;
	}
	
	/**
	 * @return the loadArea
	 */
	public boolean isLoadArea() {
		return loadArea;
	}
	
	/**
	 * @param loadArea the loadArea to set
	 */
	public void setLoadArea(boolean loadArea) {
		this.loadArea = loadArea;
	}
	
	/**
	 * @return the xenon
	 */
	public boolean isXenon() {
		return xenon;
	}
	
	/**
	 * @param xenon the xenon to set
	 */
	public void setXenon(boolean xenon) {
		this.xenon = xenon;
	}
	
	/**
	 * @return the sixGearManual
	 */
	public boolean isSixGearManual() {
		return sixGearManual;
	}
	
	/**
	 * @param sixGearManual the sixGearManual to set
	 */
	public void setSixGearManual(boolean sixGearManual) {
		this.sixGearManual = sixGearManual;
	}
	
	/**
	 * @return the escStability
	 */
	public boolean isEscStability() {
		return escStability;
	}
	
	/**
	 * @param escStability the escStability to set
	 */
	public void setEscStability(boolean escStability) {
		this.escStability = escStability;
	}
	
	/**
	 * @return the compressor
	 */
	public boolean isCompressor() {
		return compressor;
	}
	
	/**
	 * @param compressor the compressor to set
	 */
	public void setCompressor(boolean compressor) {
		this.compressor = compressor;
	}
	
	/**
	 * @return the engineHeater
	 */
	public boolean isEngineHeater() {
		return engineHeater;
	}
	
	/**
	 * @param engineHeater the engineHeater to set
	 */
	public void setEngineHeater(boolean engineHeater) {
		this.engineHeater = engineHeater;
	}
	
	/**
	 * @return the engineNumber
	 */
	public boolean isEngineNumber() {
		return engineNumber;
	}
	
	/**
	 * @param engineNumber the engineNumber to set
	 */
	public void setEngineNumber(boolean engineNumber) {
		this.engineNumber = engineNumber;
	}
	
	/**
	 * @return the differentEngine
	 */
	public boolean isDifferentEngine() {
		return differentEngine;
	}
	
	/**
	 * @param differentEngine the differentEngine to set
	 */
	public void setDifferentEngine(boolean differentEngine) {
		this.differentEngine = differentEngine;
	}
	
	/**
	 * @return the abs
	 */
	public boolean isAbs() {
		return abs;
	}
	
	/**
	 * @param abs the abs to set
	 */
	public void setAbs(boolean abs) {
		this.abs = abs;
	}
	
	/**
	 * @return the ceramicDisc
	 */
	public boolean isCeramicDisc() {
		return ceramicDisc;
	}
	
	/**
	 * @param ceramicDisc the ceramicDisc to set
	 */
	public void setCeramicDisc(boolean ceramicDisc) {
		this.ceramicDisc = ceramicDisc;
	}
	
	/**
	 * @return the discBrakesRear
	 */
	public boolean isDiscBrakesRear() {
		return discBrakesRear;
	}
	
	/**
	 * @param discBrakesRear the discBrakesRear to set
	 */
	public void setDiscBrakesRear(boolean discBrakesRear) {
		this.discBrakesRear = discBrakesRear;
	}
	
	/**
	 * @return the discBrakesFront
	 */
	public boolean isDiscBrakesFront() {
		return discBrakesFront;
	}
	
	/**
	 * @param discBrakesFront the discBrakesFront to set
	 */
	public void setDiscBrakesFront(boolean discBrakesFront) {
		this.discBrakesFront = discBrakesFront;
	}
	
	/**
	 * @return the suspensionFrame
	 */
	public boolean isSuspensionFrame() {
		return suspensionFrame;
	}
	
	/**
	 * @param suspensionFrame the suspensionFrame to set
	 */
	public void setSuspensionFrame(boolean suspensionFrame) {
		this.suspensionFrame = suspensionFrame;
	}
	
	/**
	 * @return the electronicDamers
	 */
	public boolean isElectronicDampers() {
		return electronicDampers;
	}
	
	/**
	 * @param electronicDamers the electronicDamers to set
	 */
	public void setElectronicDampers(boolean electronicDampers) {
		this.electronicDampers = electronicDampers;
	}
	
	/**
	 * @return the airSuspensionBearing
	 */
	public boolean isAirSuspensionBearing() {
		return airSuspensionBearing;
	}
	
	/**
	 * @param airSuspensionBearing the airSuspensionBearing to set
	 */
	public void setAirSuspensionBearing(boolean airSuspensionBearing) {
		this.airSuspensionBearing = airSuspensionBearing;
	}
	
	/**
	 * @return the levelling
	 */
	public boolean isLevelling() {
		return levelling;
	}
	
	/**
	 * @param levelling the levelling to set
	 */
	public void setLevelling(boolean levelling) {
		this.levelling = levelling;
	}
	
	/**
	 * @return the rebuiltFrame
	 */
	public boolean isRebuiltFrame() {
		return rebuiltFrame;
	}
	
	/**
	 * @param rebuiltFrame the rebuiltFrame to set
	 */
	public void setRebuiltFrame(boolean rebuiltFrame) {
		this.rebuiltFrame = rebuiltFrame;
	}
	
	/**
	 * @return the rigidFrame
	 */
	public boolean isRigidFrame() {
		return rigidFrame;
	}
	
	/**
	 * @param rigidFrame the rigidFrame to set
	 */
	public void setRigidFrame(boolean rigidFrame) {
		this.rigidFrame = rigidFrame;
	}
	
	/**
	 * @return the tiresGreaterThan20
	 */
	public boolean isTiresGreaterThan20() {
		return tiresGreaterThan20;
	}
	
	/**
	 * @param tiresGreaterThan20 the tiresGreaterThan20 to set
	 */
	public void setTiresGreaterThan20(boolean tiresGreaterThan20) {
		this.tiresGreaterThan20 = tiresGreaterThan20;
	}
	
	/**
	 * @return the airbags
	 */
	public int getAirbags() {
		return airbags;
	}
	
	/**
	 * @param airbags the airbags to set
	 */
	public void setAirbags(int airbags) {
		this.airbags = airbags;
	}
	
	/**
	 * @return the radio
	 */
	public boolean isRadio() {
		return radio;
	}
	
	/**
	 * @param radio the radio to set
	 */
	public void setRadio(boolean radio) {
		this.radio = radio;
	}
	
	/**
	 * @return the automaticGearing
	 */
	public boolean isAutomaticGearing() {
		return automaticGearing;
	}
	
	/**
	 * @param automaticGearing the automaticGearing to set
	 */
	public void setAutomaticGearing(boolean automaticGearing) {
		this.automaticGearing = automaticGearing;
	}
	
	/**
	 * @return the allWheelDrive
	 */
	public boolean isAllWheelDrive() {
		return allWheelDrive;
	}
	
	/**
	 * @param allWheelDrive the allWheelDrive to set
	 */
	public void setAllWheelDrive(boolean allWheelDrive) {
		this.allWheelDrive = allWheelDrive;
	}
	
	/**
	 * @return the steeringWheelGearShift
	 */
	public boolean isSteeringWheelGearShift() {
		return steeringWheelGearShift;
	}
	
	/**
	 * @param steeringWheelGearShift the steeringWheelGearShift to set
	 */
	public void setSteeringWheelGearShift(boolean steeringWheelGearShift) {
		this.steeringWheelGearShift = steeringWheelGearShift;
	}
	
	/**
	 * @return the partLeatherSeat
	 */
	public boolean isPartLeatherSeat() {
		return partLeatherSeat;
	}
	
	/**
	 * @param partLeatherSeat the partLeatherSeat to set
	 */
	public void setPartLeatherSeat(boolean partLeatherSeat) {
		this.partLeatherSeat = partLeatherSeat;
	}
	
	/**
	 * @return the blindsRearDoors
	 */
	public boolean isBlindsRearDoors() {
		return blindsRearDoors;
	}
	
	/**
	 * @param blindsRearDoors the blindsRearDoors to set
	 */
	public void setBlindsRearDoors(boolean blindsRearDoors) {
		this.blindsRearDoors = blindsRearDoors;
	}
	
	/**
	 * @return the blindsRearWindow
	 */
	public boolean isBlindsRearWindow() {
		return blindsRearWindow;
	}
	
	/**
	 * @param blindsRearWindow the blindsRearWindow to set
	 */
	public void setBlindsRearWindow(boolean blindsRearWindow) {
		this.blindsRearWindow = blindsRearWindow;
	}
	
	/**
	 * @return the electricAdjustableSeatsBehind
	 */
	public boolean isElectricAdjustableSeatsBehind() {
		return electricAdjustableSeatsBehind;
	}
	
	/**
	 * @param electricAdjustableSeatsBehind the electricAdjustableSeatsBehind to set
	 */
	public void setElectricAdjustableSeatsBehind(boolean electricAdjustableSeatsBehind) {
		this.electricAdjustableSeatsBehind = electricAdjustableSeatsBehind;
	}
	
	/**
	 * @return the solidPanniers
	 */
	public boolean isSolidPanniers() {
		return solidPanniers;
	}
	
	/**
	 * @param solidPanniers the solidPanniers to set
	 */
	public void setSolidPanniers(boolean solidPanniers) {
		this.solidPanniers = solidPanniers;
	}
	
	/**
	 * @return the integratedChildSeat
	 */
	public int getIntegratedChildSeat() {
		return integratedChildSeat;
	}
	
	/**
	 * @param integratedChildSeat the integratedChildSeat to set
	 */
	public void setIntegratedChildSeat(int integratedChildSeat) {
		this.integratedChildSeat = integratedChildSeat;
	}
	
	/**
	 * @return the leatherSeats
	 */
	public boolean isLeatherSeats() {
		return leatherSeats;
	}
	
	/**
	 * @param leatherSeats the leatherSeats to set
	 */
	public void setLeatherSeats(boolean leatherSeats) {
		this.leatherSeats = leatherSeats;
	}
	
	/**
	 * @return the massageSeats
	 */
	public boolean isMassageSeats() {
		return massageSeats;
	}
	
	/**
	 * @param massageSeats the massageSeats to set
	 */
	public void setMassageSeats(boolean massageSeats) {
		this.massageSeats = massageSeats;
	}
	
	/**
	 * @return the memorySeatsFront
	 */
	public boolean isMemorySeatsFront() {
		return memorySeatsFront;
	}
	
	/**
	 * @param memorySeatsFront the memorySeatsFront to set
	 */
	public void setMemorySeatsFront(boolean memorySeatsFront) {
		this.memorySeatsFront = memorySeatsFront;
	}
	
	/**
	 * @return the sportComfortSeats
	 */
	public boolean isSportComfortSeats() {
		return sportComfortSeats;
	}
	
	/**
	 * @param sportComfortSeats the sportComfortSeats to set
	 */
	public void setSportComfortSeats(boolean sportComfortSeats) {
		this.sportComfortSeats = sportComfortSeats;
	}
	
	/**
	 * @return the ventilatedSeats
	 */
	public boolean isVentilatedSeats() {
		return ventilatedSeats;
	}
	
	/**
	 * @param ventilatedSeats the ventilatedSeats to set
	 */
	public void setVentilatedSeats(boolean ventilatedSeats) {
		this.ventilatedSeats = ventilatedSeats;
	}
	
	/**
	 * @return the electricAdjustingSteeringWheel
	 */
	public boolean isElectricAdjustingSteeringWheel() {
		return electricAdjustingSteeringWheel;
	}
	
	/**
	 * @param electricAdjustingSteeringWheel the electricAdjustingSteeringWheel to set
	 */
	public void setElectricAdjustingSteeringWheel(boolean electricAdjustingSteeringWheel) {
		this.electricAdjustingSteeringWheel = electricAdjustingSteeringWheel;
	}
	
	/**
	 * @return the rightSteering
	 */
	public boolean isRightSteering() {
		return rightSteering;
	}
	
	/**
	 * @param rightSteering the rightSteering to set
	 */
	public void setRightSteering(boolean rightSteering) {
		this.rightSteering = rightSteering;
	}
	
	/**
	 * @return the longFork
	 */
	public boolean isLongFork() {
		return longFork;
	}
	
	/**
	 * @param longFork the longFork to set
	 */
	public void setLongFork(boolean longFork) {
		this.longFork = longFork;
	}
	
	/**
	 * @return the multifunctionSteeringWheel
	 */
	public boolean isMultifunctionSteeringWheel() {
		return multifunctionSteeringWheel;
	}
	
	/**
	 * @param multifunctionSteeringWheel the multifunctionSteeringWheel to set
	 */
	public void setMultifunctionSteeringWheel(boolean multifunctionSteeringWheel) {
		this.multifunctionSteeringWheel = multifunctionSteeringWheel;
	}
	
	/**
	 * @return the heatedSteeringWheel
	 */
	public boolean isHeatedSteeringWheel() {
		return heatedSteeringWheel;
	}
	
	/**
	 * @param heatedSteeringWheel the heatedSteeringWheel to set
	 */
	public void setHeatedSteeringWheel(boolean heatedSteeringWheel) {
		this.heatedSteeringWheel = heatedSteeringWheel;
	}
	
	/**
	 * @return the turbo
	 */
	public boolean isTurbo() {
		return turbo;
	}
	
	/**
	 * @param turbo the turbo to set
	 */
	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}
	
	/**
	 * @return the other
	 */
	public String getOther() {
		return other;
	}
	
	/**
	 * @param other the other to set
	 */
	public void setOther(String other) {
		this.other = other;
	}
	
	/**
	 * @return the blocked
	 */
	public String isBlocked() {
		return blocked;
	}
	
	/**
	 * @param blocked the blocked to set
	 */
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	
}
