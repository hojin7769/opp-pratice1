package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;


public class MenuTest {
    @Test
    @DisplayName("메뉴이름에 해당하는 메뉴를 반환한다")
    void createTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",5000),new MenuItem("냉면",7000)));

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스",5000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문할시 에러를 반환한다")
    @Test
    void name() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스",5000),new MenuItem("냉면",7000)));
        assertThatCode(() -> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다");
    }
}
