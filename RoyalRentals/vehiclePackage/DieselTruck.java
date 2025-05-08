package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The DieselTruck class extends the Truck class and represents a diesel-powered truck.
 * It includes an additional attribute for fuel capacity and assigns a unique plate number.
 * 
 * @author Sara Boutine 40304116
 */
public class DieselTruck extends Truck{

	//Variable instance
	private double fuelCapacity;
	private static int nextPlateNumber = 1001;
	
	/**
     * Default constructor initializes a diesel truck with default values and assigns a unique plate number.
     */
	public DieselTruck()
	{
		super();
		this.plateNumber = "DT" + nextPlateNumber++;
		fuelCapacity = 0.0;
	}
	
	/**
     * Parameterized constructor initializes a diesel truck with specified values and assigns a unique plate number.
     * 
     * @param make         the make of the truck
     * @param model        the model of the truck
     * @param year         the manufacturing year of the truck
     * @param maxCapacity  the maximum cargo capacity of the truck
     * @param fuelCapacity the fuel capacity of the truck in liters
     */
	public DieselTruck(String make,String model, int year, double maxCapacity, double fuelCapacity)
	{
		super(make, model, year, maxCapacity);
		this.plateNumber = "DT" + nextPlateNumber++;//To auto-assign plate number
		this.fuelCapacity = fuelCapacity;
	}
	
	/**
     * Copy constructor creates a new diesel truck instance by copying values from another diesel truck.
     * 
     * @param other the diesel truck object to copy from.
     */
	public DieselTruck(DieselTruck other) 
	{
        super(other); 
        this.plateNumber = "DT" + nextPlateNumber++; 
        this.fuelCapacity = other.fuelCapacity;
    }
	
	
	//Getter: 
	
	/**
     * Gets the fuel capacity of the diesel truck.
     * 
     * @return the fuel capacity in liters
     */
	public double getFuelCapacity()
	{
		return fuelCapacity;
	}
	
	//Setter:
	
	/**
     * Sets the fuel capacity of the diesel truck.
     * 
     * @param fuelCapacity the fuel capacity in liters to set.
     */
	public void setFuelCapacity(double fuelCapacity)
	{
		this.fuelCapacity = fuelCapacity;
	}
	
    /**
     * Returns a string representation of the diesel truck, including its type and inherited attributes.
     * 
     * @return a formatted string containing diesel truck details.
     */
	@Override
	public String toString()
	{
		return  "\n-Type: Diesel truck\n" + super.toString() + "-Fuel tank capacity of: " + fuelCapacity + " L\n" ;
	}
	
	/**
     * Compares this diesel truck with another object for equality based on the parent class attributes
     * and the fuel capacity.
     * 
     * @param obj the object to compare
     * @return true if the objects are equal, otherwise false.
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (!super.equals(obj)) return false; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        DieselTruck dieselTruck = (DieselTruck) obj; 
        return fuelCapacity == dieselTruck.fuelCapacity;
    }
	
}
