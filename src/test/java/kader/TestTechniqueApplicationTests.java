package kader;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import kader.exception.ReferenceException;
import kader.model.Color;
import kader.model.Reference;

@SpringBootTest
class TestTechniqueApplicationTests {

	@Test 
	void red_referenceTest() throws ReferenceException{
		 Reference reference=new Reference("1460100040;R;45.12;27");
		 assertTrue(reference.getType().equals(Color.R));
	}
	
    @Test
    void exception_on_numReference()  {
        ReferenceException thrown = assertThrows(ReferenceException.class, () ->new Reference("14610004;R;45.12;27"));
        assertTrue(thrown.getMessage().contains("numReference"));
    }
   
    @Test
    void exception_on_color()  {
        ReferenceException thrown = assertThrows(ReferenceException.class, () ->new Reference("1460100040;A;45.12;27"));
        assertTrue(thrown.getMessage().contains("color"));
    }
    
    @Test 
    void exception_on_arguments(){
    	ReferenceException thrown=assertThrows(ReferenceException.class, ()-> new Reference("1460100040;45.12;27"));
    	assertTrue(thrown.getMessage().contains("arguments"));
    }
    
    
    
}
