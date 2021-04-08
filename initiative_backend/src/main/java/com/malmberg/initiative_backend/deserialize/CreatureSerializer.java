package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.Creature;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Manages the Creature JSON object that is sent to the front end
 */
@JsonComponent
public class CreatureSerializer extends JsonSerializer<Creature> {

    /**
     * Serializes the Creature JSON object
     * @param creature The Creature to be serialized
     * @param jsonGenerator The JSON Generator that builds the JSON
     * @param serializerProvider Serializer Provider
     * @throws IOException Input/Output exception is thrown if there is a NULL field trying to be serialized
     */
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
