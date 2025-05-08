package vehiclePackage;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The GasolineCar class extends the Car class and represents a car that runs on gasoline.
 * It automatically assigns a unique plate number to each instance.
 * 
 * @author Sara Boutine 40304116
 */
public class GasolineCar extends Car {
	//Instance variables
	private static int nextPlateNumber = 1001;
	
	/**
     * Default constructor initializes a gasoline car with default values and assigns a unique plate number.
     */
	public GasolineCar()
	{
		super();
		this.plateNumber = "GC" + nextPlateNumber++;
	}
	
	/**
     * Parameterized constructor initializes a gasoline car with specified values and assigns a unique plate number.
     * 
     * @param make         the make of the car
     * @param model        the model of the car
     * @param year         the manufacturing year of the car
     * @param maxPassenger the maximum number of passengers
     */
	public GasolineCar(String make, String model, int year, int maxPassenger)
	{
		super(make, model, year, maxPassenger);
		this.plateNumber = "GC" + nextPlateNumber++;
	}
	
	/**
     * Copy constructor creates a new gasoline car instance by copying values from another gasoline car.
     * 
     * @param other the gasoline car object to copy from.
     */
	public GasolineCar(GasolineCar other) 
	{
        super(other);  
        this.plateNumber = "GC" + nextPlateNumber++;  
    }
	
	/**
     * Returns a string representation of the gasoline car, including its type and inherited attributes.
     * 
     * @return a formatted string containing gasoline car details.
     */
	@Override
	public String toString() 
	{
        return  "-Type: Gasoline car\n" + super.toString();
    }
	
	/**
     * Compares this gasoline car with another object for equality based on the parent class attributes.
     * 
     * @param obj the object to compare.
     * @return true if the objects are equal, otherwise false.
     */
	@Override
	public boolean equals(Object obj) 
	{
        if (!super.equals(obj)) return false; 
        if (obj == null || getClass() != obj.getClass()) return false; 
        GasolineCar gasolineCar = (GasolineCar) obj; 
        return maxPassenger == gasolineCar.maxPassenger; 
    }
}
