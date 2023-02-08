package org.example;

import java.util.List;

public class Menu {
    private final List<MenuItem> menuItems;

    // 메뉴판은 여러 개의 메뉴들을 가진다.
    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public MenuItem choose(String name) {
        return this.menuItems.stream()
                .filter(menuItem -> menuItem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
