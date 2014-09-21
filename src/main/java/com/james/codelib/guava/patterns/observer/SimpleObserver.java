package com.james.codelib.guava.patterns.observer;

import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 9/21/14.
 */
public class SimpleObserver {
    public static final Logger LOG = LoggerFactory.getLogger(SimpleObserver.class);

    public static void main(String[] args) {
        NotifyMessage message = new NotifyMessage();
        message.setId(1);
        message.setContext("context1");

        EventBus eventBus = new EventBus("message");
        MessageReceiver listener = new MessageReceiver();
        eventBus.register(listener);

        /**
         * 添加Subscribe申明即可添加监听
         * 支持多态，可以通过入参来添加对不同事件的监听
         */
        LOG.info("start common test.");
        eventBus.post("start token.");
        eventBus.post(message);

        /**
         * 发送未订阅的消息类型
         */
        LOG.info("start unsupported message test");
        eventBus.post(123);

        ChildNotifyMessage child = new ChildNotifyMessage();
        message.setId(2);
        message.setContext("context2");

        /**
         * 同样接收子类消息
         */
        LOG.info("start child test.");
        eventBus.post(child);
    }
}
