package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final int MAXIMUM_LENGTH = 16;
    private static final int MINIMUM_LENGTH = 1;
    private static final Person[] PEOPLE = {
            new Person(1, "Niya"),
            new Person(2, "Raicho"),
            new Person(3, "Eva")};

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    // CONSTRUCTOR TESTS ----------------------------------------------
    @Test
    public void testConstructorCreatesValidObject() {
        Person[] elements = database.getElements();

        Assert.assertArrayEquals(elements, PEOPLE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayLengthMoreThan16ShouldThrowException() throws OperationNotSupportedException {
        new p01_Database.Database(new Integer[MAXIMUM_LENGTH + 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testArrayLengthLessThan1ShouldThrowException() throws OperationNotSupportedException {
        new p01_Database.Database(new Integer[MINIMUM_LENGTH - 1]);
    }

    // ADD TESTS ------------------------------------------------------
    @Test
    public void testAddsPersonToDatabaseCorrectly() throws OperationNotSupportedException {
        Person person = new Person(4, "Nikola");

        database.add(person);

        Person[] people = database.getElements();

        Assert.assertEquals("Add operation doesn't add to array.", people.length, PEOPLE.length + 1);
        Assert.assertEquals("Add operation changed the person's index.", people[people.length - 1].getId(), 4);
        Assert.assertEquals("Add operation changed the person's name.", people[people.length - 1].getUsername(), "Nikola");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullPersonToDatabaseShouldThrowException() throws OperationNotSupportedException {
        database.add(null);
    }

    // REMOVE TESTS ---------------------------------------------------
    @Test
    public void testRemoveMethodRemovesLastElement() throws OperationNotSupportedException {
        Person[] arrayBeforeRemoval = database.getElements();
        Person expectedLastElement = arrayBeforeRemoval[arrayBeforeRemoval.length - 2];

        database.remove();

        Person[] arrayAfterRemoval = database.getElements();
        Person actualLastElement = arrayAfterRemoval[arrayAfterRemoval.length - 1];

        Assert.assertEquals("Remove operation doesn't remove from array.", arrayAfterRemoval.length, arrayBeforeRemoval.length - 1);
        Assert.assertEquals("Remove operation doesn't remove from end of array.", expectedLastElement, actualLastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabaseShouldThrowException() throws OperationNotSupportedException {
        createEmptyDatabase();

        database.remove();
    }

    private void createEmptyDatabase() throws OperationNotSupportedException {
        for (int i = 0; i < PEOPLE.length; i++) {
            database.remove();
        }
    }

    // FIND BY USERNAME TESTS ---------------------------------
    @Test(expected = OperationNotSupportedException.class)
    public void testNoExistingUserWithGivenUsernameShouldThrowException() throws OperationNotSupportedException {
        String username = "Gosho";

        database.findByUsername(username);
    }

    @Test
    public void testFindExistingUserWithGivenUsername() throws OperationNotSupportedException {
        String username = PEOPLE[0].getUsername();

        database.findByUsername(username);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testUsernameIsNullShouldThrowException() throws OperationNotSupportedException {
        String username = "";

        database.findByUsername(username);
    }


    // FIND BY ID TESTS ---------------------------------------
    @Test(expected = OperationNotSupportedException.class)
    public void testNoExistingUserWithGivenIDShouldThrowException() throws OperationNotSupportedException {
        int id = Integer.MAX_VALUE;

        database.findById(id);
    }

    @Test
    public void testFindExistingUserWithGivenID() throws OperationNotSupportedException {
        int id = PEOPLE[0].getId();

        database.findById(id);
    }
}
