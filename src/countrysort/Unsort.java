/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package countrysort;

/**
 *
 * @author Bruce
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Unsort {
    
    public static void main(String [] args) throws Exception {
        
        Scanner stdIn = new Scanner(new File("C:\\Users\\Bruce\\Desktop\\Java\\CountrySort\\src\\countrysort\\CountrySortedFormat.txt"));
        PrintWriter out = new PrintWriter("C:\\Users\\Bruce\\Desktop\\Java\\CountrySort\\src\\countrysort\\CountryUnsortedFormat.txt");
        int k = 0;
        //String line[] = new String[240];  
        ArrayList<String> line = new ArrayList<String>();
        ArrayList<String> newLine = new ArrayList<String>();
        Random rand = new Random();

        while (stdIn.hasNextLine() != false) {
            line.add(stdIn.nextLine());
        }
        
        for(int i = 0; 0<line.size(); ){
            int temp = rand.nextInt(line.size());
            newLine.add(line.get(temp));
            line.remove(temp);
            out.println(newLine.get(i));
            System.out.println(newLine.get(i));
            i++;
        }
        out.close();
    }
    
}
