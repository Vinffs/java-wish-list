package org.learning.whishlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WishList {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> wishlist = new ArrayList<>();
        boolean exit = false;

        // Create a new file if it doesn't exist
        FileWriter writer = null;
        File data = new File("./resources/data.txt");
        if (!data.exists()) {
            data.createNewFile();
        }

        // Read the file
        Scanner fileReader = null;
        try {
            fileReader = new Scanner(data);
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                wishlist.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }


            while (!exit) {
                System.out.print("Insert a gift name: ");
                String gift = scan.nextLine();
                wishlist.add(gift);
                System.out.println("Your wishlist is now composed of " + wishlist.size() + (wishlist.size() > 1 ? " gifts" : " gift"));
                System.out.println("Gifts in your wishlist: " + wishlist);

                System.out.print("Would you like to continue? Y/N ");
                exit = Objects.equals(scan.nextLine().toUpperCase(), "N");
            }


            Collections.sort(wishlist);

            System.out.println();
            System.out.println("Your wishlist gifts are: ");
            for (String s : wishlist) {
                System.out.println(s);
            }


            // Write in file the array as single string for each element
            try {
                writer = new FileWriter(data);
                for (String gift : wishlist) {
                    writer.write(gift + "\n");
                }

            } catch (IOException e) {
                System.out.println("Unable to open file");
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Unable to close file");
                    }
                }
            }

            scan.close();
        }
    }
}
