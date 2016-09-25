/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countrysort;

import java.io.File;
import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Bruce
 */
public class Hashing {
        public static int hash(String key) {
        String country = key.substring(0, 49).trim();
        int ascii = 0;
        ascii = country.hashCode();

        return abs(ascii % 300);
    }

    ;
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        Scanner stdIn = new Scanner(new File("C:\\Users\\Bruce\\Desktop\\Java\\CountrySort\\src\\countrysort\\CountryUnsortedFormat.txt"));
        Scanner scan = new Scanner(System.in);
        String line[] = new String[300];
        HashMap<String, Integer> hMap = new HashMap<>();
        int count = 0;

        while (stdIn.hasNextLine() != false) {
            line[count] = stdIn.nextLine();
            hMap.put(line[count], hash(line[count]));
        }
        
//        while (iterator.hasNext()) {
//            Map.Entry mentry = (Map.Entry) iterator.next();
//            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
//            System.out.println(mentry.getValue());
//        }

        String input = "y";
        String country = "";
        System.out.println("Would you like to search for a country? y/n");
        input = scan.next();

        while ("y".equals(input)) {
            System.out.println("Enter the name of the country you would like to search for: ");
            country = scan.next();
            Set set = hMap.entrySet();
            Iterator iterator = set.iterator();
            
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                if (country.equals(mentry.getKey().toString().subSequence(0, 49).toString().trim())) {
                //if (hash(country) == hash(mentry.getKey().toString().subSequence(0, 49).toString().trim())) {
                System.out.print("key is: " + mentry.getKey() + " & Value is: ");
                System.out.println(mentry.getValue());
                }
                

            }

            System.out.println("Would you like to search for another country? y/n");
            input = scan.next();
        }

    }
}
