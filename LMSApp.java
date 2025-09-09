import java.util.Scanner;

public class LMSApp {
    public static void main(String[] args) {
        LMS lms = new LMS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Load patrons from file");
            System.out.println("2. Add patron manually");
            System.out.println("3. Remove patron");
            System.out.println("4. List patrons");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    lms.loadPatronsFromFile(filename);
                    break;

                case 2:
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
                    System.out.print("Enter ID of patron to remove: ");
                    String removeId = scanner.nextLine();
                    lms.removePatron(removeId);
                    break;

                case 4:
                    lms.listPatrons();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

