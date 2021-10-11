package racinggame.domain;

import java.util.Objects;

public class Car {
    private static final int START_DISTANCE = 0;
    private static final int DEFAULT_ADD_DISTANCE = 1;
    private static final int MOVE_ABLE_ENERGY = 4;

    private final CarName carName;
    private final Distance distance;

    public static Car ready(String carName) {
        return new Car(carName, START_DISTANCE);
    }

    public static Car of(String carName, int distance) {
        return new Car(carName, distance);
    }

    private Car(String carName, int distance) {
        this.carName = CarName.of(carName);
        this.distance = Distance.of(distance);
    }

    public int move(int energy) {
        if(energy < MOVE_ABLE_ENERGY)
            return distance.getDistance();
        return distance.addDistance(DEFAULT_ADD_DISTANCE);
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public String getCarName() {
        return carName.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName=" + carName +
                ", distance=" + distance +
                '}';
    }

    public boolean isLose(Car maxCar) {
        return getDistance() < maxCar.getDistance();
    }
}
