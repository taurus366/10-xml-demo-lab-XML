package course.springdata.xmldemo.model;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(value = XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    private static Long nextId = 0L;

    @XmlAttribute(required = true)
    private Long id = ++ nextId;

    @NonNull
    private String number;
}
