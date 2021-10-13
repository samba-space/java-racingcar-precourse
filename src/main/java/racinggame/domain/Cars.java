package racinggame.domain;


import racinggame.commons.message.MessageType;
import racinggame.commons.utils.ListUtils;

import java.util.*;
import java.util.function.Consumer;

public class Cars {
    private static int MIN_CARS_SIZE = 2;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        ListUtils.validateNullOrEmpty(cars);
        validateMinCarsSize(cars);
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public void moveCars(Consumer<Car> consumer) {
        Objects.requireNonNull(consumer, MessageType.ERROR_PARAM_NULL.get());
        for (Car car : cars) {
            consumer.accept(car);
        }
    }

    public WinnerNames getWinners() {
        List<Car> copyCars = new ArrayList<>(cars);
        Car winnerCar = Collections.max(cars, Comparator.comparing(Car::getDistance));
        copyCars.removeIf(car -> car.isLose(winnerCar));
        return WinnerNames.from(copyCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void validateMinCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException(MessageType.ERROR_CAR_SIZE_ERROR.get());
        }
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (cars.size() != nonDuplicateCars.size()) {
            throw new IllegalArgumentException(MessageType.ERROR_DUP_CAR_NAME.get());
        }
    }
}
