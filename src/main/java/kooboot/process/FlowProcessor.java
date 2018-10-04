package kooboot.process;

import kooboot.message.domain.Message;
import kooboot.message.domain.RequestMessage;
import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.User;
import kooboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FlowProcessor {

    public static final int MAXIMUM_REQ_INTERVAL_TIME = 5;

    @Autowired
    private UserService userService;

    User preHandle(RequestMessage requestMessage) {
        User user = userService.findByRequestMessage(requestMessage);
        user.renewalLastRequestTime();

//        if(user.isExceededRequestTime())

        return user;
    }

    public ResponseMessage process(RequestMessage requestMessage) {
        User user = preHandle(requestMessage);
        try{
            return ResponseMessage.builder()
                    .message(Message.builder()
                            .text("테스트 메시지 전송")
                            .build())
                    .build();
        }catch(Exception e){
            return ResponseMessage.builder()
                    .message(Message.builder()
                            .text("테스트 메시지 전송")
                            .build())
                    .build();
        }finally {
            postHandle(user);
        }

    }

    User postHandle(User user) {
        return userService.save(user);
    }




}
