package kooboot.message.domain;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Message {
    private String text;
    private MessageButton messageButton;
    private Photo photo;
}
