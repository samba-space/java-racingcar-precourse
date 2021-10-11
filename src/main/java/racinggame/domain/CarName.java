package racinggame.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public static CarName of(String name) {
        return new CarName(name);
    }

    private CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        String targetName = name != null ? name.trim() : null;
        if (targetName == null || targetName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 empty 또는 null 입니다.");
        }
        if (targetName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 5글자 초과입니다.");
        }
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
