package racinggame.view;

import racinggame.commons.message.MessageType;
import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.WinnerNames;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printExecution() {
        System.out.println(MessageType.OUTPUT_EXECUTION.get());

    }

    public static void printTurnResult(List<Car> cars) {
        cars.forEach(car -> System.out.printf(MessageType.OUTPUT_TURN_RESULT_FORMAT.get(), car.getCarName(), mapToLine(car.getDistance())));
        System.out.println();
    }

    public static void printWinners(WinnerNames winnerNames) {
        System.out.printf(MessageType.OUTPUT_WINNER_FORMAT.get(), String.join(", ", mapToStringList(winnerNames.getWinnerNames())));
    }

    private static String mapToLine(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    private static List<String> mapToStringList(List<CarName> carNames) {
        List<String> stringCarNames = new ArrayList<>();
        for (CarName carName : carNames) {
            stringCarNames.add(carName.getName());
        }
        return stringCarNames;
    }
}
