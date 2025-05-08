package driverPackage;
import vehiclePackage.*;
import clientPackage.Client;
import java.util.Scanner;

//---------------------------------------------------------
//Written by: Sara Boutine 
//---------------------------------------------------------

/*-------------------------------------Purpose of this program-------------------------------------
 * The purpose of this program is to simulate the operations of a vehicle leasing service. 
 * It allows users to lease vehicles (cars and trucks), return them, and view leased vehicles 
 * by clients or by all clients. The program supports various vehicle types, including gasoline 
 * cars, electric cars, diesel trucks, and electric trucks. Users can perform additional operations 
 * like identifying the truck with the largest capacity and copying an array of electric trucks. 
 * The system is designed for testing and managing vehicle inventories, client information, and lease 
 * statuses, while providing features for managing both individual and fleet-level leasing operations.
 */

/**
 * The DriverRoyalRentals class serves as the main driver for the vehicle rental system.
 * It manages an array of vehicles and clients, allowing interactions such as adding and leasing vehicles.
 * 
 * @author Sara Boutine 40304116
 */
public class DriverRoyalRentals {
	//** Array to store the available vehicles for Royal Rentals. */
	private static Vehicle[] RoyalRentals;
	
    /** Array to store the clients of Royal Rentals. */
	private static Client[] clientsList;
	
	/** The maximum number of vehicles the system can manage. */
	private static int maxVehicles;
	
	/** The maximum number of clients the system can manage. */
	private static int maxClients;
	
	/** The current count of vehicles added to the system. */
	private static int vehiclesCount = 0;
	
	/** The current count of clients added to the system. */
	private static int clientsCount = 0;
	
	/** Scanner object to handle user input from the keyboard. */
	private static Scanner keyboard = new Scanner(System.in);
	
	/**
     * The main method serves as the entry point for the RoyalRentals application.
     * It continuously displays the main menu, allowing users to choose between interface operations, 
     * a predefined scenario, or exiting the program.
     */
	public static void main(String[] args) {
		
		//Welcome message for the user.
		System.out.println("\n============================= Welcome to RoyalRentals! =============================\n");	

		while (true)
		{
		//------Display the main menu------
		displayMainMenu();
		
		//Prompt user to select an option
		int mainChoice = keyboard.nextInt();
		
		switch(mainChoice)
		{
			case 1:
			{
				displayInterfaceOperations();
				break;
			}
			
			case 2:
			{
				predefinedScenario();
				break;
			}
			
			case 3:
			{
				System.out.println("\nThank you for using RoyalRentals. Goodbye!");
				System.exit(0);
				break;
			}
			
			default :
			{
				System.out.print("Invalid choice. Please try again!");
				break;
			}	
		}//end of the first switch
	
		}//end of the while loop 
	}
	
	/**
     * Displays the main menu for the RoyalRentals application.
     * The user is prompted to enter a number corresponding to their choice.
     * 
     * @param None
	 * @return None
     */
	private static void displayMainMenu()
	{
			System.out.print("Please choose between:\n"
					+ "    1. A menu-driven interface to interact with the program.\n"
					+ "    2. A predefined/hard-coded scenario for testing.\n"
					+ "    3. Exit.\n"
					+ "Choose an option (enter a number) > ");
	}
	
	/**
	 * Displays the main menu for managing vehicles, clients, leasing operations, and additional operations.
	 * Prompts the user for input to determine the maximum number of vehicles and clients in the system.
	 * Provides a looped interface to navigate through different operations with a selection menu.
	 * 
	 * @param None
	 * @return None
	 */
	private static void displayInterfaceOperations()
	{
		System.out.print("\nPlease enter the maximum number of vehicles that you can have in your inventory: ");
		maxVehicles = keyboard.nextInt();
		
		System.out.print("Please enter the maximum number of client that you can have: ");
		maxClients = keyboard.nextInt();	
		
		while(true)
		{
			System.out.println("\n-------------------------------------------------------------------------------------");
			System.out.println("What do you want to do?");
			System.out.println("	1. Vehicle Management.");
			System.out.println("	2. Client Management.");
			System.out.println("	3. Leasing Operations.");
			System.out.println("	4. Additional Operations.");
			System.out.println("	5. Exit the menu operation.");
			System.out.print("Please enter your choice > ");
			
			int choice = keyboard.nextInt();
			
			//to consume the left line
			keyboard.nextLine();
			
			switch(choice)
			{
				case 1 : 
				{
					vehicleManagement();
					break;
				}
				
				case 2:
				{
					clientManagement();
					break;
				}
				
				case 3:
				{
					leasingOperation();
					break;
				}
				
				case 4:
				{
					additionalOperations();
					break;
				}
				
				case 5:
				{
					System.out.println("\n-------------------------------------------------------------------------------------");
					return;
				}
				
				default:
				{
					System.out.print("Invalid choice. Please try again!");
					break;
				}
			}//end of the switch
		}//end of the while loop
	}

	/**
	 * Displays the Vehicle Management menu with options to manage vehicles.
	 * 
	 * @param None
	 * @return None
	 */
	private static void vehicleManagement()
	{
		System.out.println("\n--------------------------------- Vehicle Management ---------------------------------");
		System.out.println("Select one of the following option:");
		System.out.println("     1. Add a vehicle.");
		System.out.println("     2. Delete a vehicle.");
		System.out.println("     3. Update vehicle information.");
		System.out.println("     4. List all vehicles by category (electric trucks, diesel trucks, etc.).");
		System.out.println("     5. Exit.");
		System.out.print("Please enter your choice > ");		
		int choice = keyboard.nextInt();
		
		switch(choice)
		{
			case 1 ://Add a vehicle
			{
				addVehicle();
				break;
			}
			
			case 2: //Delete a vehicle
			{
				deleteVehicle();
				break;
			}
			
			case 3://Update a vehicle information
			{
				updateVehicle();
				break;
			}
			
			case 4: //List all vehicles by category
			{
				listAllVehicle();
				break;
			}
			
			case 5: //Exit
			{
				break;
			}
			
			default:
			{
				System.out.print("Invalid choice. Please try again!");
				break;
			}
		}//end of the switch
	}
	
