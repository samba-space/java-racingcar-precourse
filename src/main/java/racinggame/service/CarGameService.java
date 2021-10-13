package racinggame.service;

import racinggame.commons.strategy.MoveStrategy;
import racinggame.domain.Cars;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class CarGameService {
    private final MoveStrategy moveStrategy;

    public CarGameService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public static CarGameService from(MoveStrategy moveStrategy) {
        return new CarGameService(moveStrategy);
    }

    public void play() {
        Cars cars = InputView.inputCarNames();
        int turnCount = InputView.inputTurn();
        OutputView.printExecution();
        for (int i = 0; i < turnCount; ++i) {
            cars.moveCars(car -> car.move(moveStrategy));
            OutputView.printTurnResult(cars.getCars());
        }
        OutputView.printWinners(cars.getWinners());
    }
}
