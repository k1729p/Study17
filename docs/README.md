<!DOCTYPE html>
<HTML>
<HEAD>
	<META charset="UTF-8">
</HEAD>
<BODY>
<a href="../../../tree/main/docs"><IMG src="images/ColorScheme.png" height="25" width="800"/></a>
<H2 id="contents">Study17 README Contents</H2>
<H3>The assessment of the libraries</H3>
<table style="border:solid">
<tbody>
<tr>
<td style="border:solid">Java Mapping Framework <a href="https://mapstruct.org/">MapStruct</a></td>
<td style="border:solid"><a href="https://commons.apache.org/proper/commons-collections/">Apache Commons Collections</a></td>
</tr><tr>
<td style="border:solid"><a href="https://github.com/npgall/concurrent-trees">Concurrent Radix &amp; Suffix Trees</a></td>
<td style="border:solid"><a href="https://www.eclipse.org/collections/">Eclipse Collections</a></td>
</tr>
</tbody></table>

<br>

<p>
The sections of this project:
<ol>
<li><a href="#ONE">Docker Build</A></li>
<li><a href="#TWO">MapStruct</A></li>
<li><a href="#THREE">Commons Collections</A></li>
<li><a href="#FOUR">Concurrent Radix &amp; Suffix Trees</A></li>
<li><a href="#FIVE">Eclipse Collections</A></li>
</ol>
</p>

<P>Java source code:<BR/>
<img src="images/aquaHR-500.png"><BR/>
<img src="images/aquaSquare.png">
	<a href="https://github.com/k1729p/Study17/blob/master/src/main/java/kp">kp</a><BR/>
<img src="images/aquaHR-500.png"></P>

<p>
<img src="images/yellowHR-500.png"><br>
<img src="images/yellowSquare.png">
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study17/blob/main/docs/apidocs/index.html">
	Java API Documentation</a><br>
<img src="images/yellowHR-500.png">
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="ONE">❶ Docker Build</H2>

<p>Action:<BR/>
<img src="images/orangeHR-500.png"><BR/>
<img src="images/orangeSquare.png"> 1. With the batch file 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/01%20Docker%20build%20and%20run.bat">
<I>"01 Docker build and run.bat"</I></a> build the image and start the container<br>
<img src="images/orangeSquare.png"><img src="images/spacer-32.png">
with the application <a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/ApplicationForLibrariesAssay.java">
'kp.ApplicationForLibrariesAssay'</a>.<br>
<img src="images/orangeSquare.png"> 2. With the batch file 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/02%20Docker%20show%20logs.bat">
<I>"02 Docker show logs.bat"</I></a> view the console logs from the application run.<br>
<img src="images/orangeHR-500.png"></p>
 
 <P><img src="images/greenCircle.png">
1.1. Docker image is built using these files:
<a href="https://raw.githubusercontent.com/k1729p/Study17/main/docker-config/Dockerfile"><b>Dockerfile</b></a> and
<a href="https://raw.githubusercontent.com/k1729p/Study17/main/docker-config/compose.yaml"><b>compose.yaml</b></a>.
</P>
<P>
<IMG src="images/ScreenshotDockerContainer.png" height="275" width="875"/><BR>
<img src="images/blackArrowUp.png">
<I>The screenshot of the created Docker containers.</I>
</P>

 <P><img src="images/greenCircle.png">
1.2. Alternative batch files.<br>
For building and running the 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/ApplicationForLibrariesAssay.java">
'kp.ApplicationForLibrariesAssay'</a> on 'localhost' use 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/03%20MVN%20clean%20install%20run.bat"> 
<i>"03 MVN clean install run.bat"</i></a>.<br>
For only running the 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/ApplicationForLibrariesAssay.java">
'kp.ApplicationForLibrariesAssay'</a> on 'localhost' use 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/04%20Run%20Application.bat"> 
<i>"04 Run Application.bat"</i></a>.
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="TWO">❷ MapStruct</H2>
<p><img src="images/greenCircle.png">
2.1. The mapping launch method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/MapperLauncher.java#L40">
'kp.mappers.MapperLauncher::launch'</a><BR/>
</p>
<P><IMG src="images/MapStruct.png" height="100" width="820"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'kp.mappers.MapperLauncher::launch' method.</I></P>

<P><img src="images/greenCircle.png">
2.2. The mapping <b>source</b> objects:
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/First.java">First</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/builders/Top.java">Top</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ElementOne.java">ElementOne</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/KeyOne.java">KeyOne</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ValueOne.java">ValueOne</a></li>
</ul>
</p>
<P><IMG src="images/MermaidClassDiagramFirst.png" height="745" width="830"/><BR>
<img src="images/blackArrowUp.png">
<I>The class diagram of the mapping source objects.</I></P>

<P><img src="images/greenCircle.png">
2.3. The mapping <b>target</b> objects:
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/Second.java">Second</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/builders/Bottom.java">Bottom</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ElementTwo.java">ElementTwo</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/KeyTwo.java">KeyTwo</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ValueTwo.java">ValueTwo</a></li>
</ul>
</p>
<P><IMG src="images/MermaidClassDiagramSecond.png" height="745" width="860"/><BR>
<img src="images/blackArrowUp.png">
<I>The class diagram of the mapping target objects.</I></P>

<P><img src="images/greenCircle.png">
2.4. The interfaces are marked with the annotation '@Mapper':
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L26">
'kp.mappers.FirstMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L108">
'kp.mappers.FirstMapper.ElementOneMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L132">
'kp.mappers.FirstMapper.KeyOneMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L156">
'kp.mappers.FirstMapper.ValueOneMapper'</a></li>
</ul>
</p>
<p>
This marking activates the generation of an implementation of that type via 'MapStruct'.
</p>

