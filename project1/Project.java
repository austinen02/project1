/**
 * Project.java
 * @author Eddie Austin
 * @version 1.0
 */

import java.util.*;

public class Project
{
  int projId;
  String buildingType;
  double priceEst;
  String dateStarted;
  String dateCompleted;
  int custId;
  ArrayList<Task> tasks;

  public Project (int pid, String bt, double pe, String ds, String dc, int cid,  ArrayList<Task> t)
  {
    projId = pid;
    buildingType = bt;
    priceEst = pe;
    dateStarted = ds;
    dateCompleted = dc;
    custId = cid;
    tasks = t;
  }

  public Project (int pid, String bt, double pe, String ds, String dc, int cid)
  {
    projId = pid;
    buildingType = bt;
    priceEst = pe;
    dateStarted = ds;
    dateCompleted = dc;
    custId = cid;
  }

  /**
   * @return projId
   */  
  public int getProjId()
  {
    return projId;
  }  

  /**
   * @return buildingType
   */  
  public String getBuildingType()
  {
    return buildingType;
  }

  /**
   * @return priceEst
   */  
  public double getPriceEst()
  {
    return priceEst;
  }

  /**
   * @return dateStarted
   */
  public String getDateStarted()
  {
    return dateStarted;
  }

  /**
   * @return dateCompleted
   */
  public String getDateCompleted()
  {
    return dateCompleted;
  }
  /**
   * @return custId
   */
  public int getCustId()
  {
    return custId;
  }
  /**
   * @return tasks
   */
  public ArrayList<Task> getTasks()
  {
    return tasks;
  }

  /**
   * @return projId
   * @return buildingtype
   * @return priceEst
   * @return dateStarted
   * @return dateCompleted
   * @return custId
   */  
  public String toString()
  {
    return projId + ", " + buildingType + ", " + priceEst + ", " + dateStarted + ", " 
      + dateCompleted + ", " + custId;
  }
}
