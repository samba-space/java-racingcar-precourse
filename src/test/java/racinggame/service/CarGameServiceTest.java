package racinggame.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.view.InputView;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CarGameServiceTest {

    private CarGameService carGameService;

    @BeforeEach
    void setUp() {
        carGameService = CarGameService.from(() -> 1);
    }

    @Test
    void play_정상() {
        //given
        Cars cars = Cars.from(Arrays.asList(Car.from("park"), Car.from("kim")));
        MockedStatic<InputView> inputView = Mockito.mockStatic(InputView.class);
        int inputTurn = 10;

        //when
        inputView.when(() -> InputView.inputCarNames()).thenReturn(cars);
        inputView.when(() -> InputView.inputTurn()).thenReturn(inputTurn);

        //then
        assertThatCode(() -> carGameService.play()).doesNotThrowAnyException();
    }
}
