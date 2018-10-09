package kooboot.process;

import kooboot.message.domain.RequestMessage;
import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.Category;
import kooboot.user.domain.CategoryType;
import kooboot.user.domain.ExceedCategory;
import kooboot.user.domain.User;
import kooboot.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class FlowProcessor {

    public static final int MAXIMUM_REQ_INTERVAL_TIME = 5;

    @Autowired
    private UserService userService;

    @Autowired
    private Map<String, RequestHandler> requestHandlerMap;

    User preHandle(RequestMessage requestMessage) {
        User user = userService.findByRequestMessage(requestMessage);
        user.renewalLastRequestTime();
        user.renewalCategory(requestMessage);
        if (user.isExceededRequestTime())
            user.setCategory(Category.valueOf(CategoryType.EXCEED));
        return user;
    }

    public ResponseMessage process(RequestMessage requestMessage) {
        User user = null;
        try {
            user = preHandle(requestMessage);
            return  getRequestHandler(user.getCategory()).handle(user);
        } catch (InvalidRequestException e) {
            return e.getResponseMessage();
        } finally {
            postHandle(user);
        }
    }

    User postHandle(User user) {
        return userService.save(user);
    }


    RequestHandler getRequestHandler(Category category) {
        switch (category.getCategoryType()) {
            case EXCEED:
                return requestHandlerMap.get("exceedRequestTimeHandler");
            case INIT:
                return requestHandlerMap.get("initRequestHandler");
            default:
                throw new InvalidRequestException();
        }
    }


}
