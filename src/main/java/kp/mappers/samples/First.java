package kp.mappers.samples;

import kp.mappers.samples.builders.Top;
import kp.mappers.samples.items.ElementOne;
import kp.mappers.samples.items.KeyOne;
import kp.mappers.samples.items.ValueOne;

import java.util.List;
import java.util.Map;

/**
 * Represents the first record with the following properties:
 *
 * @param id      the id
 * @param name    the name
 * @param top     the {@link Top} object
 * @param listOne the list of {@link ElementOne} objects
 * @param mapOne  the map containing {@link KeyOne} and {@link ValueOne} pairs
 */
public record First(long id,
                    String name,
                    Top top,
                    List<ElementOne> listOne,
                    Map<KeyOne, ValueOne> mapOne) {
}
