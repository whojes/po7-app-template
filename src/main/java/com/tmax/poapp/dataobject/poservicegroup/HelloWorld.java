package com.tmax.poapp.dataobject.poservicegroup;

import java.sql.Timestamp;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.tmax.proobject.common.CkMsgJson;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.model.exception.FieldNotFoundException;

@CkMsgJson(gson = "com.tmax.poapp.dataobject.common.GsonMessage")
public class HelloWorld extends DataObject{

    @Expose
    private int numberTest;
    
    @Expose
    private String stringTest;
    
    @Expose
    private Timestamp timestampTest;

	public int getNumberTest() {
        return this.numberTest;
    }

    public void setNumberTest(int numberTest) {
        this.numberTest = numberTest;
    }

    public String getStringTest() {
        return this.stringTest;
    }

    public void setStringTest(String stringTest) {
        this.stringTest = stringTest;
    }

    public Timestamp getTimestampTest() {
        return this.timestampTest;
    }

    public void setTimestampTest(Timestamp timestampTest) {
        this.timestampTest = timestampTest;
    }
    
    @Override
    public Object clone() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object get(String paramString) throws FieldNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void set(String paramString, Object paramObject) throws FieldNotFoundException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Map getFieldPropertyMap() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\nnumberTest = " + getNumberTest() + "\n")
    	.append("stringTest = " + getStringTest() + "\n")
    	.append("timestampTest = " + getTimestampTest() + "\n");
    	
    	return sb.toString();
    }

}
