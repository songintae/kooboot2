package kooboot.message.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Photo {
    private String url;
    private String width;
    private String height;
}