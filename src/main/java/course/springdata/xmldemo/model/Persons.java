package course.springdata.xmldemo.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persons {

    @XmlElement(name = "person")
   private List<Person> persons;



}