	/**
	 * Prompts the user to add one or more vehicles to the RoyalRentals inventory.
	 * The method first ensures the vehicle array is initialized and checks if there is space
	 * to add the requested number of vehicles. For each vehicle, the user provides details such as
	 * make, model, year, and type (Gasoline Car, Electric Car, Diesel Truck, or Electric Truck).
	 * The method also displays the associated plate number for each newly added vehicle.
	 * 
	 * @param None
	 * @return None
	 */
	private static void addVehicle()
	{
		// Set the maximum number of vehicles in the array if not done yet
	    if (RoyalRentals == null) 
	    {
	        RoyalRentals = new Vehicle[maxVehicles];
	    }

	    // Prompt the user to enter the number of vehicles to add
	    int numVehicle;
	    while (true) 
	    {
	        System.out.print("\nHow many vehicle(s) do you want to add? ");
	        numVehicle = keyboard.nextInt();

	        // Verify if the array is full
	        if ((numVehicle + vehiclesCount) > maxVehicles) 
	        {
	            System.out.println("\nYou can only add " + (maxVehicles - vehiclesCount) + " more vehicles to the list.");
	        } 
	        else if (numVehicle <= 0) 
	        {
	            System.out.println("\nPlease enter a positive number of vehicles.");
	        } 
	        else 
	        {
	            break; // Exit the loop if the input is valid
	        }
	    }

	    // Loop for each new vehicle's information added
	    for (int i = 0; i < numVehicle; i++) {
	        System.out.println("\nEnter the new vehicle " + (i + 1) + "/" + numVehicle + " information please: ");

	        System.out.print("	- Make of the new vehicle : ");
	        String make = keyboard.next();

	        keyboard.nextLine(); // Consume the left line

	        System.out.print("	- Model of the new vehicle : ");
	        String model = keyboard.nextLine();

	        System.out.print("	- Year of production of the new vehicle : ");
	        int year = keyboard.nextInt();

	        // Prompt the user to choose the type of vehicle
	        int choice;
	        while (true) {
	            System.out.println("	- Provide the type of the vehicle, you can choose between:  ");
	            System.out.print("		1. Gasoline Car.\n"
	                           + "		2. Electric Car.\n"
	                           + "		3. Diesel Truck.\n"
	                           + "		4. Electric Truck.\n"
	                           + "	Enter your choice > ");
	            choice = keyboard.nextInt();

	            if (choice >= 1 && choice <= 4) 
	            {
	            	// Exit the loop if the choice is valid
	                break; 
	            } 
	            else 
	            {
	                System.out.println("Invalid choice. Please try again!");
	            }
	        }

	        switch (choice) {
	            case 1: {
	                System.out.print("	- Enter the maximum passengers allowed in this vehicle: ");
	                int maxPassenger = keyboard.nextInt();

	                RoyalRentals[vehiclesCount] = new GasolineCar(make, model, year, maxPassenger);
	                vehiclesCount++;

	                // To print the associated plate number to the new created vehicle
	                System.out.print("	- This is the plate number associated to this vehicle: " + RoyalRentals[vehiclesCount - 1].getPlateNumber() + "\n");
	                break;
	            }

	            case 2: {
	                System.out.print("	- Enter the maximum passengers allowed in this vehicle: ");
	                int maxPassenger = keyboard.nextInt();

	                System.out.print("	- Enter the maximum autonomy range of this vehicle: ");
	                double maxAutonomy = keyboard.nextDouble();

	                RoyalRentals[vehiclesCount] = new ElectricCar(make, model, year, maxPassenger, maxAutonomy);
	                vehiclesCount++;

	                // To print the associated plate number to the new created vehicle
	                System.out.print("	- This is the plate number associated to this vehicle: " + RoyalRentals[vehiclesCount - 1].getPlateNumber() + "\n");
	                break;
	            }

	            case 3: {
	                System.out.print("	- Enter the weight it can transport in kilograms: ");
	                double maxCapacity = keyboard.nextDouble();

	                System.out.print("	- Enter the fuel tank capacity in liters: ");
	                double fuelCapacity = keyboard.nextDouble();

	                RoyalRentals[vehiclesCount] = new DieselTruck(make, model, year, maxCapacity, fuelCapacity);
	                vehiclesCount++;

	                // To print the associated plate number to the new created vehicle
	                System.out.print("	- This is the plate number associated to this vehicle: " + RoyalRentals[vehiclesCount - 1].getPlateNumber() + "\n");
	                break;
	            }

	            case 4: {
	                System.out.print("	- Enter the weight it can transport in kilograms: ");
	                double maxCapacity = keyboard.nextDouble();

	                System.out.print("	- Enter the maximum autonomy range of this vehicle: ");
	                double maxAutonomy = keyboard.nextDouble();

	                RoyalRentals[vehiclesCount] = new ElectricTruck(make, model, year, maxCapacity, maxAutonomy);
	                vehiclesCount++;

	                // To print the associated plate number to the new created vehicle
	                System.out.print("	- This is the plate number associated to this vehicle: " + RoyalRentals[vehiclesCount - 1].getPlateNumber() + "\n");
	                break;
	            }
	        } // end of the switch
	    } // end of for loop
		
		System.out.println("\n\nThe new vehicle(s) have been successfully added to RoyalRentals!");		
	}

