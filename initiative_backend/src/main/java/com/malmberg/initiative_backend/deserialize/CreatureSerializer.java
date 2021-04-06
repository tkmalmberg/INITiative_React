package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.Creature;

import java.io.IOException;

public class CreatureSerializer extends JsonSerializer<Creature> {
    @Override
    public void serialize(Creature creature, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (creature != null) {
            jsonGenerator.writeNumberField("id", creature.getId());
            jsonGenerator.writeNumberField("strength", creature.getStrength());
            jsonGenerator.writeNumberField("constitution", creature.getConstitution());
            jsonGenerator.writeNumberField("dexterity", creature.getDexterity());
            jsonGenerator.writeNumberField("intelligence", creature.getIntelligence());
            jsonGenerator.writeNumberField("wisdom", creature.getWisdom());
            jsonGenerator.writeNumberField("charisma", creature.getCharisma());
            jsonGenerator.writeEndObject();
        } else {
            jsonGenerator.writeNull();
        }
    }
}
