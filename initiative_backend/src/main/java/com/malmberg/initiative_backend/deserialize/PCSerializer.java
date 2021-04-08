package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.PlayerCharacter;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Manages the PlayerCharacter JSON object that is sent to the front end
 */
@JsonComponent
public class PCSerializer extends JsonSerializer<PlayerCharacter> {

    /**
     * Serializes the PlayerCharacter JSON object
     * @param playerCharacter The PlayerCharacter to be serialized
     * @param jsonGenerator The JSON Generator that builds the JSON
     * @param serializerProvider Serializer Provider
     * @throws IOException Input/Output exception is thrown if there is a NULL field trying to be serialized
     */
    @Override
    public void serialize(PlayerCharacter playerCharacter, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (playerCharacter != null) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", playerCharacter.getId());
            jsonGenerator.writeStringField("name", playerCharacter.getName());
            jsonGenerator.writeStringField("race", playerCharacter.getRace());
            jsonGenerator.writeStringField("className", playerCharacter.getClassName());
            jsonGenerator.writeNumberField("hitPoints", playerCharacter.getHitPoints());
            jsonGenerator.writeNumberField("level", playerCharacter.getLevel());
            jsonGenerator.writeNumberField("strength", playerCharacter.getStrength());
            jsonGenerator.writeNumberField("constitution", playerCharacter.getConstitution());
            jsonGenerator.writeNumberField("dexterity", playerCharacter.getDexterity());
            jsonGenerator.writeNumberField("intelligence", playerCharacter.getIntelligence());
            jsonGenerator.writeNumberField("wisdom", playerCharacter.getWisdom());
            jsonGenerator.writeNumberField("charisma", playerCharacter.getCharisma());
            jsonGenerator.writeEndObject();
        } else {
            jsonGenerator.writeNull();
        }

    }
}