	/**
	 * Deletes a vehicle from the RoyalRentals inventory based on its license plate number.
	 * The method first checks if there are any vehicles available to delete. If no vehicles exist,
	 * an appropriate message is displayed. Otherwise, the user is prompted to enter the license plate 
	 * number of the vehicle to be removed. If the vehicle is found, it is removed by shifting elements in the array to fill the gap,
	 * and the last array slot is set to null.
	 * 
	 * @param None
	 * @return None
	 */
	private static void deleteVehicle()
	{
		if (vehiclesCount == 0)
		{
			System.out.println("There is no vehicle to delete at this moment.");
			return;
		}
		
		//Prompt the user to enter the license plate of the vehicle he wants to delete
		System.out.print("Enter the vehicle plate number to delete: ");
		String plateDelete = keyboard.next();
		
		//Default value of not found
		int indexToDelete = -1;
		
		//Find the vehicle by plate number
		for (int i = 0; i < vehiclesCount; i++)
		{
			if (RoyalRentals[i] != null && RoyalRentals[i].getPlateNumber().equalsIgnoreCase(plateDelete)) {  
	            indexToDelete = i;
	            break;
	        }
		}
		
		//If no vehicle is found 
		if (indexToDelete == -1) {
	        System.out.println("Vehicle not found.");
	        return;
	    }
		
		// Shift elements left to remove the vehicle
	    for (int i = indexToDelete; i < vehiclesCount - 1; i++) 
	    {
	        RoyalRentals[i] = RoyalRentals[i + 1];
	    }

	    // Set the last slot to null and decrease count
	    RoyalRentals[vehiclesCount - 1] = null;
	    vehiclesCount--;

	    System.out.println("Vehicle deleted successfully!");
	}
	
	/**
	 * Updates the details of an existing vehicle in the RoyalRentals inventory.
	 * The method first checks if there are any vehicles available for update. If no vehicles exist, 
	 * an appropriate message is displayed. Otherwise, the user is prompted to enter the license plate 
	 * number of the vehicle they wish to update. The method then searches for the vehicle in the array.
	 * If the vehicle is found, the user is presented with a menu to update various attributes such as 
	 * make, model, year, and specific properties depending on the vehicle type (passenger capacity, 
	 * weight capacity, fuel tank size, or autonomy range). The user can continue updating attributes 
	 * until they choose to exit the update menu.
	 * 
	 * @param None
	 * @return None
	 */
	private static void updateVehicle()
	{
		//Verify if there are vehicles already created
		if (vehiclesCount == 0)
		{
			System.out.println("There is no vehicle to update at this moment.");
			return;
		}
		
		//Prompt the user to enter the license plate of the vehicle he wants to update
		System.out.print("Enter the vehicle's plate number to delete: ");
		String plateUpdate = keyboard.next();
		
		//Default value of not found
		int indexToUpdate = -1;
		Vehicle vehicleToUpdate = null;
		
		//To find the vehicle with the corresponding plate number
		for (int i = 0; i < vehiclesCount; i++) 
		{
	        if (RoyalRentals[i].getPlateNumber().equalsIgnoreCase(plateUpdate)) {
	            vehicleToUpdate = RoyalRentals[i];
	            indexToUpdate = i;
	            break;
	        }
	    }
		
		//If no vehicle is found 
		if (indexToUpdate == -1 || vehicleToUpdate == null) 
		{
	        System.out.println("Vehicle not found.");
	        return;
	    }
		
		//Make the update
		System.out.println("\nUpdating vehicle: " + vehicleToUpdate.getMake() + " " + vehicleToUpdate.getModel() + " " + vehicleToUpdate.getYear());
		
	    // Loop to allow multiple updates until the user decides to exit
		int choice;
	    do {
	        System.out.println("\nWhich information would you like to update?");
	        System.out.println("	1. Make");
	        System.out.println(" 	2. Model");
	        System.out.println(" 	3. Year");
	        
	        if (vehicleToUpdate instanceof GasolineCar) {
	            System.out.println("	4. Max Passengers");
	        } 
	        else if (vehicleToUpdate instanceof ElectricCar) {
	            System.out.println("	4. Max Passengers");
	            System.out.println("	5. Max Autonomy");
	        } 
	        else if (vehicleToUpdate instanceof DieselTruck) {
	            System.out.println("	4. Max Cargo Capacity");
	            System.out.println("	5. Fuel Tank Capacity");
	        } 
	        else if (vehicleToUpdate instanceof ElectricTruck) {
	            System.out.println("	4. Max Cargo Capacity");
	            System.out.println("	5. Max Autonomy");
	        }
	        System.out.println("	6. Exit Update Menu");
	        System.out.print("Enter your choice: ");
	        choice = keyboard.nextInt();

	        switch (choice) {
	            case 1:
	                System.out.print("Enter new make (current make: " + vehicleToUpdate.getMake() + "): ");
	                vehicleToUpdate.setMake(keyboard.next());
	                break;

	            case 2:
	                System.out.print("Enter new model (current model: " + vehicleToUpdate.getModel() + "): ");
	                vehicleToUpdate.setModel(keyboard.next());
	                break;

	            case 3:
	                System.out.print("Enter new year (current year: " + vehicleToUpdate.getYear() + "): ");
	                vehicleToUpdate.setYear(keyboard.nextInt());
	                break;

	            case 4:
	                if (vehicleToUpdate instanceof GasolineCar) {
	                    GasolineCar car = (GasolineCar) vehicleToUpdate;
	                    System.out.print("Enter new max passengers (current max passengers: " + car.getMaxPassenger() + "): ");
	                    car.setMaxPassenger(keyboard.nextInt());
	                } 
	                else if (vehicleToUpdate instanceof ElectricCar) {
	                    ElectricCar car = (ElectricCar) vehicleToUpdate;
	                    System.out.print("Enter new max passengers (current max passenger: " + car.getMaxPassenger() + "): ");
	                    car.setMaxPassenger(keyboard.nextInt());
	                } 
	                else if (vehicleToUpdate instanceof DieselTruck) {
	                    DieselTruck truck = (DieselTruck) vehicleToUpdate;
	                    System.out.print("Enter new max weigth capacity (current capacity: " + truck.getMaxCapacity() + " kg): ");
	                    truck.setMaxCapacity(keyboard.nextDouble());
	                } 
	                else if (vehicleToUpdate instanceof ElectricTruck) {
	                    ElectricTruck truck = (ElectricTruck) vehicleToUpdate;
	                    System.out.print("Enter new max weigth capacity (current capacity: " + truck.getMaxCapacity() + " kg): ");
	                    truck.setMaxCapacity(keyboard.nextDouble());
	                }
	                break;

	            case 5:
	                if (vehicleToUpdate instanceof ElectricCar) {
	                    ElectricCar car = (ElectricCar) vehicleToUpdate;
	                    System.out.print("Enter new max autonomy (current autonomy: " + car.getMaxAutonomyRange() + " km): ");
	                    car.setMaxAutonomyRange(keyboard.nextDouble());
	                } 
	                else if (vehicleToUpdate instanceof DieselTruck) {
	                    DieselTruck truck = (DieselTruck) vehicleToUpdate;
	                    System.out.print("Enter new fuel tank capacity (current fuel capacity: " + truck.getFuelCapacity() + " liters): ");
	                    truck.setFuelCapacity(keyboard.nextDouble());
	                } 
	                else if (vehicleToUpdate instanceof ElectricTruck) {
	                    ElectricTruck truck = (ElectricTruck) vehicleToUpdate;
	                    System.out.print("Enter new max autonomy (current autonomy: " + truck.getMaxAutonomy() + " km): ");
	                    truck.setMaxAutonomy(keyboard.nextDouble());
	                }
	                break;

	            case 6:
	                System.out.println("Exiting update menu.");
	                break;

	            default:
	                System.out.println("Invalid choice. Try again.");
	        }

	        System.out.println("Attribute updated successfully!");

	    } while (choice != 6);
	}

