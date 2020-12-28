package addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person{
    String firstName,lastName,city,state,zip,phone;

    public Person(String firstName, String lastName, String city, String state, String zip, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                "}\n";
    }
}
public class AddressBook {
    Scanner scanner=new Scanner(System.in);
    List<Person> personList=new ArrayList<>();
    public static void main(String[] args){
        System.out.println("Welome to Address Book");
        AddressBook addressBook =new AddressBook();
        Person person=new Person("Rajas","Dongre","Mumbai","Mahrashtra","400092","8286054654");
        addressBook.personList.add(person);
        person=new Person("Shivam","Pandey","Jaipur","Rajasthan","400123","9894054654");
        addressBook.personList.add(person);
        person=new Person("Adarsh","Chaudhray","Darbhanga","Bihar","409992","8286054786");
        addressBook.personList.add(person);
        System.out.println(addressBook.personList);
    }
}
