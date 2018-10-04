package kooboot.process;

import kooboot.message.domain.RequestMessage;
import kooboot.support.SpringTest;
import kooboot.user.domain.Category;
import kooboot.user.domain.User;
import kooboot.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class FlowProcessorTest extends SpringTest {

    @Autowired
    private UserService userService;

    @Autowired
    private FlowProcessor flowProcessor;

    private RequestMessage noneExistUserRequestMessage;
    private RequestMessage existUserRequestMessage;

    @Before
    public void setUp() throws Exception {
        noneExistUserRequestMessage = RequestMessage.builder().user_key("none").content("번역").type("텍스트").build();
        existUserRequestMessage = RequestMessage.builder().user_key("exist").content("번역").type("텍스트").build();
        User user = User.valueOf(existUserRequestMessage);
        user.setCategory(Category.TRANSLATE);
        userService.save(user);
    }

    @Test
    @Transactional
    public void preHandlerTest() {
        User newUser = flowProcessor.preHandle(noneExistUserRequestMessage);
        assertThat(newUser.getCategory()).isEqualTo(Category.INIT);

        User existUser = flowProcessor.preHandle(existUserRequestMessage);
        assertThat(existUser.getCategory()).isEqualTo(Category.TRANSLATE);
    }

}