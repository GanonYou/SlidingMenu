package com.example.ywy.slidingmenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YWY on 16/3/30.
 */
public class ColumnContent {

    private static final int COUNT = 6;
    private static final int TOTALPAGE = 2;

    public static List<ColumnItem> generyData(int page) {
        int start = page * COUNT;
        int end = TOTALPAGE == page ? start + COUNT : start + COUNT;
        List<ColumnItem> items = new ArrayList<ColumnItem>();
        for (int i = start; i < end; i++) {
            items.add(createColumnItem(i));
        }
        return items;
    }

    /**
     * 是否还有更多
     *
     * @param page
     * @return
     */
    public static boolean hasMore(int page) {
        return page < TOTALPAGE;
    }

    private static ColumnItem createColumnItem(int position) {
        return new ColumnItem(String.valueOf(position), "item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        int count = position % 3;
        for (int i = 0; i < count; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class ColumnItem {
        public final String id;
        public final String content;
        public final String details;

        public ColumnItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
