package kooboot.process;

import kooboot.message.domain.Keyboard;
import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.Category;
import kooboot.user.domain.CategoryType;
import kooboot.user.domain.User;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ExceedRequestTimeHandlerTest {

    private RequestHandler handler;
    private User user;

    @Before
    public void setUp() throws Exception {
        handler = new ExceedRequestTimeHandler();
        user = User.builder().category(Category.valueOf(CategoryType.EXCEED)).build();
    }

    @Test
    public void handleTest() {
        ResponseMessage responseMessage = handler.handle(user);
        assertThat(user.getCategory().getCategoryType()).isEqualTo(CategoryType.INIT);
        assertThat(responseMessage.getKeyboard()).isEqualTo(Keyboard.DEFAULT_KEYBOARD);
        assertThat(responseMessage.getMessage().getText()).isEqualTo(ExceedRequestTimeHandler.DEFAULT_MESSAGE);
    }
}