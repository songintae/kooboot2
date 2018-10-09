package kooboot.common;

import kooboot.message.domain.ResponseMessage;

public abstract class AbstractException extends RuntimeException {
    public abstract ResponseMessage getResponseMessage();
}
