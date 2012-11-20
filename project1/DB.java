/**
 * DB.java
 * @author Eddie Austin
 * @version 1.0
 */

import java.sql.*;
import java.util.ArrayList;

public class DB {
  private Connection connect = null;
  private String dbURL = "jdbc:mysql://localhost/austinen02";
  private String username = "austinen02";
  private String password = "austinen02";

  public DB() {

    getConnection();
  }

  private void getConnection()
  {
    try
    {
      connect = DriverManager.getConnection(dbURL, username, password);
    }
    catch (SQLException e)
    {
      System.out.println("Exception thrown calling getConnection.\n" + e.getMessage());
    }
  }
/**
 *  Inserts a customer into the customer table
 * @param Customer object
 * @return String result saying customer was added
 */
  public String addCustomer(Customer c)
  {
    String result = "";
    PreparedStatement ps = null;
    try
    {
      String q = "insert into customer (custId, firstName, lastName, phone) "
        + "values (null, ?, ?, ?)";
      ps = connect.prepareStatement(q);
      ps.setString(1, c.getFirstName());
      ps.setString(2, c.getLastName());
      ps.setString(3, c.getPhone());
      ps.executeUpdate();
      result = c.getFirstName() + " " + c.getLastName() + " has been added.";
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }
    return result;
  }
/**
 *  Returns an ArrayList of all customers
 * @param int order by
 * @param int record to start at
 * @param int number of records to display
 * @return an ArrayList of customer objects
 */
  public ArrayList<Customer> listCustomers(int orderBy,
      int startRecord, int numberToDisplay)
  {
    ArrayList<Customer> cList = new ArrayList<Customer>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      String q = "";
      if (1==orderBy)
      {
        q = "select custId, firstName, lastName, phone from customer "
          + "order by custId limit ?, ?";
      }
      else
      {
        q = "select custId, firstName, lastName, phone from customer "
          + "order by lastName, firstName limit ?, ?";
      }
      ps = connect.prepareStatement(q);
      ps.setInt(1, startRecord-1);
      ps.setInt(2, numberToDisplay);
      rs = ps.executeQuery();

      while (rs.next())
      {
        cList.add( new Customer(
              rs.getInt("custId"), rs.getString("firstName"),
              rs.getString("lastName"), rs.getString("phone") ) );
      }
      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }

    return cList;
  }
/**
 * Returns an arraylist of customers by name
 * @param String first name of customer
 * @param String last name of customer
 * @return an ArrayList of customer objects
 */
  public ArrayList<Customer> findCustomerByName(String first, String last)
  {
    ArrayList<Customer> cList = new ArrayList<Customer>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      String q = "select custId, firstName, lastName, phone from customer "
          + "where firstName like ? and lastName like ? order by custId";
      ps = connect.prepareStatement(q);
      ps.setString(1, first + "%");
      ps.setString(2, last + "%");
      rs = ps.executeQuery();

      while (rs.next())
      {
        cList.add( new Customer(
              rs.getInt("custId"), rs.getString("firstName"),
              rs.getString("lastName"), rs.getString("phone") ) );
      }
      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }

    return cList;
  }
/**
 * Inserts a contractor into the contractor table
 * @param Contractor object
 * @return String result saying contractor was added
 */
  public String addContractor(Contractor ct)
  {
    String result = "";
    PreparedStatement ps = null;
    try
    {
      String q = "insert into contractor (contractorId, name, conPhone) "
        + "values (null, ?, ?)";
      ps = connect.prepareStatement(q);
      ps.setString(1, ct.getName());
      ps.setString(2, ct.getConPhone());
      ps.executeUpdate();
      result = ct.getName() + " has been added.";
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }
    return result;
  }
/**
 * Returns an ArrayList of all contractors
 * @param int order by
 * @param int record to start at
 * @param int number of records to display
 * @return an ArrayList of contracotr objects
 */
  public ArrayList<Contractor> listContractors(int orderBy,
      int startRecord, int numberToDisplay)
  {
    ArrayList<Contractor> ctList = new ArrayList<Contractor>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      String q = "";
      if (1==orderBy)
      {
        q = "select contractorId, name, conPhone from contractor "
          + "order by contractorId limit ?, ?";
      }
      else
      {
        q = "select contractorId, name, conPhone from contractor "
          + "order by contractorId limit ?, ?";
      }
      ps = connect.prepareStatement(q);
      ps.setInt(1, startRecord-1);
      ps.setInt(2, numberToDisplay);
      rs = ps.executeQuery();

      while (rs.next())
      {
        ctList.add( new Contractor(
              rs.getInt("contractorId"), rs.getString("name"),
              rs.getString("conPhone") ) );
      }
      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }

    return ctList;
  }
