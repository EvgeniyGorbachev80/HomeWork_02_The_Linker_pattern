package org.Gorbachev.domain;

import org.Gorbachev.Document;
import org.Gorbachev.domain.enums.Property;
import java.util.Optional;

/**
 * HasPrice trait for static access to 'price' property.
 */
public interface HasPrice extends Document {
    default Optional<Number> getPrice() {
        return Optional.ofNullable((Number) get(Property.PRICE.toString()));
    }
}
