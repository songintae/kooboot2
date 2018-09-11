package kooboot.message.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMessage {
    private String user_key;
    private String type;
    private String content;
}
