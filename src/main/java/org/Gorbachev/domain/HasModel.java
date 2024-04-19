package org.Gorbachev.domain;

import org.Gorbachev.Document;
import org.Gorbachev.domain.enums.Property;
import java.util.Optional;

/**
 * HasModel trait for static access to 'model' property.
 */
public interface HasModel extends Document {
    default Optional<String> getModel() {
        return Optional.ofNullable((String) get(Property.MODEL.toString()));
    }
}
