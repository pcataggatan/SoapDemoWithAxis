package gov.weather;

import org.junit.Test;

import javax.xml.bind.*;
import java.io.StringReader;

import static org.junit.Assert.*;

public class NdfdXMLBindingStubTest {

    @Test
    public void LatLonListZipcode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.latLonListZipCode("53718");
        //assertEquals("Result did not match expected value", "???", response);
        String latlon = unmarshallResult(response);
        assertEquals("43.0798,-89.3875", latlon);
    }


    public String unmarshallResult(String response) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        try {
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}