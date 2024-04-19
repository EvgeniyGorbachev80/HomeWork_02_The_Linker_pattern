package org.Gorbachev.Test;

import org.Gorbachev.AbstractDocument;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * AbstractDocument test class
 */
public class AbstractDocumentTest {
    private static final String KEY = "key";
    private static final String VALUE = "value";

    private static class DocumentImplementation extends AbstractDocument {

        DocumentImplementation(Map<String, Object> properties) {
            super(properties);
        }
    }

    private final DocumentImplementation document = new DocumentImplementation(new HashMap<>());

    @Test
    void shouldPutAndGetValue() {
        document.put(KEY, VALUE);
        assertEquals(VALUE, document.get(KEY));
    }

    @Test
    void shouldRetrieveChildren() {
        var children = List.of(Map.of(), Map.of());

        document.put(KEY, children);

        var childrenStream = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(2, childrenStream.count());
    }

    @Test
    void shouldRetrieveEmptyStreamForNonExistingChildren() {
        var children = document.children(KEY, DocumentImplementation::new);
        assertNotNull(children);
        assertEquals(0, children.count());
    }

    @Test
    void shouldIncludePropsInToString() {
        var props = Map.of(KEY, (Object) VALUE);
        var document = new DocumentImplementation(props);
        assertTrue(document.toString().contains(KEY));
        assertTrue(document.toString().contains(VALUE));
    }

    @Test
    void shouldHandleExceptionDuringConstruction() {
        Map<String, Object> invalidProperties = null; // Invalid properties, causing NullPointerException

        // Throw null pointer exception
        assertThrows(NullPointerException.class, () -> {
            // Attempt to construct a document with invalid properties
            new DocumentImplementation(invalidProperties);
        });
    }

    @Test
    void shouldPutAndGetNestedDocument() {
        // Creating a nested document
        DocumentImplementation nestedDocument = new DocumentImplementation(new HashMap<>());
        nestedDocument.put("nestedKey", "nestedValue");


        document.put("nested", nestedDocument);

        // Retrieving the nested document
        DocumentImplementation retrievedNestedDocument = (DocumentImplementation) document.get("nested");

        assertNotNull(retrievedNestedDocument);
        assertEquals("nestedValue", retrievedNestedDocument.get("nestedKey"));
    }

    @Test
    void shouldUpdateExistingValue() {
        // Arrange
        final String key = "key";
        final String originalValue = "originalValue";
        final String updatedValue = "updatedValue";

        document.put(key, originalValue);

        // Updating the value
        document.put(key, updatedValue);

        //Verifying that the updated value is retrieved correctly
        assertEquals(updatedValue, document.get(key));
    }
}
