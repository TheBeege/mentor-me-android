package com.beegeworks.education.mentorme.search.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MentorDto {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<MentorItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, MentorItem> ITEM_MAP = new HashMap<>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createMentorItem(i));
        }
    }

    private static void addItem(MentorDto.MentorItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static MentorDto.MentorItem createMentorItem(int position) {
        return new MentorDto.MentorItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class MentorItem {
        public final String id;
        public final String content;
        public final String details;

        public MentorItem(String id, String content, String details) {
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
