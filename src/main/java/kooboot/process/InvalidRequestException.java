package kooboot.process;

import kooboot.common.AbstractException;
import kooboot.message.domain.Keyboard;
import kooboot.message.domain.Message;
import kooboot.message.domain.ResponseMessage;

public class InvalidRequestException extends AbstractException {
    @Override
    public ResponseMessage getResponseMessage() {
        Message message = Message.builder().text("잘못된 요청입니다. 처음 단계부터 다시 진행하시기 바랍니다.").build();
        return ResponseMessage.builder()
                .message(message)
                .keyboard(Keyboard.DEFAULT_KEYBOARD)
                .build();
    }
}