	/**
	 * Lists all registered vehicles in the RoyalRentals inventory,
	 * categorized by type (Gasoline Car, Electric Car, Diesel Truck, Electric Truck).
	 * If no vehicles of a specific type exist, an appropriate message is displayed.
	 * 
	 * @param None
	 * @return None
	 */
	private static void listAllVehicle()
	{
		System.out.println("\n------------------------- List of all the vehicle registered -------------------------");
		
		// Loop for all the gasoline car type.
	    System.out.println("Gasoline Car Type: ");
	    
	    // Flag to track if any GasolineCar is found
	    boolean gasolineCarFound = false; 

	    for (int i = 0; i < vehiclesCount; i++) 
	    {
	        if (RoyalRentals[i] instanceof GasolineCar) 
	        {
	            System.out.println(" -" + RoyalRentals[i].getMake() + " " + RoyalRentals[i].getModel() + " " + RoyalRentals[i].getYear());
	            gasolineCarFound = true; 
	        }
	    }

	    // If no GasolineCar is found
	    if (!gasolineCarFound) 
	    {
	        System.out.println("Nothing was found!");
	    }

	    System.out.println("\n");
		
	    
		
		//Loop for all the electric car type.
		System.out.println("Electric Car Type: ");
		
		// Flag to track if any ElectricCar is found
		boolean electricCarFound = false; 

		for (int i = 0; i < vehiclesCount; i++) 
		{
			if (RoyalRentals[i] instanceof ElectricCar)
			{
				System.out.println(" -" + RoyalRentals[i].getMake() + " " + RoyalRentals[i].getModel() + " " + RoyalRentals[i].getYear());
				electricCarFound = true;
			}
		}

		// If no ElectricCar is found
		if (!electricCarFound) 
		{
		    System.out.println("Nothing was found!");
		}
		
		System.out.println("\n");
				
		    
		//Loop for all the diesel truck type.
		System.out.println("Diesel Truck Type: ");
		
		// Flag to track if any ElectricCar is found
		boolean dieselTruckFound = false; 

		for (int i = 0; i < vehiclesCount; i++) 
		{
			if (RoyalRentals[i] instanceof DieselTruck)
			{
				System.out.println(" -" + RoyalRentals[i].getMake() + " " + RoyalRentals[i].getModel() + " " + RoyalRentals[i].getYear());
				dieselTruckFound = true;
			}
		}

		// If no DieselTruck is found
		if (!dieselTruckFound) 
		{
			System.out.println("Nothing was found!");
		}
			
	    System.out.println("\n");
					
				
		//Loop for all the electric truck type.
		System.out.println("Electric Truck Type: ");
		
		// Flag to track if any ElectricTruck is found
		boolean electricTruckFound = false; 

		for (int i = 0; i < vehiclesCount; i++) 
		{
			if (RoyalRentals[i] instanceof ElectricTruck)
			{
				System.out.println(" -" + RoyalRentals[i].getMake() + " " + RoyalRentals[i].getModel() + " " + RoyalRentals[i].getYear());
				electricTruckFound = true;
			}
		}

		// If no ElectricTruck is found
		if (!electricTruckFound) 
			{
				System.out.println("Nothing was found!");
			}
		System.out.println("\n");
	}
	
	/**
	 * Manages client operations, including adding, editing, and deleting clients.
	 * Displays a menu for the user to select an option and performs the corresponding action.
	 * The menu repeats until the user chooses to exit.
	 * 
	 * @param None
	 * @return None
	 */
	private static void clientManagement()
	{
		System.out.println("\n------------------------------Clients Management------------------------------");
		System.out.println("Select one of the following option:");
		System.out.println("     1. Add a client.");
		System.out.println("     2. Edit a client.");
		System.out.println("     3. Delete a client.");
		System.out.println("     4. Exit.");
		System.out.print("Please enter your choice > ");		
		int choice = keyboard.nextInt();
		
		switch(choice)
		{
			case 1 ://Add a client.
			{
				addClient();
				break;
			}
			
			case 2: //Delete a client.
			{
				editClient();
				break;
			}
			
			case 3://Delete a client.
			{
				deleteClient();
				break;
			}
			
			case 4: //Exit
			{
				break;
			}
			
			default:
			{
				System.out.print("Invalid choice. Please try again!");
				break;
			}
		}//end of the switch
		
	}
	
