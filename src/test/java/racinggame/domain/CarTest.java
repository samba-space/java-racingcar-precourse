package racinggame.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("자동차 이름을 입력했을 경우, 정상적으로 생성된다.")
    @Test
    void 자동차_생성_정상() {
        Assertions.assertThatCode(() -> Car.ready("park")).doesNotThrowAnyException();
    }

    @DisplayName("energy가 MOVE_ABLE_ENERGY 이상이면 전진한다.")
    @Test
    void 자동차_전진() {
        //given
        Car car = Car.ready("park");

        //when
        int movedDistance = car.move(4);

        //then
        Assertions.assertThat(movedDistance).isEqualTo(1);
    }

    @DisplayName("energy가 MOVE_ABLE_ENERGY 보다 작으면 스탑한다.")
    @Test
    void 자동차_스탑() {
        //given
        Car car = Car.ready("park");

        //when
        int movedDistance = car.move(3);

        //then
        Assertions.assertThat(movedDistance).isEqualTo(0);
    }
}
