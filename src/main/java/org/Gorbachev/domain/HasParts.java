package org.Gorbachev.domain;

import org.Gorbachev.Document;
import org.Gorbachev.domain.enums.Property;
import java.util.stream.Stream;

/**
 * HasParts trait for static access to 'parts' property.
 */
public interface HasParts extends Document {
    default Stream<Part> getParts() {
        return children(Property.PARTS.toString(), Part::new);
    }
}
