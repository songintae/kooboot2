package kooboot.process;

import kooboot.message.domain.ResponseMessage;
import kooboot.user.domain.User;

public interface RequestHandler {
    ResponseMessage handle(User user);
}
