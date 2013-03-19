#stringmetric [![Build Status](https://travis-ci.org/rockymadden/stringmetric.png?branch=master)](http://travis-ci.org/rockymadden/stringmetric)
String metrics and phonetic algorithms for Scala. The library provides facilities to perform approximate string matching, measurement of string similarity/distance, indexing by word pronunciation, and sounds-like comparisons. In addition to the core library, each metric and algorithm has a command line interface. Heavy emphasis is placed on unit testing and performance (verified via microbenchmark suites).

## Metrics and Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Double Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Queued phonetic metric and algorithm)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaccard](http://en.wikipedia.org/wiki/Jaccard_index)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[Monge-Elkan](http://www.cs.cmu.edu/~pradeepr/papers/ijcai03.pdf)__ (Queued similarity metric)
* __[Match Rating Approach](http://en.wikipedia.org/wiki/Match_rating_approach)__ (Queued phonetic metric and algorithm)
* __[Needleman-Wunch](http://en.wikipedia.org/wiki/Needleman%E2%80%93Wunsch_algorithm)__ (Queued similarity metric)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Overlap](http://en.wikipedia.org/wiki/Overlap_coefficient)__ (Similarity metric)
* __[Ratcliff-Obershelp](http://xlinux.nist.gov/dads/HTML/ratcliffObershelp.html)__ (Similarity metric)
* __[Refined NYSIIS](http://www.markcrocker.com/rexxtipsntricks/rxtt28.2.0482.html)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Tanimoto](http://en.wikipedia.org/wiki/Tanimoto_coefficient)__ (Queued similarity metric)
* __[Tversky](http://en.wikipedia.org/wiki/Tversky_index)__ (Queued similarity metric)
* __[Smith-Waterman](http://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm)__ (Queued similarity metric)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)


## Installation
Available on the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.rockymadden.stringmetric%22). Depending on the core sub-project shown below (add others, like the CLI, as needed):


__SBT:__
```scala
libraryDependencies += "com.rockymadden.stringmetric" % "stringmetric-core" % "0.24.0"
```

---

__Gradle:__
```groovy
compile 'com.rockymadden.stringmetric:stringmetric-core:0.24.0'
```

---

__Maven:__
```xml
<dependency>
	<artifactId>com.rockymadden.stringmetric</artifactId>
	<groupId>stringmetric-core</groupId>
	<version>0.24.0</version>
</dependency>
```

## Scaladoc
[Scaladoc](http://rockymadden.com/stringmetric/scaladoc/) is available on the project website.

## Similarity package
Useful for approximate string matching and measurement of string distance. Most metrics calculate the similarity of two strings as a double with a value between 0 and 1. A value of 0 being completely different and a value of 1 being completely similar.


__Dice / Sorensen Metric:__ _(Note you must specify the size of the n-gram you wish to use. This can be done implicitly.)_
```scala
println(DiceSorensenMetric.compare("night", "nacht")(1))
println(DiceSorensenMetric.compare("context", "contact")(1))
```

Output:
```
0.6
0.7142857142857143
```

---

__Hamming Metric:__
```scala
println(HammingMetric.compare("toned", "roses"))
println(HammingMetric.compare("1011101", "1001001"))
```

Output: _(Note the exception of integers, rather than doubles, being returned.)_
```
3
2
```

---

__Jaccard Metric:__ _(Note you must specify the size of the n-gram you wish to use. This can be done implicitly.)_
```scala
println(JaccardMetric.compare("night", "nacht")(1))
println(JaccardMetric.compare("context", "contact")(1))
```

Output:
```
0.3
0.35714285714285715
```

---

__Jaro Metric:__
```scala
println(JaroMetric.compare("dwayne", "duane"))
println(JaroMetric.compare("jones", "johnson"))
println(JaroMetric.compare("fvie", "ten"))
```

Output:
```
0.8222222222222223
0.7904761904761904
0
```

---

__Jaro-Winkler Metric:__
```scala
println(JaroWinklerMetric.compare("dwayne", "duane"))
println(JaroWinklerMetric.compare("jones", "johnson"))
println(JaroWinklerMetric.compare("fvie", "ten"))
```

Output:
```
0.8400000000000001
0.8323809523809523
0
```

---

__Levenshtein Metric:__
```scala
println(LevenshteinMetric.compare("sitting", "kitten"))
println(LevenshteinMetric.compare("cake", "drake"))
```

Output: _(Note the exception of integers, rather than doubles, being returned.)_
```
3
2
```

---


__N-Gram Metric:__ _(Note you must specify the size of the n-gram you wish to use. This can be done implicitly.)_
```scala
println(NGramMetric.compare("night", "nacht")(1))
println(NGramMetric.compare("night", "nacht")(2))
println(NGramMetric.compare("context", "contact")(2))
```

Output:
```
0.6
0.25
0.5
```

---

__Overlap Metric:__ _(Note you must specify the size of the n-gram you wish to use. This can be done implicitly.)_
```scala
println(OverlapMetric.compare("night", "nacht")(1))
println(OverlapMetric.compare("context", "contact")(1))
```

Output:
```
0.6
0.7142857142857143
```

---

__Ratcliff/Obershelp Metric:__
```scala
println(RatcliffObershelpMetric.compare("aleksander", "alexandre"))
println(RatcliffObershelpMetric.compare("pennsylvania", "pencilvaneya"))
```

Output:
```
0.7368421052631579
0.6666666666666666
```

---

__Weighted Levenshtein Metric:__ _(Note you must specify the weight of each operation. Delete, insert, and then substitute. This can be done implicitly.)_
```scala
println(WeightedLevenshteinMetric.compare("book", "back")(10, 0.1, 1))
println(WeightedLevenshteinMetric.compare("hosp", "hospital")(10, 0.1, 1))
println(WeightedLevenshteinMetric.compare("hospital", "hosp")(10, 0.1, 1))
```

Output: _(Note that while a double is returned, it can be outside the range of 0 to 1, based upon the weights used.)_
```
2
0.4
40
```

## Phonetic package
Useful for indexing by word pronunciation and performing sounds-like comparisons. All metrics return a boolean value indicating if the two strings sound the same, per the algorithm used. All metrics have an algorithm counterpart which provide the means to perform indexing by word pronunciation.

__Metaphone Metric:__
```scala
println(MetaphoneMetric.compare("merci", "mercy"))
println(MetaphoneMetric.compare("dumb", "gum"))
```

Output:
```
true
false
```

---

__Metaphone Algorithm:__
```scala
println(MetaphoneAlgorithm.compute("dumb"))
println(MetaphoneAlgorithm.compute("knuth"))
```

Output:
```
tm
n0
```

---

__NYSIIS Metric:__
```scala
println(NysiisMetric.compare("ham", "hum"))
println(NysiisMetric.compare("dumb", "gum"))
```

Output:
```
true
false
```

---

__NYSIIS Algorithm:__
```scala
println(NysiisAlgorithm.compute("macintosh"))
println(NysiisAlgorithm.compute("knuth"))
```

Output:
```
mcant
nnat
```

---

__Refined NYSIIS Metric:__
```scala
println(RefinedNysiisMetric.compare("ham", "hum"))
println(RefinedNysiisMetric.compare("dumb", "gum"))
```

Output:
```
true
false
```

---

__Refined NYSIIS Algorithm:__
```scala
println(RefinedNysiisAlgorithm.compute("macintosh"))
println(RefinedNysiisAlgorithm.compute("westerlund"))
```

Output:
```
mcantas
wastarlad
```

---

__Refined Soundex Metric:__
```scala
println(RefinedSoundexMetric.compare("robert", "rupert"))
println(RefinedSoundexMetric.compare("robert", "rubin"))
```

Output:
```
true
false
```

---

__Refined Soundex Algorithm:__
```scala
println(RefinedSoundexAlgorithm.compute("hairs"))
println(RefinedSoundexAlgorithm.compute("lambert"))
```

Output:
```
h093
l7081096
```

---

__Soundex Metric:__
```scala
println(SoundexMetric.compare("robert", "rupert"))
println(SoundexMetric.compare("robert", "rubin"))
```

Output:
```
true
false
```

---

__Soundex Algorithm:__
```scala
println(SoundexAlgorithm.compute("rupert"))
println(SoundexAlgorithm.compute("lukasiewicz"))
```

Output:
```
r163
l222
```

## Decorating
It is possible to decorate algorithms and metrics with additional functionality. The most common decorations are filters, which are useful for filtering strings prior to evaluation (e.g. ignore case, ignore non-alpha, ignore spaces). __NOTE:__ Memoization decorator queued.

Basic examples with no filtering:
```scala
JaroWinklerMetric.compare("string1", "string2")
JaroWinklerMetric().compare("string1", "string2")
(new JaroWinklerMetric).compare("string1", "string2")
```

---

Basic example with single filter:
```scala
(new JaroWinklerMetric with IgnoreAsciiLetterCaseFilter).compare("string1", "string2")
```

---

Basic example with stacked filters. Filters are applied in reverse order:
```scala
(new JaroWinklerMetric with IgnoreAsciiLetterCaseFilter with AsciiLetterOnlyFilter).compare("string1", "string2")
```

## Convenience objects
Convenience objects are available to make interactions with the library easier.

__StringAlgorithm:__
```scala
// Easy access to compute methods.
StringAlgorithm.computeWithMetaphone("string")

// Easy access to types and companion objects.
val metaphone: StringAlgorithm.Metaphone = StringAlgorithm.Metaphone()
```

---

__StringMetric:__
```scala
// Easy access to compare methods.
StringMetric.compareWithJaroWinkler("string1", "string2")

// Easy access to types and companion objects.
val jaro: StringMetric.Jaro = StringMetric.Jaro()
```

---

__StringFilter:__
```scala
// Easy access to types and instances.
val metaphone: StringAlgorithm.Metaphone = StringAlgorithm.Metaphone() with StringFilter.asciiSpace
val asciiSpace: StringFilter.AsciiSpace = StringFilter.asciiSpace
```

## Command line interfaces
Every metric and algorithm has a command line interface. Said code is housed in a separate sub-project from the core library called "stringmetric-cli".

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

---

Compare "dog" to "dawg":
```shell
$ metaphoneMetric dog dawg
true
```

```shell
$ jaroWinklerMetric dog dawg
0.75
```

---

Get the phonetic representation of "dog" using the Metaphone phonetic algorithm:
```shell
$ metaphoneAlgorithm dog
tk
```

## Requirements
* Scala 2.10.x
* Gradle 1.x

## Versioning
[Semantic Versioning v2.0](http://semver.org/)

## License
[Apache License v2.0](http://www.apache.org/licenses/LICENSE-2.0)

## Bugs and Issues
Please submit bugs and issues via [GitHub issues](https://github.com/rockymadden/stringmetric/issues).

## Questions, Comments, and Requests
Please contact me directly. Find all my contact information on my [personal website](http://rockymadden.com/).
