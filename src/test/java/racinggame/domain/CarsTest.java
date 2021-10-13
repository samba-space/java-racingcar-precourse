package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.from(Arrays.asList(Car.from("park"), Car.from("kim"), Car.from("song")));
    }

    @DisplayName("자동차 목록 중 이름이 중복되지 않을 경우 정상 생성된다.")
    @Test
    void 자동차_이름_중복_없음() {
        assertThatCode(() -> Cars.from(Arrays.asList(Car.from("park"), Car.from("abc")))).doesNotThrowAnyException();
    }

    @DisplayName("자동차 목록 중 이름이 중복된 경우 IllegalArgumentException발생")
    @Test
    void 자동차_이름_중복_에러발생() {
        assertThatThrownBy(() -> Cars.from(Arrays.asList(Car.from("park"), Car.from("park"), Car.from("abc"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 중복됐습니다.");
    }

    @ParameterizedTest(name = "[{index}] cars={0}")
    @NullAndEmptySource
    void 자동차목록_null_or_empty_에러발생(List<Car> cars) {
        assertThatThrownBy(() -> Cars.from(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] params가 null이거나 empty입니다.");
    }

    @DisplayName("자동차목록이 정상 이동한다.")
    @Test
    void 자동차목록_이동() {
        //when, then
        assertThatCode(() -> cars.moveCars(car -> car.move(() -> 1))).doesNotThrowAnyException();
    }

    @DisplayName("consumer가 null인 경우 NullPointerException발생")
    @Test
    void randoms_null_에러발생() {
        //when, then
        assertThatThrownBy(() -> cars.moveCars(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("[ERROR] consumer가 null입니다.");
    }

    @DisplayName("우승자를 선출한다.")
    @Test
    void 우승자_선출() {
        //given
        cars.moveCars((Car car) -> car.move(() -> 5));
        WinnerNames expectedNames = WinnerNames.from(
                Arrays.asList(Car.of("park", 5), Car.of("kim", 5), Car.of("song", 5)));

        //when
        WinnerNames winnerNames = cars.getWinners();

        //then
        assertThat(winnerNames).isEqualTo(expectedNames);
    }
}
