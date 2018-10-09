package kooboot.user.domain;


import java.util.Arrays;

public enum CategoryType {
    EXCEED("요청시간초과"),
    INIT("처음"),
    SEARCH("검색"),
    TRANSLATE("번역");



    private String code;

    CategoryType(String code) {
        this.code = code;
    }


    public static CategoryType of(String value) {
        return Arrays.stream(values()).filter(category -> category.getCode().equals(value)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public String getCode() {
        return this.code;
    }
}