/**
 * Returns an arraylist of contractors by name
 * @param String name of contractor
 * @return an ArrayList of contractor objects
 */
  public ArrayList<Contractor> findContractorByName(String contractor)
  {
    ArrayList<Contractor> ctList = new ArrayList<Contractor>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {

      String q = "select contractorId, name, conPhone from contractor "
          + "where name like ? order by contractorId";
      ps = connect.prepareStatement(q);
      ps.setString(1, contractor + "%");
      rs = ps.executeQuery();

      while (rs.next())
      {
        ctList.add( new Contractor(
              rs.getInt("contractorId"), rs.getString("name"),
              rs.getString("conPhone") ) );
      }
      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }

    return ctList;
  }
/**
 * Adds a new project
 * @param Project object
 */
  public void addProject(Project project)
  {
    String result = "", q = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    try
    {
      q = "insert into project (projId, buildingType, priceEst, dateStarted, dateCompleted, custId) "
        + "values (null, ?, ?, ?, null, ?)";
      ps = connect.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, project.getBuildingType());
      ps.setDouble(2, project.getPriceEst());
      ps.setString(3, project.getDateStarted());
      ps.setInt(4, project.getCustId());
      ps.executeUpdate();

      rs = ps.getGeneratedKeys();
      int projectId = -1;
      if (rs.next())
      {
        projectId = rs.getInt(1);

        q = "insert into tasks (taskId, contractorId, projId, price) "
          + "values (null, ?, ?, ?)";
        ps = connect.prepareStatement(q);

        for (Task task : project.getTasks())
        {
          ps.setInt(1, task.getContractorId());
          ps.setInt(2, projectId);
          ps.setDouble(3, task.getPrice());
          ps.executeUpdate();
        }
      }
      else System.out.println("Error getting projectId");
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }
  }
/**
 * Inserts a task into the task table
 * @param Task object
 * @return String result saying task was added
 */
  public String addTask(Task t)
  {
    String result = "";
    PreparedStatement ps = null;
    try
    {
      String q = "insert into tasks (taskId, contractorId, projId, price) "
        + "values (null, ?, ?, ?)";
      ps = connect.prepareStatement(q);
      ps.setInt(1, t.getContractorId());
      ps.setInt(2, t.getProjId());
      ps.setDouble(3, t.getPrice());
      ps.executeUpdate();
      result = t.toString() + " has been added.";
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }
    return result;
  }

/**
 * Returns an ArrayList of all projects
 * @param int order by
 * @param int record to start at
 * @param int number of records to display
 * @return an ArrayList of project objects
 */
  public ArrayList<Project> listProjects(int orderBy,
      int startRecord, int numberToDisplay)
  {
    ArrayList<Project> pList = new ArrayList<Project>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try
    {
      String q = "";
      if (1==orderBy)
      {
        q = "select projId, buildingType, priceEst, dateStarted, dateCompleted, custId from project "
          + "order by projId limit ?, ?";
      }
      else
      {
        q = "select projId, buildingType, priceEst, dateStarted, dateCompleted, custId from project "
          + "order by projId limit ?, ?";
      }
      ps = connect.prepareStatement(q);
      ps.setInt(1, startRecord-1);
      ps.setInt(2, numberToDisplay);
      rs = ps.executeQuery();

      while (rs.next())
      {
        pList.add( new Project(
              rs.getInt("projId"), rs.getString("buildingType"), rs.getDouble("priceEst"), rs.getString("dateStarted"), rs.getString("dateCompleted"),
              rs.getInt("custId") ) );
      }
      rs.close();
      ps.close();
    }
    catch (SQLException e)
    {
      System.out.println("SQLException: " + e.getMessage());
      System.out.println("\nQUERY: " + ps.toString());
    }

    return pList;
  }

 public static void main(String[] args) throws Exception
  {
    DB mydb = new DB();

    ArrayList<Contractor> ctList = mydb.listContractors(2, 1, 20);

    for (Contractor ct : ctList)
    {
      System.out.printf("%10s, %20s, %20s, %15s\n",
          ct.getContractorId(), ct.getName(), ct.getConPhone());
    }
  }
}
