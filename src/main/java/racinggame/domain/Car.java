package racinggame.domain;

import racinggame.commons.strategy.MoveStrategy;

import java.util.Objects;

public class Car {
    private static final int START_DISTANCE = 0;

    private final CarName carName;
    private final Distance distance;

    private Car(String carName, int distance) {
        this.carName = CarName.from(carName);
        this.distance = Distance.from(distance);
    }

    public static Car from(String carName) {
        return new Car(carName, START_DISTANCE);
    }

    public static Car of(String carName, int distance) {
        return new Car(carName, distance);
    }

    public void move(MoveStrategy moveStrategy) {
        Objects.requireNonNull(moveStrategy, "[ERROR] moveStrategy가 null입니다.");
        distance.addDistance(moveStrategy.getMoveDistance());
    }

    public boolean isLose(Car otherCar) {
        Objects.requireNonNull(otherCar, "[ERROR] otherCar가 null입니다.");
        return getDistance() < otherCar.getDistance();
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
}
