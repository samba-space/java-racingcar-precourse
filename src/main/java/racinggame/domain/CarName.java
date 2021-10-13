package racinggame.domain;

import racinggame.commons.message.MessageType;

import java.util.Objects;

public class CarName {
    private static final int DEFAULT_NAME_SIZE = 5;

    private final String name;

    private CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    private void validateCarName(String name) {
        String targetName = name != null ? name.trim() : null;
        if (targetName == null || targetName.isEmpty()) {
            throw new IllegalArgumentException(MessageType.ERROR_CAR_NAME_EMPTY_NULL.get());
        }
        if (targetName.length() > DEFAULT_NAME_SIZE) {
            throw new IllegalArgumentException(MessageType.ERROR_CAR_NAME_SIZE.get());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName = (CarName) o;
        return Objects.equals(name, carName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }
}
