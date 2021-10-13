package racinggame.view;

import nextstep.utils.Console;
import racinggame.commons.message.MessageType;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static Cars inputCarNames() {
        System.out.println(MessageType.INPUT_RACING_CAR.get());
        try {
            return mapToList(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.printf(MessageType.ERROR_FORMAT.get(), e.getMessage());
            return inputCarNames();
        }
    }

    public static int inputTurn() {
        System.out.println(MessageType.INPUT_TURN_COUNT.get());
        String count = Console.readLine();
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return inputTurn();
        }
    }

    private static Cars mapToList(String inputCarNames) {
        List<Car> result = new ArrayList<>();
        String[] carNames = inputCarNames.split(DELIMITER);
        for (String carName : carNames) {
            result.add(Car.from(carName.trim()));
        }
        return Cars.from(result);
    }
}
