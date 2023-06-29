public class Person {
    private String personName;
    private String phoneNumber;
    private String email;
    public Person(String personName, String phoneNumber, String email) {
        this.personName = personName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
