package racinggame;

import racinggame.service.CarGameService;

public class Application {
    public static void main(String[] args) {
        CarGameService carGameService = CarGameService.of();
        carGameService.play();
    }
}