	/**
	 * Adds new clients to the client list.
	 * If the client list has not been initialized, it sets the maximum number of clients.
	 * The user is prompted to enter the number of clients to add, ensuring the list does not exceed its maximum capacity.
	 * Each client's name and phone number are collected and stored in the array.
	 *
	 * @param None
	 * @return None
	 */
	private static void addClient()
	{
		//Set the maximum number of client in the array if not done yet
		if (clientsList == null)
		{
			clientsList = new Client[maxClients];
		}
				
		//Prompt the user to enter the number of client to add
		System.out.print("\nHow many client(s) do you want to add? ");
		int numClient = keyboard.nextInt();
				
		//Verify if the array is full
		if((numClient + clientsCount) > maxClients)
		{
			System.out.println("\nYou can only add " + (maxClients - clientsCount)+ " more client(s) to your list.");					
			return;
		}
		
		//If array not full
		for (int i = 0; i < numClient; i++)
		{
			System.out.println("\nEnter the new client " + (numClient - (numClient - (i + 1))) + "/" + numClient + " information please: ");
					
			System.out.print("- Name of the new client : ");
			String name = keyboard.next();
					
			System.out.print("- Phone number of the new client: ");
			String phoneNumber = keyboard.next();
			
			clientsList[clientsCount] = new Client(name, phoneNumber);
			clientsCount++;
		}
		System.out.println("\nYour client(s) have been successfully added to your repertory!");
	}
	
	/**
	 * Edits the details of an existing client in the client list.
	 * If no clients exist, the method informs the user and exits.
	 * The user is prompted to enter the phone number of the client they wish to modify.
	 * If the client is found, the user is given options to edit either the client's name or phone number.
	 * 
	 * @param None
	 * @return None
	 */
	private static void editClient()
	{
		if (clientsCount == 0)
		{
			System.out.println("There is no client to update at this moment.");
			return;
		}
		
		System.out.print("Enter the phone number of the client you want to modify: ");
		String clientPhone = keyboard.next();
		
		//Default value of not found
		int indexToEdit = -1;
		Client clientToEdit = null;
		
		//To search for the client with phone number
		for (int i = 0; i < clientsCount; i++)
		{
			if(clientsList[i].getPhoneNumber().replace("-", "").equals(clientPhone.replace("-", "")))
			{
				clientToEdit = clientsList[i];
				indexToEdit = i;
				break;
			}
		}

		//If no client is found 
		if (indexToEdit == -1 || clientToEdit == null ) 
		{
		   System.out.println("Client not found.");
		   return;
	    }
		
		//Make the edit
		System.out.println("\nEditing client: " + clientToEdit.getName() + " " + clientToEdit.getPhoneNumber());
		
		int choice;
		do {
	        System.out.println("\nWhich information would you like to edit?");
	        System.out.println("	1. Name of the client.");
	        System.out.println(" 	2. Phone number of the client.");
	        System.out.println("	3. Exit Edit Menu");
	        System.out.print("Enter your choice > ");
	        
	        choice = keyboard.nextInt();
	        
	        switch(choice)
	        {
	        	case 1://Edit name client
	        	{
	        		System.out.print("\nEnter new name (current name: " + clientToEdit.getName() + "): ");
	        		clientToEdit.setName(keyboard.next());
	        		System.out.println("Your client's name has been successfully editted!");
	                break;
	        	}
	        	
	        	case 2://Edit phone number of client
	        	{
	        		System.out.print("\nEnter new phone number (current phone number: " + clientToEdit.getPhoneNumber() + "): ");
	        		clientToEdit.setPhoneNumber(keyboard.next());
	        		System.out.println("Your client's phone number has been successfully editted!");
	                break;
	        	}
	        	
	        	case 3: //Exit
	        	{
	        		System.out.println("Exiting Edit Menu.");
	        		break;
	        	}
	        
	            default:
	            {
	            	System.out.println("Invalid choice. Try again.");
	            }
	        	
	        }//end of switch
		}while(choice != 3);
	}
	
	/**
	 * Deletes a client from the client list based on their phone number.
	 * If no clients exist, the method informs the user and exits.
	 * The user is prompted to enter the phone number of the client to delete.
	 * If the client is found, they are removed from the list by shifting elements left.
	 * 
	 * @param None
	 * @return None
	 */
	private static void deleteClient()
	{
		if (clientsCount == 0)
		{
			System.out.println("There is no client to delete at this moment.");
			return;
		}
		
		//Prompt the user to enter the phone number of the client to delete
		System.out.print("Enter the phone number to delete: ");
		String phoneDelete = keyboard.next();
		
		//Default value of not found
		int indexToDelete = -1;
		
		//Find the client by phone number
		for (int i = 0; i < clientsCount; i++)
		{
			if (clientsList[i] != null && clientsList[i].getPhoneNumber().replace("-", "").equals(phoneDelete.replace("-", ""))) 
			{  
	            indexToDelete = i;
	            break;
	        }
		}
		//If no client is found 
		if (indexToDelete == -1) {
	        System.out.println("Client not found.");
	        return;
	    }
		
		// Shift elements left to remove the client
	    for (int i = indexToDelete; i < clientsCount - 1; i++) 
	    {
	    	clientsList[i] = clientsList[i + 1];
	    }

	    // Set the last slot to null and decrease count
	    clientsList[clientsCount - 1] = null;
	    clientsCount--;

	    System.out.println("Client deleted successfully!");
	}
	
