package nl.tudelft.jpacman.game;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.level.PlayerFactory;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.level.LevelFactory;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.DefaultPointCalculator;
import nl.tudelft.jpacman.sprite.PacManSprites;

import java.util.ArrayList;
import java.util.List;


/**
 * A test class to verify the functionality of the SinglePlayerGame class.
 *
 * @author Isabella Capriotti
 */
public class SinglePlayerGameTest {

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
     Verifies that getPlayers returns the one Player the SinglePlayerGame was instantiated with.
     */
    @Test
    void testGetPlayers() {
        // Instantiate SinglePlayerGame
        PacManSprites sprites = new PacManSprites();
        BoardFactory boardFactory = new BoardFactory(sprites);
        Board board = boardFactory.createBoard(new Square[][]
        {
            { new BasicSquare() }, { new BasicSquare() }
        });
        GhostFactory ghostFactory = new GhostFactory(sprites);
        LevelFactory levelFactory = new LevelFactory(sprites,
            ghostFactory,
            new DefaultPointCalculator());
        Level testLevel = levelFactory.createLevel(board,
            new ArrayList<Ghost>() { },
            testSquaresArrayList);

        // Instantiate Player
        PlayerFactory playerFactory = new PlayerFactory(sprites);
        Player testPlayer = playerFactory.createPacMan();

        SinglePlayerGame testGame = new SinglePlayerGame(testPlayer,
            testLevel,
            new DefaultPointCalculator());

        // Verify that getPlayers returns the same Player that the game was created with
        List<Player> playersReturned = testGame.getPlayers();
        assertThat(playersReturned.contains(testPlayer)).isTrue();
        assertThat(playersReturned.size()).isEqualTo(1);
    }
}
