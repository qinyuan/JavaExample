package json.register;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;

public class AppModified {
    private static final String ANNOTATAED_FOO = "{\"@type\": \"annotated\"}";
    private static final String REGISTERED_FOO = "{\"@type\": \"registered\"}";

    public static void main(String[] args) {
        try {
            ObjectMapper onlyAnnoMapper = new ObjectMapper();
            onlyAnnoMapper.registerSubtypes(new NamedType(AnnotatedFoo.class, "annotated"));
            Foo annoFoo = onlyAnnoMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing annotation-based only: " + e);
        }
        System.out.println("");

        try {
            ObjectMapper onlyRegMapper = new ObjectMapper();
            onlyRegMapper.registerSubtypes(new NamedType(RegisteredFoo.class, "registered"));
            Foo regFoo = onlyRegMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");
    }

    @JsonTypeInfo(use = Id.NAME)
    public static interface Foo {
    }

    public static class AnnotatedFoo implements Foo {
        @Override
        public String toString() {
            return "AnnotatedFoo";
        }
    }

    public static class RegisteredFoo implements Foo {
        @Override
        public String toString() {
            return "RegisteredFoo";
        }
    }
}
