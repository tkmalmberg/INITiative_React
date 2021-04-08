package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.Monster;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Manages the Monster JSON object that is sent to the front end
 */
@JsonComponent
public class MonsterSerializer extends JsonSerializer<Monster> {

    /**
     * Serializes the Monster JSON object
     * @param monster The Monster to be serialized
     * @param jsonGenerator The JSON Generator that builds the JSON
     * @param serializerProvider Serializer Provider
     * @throws IOException Input/Output exception is thrown if there is a NULL field trying to be serialized
     */
    @Override
    public void serialize(Monster monster, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (monster != null) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", monster.getId());
            jsonGenerator.writeStringField("name", monster.getName());
            jsonGenerator.writeNumberField("hitPoints", monster.getHitPoints());
            jsonGenerator.writeNumberField("strength", monster.getStrength());
            jsonGenerator.writeNumberField("constitution", monster.getConstitution());
            jsonGenerator.writeNumberField("dexterity", monster.getDexterity());
            jsonGenerator.writeNumberField("intelligence", monster.getIntelligence());
            jsonGenerator.writeNumberField("wisdom", monster.getWisdom());
            jsonGenerator.writeNumberField("charisma", monster.getCharisma());
            jsonGenerator.writeEndObject();
        } else {
            jsonGenerator.writeNull();
        }
    }
}
