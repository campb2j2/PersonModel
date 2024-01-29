import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {


        public static void main(String[] args) {
            ArrayList<String> products = new ArrayList<>();
            Scanner in = new Scanner(System.in);

            // Construct the path to the src directory
            Path file = Paths.get(System.getProperty("user.dir"), "src", "ProductTestData.txt");

            // Ensure the src directory exists
            try {
                if (!Files.exists(file.getParent())) {
                    Files.createDirectories(file.getParent());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            boolean done = false;
            String productRec;
            String ID, prodName, prodDesc;
            double cost;
            

            do {
                ID = SafeInput.getNonZeroLenString( in, "Enter the ID [6 digits]");
                prodName = SafeInput.getNonZeroLenString(in, "Enter the product name");
                prodDesc = SafeInput.getNonZeroLenString(in, "Enter the product description");
                cost = SafeInput.getDouble(in, "Enter the cost");

                productRec = ID + "; " + prodName + "; " + prodDesc + "; " + cost;
                products.add(productRec);
                done = SafeInput.getYNConfirm(in, "Are you done?");

            } while (!done);

            for (String p : products) {
                System.out.println(p);
            }

            try {
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

                // Finally can write the file
                for (String rec : products) {
                    writer.write(rec, 0, rec.length());  // Write the record
                    writer.newLine();  // Add the new line
                }
                writer.close(); // Must close the file to seal it and flush buffer
                System.out.println("File written to " + file);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    //000001, Bilbo, Baggins, Esq., 1060
//000002, Frodo, Baggins, Esq., 1120
//000003, Samwise, Gamgee, Esq., 1125
//000004, Peregrin, Took, Esq., 1126
//000005, Meridoc, Brandybuck, Esq., 1126


