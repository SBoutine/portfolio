package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine
//---------------------------------------------------------

/**
 * The Car class represents a type of vehicle with an additional
 * attribute for the maximum number of passengers.
 * 
 * @author Sara Boutine 40304116
 */
public class Car extends Vehicle{
	
	//Variable instance
	protected int maxPassenger;
	
	/**
     * Default constructor initializes a car with default values.
     */
	public Car()
	{
		super();
		this.maxPassenger = 0;
	}
	
	/**
     * Parameterized constructor initializes a car with specified values.
     * 
     * @param make         the make of the car
     * @param model        the model of the car
     * @param year         the manufacturing year of the car
     * @param maxPassenger the maximum number of passengers
     */
	public Car(String make, String model, int year, int maxPassenger) {
        super(make, model, year);
        this.maxPassenger = maxPassenger;
    }
	
	/**
     * Copy constructor creates a new car instance by copying values from another car.
     * 
     * @param other the car object to copy from.
     */
	public Car(Car other) 
	{
	    super(other);
	    this.maxPassenger = other.maxPassenger;
	}
	
	//Getter :
	
	/**
     * Gets the maximum number of passengers the car can take.
     * 
     * @return the maximum number of passengers.
     */
	public int getMaxPassenger()
	{
		return maxPassenger;
	}
	
	//Setter : 
	
	 /**
     * Sets the maximum number of passengers the car can accommodate.
     * 
     * @param maxPassenger the maximum number of passengers to set
     */
	public void setMaxPassenger(int maxPassenger)
	{
		this.maxPassenger = maxPassenger;
	}
	
	/**
     * Returns a string representation of the car, including vehicle details and maximum passengers.
     * 
     * @return a formatted string containing car details
     */
	public String toString()
	{
		return super.toString() + "-Maximum number of passengers: " + maxPassenger + " passenger(s)\n";
	}
	
	/**
     * Compares this car with another object for equality based on the parent class attributes
     * and the maximum number of passengers.
     * 
     * @param obj the object to compare
     * @return {@code true} if the objects are equal, otherwise {@code false}
     */
	 public boolean equals(Object obj) 
	 {
		 if (!super.equals(obj)) return false; 
	     if (obj == null || getClass() != obj.getClass()) return false; 
	     Car car = (Car) obj; 
	     return maxPassenger == car.maxPassenger; 
	    }
}
