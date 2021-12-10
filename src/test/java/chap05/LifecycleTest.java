package chap05;

import org.junit.jupiter.api.*;


@DisplayName("라이프 사이클 테스트")
public class LifecycleTest {
    public LifecycleTest() {
        System.out.println("new Lifecycle Test");
    }
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
    }

    @DisplayName("에이 테스트")
    @Test
    void a() {
        System.out.println("A");
    }

    @Disabled
    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("After All");
    }
}
