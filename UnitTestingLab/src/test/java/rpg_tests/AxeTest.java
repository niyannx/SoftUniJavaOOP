package rpg_tests;

import Lab.Axe;
import Lab.Dummy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int AXE_BROKEN_DURABILITY = 0;
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int DURABILITY_LOSS = 1;

    private Dummy dummy;
    private Axe axe;
    private Axe brokenAxe;

    @Before
    public void setup() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        brokenAxe = new Axe(AXE_ATTACK, AXE_BROKEN_DURABILITY);
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void testAxeLosesDurabilityAfterAttack() {
        // act ->
        axe.attack(dummy);

        // assert ->
        Assert.assertEquals(AXE_ATTACK - DURABILITY_LOSS , axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenAxeShouldThrowException() {
        // act ->
        brokenAxe.attack(dummy);
    }
}
