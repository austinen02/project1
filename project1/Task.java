/**
 * Task.java
 * @author Eddie Austin
 * @version 1.0
 */

import java.util.*;

public class Task
{
  int taskId;
  int contractorId;
  int projId;
  double price;

  public Task (int tid, int cid, int pid, double p)
  {
    taskId = tid;
    contractorId = cid;
    projId = pid;
    price = p;
  }

  /**
   * @return taskId
   */
  public int getTaskId()
  {
    return taskId;
  }  

  /**
   * @return contractorId
   */
  public int getContractorId()
  {
    return contractorId;
  }

  /**
   * @return projId
   */
  public int getProjId()
  {
    return projId;
  }

  /**
   * @return price
   */
  public double getPrice()
  {
    return price;
  }
  /**
   * @return taskId
   * @return contractorId
   * @return projId
   * @return price
   */
  public String toString()
  {
    return taskId + ", " + contractorId + ", " + projId + ", " + price;
  }
}
