/**
 * Validator.java
 * @author Eddie Austin
 * @version 1.0
 */

// Validator.java prompts and validates console input.
// Based on code from Murach's Java with a few changes.
// Ranges are inclusive. Changes by Phillips on 9/3/12.

import java.util.Scanner;

public class Validator
{
/**
 * Returns a string and stores string entered by user
 * @param Scanner object
 * @param String prompt
 * @return String response
 */
  public static String getString(Scanner sc, String prompt)
  {
    System.out.print(prompt);
    String s = sc.next();		// read the first string on the line
    sc.nextLine();				// discard any other data entered on the line
    return s;
  }
/**
 * Returns a string object
 * @param Scanner object
 * @param String prompt
 * @return String response
 */
  public static String getLine(Scanner sc, String prompt)
  {
    System.out.print(prompt);
    String s = sc.nextLine();
    return s;
  }
/**
 * Returns an integer
 * @param Scanner object
 * @param String prompt
 * @return int value entered by user
 */ 
  public static int getInt(Scanner sc, String prompt)
  {
    boolean isValid = false;
    int i = 0;
    while (isValid == false)
    {
      System.out.print(prompt);
      if (sc.hasNextInt())
      {
        i = sc.nextInt();
        isValid = true;
      }
      else
      {
        System.out.println("Error! Invalid integer value. Try again.");
      }
      sc.nextLine();
    }
    return i;
  }
 /**
  * Returns an integer
  * @param Scanner object
  * @param String prompt
  *  @return int response
  */
  public static int getInt(Scanner sc, String prompt,
      int min, int max)
  {
    int i = 0;
    boolean isValid = false;
    while (isValid == false)
    {
      i = getInt(sc, prompt);
      if (i < min)
        System.out.println(
            "Error! Number must be greater than or equal to " + min);
      else if (i > max)
        System.out.println(
            "Error! Number must be less than or equal to " + max);
      else
        isValid = true;
    }
    return i;
  }
/**
 * Returns a double
 * @param Scanner object
 * @param String prompt
 * @return double response
 */
  public static double getDouble(Scanner sc, String prompt)
  {
    boolean isValid = false;
    double d = 0;
    while (isValid == false)
    {
      System.out.print(prompt);
      if (sc.hasNextDouble())
      {
        d = sc.nextDouble();
        isValid = true;
      }
      else
      {
        System.out.println("Error! Invalid decimal value. Try again.");
      }
      sc.nextLine();
    }
    return d;
  }
/**
 * Returns a double
 * @param Scanner object
 * @param String prompt
 * @return double response
 */
  public static double getDouble(Scanner sc, String prompt,
      double min, double max)
  {
    double d = 0;
    boolean isValid = false;
    while (isValid == false)
    {
      d = getDouble(sc, prompt);
      if (d < min)
        System.out.println(
            "Error! Number must be greater than or equal to " + min);
      else if (d > max)
        System.out.println(
            "Error! Number must be less than or equal to " + max);
      else
        isValid = true;
    }
    return d;
  }

}
