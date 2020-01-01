package kader;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import kader.service.ReportService;

@SpringBootApplication
public class TestTechniqueApplication {

	static ReportService reportService=new ReportService();

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestTechniqueApplication.class, args);
		
		 String inputFile= "src/main/resources/test.txt";
		 String fileOutPut= "src/main/resources/testResult.xml";
		 String type= "XML";
		 reportService.runReport(inputFile, fileOutPut, type);
		 
		 
		 String inputFile1= "src/main/resources/test.txt";
		 String fileOutPut1= "src/main/resources/testResult.json";
		 String type1= "JSON";
		 reportService.runReport(inputFile1, fileOutPut1, type1);
	}
}
