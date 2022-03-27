package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {
    private static final int[] arrWithPositiveNumbers = {65, 23, 45, 907, 12, 1, 435, 123123, 65768, 123, 234, 823813};
    private static final int[] arrWithNegativeNumbers = {-1, -435, -213, -12444, 123, -234234, 384872, -11};

    @Test
    public void testSortPositiveNumbersCorrectly() {
        int[] correctlySortedArray = sortArray(arrWithPositiveNumbers);
        int[] sortedWithBubbleSort = Bubble.sort(arrWithPositiveNumbers);

        Assert.assertEquals(correctlySortedArray, sortedWithBubbleSort);
    }

    @Test
    public void testSortNegativeNumbersCorrectly() {
        int[] correctlySortedArray = sortArray(arrWithNegativeNumbers);
        int[] sortedWithBubbleSort = Bubble.sort(arrWithNegativeNumbers);

        Assert.assertEquals(correctlySortedArray, sortedWithBubbleSort);
    }

    private int[] sortArray(int[] arr) {
        Arrays.sort(arr);

        return arr;
    }
}
