/**
 * The abstract parent class Person encapsulates the common attributes (ID, name, and age) of all personnel.
 */
public abstract class Person {
    // Define private member variables name, age, and gender to store the name, age, and gender of a person.
    private String name;
    private int age;
    private String gender;

    // Default constructor, providing a parameterless constructor for subclasses to call or for initializing objects.
    public Person() {
    }

    /**
     * Parameterized constructor, allowing the initial values to be passed in when creating the object to set the properties of name, age and gender.
     *
     * @param name   The names of the person
     * @param age    The age of the person
     * @param gender The gender of the person
     */
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * The method for obtaining the "name" attribute, as well as "age" and "gender" below, are all the same.
     * return Returns the value of the "name" attribute of the current object
     */
    public String getName() {
        return name;
    }
    /**
     * The method for setting the "name" attribute, and the same applies to "age" and "gender" below.
     * @param name New name value
     */
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    //Override the toString method to return a string representing the Person object
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}