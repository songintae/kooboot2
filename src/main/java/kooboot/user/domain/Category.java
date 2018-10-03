package kooboot.user.domain;


import java.util.Arrays;

public enum Category {

    INIT(0),
    SEARCH(1),
    TRANSLATE(2);


    private long code;

    Category(long code) {
        this.code = code;
    }


    public static Category valueOf(long value) {
        return Arrays.stream(values()).filter(category -> category.getCode() == value).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public long getCode() {
        return this.code;
    }
}
