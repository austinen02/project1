/**
 * Customer.java
 * @author Eddie Austin
 * @version 1.0
 */

public class Customer
{
  int custId;
  String firstName;
  String lastName;
  String phone;

  public Customer(int cid, String fn, String ln, String p)
  {
    custId = cid;
    firstName = fn;
    lastName = ln;
    phone = p;
  }
  
  /**
   * @return custId
   */
  public int getCustId()
  {
    return custId;
  }

  /**
   * @return firstName
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * @return lastName
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * @return phone
   */  
  public String getPhone()
  {
    return phone;
  }

  /**
   * @return custId
   * @return firstName
   * @return lastName
   * @return phone
   */  
  public String toString()
  {
    return custId + ", " + firstName + ", " + lastName + ", " + phone;
  }
}
