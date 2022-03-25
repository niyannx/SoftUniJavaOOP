package rpg_tests;

import Lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int DUMMY_START_HEALTH = 100;
    private static final int DUMMY_DEAD_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 20;

    private Dummy aliveDummy;
    private Dummy deadDummy;

    @Before
    public void setup() {
        aliveDummy = new Dummy(DUMMY_START_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(DUMMY_DEAD_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testAttackedDummyLosesHealth() {
        // act ->
        aliveDummy.takeAttack(ATTACK_POINTS);

        // assert ->
        Assert.assertEquals(DUMMY_START_HEALTH - ATTACK_POINTS, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackedDeadDummyThrowsException() {
        // act
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesXP() {
        // act
        int exp = deadDummy.giveExperience();

        // assert
        Assert.assertEquals(DUMMY_EXPERIENCE, exp);
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyDoesNotGiveXP() {
        int exp = aliveDummy.giveExperience();
    }
}
