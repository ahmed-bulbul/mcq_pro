package com.bulbul.examportal.entity.acl;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/** this model receive data
 * from RestTemplate
 * as a Json or api
 * its call as pojo class
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  //Annotation used to indicate that the properties that do not match json response should be ignored
@Entity
public class Country {

    @Id
    private Long id;
    private String name;
    private String capital;
    private long population;
    @OneToMany(mappedBy = "country")
    private List<Currency> currencies;
}
