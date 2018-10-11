package kooboot.user.domain;


import kooboot.message.domain.RequestMessage;
import kooboot.process.InvalidRequestException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static kooboot.process.FlowProcessor.MAXIMUM_REQ_INTERVAL_TIME;

@Data
@Slf4j
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToMany
    @JoinColumn(name = "USER_DATA_ID")
    private List<UserData> userDataList;

    public static User valueOf(RequestMessage requestMessage) {
        return User.builder()
                .userKey(requestMessage.getUser_key())
                .category(new InitCategory())
                .build();
    }

    public void setCategoryType(CategoryType categoryType) {
        this.category.setCategoryType(categoryType);
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

    public void renewalCategory(RequestMessage requestMessage) {
        if (CategoryType.INIT.getCode().equals(requestMessage.getContent())) {
            this.setCategoryType(CategoryType.of(requestMessage.getContent()));
            return;
        }

        if(!(this.category instanceof InitCategory))
            return;

        try {
            this.setCategoryType(CategoryType.of(requestMessage.getContent()));
        }catch(IllegalArgumentException e) {
            throw new InvalidRequestException();
        }


    }
}
