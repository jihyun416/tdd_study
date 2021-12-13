package chap06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BaseballGameTest {
    BaseballGame game = null;
    @BeforeEach
    void givenGame() {
        game = new BaseballGame("456");
    }

    @Test
    void exactMatch() {
        // 실행
        Score score = game.guess("456");
        // 결과 확인
        assertEquals(3, score.getStrikes());
        assertEquals(0, score.getBalls());
    }

    @Test
    void one_strike_one_ball() {
        // 실행
        Score score = game.guess("516");
        // 결과 확인
        assertEquals(1, score.getStrikes());
        assertEquals(1, score.getBalls());
    }

    @Test
    void noMatch() {
        // 실행
        Score score = game.guess("123");
        // 결과 확인
        assertEquals(0, score.getStrikes());
        assertEquals(0, score.getBalls());
    }

    @Test
    void genGame_With_DupNumber_Then_Fail() {
        assertThrows(IllegalArgumentException.class, ()->new BaseballGame("110"));
    }

}