package org.example;

public class Customer {
    public void order(String menuName, Menu menu, Cooking cooking){
        // 고른 요리가 메뉴 목록에 있다면 메뉴 아이템을 생성한다
        MenuItem menuItem = menu.choose(menuName);
        // 그 후 요리사가 요리를 만들어 요리 객체를 만든다
        Cook cook = cooking.makeCook(menuItem);
    }
}
