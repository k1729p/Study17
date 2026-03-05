package kp.mappers;

import kp.mappers.samples.First;
import kp.mappers.samples.Second;
import kp.mappers.samples.items.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Mapper for {@link First} and {@link Second}.
 */
@Mapper(uses = {
        FirstMapper.ElementOneMapper.class,
        FirstMapper.KeyOneMapper.class,
        FirstMapper.ValueOneMapper.class})
public interface FirstMapper {
    /**
     * Instance of the interface implementation.
     */
    FirstMapper INSTANCE = Mappers.getMapper(FirstMapper.class);

    /**
     * Maps {@link First} to {@link Second}.
     *
     * @param first       {@link First} instance
     * @param labelsQueue {@link Queue} with labels
     * @return {@link Second} instance
     */
    @Mapping(source = "name", target = "name", qualifiedByName = "changeNameInSecond")
    @Mapping(source = "top.left", target = "bottom.right")
    @Mapping(source = "listOne", target = "listTwo")
    @Mapping(source = "mapOne", target = "mapTwo")
    Second toSecond(First first, @Context Queue<String> labelsQueue);

    /**
     * Maps {@link Second} to {@link First}.
     *
     * @param second      {@link Second} instance
     * @param labelsQueue {@link Queue} with labels
     * @return {@link First} instance
     */
    @InheritInverseConfiguration
    @Mapping(source = "name", target = "name", qualifiedByName = "changeNameInFirst")
    First fromSecond(Second second, @Context Queue<String> labelsQueue);

    /**
     * Completes the mapping {@link First} to {@link Second}.
     *
     * @param second      the {@link Second} instance
     * @param labelsQueue the {@link Queue} with labels
     */
    @AfterMapping
    default void afterToSecond(@MappingTarget Second second, @Context Queue<String> labelsQueue) {
        second.listTwo().add(new ElementTwo(labelsQueue.poll()));
    }

    /**
     * Completes the mapping {@link Second} to {@link First}..
     *
     * @param first       the {@link First} instance
     * @param labelsQueue the {@link Queue} with labels
     */
    @AfterMapping
    default void afterFromSecond(@MappingTarget First first, @Context Queue<String> labelsQueue) {
        first.listOne().add(new ElementOne(labelsQueue.poll()));
    }

    /**
     * Changes the name in {@link Second}.
     *
     * @param name the name
     * @return the modified name
     */
    @Named("changeNameInSecond")
    default String changeNameInSecond(String name) {
        return name.toUpperCase();
    }

    /**
     * Changes the name in {@link First}.
     *
     * @param name the name
     * @return the modified name
     */
    @Named("changeNameInFirst")
    default String changeNameInFirst(String name) {
        return Stream.of(name.split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
    }

    /**
     * Mapper for list elements: {@link ElementOne} and {@link ElementTwo}.
     */
    @Mapper
    interface ElementOneMapper {
        /**
         * Maps {@link ElementOne} to {@link ElementTwo}.
         *
         * @param elementOne the {@link ElementOne} instance
         * @return the {@link ElementTwo} instance
         */
        ElementTwo toElementTwo(ElementOne elementOne);

        /**
         * Maps {@link ElementTwo} to {@link ElementOne}.
         *
         * @param elementTwo the {@link ElementTwo} instance
         * @return the {@link ElementOne} instance
         */
        ElementOne fromElementTwo(ElementTwo elementTwo);
    }

    /**
     * Mapper for map keys: {@link KeyOne} and {@link KeyTwo}.
     */
    @Mapper
    interface KeyOneMapper {
        /**
         * Maps {@link KeyOne} to {@link KeyTwo}.
         *
         * @param keyOne the {@link KeyOne} instance
         * @return the {@link KeyTwo} instance
         */
        KeyTwo toKeyTwo(KeyOne keyOne);

        /**
         * Maps {@link KeyTwo} to {@link KeyOne}.
         *
         * @param keyTwo the {@link KeyTwo} instance
         * @return the {@link KeyOne} instance
         */
        KeyOne fromKeyTwo(KeyTwo keyTwo);

    }

    /**
     * Mapper for map values: {@link ValueOne} and {@link ValueTwo}.
     */
    @Mapper
    interface ValueOneMapper {
        /**
         * Maps {@link ValueOne} to {@link ValueTwo}.
         *
         * @param valueOne the {@link ValueOne} instance
         * @return the {@link ValueTwo} instance
         */
        ValueTwo toMapTwo(ValueOne valueOne);

        /**
         * Maps {@link ValueTwo} to {@link ValueOne}.
         *
         * @param valueTwo the {@link ValueTwo} instance
         * @return the {@link ValueOne} instance
         */
        ValueOne fromValueTwo(ValueTwo valueTwo);
    }

}
