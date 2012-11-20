/**
 * StoreApp.java
 * @author Eddie Austin
 * @version 1.0
 */
import java.sql.*;
import java.util.*;
import java.text.*;

public class StoreApp
{
  DB mydb;
  Scanner sc;

  public StoreApp()
  {
    mydb = new DB();
    sc = new Scanner(System.in);
  }

  public void showMenu()
  {
    System.out.println();
    System.out.println("1 = Add customer");
    System.out.println("2 = List customers");
    System.out.println("3 = Find customer");
    System.out.println("4 = Add contractor");
    System.out.println("5 = List contractors");
    System.out.println("6 = Find contractor");
    System.out.println("7 = Make a project");
    System.out.println("8 = Add Task");
    System.out.println("9 = List Projects");
    System.out.println("0 = Quit");
  }

  public void mainLoop() throws Exception
  {
    int choice = 999;
    while (choice != 0) {
      showMenu();
      choice = Validator.getInt(sc, "Enter choice: ", 0, 10);
      if (1 == choice) addCustomer();
      else if (2 == choice) listCustomers();
      else if (3 == choice) findCustomerByName();
      else if (4 == choice) addContractor();
      else if (5 == choice) listContractors();
      else if (6 == choice) findContractorByName();
      else if (7 == choice) makeProject();
      else if (8 == choice) addTask();
      else if (9 == choice) listProjects();
      else if (0 == choice) ;
      else System.out.println("\nInvalid Choice. Please try again.\n");
    }
  }

  public void addCustomer()
  {
    int custId = 0;
    String first = Validator.getLine(sc, "Enter customer first name: ");
    String last  = Validator.getLine(sc, "Enter last name: ");
    String phone = Validator.getLine(sc, "Enter phone number (111-222-3333): ");
    Customer c = new Customer(custId, first, last, phone);
    String result = mydb.addCustomer(c);
    System.out.println(result);
  }

  public void listCustomers()
  {
    int orderBy =
      Validator.getInt(sc, "1 = sort by custId, 2 = sort by name: ", 1, 2);
    int startRecord =
      Validator.getInt(sc, "Index of starting record: ", 1, 999999999);
    int numberToDisplay =
      Validator.getInt(sc, "How many records to display: ", 1, 999999999);

    ArrayList<Customer> cList =
      mydb.listCustomers(orderBy, startRecord, numberToDisplay);

    for (Customer c : cList)
    {
      System.out.printf("%-10s %-20s %-20s %-15s\n",
          c.getCustId(), c.getFirstName(), c.getLastName(), c.getPhone());
    }
  }

  public void findCustomerByName()
  {
    String first = Validator.getLine(sc, "Enter customer first name: ");
    String last  = Validator.getLine(sc, "Enter last name: ");

    ArrayList<Customer> cList = mydb.findCustomerByName(first, last);

    for (Customer c : cList)
    {
      System.out.printf("%-10s %-20s %-20s %-15s\n",
          c.getCustId(), c.getFirstName(), c.getLastName(), c.getPhone());
    }
  }

  public void addContractor()
  {
    int ContractorId = 0;
    String name = Validator.getLine(sc, "Enter contractor name: ");
    String conPhone  = Validator.getLine(sc, "Enter contractor phone number (111-222-3333): ");
    Contractor ct = new Contractor(ContractorId, name, conPhone);
    String result = mydb.addContractor(ct);
    System.out.println(result);
  }

  public void listContractors()
  {
    int orderBy =
      Validator.getInt(sc, "1 = sort by ContractorId, 2 = sort by name: ", 1, 2);
    int startRecord =
      Validator.getInt(sc, "Index of starting record: ", 1, 999999999);
    int numberToDisplay =
      Validator.getInt(sc, "How many records to display: ", 1, 999999999);

    ArrayList<Contractor> ctList =
      mydb.listContractors(orderBy, startRecord, numberToDisplay);

    for (Contractor ct : ctList)
    {
      System.out.printf("%-10s %-20s %-20s \n",
          ct.getContractorId(), ct.getName(), ct.getConPhone());
    }
  }

  public void findContractorByName()
  {
    String name = Validator.getLine(sc, "Enter contractor name: ");

    ArrayList<Contractor> ctList = mydb.findContractorByName(name);

    for (Contractor ct : ctList)
    {
      System.out.printf("%-10s %-20s %-20s \n",
          ct.getContractorId(), ct.getName(), ct.getConPhone());
    }
  }

  public void makeProject()
  {
    int contractorId, custId, count=0;
    double priceEst;
    String buildingType;
    String dateStarted;
    String choice = "y", customer, date;
    ArrayList<Task> tasks = new ArrayList<Task>();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    custId = Validator.getInt(sc, "Enter customer id: ", 1, 999999999);
    dateStarted = sdf.format(new java.util.Date());
    buildingType = Validator.getLine(sc, "Building Type: ");
    priceEst = Validator.getDouble(sc, "Price: ", 0.00, 999999999.99);
    choice = Validator.getLine(sc, "Would you like to add a task to the project (y/n)? ");
     while (choice.equalsIgnoreCase("y"))
    {
      contractorId = Validator.getInt(sc, "Contractor id: ",  1, 999999999);
      double taskPrice = Validator.getDouble(sc, "Price: ", 0.00, 999999999.99);
      tasks.add(new Task(0, contractorId, 0, taskPrice));
     choice = Validator.getLine(sc, "Add another task (y/n)? ");
    }

    Project project = new Project(0, buildingType, priceEst, dateStarted, null, custId, tasks);
    mydb.addProject(project);
  }

  public void addTask()
  {
    int taskId = 0;
    int contractorId = Validator.getInt(sc, "Enter contractor ID: ");
    int projId  = Validator.getInt(sc, "Enter project ID: ");
    double price = Validator.getDouble(sc, "Enter price: ", 0.00, 999999999.99);
    Task t = new Task(taskId, contractorId, projId, price);
    String result = mydb.addTask(t);
  }

  public void listProjects()
  {
    int orderBy = 1;
    int startRecord = 1;
    int numberToDisplay = 20;

    ArrayList<Project> pList =
      mydb.listProjects(orderBy, startRecord, numberToDisplay);

      System.out.printf("%-10s %-10s %-10s %-19s %-12s %-10s \n", "ProjectId", "Building Type", "PriceEst", "Date Started", "Date Completed", "CustId");

    for (Project p : pList)
    {
      System.out.printf("%-10s %-13s %-10s %-19s %-16s %-10s \n",
          p.getProjId(), p.getBuildingType(), p.getPriceEst(), p.getDateStarted(), p.getDateCompleted(), p.getCustId());
    }
  }

 public static void main(String[] args) throws Exception
  {
    StoreApp store = new StoreApp();
    store.mainLoop();
  }
}
