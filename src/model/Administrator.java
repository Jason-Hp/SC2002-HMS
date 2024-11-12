package model;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.InventoryManagement;
import controller.StaffManagement;
import model.Appointment;
import view.AdminDisplayMenu;
import view.InputIntChoice;
import system.SystemManager;

public class Administrator extends User {
	private InventoryManagement inventoryManagement;
    private StaffManagement staffManagement;
	private ArrayList<Appointment> allAppointments;
	private InputIntChoice inputIntChoice = new InputIntChoice(6); // 6 input choices
	private SystemManager systemManager;

    public Administrator(String id, String name, int age, String gender, ArrayList<Inventory> allInventoryItems, ArrayList<User> staffList, ArrayList<Appointment> allAppointments, SystemManager systemManager) {
        super(id, name, age, gender);
		this.inventoryManagement = new InventoryManagement(allInventoryItems);
        this.staffManagement = new StaffManagement(staffList, allInventoryItems, allAppointments, systemManager);
		this.allAppointments = allAppointments;
		this.systemManager = systemManager;
    }

	
    // Inventory management methods delegated to InventoryManagement
    public void manageInventory() {
        inventoryManagement.manageInventory();
    }

	public void approveRequest() {
		inventoryManagement.approveRequest();
	}

    // Staff management methods delegated to StaffManagement
    public void manageStaff() {
        staffManagement.manageStaff();
    }
	
    public void displayMenu() {
        int choice;
		do{
			AdminDisplayMenu.display();
			choice = inputIntChoice.getIntChoice();
			
			switch(choice) {
			case 1:
				manageStaff();
				break;
			case 2:
				viewAppointment(allAppointments);
				break;
			case 3:
				manageInventory();
				break;
			case 4:
				approveRequest();
				break;
			case 5:
				systemManager.shutdown();
				break;
			case 6:
				break;
			}
			
		} while (choice != 6);
		
		// scan.close();
    }
	
	private void viewAppointment(ArrayList<Appointment> allAppointments) {
		for(Appointment a : allAppointments) {
			a.printInfoForAdmin();
		}
	}
    
}

