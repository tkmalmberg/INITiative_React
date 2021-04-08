package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.Encounter;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Manages the Encounter JSON object that is sent to the front end
 */
@JsonComponent
public class EncounterSerializer extends JsonSerializer<Encounter> {

    /**
     * Serializes the Encounter JSON Object
     * @param encounter The Encounter to be serialized
     * @param jsonGenerator The JSON Generator that builds the JSON
     * @param serializerProvider Serializer Provider
     * @throws IOException Input/Output exception is thrown if there is a NULL field trying to be serialized
     */
    @Override
    public void serialize(Encounter encounter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", encounter.getId());
        jsonGenerator.writeStringField("name", encounter.getName());
        jsonGenerator.writeObjectField("combatants", encounter.getCombatants());
        jsonGenerator.writeEndObject();
    }
}
