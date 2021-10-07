package ru.fbtw.tagger.util;

import com.google.gson.*;
import ru.fbtw.tagger.domain.dto.events.VkEvent;
import ru.fbtw.tagger.domain.enums.EventType;

import java.lang.reflect.Type;
import java.util.Locale;

public class VkEventAdapter implements JsonDeserializer<VkEvent> {

    private final Gson gson;

    protected VkEventAdapter() {
        gson = new Gson();
    }

    @Override
    public VkEvent deserialize(
            JsonElement jsonElement,
            Type type,
            JsonDeserializationContext jsonDeserializationContext
    ) throws JsonParseException {
        JsonObject root = jsonElement.getAsJsonObject();

        String typeStr = root.get("type")
                .getAsString()
                .toUpperCase(Locale.ROOT);
        EventType eventType = EventType.valueOf(typeStr);

        Object object = null;
        if (root.has("object")) {
            object = gson.getAdapter(eventType.getType())
                    .fromJsonTree(root.get("object"));
        }

        long groupId = root.get("group_id").getAsLong();


        return new VkEvent(eventType, object, groupId);
    }
}
