package kp.trees;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.concurrenttrees.common.CharSequences;
import com.googlecode.concurrenttrees.common.Iterables;
import com.googlecode.concurrenttrees.common.PrettyPrinter;
import com.googlecode.concurrenttrees.radix.ConcurrentRadixTree;
import com.googlecode.concurrenttrees.radix.RadixTree;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharArrayNodeFactory;
import com.googlecode.concurrenttrees.radix.node.concrete.DefaultCharSequenceNodeFactory;
import com.googlecode.concurrenttrees.radix.node.util.PrettyPrintable;
import com.googlecode.concurrenttrees.radixinverted.ConcurrentInvertedRadixTree;
import com.googlecode.concurrenttrees.radixinverted.InvertedRadixTree;
import com.googlecode.concurrenttrees.radixreversed.ConcurrentReversedRadixTree;
import com.googlecode.concurrenttrees.radixreversed.ReversedRadixTree;
import com.googlecode.concurrenttrees.solver.LCSubstringSolver;
import com.googlecode.concurrenttrees.suffix.ConcurrentSuffixTree;
import com.googlecode.concurrenttrees.suffix.SuffixTree;

import kp.Constants;

/*-
 * The framed javadoc for 'Concurrent-Trees API' can be read by setting URL in Eclipse IDE: 
 * https://github.com/npgall/concurrent-trees/tree/master/documentation/javadoc/apidocs
 */
/**
 * Researching <a href="https://github.com/npgall/concurrent-trees">Concurrent
 * Trees</a>.
 * <p>
 * <a href=
 * "https://htmlpreview.github.io/?https://raw.githubusercontent.com/npgall/concurrent-trees/master/documentation/javadoc/apidocs/overview-summary.html">Concurrent-Trees
 * 2.6.0 API</a>
 * <ul>
 * <li>{@link RadixTree}<br>
 * <code>    - known as PATRICIA trie or compact prefix tree</code>
 * <li>{@link ReversedRadixTree}
 * <li>{@link InvertedRadixTree}<br>
 * <code>    - scanning for keywords in external documents</code>
 * <li>{@link SuffixTree}<br>
 * <code>    - known as PAT tree or position tree</code>
 * <li>{@link PrettyPrinter}
 * <li>{@link LCSubstringSolver}<br>
 * <code>    - longest common substring solver</code>
 * </ul>
 */
public class ConcurrentTrees {
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

