/**
 * Contractor.java
 * @author Eddie Austin
 * @version 1.0
 */

public class Contractor
{
  int contractorId;
  String name;
  String conPhone;
  
  public Contractor(int cid, String n, String cp)
  {
    contractorId = cid;
    name = n;
    conPhone = cp;
  }

  /**
   * @return contractorId
   */
  public int getContractorId()
  {
    return contractorId;
  }

  /**
   * @return contractorId
   */
  public String getName()
  {
    return name;
  }
  
  /**
   * @return contractorId
   */
  public String getConPhone()
  {
    return conPhone;
  }
  /**
   * @return contractorId
   * @return name
   * @return conPhone
   */
  public String toString()
  {
    return contractorId + ", " + name + ", " + conPhone;
  }
}
