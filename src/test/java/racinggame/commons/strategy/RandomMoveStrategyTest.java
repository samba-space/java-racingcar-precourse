package racinggame.commons.strategy;

import nextstep.utils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;


public class RandomMoveStrategyTest {

    private RandomMoveStrategy strategy;
    private static MockedStatic<Randoms> randoms;

    @BeforeAll
    static void setUpAll() {
        randoms = Mockito.mockStatic(Randoms.class);
    }

    @BeforeEach
     void setUp() {
        strategy = RandomMoveStrategy.of();
    }

    @DisplayName("random 숫자가 주어질 때, 해당하는 조건만큼 이동한다.")
    @ParameterizedTest(name = "[{index}] moveAbleEnergy={0}, addDistance={1}")
    @CsvSource(value = {"4,1", "3,0"})
    void 가야할_거리를_반환한다(int pickNumber, int addDistance) {
        //given
        randoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(pickNumber);

        //when
        int movedDistance = strategy.getMoveDistance();

        //then
        Assertions.assertThat(movedDistance).isEqualTo(addDistance);
    }
}
