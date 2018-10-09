package kooboot.user.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class SearchCategory extends Category {

    public SearchCategory() {
        super();
        this.setCategoryType(CategoryType.SEARCH);
    }
}
