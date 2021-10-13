package racinggame.commons.message;

public enum MessageType {

    ERROR_EMPTY_NULL("params가 null이거나 empty입니다."),
    ERROR_PARAM_NULL("parameter가 null입니다."),
    ERROR_CAR_NAME_EMPTY_NULL("자동차 이름이 empty 또는 null 입니다."),
    ERROR_CAR_NAME_SIZE("자동차 이름이 5글자 초과입니다."),
    ERROR_CAR_SIZE_ERROR("자동차 수가 2보다 작습니다."),
    ERROR_DUP_CAR_NAME("자동차 이름이 중복됐습니다."),
    ERROR_MIN_DISTANCE("거리가 0보다 작습니다."),
    ERROR_EXCESS_DISTANCE("이동 가능 거리를 초과했습니다."),
    INPUT_RACING_CAR("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TURN_COUNT("시도할 회수는 몇회인가요?"),
    OUTPUT_EXECUTION("\n실행 결과"),
    OUTPUT_TURN_RESULT_FORMAT("%s : %s\n"),
    OUTPUT_WINNER_FORMAT("최종 우승자는 %s 입니다.\n"),
    ERROR_NUMBER_FORMAT("숫자를 입력하세요."),
    ERROR_FORMAT("[ERROR] %s\n");



    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
