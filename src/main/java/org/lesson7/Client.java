package org.lesson7;

public class Client extends User {
    private final int code;

    protected Client(ClientBuilder builder) {
        super(builder);
        this.code = builder.code;
    }

    public int getCode() {
        return code;
    }

    public static class ClientBuilder extends UserBuilder<ClientBuilder> {
        private int code;

        public ClientBuilder() {

        }

        @Override
        public Client build() {
            return new Client(this);
        }

        public ClientBuilder withCode(int code) {
            this.code = code;
            return this;
        }

        @Override
        public ClientBuilder self(){
            return this;
        }
    }
}
