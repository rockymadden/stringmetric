#stringmetric [![Build Status](https://travis-ci.org/rockymadden/stringmetric.png?branch=master)](http://travis-ci.org/rockymadden/stringmetric)
String metrics and phonetic algorithms for Scala. The library provides facilities to perform approximate string matching, measurement of string similarity/distance, indexing by word pronunciation, and sounds-like comparisons. In addition to the core library, each metric and algorithm has a command line interface.

* __Requirements:__ Scala 2.10+
* __Documentation:__ [Scaladoc](http://rockymadden.com/stringmetric/scaladoc/)
* __Issues:__ [Enhancements](https://github.com/rockymadden/stringmetric/issues?labels=accepted%2Cenhancement&page=1&state=open), [Questions](https://github.com/rockymadden/stringmetric/issues?labels=accepted%2Cquestion&page=1&state=open), [Bugs](https://github.com/rockymadden/stringmetric/issues?labels=accepted%2Cbug&page=1&state=open)
* __Versioning:__ [Semantic Versioning v2.0](http://semver.org/)

## Metrics and algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__ (Similarity metric)
* __[Double Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/6) phonetic metric and algorithm)
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__ (Similarity metric)
* __[Jaccard](http://en.wikipedia.org/wiki/Jaccard_index)__ (Similarity metric)
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__ (Similarity metric)
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__ (Similarity metric)
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__ (Phonetic metric and algorithm)
* __[Monge-Elkan](http://www.cs.cmu.edu/~pradeepr/papers/ijcai03.pdf)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/7) similarity metric)
* __[Match Rating Approach](http://en.wikipedia.org/wiki/Match_rating_approach)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/8) phonetic metric and algorithm)
* __[Needleman-Wunch](http://en.wikipedia.org/wiki/Needleman%E2%80%93Wunsch_algorithm)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/9) similarity metric)
* __[N-Gram](http://en.wikipedia.org/wiki/N-gram)__ (Similarity metric)
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__ (Phonetic metric and algorithm)
* __[Overlap](http://en.wikipedia.org/wiki/Overlap_coefficient)__ (Similarity metric)
* __[Ratcliff-Obershelp](http://xlinux.nist.gov/dads/HTML/ratcliffObershelp.html)__ (Similarity metric)
* __[Refined NYSIIS](http://www.markcrocker.com/rexxtipsntricks/rxtt28.2.0482.html)__ (Phonetic metric and algorithm)
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__ (Phonetic metric and algorithm)
* __[Tanimoto](http://en.wikipedia.org/wiki/Tanimoto_coefficient)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/10) similarity metric)
* __[Tversky](http://en.wikipedia.org/wiki/Tversky_index)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/16) similarity metric)
* __[Smith-Waterman](http://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm)__ ([Queued](https://github.com/rockymadden/stringmetric/issues/11) similarity metric)
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__ (Phonetic metric and algorithm)
* __Weighted Levenshtein__ (Similarity metric)


## Depending upon

__SBT:__
```scala
libraryDependencies += "com.rockymadden.stringmetric" %% "stringmetric-core" % "0.27.1"
```

---

__Gradle:__
```groovy
compile 'com.rockymadden.stringmetric:stringmetric-core_2.10:0.27.1'
```

---

__Maven:__
```xml
<dependency>
	<groupId>com.rockymadden.stringmetric</groupId>
	<artifactId>stringmetric-core_2.10</artifactId>
	<version>0.27.1</version>
</dependency>
```

---

## Similarity package
Useful for approximate string matching and measurement of string distance. Most metrics calculate the similarity of two strings as a double with a value between 0 and 1. A value of 0 being completely different and a value of 1 being completely similar.

---

__Dice / Sorensen Metric:__
```scala
DiceSorensenMetric(1).compare("night", "nacht") // 0.6
DiceSorensenMetric(1).compare("context", "contact") // 0.7142857142857143
```
<sup>Note you must specify the size of the n-gram you wish to use.</sup>

---

__Hamming Metric:__
```scala
HammingMetric.compare("toned", "roses") // 3
HammingMetric.compare("1011101", "1001001") // 2
```
<sup>Note the exception of integers, rather than doubles, being returned.</sup>

---


__Jaccard Metric:__
```scala
JaccardMetric(1).compare("night", "nacht") // 0.3
JaccardMetric(1).compare("context", "contact") // 0.35714285714285715
```
<sup>Note you must specify the size of the n-gram you wish to use.</sup>


---

__Jaro Metric:__
```scala
JaroMetric.compare("dwayne", "duane") // 0.8222222222222223
JaroMetric.compare("jones", "johnson") // 0.7904761904761904
JaroMetric.compare("fvie", "ten") // 0.0
```

---

__Jaro-Winkler Metric:__
```scala
JaroWinklerMetric.compare("dwayne", "duane") // 0.8400000000000001
JaroWinklerMetric.compare("jones", "johnson") // 0.8323809523809523
JaroWinklerMetric.compare("fvie", "ten") // 0.0
```

---

__Levenshtein Metric:__
```scala
LevenshteinMetric.compare("sitting", "kitten") // 3
LevenshteinMetric.compare("cake", "drake") // 2
```
<sup>Note the exception of integers, rather than doubles, being returned.</sup>

---


__N-Gram Metric:__
```scala
NGramMetric(1).compare("night", "nacht") // 0.6
NGramMetric(2).compare("night", "nacht") // 0.25
NGramMetric(2).compare("context", "contact") // 0.5
```
<sup>Note you must specify the size of the n-gram you wish to use.</sup>

---

__Overlap Metric:__
```scala
OverlapMetric(1).compare("night", "nacht") // 0.6
OverlapMetric(1).compare("context", "contact") // 0.7142857142857143
```
<sup>Note you must specify the size of the n-gram you wish to use.</sup>

---

__Ratcliff/Obershelp Metric:__
```scala
RatcliffObershelpMetric.compare("aleksander", "alexandre") // 0.7368421052631579
RatcliffObershelpMetric.compare("pennsylvania", "pencilvaneya") // 0.6666666666666666
```

---

__Weighted Levenshtein Metric:__
```scala
WeightedLevenshteinMetric(10, 0.1, 1).compare("book", "back") // 2
WeightedLevenshteinMetric(10, 0.1, 1).compare("hosp", "hospital") // 0.4
WeightedLevenshteinMetric(10, 0.1, 1).compare("hospital", "hosp") // 40
```
<sup>Note you must specify the weight of each operation. Delete, insert, and then substitute. Note that while a double is returned, it can be outside the range of 0 to 1, based upon the weights used.</sup>

---

## Phonetic package
Useful for indexing by word pronunciation and performing sounds-like comparisons. All metrics return a boolean value indicating if the two strings sound the same, per the algorithm used. All metrics have an algorithm counterpart which provide the means to perform indexing by word pronunciation.

---

__Metaphone Metric:__
```scala
MetaphoneMetric.compare("merci", "mercy") // true
MetaphoneMetric.compare("dumb", "gum") // false
```
---

__Metaphone Algorithm:__
```scala
MetaphoneAlgorithm.compute("dumb") // tm
MetaphoneAlgorithm.compute("knuth") // n0
```

---

__NYSIIS Metric:__
```scala
NysiisMetric.compare("ham", "hum") // true
NysiisMetric.compare("dumb", "gum") // false
```

---

__NYSIIS Algorithm:__
```scala
NysiisAlgorithm.compute("macintosh") // mcant
NysiisAlgorithm.compute("knuth") // nnat
```

---

__Refined NYSIIS Metric:__
```scala
RefinedNysiisMetric.compare("ham", "hum") // true
RefinedNysiisMetric.compare("dumb", "gum") // false
```

---

__Refined NYSIIS Algorithm:__
```scala
RefinedNysiisAlgorithm.compute("macintosh") // mcantas
RefinedNysiisAlgorithm.compute("westerlund") // wastarlad
```

---

__Refined Soundex Metric:__
```scala
RefinedSoundexMetric.compare("robert", "rupert") // true
RefinedSoundexMetric.compare("robert", "rubin") // false
```

---

__Refined Soundex Algorithm:__
```scala
RefinedSoundexAlgorithm.compute("hairs") // h093
RefinedSoundexAlgorithm.compute("lambert") // l7081096
```

---

__Soundex Metric:__
```scala
SoundexMetric.compare("robert", "rupert") // true
SoundexMetric.compare("robert", "rubin") // false
```

---

__Soundex Algorithm:__
```scala
SoundexAlgorithm.compute("rupert") // r163
SoundexAlgorithm.compute("lukasiewicz") // l222
```

---

## Convenience objects

__StringAlgorithm:__
```scala
StringAlgorithm.computeWithMetaphone("abcdef")
StringAlgorithm.computeWithNysiis("abcdef")
```

---

__StringMetric:__
```scala
StringMetric.compareWithJaccard(1)("abcdef", "abcxyz")
StringMetric.compareWithJaroWinkler("abcdef", "abcxyz")
```

---

## Decorating
It is possible to decorate algorithms and metrics with additional functionality, which you can mix and match. Decorations include:

* __[withMemoization](https://en.wikipedia.org/wiki/Memoization):__ Computations and comparisons are cached. Future calls made with identical arguments will be looked up, rather than computed.

* __withTransform:__ Transform arguments prior to computation/comparison. A handful of pre-built transforms are located in the [transform module](https://github.com/rockymadden/stringmetric/blob/master/core/src/main/scala/com/rockymadden/stringmetric/Transform.scala).

---

Non-decorated:
```scala
MetaphoneAlgorithm.compute("abcdef")
MetaphoneMetric.compare("abcdef", "abcxyz")
```

---

Using a transform so that we only examine alphabetical characters:
```scala
(MetaphoneAlgorithm withTransform StringTransform.filterAlpha).compute("abcdef")
(MetaphoneMetric withTransform StringTransform.filterAlpha).compare("abcdef", "abcxyz")
```

---

Using a functionally composed transform so that we only examine alphabetical characters, but the case will not matter:
```scala
val composedTransform = (StringTransform.filterAlpha andThen StringTransform.ignoreAlphaCase)

(MetaphoneAlgorithm withTransform composedTransform).compute("abcdef")
(MetaphoneMetric withTransform composedTransform).compare("abcdef", "abcxyz")
```

---

Making your own transform:
```scala
val myTransform: StringTransform = (ca) => ca.filter(_ == 'x')

(MetaphoneAlgorithm withTransform myTransform).compute("abcdef")
(MetaphoneMetric withTransform myTransform).compare("abcdef", "abcxyz")
```

---

Using memoization:
```scala
(MetaphoneAlgorithm withMemoization).compute("abcdef")
```

---

Using memoization and a transform:
```scala
((MetaphoneAlgorithm withMemoization) withTransform StringTransform.filterAlpha).compute("abcdef")
```

---

## Building the CLIs
```shell
$ git clone https://github.com/rockymadden/stringmetric.git
$ cd stringmetric
$ sbt clean package
$ ./project/build.sh
$ ./target/cli/jarometric abc xyz
```

---

## Using the CLIs
Get help:
```shell
$ metaphonemetric --help
Compares two strings to determine if they are phonetically similarly, per the Metaphone algorithm.

Syntax:
  metaphonemetric [Options] string1 string2...

Options:
  -h, --help
    Outputs description, syntax, and options.
```

---

Get comparison value with metrics:
```shell
$ jarowinklermetric dog dawg
0.75
```

---

Get representation value with phonetic algorithms:
```shell
$ metaphonealgorithm dog
tk
```

---

## License
```
The MIT License (MIT)

Copyright (c) 2013 Rocky Madden (http://rockymadden.com/)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
```
