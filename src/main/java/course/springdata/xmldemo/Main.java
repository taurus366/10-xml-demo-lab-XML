package course.springdata.xmldemo;

import course.springdata.xmldemo.model.Address;
import course.springdata.xmldemo.model.Person;
import course.springdata.xmldemo.model.Persons;
import course.springdata.xmldemo.model.PhoneNumber;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
         //   marshaller.marshal(person1,new File("person.xml"));

            // 4. Marshall multiple persons to persons.xml
            marshaller.marshal(new Persons(persons),new File("persons.xml"));
           // marshaller.marshal(new Persons(persons),System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
