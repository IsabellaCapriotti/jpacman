package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.Test;

/**
 * A test class to verify the functionality of the Player class.
 *
 * @author Isabella Capriotti
 */
public class PlayerTest {
    /**
     * Does isAlive() return the expected value for if the Player is alive or not?
     */
    @Test
    void testIsAlive() {
        // Instantiate sprites
        PacManSprites sprites = new PacManSprites();

        // Instantiate player
        PlayerFactory factory = new PlayerFactory(sprites);
        Player testPlayer = factory.createPacMan();

        // isAlive() should initially return true
        boolean actualIsAliveVal = testPlayer.isAlive();
        assertThat(actualIsAliveVal).isTrue();

        // Set alive to false
        testPlayer.setAlive(false);

        // isAlive() should now return false
        actualIsAliveVal = testPlayer.isAlive();
        assertThat(actualIsAliveVal).isFalse();
    }
}
