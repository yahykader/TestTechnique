package kader.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import kader.exception.ReferenceException;
import kader.model.Error;
import kader.model.Reference;
import kader.model.Result;

/**
 * @author abdel
 *
 */
public class ReportService {
	
	
	/**
	 * product a report by a given filePath
	 * @param inputFile
	 * @return
	 * @throws IOException
	 */
	public Result productReport(String inputFile) throws IOException {
		List<String> data=Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
		Result result=new Result(inputFile);
        for (int i = 0; i < data.size(); i++) {
        	String line=data.get(i);
        	try {
				Reference reference=new Reference(line);
				result.addReference(reference);
			} catch (ReferenceException e) {
			   Error error=new Error(i, e.getMessage(), line);
			   result.addError(error);			   
			}			
		}   
		return result;	
	}

    /**
     * Create json file on result
     * @param result
     * @param fileOutPut
     * @throws IOException
     */
    private void createJsonFile(Result result, String fileOutPut) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(fileOutPut), result);
    }

    /**
     * Create XML file on result
     * @param result
     * @param fileOutPut
     * @throws IOException
     */
    private void createXMLFile(Result result, String fileOutPut) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.writeValue(new File(fileOutPut), result);
    }
   
    /**
     * run report by a given type of output format
     * @param inputFile
     * @param fileOutPut
     * @param type
     * @throws IOException
     */
    
    public void runReport(String inputFile,String fileOutPut,String type ) throws IOException {
    	Result result=productReport(inputFile);
    	switch (type) {
		case "XML":
			this.createXMLFile(result, fileOutPut);
			break;
		case "JSON":
			this.createJsonFile(result, fileOutPut);
			break;	
		default:
			System.out.println("type of output is not implements");
			break;
		}
    }
    
	
	
	
}
