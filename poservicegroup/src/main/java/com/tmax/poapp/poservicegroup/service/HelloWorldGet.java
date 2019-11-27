package com.tmax.poapp.poservicegroup.service;

import com.tmax.poapp.dataobject.poservicegroup.*;
import com.tmax.proobject.common.CkService;
import com.tmax.proobject.common.CkServiceExecutor;
import com.tmax.proobject.common.HttpMethod;
import com.tmax.proobject.model.service.ServiceObject;

@CkService(serviceName = "hello-worlds", method = HttpMethod.GET)
@CkServiceExecutor
public class HelloWorldGet implements ServiceObject<HelloWorld, HelloWorld> {
    @Override
    public HelloWorld service(HelloWorld indto) {
        HelloWorld outdto = new HelloWorld();
        outdto.setStringTest("Hello, world!");
        return outdto;
    }
}