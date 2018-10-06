package kooboot.user.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_DATA")
public class UserData {

    @Id @GeneratedValue
    @Column(name = "USER_DATA_ID")
    private Long id;

    private String type;
    private String content;
}
