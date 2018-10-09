package kooboot.user.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class TranslateCategory extends Category {

    public TranslateCategory() {
        super();
        this.setCategoryType(CategoryType.TRANSLATE);
    }
}
