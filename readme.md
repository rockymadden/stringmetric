#stringmetric [![Build Status](https://secure.travis-ci.org/rockymadden/stringmetric.png)](http://travis-ci.org/rockymadden/stringmetric)
A small library of string metrics and phonetic algorithms. Each has a command line interface, is thoroughly unit tested, and performant (verified via microbenchmark suites). 

* __Similarity metrics__ determine the distance or coefficient between two arguments.
* __Phonetic metrics__ determine if two arguments sound the same phonetically. 
* __Phonetic algorithms__ determine the phonetic representation of the argument passed. All phonetic metrics have a standalone algorithm counterpart. 
* __Filters__ clean up arguments prior to evaluation. Filters can be combined via trait stacking.

## Metrics and Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric and algorithm)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Refined NYSIIS](http://www.markcrocker.com/rexxtipsntricks/rxtt28.2.0482.html)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)

## Using the API
Basic example with no filtering:
```scala
val distance = JaroWinklerMetric.compare("string1", "string2")

if (distance >= 0.9) println("It's likely you're a match!")
```

Basic example with single filter:
```scala
val distance = JaroWinklerMetric.compare("string1", "string2")
    (new StringFilterDelegate with AsciiLetterCaseStringFilter)

if (distance >= 0.9) println("It's likely you're a match!")
```

Basic example with stacked filter. Filters are applied in reverse order:
```scala
val distance = JaroWinklerMetric.compare("string1", "string2")
    (new StringFilterDelegate with AsciiLetterCaseStringFilter with AsciiLetterOnlyStringFilter)

if (distance >= 0.9) println("It's likely you're a match!")
```

You can also use the StringMetric, StringAlgorithm, and StringFilter convenience objects:
```scala
if (StringMetric.compareWithJaroWinkler("string1", "string2") >= 0.9) 
    println("It's likely you're a match!")
 
if (StringMetric.compareWithJaroWinkler("string1", "string2")(StringFilter.asciiLetterCase) >= 0.9) 
    println("It's likely you're a match!")
```

## Using the CLI
The help option prints command syntax and usage:
```shell
$ jaroWinklerMetric --help
$ metaphoneMetric --help
$ metaphoneAlgorithm --help
```

Compare "abc" to "xyz" using the Jaro-Winkler metric:
```shell
$ jaroWinklerMetric abc xyz
```

Compare "abc "to "xyz" using the Metaphone metric:
```shell
$ metaphoneMetric abc xyz
```

Get the phonetic representation of "abc" using the Metaphone phonetic algorithm:
```shell 
$ metaphoneAlgorithm abc
```

## Depending on the API
Available on the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.rockymadden.stringmetric%22):

* __groupId__: com.rockymadden.stringmetric
* __artifactId__: stringmetric-core

## Depending on the CLI
Available on the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.rockymadden.stringmetric%22):

* __groupId__: com.rockymadden.stringmetric
* __artifactId__: stringmetric-cli

## Building the API
```shell
$ gradle :stringmetric-core:jar
```

## Building the CLI
```shell
$ gradle :stringmetric-cli:tar
```

## Requirements
* Scala 2.9.x
* Gradle 1.x

## Todo
* SmithWaterman
* MongeElkan
* NeedlemanWunch
* Jaccard
* Double Metaphone
* Memoization decorator

## Versioning
[Semantic Versioning v2.0](http://semver.org/)

## License
[Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Questions and Comments
Reach me at <stringmetric@rockymadden.com>.