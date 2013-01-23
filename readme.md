#stringmetric [![Build Status](https://travis-ci.org/rockymadden/stringmetric.png?branch=master)](http://travis-ci.org/rockymadden/stringmetric)
A Scala library of string metrics and phonetic algorithms. It provides implementations to perform approximate string matching (sometimes called fuzzy string matching), measurement of strings similarity/distance, indexing by word pronunciation, and more. Common applications of said metrics and algorithms include spell checkers, search algorithms, plagiarism detection, fraud detection, data deduplication, and record linkage. In addition to the core library, each metric and algorithm has a command line interface. Both subprojects are heavily unit tested and performant (verified via microbenchmark suites).

## Metrics and Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric and algorithm)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Ratcliff / Obershelp](http://xlinux.nist.gov/dads/HTML/ratcliffObershelp.html)__ (Similarity metric)
* __[Refined NYSIIS](http://www.markcrocker.com/rexxtipsntricks/rxtt28.2.0482.html)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)

## Using the Core
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
$ metaphoneMetric --help
Compares two strings to determine if they are phonetically similarly, per the Metaphone algorithm.

Syntax:
  metaphoneMetric [Options] string1 string2...

Options:
  -h, --help
    Outputs description, syntax, and options.
```

```shell
$ jaroWinklerMetric --help
Compares two strings to calculate the Jaro-Winkler distance.

Syntax:
  jaroWinklerMetric [Options] string1 string2...

Options:
  -h, --help
    Outputs description, syntax, and options.
```

Compare "dog" to "dawg":
```shell
$ metaphoneMetric dog dawg
true
```

```shell
$ jaroWinklerMetric dog dawg
0.75
```

Get the phonetic representation of "dog" using the Metaphone phonetic algorithm:
```shell
$ metaphoneAlgorithm dog
tk
```

## Testing
```shell
$ gradle :stringmetric-core:test
```

```shell
$ gradle :stringmetric-cli:test
```

## Building
```shell
$ gradle :stringmetric-core:jar
```

```shell
$ gradle :stringmetric-cli:tar
```

## Depending Upon
Available on the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.rockymadden.stringmetric%22):

* __groupId__: com.rockymadden.stringmetric
* __artifactId__: stringmetric-core
* __artifactId__: stringmetric-cli

## Requirements
* Scala 2.10.x
* Gradle 1.x

## Versioning
[Semantic Versioning v2.0](http://semver.org/)

## License
[Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Todo
* SmithWaterman
* MongeElkan
* NeedlemanWunch
* Jaccard
* Double Metaphone
* Memoization decorator

## Questions and Comments
Reach me at <stringmetric@rockymadden.com>.
