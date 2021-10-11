package racinggame.domain;

import racinggame.utils.CommonValidator;

import java.util.*;

public class Cars {
    private List<Car> cars;

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        CommonValidator.validateNullOrEmpty(cars);
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void moveCars(List<Integer> randoms) {
        CommonValidator.validateNullOrEmpty(cars);
        validateRandomsSize(randoms);
        for (int i = 0; i < randoms.size(); ++i) {
            cars.get(i).move(randoms.get(i));
        }
    }

    public WinnerNames getWinners() {
        List<Car> copyCars = new ArrayList<>(cars);
        Car winnerCar = Collections.max(cars, Comparator.comparing(Car::getDistance));
        copyCars.removeIf(car -> car.isLose(winnerCar));
        return WinnerNames.of(copyCars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (cars.size() != nonDuplicateCars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }

    private void validateRandomsSize(List<Integer> randoms) {
        if (cars.size() != randoms.size()) {
            throw new IllegalArgumentException("[ERROR] randoms와 자동차 사이즈가 일치하지 않습니다.");
        }
    }
}
