import java.io.*;
import java.util.*;
// the library management system that manages the
// patrons with the requirements that were asked for.
public class LMS {
    //collection of the Patron objects
    private List<Patron> patrons;

    //reads the patron list
    
    public LMS() {
        //creation of a collection in memory for Patron(the empty list)
        patrons = new ArrayList<>();
    }

    public void addPatron(Patron patron) {
        patrons.add(patron); //adds patron
    }

    public void removePatron(String id) {
        patrons.removeIf(p -> p.getId().equals(id)); //removal of patron using ID
    }

    public void listPatrons() {
        if (patrons.isEmpty()) {
            //error message if Patron is not found
            System.out.println("No patrons found.");
        } else {
            patrons.forEach(System.out::println);
            //prints each patron in the system
        }
    }

    public void loadPatronsFromFile(String filename) {
        //gets file that user uploads to create a patron object
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String address = parts[2];
                    double fine = Double.parseDouble(parts[3]);
                    patrons.add(new Patron(id, name, address, fine));
                }
            }
            System.out.println("Patrons loaded successfully."); //output if uploaded successfully
        } catch (IOException e) {
            //error
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
