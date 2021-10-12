package racinggame.domain;

import java.util.Objects;

public class Distance {
    private static final int MIN_DISTANCE = 0;
    private static final int MIN_ADD_DISTANCE = 1;

    private int distance;

    private Distance(int distance) {
        validateDistance(distance);
        this.distance = distance;
    }

    public static Distance of(int distance) {
        return new Distance(distance);
    }

    public int addDistance(int distance) {
        validateAddDistance(distance);
        this.distance += distance;
        return this.distance;
    }

    public int getDistance() {
        return distance;
    }

    private void validateDistance(int distance) {
        if (distance < MIN_DISTANCE) {
            throw new IllegalArgumentException("[ERROR] 거리가 0보다 작습니다.");
        }
    }

    private void validateAddDistance(int distance) {
        if (distance < MIN_ADD_DISTANCE) {
            throw new IllegalArgumentException("[ERROR] 더할 거리가 1보다 작습니다.");
        }
        long addedDistance = (long) this.distance + distance;
        if (addedDistance > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("[ERROR] 이동 가능 거리를 초과했습니다.");
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
