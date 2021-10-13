package racinggame.commons.utils;

import racinggame.commons.message.MessageType;

import java.util.List;

public class ListUtils {
    private ListUtils() {
    }

    public static <T> void validateNullOrEmpty(List<T> params) {
        if (params == null || params.isEmpty()) {
            throw new IllegalArgumentException(MessageType.ERROR_EMPTY_NULL.get());
        }
    }
}
