// Main class
public class AssignmentTwo {
    /**
     * Program entry
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // Queue demo
        System.out.println("--------------- PART 3 ---------------");
        assignment.partThree();

        // History demo
        System.out.println("\n---------------- PART 4A ---------------");
        assignment.partFourA();

        // Sorting demonstration
        System.out.println("\n--------------- PART 4B --------------");
        assignment.partFourB();

        //Run cycle demo
        System.out.println("\n--------------- PART 5 ---------------");
        assignment.partFive();

        //CSV export demo
        System.out.println("\n--------------- PART 6 ---------------");
        assignment.partSix();

        //CSV import demo
        System.out.println("\n--------------- PART 7 ---------------");
        assignment.partSeven();
    }

    // Part 3: Queue Demonstration
    public void partThree() {
        Employee op = new Employee("Tang", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, op);

        // Create and add five visitors to the queue
        Visitor v1 = new Visitor("ZhangSan", 20, "Male", "A11", "VIP");
        Visitor v2 = new Visitor("LiSi", 22, "Female", "A12", "Regular");
        Visitor v3 = new Visitor("WangWu", 25, "Male", "A13", "Regular");
        Visitor v4 = new Visitor("ZhaoLiu", 18, "Male", "A14", "VIP");
        Visitor v5 = new Visitor("SunQi", 28, "Male", "A15", "Regular");

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove one
        rollerCoaster.removeVisitorFromQueue(v3);

        // Print Queue
        rollerCoaster.printQueue();
    }

    // Part 4A: Collection (History) Demonstration
    public void partFourA() {
        Employee op = new Employee("Alice", 29, "Female", "E002", "Manager");
        Ride waterRide = new Ride("Water Rafting", 4, op);

        // Same as above
        Visitor v1 = new Visitor("Tom", 20, "Male", "A21", "Regular");
        Visitor v2 = new Visitor("Sherly", 22, "Female", "A22", "VIP");
        Visitor v3 = new Visitor("Ben", 25, "Male", "A23", "Regular");
        Visitor v4 = new Visitor("David", 18, "Male", "A24", "Regular");
        Visitor v5 = new Visitor("Anna", 30, "Female", "A25", "VIP");

        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);

        // Checks if a particular visitor is in the history
        waterRide.checkVisitorFromHistory(v3);

        // Prints the total number of visitors in the history
        System.out.println("Total visitors in history: " + waterRide.numberOfVisitors());

        // Print all history
        waterRide.printRideHistory();
    }

    // Part 4B: Sorting Demonstration
    public void partFourB() {
        Employee op = new Employee("Bob", 40, "Male", "E003", "Operator");
        Ride dropTower = new Ride("Drop Tower", 3, op);

        // Add visitors out of order by age and name
        dropTower.addVisitorToHistory(new Visitor("Zack", 25, "Male", "A31", "Regular"));
        dropTower.addVisitorToHistory(new Visitor("Alice", 25, "Female", "A32", "VIP"));
        dropTower.addVisitorToHistory(new Visitor("Bob", 15, "Male", "A33", "Regular"));
        dropTower.addVisitorToHistory(new Visitor("Charlie", 55, "Male", "A34", "VIP"));
        dropTower.addVisitorToHistory(new Visitor("Dave", 15, "Male", "A35", "Regular"));

        // Print the history before sorting
        System.out.println("Before Sorting:");
        dropTower.printRideHistory();

        // Sort
        dropTower.sortHistory();

        // Print history after sorting (ascending by age, then ascending by name)
        System.out.println("After Sorting (By Age asc, then Name asc):");
        dropTower.printRideHistory();
    }

    // Part 5: Run Cycle Demonstration
    public void partFive() {
        Employee op = new Employee("Eve", 35, "Female", "E004", "Operator");
        Ride ferrisWheel = new Ride("Ferris Wheel", 3, op); // Max 3 riders per cycle

        // Add 10 visitors
        for (int i = 1; i <= 10; i++) {
            ferrisWheel.addVisitorToQueue(new Visitor("Vis" + i, 20 + i, "N/A", "T" + i, "Reg"));
        }

        ferrisWheel.printQueue();

        // Run one cycle (should take 3 people)
        ferrisWheel.runOneCycle();

        // Print the queue after one cycle
        System.out.println("Queue after 1 cycle:");
        ferrisWheel.printQueue();

        // Print the history after running one cycle
        System.out.println("History after 1 cycle:");
        ferrisWheel.printRideHistory();
    }

    // Part 6:CSV export demo methods
    public void partSix() {
        System.out.println("\n=== Part 6: Export CSV ===");
        Employee op = new Employee("Steve", 50, "Male", "E005", "Operator");
        Ride train = new Ride("Ghost Train", 5, op);

        train.addVisitorToHistory(new Visitor("Lionel", 30, "Male", "A41", "VIP"));
        train.addVisitorToHistory(new Visitor("Cristiano", 32, "Male", "A42", "VIP"));
        train.addVisitorToHistory(new Visitor("Neymar", 28, "Male", "A43", "Regular"));
        train.addVisitorToHistory(new Visitor("Messi", 35, "Male", "A44", "VIP"));
        train.addVisitorToHistory(new Visitor("Ronaldo", 37, "Male", "A45", "Regular"));

        // Export history to a CSV file
        train.exportRideHistory("ride_history.csv");
    }

    // Part 7: Import Demonstration
    public void partSeven() {
        Employee op = new Employee("Steve", 50, "Male", "E005", "Operator");
        Ride train = new Ride("Ghost Train", 5, op); // New Ride object

        // Prints the number of history records before import
        System.out.println("History before import: " + train.numberOfVisitors());

        // Import data from a CSV file
        train.importRideHistory("ride_history.csv");

        // Print the number and details of the history after the import
        System.out.println("History after import: " + train.numberOfVisitors());
        train.printRideHistory();
    }
}