package com.example.xmldemo.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.content.Context;
import android.util.Log;

public class DomHelper {
	
	public static void domXML(Context context){
		Log.i("gejun","domXML");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(context.getAssets().open("city.xml"));
			NodeList nodelist = doc.getElementsByTagName("county");
			Log.i("gejun",""+nodelist.getLength());
			for(int i =0;i<nodelist.getLength();i++){
//				Node node = nodelist.item(i);
				Element element = (Element) nodelist.item(i);
				String name = element.getAttribute("name");
				String id = element.getAttribute("id");
				Log.i("gejun","name = "+name+"    id = "+id);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
