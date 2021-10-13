package racinggame.domain;

import racinggame.commons.message.MessageType;

import java.util.Objects;

public class Distance {
    private static final int MIN_DISTANCE = 0;

    private int distance;

    private Distance(int distance) {
        validateDistance(distance);
        this.distance = distance;
    }

    public static Distance from(int distance) {
        return new Distance(distance);
    }

    public void addDistance(int distance) {
        validateAddDistance(distance);
        this.distance += distance;
    }

    public int getDistance() {
        return distance;
    }

    private void validateDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException(MessageType.ERROR_MIN_DISTANCE.get());
        }
    }

    private void validateAddDistance(int distance) {
        validateDistance(distance);
        long addedDistance = (long) this.distance + distance;
        if (addedDistance > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(MessageType.ERROR_EXCESS_DISTANCE.get());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance1 = (Distance) o;
        return getDistance() == distance1.getDistance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDistance());
    }

    @Override
    public String toString() {
        return "Distance{" +
                "distance=" + distance +
                '}';
    }
}
