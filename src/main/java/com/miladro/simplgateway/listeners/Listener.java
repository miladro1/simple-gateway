package com.miladro.simplgateway.listeners;

public interface Listener<M> {
    void listen(M message);
}
