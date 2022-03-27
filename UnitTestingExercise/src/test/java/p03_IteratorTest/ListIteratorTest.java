package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] ELEMENTS = {"element1", "element2", "element3"};

    @Before
    public void setup() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }

    // CONSTRUCTOR TESTS -----------------------------
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorGivenNullParametersShouldThrowException() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator(null);
    }

    // MOVE TESTS ------------------------------------

    @Test
    public void testMoveIncrementsIndex() {
        listIterator.move();

        Assert.assertEquals(listIterator.print(), ELEMENTS[1]);
    }

    // PRINT TESTS -----------------------------------
    @Test
    public void testPrintElement() {
        String output = listIterator.print();

        Assert.assertEquals(output, ELEMENTS[0]);
    }

    @Test
    public void testPrintNextElement() {
        listIterator.move();

        String output = listIterator.print();

        Assert.assertEquals(output, ELEMENTS[1]);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWhenElementsCollectionIsEmptyShouldThrowException() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();

        iterator.print();
    }

    // HAS NEXT TESTS -----------------------------------
    @Test
    public void testNoNextElementShouldReturnFalse() {
        for (int i = 0; i < ELEMENTS.length; i++) {
            listIterator.move();
        }

        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testHasNextElementShouldReturnTrue() {
        Assert.assertTrue(listIterator.hasNext());
    }
}
