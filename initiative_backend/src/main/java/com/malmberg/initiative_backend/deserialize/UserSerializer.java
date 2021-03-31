package com.malmberg.initiative_backend.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.malmberg.initiative_backend.models.User;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class UserSerializer extends JsonSerializer<User> {

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", user.getId());
        jsonGenerator.writeStringField("firstName", user.getFirstName());
        jsonGenerator.writeStringField("lastName", user.getLastName());
        jsonGenerator.writeStringField("email", user.getEmail());
        jsonGenerator.writeStringField("pass", user.getPass());
        jsonGenerator.writeBooleanField("admin", user.isAdmin());
        jsonGenerator.writeObjectField("encounters", user.getEncounters());
        jsonGenerator.writeObjectField("pcs", user.getPcs());
        jsonGenerator.writeEndObject();
    }

    // TODO Make a method to get a list of Owned PlayerCharacter IDs
}
