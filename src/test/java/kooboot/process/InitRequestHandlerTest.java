package kooboot.process;

import kooboot.message.domain.Keyboard;
import kooboot.message.domain.ResponseMessage;
import kooboot.support.SpringTest;
import kooboot.user.domain.Category;
import kooboot.user.domain.CategoryType;
import kooboot.user.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


public class InitRequestHandlerTest extends SpringTest {


    @Autowired
    private InitRequestHandler initRequestHandler;


    @Test
    public void handleTest() {
        User user = User.builder()
                .category(Category.valueOf(CategoryType.INIT))
                .userKey("user1")
                .lastRequestTime(new Date())
                .build();
        ResponseMessage responseMessage =  initRequestHandler.handle(user);
        assertThat(responseMessage.getKeyboard()).isEqualTo(Keyboard.DEFAULT_KEYBOARD);
        assertThat(responseMessage.getKeyboard()).isEqualTo(InitRequestHandler.DEFAULT_MESSAGE);

    }
}