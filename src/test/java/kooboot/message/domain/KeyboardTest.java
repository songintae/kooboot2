package kooboot.message.domain;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyboardTest {

    private Keyboard keyBoard;

    @Before
    public void setUp() throws Exception {
        keyBoard = new Keyboard();
        keyBoard.addButtons(Arrays.asList(
                "번역"
                , "검색"
        ));
    }


    @Test
    public void addButton() {
        assertThat(keyBoard.getButtons().size()).isEqualTo(2);
        keyBoard.addButton("새로운버튼");
        assertThat(keyBoard.getButtons().size()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addButton_중복() {
        keyBoard.addButton("번역");
    }

    @Test
    public void removeButton() {
        assertThat(keyBoard.getButtons().size()).isEqualTo(2);
        keyBoard.removeButton("번역");
        assertThat(keyBoard.getButtons().size()).isEqualTo(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeButton_없는경우() {
        keyBoard.removeButton("없는경우");
    }

}