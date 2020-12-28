package addressbook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    public  boolean equals(Object object){
        if(object==this)
            return true;
        if(!(object instanceof String))
            return false;
        String firstName=(String)object;
        if(this.firstName.equals(firstName))
            return true;
        else
            return false;
    }
}
public class AddressBook {
    Scanner scanner=new Scanner(System.in);
    List<Person> personList=new ArrayList<>();
    public static void main(String[] args){
        System.out.println("Welome to Address Book");
        AddressBook addressBook =new AddressBook();
        int command;
        Person person=new Person("Rajas","Dongre","Mumbai","Mahrashtra","400092","8286054654");
        addressBook.personList.add(person);
        person=new Person("Shivam","Pandey","Jaipur","Rajasthan","400123","9894054654");
        addressBook.personList.add(person);
        person=new Person("Adarsh","Chaudhray","Darbhanga","Bihar","409992","8286054786");
        addressBook.personList.add(person);
        System.out.println(addressBook.personList);


        do{
            System.out.print("Enter command: \n");
            System.out.print("Exit : 0 \n");
            System.out.print("Add command: 1 \n");
            System.out.print("Edit command: 2 \n");
            System.out.print("Delete: 3 \n");
            System.out.print("Sort by first name: 4 \n");
            System.out.print("Sort by City command: 5 \n");
            System.out.print("Find all Person by City and State command: 6 \n");
            System.out.print("count all Person by City and State command: 7 \n");
            command=addressBook.scanner.nextInt();
            switch(command){
                case 1:
                    addressBook.scanner.nextLine();
                    addressBook.addPerson();
                    break;
                case 2:
                    addressBook.scanner.nextLine();
                    addressBook.editPerson();
                    break;
                case 3:
                    addressBook.scanner.nextLine();
                    System.out.print("Enter first name to delete");
                    addressBook.deletePersonFirstName(addressBook.scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Sorted list by first name: ");
                    System.out.println(addressBook.sortByFirstName());
                    break;
                case 5:
                    System.out.print("Sorted list by City: ");
                    System.out.println(addressBook.sortByCity());
                    break;
                case 6:
                    addressBook.scanner.nextLine();
                    System.out.print("Enter City");
                    String city = addressBook.scanner.nextLine();
                    System.out.print("Enter State");
                    String state = addressBook.scanner.nextLine();
                    System.out.println(addressBook.findByCityAndState(city, state));
                    break;
                case 7:
                    addressBook.scanner.nextLine();
                    System.out.print("Enter City");
                    String city1 = addressBook.scanner.nextLine();
                    System.out.print("Enter State");
                    String state1 = addressBook.scanner.nextLine();
                    System.out.println(addressBook.countPerson(city1, state1));
                    break;

            }
        }while(command !=0);
    }
    public boolean personExistsCheckByFirstName (String firstName) {
        return this.personList.stream().anyMatch(person -> person.equals(firstName));
    }
    private void addPerson() {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        if (!this.personExistsCheckByFirstName(firstName)) {
            System.out.print("Enter last name:");
            String lastName = scanner.nextLine();
            System.out.print("Enter city:");
            String city = scanner.nextLine();
            System.out.print("Enter state:");
            String state = scanner.nextLine();
            System.out.print("Enter zip:");
            String zip = scanner.nextLine();
            System.out.print("Enter phoennumber:");
            String phone = scanner.nextLine();
            Person person=new Person(firstName,lastName,city,state,zip,phone);
            this.personList.add(person);
        }
        else {
            System.out.println("Person with first name : "+firstName+" already exists.");
        }
    }
    public Person getPersonByFirstName (String firstName) {
        return this.personList.stream().filter(Person -> Person.equals(firstName)).findFirst().get();
    }
    public void editPerson () {
        System.out.println("Enter first name:");
        String firstName = scanner.nextLine();
        if (this.personExistsCheckByFirstName(firstName)) {
            Person editPerson = this.getPersonByFirstName(firstName);
            System.out.print("Enter last name:");
            String lastName = scanner.nextLine();
            editPerson.setLastName(lastName);

            System.out.print("Enter city:");
            String city = scanner.nextLine();
            editPerson.setCity(city);

            System.out.print("Enter state:");
            String state = scanner.nextLine();
            editPerson.setState(state);

            System.out.print("Enter zip:");
            String zip = scanner.nextLine();
            editPerson.setZip(zip);

            System.out.print("Enter phonenumber:");
            String phone = scanner.nextLine();
            editPerson.setPhone(phone);

            System.out.println("Edited person : " + editPerson);
        }
        else {
            System.out.println("Person with first name : "+firstName+" does not exists.");
        }

    }
    public void deletePersonFirstName (String firstName) {

        if(this.personExistsCheckByFirstName(firstName)) {
            this.personList.removeIf(Person -> Person.equals(firstName));
            System.out.println("The person "+firstName + " was deleted");
        }
        else {
            System.out.println("The person "+firstName+ " does not exist");
        }
    }
    public List<Person> sortByFirstName() {
        List<Person> sort= this.personList.stream().
                sorted(Comparator.comparing(Person::getFirstName)).
                collect(Collectors.toList());
        return sort;
    }
    public List<Person> sortByCity() {
        List<Person> sortedPersonList = this.personList.stream().
                sorted(Comparator.comparing(Person::getCity)).
                collect(Collectors.toList());
        return sortedPersonList;
    }
    public List<Person> findByCityAndState(String city,String state) {
        List<Person> matchedPersonList = this.personList.stream().
                filter(p -> p.getCity().equals(city) && p.getState().equals(state)).
                collect(Collectors.toList());

        return matchedPersonList;
    }
    public long countPerson(String city ,String state) {
        long count = this.personList.stream().
                filter(p -> p.getCity().equals(city) && p.getState().equals(state)).
                count();
        return count;
    }
}
