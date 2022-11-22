import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerInserter
{

    public static void main(String[] args)
    {
        try
        {
            final String DB_URL = "jdbc:derby:CoffeeDB";
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement statement = conn.createStatement(1005, 1007);

            System.out.println("Connected to database\n");

            Scanner input = new Scanner(System.in);

            System.out.print("Enter Customer Number: ");
            String number = input.nextLine();

            System.out.print("Enter Name:  ");
            String name = input.nextLine();

            System.out.print("Enter Address: ");
            String address = input.nextLine();

            System.out.print("Enter City: ");
            String city = input.nextLine();

            System.out.print("Enter State:  ");
            String state = input.nextLine();

            System.out.print("Enter Zipcode: ");
            String zip = input.nextLine();

            final String SQL_STMT = String.format("UPDATE Customer SET ( '%s', '%s', '%s', '%s', '%s', '%s' )", number, name, address, city, state, zip);
            statement.executeUpdate(SQL_STMT);

            System.out.println("\nRow successfully added");
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("\nError: " + e.getMessage());
        }
    }

}
