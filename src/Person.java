/**
 * 抽象父类 Person，封装人员共通属性（ID、姓名、年龄）
 * 因不会直接实例化，设计为抽象类（Part 2 要求）
 */
public abstract class Person {
    // 3个实例变量（Part 1 要求）
    private String id;
    private String name;
    private int age;

    // 默认构造函数（Part 1 要求）
    public Person() {}

    // 带参构造函数（Part 1 要求）
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter 和 Setter（Part 1 要求）
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
