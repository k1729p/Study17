package kp.collections.eclipse;

import java.lang.invoke.MethodHandles;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bimap.ImmutableBiMap;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.MutableOrderedMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.ImmutableMultimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.api.partition.list.PartitionMutableList;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.stack.ImmutableStack;
import org.eclipse.collections.api.stack.MutableStack;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.BiMaps;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.factory.Multimaps;
import org.eclipse.collections.impl.factory.OrderedMaps;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.SortedMaps;
import org.eclipse.collections.impl.factory.Stacks;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.utility.Iterate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kp.Constants;

/*-
--------------------|-----------------------------------|
Eclipse Collections | Java Collections & Streams		|
--------------------|-----------------------------------|
FastList			| ArrayList							|
UnifiedSet			| HashSet							|
UnifiedMap			| HashMap							|
ArrayStack			| Stack								|
					|									|
select				| filter							|
reject				| filter (!)						|
collect				| map								|
flatCollect			| flatMap							|
detect 				| filter().findFirst().orElse(null)	|
detectIfNone 		| filter().findFirst().orElseGet()	|
detectOptional 		| filter().findFirst()				|
count 				| filter().count()					|
injectInto 			| reduce							|
any/all/noneSatisfy | any/all/noneMatch					|
--------------------|-----------------------------------|

('Eclipse Collections' were previously named 'Goldman Sachs Collections')
The framed javadoc for 'Eclipse Collections API' can be read by using Eclipse IDE.
*/
/**
 * Researching <a href="https://www.eclipse.org/collections/">Eclipse
 * Collections</a>
 * <p>
 * <a href="https://www.eclipse.org/collections/javadoc/11.1.0/">Eclipse
 * Collections API - 11.1.0</a><br>
 * <a href=
 * "https://github.com/eclipse/eclipse-collections/blob/master/docs/0-RefGuide.adoc">Eclipse
 * Collections Reference Guide</a>.
 * <ul>
 * <li>{@link FastList}
 * <li>{@link FastListMultimap}
 * <li>{@link IntInterval}
 * <li>{@link IntIterable}
 * <li>{@link MutableBag}
 * <li>{@link MutableIntList}
 * <li>{@link MutableList}
 * <li>{@link MutableListMultimap}
 * <li>{@link MutableMap}
 * <li>{@link MutableOrderedMap}
 * <li>{@link MutableSortedSet}
 * <li>{@link MutableStack}
 * <li>{@link OrderedMaps}
 * <li>{@link PartitionMutableList}
 * <li>{@link RichIterable}
 * <li>{@link UnifiedMap}
 * <li>{@link UnifiedSet}
 * </ul>
 */
public class EclipseCollections {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

	private static final LocalDate EXAMPLE_DATE = LocalDate.of(2000, 1, 1);

