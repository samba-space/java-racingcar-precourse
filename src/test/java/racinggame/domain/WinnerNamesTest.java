package racinggame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNamesTest {

    @Test
    void 우승자이름_생성_정상() {
        assertThatCode(() -> WinnerNames.from(Arrays.asList(Car.of("park", 5)))).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "[{index}] winnerCars={0}")
    @NullAndEmptySource
    void winnerCars_null_or_empty_에러발생(List<Car> winnerCars) {
        assertThatThrownBy(() -> WinnerNames.from(winnerCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] params가 null이거나 empty입니다.");
    }
}
