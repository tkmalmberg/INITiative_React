package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.User;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * Manages the User JSON object that is sent to the front end
 */
@JsonComponent
public class UserSerializer extends JsonSerializer<User> {

    /**
     * Serializes the User JSON object
     * @param user The User to be serialized
     * @param jsonGenerator The JSON Generator that builds the JSON
     * @param serializerProvider Serializer Provider
     * @throws IOException Input/Output exception is thrown if there is a NULL field trying to be serialized
     */
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("firstName", user.getFirstName());
        jsonGenerator.writeStringField("lastName", user.getLastName());
        jsonGenerator.writeStringField("email", user.getEmail());
        jsonGenerator.writeStringField("pass", user.getPass());
        jsonGenerator.writeBooleanField("admin", user.isAdmin());
//        jsonGenerator.writeObjectField("encounters", user.getEncounters());
//        jsonGenerator.writeObjectField("pcs", user.getPcs());
        jsonGenerator.writeEndObject();
    }

    // TODO Make a method to get a list of Owned PlayerCharacter IDs
}
