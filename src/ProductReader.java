import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class ProductReader {


        public static void main(String[] args) {

            JFileChooser chooser = new JFileChooser();
            Scanner scanner = new Scanner(System.in);
            String rec = "";

            try {
                File workingDirectory = new File(System.getProperty("user.dir"));
                chooser.setCurrentDirectory(workingDirectory);
                if (chooser.showOpenDialog((Component) null) == 0) {
                    File selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();
                    InputStream in = new BufferedInputStream(Files.newInputStream(file, StandardOpenOption.CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    int line = 0;

                    while (reader.ready()) {
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

