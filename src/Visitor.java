/**
 * 游客类，继承自 Person，封装游客特有属性
 */
public class Visitor extends Person {
    private String ticketId;
    private String membershipType; // e.g., "Regular", "VIP"

    public Visitor() {
    }

    public Visitor(String name, int age, String gender, String ticketId, String membershipType) {
        super(name, age, gender); // 调用父类构造器
        this.ticketId = ticketId;
        this.membershipType = membershipType;
    }

    // Getters and Setters
    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public String getMembershipType() { return membershipType; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    @Override
    public String toString() {
        return super.toString() + ", TicketID: " + ticketId + ", Membership: " + membershipType;
    }
}
