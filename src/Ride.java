import java.io.*;
import java.util.*;

/**
 * The Ride class implements the RideInterface Interface, which represents the management system of the ride facility
 * It contains basic information about the ride facilities, operators, waiting queues, ride history and other functions
 */
public class Ride implements RideInterface {
    private String rideName;
    private Employee operator;
    private int maxRider;
    private int numOfCycles;

    //The waiting queue is used to manage the visitor waiting to ride
    private Queue<Visitor> waitingLine;
    //Ride history, which records all visitors who have ridden the facility
    private LinkedList<Visitor> rideHistory;

    // Constructor, initialization
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    /**
     * Take parameter constructor, initialize all the basic information of the ride
     *
     * @param rideName Name of amusement facilities
     * @param maxRider Maximum number of passengers per trip
     * @param operator The operator responsible for the facility
     */
    public Ride(String rideName, int maxRider, Employee operator) {
        this();
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }
    public Employee getOperator() {
        return operator;
    }
    public void setOperator(Employee operator) {
        this.operator = operator;
    }
    public int getMaxRider() {
        return maxRider;
    }
    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    /**
     * --- Part 3: Queue Management ---
     * Add visitor to the end of the waiting queue
     * @param visitor The visitor object to add
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor); // Add to the end of the queue
            System.out.println(visitor.getName() + " added to the queue.");
        } else {
            System.out.println("Cannot add null visitor to queue.");
        }
    }

    /**
     * Removes the designated visitor from the waiting queue
     * @param visitor The visitor object to remove
     */
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (waitingLine.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println("Visitor not found in queue.");
        }
    }

    //Prints information about all visitors currently in the waiting queue
    @Override
    public void printQueue() {
        System.out.println("\n--- Current Queue ---");
        if (waitingLine.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor v : waitingLine) {
                System.out.println(v);
            }
        }
    }

    /**
     * --- Part 4A: History Management ---
     * Add the visitor to the ride history
     * @param visitor The visitor object to add
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " added to ride history.");
        }
    }

    /**
     * Checks whether the designated visitor exists in the ride history
     * @param visitor The visitor object to check
     * @return true indicates presence and false indicates absence
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println("Is " + visitor.getName() + " in history? " + (found ? "Yes" : "No"));
        return found;
    }

    /**
     * Get the total number of visitors in the ride history
     * @return The number of visitors in the historical record
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }


    // Print all the visitor information in the ride history
    @Override
    public void printRideHistory() {
        System.out.println("\n--- Ride History ---");
        // Iterator is used
        Iterator<Visitor> it = rideHistory.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // --- Part 4B: Sorting ---
    // Sort the ride history
    public void sortHistory() {
        // Sort using Collections.sort and a custom VisitorComparator
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");
    }

    /**
     * --- Part 5: Run a Cycle ---
     * One cycle is run to process the tourists in the waiting queue
     * Move up to maxRider visitors from the queue to the history
     */
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Error: No operator assigned. Cannot run ride.");
            return;
        }

        if (waitingLine.isEmpty()) {
            System.out.println("Error: No visitors in queue. Cannot run ride.");
            return;
        }

        System.out.println("\n--- Running One Cycle ---");
        int count = 0;
        // The people in the queue are removed in a loop until the single maximum capacity is reached or the queue is empty
        while (count < maxRider && !waitingLine.isEmpty()) {
            Visitor v = waitingLine.poll(); // Remove team leader
            addVisitorToHistory(v);         // Join History
            count++;
        }

        numOfCycles++;
        System.out.println("Cycle completed. Visitors processed: " + count + ". Total cycles: " + numOfCycles);
    }

    /**
     * --- Part 6: Export to File ---
     * Export ride history to a CSV file
     * @param filename The name of the file to export
     */
    public void exportRideHistory(String filename) {
        // CSV type: Name,Age,Gender,TicketId,MembershipType
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                String line = String.format("%s,%d,%s,%s,%s",
                        v.getName(), v.getAge(), v.getGender(), v.getTicketId(), v.getMembershipType());
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Data exported successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * --- Part 7: Import from File ---
     * Import the ride history from the CSV file
     * @param filename The filename to import
     */
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Make sure the data is in the correct format
                if (data.length == 5) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1]);
                    String gender = data[2];
                    String ticketId = data[3];
                    String membership = data[4];

                    Visitor v = new Visitor(name, age, gender, ticketId, membership);
                    addVisitorToHistory(v);
                }
            }
            System.out.println("Data imported successfully from " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}