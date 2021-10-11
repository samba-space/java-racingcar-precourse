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
        validateNullOrException(cars);
        validateDuplicateCarName(cars);
        this.cars = cars;
    }

    public void moveCars(List<Integer> randoms) {
        validateNullOrException(randoms);
        validateRandomsSize(randoms);
        for (int i = 0; i < randoms.size(); ++i) {
            cars.get(i).move(randoms.get(i));
        }
    }

    private <T> void validateNullOrException(List<T> params) {
        if (params == null || params.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] params가 null이거나 empty입니다.");
        }
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
