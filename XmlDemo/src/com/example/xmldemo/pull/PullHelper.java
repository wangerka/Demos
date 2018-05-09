package com.example.xmldemo.pull;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.util.Log;
import android.util.Xml;

public class PullHelper {
	
	
	public static void pullXML(Context c){
		try {
			//1
//			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//			XmlPullParser parser = factory.newPullParser();
			//2
			XmlPullParser parser = Xml.newPullParser();
			parser.setInput(c.getAssets().open("person.xml"), "UTF-8");
			
			int eventType = parser.getEventType();
			while(eventType != XmlPullParser.END_DOCUMENT){
				switch(eventType){
				case XmlPullParser.END_TAG:
					break;
				case XmlPullParser.START_DOCUMENT:
					break;
				case XmlPullParser.START_TAG:
					if("county".equals(parser.getName())){
						Log.i("gejun","id = "+parser.getAttributeValue(0)+",name = "+parser.getAttributeValue(1)
								+", weatherCode = "+parser.getAttributeValue(2));
					} else if("name".equals(parser.getName())){
						String name = parser.nextText();
						Log.i("gejun","name = "+name);
					}
					break;
				case XmlPullParser.TEXT:
					Log.i("gejun","XmlPullParser.TEXT");
					break;
				}
				eventType = parser.next();  
			}
			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
