/**
 * COPYRIGHT (C) A.M.H.D.Kavindya - 20222164 - W1985735- hasanga.20222164@iit.ac.lk. All Rights Reserved.
 * Coursework on Object-Oriented Programming, L5 Semester 1
 *
 * A.M.H.D. Kavindya, the author
 */

// User class representing a user with a username and password
public class User {
    private String username;
    // User's username
    private String password;
    // User's password

    /**
     * Constructor to initialize the User object with provided username and password.
     *
     * @param username The user's username.
     * @param password The user's password.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method to retrieve the user's username.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method to update the user's username.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method to retrieve the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to update the user's password.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
