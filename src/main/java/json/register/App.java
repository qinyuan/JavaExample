package json.register;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    private static final String ANNOTATAED_FOO = "{\"@type\": \"annotated\"}";
    private static final String REGISTERED_FOO = "{\"@type\": \"registered\"}";
    private static final String ANOTHER_FOO = "{\"@type\": \"another\"}";

    public static void main( String[] args ) {
        Foo annoFoo = null;
        Foo regFoo = null;

        try {
            System.out.println("Only Annotation-based Deser");
            ObjectMapper onlyAnnoMapper = new ObjectMapper();
            annoFoo = onlyAnnoMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing annotation-based only: " + e);
        }
        System.out.println("");

        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Only Registration-based Deser");
            ObjectMapper onlyRegMapper = new ObjectMapper();
            onlyRegMapper.registerSubtypes(RegisteredFoo.class);
            regFoo = onlyRegMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");

        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Register types before any deser");
            ObjectMapper regBeforeDeserMapper = new ObjectMapper();
            regBeforeDeserMapper.registerSubtypes(RegisteredFoo.class);
            annoFoo = regBeforeDeserMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
            regFoo = regBeforeDeserMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");

        // THIS ONE FAILS!
        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Register types after anno deser");
            ObjectMapper regBeforeDeserMapper = new ObjectMapper();
            annoFoo = regBeforeDeserMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
            regBeforeDeserMapper.registerSubtypes(RegisteredFoo.class);
            regFoo = regBeforeDeserMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");

        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Register types before deser, deser registered first");
            ObjectMapper regBeforeDeserMapper = new ObjectMapper();
            regBeforeDeserMapper.registerSubtypes(RegisteredFoo.class);
            regFoo = regBeforeDeserMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
            annoFoo = regBeforeDeserMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");

        // This one fails too!
        Foo anotherFoo = null;
        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Register, deser, Register 2, deser");
            ObjectMapper regBeforeDeserMapper = new ObjectMapper();
            regBeforeDeserMapper.registerSubtypes(RegisteredFoo.class);
            regFoo = regBeforeDeserMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
            regBeforeDeserMapper.registerSubtypes(AnotherFoo.class);
            anotherFoo = regBeforeDeserMapper.readValue(ANOTHER_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + anotherFoo);
            annoFoo = regBeforeDeserMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");

        anotherFoo = null;
        annoFoo = null;
        regFoo = null;
        try {
            System.out.println("Register two, deser");
            ObjectMapper regBeforeDeserMapper = new ObjectMapper();
            regBeforeDeserMapper.registerSubtypes(RegisteredFoo.class);
            regBeforeDeserMapper.registerSubtypes(AnotherFoo.class);
            regFoo = regBeforeDeserMapper.readValue(REGISTERED_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + regFoo);
            anotherFoo = regBeforeDeserMapper.readValue(ANOTHER_FOO, Foo.class);
            System.out.println("Deserialized Reg: " + anotherFoo);
            annoFoo = regBeforeDeserMapper.readValue(ANNOTATAED_FOO, Foo.class);
            System.out.println("Deserialized Anno: " + annoFoo);
        } catch (Exception e) {
            System.out.println("Error deserializaing registration-based only: " + e);
        }
        System.out.println("");
    }


    @JsonTypeInfo(use=Id.NAME, include=As.PROPERTY, property="@type")
    @JsonSubTypes({ @Type(name="annotated", value=AnnotatedFoo.class) })
    public static interface Foo {
    }

    public static class AnnotatedFoo implements Foo {
        @Override public String toString() { return "AnnotatedFoo"; }
    }

    @JsonTypeName("registered")
    public static class RegisteredFoo implements Foo {
        @Override public String toString() { return "RegisteredFoo"; }
    }

    @JsonTypeName("another")
    public static class AnotherFoo implements Foo {
        @Override public String toString() { return "AnotherFoo"; }
    }
}
