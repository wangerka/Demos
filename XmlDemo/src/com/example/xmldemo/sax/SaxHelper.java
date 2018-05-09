package com.example.xmldemo.sax;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;

public class SaxHelper extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		if(tag != null){
			
			if(tag.equals("name")){
				Log.i("gejun","characters name = "+new String(ch,start,length));
			} else if("age".equals(tag)){
				Log.i("gejun","age = "+new String(ch,start,length));
			}
		}
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		Log.i("gejun","endElement");
		Iterator pit = plist.iterator();
		while(pit.hasNext()){
			Log.i("gejun","province = " + pit.next());
		}
		Iterator cit = clist.iterator();
		while(cit.hasNext()){
			Log.i("gejun","city = " + cit.next());
		}
		
		tag = null;
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		Log.i("gejun","startElement localName = "+localName);
		if(localName.equals("province")){
			String p = attributes.getValue("name");
			plist.add(p);
		} else if(localName.equals("city")){
			String c = attributes.getValue("name");
			clist.add(c);
		}
		
		tag = localName;
	}
	
	private String tag=null;
	private List<String> plist = new ArrayList<String>();
	private List<String> clist = new ArrayList<String>();
	
	
}
