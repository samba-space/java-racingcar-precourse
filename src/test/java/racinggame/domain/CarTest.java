package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarTest {

    @DisplayName("자동차 이름을 입력했을 경우, 정상적으로 생성된다.")
    @Test
    void 자동차_생성_정상() {
        assertThatCode(() -> Car.ready("park")).doesNotThrowAnyException();
    }

    @DisplayName("energy가 MOVE_ABLE_ENERGY 이상이면 전진한다.")
    @Test
    void 자동차_전진() {
        //given
        Car car = Car.ready("park");
        int energy = 4;
        int expectedDistance = car.getDistance() + 1;

        //when
        int movedDistance = car.move(energy);

        //then
        assertThat(movedDistance).isEqualTo(expectedDistance);
    }

    @DisplayName("energy가 MOVE_ABLE_ENERGY 보다 작으면 스탑한다.")
    @Test
    void 자동차_스탑() {
        //given
        Car car = Car.ready("park");
        int energy = 3;
        int expectedDistance = car.getDistance();

        //when
        int movedDistance = car.move(energy);

        //then
        assertThat(movedDistance).isEqualTo(expectedDistance);
    }

    @DisplayName("자동차 거리를 비교한다.")
    @Test
    void 자동차_거리_비교() {
        //given
        Car car1 = Car.of("park", 1);
        Car car2 = Car.of("kim", 2);

        //when
        boolean isCar1Lose = car1.isLose(car2);

        //then
        assertThat(isCar1Lose).isTrue();
    }
}
