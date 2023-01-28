package nl.tudelft.jpacman.level;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * A test class to verify the functionality of the Level class.
 *
 * @author Isabella Capriotti
 */
public class LevelTest {
    private List<Square> testSquaresArrayList = new ArrayList<Square>();

    /**
    Re-initializes the array of BasicSquares to test with.
     */
    @BeforeEach
    void setUpSquares() {
        testSquaresArrayList.clear();
        testSquaresArrayList.add(new BasicSquare());
        testSquaresArrayList.add(new BasicSquare());
    }

    /**
    * Before registering a player, there should be no players alive,
     * so isAnyPlayerAlive() should return false.
    * After registering a living player, isAnyPlayerAlive() should return true.
    * */
    @Test
    void testIsAnyPlayerAlive() {

        // Instantiate Level
        PacManSprites sprites = new PacManSprites();
        BoardFactory boardFactory = new BoardFactory(sprites);
        Board board = boardFactory.createBoard(new Square[][] {
            { new BasicSquare() }, { new BasicSquare() }
        });
        GhostFactory ghostFactory = new GhostFactory(sprites);
        LevelFactory levelFactory = new LevelFactory(sprites,
            ghostFactory,
            new DefaultPointCalculator());
        Level testLevel = levelFactory.createLevel(board,
            new ArrayList<Ghost>() { },
            testSquaresArrayList);

        // isAnyPlayerAlive() should initially return false
        boolean actualValue = testLevel.isAnyPlayerAlive();
        assertThat(actualValue).isFalse();

        // Register a living player
        PlayerFactory factory = new PlayerFactory(sprites);
        Player testPlayer = factory.createPacMan();
        testLevel.registerPlayer(testPlayer);

        // isAnyPlayerAlive() should now return true
        actualValue = testLevel.isAnyPlayerAlive();
        assertThat(actualValue).isTrue();
    }
}
