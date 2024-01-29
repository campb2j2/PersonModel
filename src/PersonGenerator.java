import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // Construct the path to the src directory
        Path file = Paths.get(System.getProperty("user.dir"), "src", "personData.txt");

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
        String personRec;
        String ID, firstName, lastName, title;
        int YOB;

        do {
            ID = SafeInput.getNonZeroLenString( in, "Enter the ID [6 digits]");
            firstName = SafeInput.getNonZeroLenString(in, "Enter the first name");
            lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
            title = SafeInput.getNonZeroLenString(in, "Enter the title");
            YOB = SafeInput.getRangedInt(in, "Enter the year of birth", 1000, 9999);

            personRec = ID + "; " + firstName + "; " + lastName + "; " + title + "; " + YOB;
            folks.add(personRec);
            done = SafeInput.getYNConfirm(in, "Are you done?");

        } while (!done);

        for (String p : folks) {
            System.out.println(p);
        }

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file
            for (String rec : folks) {
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
