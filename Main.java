package tkt_booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	 private static Connection connection;

	    public static void main(String[] args) {
	        try {
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tkt_booking", "root", "password1@123");
	        } catch (SQLException e) {
	            System.out.println("Error connecting to database: " + e.getMessage());
	            return;
	        }

	        Scanner scanner = new Scanner(System.in);
	        TktAdmin admin = new TktAdmin();

	        while (true) {
	            System.out.println("Movie Ticket Booking System");
	            System.out.println("-------------------------------");
	            System.out.println("1. authenticate");
	            System.out.println("2. Register");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    admin.authenticate();
	                    break;
	                case 2:
	                    admin.userRegister(null);
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }

	            if (admin.authenticate()) {
	                while (true) {
	                    System.out.println("Movie Ticket Booking System");
	                    System.out.println("-------------------------------");
	                    System.out.println("1. Search Movies");
	                    System.out.println("2. Search Screens");
	                    System.out.println("3. Search Languages");
	                    System.out.println("4. Book Showtime");
	                    System.out.println("5. Logout");
	                    System.out.print("Enter your choice: ");
	                    int choice2 = scanner.nextInt();
	                    scanner.nextLine();

	                    switch (choice2) {
	                        case 1:
	                            admin.searchBymovie();
	                            break;
	                        case 2:
	                            admin.searchByscreen();
	                            break;
	                        case 3:
	                            admin.searchByLanguage();
	                            break;
	                        case 4:
	                            admin.selectShowtime();
	                            break;
	                        case 5:
	                            admin.logout();
	                            return;
	                        default:
	                            System.out.println("Invalid choice. Please try again.");
	                    }
	                }
	            }
	        }
	    }
}