	/**
	 * Handles leasing operations for vehicles in the rental system.
	 * The method prompts the user for an input choice and executes the corresponding action.
	 * If an invalid choice is entered, the user is prompted to try again.
	 * 
	 * @param None
	 * @return None
	 */
	private static void leasingOperation()
	{
		System.out.println("\n------------------------------Leasing Operations------------------------------");
		System.out.println("Select one of the following option:");
		System.out.println("     1. Lease a vehicle to a client");
		System.out.println("     2. Return a vehicle from a client");
		System.out.println("     3. Show all vehicles leased by a client");
		System.out.println("     4. Show all leased vehicles (by all clients)");
		System.out.println("     5. Exit");
		System.out.print("Please enter your choice > ");		
		int choice = keyboard.nextInt();
		
		switch(choice)
		{
			case 1 ://Lease a vehicle to a client
			{
				leaseVehicle();
				break;
			}
			
			case 2: //Return a vehicle from a client
			{
				returnVehicle();
				break;
			}
			
			case 3://Show all vehicles leased by a client
			{
				showClientLeasedVehicle();
				break;
			}
			
			case 4: //Exit
			{
				showAllLeasedVehicles();//Show all leased vehicles (by all clients)
				break;
			}
			
			case 5://Exit
			{
				break;
			}
			
			default:
			{
				System.out.print("Invalid choice. Please try again!");
				break;
			}
		}//end of the switch
	}
	
	/**
	 * Leases an available vehicle to a registered client.
	 * Checks if there are any available vehicles for leasing.
	 * Prompts the user to enter a client's phone number and verifies if the client exists.
	 * Displays a list of available vehicles and allows the client to select one.
	 * Marks the selected vehicle as leased and associates it with the client.
	 * If no vehicles are available, or if an invalid selection is made, appropriate messages are displayed.
	 * If the client is not found in the system, they must be registered first.
	 * 
	 * @param None
	 * @return None
	 */
	private static void leaseVehicle()
	{
		System.out.println("\n----------Lease a Vehicle----------");
		
		//Verify if there are available vehicles
		boolean vehicleAvailable = false;
		
		for(int i = 0; i < vehiclesCount; i++)
		{
			if (RoyalRentals[i] != null && !RoyalRentals[i].isLeased()) 
			{
	            vehicleAvailable = true;
	            break;
			}
		}
		
		if (!vehicleAvailable) 
		{
	        System.out.println("No available vehicles for leasing.");
	        return;
	    }
		
		//Ask for the client's phone number
		System.out.print("Enter client's phone number: ");
		String clientPhone = keyboard.next().replace("-", "");
		
		Client leasingClient = null;
		
		//Find the client in the client's list
	    for (int i = 0; i < clientsCount; i++) 
	    {
	        if (clientsList[i] != null && clientsList[i].getPhoneNumber().replace("-", "").equals(clientPhone)) 
	        {
	            leasingClient = clientsList[i];
	            break;
	        }
	    }

	    if (leasingClient == null) 
	    {
	        System.out.println("Client not found. Please register the client first.");
	        return;
	    }
		
	   //Show the available vehicles and ask the client the one they want
	    System.out.println("\nAvailable vehicles:");
	    for (int i = 0; i < vehiclesCount; i++) 
	    {
	        if (!RoyalRentals[i].isLeased()) 
	        {
	            System.out.println((i + 1) + ". " + RoyalRentals[i]); 
	        }
	    }
	    
	    System.out.print("Enter the number of the vehicle to lease: ");
	    int vehicleIndex = keyboard.nextInt() - 1;
		
	    //for invalid choice
	    if (vehicleIndex < 0 || vehicleIndex >= vehiclesCount || RoyalRentals[vehicleIndex].isLeased()) {
	        System.out.println("Invalid selection. Please try again.");
	        return;
	    }
	    
	    //Lease the vehicle to the client.
	    Vehicle leasedVehicle = RoyalRentals[vehicleIndex]; 
	    leasedVehicle.setLeased(true);                       
	    leasedVehicle.setLeasedBy(leasingClient); 
	    System.out.println("\nVehicle successfully leased to " + leasingClient.getName() + "!");
	}
	
