package kader.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

@JacksonXmlRootElement(localName = "error")
public class Error {
	
    @JacksonXmlProperty(isAttribute = true)
    private int line;
    @JacksonXmlProperty(isAttribute = true)
    private String message;
    @JacksonXmlText
    private String value;
    
	public Error(int line, String message, String value) {
		super();
		this.line = line;
		this.message = message;
		this.value = value;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
    
    
    
    

}
