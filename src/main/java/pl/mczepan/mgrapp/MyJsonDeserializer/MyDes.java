package pl.mczepan.mgrapp.MyJsonDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

public class MyDes extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String currentParsingName = jsonParser.getParsingContext().getCurrentName();
        if(node.isValueNode()) {
            /*
            if(currentParsingName.equals("Time")) {
                if(node.textValue().equals("Not started") || node.textValue().equals("Postponed")) {
                    ((ObjectNode) node).replace("Time",new TextNode("New Value"));
                    String s = node.textValue();
                }
            }*/
            return node.textValue();
        }
        return null;
    }
}