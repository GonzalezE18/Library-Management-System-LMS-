public class Patron {
    //Adding field that can only be visible for this class and cannot be added 
    //create the objects 
    private String id; //7 digit ID 
    private String name; //full name of patron
    private String address; // patrons address
    private double fineAmount; //fine owed

    public Patron(String id, String name, String address, double fineAmount) {
        //creating the  parts of the objects
        //assigning the field to parameter
        this.id = id;
        this.name = name;
        this.address = address;
        this.fineAmount = fineAmount;
    }



    //accessing the private fields
    public String getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public double getFineAmount() { return fineAmount; }

    //using override to replace the default that it will ouput to what the layout is wanted
    @Override
    public String toString() {
        return id + " - " + name + " - " + address + " - " + fineAmount;
    }
}
