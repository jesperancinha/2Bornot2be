package org.jesperancinha.jtd.jee.soap;

import javax.jws.WebService;

@WebService(
    name = "hello", endpointInterface = "org.jesperancinha.jtd.jee.soap.HelloWorldServerInt")
public class HelloWorldServerImpl
    implements HelloWorldServerInt {

    public String sayHelloWorld(String name) {
        return "Hello World ! My name is " + name + ".";
    }

}