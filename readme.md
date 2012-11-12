#stringmetric [![Build Status](https://secure.travis-ci.org/rockymadden/stringmetric.png)](http://travis-ci.org/rockymadden/stringmetric)
A small library of string metrics and phonetic algorithms implemented in Scala. Said metrics and algorithms are broken out into packages:

* The __similarity package__ houses metrics and supporting algorithms which determine distance and coefficients (e.g. Dice's coefficient and Levenshtein distance).
* The __phonetic package__ houses metrics and supporting algorithms which determine if two strings sound the same phonetically (e.g. Metaphone and Soundex). All phonetic string metrics have a standalone algorithm counterpart. They provide a means to determine the phonetic representation of the argument passed.

Each string metric and supporting algorithm has a CLI. 

## Metrics and Phonetic Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__
	* API: `org.hashtree.stringmetric.similarity.DiceSorensenMetric`
	* CLI: `diceSorensenMetric`
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__
	* API: `org.hashtree.stringmetric.similarity.HammingMetric`
	* CLI: `hammingMetric`
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__
	* API: `org.hashtree.stringmetric.similarity.JaroMetric`
	* CLI: `jaroMetric`
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__
	* API: `org.hashtree.stringmetric.similarity.JaroWinklerMetric`
	* CLI: `jaroWinklerMetric`
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__
	* API:` org.hashtree.stringmetric.similarity.LevenshteinMetric`
	* CLI: `levenshteinMetric`
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__
	* API: `org.hashtree.stringmetric.phonetic.MetaphoneMetric` and `org.hashtree.stringmetric.phonetic.MetaphoneAlgorithm`
	* CLI: `metaphoneMetric` and `metaphoneAlgorithm`
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__
	* API: `org.hashtree.stringmetric.similarity.NGramMetric` and `org.hashtree.stringmetric.similarity.NGramAlgorithm`
	* CLI: `nGramMetric` and `nGramAlgorithm`
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__
	* API: `org.hashtree.stringmetric.phonetic.NysiisMetric` and `org.hashtree.stringmetric.phonetic.NysiisAlgorithm`
	* CLI: `nysiisMetric` and `nysiisAlgorithm`
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__
	* API: `org.hashtree.stringmetric.phonetic.RefinedSoundexMetric` and `org.hashtree.stringmetric.phonetic.RefinedSoundexAlgorithm`
	* CLI: `refinedSoundexMetric` and `refinedSoundexAlgorithm`
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__
	* API: `org.hashtree.stringmetric.phonetic.SoundexMetric` and `org.hashtree.stringmetric.phonetic.SoundexAlgorithm`
	* CLI: `soundexMetric` and `soundexAlgorithm`
* __Weighted Levenshtein__
	* API: `org.hashtree.stringmetric.similarity.WeightedLevenshteinMetric`
	* CLI: `weightedLevenshteinMetric`

## Filters
Filters, which can optionally be applied, clean up arguments prior to evaluation. Filtering rules can be composed via trait stacking.

* __Ensure only ASCII control characters matter__
	* API: `org.hashtree.stringmetric.filter.AsciiControlOnlyStringFilter`
* __Ensure ASCII controls do not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiControlStringFilter`
* __Ensure ASCII letter case-sensitivity does not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiLetterCaseStringFilter`
* __Ensure only ASCII letters and numbers matter__
	* API: `org.hashtree.stringmetric.filter.AsciiLetterNumberOnlyStringFilter`
* __Ensure ASCII letters and numbers do not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiLetterNumberStringFilter`
* __Ensure only ASCII letters matter__
	* API: `org.hashtree.stringmetric.filter.AsciiLetterOnlyStringFilter`
* __Ensure ASCII letters do not matter__
	* AlI: `org.hashtree.stringmetric.filter.AsciiLetterStringFilter`
* __Ensure only ASCII numbers matter__
	* API: `org.hashtree.stringmetric.filter.AsciiNumberOnlyStringFilter`
* __Ensure ASCII numbers do not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiNumberStringFilter`
* __Ensure ASCII spaces do not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiSpaceStringFilter`
* __Ensure only ASCII symbols matter__
	* API: `org.hashtree.stringmetric.filter.AsciiSymbolOnlyStringFilter`
* __Ensure ASCII symbols do not matter__
	* API: `org.hashtree.stringmetric.filter.AsciiSymbolStringFilter`

## Building the API
```shell
gradle :stringmetric-core:jar
```

## Building the CLI
```shell
gradle :stringmetric-cli:tar
```

## Using the API
The easiest non-filtered example involves using the StringMetric convenience object.
```scala
import org.hashtree.stringmetric.StringMetric
  
if (StringMetric.compareJaroWinkler("string1", "string2") >= 0.9) 
    println("It's likely you're a match!")
```

The easiest single filtered example involves using the StringMetric and StringFilter convenience objects.
```scala
import org.hashtree.stringmetric.{ StringFilter, StringMetric }
  
if (StringMetric.compareJaroWinkler("string1", "string2")(StringFilter.asciiLetterCase) >= 0.9) 
    println("It's likely you're a match!")
```

Basic example with no filtering.
```scala
import org.hashtree.stringmetric.similarity.JaroWinklerMetric  
  
val distance = JaroWinklerMetric.compare("string1", "string2")

if (distance >= 0.9) println("It's likely you're a match!")
```

Basic example with single filter.
```scala
import org.hashtree.stringmetric.similarity.{ JaroWinklerMetric, StringFilterDelegate }
import org.hashtree.stringmetric.filter.AsciiLetterCaseStringFilter

val distance = JaroWinklerMetric.compare("string1", "string2")
    (new StringFilterDelegate with AsciiLetterCaseStringFilter)

if (distance >= 0.9) println("It's likely you're a match!")
```

Basic example with stacked filter. Filters are applied in reverse order.
```scala
import org.hashtree.stringmetric.similarity.{ JaroWinklerMetric, StringFilterDelegate }
import org.hashtree.stringmetric.filter.{ AsciiLetterCaseStringFilter, AsciiLetterOnlyStringFilter }

val distance = JaroWinklerMetric.compare("string1", "string2")
    (new StringFilterDelegate with AsciiLetterCaseStringFilter with AsciiLetterOnlyStringFilter)

if (distance >= 0.9) println("It's likely you're a match!")
```

## Using the CLI
Uncompress the built tar and ensure you have ability to execute the commands. Execute the metric of choice via the command line:

The help option prints command syntax and usage.
```shell
jaroWinklerMetric --help
metaphoneMetric --help
metaphoneAlgorithm --help
```

Compare "abc" to "xyz" using the Jaro-Winkler metric.
```shell
jaroWinklerMetric abc xyz
```

Compare "abc "to "xyz" using the Metaphone metric.
```shell
metaphoneMetric abc xyz
```

Get the phonetic representation of "abc" using the Metaphone phonetic algorithm.
```shell 
metaphoneAlgorithm abc
```

## Requirements
* Scala 2.9.2
* Gradle 1.0 or above

## Todo
* SmithWaterman
* MongeElkan
* NeedlemanWunch
* Jaccard
* Refined NYSIIS
* Double Metaphone

## Versioning
[Semantic Versioning 2.0.0](http://semver.org/)

## License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)