package com.example.gazpromtest.gson;

import com.example.gazpromtest.model.AuxiliaryText;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AuxiliaryTextSerializer implements JsonSerializer<AuxiliaryText> {
    @Override
    public JsonElement serialize(AuxiliaryText auxiliaryText, Type type, JsonSerializationContext jsonSerializationContext) {


        return null;
    }
}
