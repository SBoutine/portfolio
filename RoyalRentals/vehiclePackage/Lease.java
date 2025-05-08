package vehiclePackage;
import clientPackage.Client;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/**
 * The Lease class represents a vehicle lease, tracking its lease status and the client who leased it.
 * 
 * @author Sara Boutine 40304116
 */
public class Lease {
	//To keep track of the leased vehicles and client who take these vehicles
	private boolean leased;
	private Client leasedBy;

	/**
     * Default constructor initializes a lease as not leased with no associated client.
     */
	public Lease()
	{
		this.leased = false;
		this.leasedBy = null;
	}
	
	/**
     * Parameterized constructor initializes a lease with the specified lease status and client.
     * 
     * @param leased   the lease status of the vehicle
     * @param leasedBy the client who leased the vehicle
     */
	public Lease(boolean leased, Client leasedBy)
	{
		this.leased = leased;
		this.leasedBy = leasedBy;
	}
		
	/**
     * Copy constructor creates a new lease instance by copying the values from another lease.
     * 
     * @param other the lease object to copy from.
     */
	public Lease(Lease other) 
	{
		this.leased = other.leased;
		this.leasedBy = other.leasedBy;
	}
	
	//Getters:
	
	/**
     * Checks if the vehicle is leased.
     * 
     * @return true if the vehicle is leased, otherwise false.
     */
	public boolean isLeased()
	{
		return leased;
	}
	
	 /**
     * Gets the client who leased the vehicle.
     * 
     * @return the client who leased the vehicle, or null if not leased.
     */
	public Client getLeasedBy()
	{
		return leasedBy;
	}
	
	//Setters:
	
	/**
     * Sets the lease status of the vehicle.
     * If the vehicle is no longer leased, the associated client is reset to null.
     * 
     * @param leased true if leased, otherwise false.
     */
	public void setLeased(boolean leased)
	{
		this.leased = leased;
        if (!leased) 
        {
            this.leasedBy = null; // Reset leasedBy when lease is removed
        }
	}
	
	/**
     * Sets the client who leased the vehicle.
     * 
     * @param leasedBy the client who leased the vehicle
     */
	public void setLeasedBy(Client leasedBy)
	{
		this.leasedBy = leasedBy;
	}
	
	 /**
     * Returns a string representation of the lease status and client information.
     * 
     * @return a formatted string describing the lease
     */
	public String toString()
	{
		return "-Lease status: " + (leased ? "Leased" : "Not Leased") +
	           "\n-Leased By: " + (leasedBy != null ? leasedBy.getName() : "None") + "\n";
	}
	
	/**
     * Compares this lease object with another object for equality based on lease status and client.
     * 
     * @param obj the object to compare
     * @return true if the objects are equal, otherwise false.
     */
	public boolean equals(Object obj) 
	{
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lease lease = (Lease) obj;
        return leased == lease.leased &&
               (leasedBy != null ? leasedBy.equals(lease.leasedBy) : lease.leasedBy == null);
    }
}
