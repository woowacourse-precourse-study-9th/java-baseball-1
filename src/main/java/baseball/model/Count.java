package baseball.model;

public enum Count {

    BALL("볼"),
    STRIKE("스트라이크"),
    NONE("낫싱");

    private final String kor;

    Count(String kor) {
        this.kor = kor;
    }

    public String getKor() {
        return kor;
    }
}
