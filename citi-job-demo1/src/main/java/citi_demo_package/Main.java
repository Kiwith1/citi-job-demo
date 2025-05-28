package citi_demo_package;
/** A többi package meghívása */
import citi_demo_package.CRUD.UserCRUD;
import citi_demo_package.model.User;
/** Az adatbázis kezeléséhez, listákhoz és beolvasáshoz szükséges SQL bővítmények importálása */
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
/** Fő függvény, lefuttat mindent */
public class Main {
    private static final UserCRUD userCRUD = new UserCRUD();
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /**A menü rendszer kezelése*/
        while (true) {
            System.out.println("\n=== User CRUD Menu ===");
            System.out.println("1. Create User");
            System.out.println("2. View User by ID");
            System.out.println("3. View All Users");
            System.out.println("4. Update User");
            System.out.println("5. Delete User");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());

            try {
                switch (option) {
                    case 1 -> createUser();
                    case 2 -> viewUserById();
                    case 3 -> viewAllUsers();
                    case 4 -> updateUser();
                    case 5 -> deleteUser();
                    case 6 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void createUser() throws SQLException {
        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            } else if (name.matches(".*\\d.*")) {  // tartalmaz számjegyet
                System.out.println("Name must not contain numbers.");
                name = "";
            }
        } while (name.isEmpty());

        String email;
        do {
            System.out.print("Enter email: ");
            email = scanner.nextLine().trim();
            if (!isValidEmail(email)) {
                System.out.println("Invalid email format. Please enter a valid email.");
            }
        } while (!isValidEmail(email));

        String country;
        do {
            System.out.print("Enter country: ");
            country = scanner.nextLine().trim();
            if (country.isEmpty()) {
                System.out.println("Country cannot be empty. Please enter a valid country.");
            } else if (country.matches(".*\\d.*")) {  // tartalmaz számjegyet
                System.out.println("Country must not contain numbers.");
                country = "";
            }
        } while (country.isEmpty());

        User user = new User(name, email, country);
        userCRUD.insertUser(user);
        System.out.println("User created successfully.");
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }


    private static void viewUserById() throws SQLException {
        System.out.print("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        User user = userCRUD.selectUser(id);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void viewAllUsers() throws SQLException {
        List<User> users = userCRUD.selectAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            users.forEach(System.out::println);
        }
    }

    private static void updateUser() throws SQLException {
        System.out.print("Enter user ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        User user = userCRUD.selectUser(id);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Enter new name (leave blank to keep '" + user.getName() + "'): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) user.setName(name);

        System.out.print("Enter new email (leave blank to keep '" + user.getEmail() + "'): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) user.setEmail(email);

        System.out.print("Enter new country (leave blank to keep '" + user.getCountry() + "'): ");
        String country = scanner.nextLine();
        if (!country.isEmpty()) user.setCountry(country);

        boolean updated = userCRUD.updateUser(user);
        System.out.println(updated ? "User updated successfully." : "Update failed.");
    }

    private static void deleteUser() throws SQLException {
        System.out.print("Enter user ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean deleted = userCRUD.deleteUser(id);
        System.out.println(deleted ? "User deleted successfully." : "User not found or delete failed.");
    }
}
