package com.biasedbit.nettytutorials.handshake.common;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.Channels;

/**
 * @author <a href="mailto:bruno@biasedbit.com">Bruno de Carvalho</a>
 */
public class HandshakeEvent implements ChannelEvent {

    // internal vars ----------------------------------------------------------

    private final boolean successful;
    private final Channel channel;

    // constructors -----------------------------------------------------------

    private HandshakeEvent(boolean successful, Channel channel) {
        this.successful = successful;
        this.channel = channel;
    }

    // public static methods --------------------------------------------------

    public static HandshakeEvent handshakeSucceeded(Channel channel) {
        return new HandshakeEvent(true, channel);
    }

    public static HandshakeEvent handshakeFailed(Channel channel) {
        return new HandshakeEvent(false, channel);
    }

    // ChannelEvent -----------------------------------------------------------

    @Override
    public Channel getChannel() {
        return this.channel;
    }

    @Override
    public ChannelFuture getFuture() {
        return Channels.succeededFuture(this.channel);
    }

    // getters & setters ------------------------------------------------------

    public boolean isSuccessful() {
        return successful;
    }
}