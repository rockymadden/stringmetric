#stringmetric [![Build Status](https://secure.travis-ci.org/rockymadden/stringmetric.png)](http://travis-ci.org/rockymadden/stringmetric)
A small library of string metrics and phonetic algorithms implemented in Scala. Each metric and algorithm has a CLI. 

* __Phonetic metrics__ determine if two arguments sound the same phonetically. 
* __Phonetic algorithms__ provide a means to determine the phonetic representation of the argument passed. All phonetic metrics have a standalone algorithm counterpart. 
* __Similarity metrics__ determine the distance or coefficient between two arguments.
* __Similarity algorithms__ provide a means to access underlying similarity metric functionality, when applicable. An example is the N-Gram algorithm, which provides a means to get n-grams for a given argument with a specific n.
* __Filters__, which can optionally be applied to metrics and algorithms, clean up arguments prior to evaluation. Filtering rules can easily be combined via trait stacking.

## Metrics and Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric and algorithm)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)

## Filters
* __Ensure only ASCII control characters matter__
* __Ensure ASCII controls do not matter__
* __Ensure ASCII letter case-sensitivity does not matter__
* __Ensure only ASCII letters and numbers matter__
* __Ensure ASCII letters and numbers do not matter__
* __Ensure only ASCII letters matter__
* __Ensure ASCII letters do not matter__
* __Ensure only ASCII numbers matter__
* __Ensure ASCII numbers do not matter__
* __Ensure ASCII spaces do not matter__
* __Ensure only ASCII symbols matter__
* __Ensure ASCII symbols do not matter__

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
  
if (StringMetric.compareWithJaroWinkler("string1", "string2") >= 0.9) 
    println("It's likely you're a match!")
```

The easiest single filtered example involves using the StringMetric and StringFilter convenience objects.
```scala
import org.hashtree.stringmetric.{ StringFilter, StringMetric }
  
if (StringMetric.compareWithJaroWinkler("string1", "string2")(StringFilter.asciiLetterCase) >= 0.9) 
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
* Micro benchmarks
* Performance enhancements to existing metrics/algorithms
* Memoization decorator

## Versioning
[Semantic Versioning 2.0.0](http://semver.org/)

## License
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)