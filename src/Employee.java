/**
 * 员工类，继承自 Person，封装员工特有属性
 */
public class Employee extends Person {
    // 2个特有实例变量（Part 1 要求）
    private String employeeId;
    private String position; // 职位（如 "Roller Coaster Operator"）

    // 默认构造函数（Part 1 要求）
    public Employee() {}

    // 带参构造函数（初始化自身+父类属性，Part 1 要求）
    public Employee(String id, String name, int age, String employeeId, String position) {
        super(id, name, age);
        this.employeeId = employeeId;
        this.position = position;
    }

    // Getter 和 Setter（Part 1 要求）
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
