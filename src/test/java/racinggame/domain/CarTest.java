package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = Car.from("park");
    }

    @DisplayName("자동차 이름을 입력했을 경우, 정상적으로 생성된다.")
    @Test
    void 자동차_생성_정상() {
        assertThatCode(() -> Car.from("park")).doesNotThrowAnyException();
    }

    @DisplayName("자동차가 주어진 distance만큼 전진한다.")
    @ParameterizedTest(name = "[{index}] distance={0}")
    @ValueSource(ints = {0, 1, 2})
    void 자동차_전진_스탑(int distance) {
        //when
        car.move(() -> distance);
        int movedDistance = car.getDistance();

        //then
        assertThat(movedDistance).isEqualTo(distance);
    }

    @DisplayName("moveStrategy가 null일 경우 NullPointerException이 발생한다.")
    @Test
    void moveStrategy_null_전진_에러발생() {
        assertThatThrownBy(() -> car.move(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("[ERROR] moveStrategy가 null입니다.");
    }

    @DisplayName("자동차 거리를 비교한다.")
    @Test
    void 자동차_거리_비교() {
        //given
        Car orderCar = Car.of("kim", 2);

        //when
        boolean isCar1Lose = car.isLose(orderCar);

        //then
        assertThat(isCar1Lose).isTrue();
    }

    @DisplayName("상대 자동차가 null일 경우 NullPointerException이 발생한다.")
    @Test
    void 상대_자동차_null_경우_비교_에러발생() {
        assertThatThrownBy(() -> car.isLose(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("[ERROR] otherCar가 null입니다.");
    }
}