	/**
	 * Returns a leased vehicle by updating its status and removing the reference to the client.
	 * Searches for the vehicle in the system based on the given plate number.
	 * If the vehicle is leased, it marks the vehicle as available and removes the client reference.
	 * Displays a success message if the vehicle is returned successfully or an error message if no leased vehicle is found with the provided plate number.
	 *
	 * @param None
	 * @return None
	 */
	private static void returnVehicle()
	{
		//Ask for the vehicle information
	    System.out.print("Please enter the plate number of the vehicle you want to return: ");
	    String plateNumber = keyboard.next(); 

	    boolean found = false;

	    // Search for the vehicle with the given plate number
	    for (int i = 0; i < vehiclesCount; i++) {
	        if (RoyalRentals[i].getPlateNumber().equals(plateNumber) && RoyalRentals[i].isLeased()) {
	            // If vehicle is leased, mark it as available and remove the reference to the previous client
	            RoyalRentals[i].setLeased(false); 
	            RoyalRentals[i].setLeasedBy(null);
	            System.out.println("The vehicle with plate number " + plateNumber + " has been returned successfully!");
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("No leased vehicle found with plate number " + plateNumber + ".");
	    }
	}
	
	/**
	 * Displays all vehicles leased by a specific client based on their phone number.
	 * Prompts the user to enter the phone number of the client whose leased vehicles are to be displayed.
	 * Searches the client list to find a match for the given phone number.
	 * If the client is found, it displays all vehicles leased by that client.
	 * If no leased vehicles are found for the client, a message is displayed indicating that no vehicles are leased by the client.
	 * 
	 * @param None
	 * @return None
	 */
	private static void showClientLeasedVehicle()
	{
		//Ask for the phone number of the client
	    System.out.print("Please enter the phone number of the client: ");
	    String clientPhone = keyboard.next(); 
	    Client client = null;
	    
	    // Loop through the clients list to find the client by phone number
	    for (int i = 0; i < clientsCount; i++) 
	    {
	        if (clientsList[i].getPhoneNumber().replace("-", "").equals(clientPhone)) 
	        {
	            client = clientsList[i]; 
	            break;
	        }
	    }
	    
	    if (client == null) {
	        System.out.println("Client not found.");
	        return;
	    }

	    // Now print the name of the client
	    System.out.println("\nVehicles leased by " + client.getName() + ":");
	    
	    boolean foundClient = false;

	    // Loop through the vehicles to find leased ones by the specific client
	    for (int i = 0; i < vehiclesCount; i++) 
	    {
	        // Check all the vehicles leased by the specific client
	        if (RoyalRentals[i].isLeased() && RoyalRentals[i].getLeasedBy() != null &&
	                RoyalRentals[i].getLeasedBy().equals(client)) 
	        {
	            System.out.println((i + 1 ) + ". " + RoyalRentals[i]);
	            foundClient = true;
	        }
	    }

	    if (!foundClient) 
	    {
	        System.out.println("-No vehicles leased by this client.");
	    }
	}
	
	/**
	 * Displays a list of all vehicles that are currently leased by clients.
	 * Loops through all vehicles in the system to check if they are currently leased.
	 * If a vehicle is leased, it prints the vehicle's details and the name of the client who leased it.
	 * If no leased vehicles are found, a message is displayed indicating that no vehicles are currently leased.
	 * 
	 * @param None
	 * @return None
	 */
	private static void showAllLeasedVehicles()
	{
		System.out.println("\n----------List of all leased vehicles by all the clients----------");
		
		boolean foundLeasedVehicles = false;
		
		//Loop through all vehicles and check if they are leased
		for (int i = 0; i < vehiclesCount; i++)
		{
			if(RoyalRentals[i].isLeased())
			{
				foundLeasedVehicles = true;
				System.out.println(RoyalRentals[i] + "-Leased by: " + 
						RoyalRentals[i].getLeasedBy().getName() + "\n");
			}
		}
		
		//If not leased vehicles found
		if (!foundLeasedVehicles) {
	        System.out.println("No leased vehicles found!");
	    }
	}
	
	/**
	 * Provides additional operations related to vehicle management.
	 * Displays the truck with the largest capacity by calling the getLargestTruck() method.
	 * Creates a copy of the electric trucks array by calling the copyVehicles(Vehicle[], int) method
	 *
	 * @param None
	 * @return None
	 */
	private static void additionalOperations()
	{
		System.out.println("\n------------------------------Additional Operations------------------------------");
		System.out.println("Select one of the following option:");
		System.out.println("     1. Display the truck with the largest capacity");
		System.out.println("     2. Create a copy of the electric trucks array");
		System.out.println("     3. Exit");
		System.out.print("Please enter your choice > ");		
		int choice = keyboard.nextInt();
		
		switch(choice)
		{
			case 1:
			{
				DieselTruck largestTruck = getLargestTruck();
			    break;
			}
			
			case 2:
			{
				copyVehicles(RoyalRentals, vehiclesCount);
				break;
			}
			
			case 3:
			{
				break;
			}
			
			default : 
			{
				System.out.print("Invalid choice. Please try again!");
				break;
			}
		}
		
	}
	
	/**
	 * Finds and returns the diesel truck with the largest capacity from the list of vehicles.
	 * This method loops through all vehicles and identifies the diesel truck with the highest maximum capacity
	 * by comparing the DieselTruck getMaxCapacity() values. It then returns the truck with the largest capacity.
	 * 
	 * @return the DieselTruck with the largest capacity.
	 */
	public static DieselTruck getLargestTruck()
	{
		 DieselTruck largestTruck = null;
		 double maxCapacity = 0;

		    // Loop through the vehicles and find the diesel truck with the largest capacity
		    for (int i = 0; i < vehiclesCount; i++) 
		    {
		        if (RoyalRentals[i] instanceof DieselTruck) 
		        {
		            DieselTruck truck = (DieselTruck) RoyalRentals[i]; 
		            if (truck.getMaxCapacity() > maxCapacity) 
		            {
		                maxCapacity = truck.getMaxCapacity();
		                largestTruck = truck;
		            }
		        }
		    }
		    
		    if (largestTruck != null) {
		        System.out.println("\nThe largest diesel truck is: " + largestTruck);
		    } else {
		        System.out.println("\nNo diesel trucks found.");
		    }
		    
		    return largestTruck;
	}
	
	/**
	 * Copies all electric trucks from the provided list of vehicles into a new array.
	 * This method iterates over the list of vehicles, counting the number of ElectricTruck objects and 
	 * creating a new array to hold those objects. If no electric trucks are found, an empty array is returned.
	 * 
	 * @param RoyalRentals the array of Vehicle objects to search through.
	 * @param vehiclesCount the total number of vehicles in the RoyalRentals array.
	 * @return a new array of ElectricTruck objects containing all the electric trucks found in the input array.
	 */
	public static ElectricTruck[] copyVehicles(Vehicle[] RoyalRentals, int vehiclesCount) 
	{
	    // Count the number of electricTruckCount objects
	    int electricTruckCount = 0;

	    for (int i = 0; i < vehiclesCount; i++)
	    {
	        if (RoyalRentals[i] instanceof ElectricTruck) {
	            electricTruckCount++;
	        }
	    }
	    
	    //If no ElectricTruck object is found and return empty array
	    if (electricTruckCount == 0)
	    {
	    	System.out.println("\nNo electric truck found to copy!");
	    	return new ElectricTruck[0];
	    }
	  
	    // Create a new array for ElectricTruck
	    ElectricTruck[] electricTrucksCopy = new ElectricTruck[electricTruckCount];
	    int index = 0;
	    
	    // Copy all ElectricTruck objects into the new array
	    for (int i = 0; i < vehiclesCount; i++) {
	        if (RoyalRentals[i] instanceof ElectricTruck) {
	            electricTrucksCopy[index++] = (ElectricTruck) RoyalRentals[i];
	        }
	    }
	    
	    //Print the copy
	    System.out.println("\nThe copied electric trucks are:");
	    for (int i = 0; i < electricTrucksCopy.length; i++) 
	    {
	    	if(electricTrucksCopy[i] != null)
	    	{
	    		System.out.println(electricTrucksCopy[i]);
	    	}
	    	else
	    	{
	    		System.out.println("\nNo electric truck found to copy!");
	    	}
	    }
	    System.out.println("Electric trucks copied successfully!\n");

	    return electricTrucksCopy;
	}
	    
	/**
	 * Sets up a predefined scenario for testing by creating an array of vehicles and clients, 
	 * then populating them with sample data. The method tests various functionalities such as 
	 * displaying vehicle and client information, comparing objects ,and testing specific methods 
	 * like getLargestTruck() and copyVehicles(Vehicle[], int).
	 * 
	 * @param None
	 * @return None
	 */
	private static void predefinedScenario()
	{
		System.out.println("============================Predefined Scenario (Testing)============================");
		
		RoyalRentals = new Vehicle[12]; // Make sure it has enough space

		//Create 3 objects of each vehicle type
		GasolineCar gc1 = new GasolineCar("Mercedes", "E-Class", 2021, 5);
		GasolineCar gc2 = new GasolineCar("BMW", "M8", 2022, 2);
		GasolineCar gc3 = new GasolineCar("Audi", "Q7", 2023, 5);

	    ElectricCar ec1 = new ElectricCar("Tesla", "Model S", 2023, 5, 650);
	    ElectricCar ec2 = new ElectricCar("Lucid", "Air", 2022, 5, 800);
	    ElectricCar ec3 = new ElectricCar("Nissan", "Leaf", 2023, 5, 400);
		
	    DieselTruck dt1 = new DieselTruck("Freightliner", "Cascadia", 2021, 20000, 300);
	    DieselTruck dt2 = new DieselTruck("Volvo", "VNL", 2022, 22000, 320);
	    DieselTruck dt3 = new DieselTruck("Kenworth", "T680", 2023, 25000, 350);
	    
	    ElectricTruck et1 = new ElectricTruck("Tesla", "Cybertruck", 2023, 6000, 800);
	    ElectricTruck et2 = new ElectricTruck("Rivian", "R1T", 2022, 5000, 700);
	    ElectricTruck et3 = new ElectricTruck("Ford", "F-150 Lightning", 2023, 5500, 750);

	    //Create 3 clients
	    Client client1 = new Client("Alicia", "123-456-7890");
	    Client client2 = new Client("Sara", "234-567-8901");
	    Client client3 = new Client("Maria", "345-678-9012");
	    
	    RoyalRentals[0] = gc1;
	    RoyalRentals[1] = gc2;
	    RoyalRentals[2] = gc3;
	    RoyalRentals[3] = ec1;
	    RoyalRentals[4] = ec2;
	    RoyalRentals[5] = ec3;
	    RoyalRentals[6] = dt1;
	    RoyalRentals[7] = dt2;
	    RoyalRentals[8] = dt3;
	    RoyalRentals[9] = et1;
	    RoyalRentals[10] = et2;
	    RoyalRentals[11] = et3;

	    vehiclesCount = 12;

	 // Display information using toString()
	    System.out.println("\n-------------------------Vehicle Information-------------------------");
	    System.out.println(gc1);
	    System.out.println(gc2);
	    System.out.println(gc3);
	    System.out.println(ec1);
	    System.out.println(ec2);
	    System.out.println(ec3);
	    System.out.println(dt1);
	    System.out.println(dt2);
	    System.out.println(dt3);
	    System.out.println(et1);
	    System.out.println(et2);
	    System.out.println(et3);
	   
	    System.out.println("\n-------------------------Client Information-------------------------");
	    System.out.println(client1);
	    System.out.println(client2);
	    System.out.println(client3);

	    //Test the equals() method 
	    System.out.println("\n-------------------------Equals() method testing-------------------------");

	    //1. Compare two objects from different classes :
	    System.out.println("Comparing an ElectricTruck with a DieselTruck: " + et1.equals(dt1));
	    
	    //2. Compare two objects of the same class with different attribute values :
	    System.out.println("Comparing two different ElectricTrucks: " + et1.equals(et2));
	    
	    //3. Compare two objects of the same class with identical attribute values : 
	    ElectricTruck et4 = new ElectricTruck("Tesla", "Cybertruck", 2023, 6000, 800);
	    System.out.println("Comparing two identical ElectricTrucks: " + et1.equals(et4));

	    //Create arrays for each type of vehicle
	    GasolineCar[] gasolinelCars = {gc1, gc2, gc3};
	    ElectricCar[] electricCars = {ec1, ec2, ec3};
	    DieselTruck[] dieselTrucks = {dt1, dt2, dt3};
	    ElectricTruck[] electricTrucks = {et1, et2, et3};
	    
	    // Create an array for all vehicles
	    Vehicle[] allVehicles = {gc1, gc2, gc3, ec1, ec2, ec3, dt1, dt2, dt3, et1, et2, et3,};
	    
	    System.out.println("\n-------------------------Other methods testing-------------------------");
	    
	    // Call getLargestTruck() on diesel trucks
	    DieselTruck largestTruck = getLargestTruck();
	    
	    // Call copyVehicles() on electric trucks and display them
	    ElectricTruck[] electricTrucksCopy = copyVehicles(RoyalRentals, vehiclesCount);
	
	}
	
}
