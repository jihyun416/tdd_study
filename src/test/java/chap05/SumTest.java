package chap05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class SumTest {

    @Test
    void sum() {
        int result = 2+3;
        assertEquals(5, result);
        assertNotEquals(4, result);
        String a = "a";
        String a1 = a;
        String b = "b";
        assertThat(a).contains("a");
        assertSame(a, a1);
        assertNotSame(a, b);
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull(a);
        //fail();
        NullPointerException thrown = assertThrows(NullPointerException.class, ()->{
            String str = null;
            str.isEmpty();
        });
        assertDoesNotThrow(()->{
            String str = null;
        });

        assertAll(
                ()->assertNull(null),
                ()->assertTrue(true),
                ()->assertNull(null)
        );
    }
}
