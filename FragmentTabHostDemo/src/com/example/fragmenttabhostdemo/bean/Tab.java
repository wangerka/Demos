package com.example.fragmenttabhostdemo.bean;

public class Tab {
	private int image;
	private int tag;
	public Tab(int image, int tag, Class fragment) {
		super();
		this.image = image;
		this.tag = tag;
		this.fragment = fragment;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	private Class fragment;
	
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
	public Class getFragment() {
		return fragment;
	}
	public void setFragment(Class fragment) {
		this.fragment = fragment;
	}
	
	

}
