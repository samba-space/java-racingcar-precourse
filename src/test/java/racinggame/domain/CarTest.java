package racinggame.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_생성_정상() {
        Assertions.assertThatCode(() -> Car.ready("park")).doesNotThrowAnyException();
    }

    @Test
    void 자동차_전진() {
        //given
        Car car = Car.ready("park");

        //when
        int movedDistance = car.move();

        //then
        Assertions.assertThat(movedDistance).isEqualTo(1);
    }
}
