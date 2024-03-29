import java.util.HashMap;
import java.util.Map;

class JavaApplication {
    public static void main(String[] args) {

        Address addressBedia = new Address(
                "yenı mh.",
                "kayabasi",
                "batman",
                "turkey",
                "42423",
                AddressType.Shipping);

        User user = new User();
        user.setFirstName("bedia");
        user.setLastName("berek");
        UserExtensions.addOrUpdateAddress(user, addressBedia);
        labelPrinter.printLabelFor(user);

        Address.JSONKeys keys =  Address.JSONKeys.INSTANCE;

        HashMap<String, Object> JsonHashmap = new HashMap<>();
        JsonHashmap.put(keys.streetLine1, addressBedia.streetLine1);
        JsonHashmap.put(keys.city, addressBedia.city);
        JsonHashmap.put(keys.streetLine2, addressBedia.streetLine2);
        JsonHashmap.put(keys.country, addressBedia.country);
        JsonHashmap.put(keys.streetLine1, addressBedia.postalCode);
        JsonHashmap.put(keys.postalCode, addressBedia.postalCode);
        JsonHashmap.put(keys.stateOrProvince, addressBedia.stateOrProvince);
        JsonHashmap.put(keys.addressType, addressBedia.addressType.name());


        for (String key : JsonHashmap.keySet()) {
            Object value = JsonHashmap.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        System.out.println("JsonAddress :  \n" + JsonHashmap);
        System.out.println(Address.addCanadian(AddressType.Gift));
        System.out.println(Address.street);

        CreditCard card1 = new CreditCard(
                "123456",
                "7",
                "2024",
                "9999"
        );

        CreditCard card2 = new CreditCard(
                "123456",
                "7",
                "2025",
                "9999"
        );
        CreditCard card3 = new CreditCard(
                "123456",
                "10",
                "2023",
                "9999"
        );

        UserExtensions.addValidCreditCard(user,card1);
        UserExtensions.addValidCreditCard(user,card2);
        UserExtensions.addValidCreditCard(user,card3);
        System.out.println(user.getCreditCards().size());

    }
}
