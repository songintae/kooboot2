package kooboot.web;


import kooboot.message.domain.Keyboard;
import kooboot.message.domain.Message;
import kooboot.message.domain.RequestMessage;
import kooboot.message.domain.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("/keyboard")
    public Keyboard keyboard() {
        return new Keyboard()
                .addButton("번역")
                .addButton("검색");
    }

    @PostMapping("/message")
    public ResponseMessage message(@RequestBody RequestMessage requestMessage) throws Exception {
        return ResponseMessage.builder()
                .message(Message.builder()
                        .text("테스트 메시지 전송")
                        .build())
                .build();
    }
}
