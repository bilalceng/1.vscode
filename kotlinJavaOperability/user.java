import java.util.ArrayList;
import java.util.List;

public class User {

    private String firstName;
    private String lastName;
    private String city;
    private String country;

    private List<Address> addresses = new ArrayList<>();



    public User(String firstName, String lastname){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(){

    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Address> getAddresses(){
        return addresses;
    }
    public void setAddresses(List<Address> AddressList){
        this.addresses = AddressList;
    }

    public String allAddresses(){
        StringBuilder builder = new StringBuilder();
        for(Address address: addresses){
            builder.append(address.getAddressType().name()).append("adress: \n");
            builder.append(labelPrinter.labelFor(this, address.getAddressType()));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return UserExtensions.getFullName(this) +
                " - Addresses: " + addresses.size() + "\n" +
                allAddresses();
    }
}