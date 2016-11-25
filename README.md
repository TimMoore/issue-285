Reproduction of https://github.com/lagom/lagom/issues/285

1. Run `mvn lagom:runAll`
2. Use http://www.websocket.org/echo.html to connect to `ws://localhost:9000/stream`
3. Send any message
4. An error will be logged to the console:
   ```
   [error] stream - Exception in NamedCallId{name='stream'}
   com.lightbend.lagom.javadsl.api.deser.DeserializationException: Could not find creator property with name 'json' (in class com.example.lagom.hello.api.GreetingMessage)
    at [Source: akka.util.ByteIterator$ByteArrayIterator$$anon$1@53bb9d30; line: 1, column: 1]
   	at com.lightbend.lagom.javadsl.jackson.JacksonSerializerFactory$JacksonMessageSerializer$JacksonDeserializer.deserialize(JacksonSerializerFactory.java:127) ~[lagom-javadsl-jackson_2.11-1.2.0.jar:1.2.0]
   	at com.lightbend.lagom.javadsl.jackson.JacksonSerializerFactory$JacksonMessageSerializer$JacksonDeserializer.deserialize(JacksonSerializerFactory.java:115) ~[lagom-javadsl-jackson_2.11-1.2.0.jar:1.2.0]
   	at com.lightbend.lagom.internal.client.ClientServiceCallInvoker$$anonfun$com$lightbend$lagom$internal$client$ClientServiceCallInvoker$$makeStrictCall$1.apply(ServiceClientImplementor.scala:327) ~[lagom-javadsl-client_2.11-1.2.0.jar:1.2.0]
   	at com.lightbend.lagom.internal.client.ClientServiceCallInvoker$$anonfun$com$lightbend$lagom$internal$client$ClientServiceCallInvoker$$makeStrictCall$1.apply(ServiceClientImplementor.scala:311) ~[lagom-javadsl-client_2.11-1.2.0.jar:1.2.0]
   	at scala.util.Success$$anonfun$map$1.apply(Try.scala:237) ~[scala-library-2.11.8.jar:na]
   	at scala.util.Try$.apply(Try.scala:192) ~[scala-library-2.11.8.jar:na]
   	at scala.util.Success.map(Try.scala:237) ~[scala-library-2.11.8.jar:na]
   	at scala.concurrent.Future$$anonfun$map$1.apply(Future.scala:237) ~[scala-library-2.11.8.jar:na]
   	at scala.concurrent.Future$$anonfun$map$1.apply(Future.scala:237) ~[scala-library-2.11.8.jar:na]
   	at scala.concurrent.impl.CallbackRunnable.run(Promise.scala:32) ~[scala-library-2.11.8.jar:na]
   Caused by: com.fasterxml.jackson.databind.JsonMappingException: Could not find creator property with name 'json' (in class com.example.lagom.hello.api.GreetingMessage)
    at [Source: akka.util.ByteIterator$ByteArrayIterator$$anon$1@53bb9d30; line: 1, column: 1]
   	at com.fasterxml.jackson.databind.JsonMappingException.from(JsonMappingException.java:216) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.DeserializationContext.mappingException(DeserializationContext.java:894) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.addBeanProps(BeanDeserializerFactory.java:541) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.buildBeanDeserializer(BeanDeserializerFactory.java:228) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.BeanDeserializerFactory.createBeanDeserializer(BeanDeserializerFactory.java:143) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.DeserializerCache._createDeserializer2(DeserializerCache.java:406) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.DeserializerCache._createDeserializer(DeserializerCache.java:352) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.DeserializerCache._createAndCache2(DeserializerCache.java:264) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.DeserializerCache._createAndCacheValueDeserializer(DeserializerCache.java:244) ~[jackson-databind-2.7.1.jar:2.7.1]
   	at com.fasterxml.jackson.databind.deser.DeserializerCache.findValueDeserializer(DeserializerCache.java:142) ~[jackson-databind-2.7.1.jar:2.7.1]
   ```
