//
// Created by Isaias Perez

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class DPOptimization {

    public static void main(String[] args) {
        
        // Terminal Input Setup
        if (args.length > 0) {
            File fileName = new File(args[0]);
            int numHrs = 0; int numProbs = 0;
            ArrayList<Integer> hrs = new ArrayList<Integer>();
            ArrayList<Integer> pts = new ArrayList<Integer>();

            // Process input
            readFile(fileName, numHrs, numProbs, hrs, pts);
           
        } else {
            System.err.println("Input file not specified!, try again");
        }
        
    }
    
    // READS INPUT FILE AND EXECUTES COMMANDS //
    public static void readFile(File fileName, int numHrs, int numProbs, ArrayList<Integer> hrs, ArrayList<Integer> pts) {
        
        try {
            int k; int counter = 1;
            String line;
            Scanner scan = new Scanner(fileName);
                      
            // Get # of problems and # of hours from input file
            line = scan.nextLine();
            numProbs = Integer.parseInt(line);
            line = scan.nextLine();
            numHrs = Integer.parseInt(line);
            System.out.println(fileName + " has " + numProbs + " problems over " + numHrs + " hours");
            System.out.println("Pr#\tTime\tPoints");
            
            // Read the rest of the lines in file
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] command = line.split(" ");
                if (command.length > 0) {
                    System.out.println(counter + "\t" + command[0] + "\t" + command[2]); 
                    hrs.add(Integer.parseInt(command[0]));
                    pts.add(Integer.parseInt(command[2]));
                    counter++;
                }
            }
            
            // Execute DP process
            k = genTable(numProbs, numHrs, hrs, pts);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // HELPER MAX FUNCTION //
    public static int findMax(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
        
    // SCHEDULE LOGIC //
    //---------------//

    // DP SOLUTION // 0-1 Knapsack Problem
    public static int genTable(int numPrbs, int numHrs, ArrayList<Integer> hrs, ArrayList<Integer> pts) {
        // Serves as the DP table
        int[][] k = new int[numPrbs + 1][numHrs + 1];
        
        // Knapsask
        int sack[] = new int[numPrbs];

         // Building DP table from the bottom up
        for (int i = 0; i <= numPrbs; i++) {
            for (int w = 0; w <= numHrs; w++) {

                // Base Case - Initialization
                if (i == 0 || w == 0) {
                    k[i][w] = 0;

                // Current problem does not exceed max hours 
                } else if (hrs.get(i-1) <= w) {     
                    k[i][w] = findMax(pts.get(i-1) + k[i-1][w - hrs.get(i-1)], k[i-1][w]);
                    
                } else {
                    k[i][w] = k[i-1][w];
                        
                }
            }
        }


        // Traverse back and collect items in knapsack
        int temp1 = numPrbs; int temp2 = numHrs; int sackIndex = 0;
        while (numPrbs > 0) {

            // Detects when it should account for a problem in the sack
            if (k[numPrbs][numHrs] != k[numPrbs-1][numHrs]) {
                sack[sackIndex] = numPrbs;  
                sackIndex++; numPrbs--;  
                numHrs = numHrs - hrs.get(numPrbs);
            } else {
                numPrbs--;
            }
        }


        // Output optimal items
        System.out.println("\nThe selected  problems for the highest contest score are: ");
        System.out.println("\tProblem\tPoints");
        for (int x = sackIndex - 1; x >= 0; x--) {
            System.out.println("\t" + sack[x] + "\t" + pts.get((int)sack[x]-1));
        }
        System.out.println("\nTarget problem list yields " + k[temp1][temp2] + " points");
        
        return k[temp1][temp2];

    }

}