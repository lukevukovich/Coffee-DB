import java.sql.*;

public class UnpaidOrder
{

    public static void main(String[] args)
    {
       try
       {
           final String DB_URL = "jdbc:derby:CoffeeDB";
           Connection conn = DriverManager.getConnection(DB_URL);
           Statement statement = conn.createStatement(1005, 1007);

           System.out.println("Connected to database\n");

           String getCost = ("SELECT Cost FROM UnpaidOrder");
           ResultSet result = statement.executeQuery(getCost);

           //Inserting rows into UnpaidOrder table to use for example
           CoffeeDBManager.submitOrder("103", "14-001", 4, 10.00, "6-20-2022");
           CoffeeDBManager.submitOrder("104", "15-003", 6, 12.00, "5-4-2022");

           double runningCost = 0;
           while (result.next())
           {
               runningCost += result.getDouble("Cost");
           }

           System.out.printf("Unpaid order sum: $%.2f\n", runningCost);
           conn.close();
       }
       catch (SQLException e)
       {
           System.out.println("\nError: "  + e.getMessage());
       }
    }

}
