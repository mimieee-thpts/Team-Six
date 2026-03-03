import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    public AuthenticationService(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * check that the username does not already exist before creating a new user
     * @param username new user username
     * @param password new user password
     * @return new user, or null if the username already exists
     */
    @Override
    public User signUp(String username, String password) {
        // iterate through list of users to see if any user contains the same username as the entered username.
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                // exit out of method if username already exists
                return null;
            }
        }

        // create new user if username does not already exist.
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    /**
     * check if the user is valid before returning the login user
     * @param username login user username
     * @param password login user password
     * @return the user if the username and password match, and null otherwise
     */
    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        // if no user matches
        return null;
    }

    // DONE TODO Now: Add a constructor to initialize the users list with the default user

    // DONE TODO Now: Implement the signUp method to add a new user to the list if the username is not taken and return the user; returns null otherwise

    // DONE TODO Now: Implement the logIn method to return the user if the username and password match, and null otherwise
}