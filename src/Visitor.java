/**
 * 游客类，继承自 Person，封装游客特有属性
 */
public class Visitor extends Person {
    // 2个特有实例变量（Part 1 要求）
    private String visitorId;
    private String membershipType; // 会员类型（如 "Standard"、"VIP"）

    // 默认构造函数（Part 1 要求）
    public Visitor() {}

    // 带参构造函数（初始化自身+父类属性，Part 1 要求）
    public Visitor(String id, String name, int age, String visitorId, String membershipType) {
        super(id, name, age);
        this.visitorId = visitorId;
        this.membershipType = membershipType;
    }

    // Getter 和 Setter（Part 1 要求）
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * 重写 toString，方便打印游客详情（支持 Part 3/4/5 的打印功能）
     */
    @Override
    public String toString() {
        return String.format("Visitor[ID: %s, Name: %s, Age: %d, Membership: %s]",
                visitorId, getName(), getAge(), membershipType);
    }
}
