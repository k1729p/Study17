<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8"><body>
<a href="https://github.com/k1729p/Study17/tree/main/docs"><img alt="" src="images/ColorScheme.png" height="25" width="800"/></a>
<h2 id="contents">Study17 README Contents</h2>
<h3 id="top">The assessment of the libraries</h3>
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

<p>The sections of this project:</p>
<ol>
<li><a href="#ONE">Docker Build</a></li>
<li><a href="#TWO">MapStruct</a></li>
<li><a href="#THREE">Commons Collections</a></li>
<li><a href="#FOUR">Concurrent Radix &amp; Suffix Trees</a></li>
<li><a href="#FIVE">Eclipse Collections</a></li>
</ol>

<p>Java source code:<br>
<img alt="" src="images/aquaHR-500.png"><br>
<img alt="" src="images/aquaSquare.png">
	<a href="https://github.com/k1729p/Study17/blob/master/src/main/java/kp">kp</a><br>
<img alt="" src="images/aquaHR-500.png">
</p>

<p>
<img alt="" src="images/yellowHR-500.png"><br>
<img alt="" src="images/yellowSquare.png">
    <a href="http://htmlpreview.github.io/?https://github.com/k1729p/Study17/blob/main/docs/apidocs/index.html">
	Java API Documentation</a><br>
<img alt="" src="images/yellowHR-500.png">
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="ONE">❶ Docker Build</h2>

<p>Action:<br>
<img alt="" src="images/orangeHR-500.png"><br>
<img alt="" src="images/orangeSquare.png"> 1. With the batch file 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/01%20Docker%20build%20and%20run.bat">
<i>"01 Docker build and run.bat"</i></a> build the image and start the container<br>
<img alt="" src="images/orangeSquare.png"><img alt="" src="images/spacer-32.png">
with the application <a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/ApplicationForLibrariesAssay.java">
'kp.ApplicationForLibrariesAssay'</a>.<br>
<img alt="" src="images/orangeSquare.png"> 2. With the batch file 
<a href="https://github.com/k1729p/Study17/blob/main/0_batch/02%20Docker%20show%20logs.bat">
<i>"02 Docker show logs.bat"</i></a> view the console logs from the application run.<br>
<img alt="" src="images/orangeHR-500.png">
</p>
 
 <p><img alt="" src="images/greenCircle.png">
1.1. The Docker image is built using these files:
<a href="https://raw.githubusercontent.com/k1729p/Study17/main/docker-config/Dockerfile"><b>Dockerfile</b></a> and
<a href="https://raw.githubusercontent.com/k1729p/Study17/main/docker-config/compose.yaml"><b>compose.yaml</b></a>.
</p>
<p>
<img alt="" src="images/ScreenshotDockerContainer.png" height="275" width="875"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>The screenshot of the created Docker containers.</i>
</p>

 <p><img alt="" src="images/greenCircle.png">
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
<h2 id="TWO">❷ MapStruct</h2>
<p><img alt="" src="images/greenCircle.png">
2.1. The mapping launch method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/MapperLauncher.java#L36">
'kp.mappers.MapperLauncher::launch'</a><br>
</p>
<p><img alt="" src="images/MapStruct.png" height="100" width="820"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'kp.mappers.MapperLauncher::launch' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
2.2. The mapping <b>source</b> objects:
</p>
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/First.java">First</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/builders/Top.java">Top</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ElementOne.java">ElementOne</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/KeyOne.java">KeyOne</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ValueOne.java">ValueOne</a></li>
</ul>
<p><img alt="" src="images/MermaidClassDiagramFirst.png" height="745" width="830"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>The class diagram of the mapping source objects.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
2.3. The mapping <b>target</b> objects:
</p>
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/Second.java">Second</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/builders/Bottom.java">Bottom</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ElementTwo.java">ElementTwo</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/KeyTwo.java">KeyTwo</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/samples/items/ValueTwo.java">ValueTwo</a></li>
</ul>
<p><img alt="" src="images/MermaidClassDiagramSecond.png" height="745" width="860"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>The class diagram of the mapping target objects.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
2.4. The interfaces are marked with the annotation '@Mapper':
</p>
<ul>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java">
'kp.mappers.FirstMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L99">
'kp.mappers.FirstMapper.ElementOneMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L121">
'kp.mappers.FirstMapper.KeyOneMapper'</a></li>
<li><a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L144">
'kp.mappers.FirstMapper.ValueOneMapper'</a></li>
</ul>
<p>
This marking activates the generation of an implementation of that type via 'MapStruct'.
</p>

<p><img alt="" src="images/greenCircle.png">
2.5. The mapping method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L38">
'kp.mappers.FirstMapper::toSecond'</a><br>
The finishing method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L58">
'kp.mappers.FirstMapper::afterToSecond'</a>
</p>

