/*
 * Copyright (C) 2016 Lightbend Inc. <http://www.lightbend.com>
 */
package com.example.lagom.hello.impl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.withServer;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import akka.NotUsed;
import com.example.lagom.hello.api.GreetingMessage;
import com.example.lagom.hello.api.HelloService;

public class HelloServiceTest {

  @Test
  public void shouldStorePersonalizedGreeting() throws Exception {
    withServer(defaultSetup().withCassandra(true), server -> {
      HelloService service = server.client(HelloService.class);

      GreetingMessage msg1 = service.hello("Alice").invoke().toCompletableFuture().get(5, SECONDS);
      assertEquals(GreetingMessage.of("Hello, Alice!"), msg1); // default greeting

      service.useGreeting("Alice").invoke(GreetingMessage.of("Hi")).toCompletableFuture().get(5, SECONDS);
      GreetingMessage msg2 = service.hello("Alice").invoke().toCompletableFuture().get(5, SECONDS);
      assertEquals(GreetingMessage.of("Hi, Alice!"), msg2);

      GreetingMessage msg3 = service.hello("Bob").invoke().toCompletableFuture().get(5, SECONDS);
      assertEquals(GreetingMessage.of("Hello, Bob!"), msg3); // default greeting
    });
  }

}
