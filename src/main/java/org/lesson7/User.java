package org.lesson7;

//abstract ?
public class User {
    private final String email;
    private final String password;

    protected User(UserBuilder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder<SELF extends UserBuilder<SELF>> {
        private String email;
        private String password;

        public UserBuilder() {

        }

        public User build() {
            return new User(this);
        }

        public SELF withEmail(String email) {
            this.email = email;
            return self();
        }

        public SELF withPassword(String password) {
            this.password = password;
            return self();
        }

        @SuppressWarnings("")
        protected SELF self(){
            return (SELF)this;
        }
    }
}