<p><img alt="" src="images/greenCircle.png">
2.6. The inverse mapping method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L49">
'kp.mappers.FirstMapper::fromSecond'</a><br>
The finishing method: 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/mappers/FirstMapper.java#L69">
'kp.mappers.FirstMapper::afterFromSecond'</a>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="THREE">❸ Commons Collections</h2>

<p><img alt="" src="images/greenCircle.png">
3.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/commons/ApacheCommonsCollections.java#L41">
'kp.collections.commons.ApacheCommonsCollections::researchBidirectionalMap'</a>.
</p>
<p><img alt="" src="images/CommonsCollectionsBidirectionalMap.png" height="100" width="275"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ApacheCommonsCollections::researchBidirectionalMap' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
3.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/commons/ApacheCommonsCollections.java#L60">
'kp.collections.commons.ApacheCommonsCollections::researchPatriciaTrie'</a>.
</p>
<p>
<b>PATRICIA</b>: Practical Algorithm to Retrieve Information Coded in Alphanumeric.<br>
A <i>trie</i> is also called a <i>digital tree</i>, <i>radix tree</i>, or <i>prefix tree</i>.
</p>
<p><img alt="" src="images/CommonsCollectionsPatriciaTrie.png" height="190" width="1090"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ApacheCommonsCollections::researchPatriciaTrie' method.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="FOUR">❹ Concurrent Radix &amp; Suffix Trees</h2>

<p><img alt="" src="images/greenCircle.png">
4.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L60">
'kp.trees.ConcurrentTrees::researchRadixTree'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesRadixTree.png" height="855" width="690"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchRadixTree' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
4.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L92">
'kp.trees.ConcurrentTrees::researchSuffixTree'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesSuffixTree.png" height="60" width="635"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchSuffixTree' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
4.3. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L112">
'kp.trees.ConcurrentTrees::researchInvertedRadixTree'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesInvertedRadixTree.png" height="80" width="610"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchInvertedRadixTree' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
4.4. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L140">
'kp.trees.ConcurrentTrees::researchReversedRadixTree'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesReversedRadixTree.png" height="30" width="460"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchReversedRadixTree' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
4.5. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L155">
'kp.trees.ConcurrentTrees::researchPrefixesAndSuffixesGenerator'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesPrefixesAndSuffixesGenerator.png" height="45" width="350"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchPrefixesAndSuffixesGenerator' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
4.6. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/trees/ConcurrentTrees.java#L169">
'kp.trees.ConcurrentTrees::researchSolver'</a>.
</p>
<p><img alt="" src="images/ConcurrentTreesSolver.png" height="45" width="365"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'ConcurrentTrees::researchSolver' method.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
<h2 id="FIVE">❺ Eclipse Collections</h2>

<p><img alt="" src="images/greenCircle.png">
5.1. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L131">
'kp.collections.eclipse.EclipseCollections::researchChunksAndPairs'</a><br>
</p>
<p>
The chunk - a collection of a specified fixed size.
</p>
<p><img alt="" src="images/EclipseCollectionsChunksAndPairs.png" height="170" width="580"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchChunksAndPairs' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
5.2. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L174">
'kp.collections.eclipse.EclipseCollections::researchMapFlipping'</a><br>
</p>
<p><img alt="" src="images/EclipseCollectionsMapFlipping.png" height="100" width="615"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchMapFlipping' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
5.3. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L214">
'kp.collections.eclipse.EclipseCollections::researchSetOperations'</a><br>
</p>
<p><img alt="" src="images/EclipseCollectionsSetOperations.png" height="65" width="615"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchSetOperations' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
5.4. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L242">
'kp.collections.eclipse.EclipseCollections::researchUsingDates'</a><br>
</p>
<p><img alt="" src="images/EclipseCollectionsUsingDates.png" height="280" width="1015"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchUsingDates' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
5.5. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L326">
'kp.collections.eclipse.EclipseCollections::researchUsingNumbers'</a><br>
</p>
<p><img alt="" src="images/EclipseCollectionsUsingNumbers.png" height="190" width="705"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchUsingNumbers' method.</i>
</p>

<p><img alt="" src="images/greenCircle.png">
5.6. The method 
<a href="https://github.com/k1729p/Study17/blob/main/src/main/java/kp/collections/eclipse/EclipseCollections.java#L383">
'kp.collections.eclipse.EclipseCollections::researchStacks'</a><br>
</p>
<p><img alt="" src="images/EclipseCollectionsStacks.png" height="60" width="365"/><br>
<img alt="" src="images/blackArrowUp.png">
<i>Console log from 'EclipseCollections::researchStacks' method.</i>
</p>

<a href="#top">Back to the top of the page</a>
<hr>
</body>
</html>