package bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


	public class ResponseList {

	private ArrayList<Object> list;

	//@XMLElement("usersList")
	public ArrayList<Object> getList() {
	    return list;
	}

	public void setList(ArrayList<Object> list) {
	    this.list = list;
	}
	
	}