	/**
	 * The hidden constructor.
	 */
	private EclipseCollections() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Researches the chunks and the {@link Pair}s.
	 * <p>
	 * The chunk - a collection of a specified fixed size.<br>
	 * Used here are classes:
	 * <ul>
	 * <li>{@link MutableList}
	 * <li>{@link MutableIntList}
	 * <li>{@link FastList}
	 * <li>{@link RichIterable}
	 * <li>{@link IntInterval}
	 * <li>{@link IntIterable}
	 * </ul>
	 */
	public static void researchChunksAndPairs() {

		final MutableIntList mutableIntList = IntInterval.fromTo(1, 10).toList();
		final int chunkSize = 4;
		final RichIterable<IntIterable> chunks = mutableIntList.chunk(chunkSize);
		String message = String.format("Chunk size[%d], chunks%s", chunkSize, chunks);
		logger.info(message);
		message = String.format("In 2nd chunk the 4th element[%d]. In 3rd chunk the 1st element[%d].",
				chunks.toList().get(1).toList().get(3), chunks.toList().get(2).toList().get(0));
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final MutableList<String> mutableList1 = FastList.newListWith("aaa", "bbb", "ccc", "truncated");
		final MutableList<String> mutableList2 = FastList.newListWith("AAA", "BBB", "CCC");
		message = String.format("1st list%s, 2nd list%s", mutableList1, mutableList2);
		logger.info(message);
		final MutableList<Pair<String, String>> pairs = mutableList1.zip(mutableList2);
		message = String.format("Two lists zipped into pairs%s", pairs);
		logger.info(message);
		message = String.format("In 2nd pair the 'Two' element[%s]. In 3rd pair the 'One' element[%s].",
				pairs.toList().get(1).getTwo(), pairs.toList().get(2).getOne());
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final MutableIntList mutableIntList1 = IntInterval.fromTo(1, 5).toList();
		final MutableIntList mutableIntList2 = IntInterval.fromToBy(5, 25, 5).toList();
		message = String.format("1st list%s, 2nd list%s", mutableIntList1, mutableIntList2);
		logger.info(message);
		message = String.format("Two lists zipped into pairs%s", mutableIntList1.zipInt(mutableIntList2));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches flipping a map.
	 * <p>
	 * Used here are classes:
	 * <ul>
	 * <li>{@link MutableMap}
	 * <li>{@link FastListMultimap}
	 * </ul>
	 */
	public static void researchMapFlipping() {

		final Iterable<String> iterable = Lists.mutable.of("a", "b", "c");
		final org.eclipse.collections.api.block.function.Function<String, String> keyFunction = k -> k.concat("k");
		final org.eclipse.collections.api.block.function.Function<String, String> valueFunction = //
				v -> v.toUpperCase().concat("V");
		final MutableMap<String, String> mutableMap = Iterate.toMap(iterable, keyFunction, valueFunction);
		String message = String.format("MutableMap[%s]", mutableMap);
		logger.info(message);
		message = String.format("MutableMap[%s] ◄ flipped", mutableMap.flip());
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final FastListMultimap<String, String> multimap = FastListMultimap.newMultimap();
		multimap.putAll(Multimaps.mutable.list.of("aK", "AV", "aK", "BV", "aK", "CV"));
		multimap.putAll(Multimaps.mutable.list.of("bK", "AV", "bK", "BV", "bK", "CV"));
		multimap.putAll(Multimaps.mutable.list.of("cK", "AV", "cK", "BV", "cK", "CV"));
		// adding duplicate element
		multimap.put("cK", "CV");
		message = String.format("Multimap[%s]", multimap);
		logger.info(message);
		message = String.format("Multimap[%s] ◄ flipped", multimap.flip());
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches set operations.
	 * <p>
	 * Used here are classes:
	 * <ul>
	 * <li>{@link MutableSortedSet}
	 * <li>{@link UnifiedSet}
	 * </ul>
	 */
	public static void researchSetOperations() {

		final MutableSortedSet<String> set1 = UnifiedSet.newSetWith("A", "B", "C").toSortedSet();
		final MutableSortedSet<String> set2 = UnifiedSet.newSetWith("B", "C", "D").toSortedSet();
		String message = String.format("set 1%s, set 2%s", set1, set2);
		logger.info(message);

		message = String.format("sets union%s, sets intersect%s", set1.union(set2), set1.intersect(set2));
		logger.info(message);

		message = String.format("set 1 difference %s, set 2 difference %s, sets symmetric difference%s",
				set1.difference(set2), set2.difference(set1), set1.symmetricDifference(set2));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches using dates.
	 * <p>
	 * Used here are classes:
	 * <ul>
	 * <li>{@link FastList}
	 * <li>{@link MutableBag}
	 * <li>{@link MutableList}
	 * <li>{@link MutableListMultimap}
	 * </ul>
	 */
	public static void researchUsingDates() {

		final List<LocalDate> list1 = IntStream.rangeClosed(-3, 3).boxed().map(EXAMPLE_DATE::plusDays).toList();
		final MutableList<LocalDate> dateList = FastList.newList(list1);
		String message = String.format("Date list%s", dateList);
		logger.info(message);
		org.eclipse.collections.api.block.predicate.Predicate<LocalDate> predicate1 = Predicates
				.attributeEqual(LocalDate::getDayOfWeek, DayOfWeek.MONDAY);
		message = String.format("Monday detected in date list: date[%s]", dateList.detect(predicate1));
		logger.info(message);

		final boolean successFlag = dateList.anySatisfyWith(LocalDate::isAfter, EXAMPLE_DATE);
		message = String.format("Days after[%s]: selected any [%b], selected days count[%d]", EXAMPLE_DATE, successFlag,
				dateList.countWith(LocalDate::isAfter, EXAMPLE_DATE));
		logger.info(message);

		final MutableList<LocalDate> selectedList = dateList.selectWith(LocalDate::isAfter, EXAMPLE_DATE);
		final MutableList<LocalDate> rejectList = dateList.rejectWith(LocalDate::isAfter, EXAMPLE_DATE);
		message = String.format("Days after[%s]: rejected%s, selected%s", EXAMPLE_DATE, rejectList, selectedList);
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final MutableList<DayOfWeek> dayOfWeekList = dateList.collect(LocalDate::getDayOfWeek);
		message = String.format("Days of week%s", dayOfWeekList);
		logger.info(message);
		final MutableList<DayOfWeek> notMondayDOWList1 = dayOfWeekList.reject(DayOfWeek.MONDAY::equals);
		message = String.format("Days of week%s ◄ with Monday rejected", notMondayDOWList1);
		logger.info(message);

		org.eclipse.collections.api.block.predicate.Predicate<LocalDate> predicate2 = Predicates
				.attributeNotEqual(LocalDate::getDayOfWeek, DayOfWeek.MONDAY);
		final MutableList<DayOfWeek> notMondayDOWList2 = dateList.select(predicate2).collect(LocalDate::getDayOfWeek);
		message = String.format("Days of week%s ◄ with any day not equal Monday", notMondayDOWList2);
		logger.info(message);

		org.eclipse.collections.api.block.predicate.Predicate<LocalDate> predicate3 = Predicates
				.attributeBetweenInclusive(LocalDate::getDayOfWeek, DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY);
		final MutableList<DayOfWeek> weekBeginDOWList = dateList.select(predicate3).collect(LocalDate::getDayOfWeek);
		message = String.format("Days of week%s ◄ only Monday, Tuesday, Wednesday", weekBeginDOWList);
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final LocalDate monthEnd = EXAMPLE_DATE.plusMonths(1).minusDays(1);
		final List<LocalDate> list2 = IntStream.rangeClosed(EXAMPLE_DATE.getDayOfYear(), monthEnd.getDayOfYear())
				.boxed().map(EXAMPLE_DATE::withDayOfYear).toList();
		final MutableList<LocalDate> datesOfMonthList = FastList.newList(list2);

		message = String.format(
				"All days in list are from January[%b]. In that list the 31st day of month is present[%b]",
				datesOfMonthList.allSatisfy(day -> day.getMonth() == Month.JANUARY),
				datesOfMonthList.anySatisfy(day -> day.getDayOfMonth() == 31));
		logger.info(message);

		final MutableBag<DayOfWeek> dayOfWeekBag = datesOfMonthList.countBy(LocalDate::getDayOfWeek);
		message = String.format("Between [%s] and [%s] there were [%d] Mondays.", EXAMPLE_DATE, monthEnd,
				dayOfWeekBag.occurrencesOf(DayOfWeek.MONDAY));
		logger.info(message);
		final MutableListMultimap<DayOfWeek, LocalDate> daysToWeekdays = datesOfMonthList
				.groupBy(LocalDate::getDayOfWeek);
		final MutableList<LocalDate> mondaysList = daysToWeekdays.get(DayOfWeek.MONDAY);
		message = String.format("The Mondays%s", mondaysList);
		logger.info(message);

		logger.info("MutableBag with weekdays:");
		message = dayOfWeekBag.toStringOfItemToCount();
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches using numbers.
	 * <p>
	 * Used here are classes:
	 * <ul>
	 * <li>{@link UnifiedMap}
	 * <li>{@link MutableOrderedMap}
	 * <li>{@link OrderedMaps}
	 * <li>{@link FastList}
	 * <li>{@link MutableList}
	 * <li>{@link RichIterable}
	 * <li>{@link PartitionMutableList}
	 * <li>{@link IntInterval}
	 * </ul>
	 */
	public static void researchUsingNumbers() {

		final MutableOrderedMap<Integer, String> orderedMap = OrderedMaps.adapt(new LinkedHashMap<>());
		orderedMap.put(3, "c");
		orderedMap.put(4, "d");
		orderedMap.put(1, "a");
		orderedMap.put(2, "b");
		String message = String.format("OrderedMap %s", orderedMap);
		logger.info(message);
		final MutableSortedMap<Integer, String> sortedMap = SortedMaps.adapt(new TreeMap<>());
		sortedMap.putAll(orderedMap);
		message = String.format("SortedMap  %s", sortedMap);
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		final FastList<Integer> sourceList = FastList.newListWith(6, 6, 5, 4, 1, 2, 3, 3);
		final MutableList<Integer> distinctList = sourceList.toSortedList().distinct();
		message = String.format("Source list%s, distinct list%s", sourceList, distinctList);
		logger.info(message);
		message = String.format("Between 2 and 5: selected list%s, rejected list%s",
				distinctList.select(Predicates.betweenInclusive(2, 5)),
				distinctList.reject(Predicates.betweenInclusive(2, 5)));
		logger.info(message);

		final List<Integer> modulo2List = distinctList.select(arg -> arg % 2 == 0);
		message = String.format("Modulo 2: list%s", modulo2List);
		logger.info(message);

		final RichIterable<Integer> iterableSelected = distinctList.selectWith((arg1, arg2) -> arg1 % arg2 == 0, 3);
		final RichIterable<Integer> iterableRejected = distinctList.rejectWith((arg1, arg2) -> arg1 % arg2 == 0, 3);
		message = String.format("Modulo 3: selected list%s, rejected list%s", iterableSelected, iterableRejected);
		logger.info(message);

		final PartitionMutableList<Integer> partitionedList = distinctList
				.partition(number -> number == 2 || number == 3 || number == 5 || number == 7);
		message = String.format("Partition with prime numbers: selected list%s, rejected list%s",
				partitionedList.getSelected(), partitionedList.getRejected());
		logger.info(message);
		logger.info(Constants.SEPARATOR_LINE);

		message = String.format("Intervals(from 1 to 10): by 3 %s, odds%s, evens%s", IntInterval.fromToBy(1, 10, 3),
				IntInterval.oddsFromTo(1, 10), IntInterval.evensFromTo(1, 10));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches stacks.
	 * <p>
	 * Used here is class:
	 * <ul>
	 * <li>{@link MutableStack}
	 * </ul>
	 */
	public static void researchStacks() {

		MutableStack<Integer> mutableStack = Stacks.mutable.with(1, 2, 3, 4, 5, 6);
		String message = String.format("Before  pop: MutableStack %s", mutableStack);
		logger.info(message);
		mutableStack.pop(3);
		message = String.format("After pop 3: MutableStack %s", mutableStack);
		logger.info(message);
		mutableStack.pop(2);
		message = String.format("After pop 2: MutableStack %s", mutableStack);
		logger.info(message);
		mutableStack.pop();
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * This method has intentionally all declarations <b>unused</b>.
	 * <p>
	 * These examples were taken from <a
	 * href=https://www.eclipse.org/collections/>https://www.eclipse.org/collections/</a>
	 */
	@SuppressWarnings("unused")
	private void declareLocalVariables() {

		MutableList<String> mutableListEmpty = Lists.mutable.empty();
		MutableList<String> mutableListOf = Lists.mutable.of("OneA", "OneA", "TwoA", "ThreeA");
		MutableList<String> mutableListWith = Lists.mutable.with("OneB", "OneB", "TwoB", "ThreeB");
		MutableSet<String> mutableSet = Sets.mutable.with("One", "OneC", "TwoC", "ThreeC");
		MutableBag<String> mutableBag = Bags.mutable.with("OneD", "OneD", "TwoD", "ThreeD");
		MutableStack<String> mutableStack = Stacks.mutable.with("OneE", "OneE", "TwoE", "ThreeE");
		MutableMap<String, String> mutableMap = Maps.mutable.with("key1F", "value1F", "key2F", "value2F", "key3F",
				"value3F");
		MutableMultimap<String, String> multimapWithList = Multimaps.mutable.list.with("key1G", "value1-1G", "key1G",
				"value1-2G", "key2G", "value2-1G");
		MutableBiMap<String, String> mutableBiMap = BiMaps.mutable.with("key1H", "value1H", "key2H", "value2H", "key3H",
				"value3H");

		ImmutableList<String> immutableListEmpty = Lists.immutable.empty();
		ImmutableList<String> immutableListOf = Lists.immutable.of("OneI", "OneI", "TwoI", "ThreeI");
		ImmutableList<String> immutableListWith = Lists.immutable.with("OneJ", "OneJ", "TwoJ", "ThreeJ");
		ImmutableSet<String> immutableSet = Sets.immutable.with("OneK", "OneK", "TwoK", "ThreeK");
		ImmutableBag<String> immutableBag = Bags.immutable.with("OneL", "OneL", "TwoL", "ThreeL");
		ImmutableStack<String> immutableStack = Stacks.immutable.with("OneM", "OneM", "TwoM", "ThreeM");
		ImmutableMap<String, String> immutableMap = Maps.immutable.with("key1N", "value1N", "key2N", "value2N", "key3N",
				"value3");
		ImmutableMultimap<String, String> immutableMultimapWithList = Multimaps.immutable.list.with("key1O",
				"value1-1O", "key1O", "value1-2O", "key2O", "value2-1O");
		ImmutableBiMap<String, String> immutableBiMap = BiMaps.immutable.with("key1P", "value1P", "key2P", "value2P",
				"key3P", "value3P");

		MutableIntList intList = IntLists.mutable.of(1, 2, 3);
		MutableLongList longList = LongLists.mutable.of(1L, 2L, 3L);
		MutableCharList charList = CharLists.mutable.of('a', 'b', 'c');
		MutableShortList shortList = ShortLists.mutable.of((short) 1, (short) 2, (short) 3);
		MutableByteList byteList = ByteLists.mutable.of((byte) 1, (byte) 2, (byte) 3);
		MutableBooleanList booleanList = BooleanLists.mutable.of(true, false);
		MutableFloatList floatList = FloatLists.mutable.of(1.0f, 2.0f, 3.0f);
		MutableDoubleList doubleList = DoubleLists.mutable.of(1.0, 2.0, 3.0);
	}
}