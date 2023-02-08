package org.example;

public class Cooking {
    /**요리사가 요리를 만든다*/
    public Cook makeCook(MenuItem menuItem) {
        Cook cook = new Cook(menuItem);
        return cook;
    }
}
