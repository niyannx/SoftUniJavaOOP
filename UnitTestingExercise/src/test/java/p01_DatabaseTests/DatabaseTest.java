package p01_DatabaseTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {23, 56, 23, 12, 1};
    private static final int MAXIMUM_LENGTH = 16;
    private static final int MINIMUM_LENGTH = 1;

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreatesValidObject() {
        Integer[] elements = database.getElements();

        // check if the elements are the same && if the length is the same
        Assert.assertArrayEquals(elements, NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayLengthMoreThan16ShouldThrowException() throws OperationNotSupportedException {
        new Database(new Integer[MAXIMUM_LENGTH + 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayLengthLessThan1ShouldThrowException() throws OperationNotSupportedException {
        new Database(new Integer[MINIMUM_LENGTH - 1]);
    }

    @Test
    public void testMethodAddAddsElement() throws OperationNotSupportedException {
        database.add(67);

        Integer[] elements = database.getElements();

        Assert.assertEquals("Add operation doesn't add to array.", elements.length, NUMBERS.length + 1);
        Assert.assertEquals("Add operation doesn't add to end of array.", elements[elements.length - 1], Integer.valueOf(67));
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddWithNullParameterShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testMethodRemoveRemovesLastElement() throws OperationNotSupportedException {
        Integer[] arrayBeforeRemoval = database.getElements();
        Integer expectedLastElement = arrayBeforeRemoval[arrayBeforeRemoval.length - 2];

        database.remove();

        Integer[] arrayAfterRemoval = database.getElements();
        Integer actualLastElement = arrayAfterRemoval[arrayAfterRemoval.length - 1];

        Assert.assertEquals("Remove operation doesn't remove from array.", arrayAfterRemoval.length, arrayBeforeRemoval.length - 1);
        Assert.assertEquals("Remove operation doesn't remove from end of array.", expectedLastElement, actualLastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        createEmptyDatabase();

        // try to remove from the empty db
        database.remove();
    }

    private void createEmptyDatabase() throws OperationNotSupportedException {
        // empty the database
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
    }
}
