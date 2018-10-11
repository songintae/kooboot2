package kooboot.message.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Keyboard {
    public static final Keyboard DEFAULT_KEYBOARD = new Keyboard()
            .addButton("번역")
            .addButton("검색");

    private static final String DEFAULT_TYPE = "buttons";
    private String type = DEFAULT_TYPE;
    private List<String> buttons = new ArrayList<>();

    public Keyboard addButton(String newButton) {
        if(isExistsButton(newButton))
            throw new IllegalArgumentException("이미 등록되어있는 버튼입니다.");
        buttons.add(newButton);
        return this;
    }

    public Keyboard removeButton(String removeButton) {
        if(!isExistsButton(removeButton))
            throw new IllegalArgumentException("존재하지 않는 버튼입니다.");
        buttons.remove(buttons.stream().filter(s -> s.equalsIgnoreCase(removeButton)).findFirst().get());
        return this;
    }

    boolean isExistsButton(String button) {
        return  buttons.stream()
                .anyMatch(s -> s.equalsIgnoreCase(button));
    }

    public Keyboard addButtons(List<String> asList) {
        asList.stream().forEach(button -> addButton(button));
        return this;
    }
}
