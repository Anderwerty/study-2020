package org.lesson11.example1;

import java.util.Optional;

public class UserService {
    private final Validator validator;

    public UserService(Validator validator) {
        this.validator = validator;
    }

    public boolean register(User user) {
        // validation
        validator.validate(user);
        // check if user with such email exists in current DB
        if (findUserByEmail(user.getEmail()).isPresent()) {
           throw  new RuntimeException("user with such email already exists");
        }

       return saveUser(user);

    }

    private boolean saveUser(User user) {
        return true;
    }

    protected Optional<User> findUserByEmail(String email) {
        // find user by email should be implemented
        return Optional.empty();
    }


//    private void validate(User user) {
//        // validation should be implemented
//    }
}

class User {
    private String email;
    private String password;
    private String telephoneNumber;

    public User(String email, String password, String telephoneNumber) {
        this.email = email;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
