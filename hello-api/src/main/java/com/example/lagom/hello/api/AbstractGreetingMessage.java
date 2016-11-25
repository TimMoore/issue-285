package com.example.lagom.hello.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lightbend.lagom.javadsl.immutable.ImmutableStyle;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableStyle
@JsonDeserialize(as = GreetingMessage.class)
public interface AbstractGreetingMessage {
    @Value.Parameter
    String getMessage();
}
