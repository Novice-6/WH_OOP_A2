import java.util.Comparator;

/**
 * The VisitorComparator class implements the Comparator interface for custom sorting of Visitor objects
 * Sorting rule: First sort by age in ascending order and by name alphabetically if the age is the same
 */
public class VisitorComparator implements Comparator<Visitor> {
    /**
     * Override the compare method to define the comparison rules for the Visitor object
     *
     * @param v1 The first Visitor object
     * @param v2 The second Visitor object
     * @return Compare the results: a negative number means that v1 is less than v2, 0 means equality, and a positive number means that v1 is greater than v2
     */
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Main sorting criteria: Sorted in ascending order by age
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());

        // Secondary sorting criteria: alphabetical by name if the age is the same
        if (ageCompare == 0) {
            return v1.getName().compareTo(v2.getName());
        }
        return ageCompare;
    }
}