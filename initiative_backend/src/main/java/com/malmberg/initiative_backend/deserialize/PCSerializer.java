package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.PlayerCharacter;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
@JsonComponent
public class PCSerializer extends JsonSerializer<PlayerCharacter> {
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
