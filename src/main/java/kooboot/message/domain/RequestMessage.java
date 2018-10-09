package kooboot.message.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestMessage {
    private String user_key;
    private String type;
    private String content;
}
