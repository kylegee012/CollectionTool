package com.app.collectiontool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ratpack.handling.Handler;
import ratpack.server.RatpackServer;

import java.io.ObjectInputFilter;

@SpringBootApplication
public class CollectionToolApplication {



	public static void main(String[] args) throws Exception {
		RatpackServer.start(server -> server.handlers(chain -> chain
				.get(ctx -> ctx.render("Welcome to Baeldung ratpack!!!"))));
	}

//		RatpackServer.start(server -> server
//				.handlers(
//						chain -> chain
//						.get(ctx -> ctx.render("Hello World!"))
//						.path("foo", ctx ->
//								ctx.byMethod(m -> m
//										.get(() -> ctx.render("GET"))
//										.post(() -> ctx.render("POST"))
//								)
//						)
//				.get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!")
//				)
//			)
		//);



//		EmbeddedApp.fromHandlers(c -> c
//				.path("foo", ctx ->
//						ctx.byMethod(m -> m
//								.get(() -> ctx.render("GET"))
//								.post(() -> ctx.render("POST"))
//						)
//				)
//		);

//		final Handler router = new FooHandler();
//		RatpackServer.start(server -> server
//				.handlers(
////						context.insert(router);
//
//						chain -> chain
//						.get(ctx -> ctx.render("Hello World!"))
//						.get(ctx->ctx.insert(router))
////						.get(":name", ctx -> ctx.render("Hello " + ctx.getPathTokens().get("name") + "!")
//
//
//				)
//		);
	}

