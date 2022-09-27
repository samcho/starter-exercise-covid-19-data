import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.*;

public class covid {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        System.out.println("COVID variants filename?: ");
        String inputFileName = scnr.nextLine();

        // For file input
        String fileName;
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream); //

        // ignore first line
        inputFileNameScanner.nextLine();


        // TODO obtain parsing keywords (country, variant) for selecting lines

        System.out.println("Country: ");
        String country = scnr.nextLine();

        System.out.println("Variant: ");
        String variant = scnr.nextLine();


        while (inputFileNameScanner.hasNext()) {
            String line = inputFileNameScanner.nextLine();
            String[] parts = line.split(","); // split the string into multiple parts

            for (int i = 0; i< parts.length; i++) {
                if(parts[i].equals(country)){
                    if(parts[i+2].equals(variant)){
                        System.out.println(parts[i+1] + " "+parts[i+4]);
                    }
                }
            }
            // TODO: print out the date and perc_sequences for the selected lines
            // System.out.println(parts);
        }
        inputFileNameStream.close();
    }
}
