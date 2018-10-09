package kooboot.web;

import kooboot.message.domain.Keyboard;
import kooboot.message.domain.RequestMessage;
import kooboot.support.SpringTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
public class MessageControllerTest extends SpringTest {

    private RequestMessage requestMessage;

    @Autowired
    private TestRestTemplate template;

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

}