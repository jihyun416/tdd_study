package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoDebitRegister_Stub_Test {
    /*
    스텁(Stub) : 구현을 단순한 것으로 대체, 테스트에 맞게 단순히 원하는 동작 수행 (StubCardNumberValidator)
    가짜(Fake) : 제품에는 적합하지 않지만 실제 동작하는 구현 제공 (MemoryAutoDebitInfoRepository)
    스파이(Spy) : 호출된 내역을 기록. 기록한 내용은 테스트 결과를 검증할 때 사용한다. 스텁이기도 하다.
    모의(Mock) : 기대한 대로 상호작용 하는지 검증한다. 기대한 대로 동작하지 않으면 익셉션을 발생할 수 있다. 모의 객체는 스텁이자 스파이도 된다.
     */
    /* 변수나 필드를 사용해서 기대값 표현하지 말기 */

    private AutoDebitRegister register;
    private StubCardNumberValidator cardNumberValidator;
    private MemoryAutoDebitInfoRepository repository;

    @BeforeEach
    void setUp() {
        cardNumberValidator = new StubCardNumberValidator();
        repository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(cardNumberValidator, repository);
    }

    @Test
    void invalidCard() {
        cardNumberValidator.setInvalidNo("111122223333");
        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);
        assertEquals(CardValidity.INVALID, result.getValidity());
    }

    @Test
    void theftCard() {
        cardNumberValidator.setTheftNo("111122223333");
        AutoDebitReq req = new AutoDebitReq("user1", "111122223333");
        RegisterResult result = register.register(req);
        assertEquals(CardValidity.THEFT, result.getValidity());
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        repository.save(new AutoDebitInfo("user1", "111222333444", LocalDateTime.now()));
        AutoDebitReq req = new AutoDebitReq("user1", "1234567789012");
        RegisterResult result = this.register.register(req);
        assertTrue(result.isResult());
        AutoDebitInfo saved = repository.findOne("user1");
        assertEquals("1234567789012", saved.getCardNumber());
    }
}
