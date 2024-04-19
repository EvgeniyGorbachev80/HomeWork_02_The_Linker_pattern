package org.Gorbachev.domain;

import org.Gorbachev.Document;
import org.Gorbachev.domain.enums.Property;
import java.util.Optional;

/**
 * HasType trait for static access to 'type' property.
 */
public interface HasType extends Document {
    default Optional<String> getType() {
        return Optional.ofNullable((String) get(Property.TYPE.toString()));
    }
}
