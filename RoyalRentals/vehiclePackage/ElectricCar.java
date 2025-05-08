package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The ElectricCar class extends the Car class and represents an electric car.
 * It includes an additional attribute for maximum autonomy range and assigns a unique plate number.
 * 
 * @author Sara Boutine 40304116
 */
public class ElectricCar extends Car{
	
	//Variable instance
	private double maxAutonomyRange;
    private static int nextPlateNumber = 1001;

    /**
     * Default constructor initializes an electric car with default values and assigns a unique plate number.
     */
	public ElectricCar()
	{
		super();
        this.plateNumber = "EC" + nextPlateNumber++;
        maxAutonomyRange = 0.0;
	}
	
	/**
     * Parameterized constructor initializes an electric car with specified values and assigns a unique plate number.
     * 
     * @param make             the make of the car
     * @param model            the model of the car
     * @param year             the manufacturing year of the car
     * @param maxPassenger     the maximum number of passengers
     * @param maxAutonomy      the maximum autonomy range in kilometers
     */
	public ElectricCar(String make,String model, int year, int maxPassenger, double maxAutonomy)
	{
		super(make, model, year, maxPassenger);
        this.plateNumber = "EC" + nextPlateNumber++;
		this.maxAutonomyRange = maxAutonomy;
	}
	
	/**
     * Copy constructor creates a new electric car instance by copying values from another electric car.
     * 
     * @param other the electric car object to copy from
     */
	public ElectricCar(ElectricCar other) 
	{
        super(other);  // Calls Car's copy constructor
        this.plateNumber = "EC" + nextPlateNumber++;  // Generates a new unique plate number
        this.maxAutonomyRange = other.maxAutonomyRange;
    }
	
	//Getter : 
	
	/**
     * Gets the maximum autonomy range of the electric car.
     * 
     * @return the maximum autonomy range in kilometers
     */
	public double getMaxAutonomyRange()
	{
		return maxAutonomyRange;
	}
	
	//Setter : 
	
	/**
     * Sets the maximum autonomy range of the electric car.
     * 
     * @param maxAutonomy the maximum autonomy range in kilometers to set
     */
	public void setMaxAutonomyRange(double maxAutonomy)
	{
		this.maxAutonomyRange = maxAutonomy;
	}
	
	/**
     * Returns a string representation of the electric car, including its type and inherited attributes.
     * 
     * @return a formatted string containing electric car details
     */
	@Override
	public String toString()
	{
		return "-Type: Electric car\n" + super.toString() + "-Maximum autonomy range: " + maxAutonomyRange + " km\n" ;
	}

	/**
     * Compares this electric car with another object for equality based on the parent class attributes
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
        ElectricCar elctricCar = (ElectricCar) obj; 
        return maxAutonomyRange == elctricCar.maxAutonomyRange; 
    }
}
