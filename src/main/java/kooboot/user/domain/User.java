package kooboot.user.domain;


import kooboot.message.domain.RequestMessage;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static kooboot.process.FlowProcessor.MAXIMUM_REQ_INTERVAL_TIME;

@Data
@Builder
@Entity
@Table(name = "USER")
public class User {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(nullable = false)
    private String userKey;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastRequestTime;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany
    @JoinColumn(name = "USER_DATA_ID")
    private List<UserData> userDataList;

    public static User valueOf(RequestMessage requestMessage) {
        return User.builder()
                .userKey(requestMessage.getUser_key())
                .category(Category.INIT)
                .build();
    }

    public boolean isExceededRequestTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -MAXIMUM_REQ_INTERVAL_TIME);
        if(calendar.getTime().compareTo(lastRequestTime) >= 0)
            return true;
        return false;
    }

    public void renewalLastRequestTime() {
        this.lastRequestTime = new Date();
    }
}
