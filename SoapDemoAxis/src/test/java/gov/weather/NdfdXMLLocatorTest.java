package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;


public class NdfdXMLLocatorTest {

    @Test
    public void zipTest() throws Exception {
        NdfdXMLBindingStub service = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String answer = service.latLonListZipCode("53590");
        String GPSLocation = getResultFromClass(answer);

        assertEquals("It should fail", "43.1837,-89.2323", GPSLocation);
    }


    private String getResultFromClass(String response) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

        try {
            Unmarshaller jaxbUmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml = (DwmlType) jaxbUmarshaller.unmarshal(new StringReader(response));
            return dwml.getLatLonList();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}