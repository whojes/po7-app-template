package com.tmax.poapp.dataobject.common;

import java.lang.reflect.ParameterizedType;

import org.w3c.dom.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tmax.promapper.engine.base.Message;
import com.tmax.proobject.model.dataobject.DataObject;

public class GsonMessage<T extends DataObject> extends Message {

	@SuppressWarnings("unchecked")
	private Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0];

	@Override
	public byte[] marshal(DataObject arg0) throws Exception {
		Gson gson = getGson();
		return gson.toJson(arg0).getBytes();
	}

	@Override
	public DataObject unmarshal(byte[] arg0, int arg1) throws Exception {
		Gson gson = getGson();

		return gson.fromJson(new String(arg0, "UTF-8"), clazz);
	}

	@Override
	public int unmarshal(byte[] arg0, int arg1, DataObject arg2) throws Exception {
		arg2 = unmarshal(arg0, arg1);
		return 0;
	}

	private Gson getGson() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setDateFormat("yyyy-MM-dd hh:mm:ss.sss")
				.create();
		return gson;
	}

	// --------- UNUSED ---------
	@Override
	public void marshal(DataObject arg0, Node arg1) throws Exception {

	}

	@Override
	public DataObject unmarshal(Node arg0) throws Exception {
		return null;
	}
}
