package com.tmax.poapp.poservicegroup.service;

import com.tmax.poapp.dataobject.poservicegroup.*;
import com.tmax.proobject.model.service.ServiceObject;

public class HelloWorldGet implements ServiceObject<HelloWorld, HelloWorld> {
    @Override
    public HelloWorld service(HelloWorld indto) {
        HelloWorld outdto = new HelloWorld();
        outdto.setStringTest("Hello, world!");
        return outdto;
    }
}