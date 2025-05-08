package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The Truck class represents a type of vehicle that is designed to transport heavy objects.
 * It extends the Vehicle class and introduces an additional attribute for maximum load capacity.
 
 * @author Sara Boutine 40304116
 */
public class Truck extends Vehicle{
	
	//Variable instance
	protected double maxCapacity;
	
	/**
     * Default constructor initializes a truck with default values.
     */
	public Truck()
	{
		super();
		maxCapacity = 0.0;
	}
	
	/**
     * Parameterized constructor initializes a truck with specified values.
     * 
     * @param make        the make of the truck
     * @param model       the model of the truck
     * @param year        the manufacturing year of the truck
     * @param maxCapacity the maximum capacity of the truck in kilograms
     */
	public Truck(String make, String model, int year, double maxCapacity) {
        super(make, model, year);
        this.maxCapacity = maxCapacity;
    }
	
	/**
     * Copy constructor creates a new truck instance by copying values from another truck.
     * 
     * @param other the truck object to copy from
     */
	public Truck(Truck other) 
	{
        super(other);  
        this.maxCapacity = other.maxCapacity;
	}
	
	//Getter : 
	
	/**
     * Gets the maximum capacity of the truck.
     * 
     * @return the maximum capacity in kilograms
     */
	public double getMaxCapacity()
	{
		return maxCapacity;
	}
	
	//Setter : 
	
	/**
     * Sets the maximum capacity of the truck.
     * 
     * @param maxCapacity the maximum capacity to set in kilograms
     */
	public void setMaxCapacity(double maxCapacity)
	{
		this.maxCapacity = maxCapacity;
	}
	
	/**
     * Returns a string representation of the truck, including vehicle details and maximum capacity.
     * 
     * @return a formatted string containing truck details
     */
	public String toString()
	{
		return super.toString() + "-Maximum number capacity: " + maxCapacity + " kg\n" ;
	}
	
	/**
     * Compares this truck with another object for equality based on the parent class attributes
     * and the maximum capacity.
     * 
     * @param obj the object to compare.
     * @return true if the objects are equal, otherwise false.
     */
	public boolean equals(Object obj) 
	{
        if (!super.equals(obj)) return false; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        Truck truck = (Truck) obj; 
        return maxCapacity == truck.maxCapacity; 
    }
}
