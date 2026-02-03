package database;
import model.Patient;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class PatientDAO {
    //Insert method
    public void insertPatient(Patient patient) {
        // Corrected query with case-sensitive table and column names
        String sql = "INSERT INTO \"Patient\" (\"PatientID\", \"FullName\", \"Age\", \"BloodType\") VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set parameters (? → actual values)
            statement.setInt(1, patient.getPatientId());     // PatientID
            statement.setString(2, patient.getFullName());   // FullName
            statement.setInt(3, patient.getAge());           // Age
            statement.setString(4, patient.getBloodType());  // BloodType
            // Execute INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public static void main(String[] args) {
        // Create staff object
        Patient patient = new Patient(676767, "Birzhan", 18, "A+");
        // Insert into database
        PatientDAO dao = new PatientDAO();
        dao.insertPatient(patient);
        // Check in pgAdmin or psql:
        // SELECT * FROM staff;
        PatientDAO DAO = new PatientDAO();
        DAO.getAllPatient();
        //DAO.UpdatePatient(patient);
    }
    public void getAllPatient() {
        String sql = "SELECT * FROM \"Patient\"";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ALL PATIENT FROM DATABASE ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("PatientID");
                String name = resultSet.getString("FullName");
                int age = resultSet.getInt("Age");
                String bloodtype = resultSet.getString("BloodType");
                System.out.println("ID: " + id);
                System.out.println("FullName: " + name);
                System.out.println("Age: " + age);
                System.out.println("BloodType: " + bloodtype);
                System.out.println("---");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    //Update method
    public static boolean UpdatePatient(Patient patient) {
        String sql = "UPDATE \"Patient\" SET \"FullName\" = ?, \"Age\" = ?, \"BloodType\"= ? WHERE \"PatientID\" = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null){
            return false;
        }
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getFullName());
            statement.setInt(2, patient.getAge());
            statement.setString(3,patient.getBloodType());
            statement.setInt(4,patient.getPatientId());
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            return  rowsUpdated > 0;
        }
        catch (SQLException e){
            System.out.println("Update failed!");
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public static boolean DeletePatient(int id) {
        String sql = "DELETE FROM \"Patient\" WHERE \"PatientID\" = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null){
            return false;
        }
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int rowsUpdate = statement.executeUpdate();
            statement.close();
            return  rowsUpdate > 0;
        }
        catch (SQLException e){
            System.out.println("Delete failed!");
            e.printStackTrace();
        }
        finally{
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public static Patient getPatientById(int patientId) {
        String sql = "SELECT * FROM \"Patient\" WHERE \"PatientID\" = ?";
        Connection connection = DatabaseConnection.getConnection();
        Patient patient = null;  // This will hold the result
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("FullName");
                int age = resultSet.getInt("Age");
                String bloodType = resultSet.getString("BloodType");
                patient = new Patient(patientId, name, age, bloodType);  // Create Patient object
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patient;  // Return the Patient object (or null if not found)
    }
    public List<Patient> searchPatientByName(String name) {
        List<Patient> patientList = new ArrayList<>();
        String sql = "SELECT * FROM \"Patient\" WHERE \"FullName\" ILIKE ?";  // Case-insensitive search using ILIKE
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");  // Add wildcard for partial match
            ResultSet resultSet = statement.executeQuery();
            // Iterate through the result set and add matching patients to the list
            while (resultSet.next()) {
                int id = resultSet.getInt("PatientID");
                String fullName = resultSet.getString("FullName");
                int age = resultSet.getInt("Age");
                String bloodType = resultSet.getString("BloodType");
                Patient patient = new Patient(id, fullName, age, bloodType);
                patientList.add(patient);  // Add the patient to the list
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patientList;  // Return the list of patients matching the search criteria
    }
    public List<Patient> searchPatientByAgeRange(int minAge, int maxAge) {
        List<Patient> patientList = new ArrayList<>();
        // BETWEEN includes both min and max (inclusive)
        String sql = "SELECT * FROM \"Patient\" WHERE \"Age\" BETWEEN ? AND ? ORDER BY \"Age\" DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return patientList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge); // Set the minimum age
            statement.setInt(2, maxAge); // Set the maximum age

            ResultSet resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("PatientID");
                String name = resultSet.getString("FullName");
                int age = resultSet.getInt("Age");
                String bloodType = resultSet.getString("BloodType");

                Patient patient = new Patient(id, name, age, bloodType);
                patientList.add(patient); // Add the patient to the list
            }

            resultSet.close();
            statement.close();
            System.out.println("Found " + patientList.size() + " patients.");
        } catch (SQLException e) {
            System.out.println("Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return patientList;
    }


}