package kooboot.process;


import kooboot.message.domain.Keyboard;
import kooboot.message.domain.Message;
import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.Category;
import kooboot.user.domain.CategoryType;
import kooboot.user.domain.User;
import org.springframework.stereotype.Component;


@Component
public class ExceedRequestTimeHandler implements RequestHandler {

    public static final String DEFAULT_MESSAGE = "요청시간이 초과되었습니다. 처음상태로 되돌아갑니다.";

    @Override
    public ResponseMessage handle(User user) {
        user.setCategory(Category.valueOf(CategoryType.INIT));
        Message message = Message.builder().text(DEFAULT_MESSAGE).build();
        return  ResponseMessage.builder()
                .message(message)
                .keyboard(Keyboard.DEFAULT_KEYBOARD)
                .build();
    }
}
