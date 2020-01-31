package com.app.collectiontool.handlers;

import com.app.collectiontool.domain.Gadget;
import com.app.collectiontool.repository.GadgetRepository;
import ratpack.handling.Context;
import ratpack.handling.InjectionHandler;
import ratpack.http.Response;
import ratpack.jackson.Jackson;

import java.util.stream.Collectors;

public class GadgetHandler extends InjectionHandler {
  public void handle(Context ctx, GadgetRepository repo, String base) throws Exception {
    Response response = ctx.getResponse();

    ctx.byMethod(byMethodSpec -> byMethodSpec
      .options(() -> {
        response.getHeaders().set("Access-Control-Allow-Methods", "OPTIONS, GET, POST, DELETE");
        response.send();
      })
      .get(() ->
        repo.getAll()
          .map(gadgets -> gadgets.stream()
            .map(gadget -> gadget.baseUrl(base))
            .collect(Collectors.toList()))
          .map(Jackson::json)
          .then(ctx::render)
      )
      .post(() ->
        ctx.parse(Jackson.fromJson(Gadget.class))
          .flatMap(repo::add)
          .map(gadget -> gadget.baseUrl(base))
          .map(Jackson::json)
          .then(ctx::render)
      ).patch(() ->
                    ctx.parse(Jackson.fromJson(Gadget.class))
                            .flatMap(repo::add)
                            .map(gadget -> gadget.baseUrl(base))
                            .map(Jackson::json)
                            .then(ctx::render)
            )
    ).patch(() ->
            ctx.parse(Jackson.fromJson(Gadget.class))
                    .flatMap(repo::add)
                    .map(gadget -> gadget.baseUrl(base))
                    .map(Jackson::json)
                    .then(ctx::render)
    )
      .delete(() -> repo.deleteAll().then(response::send));
  }
}
