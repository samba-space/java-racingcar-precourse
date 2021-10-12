package racinggame.domain;

import racinggame.utils.CommonValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinnerNames {
    private final List<String> winnerNames;

    private WinnerNames(List<Car> winnerCars) {
        CommonValidator.validateNullOrEmpty(winnerCars);
        this.winnerNames = mapWinnerNames(winnerCars);
    }

    public static WinnerNames of(List<Car> winnerCars) {
        return new WinnerNames(winnerCars);
    }

    private List<String> mapWinnerNames(List<Car> winnerCars) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winnerCar : winnerCars) {
            winnerNames.add(winnerCar.getCarName());
        }
        return winnerNames;
    }

    public List<String> getWinnerNames() {
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
