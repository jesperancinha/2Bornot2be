package org.jesperancinha.jtd.jee.lightning2;

import javax.jws.WebService;

@WebService(
        name = "hello",
        endpointInterface = "org.jesperancinha.jtd.jee.lightning2.HelloSoapService")
public class HelloSoapServiceImpl
        implements HelloSoapService {

    public String sayHelloWorld(String name) {
        return "Hello World ! My name is " + name + ".";
    }

}