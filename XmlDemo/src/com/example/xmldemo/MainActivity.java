package com.example.xmldemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.example.xmldemo.dom.DomHelper;
import com.example.xmldemo.pull.PullHelper;
import com.example.xmldemo.sax.SaxHelper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void domXml(View view){
    	DomHelper.domXML(this);
    }
    
    
    public void pullXml(View view){
    	PullHelper.pullXML(this);
    }

    public void saxXml(View view){
    	SAXParserFactory facotry = SAXParserFactory.newInstance();
    	
    	try {
    		InputStream in = getAssets().open("person.xml");
			SAXParser parser = facotry.newSAXParser();
			//1
//			parser.parse(in, new SaxHelper());
			//2
			XMLReader reader = parser.getXMLReader();
			reader.setContentHandler(new SaxHelper());
			reader.parse(new InputSource(in));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    public void pullXml(){
    	
    }
    
    public void DomXml(){
    	
    }

}
