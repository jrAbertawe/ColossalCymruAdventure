import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BattleManagerTestSuite {

    //Setup for asserting console outputs
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @org.junit.jupiter.api.Test
    void attackPhase_missed() {
        //PLAN
        System.setOut(new PrintStream(outContent));

        Actor player = new Player("Player", 20, 10);
        Actor monster = new Monster("Monster");
        BattleManager battleManager = new BattleManager(player, monster);

        //ACT
        battleManager.attackPhase(player, monster, 0);

        //ASSERT
        assertEquals(player.getName() + " missed!\n", outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void attackPhase_glancingBlow() {
        //PLAN
        System.setOut(new PrintStream(outContent));

        Actor player = new Player("Player", 20, 10);
        Actor monster = new Monster("Monster", 20, 10);
        BattleManager battleManager = new BattleManager(player, monster);

        //ACT
        battleManager.attackPhase(player, monster, 5);

        //ASSERT
        assertEquals(player.getName() + " struck a glancing blow!\n", outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void attackPhase_hit() {
        //PLAN
        System.setOut(new PrintStream(outContent));

        Actor player = new Player("Player", 20, 10);
        Actor monster = new Monster("Monster");
        BattleManager battleManager = new BattleManager(player, monster);

        //ACT
        battleManager.attackPhase(player, monster, 15);

        //ASSERT
        assertEquals(player.getName() + " landed a hit for 15 HP!\n", outContent.toString());
    }
}