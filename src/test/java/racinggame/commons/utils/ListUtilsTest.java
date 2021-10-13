package racinggame.commons.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racinggame.commons.message.MessageType;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ListUtilsTest {

    @DisplayName("params가 null 또는 empty가 아닐 경우 정상 실행된다.")
    @Test
    void 정상_실행() {
        assertThatCode(() -> ListUtils.validateNullOrEmpty(Arrays.asList(1,2,3))).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "[{index}] params={0}")
    @NullAndEmptySource
    void 변환_에러발생(List<Integer> params) {
        assertThatThrownBy(() -> ListUtils.validateNullOrEmpty(params))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageType.ERROR_EMPTY_NULL.get());
    }
}
