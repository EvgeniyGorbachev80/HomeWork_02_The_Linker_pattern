package org.Gorbachev;

import org.Gorbachev.domain.Car;
import org.Gorbachev.domain.Part;
import org.Gorbachev.domain.enums.Property;
import java.util.HashMap;
import java.util.Map;
//import lombok.extern.slf4j.Slf4j;


/**
 * The Abstract Document pattern enables handling additional, non-static properties. This pattern
 * uses concept of traits to enable type safety and separate properties of different classes into
 * set of interfaces.
 *
 * <p>In Abstract Document pattern,({@link AbstractDocument}) fully implements {@link Document})
 * interface. Traits are then defined to enable access to properties in usual, static way.
 */
//@Slf4j
public class App {
    public static void main(String[] args) {
        // Создаем машину
        Map<String, Object> carProperties = new HashMap<>();
        carProperties.put(Property.MODEL.toString(), "Toyota Camry");
        carProperties.put(Property.PRICE.toString(), 25000);
        Car car = new Car(carProperties);

        // Добавляем детали машины
        Map<String, Object> part1Properties = new HashMap<>();
        part1Properties.put(Property.TYPE.toString(), "Engine");
        part1Properties.put(Property.PRICE.toString(), 5000);
        Map<String, Object> part2Properties = new HashMap<>();
        part2Properties.put(Property.TYPE.toString(), "Tires");
        part2Properties.put(Property.PRICE.toString(), 1000);

        car.put(Property.PARTS.toString(), new Part(part1Properties));
        car.put(Property.PARTS.toString(), new Part(part2Properties));


        // Выводим информацию о машине
        System.out.println("Car Model: " + car.getModel().orElse("Unknown"));
        System.out.println("Car Price: $" + car.getPrice().orElse(0));
        System.out.println("Car Parts:");
        car.getParts().forEach(part -> {
            System.out.println("  - Type: " + part.getType().orElse("Unknown"));
            System.out.println("    Price: $" + part.getPrice().orElse(0));
        });
    }
}
