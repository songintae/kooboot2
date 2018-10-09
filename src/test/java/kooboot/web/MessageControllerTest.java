package kooboot.web;

import kooboot.message.domain.Keyboard;
import kooboot.message.domain.RequestMessage;
import kooboot.message.domain.ResponseMessage;
import kooboot.process.InitRequestHandler;
import kooboot.support.SpringTest;
import kooboot.user.domain.Category;
import kooboot.user.domain.CategoryType;
import kooboot.user.domain.User;
import kooboot.user.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
public class MessageControllerTest extends SpringTest {

    private RequestMessage requestMessage;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private UserService userService;


    @Before
    public void setUp() throws Exception {
        requestMessage = RequestMessage.builder().user_key("ATDD").type("text").build();
    }

    @Test
    public void keyboardTest() {
        ResponseEntity<Keyboard> responseEntity = template.getForEntity("/keyboard", Keyboard.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        Keyboard keyboard = responseEntity.getBody();
        assertThat(keyboard.getButtons().size()).isEqualTo(2);
    }

    @Test
    public void 유저상태_처음단계로_이동() {
        User user = User.builder()
                .userKey("user1")
                .category(Category.valueOf(CategoryType.TRANSLATE))
                .lastRequestTime(new Date())
                .build();
        userService.save(user);

        RequestMessage requestMessage = RequestMessage.builder()
                .user_key("user1")
                .type("text")
                .content("처음")
                .build();
        ResponseEntity<ResponseMessage> responseEntity
                = template.postForEntity("/message", requestMessage, ResponseMessage.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getKeyboard()).isEqualTo(Keyboard.DEFAULT_KEYBOARD);
        assertThat(responseEntity.getBody().getMessage().getText()).isEqualTo(InitRequestHandler.DEFAULT_MESSAGE);
    }

}