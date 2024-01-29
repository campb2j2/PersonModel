import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class PersonReader {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();
        Scanner scanner = new Scanner(System.in);
        String rec = "";

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog((Component)null) == 0) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                int line = 0;

                while(reader.ready()) {
                    rec = reader.readLine();
                    ++line;
                    System.out.printf("\nLine %4d %-60s ", line, rec);
                }

                reader.close();
                System.out.println("\n\nData file read!");
            }
        } catch (FileNotFoundException var9) {
            System.out.println("File not found!!!");
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

    }
}








/*import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JFileChooser;

public class NIOReadTextFile {
    public NIOReadTextFile() {
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        String rec;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);
            if (chooser.showOpenDialog((Component)null) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.READ));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                System.out.printf("%-6s %-12s %-12s %-6s %-4s%n", "ID", "First Name", "Last Name", "Title", "YOB");
                System.out.println("---------------------------------------------------------------");

                while(reader.ready()) {
                    rec = reader.readLine();
                    String[] personData = rec.split("; ");
                    if (personData.length == 5) {
                        System.out.printf("%-6s %-12s %-12s %-6s %-4s%n",
                                personData[0].trim(), // ID
                                personData[1].trim(), // First Name
                                personData[2].trim(), // Last Name
                                personData[3].trim(), // Title
                                personData[4].trim()); // Year of Birth
                    } else {
                        System.out.println("Invalid data format in file: " + rec);
                    }
                }

                reader.close();
                System.out.println("\nData file read!");
            }
        } catch (FileNotFoundException var9) {
            System.out.println("File not found!!!");
            var9.printStackTrace();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

    }
}
*/