	/**
	 * The hidden constructor.
	 */
	private ConcurrentTrees() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Researches the {@link RadixTree}.
	 * 
	 */
	public static void researchRadixTree() {

		final RadixTree<Integer> radixTree = new ConcurrentRadixTree<>(new DefaultCharArrayNodeFactory());
		final AtomicInteger atomic = new AtomicInteger();
		Constants.EXAMPLE_KEY_STREAM_SUP.get().forEach(key -> radixTree.put(key, atomic.incrementAndGet()));
		final StringBuilder stringBuilder = new StringBuilder();
		PrettyPrinter.prettyPrint((PrettyPrintable) radixTree, stringBuilder);
		logger.info("Pretty print (a semi-graphical string representation of a given tree):");
		String message = stringBuilder.toString();
		logger.info(message);

		message = String.format("RadixTree: keys starting with 'a' %s",
				Iterables.toString(radixTree.getKeysStartingWith("a")));
		logger.info(message);
		message = String.format("RadixTree: keys starting with 'ab' %s",
				Iterables.toString(radixTree.getKeysStartingWith("ab")));
		logger.info(message);
		message = String.format("RadixTree: values for keys starting with 'ab' %s",
				Iterables.toString(radixTree.getValuesForKeysStartingWith("ab")));
		logger.info(message);
		message = String.format("RadixTree: key-value pairs for keys starting with 'ab' %s",
				Iterables.toString(radixTree.getKeyValuePairsForKeysStartingWith("ab")));
		logger.info(message);
		message = String.format("RadixTree: keys closest to 'abxxx' %s",
				Iterables.toString(radixTree.getClosestKeys("abxxx")));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches the {@link SuffixTree}.
	 * 
	 */
	public static void researchSuffixTree() {

		final SuffixTree<Integer> suffixTree = new ConcurrentSuffixTree<>(new DefaultCharArrayNodeFactory());
		final AtomicInteger atomic = new AtomicInteger();
		Constants.EXAMPLE_KEY_STREAM_SUP.get().forEach(key -> suffixTree.put(key, atomic.get()));
		String message = String.format("SuffixTree: keys ending with 'c' %s",
				Iterables.toString(suffixTree.getKeysEndingWith("c")));
		logger.info(message);
		message = String.format("SuffixTree: keys ending with 'bc' %s",
				Iterables.toString(suffixTree.getKeysEndingWith("bc")));
		logger.info(message);
		message = String.format("SuffixTree: keys containing 'ab' %s",
				Iterables.toString(suffixTree.getKeysContaining("ab")));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches the {@link InvertedRadixTree}.
	 * 
	 */
	public static void researchInvertedRadixTree() {

		final InvertedRadixTree<Integer> invertedRadixTree = new ConcurrentInvertedRadixTree<>(
				new DefaultCharArrayNodeFactory());
		final AtomicInteger atomic = new AtomicInteger();
		Constants.EXAMPLE_KEY_STREAM_SUP.get().forEach(key -> invertedRadixTree.put(key, atomic.get()));
		final String prefix = "ab";
		String message = String.format("InvertedRadixTree: keys starting with prefix 'ab' %s",
				Iterables.toString(invertedRadixTree.getKeysStartingWith(prefix)));
		logger.info(message);
		final String document1 = "abcba";
		message = String.format("InvertedRadixTree: keys contained in document 'abcba' %s",
				Iterables.toString(invertedRadixTree.getKeysContainedIn(document1)));
		logger.info(message);
		final String document2 = "aabbcc";
		message = String.format("InvertedRadixTree: keys contained in document 'aabbcc' %s",
				Iterables.toString(invertedRadixTree.getKeysContainedIn(document2)));
		logger.info(message);
		final String document3 = "aaaa bbb cc";
		message = String.format("InvertedRadixTree: keys contained in document 'aaaa bbb cc' %s",
				Iterables.toString(invertedRadixTree.getKeysContainedIn(document3)));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches the {@link ReversedRadixTree}.
	 * 
	 */
	public static void researchReversedRadixTree() {

		final ReversedRadixTree<Integer> reversedRadixTree = new ConcurrentReversedRadixTree<>(
				new DefaultCharArrayNodeFactory());
		final AtomicInteger atomic = new AtomicInteger();
		Constants.EXAMPLE_KEY_STREAM_SUP.get().forEach(key -> reversedRadixTree.put(key, atomic.get()));
		String message = String.format("ReversedRadixTree: keys ending with 'bc' %s",
				Iterables.toString(reversedRadixTree.getKeysEndingWith("bc")));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches the {@link ReversedRadixTree}.
	 * 
	 */
	public static void researchPrefixesAndSuffixesGenerator() {

		String message = String.format("Generated prefixes for 'xyz': %s",
				Iterables.toString(CharSequences.generatePrefixes("xyz")));
		logger.info(message);
		message = String.format("Generated suffixes for 'xyz': %s",
				Iterables.toString(CharSequences.generateSuffixes("xyz")));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

	/**
	 * Researches the {@link LCSubstringSolver}.
	 * 
	 */
	public static void researchSolver() {

		final List<String> documentList = List.of(//
				/*- ----*/"ijkl mn opqr stuv wxyz", //
				/*-*/"efgh ijkl mn opqr stuv", //
				"abcd efgh ijkl mn opqr");
		final LCSubstringSolver solver = new LCSubstringSolver(new DefaultCharSequenceNodeFactory());
		solver.add(documentList.getFirst());
		solver.add(documentList.get(1));
		String message = String.format("Longest common substring [%s]",
				CharSequences.toString(solver.getLongestCommonSubstring()));
		logger.info(message);
		solver.add(documentList.getLast());
		message = String.format("Longest common substring [%s]",
				CharSequences.toString(solver.getLongestCommonSubstring()));
		logger.info(message);
		logger.info(Constants.HORIZONTAL_RULE);
	}

}
