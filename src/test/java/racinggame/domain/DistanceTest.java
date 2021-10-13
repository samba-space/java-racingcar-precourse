package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {

    private Distance distance;

    @BeforeEach
    void setUp() {
        distance = Distance.from(0);
    }

    @DisplayName("거리가 0을 포함한 정수인 경우, 정상적으로 생성된다.")
    @ParameterizedTest(name = "[{index}] distance={0}")
    @ValueSource(ints = {0, 10, Integer.MAX_VALUE})
    void 거리_생성_정상(int distance) {
        assertThatCode(() -> Distance.from(distance)).doesNotThrowAnyException();
    }

    @DisplayName("거리가 음수인 경우, IllegalArgumentException이 발생한다.")
    @Test
    void 거리_생성_비정상() {
        assertThatThrownBy(() -> Distance.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 거리가 0보다 작습니다.");
    }

    @DisplayName("거리가 0보다 큰 정수인 경우, 정상적으로 더해진다.")
    @Test
    void 거리_더하기() {
        //given
        int expectedDistance = 1;

        //when
        distance.addDistance(1);
        int result = distance.getDistance();

        //then
        assertThat(result).isEqualTo(expectedDistance);
    }

    @DisplayName("거리가 0미만인 경우, IllegalArgumentException이 발생한다.")
    @ParameterizedTest(name = "[{index}] addDistance={0}")
    @ValueSource(ints = {-2, -1})
    void 거리입력_0미만_거리_더하기_예외발생(int inputDistance) {
        assertThatThrownBy(() -> distance.addDistance(inputDistance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 거리가 0보다 작습니다.");
    }

    @DisplayName("기존 거리와 입력거리를 더한 수가 int max 범위를 넘은 경우 IllegalArgumentException이 발생한다.")
    @Test
    void 기존거리_더하기_입력거리_범위초과_예외발생() {
        //given
        Distance distance = Distance.from(Integer.MAX_VALUE);
        int inputDistance = 1;

        //when, then
        assertThatThrownBy(() -> distance.addDistance(inputDistance))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동 가능 거리를 초과했습니다.");
    }
}
