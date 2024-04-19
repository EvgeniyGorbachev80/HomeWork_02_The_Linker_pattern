package org.Gorbachev.domain;

import org.Gorbachev.AbstractDocument;
import java.util.Map;

/**
 * Part entity.
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {
    public Part(Map<String, Object> properties) {
        super(properties);
    }
}
