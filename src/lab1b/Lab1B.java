/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1b;

import java.util.Scanner;

/**
 * <pre>
 * Author:        Stefan Kupych 000334450
 * Date created:  January 17, 2014
 * Last modified: January 17, 2014
 * Purpose:       This program will accept a currency amount from the user of
 *                $100 or less, make change for $100 and output the amount in
 *                denominations of $20, $10, $5, $2, $1, quarters, dimes,
 *                nickels and pennies.
 * </pre>
 *
 * @author stefankupych
 */
public class Lab1B {

  /**
   * @param args the command line arguments are not used in this program
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    /**
     * To avoid rounding errors, integers will be used and all inputs will be
     * multiplied by 100 and the output of total change will be divided by 100
     * for display purposes.
     */
    int change; //initializing change value
    int[] money = new int[9]; //initializing placeholder for denominations
    String[] moneyNames = {"$20 bills", "$10 bills", "$5 bills", "$2 coins",
      "$1 coins", "quarters", "dimes", "nickels", "pennies"}; //initializing denomination name array
    int[] moneyValues = {2000, 1000, 500, 200, 100, 25, 10, 5, 1}; //initializing denomination values in cents
    System.out.print("Enter the price of the purchase: $");
    while (input.hasNextFloat()) {
      change = (int) (10000 - (input.nextFloat() * 100));
      if (change > 10000 || change < 0) {
        System.err.println("Error: price is outside of range!");
      } else {
        System.out.printf("The change from $100.00 is $%.2f\n", (float) change / 100);
      }
      for (int i = 0; i < 9; i++) {
        money[i] = change / moneyValues[i];
        if (money[i] > 0) {
          System.out.printf("Number of %s is: %d\n", moneyNames[i], money[i]);
        }
        change %= moneyValues[i];
      }
      System.out.print("\nInput new price (or q to quit): $");
    }
  }
}
