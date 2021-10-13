package racinggame;

import racinggame.commons.strategy.RandomMoveStrategy;
import racinggame.service.CarGameService;

public class Application {
    public static void main(String[] args) {
        CarGameService carGameService = CarGameService.from(RandomMoveStrategy.of());
        carGameService.play();
    }
}
