public class Product {
    private String name;
    private String description;
    private final String ID;
    private double cost;

    // Constructor
    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getID() {
        return ID;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    // Method to convert to CSV format
    public String toCSVDataRecord() {
        return name + "," + description + "," + ID + "," + cost;
    }
    public String toJSONDataRecord() {
        String retString = "";
        char DQ = '\u0022'; // Double quote character
        retString += DQ + "name" + DQ + ":" + DQ + name + DQ + ",";
        retString += DQ + "description" + DQ + ":" + DQ + description + DQ + ",";
        retString += DQ + "ID" + DQ + ":" + DQ + ID + DQ + ",";
        retString += DQ + "cost" + DQ + ":" + cost;
        return retString;


    }
}
