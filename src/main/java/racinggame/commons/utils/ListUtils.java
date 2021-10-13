package racinggame.commons.utils;

import java.util.List;

public class ListUtils {
    private ListUtils() {
    }

    public static <T extends List> void validateNullOrEmpty(T params) {
        if (params == null || params.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] params가 null이거나 empty입니다.");
        }
    }
}
