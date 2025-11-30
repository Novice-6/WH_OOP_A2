// AssignmentTwo.java
public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("---------------- PART 3 ----------------");
        assignment.partThree();
        
        System.out.println("\n---------------- PART 4A ---------------");
        assignment.partFourA();
        
        System.out.println("\n---------------- PART 4B ---------------");
        assignment.partFourB();
        
        System.out.println("\n---------------- PART 5 ----------------");
        assignment.partFive();
        
        System.out.println("\n---------------- PART 6 ----------------");
        assignment.partSix();
        
        System.out.println("\n---------------- PART 7 ----------------");
        assignment.partSeven();
    }

    public void partThree() {
        // Part 3: Queue Demonstration
        Employee op = new Employee("John", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, op);

        Visitor v1 = new Visitor("Jack", 20, "Male", "T01", "VIP");
        Visitor v2 = new Visitor("Sharon", 22, "Female", "T02", "Regular");
        Visitor v3 = new Visitor("Benny", 25, "Male", "T03", "Regular");
        Visitor v4 = new Visitor("Leo", 18, "Male", "T04", "VIP");
        Visitor v5 = new Visitor("Nehemia", 28, "Male", "T05", "Regular");

        // Add 5 visitors
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove one
        rollerCoaster.removeVisitorFromQueue(v3); // Removing Benny

        // Print Queue
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // Part 4A: Collection (History) Demonstration
        Employee op = new Employee("Alice", 29, "Female", "E002", "Manager");
        Ride waterRide = new Ride("Water Splash", 4, op);

        Visitor v1 = new Visitor("Tom", 20, "Male", "T10", "Regular");
        Visitor v2 = new Visitor("Sherly", 22, "Female", "T11", "VIP");
        Visitor v3 = new Visitor("Ben", 25, "Male", "T12", "Regular");
        Visitor v4 = new Visitor("David", 18, "Male", "T13", "Regular");
        Visitor v5 = new Visitor("Anna", 30, "Female", "T14", "VIP");

        // Add to history manually
        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);

        // Check visitor
        waterRide.checkVisitorFromHistory(v3); // check Ben
        
        // Print count
        System.out.println("Total visitors in history: " + waterRide.numberOfVisitors());
        
        // Print all (using Iterator internally)
        waterRide.printRideHistory();
    }

    public void partFourB() {
        // Part 4B: Sorting Demonstration
        Employee op = new Employee("Bob", 40, "Male", "E003", "Operator");
        Ride dropTower = new Ride("Drop Tower", 3, op);

        // Intentionally disordered by age and name
        dropTower.addVisitorToHistory(new Visitor("Zack", 25, "Male", "T20", "Regular"));
        dropTower.addVisitorToHistory(new Visitor("Alice", 25, "Female", "T21", "VIP"));
        dropTower.addVisitorToHistory(new Visitor("Bob", 15, "Male", "T22", "Regular"));
        dropTower.addVisitorToHistory(new Visitor("Charlie", 60, "Male", "T23", "VIP"));
        dropTower.addVisitorToHistory(new Visitor("Dave", 15, "Male", "T24", "Regular"));

        System.out.println("Before Sorting:");
        dropTower.printRideHistory();

        // Sort
        dropTower.sortHistory();

        System.out.println("After Sorting (By Age asc, then Name asc):");
        dropTower.printRideHistory();
    }

    public void partFive() {
        // Part 5: Run Cycle Demonstration
        Employee op = new Employee("Eve", 35, "Female", "E004", "Operator");
        Ride ferrisWheel = new Ride("Ferris Wheel", 3, op); // Max 3 riders per cycle

        // Add 10 visitors
        for (int i = 1; i <= 10; i++) {
            ferrisWheel.addVisitorToQueue(new Visitor("Vis" + i, 20 + i, "N/A", "T" + i, "Reg"));
        }

        ferrisWheel.printQueue();

        // Run one cycle (should take 3 people)
        ferrisWheel.runOneCycle();

        System.out.println("Queue after 1 cycle:");
        ferrisWheel.printQueue();

        System.out.println("History after 1 cycle:");
        ferrisWheel.printRideHistory();
    }

    public void partSix() {
        // Part 6: Export Demonstration
        Employee op = new Employee("Steve", 50, "Male", "E005", "Operator");
        Ride train = new Ride("Ghost Train", 5, op);

        train.addVisitorToHistory(new Visitor("Lionel", 30, "Male", "T99", "VIP"));
        train.addVisitorToHistory(new Visitor("Cristiano", 32, "Male", "T98", "VIP"));
        train.addVisitorToHistory(new Visitor("Neymar", 28, "Male", "T97", "Regular"));

        // Export
        train.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        // Part 7: Import Demonstration
        Employee op = new Employee("Steve", 50, "Male", "E005", "Operator");
        Ride train = new Ride("Ghost Train", 5, op); // New Ride object

        System.out.println("History before import: " + train.numberOfVisitors());
        
        // Import
        train.importRideHistory("ride_history.csv");

        System.out.println("History after import: " + train.numberOfVisitors());
        train.printRideHistory();
    }
}
