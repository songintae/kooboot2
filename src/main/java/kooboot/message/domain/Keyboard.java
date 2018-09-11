package kooboot.message.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Keyboard {

    private static final String DEFAULT_TYPE = "text";
    private String type = DEFAULT_TYPE;
    private List<String> buttons = new ArrayList<>();

    public Keyboard addButton(String newButton) {
        if(isExists(newButton))
            throw new IllegalArgumentException("이미 등록되어있는 버튼입니다.");
        buttons.add(newButton);
        return this;
    }

    public Keyboard removeButton(String removeButton) {
        if(!isExists(removeButton))
            throw new IllegalArgumentException("존재하지 않는 버튼입니다.");
        buttons.remove(buttons.stream().filter(s -> s.equalsIgnoreCase(removeButton)).findFirst().get());
        return this;
    }

    private boolean isExists(String button) {
        return  buttons.stream()
                .anyMatch(s -> s.equalsIgnoreCase(button));
    }

    public Keyboard addButtons(List<String> asList) {
        asList.stream().forEach(button -> addButton(button));
        return this;
    }
}
