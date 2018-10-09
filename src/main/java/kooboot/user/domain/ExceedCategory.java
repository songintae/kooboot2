package kooboot.user.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class ExceedCategory extends Category {

    public ExceedCategory() {
        super();
        this.setCategoryType(CategoryType.EXCEED);
    }
}
