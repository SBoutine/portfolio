package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The ElectricTruck class extends the Truck class and represents an electric-powered truck.
 * It includes an additional attribute for maximum autonomy range and assigns a unique plate number.
 * 
 * @author Sara Boutine 40304116
 */
public class ElectricTruck extends Truck{
	
	//Variable instance
	private double maxAutonomy;
    private static int nextPlateNumber = 1001;
	
	
    /**
     * Default constructor initializes an electric truck with default values and assigns a unique plate number.
     */
	public ElectricTruck()
	{
		super();
        plateNumber = "ET" + nextPlateNumber++;
		maxAutonomy = 0.0;
	}
		
	 /**
     * Parameterized constructor initializes an electric truck with specified values and assigns a unique plate number.
     * 
     * @param make         the make of the truck
     * @param model        the model of the truck
     * @param year         the manufacturing year of the truck
     * @param maxCapacity  the maximum cargo capacity of the truck
     * @param maxAutonomy  the maximum autonomy range of the truck in kilometers
     */
	public ElectricTruck(String make,String model, int year,double maxCapacity, double maxAutonomy)
	{
		super(make, model, year, maxCapacity);
        this.plateNumber = "ET" + nextPlateNumber++;
		this.maxAutonomy = maxAutonomy;
	}
	
	 /**
     * Copy constructor creates a new electric truck instance by copying values from another electric truck.
     * 
     * @param other the electric truck object to copy from
     */
	public ElectricTruck(ElectricTruck other) {
        super(other); 
        this.plateNumber = "ET" + nextPlateNumber++; 
        this.maxAutonomy = other.maxAutonomy;
    }
			
	//Getter:
	
	/**
     * Gets the maximum autonomy range of the electric truck.
     * 
     * @return the maximum autonomy range in kilometers
     */
	public double getMaxAutonomy()
	{
		return maxAutonomy;
	}
		
	//Setter:
	/**
     * Sets the maximum autonomy range of the electric truck.
     * 
     * @param maxAutonomy the maximum autonomy range in kilometers to set
     */
	public void setMaxAutonomy(double maxAutonomy)
	{
		this.maxAutonomy = maxAutonomy;
	}
	
	/**
     * Returns a string representation of the electric truck, including its type and inherited attributes.
     * 
     * @return a formatted string containing electric truck details.
     */
	@Override
	public String toString()
	{
		return  "-Type: Electric truck\n" + super.toString() + "-Maximum autonomy range: " + maxAutonomy + " km\n" ;
	}
	
	/**
     * Compares this electric truck with another object for equality based on the parent class attributes
     * and the maximum autonomy range.
     * 
     * @param obj the object to compare
     * @return true if the objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false; 
        if (obj == null || getClass() != obj.getClass()) return false;
        ElectricTruck electrickTruck = (ElectricTruck) obj; 
        return maxAutonomy == electrickTruck.maxAutonomy; 
    }

}
