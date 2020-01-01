package kader.model;

import java.util.Arrays;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import kader.exception.ReferenceException;

@JacksonXmlRootElement(localName = "reference")
public class Reference {	
	   @JacksonXmlProperty(isAttribute = true)
	    private String numReference;
	    @JacksonXmlProperty(isAttribute = true)
	    private int size;
	    @JacksonXmlProperty(isAttribute = true)
	    private double price;
	    @JacksonXmlProperty(localName = "color", isAttribute = true)
	    private Color type;
	    
	    
	    public Reference(String line ) throws ReferenceException {
			String[] reference= line.split(";");
			checkErrors(reference);
			this.numReference=reference[0];
			this.type=Color.valueOf(reference[1]);
			this.price=Double.parseDouble(reference[2]);
			this.size=Integer.parseInt(reference[3]);
		}
	    
	    public void checkErrors(String[] reference) throws ReferenceException {
	    	String colors=Arrays.asList(Color.values()).toString();	
	    	if(reference.length!=4) {
	    		throw new  ReferenceException("Incorrect number of arguments");
	    	}
	    	if(!colors.contains(reference[1])) {
	    		throw new ReferenceException("Incorrect value for color ");
	    	}
	    	if(reference[0].length()!=10) {
	    		throw new ReferenceException("Incorrect value for numReference");
	    	}	
	    }

		public String getNumReference() {
			return numReference;
		}

		public void setNumReference(String numReference) {
			this.numReference = numReference;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Color getType() {
			return type;
		}

		public void setType(Color type) {
			this.type = type;
		}
	    
	    
}
