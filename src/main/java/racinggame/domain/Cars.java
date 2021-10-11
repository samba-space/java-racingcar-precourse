package racinggame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    private Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    private void validate(List<Car> cars) {
        validateNullOrException(cars);
        validateDuplicateCarName(cars);
    }

    private void validateNullOrException(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] cars가 null이거나 empty입니다.");
        }
    }

    private void validateDuplicateCarName(List<Car> cars) {
        Set<Car> nonDuplicateCars = new HashSet<>(cars);
        if (cars.size() != nonDuplicateCars.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 중복됐습니다.");
        }
    }
}
