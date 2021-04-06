package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.Encounter;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
@JsonComponent
public class EncounterSerializer extends JsonSerializer<Encounter> {
    @Override
    public void serialize(Encounter encounter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", encounter.getId());
        jsonGenerator.writeStringField("name", encounter.getName());
        jsonGenerator.writeObjectField("combatants", encounter.getCombatants());
        jsonGenerator.writeEndObject();
    }
}
