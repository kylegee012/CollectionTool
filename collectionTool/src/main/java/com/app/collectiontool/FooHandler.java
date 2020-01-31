package com.app.collectiontool;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class FooHandler implements Handler {
    public void handle(Context context) {
        context.getResponse().send("foo");
    }
}