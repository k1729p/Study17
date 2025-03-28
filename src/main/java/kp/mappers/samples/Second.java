package kp.mappers.samples;

import kp.mappers.samples.builders.Bottom;
import kp.mappers.samples.items.ElementTwo;
import kp.mappers.samples.items.KeyTwo;
import kp.mappers.samples.items.ValueTwo;

import java.util.List;
import java.util.Map;

/**
 * Represents the second record with the following properties:
 *
 * @param id      the id
 * @param name    the name
 * @param bottom  the {@link Bottom} object
 * @param listTwo the list of {@link ElementTwo} objects
 * @param mapTwo  the map containing {@link KeyTwo} and {@link ValueTwo} pairs
 */
public record Second(long id,
                     String name,
                     Bottom bottom,
                     List<ElementTwo> listTwo,
                     Map<KeyTwo, ValueTwo> mapTwo) {
}
