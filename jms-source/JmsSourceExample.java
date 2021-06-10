// camel-k: language=java
// camel-k: dependency=camel:camel-quarkus-jms
// camel-k: dependency=camel:camel-quarkus-timer property=period=1000
// camel-k: dependency=mvn:com.github.javafaker:javafaker:1.0.2

/*
 * The above statements provide information required for running the example. This includes
 * the metadata informing the language used by this code and the dependencies used by
 * Camel K to run this example.
 * As for the dependencies, these are:
 * - camel-quarkus-jms and camel-quarkus-timer, which are from Camel, thus resolved
 * automatically (hence the prefix notation "camel:")
 * - The fully qualified Maven name of JavaFaker dependency, used to generate fake data
 */

import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.github.javafaker.Faker;

public class JmsSourceExample extends RouteBuilder {
  @Override
  public void configure() throws Exception {
      /*
       * Explanation, method by method:
       *
       * - to("jms:{{jms.destinationType}}:{{jms.destinationName}}")
       * Consumes data from the JMS destination configured on the configuration
       * file
       *
       * - to("log:info")
       * Logs the generated fake person name and address to the logger using the info level
       *
       */
      from("jms:{{jms.destinationType}}:{{jms.destinationName}}")
        .to("log:info");
  }
}
