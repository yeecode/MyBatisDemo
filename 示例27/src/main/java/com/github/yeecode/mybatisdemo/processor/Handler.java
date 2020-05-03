package com.github.yeecode.mybatisdemo.processor;

import com.github.yeecode.mybatisdemo.model.Performer;

public abstract class Handler {
    // 当前处理器的下一个处理器
    private Handler nextHandler;

    /**
     * 当前处理器的处理逻辑，交给子类实现
     * @param performer 被处理对象
     */
    public abstract void handle(Performer performer);

    /**
     * 触发当前处理器，并在处理结束后将被处理对象传给后续处理器
     * @param performer 被处理对象
     */
    public void triggerProcess(Performer performer) {
        handle(performer);
        if (nextHandler != null) {
            nextHandler.triggerProcess(performer);
        }
    }

    /**
     * 设置当前处理器的下一个处理器
     * @param nextHandler 下一个处理器
     * @return 下一个处理器
     */
    public Handler setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
        return nextHandler;
    }
}
