package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    public QueryStrings(String queryStringLine) {
        // 받아온 구문을 & 기준으로 자른다
        String queryStringTokens[] = queryStringLine.split("&");
        // 그 후 forEach문을 돌며 value 값이 제대로 된 형식으로 왔는지 확인한 후, 리스트에 넣는다.
        Arrays.stream(queryStringTokens)
                .forEach(queryString -> {
                    String values[] = queryString.split("=");
                    if (values.length != 2) {
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다.");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }
}
