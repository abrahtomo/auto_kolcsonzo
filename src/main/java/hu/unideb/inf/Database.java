package hu.unideb.inf;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    /**
     * Fetches data from MY_TABLE in the H2 database.
     */
    public List<MyTable> fetchData() throws SQLException {
        List<MyTable> data = new ArrayList<>();

        // Establish the database connection
        try (Connection connection = DatabaseConnection.connect();
             Statement statement = connection.createStatement()) {

            // Execute SQL query to fetch data
            String query = "SELECT * FROM CARS"; // Replace with your actual table/columns
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set and populate the list
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Add the data to the list (assuming a MyTable class to hold the data)
                data.add(new MyTable(id, name));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data: " + e.getMessage());
            throw e;
        }
        return data;
    }



    public static List<Vehicle> getVehicles() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT vehicleType, make, model, year, engine, fuelType, seatingCapacity FROM Vehicles"; // Adjust table name and columns as needed

        try (Connection conn = DatabaseConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        rs.getString("vehicleType"),
                        rs.getString("make"),
                        rs.getString("model"),
                        rs.getInt("year"),
                        rs.getString("engine"),
                        rs.getString("fuelType"),
                        rs.getInt("seatingCapacity")
                );
                vehicles.add(vehicle);
            }
        }

        return vehicles;
    }
}