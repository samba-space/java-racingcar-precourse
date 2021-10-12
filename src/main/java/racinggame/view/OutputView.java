package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.WinnerNames;

import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printExecution() {
        System.out.println("\n실행 결과");

    }

    public static void printTurnResult(List<Car> cars) {
        cars.forEach(car -> System.out.printf("%s : %s\n", car.getCarName(), mapLine(car.getDistance())));
        System.out.println();
    }

    public static void printWinners(WinnerNames winnerNames) {
        System.out.printf("최종 우승자는 %s 입니다.\n", String.join(", ", winnerNames.getWinnerNames().toArray(new String[0])));
    }

    private static String mapLine(int distance) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
