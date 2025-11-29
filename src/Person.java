/**
 * 抽象父类 Person，封装人员共通属性（ID、姓名、年龄）
 * 因不会直接实例化，设计为抽象类（Part 2 要求）
 */
// Person.java
public abstract class Person {
    private String name;
    private int age;
    private String gender;

    // 默认构造函数
    public Person() {
    }

    // 带参构造函数
    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}
