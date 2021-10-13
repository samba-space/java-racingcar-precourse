package racinggame.domain;

import racinggame.commons.utils.CommonValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinnerNames {
    private final List<CarName> winnerNames;

    private WinnerNames(List<Car> winnerCars) {
        CommonValidator.validateNullOrEmpty(winnerCars);
        this.winnerNames = mapToWinnerNames(winnerCars);
    }

    public static WinnerNames from(List<Car> winnerCars) {
        return new WinnerNames(winnerCars);
    }

    private List<CarName> mapToWinnerNames(List<Car> winnerCars) {
        List<CarName> winnerNames = new ArrayList<>();
        for (Car winnerCar : winnerCars) {
            winnerNames.add(CarName.from(winnerCar.getCarName()));
        }
        return winnerNames;
    }

    public List<CarName> getWinnerNames() {
        return winnerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinnerNames that = (WinnerNames) o;
        return Objects.equals(winnerNames, that.winnerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNames);
    }

    @Override
    public String toString() {
        return "WinnerNames{" +
                "winnerNames=" + winnerNames +
                '}';
    }
}
