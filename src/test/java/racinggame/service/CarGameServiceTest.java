package racinggame.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racinggame.domain.Car;
import racinggame.view.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class CarGameServiceTest {

    private static CarGameService carGameService;

    @BeforeAll
    static void setUp() {
        carGameService = CarGameService.of();
    }

    @Test
    void play_정상() {
        //given
        List<Car> cars = Arrays.asList(Car.ready("park"), Car.ready("kim"));
        MockedStatic<InputView> inputView = Mockito.mockStatic(InputView.class);
        int inputTurn = 10;

        //when
        inputView.when(() -> InputView.inputCarNames()).thenReturn(cars);
        inputView.when(() -> InputView.inputTurn()).thenReturn(inputTurn);

        //then
        assertThatCode(() -> carGameService.play()).doesNotThrowAnyException();
    }

    @DisplayName("회수가 주어질 때, 회수와 일치하는 크기의 랜덤이 생성된다.")
    @Test
    void 사이즈가_일치하는_랜덤수_생성() {
        //given
        int inputTurn = 10;
        int expectedSize = 10;

        //when
        List<Integer> randoms = carGameService.createRandoms(inputTurn);

        //then
        assertThat(randoms.size()).isEqualTo(expectedSize);
    }
}
