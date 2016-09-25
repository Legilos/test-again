/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countrysort;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bruce
 */
public class Sorting {

     public static <T extends Comparable<? super T>> void main(String[] args) throws Exception {
        // TODO code application logic here

        Scanner stdIn = new Scanner(new File("C:\\Users\\Bruce\\Desktop\\Java\\CountrySort\\src\\countrysort\\CountryUnsortedFormat.txt"));
        Pattern num = Pattern.compile("(\\d)");
        Pattern let = Pattern.compile("(\\D)");

        int line[] = new int[238];
        String name[] = new String[238];
        int count = 0;

        while (stdIn.hasNextLine() != false) {
            //line.add(stdIn.nextLine());
            String in = "";
            String letIn = "";
            String temp = stdIn.nextLine();
            Matcher m = num.matcher(temp);
            Matcher m2 = let.matcher(temp);
            while (m.find()) {
                in = in.concat(m.group());
            }
            while (m2.find()) {
                letIn = letIn.concat(m2.group());
                letIn = letIn.replace(",", "");
                letIn = letIn.trim();
            }
            int parser = Integer.parseInt(in);
            line[count] = parser;
            name[count] = letIn;
            //System.out.println(line[count]);
            //System.out.println(name[count]);
            count++;
        }

        //shell sort
        int j;
        for (int gap = line.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < line.length; i++) {
                int tmp = line[ i];
                String temp = name [i];
                for (j = i; j >= gap && tmp - (line[ j - gap]) < 0; j -= gap) {
                    line[ j] = line[ j - gap];
                    name[ j] = name[ j - gap];
                }
                line[ j] = tmp;
                name[ j] = temp;
            }
        }

        for (int i = 0; i < line.length; i++) {
            System.out.println(name[i] + " " + line[i]);
        }
    }

    }
