package vehiclePackage;
import clientPackage.Client;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The Vehicle class represents an abstract vehicle with attributes such as
 * plate number, make, model, and year. It also maintains lease information.
 * 
 * @author Sara Boutine 40304116
 */
public abstract class Vehicle {
	
	//Instance variables
	protected String plateNumber;
	protected String make;
	protected String model;
	protected int year;
	
	// Lease details of the vehicle. 	
	private Lease lease;
	
	/**
     * Default constructor initializes a vehicle with default values.
     */
	public Vehicle()
	{
		this.plateNumber = "000000";
		this.make = "Undefined";
		this.model = "Undefined";
		this.year = 0;
		this.lease = new Lease();
	}
	
	/**
     * Parameterized constructor initializes a vehicle with specified values.
     * 
     * @param make  the make of the vehicle
     * @param model the model of the vehicle
     * @param year  the manufacturing year of the vehicle
     */
	public Vehicle(String make,String model, int year)
	{
		this.make = make;
		this.model = model;
		this.year = year;
		this.lease = new Lease();
	}
	
	/**
     * Copy constructor creates a new vehicle instance by copying values from another vehicle.
     * 
     * @param other the vehicle object to copy from
     */
	public Vehicle(Vehicle other) 
	{
	    this.make = other.make;
	    this.model = other.model;
	    this.year = other.year;
	    this.lease = new Lease(other.lease);
	}
	
	
	//Getters : 
	
	/**
     * Gets the plate number of the vehicle.
     * 
     * @return the plate number
     */
	public String getPlateNumber()
	{
		return plateNumber;
	}
	
	/**
     * Gets the make of the vehicle.
     * 
     * @return the make of the vehicle
     */
	public String getMake()
	{
		return make;
	}
	

    /**
     * Gets the model of the vehicle.
     * 
     * @return the model of the vehicle
     */
	public String getModel()
	{
		return model;
	}
	
	 
    /**
     * Gets the manufacturing year of the vehicle.
     * 
     * @return the year of the vehicle
     */
	public int getYear()
	{
		return year;
	}
	
	/**
     * Checks if the vehicle is currently leased.
     * 
     * @return true if the vehicle is leased, otherwise false
     */
	public boolean isLeased() {
        return lease.isLeased();
    }

	/**
     * Gets the client who has leased the vehicle.
     * 
     * @return the client who leased the vehicle
     */
    public Client getLeasedBy() {
        return lease.getLeasedBy();
    }

	//Setters : 

    /**
     * Sets the plate number of the vehicle.
     * 
     * @param plateNumber the plate number to set
     */
	public void setPlateNumber(String plateNumber)
	{
		this.plateNumber = plateNumber;
	}
	
	 
    /**
     * Sets the make of the vehicle.
     * 
     * @param make the make to set
     */
	public void setMake(String make)
	{
		this.make = make;
	}
	
	  /**
     * Sets the model of the vehicle.
     * 
     * @param model the model to set
     */
	public void setModel(String model)
	{
		this.model = model;
	}
	
	/**
     * Sets the manufacturing year of the vehicle.
     * 
     * @param year the year to set
     */
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**
     * Sets the lease status of the vehicle.
     * 
     * @param leased true if leased, otherwise false
     */
	public void setLeased(boolean leased)
	{
		lease.setLeased(leased);
	}
	
	/**
     * Sets the client who has leased the vehicle.
     * 
     * @param leasedBy the client leasing the vehicle
     */
	public void setLeasedBy(Client leasedBy)
	{
		lease.setLeasedBy(leasedBy);
	}
	
	
	/**
     * Returns a string representation of the vehicle.
     * 
     * @return a formatted string containing vehicle details.
     */
		public String toString()
		{
			return "-Plate Number: " + plateNumber +
					"\n-Make: " + make + 
					"\n-Model: " + model + 
					"\n-Year: " + year + "\n";
		}
		
	 /**
	    * Compares this vehicle with another object for equality based on make, model, and year.
	    * 
	    * @param obj the object to compare
	    * @return true if the objects are equal, otherwise false
	    */
	    public boolean equals(Object obj) 
	    {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Vehicle vehicle = (Vehicle) obj;
	        return year == vehicle.year && make.equals(vehicle.make) && model.equals(vehicle.model);
		}
}