<P><img src="images/greenCircle.png">
2.5. The mapping method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L40">
'kp.mappers.FirstMapper::toSecond'</a><br>
The finishing method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L64">
'kp.mappers.FirstMapper::afterToSecond'</a>
</p>

<P><img src="images/greenCircle.png">
2.6. The inverse mapping method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L53">
'kp.mappers.FirstMapper::fromSecond'</a><br>
The finishing method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L75">
'kp.mappers.FirstMapper::afterToFirst'</a>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="THREE">❸ Commons Collections</H2>

<p><img src="images/greenCircle.png">
3.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/commons/ApacheCommonsCollections.java#L41">
'kp.collections.commons.ApacheCommonsCollections::researchBidirectionalMap'</a>.
</p>
<P><IMG src="images/CommonsCollectionsBidirectionalMap.png" height="100" width="275"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ApacheCommonsCollections::researchBidirectionalMap' method.</I></P>

<p><img src="images/greenCircle.png">
3.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/commons/ApacheCommonsCollections.java#L61">
'kp.collections.commons.ApacheCommonsCollections::researchPatriciaTrie'</a>.
</p>
</p>
<b>PATRICIA</b>: Practical Algorithm to Retrieve Information Coded in Alphanumeric.<br>
A <i>trie</i> is also called a <i>digital tree</i>, <i>radix tree</i>, or <i>prefix tree</i>.
<p>
<P><IMG src="images/CommonsCollectionsPatriciaTrie.png" height="190" width="1090"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ApacheCommonsCollections::researchPatriciaTrie' method.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="FOUR">❹ Concurrent Radix &amp; Suffix Trees</H2>

<p><img src="images/greenCircle.png">
4.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L62">
'kp.trees.ConcurrentTrees::researchRadixTree'</a>.
</p>
<P><IMG src="images/ConcurrentTreesRadixTree.png" height="855" width="690"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchRadixTree' method.</I></P>

<p><img src="images/greenCircle.png">
4.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L95">
'kp.trees.ConcurrentTrees::researchSufixTree'</a>.
</p>
<P><IMG src="images/ConcurrentTreesSufixTree.png" height="60" width="635"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchSufixTree' method.</I></P>

<p><img src="images/greenCircle.png">
4.3. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L116">
'kp.trees.ConcurrentTrees::researchInvertedRadixTree'</a>.
</p>
<P><IMG src="images/ConcurrentTreesInvertedRadixTree.png" height="80" width="610"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchInvertedRadixTree' method.</I></P>

<p><img src="images/greenCircle.png">
4.4. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L145">
'kp.trees.ConcurrentTrees::researchReversedRadixTree'</a>.
</p>
<P><IMG src="images/ConcurrentTreesReversedRadixTree.png" height="30" width="460"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchReversedRadixTree' method.</I></P>

<p><img src="images/greenCircle.png">
4.5. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L161">
'kp.trees.ConcurrentTrees::researchPrefixesAndSuffixesGenerator'</a>.
</p>
<P><IMG src="images/ConcurrentTreesPrefixesAndSuffixesGenerator.png" height="45" width="350"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchPrefixesAndSuffixesGenerator' method.</I></P>

<p><img src="images/greenCircle.png">
4.6. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L176">
'kp.trees.ConcurrentTrees::researchSolver'</a>.
</p>
<P><IMG src="images/ConcurrentTreesSolver.png" height="45" width="365"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'ConcurrentTrees::researchSolver' method.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
<H2 id="FIVE">❺ Eclipse Collections</H2>

<p><img src="images/greenCircle.png">
5.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L136">
'kp.collections.eclipse.EclipseCollections::researchChunksAndPairs'</a><BR/>
</p>
<p>
The chunk - a collection of a specified fixed size.
</p>
<P><IMG src="images/EclipseCollectionsChunksAndPairs.png" height="170" width="580"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchChunksAndPairs' method.</I></P>

<p><img src="images/greenCircle.png">
5.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L183">
'kp.collections.eclipse.EclipseCollections::researchMapFlipping'</a><BR/>
</p>
<P><IMG src="images/EclipseCollectionsMapFlipping.png" height="100" width="615"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchMapFlipping' method.</I></P>

<p><img src="images/greenCircle.png">
5.3. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L218">
'kp.collections.eclipse.EclipseCollections::researchSetOperations'</a><BR/>
</p>
<P><IMG src="images/EclipseCollectionsSetOperations.png" height="65" width="615"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchSetOperations' method.</I></P>

<p><img src="images/greenCircle.png">
5.4. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L243">
'kp.collections.eclipse.EclipseCollections::researchUsingDates'</a><BR/>
</p>
<P><IMG src="images/EclipseCollectionsUsingDates.png" height="280" width="1015"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchUsingDates' method.</I></P>

<p><img src="images/greenCircle.png">
5.5. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L323">
'kp.collections.eclipse.EclipseCollections::researchUsingNumbers'</a><BR/>
</p>
<P><IMG src="images/EclipseCollectionsUsingNumbers.png" height="190" width="705"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchUsingNumbers' method.</I></P>

<p><img src="images/greenCircle.png">
5.6. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L386">
'kp.collections.eclipse.EclipseCollections::researchStacks'</a><BR/>
</p>
<P><IMG src="images/EclipseCollectionsStacks.png" height="60" width="365"/><BR>
<img src="images/blackArrowUp.png">
<I>Console log from 'EclipseCollections::researchStacks' method.</I></P>

<a href="#top">Back to the top of the page</a>
<hr>
</BODY>
</HTML>