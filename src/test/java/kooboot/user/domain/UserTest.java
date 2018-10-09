package kooboot.user.domain;

import kooboot.message.domain.RequestMessage;
import kooboot.process.InvalidRequestException;
import org.junit.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void valueOf() {
        User user = User.valueOf(RequestMessage.builder().user_key("test").build());
        assertThat(user.getUserKey()).isEqualTo("test");
        assertThat(user.getCategory().getCategoryType()).isEqualTo(CategoryType.INIT);
    }

    @Test
    public void isLimitedRequestTimeTest() {
        User user = User.builder().build();

        Calendar exceededCalendar = Calendar.getInstance();
        exceededCalendar.add(Calendar.MINUTE, -5);
        user.setLastRequestTime(exceededCalendar.getTime());
        assertThat(user.isExceededRequestTime()).isEqualTo(true);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -4);
        user.setLastRequestTime(calendar.getTime());
        assertThat(user.isExceededRequestTime()).isEqualTo(false);

    }


    @Test
    public void renewalCategoryTest() {
        User user = User.builder().category(Category.valueOf(CategoryType.INIT)).build();
        RequestMessage requestMessage = RequestMessage.builder().content("번역").build();
        user.renewalCategory(requestMessage);
        assertThat(user.getCategory().getCategoryType()).isEqualTo(CategoryType.TRANSLATE);

        requestMessage = RequestMessage.builder().content("처음").build();
        user.renewalCategory(requestMessage);
        assertThat(user.getCategory().getCategoryType()).isEqualTo(CategoryType.INIT);



    }

    @Test(expected = InvalidRequestException.class)
    public void renewalCategoryExcetionTest() {
        User user = User.builder().category(Category.valueOf(CategoryType.INIT)).build();
        RequestMessage requestMessage = RequestMessage.builder().content("번역이당").build();
        user.renewalCategory(requestMessage);
    }


}