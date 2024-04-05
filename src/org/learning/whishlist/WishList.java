package org.learning.whishlist;

import java.sql.SQLOutput;
import java.util.*;

public class WishList {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> wishlist = new ArrayList<>();

        boolean exit = false;

        while(!exit) {
            System.out.print("Insert a gift name: ");
            String gift = scan.nextLine();
            wishlist.add(gift);
            System.out.println("Your wishlist is now composed of " + wishlist.size() + ( wishlist.size() > 1 ?
                    " gifts" : " gift"));
            System.out.println("Gifts in your wishlist: " + wishlist);

            System.out.print("Would you like to continue? Y/N ");
            exit = Objects.equals(scan.nextLine().toUpperCase(), "N");
        }


        Collections.sort(wishlist);

        System.out.println();
        System.out.println("Your wishlist gifts are: ");
        for(String s : wishlist) {
            System.out.println(s);
        }


        scan.close();
    }

}
