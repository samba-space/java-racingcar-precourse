package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @DisplayName("자동차 목록 중 이름이 중복되지 않을 경우 정상 생성된다.")
    @Test
    void 자동차_이름_중복_없음() {
        assertThatCode(() -> Cars.of(Arrays.asList(Car.ready("park"), Car.ready("abc")))).doesNotThrowAnyException();
    }

    @DisplayName("자동차 목록 중 이름이 중복된 경우 IllegalArgumentException발생")
    @Test
    void 자동차_이름_중복_에러발생() {
        assertThatThrownBy(() -> Cars.of(Arrays.asList(Car.ready("park"), Car.ready("park"), Car.ready("abc"))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 자동차 이름이 중복됐습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 자동차목록_null_or_empty_에러발생(List<Car> cars) {
        assertThatThrownBy(() -> Cars.of(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] params가 null이거나 empty입니다.");
    }

    @DisplayName("자동차 목록과 randoms가 일치할 경우 자동차목록이 이동한다.")
    @Test
    void 자동차목록_이동() {
        //given
        List<Integer> randoms = Arrays.asList(1, 4, 6);
        Cars cars = Cars.of(Arrays.asList(Car.ready("park"), Car.ready("kim"), Car.ready("song")));
        //when, then
        assertThatCode(() -> cars.moveCars(randoms)).doesNotThrowAnyException();
    }

    @DisplayName("randoms가 null 또는 empty인 경우 IllegalArgumentException발생")
    @ParameterizedTest(name = "[{index}] randoms={0}")
    @NullAndEmptySource
    void randoms_null_or_empty_에러발생(List<Integer> randoms) {
        //given
        Cars cars = Cars.of(Arrays.asList(Car.ready("park"), Car.ready("kim"), Car.ready("song")));
        //when, then
        assertThatThrownBy(() -> cars.moveCars(randoms))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] params가 null이거나 empty입니다.");
    }

    @DisplayName("randoms와 자동차목록의 크기가 일치하지 않는 경우 IllegalArgumentException발생")
    @Test
    void randoms_자동차목록_사이즈_불일치_에러발생() {
        //given
        List<Integer> randoms = Arrays.asList(1, 4);
        Cars cars = Cars.of(Arrays.asList(Car.ready("park"), Car.ready("kim"), Car.ready("song")));
        //when, then
        assertThatThrownBy(() -> cars.moveCars(randoms))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] randoms와 자동차 사이즈가 일치하지 않습니다.");
    }
}
