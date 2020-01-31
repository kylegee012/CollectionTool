package com.app.collectiontool;

import ratpack.handling.Context;
import ratpack.handling.Handler;

public class Router implements Handler {
    private final Handler fooHandler = new FooHandler();
    private final Handler barHandler = new BarHandler();

    public void handle(Context context) {
        String path = context.getRequest().getPath();
        if (path.equals("foo")) {
            context.insert(fooHandler);
        } else if (path.equals("bar")) {
            context.insert(barHandler);
        } else {
            context.next();
        }
    }
}