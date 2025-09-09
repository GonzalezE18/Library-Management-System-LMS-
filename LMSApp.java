import java.util.Scanner;

//Console base interface for users
//using the LMS
public class LMSApp {
    public static void main(String[] args) {
        LMS lms = new LMS(); //creates the LMS 
        Scanner scanner = new Scanner(System.in);

        //program loop
        while (true) {
            //menu displayed to users using the LMS
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Load patrons from file");
            System.out.println("2. Add patron manually");
            System.out.println("3. Remove patron");
            System.out.println("4. List patrons");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // newline is created

            switch (choice) {
                case 1:
                //uploads the file name for the user
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    lms.loadPatronsFromFile(filename);
                    break;

                case 2:
                // asking for the patrons details
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter fine amount: ");
                    double fine = scanner.nextDouble();
                    scanner.nextLine();
                    lms.addPatron(new Patron(id, name, address, fine));
                    break;

                case 3:
                // removes patron by ID
                    System.out.print("Enter ID of patron to remove: ");
                    String removeId = scanner.nextLine();
                    lms.removePatron(removeId);
                    break;

                case 4:
                //display patrons in system
                    lms.listPatrons();
                    break;

                case 5:
                //exits the system if done
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                //did not put correct input 
                    System.out.println("Invalid option.");
            }
        }
    }
}

