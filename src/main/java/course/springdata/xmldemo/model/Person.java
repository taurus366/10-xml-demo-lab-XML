package course.springdata.xmldemo.model;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "person")
@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {

    @XmlAttribute(required = true)
    private Long id;

    @NonNull
    @XmlElement
    private String firstName;

    @NonNull
    @XmlElement
    private String lastName;

    @NonNull
    private Address address;

    @XmlElementWrapper(name = "phoneNumbers")
    @XmlElement(name = "phone")
    private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();

}
