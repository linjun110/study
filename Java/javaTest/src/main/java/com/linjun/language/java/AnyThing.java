package com.linjun.language.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.linjun.language.java.model.Staff;
import com.linjun.language.java.model.Template;

import java.io.IOException;

public class AnyThing {
    public static void main( String[] args ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON string to Object
        String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
        Staff staff1 = mapper.readValue(jsonInString, Staff.class);
        System.out.println(staff1);

        System.out.println(mapper.writeValueAsString(staff1));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1));

        ObjectMapper mapper1 = new ObjectMapper();
        String jsonInString2 = "{\"id\":\"mkyong\",\"configRuleGroups\":[{\"name\":\"crgName\"}]}";
        Template template = mapper1.readValue(jsonInString2, Template.class);
        System.out.println(template);
        System.out.println(mapper.writeValueAsString(template));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(template));
    }
}
