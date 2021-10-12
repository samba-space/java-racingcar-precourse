package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.domain.Cars;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarGameService {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;

    public static CarGameService of() {
        return new CarGameService();
    }

    public void play() {
        Cars cars = Cars.of(InputView.inputCarNames());
        int turnCount = InputView.inputTurn();
        OutputView.printExecution();
        for (int i = 0; i < turnCount; ++i) {
            cars.moveCars(createRandoms(cars.getCars().size()));
            OutputView.printTurnResult(cars.getCars());
        }
        OutputView.printWinners(cars.getWinners());
    }

    public List<Integer> createRandoms(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            result.add(Randoms.pickNumberInRange(RANGE_START, RANGE_END));
        }
        return result;
    }
}
