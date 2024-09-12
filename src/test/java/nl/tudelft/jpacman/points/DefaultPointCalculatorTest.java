package nl.tudelft.jpacman.points;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.level.Pellet;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.sprite.EmptySprite;
import nl.tudelft.jpacman.sprite.PacManSprites;

/**
 * A test class to verify the functionality of the DefaultPointCalculator class.
 *
 * @author Isabella Capriotti
 */
public class DefaultPointCalculatorTest {
    private static final int pointValue1 = 1;
    private static final int pointValue5 = 5;
    private static final int expectedPointValue1 = 1;
    private static final int expectedPointValue2 = 6;

    /**
     * Verifies that consumedAPellet() updates the Player's score correctly
     * according to the point value of the Pellet consumed.
     */
    @Test
    void testConsumedAPellet() {
        // Instantiate test player and pellets
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player testPlayer = playerFactory.createPacMan();

        Pellet onePointPellet = new Pellet(pointValue1, new EmptySprite());
        Pellet fivePointPellet = new Pellet(pointValue5, new EmptySprite());

        // Instantiate point calculator
        DefaultPointCalculator testPointCalculator = new DefaultPointCalculator();

        // Player should get 1 point after consuming first Pellet
        testPointCalculator.consumedAPellet(testPlayer, onePointPellet);

        int currentScore = testPlayer.getScore();
        assertThat(currentScore).isEqualTo(expectedPointValue1);

        // Player should get 5 points after consuming second Pellet
        testPointCalculator.consumedAPellet(testPlayer, fivePointPellet);

        currentScore = testPlayer.getScore();
        assertThat(currentScore).isEqualTo(expectedPointValue2);
    }


}
