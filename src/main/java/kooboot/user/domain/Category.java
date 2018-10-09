package kooboot.user.domain;


import kooboot.process.InvalidRequestException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    protected Long id;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    protected CategoryType categoryType = CategoryType.INIT;


    public static Category valueOf(CategoryType categoryType) {
        switch (categoryType) {
            case INIT:
                return new InitCategory();
            case EXCEED:
                return new ExceedCategory();
            case TRANSLATE:
                return new TranslateCategory();
            case SEARCH:
                return new SearchCategory();
            default:
                throw new InvalidRequestException();
        }
    }

}
