package com.tmax.poapp;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;

/**
 * do not modify
 */
public class VersionGet {
	public static void main(String... args) throws IOException {
		Enumeration<URL> resources = VersionGet.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
		while(resources.hasMoreElements()) {
			Manifest mf = new Manifest(resources.nextElement().openStream());
			mf.getMainAttributes().keySet().stream().map( key -> {
				return key.toString();
			}).sorted().forEach( key -> {
				System.out.println(key + " : " + mf.getMainAttributes().getValue(key.toString()));
			});
		}
	}
}
