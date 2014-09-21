package com.james.codelib.guava.patterns.observer;

import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by james on 9/21/14.
 */
public class MessageReceiver {
    public static final Logger LOG = LoggerFactory.getLogger(MessageReceiver.class);

    @Subscribe
    public void receive(NotifyMessage message)
    {
        LOG.info("recive message :{}", message);
    }

    @Subscribe
    public void receive(ChildNotifyMessage message)
    {
        LOG.info("recive child message :{}", message);
    }

    @Subscribe
    public void startToken(String message)
    {
        LOG.info("got message :{}", message);
    }

    @Subscribe
    public void got(NotifyMessage message)
    {
        LOG.info("got message :{}", message);
    }


}
