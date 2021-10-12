package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CarNameTest {

    @DisplayName("5자 이하의 자동차 이름이 정상적으로 생성된다.")
    @Test
    void 자동차_이름_생성_정상() {
        Assertions.assertThatCode(() -> CarName.of("park")).doesNotThrowAnyException();
    }

    @DisplayName("자동차 이름이 empty 또는 null일 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest(name = "[{index}] name={0}")
    @NullAndEmptySource
    void 자동차_이름_null_or_empty_생성_비정상(String name) {
        Assertions.assertThatThrownBy(() -> CarName.of(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 empty 또는 null 입니다.");
    }

    @DisplayName("자동차 이름이 5글자 초과일 경우 IllegalArgumentException이 발생한다.")
    @Test
    void 자동차_이름_글자수_초과_생성_비정상() {
        Assertions.assertThatThrownBy(() -> CarName.of("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 5글자 초과입니다.");
    }
}
