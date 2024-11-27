package tkt_booking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TktAdmin {
	Scanner input = new Scanner(System.in);

    Connection c;


    public TktAdmin(Connection c) {
        this.c = c;
    }

    public TktAdmin() {
	}

	void userRegister(User user) {
        String query = "insert into users (name, phno, email, address, user_name, password) values (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = c.prepareStatement(query);

            ps.setString(1, user.getName());
            ps.setString(2, user.getPhno());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getUserName());
            ps.setString(6, user.getPassword());

            int done = ps.executeUpdate();

            if (done > 0) {
                System.out.println("User registered successfully");
            } else {
                System.out.println("User registration failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean login = false;
    boolean authenticate() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        String query = "select * from users where user_name = ? and password = ?";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful");
                login = true;
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return login;
    }

    void changePassword() {
        if (login) {
            System.out.print("Enter username: ");
            String username = input.nextLine();
            System.out.print("Enter current password: ");
            String current_password = input.nextLine();

            String query = "select * from users where user_name = ? and password = ?";

            try {
                PreparedStatement ps = c.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, current_password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String newQuery = "update users set password = ? where user_name = ?;";

                    System.out.print("Enter new password: ");
                    String new_password = input.nextLine();

                    PreparedStatement ps1 = c.prepareStatement(newQuery);
                    ps1.setString(1, new_password);
                    ps1.setString(2, username);

                    int done = ps1.executeUpdate();

                    if (done > 0) {
                        System.out.println("Password updated successfully");
                    } else {
                        System.out.println("Failed to update password");
                    }
                } else {
                    System.out.println("User not found");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("log in first to change your password");
        }
    }

    void resetPassword() {
        System.out.print("Enter username: ");
        String username = input.nextLine();

        String query = "select * from users where user_name = ?";

        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String newQuery = "update users set password = ? where user_name = ?;";

                System.out.print("Enter new password: ");
                String password = input.nextLine();

                PreparedStatement ps1 = c.prepareStatement(newQuery);
                ps1.setString(1, password);
                ps1.setString(2, username);

                int done = ps1.executeUpdate();

                if (done > 0) {
                    System.out.println("Password reset successfully");
                } else {
                    System.out.println("Failed to reset password");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    List<Movie> searchByscreen() {
        List<Movie> screenList = new ArrayList<>();
        if (login) {
            String query = "select screen_name, movie_title, show_time, location from screens join showtimes on screens.screen_id = showtimes.screen_id join movies on showtimes.current_movie_id = movies.movie_id where screen_name like ? order by show_time;";
            System.out.print("Enter screen's name: ");
            String theaterName = input.nextLine();
            try {
                PreparedStatement ps = c.prepareStatement(query);
                ps.setString(1, "%" + theaterName + "%");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String movieName = rs.getString("movieTitle");
                    String screenName = rs.getString("screenName");
                    String showTime = rs.getString("showTime");
                    String location = rs.getString("location");
                    Movie movie = new Movie(movieName, screenName, showTime, location);
                    screenList.add(movie);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("log in first to search");
        }
        return screenList;
    }

    List<Movie> searchBymovie() {
        List<Movie> movieList = new ArrayList<>();
        String query = "select movie_title, screen_name, show_time, location from movies join showtimes on movies.movie_id = showtimes.current_movie_id join screens on showtimes.screen_id = screens.screen_id where movie_title like ? order by show_time;";
        System.out.print("Enter movie's name: ");
        String movieName = input.nextLine();
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, "%" + movieName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String movieName1 = rs.getString("movie_title");
                String screenName = rs.getString("screen_name");
                String showTime = rs.getString("show_time");
                String location = rs.getString("location");
                Movie movie = new Movie(movieName1, screenName, showTime, location);
                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    List<Movie> searchByLanguage() {
        List<Movie> languageList = new ArrayList<>();
        String query = "select movie_title, screen_name, show_time, location from movies join showtimes on movies.movie_id = showtimes.current_movie_id join screens on showtimes.screen_id = screens.screen_id where audio_language like ? order by show_time;";
        System.out.print("Enter language: ");
        String language = input.nextLine();
        try {
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, "%" + language + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String movieName1 = rs.getString("movieTitle");
                String screenName = rs.getString("screenName");
                String showTime = rs.getString("showTime");
                String location = rs.getString("location");
                Movie movie = new Movie(movieName1, screenName, showTime, location);
                languageList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return languageList;
    }
    public void logout() {
        login = false;
        System.out.println("You have been logged out.");
    }


    

    void selectShowtime() {
        if (login) {
            try {
                System.out.println("1. Screen");
                System.out.println("2. Movie");
                System.out.print("Search by ? (Enter 1 or 2): ");

                int choice = input.nextInt();
                input.nextLine();

                List<Movie> list = new ArrayList<>();

                if (choice == 1) {
                    list = searchByscreen();
                } else if (choice == 2) {
                    list = searchBymovie();
                }

                

                System.out.print("Select a movie/showtime (enter number): ");
                int showtimeChoice = input.nextInt();
                input.nextLine();

                Movie selectedMovie = list.get(showtimeChoice);

                System.out.println("You have selected:");
                System.out.println("Movie: " + selectedMovie.getMovieTitle());
                System.out.println("Screen: " + selectedMovie.getscreenName());
                System.out.println("Showtime: " + selectedMovie.getShowTime());

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("log in first to select a showtime");
        }
    }

	
            }

