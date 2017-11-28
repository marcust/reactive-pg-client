package com.julienviet.pgclient;

import io.vertx.core.Vertx;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 * @author <a href="mailto:emad.albloushi@gmail.com">Emad Alblueshi</a>
 */
@RunWith(VertxUnitRunner.class)
public abstract class DataTypeTestBase extends PgTestBase {
  Vertx vertx;
  PgClient client;

  protected abstract PgClientOptions options();

  @Before
  public void setup() {
    vertx = Vertx.vertx();
    client = PgClient.create(vertx, options());
  }

  @After
  public void teardown(TestContext ctx) {
    vertx.close(ctx.asyncAssertSuccess());
  }
}
