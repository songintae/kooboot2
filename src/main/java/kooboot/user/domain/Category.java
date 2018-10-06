package kooboot.user.domain;


import java.util.Arrays;

public enum Category {

    INIT("초기상태"),
    SEARCH("검색"),
    TRANSLATE("번역");


    private String code;

    Category(String code) {
        this.code = code;
    }


    public static Category of(String value) {
        return Arrays.stream(values()).filter(category -> category.getCode() == value).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getCode() {
        return this.code;
    }
}
