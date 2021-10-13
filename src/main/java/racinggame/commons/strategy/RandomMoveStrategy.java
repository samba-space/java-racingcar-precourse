package racinggame.commons.strategy;

import nextstep.utils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;
    private static final int MOVE_ABLE_ENERGY = 4;
    private static final int ADD_DISTANCE = 1;
    private static final int STOP_DISTANCE = 0;

    public static RandomMoveStrategy of() {
        return new RandomMoveStrategy();
    }
    @Override
    public int getMoveDistance() {
        if (Randoms.pickNumberInRange(RANGE_START, RANGE_END) >= MOVE_ABLE_ENERGY) {
            return ADD_DISTANCE;
        }
        return STOP_DISTANCE;
    }
}
