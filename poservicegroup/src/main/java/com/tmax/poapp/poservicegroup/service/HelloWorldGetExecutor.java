package com.tmax.poapp.poservicegroup.service;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class HelloWorldGetExecutor extends ServiceExecutor {

    public HelloWorldGetExecutor() {
        this.serviceObject = new HelloWorldGet();
    }
    
	@Override
	public Object execute(Object arg0, String arg1) throws Throwable {
		// TODO Auto-generated method stub
		return this.serviceObject.service(arg0); 
	}

}