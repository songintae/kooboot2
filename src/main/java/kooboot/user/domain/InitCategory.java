package kooboot.user.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("I")
public class InitCategory extends Category {

    public InitCategory() {
        super();
        this.setCategoryType(CategoryType.INIT);
    }
}
