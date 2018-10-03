package kooboot.user.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRequestTime;

    @Enumerated(EnumType.STRING)
    private Category category = Category.INIT;
}
