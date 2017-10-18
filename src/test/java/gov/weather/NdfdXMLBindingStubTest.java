package gov.weather;

import org.junit.Test;

import javax.xml.bind.*;

import static org.junit.Assert.*;

public class NdfdXMLBindingStubTest {

    @Test
    public void LatLonListZipcode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();

        String response = binding.latLonListZipCode("53711");
        //assertEquals("Result did not match expected value", "???", response);
        String latlon = unmarshallResult(response);
    }

    public String unmarshallResult(String response) {
        JAXBContext jaxbContext = new JAXBContext.newInstance(DwmlType.class);

        try {

            Unmarshaller
        }


    }
}