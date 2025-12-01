// The RideInterface interface defines the standard operations of the amusement park management system
public interface RideInterface {

    //Add visitors to the waiting queue
    void addVisitorToQueue(Visitor visitor);

    //Remove visitors from the waiting queue
    void removeVisitorFromQueue(Visitor visitor);

    //Prints information about all visitors currently in the waiting queue
    void printQueue();

    //Add the visitor to the ride history
    void addVisitorToHistory(Visitor visitor);

    /**
     * Checks whether the designated tourist exists in the ride history
     * It returns true for presence and false for absence
     */
    boolean checkVisitorFromHistory(Visitor visitor);

    //Gets the total number of visitors in ride history
    int numberOfVisitors();

    //Print all the visitor information in the ride history
    void printRideHistory();

    //One cycle is run to process the visitors in the waiting queue
    void runOneCycle();
}