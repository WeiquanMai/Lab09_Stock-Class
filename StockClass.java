/*
 * CSC-239 JAVA
 * Project Name: StockClass
 * Student: Weiquan Mai
 * Date: March 10, 2025
 * Description: This project prompts user to enter information regarding a stock, and then creates a stock object.
 * The program then calculates the percent change from previous closing price to current price.
 */

import java.util.Scanner;

public class Lab9a{
    // Main method
    public static void main(String[] args){
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Variables
        double previous;
        double current;
        boolean keepRunning = true;

            // Use while(keepRunning) to keep running loop until q is pressed
            while (keepRunning){
            System.out.print("Enter stock Symbol (or 'q' to exit): ");
            String symbol = input.nextLine();
            
            // if q or Q is pressed, change keepRunning to false and exit loop
            if(symbol.equalsIgnoreCase("q")){
                keepRunning = false;
            }
            else{
                // Obtain input for company name, previous closing price, and current price
                System.out.print("Enter company name: ");
                String name = input.nextLine();
                System.out.print("Enter previous closing price: ");
                String previousClosingPrice = input.nextLine();
                previous = Double.parseDouble(previousClosingPrice);
                System.out.print("Enter current price: ");
                String currentPrice = input.nextLine();
                current = Double.parseDouble(currentPrice);

                // Create instance of stock class using obtained values
                Stock myStock = new Stock (symbol, name, previous, current);
                // Call getChangePercent() method
                myStock.getChangePercent();
                //System.out.printf obtained and calculated information
                System.out.printf("SYMBOL=%s, NAME=%s, PreviousPrice=%.2f, CurrentPrice=%.2f, PercentChange=%.2f%%",
                myStock.getSymbol(),
                myStock.getName(),
                myStock.getPreviousClosingPrice(),
                myStock.getCurrentPrice(),
                myStock.getChangePercent());
                System.out.println();
    
            } // End of if-else loop
        }// End of while loop

        // Close the scanner
        input.close();

        // Exiting the program
        System.out.print("Exiting program...");
    }// End of main method
}// End of public class Lab9a

class Stock{
    private String symbol;
    private String name;
    public double previousClosingPrice;
    public double currentPrice;

    // No-args constructor
    public Stock(){}
    // Constructor
    public Stock(String s, String n, double p, double c){
        symbol = s;
        name = n;
        previousClosingPrice = p;
        currentPrice = c;
    }
    public String getSymbol(){
        return symbol;
    }
    public String getName(){
        return name;
    }
    public double getPreviousClosingPrice(){
        return previousClosingPrice;
    }
    public double getCurrentPrice(){
        return currentPrice;
    }
    public void setPreviousClosingPrice(double p){
        previousClosingPrice = p;
    }
    public void setCurrentPrice (double c){
        currentPrice = c;
    }

    public double getChangePercent(){
        return (((currentPrice-previousClosingPrice) / previousClosingPrice)*100);
    }
} // End of class Stock
