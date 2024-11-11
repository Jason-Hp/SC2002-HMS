package view;

public class AdminDisplayMenu implements Display{
    static public void display() {
        System.out.println("");
		System.out.println("Admin Menu");
		System.out.println("==============================================");
        System.out.println("1) View and Manage Staff\r\n"
							+ "2) View Appointment Details\r\n"
							+ "3) View and Manage Medication Inventory\r\n"
							+ "4) Approve Replenishment Requests\r\n" 
							+ "5) Shut Down\r\n"
                            + "6) Log Out\r\n");
        System.out.println("==============================================");
        System.out.println("");
    } 
}
