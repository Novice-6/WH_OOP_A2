/**
 * The Visitor class inherits from the Person class and represents visitor information
 * Extend visitor-specific attributes: ticket ID and membership type
 */
public class Visitor extends Person {
    // Ticket ID, which uniquely identifies each visitor's ticket
    private String ticketId;
    private String membershipType; // e.g., "Regular", "VIP"

    public Visitor() {
    }

    /**
     * A parameter constructor that initializes all properties of the Visitor object
     *
     * @param name The visitor's name, passed to the parent Person class
     * @param age The visitor's age, which is passed to the parent Person class
     * @param gender The gender of the visitor, passed to the parent Person class
     * @param ticketId Visitor ticket ID
     * @param membershipType Visitor membership type
     */
    public Visitor(String name, int age, String gender, String ticketId, String membershipType) {
        // Call the constructor of the parent class Person to initialize the underlying properties
        super(name, age, gender);
        this.ticketId = ticketId;
        this.membershipType = membershipType;
    }

    // The getter and setter methods are used to access and modify properties in the same way as in the Person class
    public String getTicketId() {
        return ticketId;
    }
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getMembershipType() {
        return membershipType;
    }
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    /**
     * Override the toString method to return a string containing the guest information
     * Inherit and extend the toString method from the parent Person class to add the ticket ID and membership type information
     */
    @Override
    public String toString() {
        return super.toString() + ", TicketID: " + ticketId + ", Membership: " + membershipType;
    }
}