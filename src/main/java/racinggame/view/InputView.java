package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private InputView() {
    }

    public static List<Car> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            return mapToList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    public static int inputTurn() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputTurn();
        }
    }

    private static List<Car> mapToList(String inputCarNames) {
        List<Car> result = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            result.add(Car.ready(carName.trim()));
        }
        return result;
    }
}
