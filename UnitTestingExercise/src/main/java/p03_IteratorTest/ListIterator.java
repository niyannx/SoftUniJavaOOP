package p03_IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;

public class ListIterator {
    // fields -> collection of strings
    private List<String> elements;
    private int currentIndex;

    // list iterator constructor
    public ListIterator(String... elements) throws OperationNotSupportedException {
        // if the params are NULL -> throw exception
        if (elements == null) {
            throw new OperationNotSupportedException();
        }

        this.elements = Arrays.asList(elements);
        // starts at index 0
        this.currentIndex = 0;
    }

    // move to the next index
    public boolean move() {
        // check if there's a next index to move to
        if (hasNext()) {
            this.currentIndex++;
            return true;
        }

        return false;
    }

    // returns whether the collection has a next element
    public boolean hasNext(){
        return currentIndex < elements.size() - 1;
    }

    // print the element at current index
    public String print() {
        if (this.elements.size() == 0){
            throw new IllegalStateException("Invalid Operation!");
        }

        return this.elements.get(this.currentIndex);
    }
}
