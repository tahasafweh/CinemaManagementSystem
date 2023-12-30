class User {
    private String username;
    private String accountDetails;

    public User(String username, String accountDetails) {
        this.username = username;
        this.accountDetails = accountDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getAccountDetails() {
        return accountDetails;
    }
}
