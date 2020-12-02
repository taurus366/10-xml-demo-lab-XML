package course.springdata.xmldemo;

import course.springdata.xmldemo.model.Address;
import course.springdata.xmldemo.model.Person;
import course.springdata.xmldemo.model.Persons;
import course.springdata.xmldemo.model.PhoneNumber;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args)  {

        Address address1 = new Address("Bulgaria", "Medovets", "ul. sedemnadeset nomer 9");
        Person person1 = new Person(1L, "Ali", "Zinal", address1,
                Set.of(new PhoneNumber("+359 894 396766"),new PhoneNumber("+359 897 854673")));

        Address address2 = new Address("Bulgaria", "Varna", "ul. sedemnadeset nomer 9");
        Person person2 = new Person(2L, "Pesho", "Gosho", address1,
                Set.of(new PhoneNumber("+359 894 396asd766"),new PhoneNumber("+359 897 85asd4673")));

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);

        // 1. Create JAXBContext

        try {
            JAXBContext ctx = JAXBContext.newInstance(Person.class, Persons.class);

            // 2. Create Marshaller
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);

            // 3. Marshall POJO to XML
//            marshaller.marshal(person1,new File("person.xml"));

            // 4. Marshall multiple persons to persons.xml
//            marshaller.marshal(new Persons(persons),new File("persons.xml"));
//            StringWriter out = new StringWriter();
//            marshaller.marshal(new Persons(persons),out);
//            System.out.printf("StringWriter: %s\n",out.toString());



            // 5. Unmarshal multiple Persons from XML to Java
//            Unmarshaller unmarshaller = ctx.createUnmarshaller();
//          Persons unmarshalled = (Persons) unmarshaller.unmarshal(new File("persons.xml"));
//          unmarshalled.getPersons().forEach(p -> System.out.printf("| %5d | %-15.15s | %-15.15s | %-50.50s | %-40.40s |\n", p.getId(),p.getFirstName(),p.getLastName(),p.getAddress().getCountry() + ", " + p.getAddress().getCity() + ", " + p.getAddress().getStreet() + " ",p.getPhoneNumbers().stream().map(PhoneNumber::getNumber).collect(Collectors.joining(", "))));


//            // 6. Set validation  OPTIONAL !!!!
//            SchemaFactory sc = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = sc.newSchema(new File("persons.xsd"));
//            unmarshaller.setSchema(schema);
//            unmarshaller.setEventHandler((ValidationEvent ve)-> {
//                if (ve.getSeverity() != ValidationEvent.WARNING){
//                    System.out.printf(
//                            "%s: Line:Col[%d:%d] - %s\n",
//                            ve.getSeverity(), ve.getLocator().getLineNumber(),ve.getLocator().getColumnNumber(),
//                            ve.getMessage()
//                    );
//                }
//                        return true;
//                    }
//            ) ;




        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
