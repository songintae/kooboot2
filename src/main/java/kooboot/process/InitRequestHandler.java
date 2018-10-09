package kooboot.process;

import kooboot.message.domain.Keyboard;
import kooboot.message.domain.Message;
import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.User;
import org.springframework.stereotype.Component;


@Component
public class InitRequestHandler implements RequestHandler {

    public static final String DEFAULT_MESSAGE = "처음 단계로 진행됩니다. 원하시는 항목을 선택해주세요.";

    @Override
    public ResponseMessage handle(User user) {
        Message message = Message.builder().text(DEFAULT_MESSAGE).build();
        return  ResponseMessage.builder()
                .message(message)
                .keyboard(Keyboard.DEFAULT_KEYBOARD)
                .build();
    }
}
