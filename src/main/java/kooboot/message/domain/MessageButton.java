package kooboot.message.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MessageButton {
    private String label;
    private String url;
}
