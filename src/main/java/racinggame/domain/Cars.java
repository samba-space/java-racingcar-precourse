package racinggame.domain;


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
        Objects.requireNonNull(consumer, "[ERROR] consumer가 null입니다.");
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
            throw new IllegalArgumentException("[ERROR] 자동차가 수가 " + MIN_CARS_SIZE + "보다 작습니다.");
        }
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (cars.size() != nonDuplicateCars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }
}
