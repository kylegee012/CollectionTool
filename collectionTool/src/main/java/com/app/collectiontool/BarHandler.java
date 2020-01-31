package com.app.collectiontool;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class BarHandler implements Handler {
    public void handle(Context context) {
        context.getResponse().send("bar");
    }
}