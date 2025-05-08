package clientPackage;

/**
 * The Client class represents a client who leases vehicles.
 * It stores the client's name and phone number.
 *
 * @author Sara Boutine 
 */
public class Client {
	//Instance variables
	private String name;
	private String phoneNumber;
	
	/**
     * Default constructor initializes a client with default values.
     */
	public Client()
	{
		this.name = "Undefined";
		this.phoneNumber = "Undefined";
	}
	
	/**
     * Parameterized constructor initializes a client with specified values.
     * 
     * @param name         the name of the client
     * @param phoneNumber  the phone number of the client
     */
	public Client(String name, String phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	/**
     * Copy constructor creates a new client instance by copying values from another client.
     * 
     * @param other the client object to copy from
     */
	public Client(Client other)
	{
		this.name = other.name;
		this.phoneNumber = other.phoneNumber;
	}
	
	//Getters:
	
	/**
     * Gets the name of the client.
     * 
     * @return the name of the client
     */
	public String getName()
	{
		return name;
	}
	
	/**
     * Gets the phone number of the client.
     * 
     * @return the phone number of the client
     */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	//Setters:
	
	/**
     * Sets the name of the client.
     * 
     * @param name the name to set
     */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
     * Sets the phone number of the client.
     * 
     * @param phoneNumber the phone number to set
     */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
     * Returns a string representation of the client, including their name and phone number.
     * 
     * @return a formatted string containing client details.
     */
	public String toString()
	{
		return "Client's name: " + name +
				"\nPhone number: " + phoneNumber +"\n";
	}
	
	/**
     * Compares this client with another object for equality based on name and phone number.
     * 
     * @param obj the object to compare.
     * @return true if the objects are equal, otherwise false.
     */
	public boolean equals(Object obj) 
	{
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return name.equals(client.name) && phoneNumber.equals(client.phoneNumber); 
    }
}
