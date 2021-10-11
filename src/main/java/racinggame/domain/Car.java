package racinggame.domain;

public class Car {
    private static final int START_DISTANCE = 0;
    private static final int DEFAULT_ADD_DISTANCE = 1;

    private final CarName carName;
    private final Distance distance;

    public static Car ready(String carName) {
        return new Car(carName, START_DISTANCE);
    }

    private Car(String carName, int distance) {
        this.carName = CarName.of(carName);
        this.distance = Distance.of(distance);
    }

    public int move() {
        return distance.addDistance(DEFAULT_ADD_DISTANCE);
    }
}
