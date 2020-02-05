package org.lesson11.example2.one;

public class VipUser extends User {
    private final String telephoneNumber;

    public VipUser(String email, String password, String telephoneNumber) {
        super(email, password);
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
