package kooboot.web;


import kooboot.message.domain.Keyboard;
import kooboot.message.domain.RequestMessage;
import kooboot.message.domain.ResponseMessage;
import kooboot.process.FlowProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private FlowProcessor flowProcessor;
    @GetMapping("/keyboard")
    public Keyboard keyboard() {
        return Keyboard.DEFAULT_KEYBOARD;
    }

    @PostMapping("/message")
    public ResponseMessage message(@RequestBody RequestMessage requestMessage) throws Exception {
        return flowProcessor.process(requestMessage);
    }
}
