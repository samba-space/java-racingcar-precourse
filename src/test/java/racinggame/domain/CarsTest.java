package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

public class CarsTest {

    @DisplayName("자동차 목록 중 이름이 중복되지 않을 경우 정상 생성된다.")
    @Test
    void 자동차_이름_중복_없음() {
        Assertions.assertThatCode(() -> Cars.of(Arrays.asList(Car.ready("park"), Car.ready("abc")))).doesNotThrowAnyException();
    }

    @DisplayName("자동차 목록 중 이름이 중복된 경우 IllegalArgumentException발생")
    @Test
    void 자동차_이름_중복_에러발생() {
        Assertions.assertThatThrownBy(() -> Cars.of(Arrays.asList(Car.ready("park"), Car.ready("park"), Car.ready("abc"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 중복됐습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동자_목록_null_or_empty_에러발생(List<Car> cars) {
        Assertions.assertThatThrownBy(() -> Cars.of(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] cars가 null이거나 empty입니다.");
    }
}
