#stringmetric [![Build Status](https://travis-ci.org/rockymadden/stringmetric.png?branch=master)](http://travis-ci.org/rockymadden/stringmetric)
String metrics and phonetic algorithms for Scala. The library provides facilities to perform approximate string matching, measurement of string similarity/distance, indexing by word pronunciation, and sounds-like comparisons. In addition to the core library, each metric and algorithm has a command line interface.

* __Requirements:__ Scala 2.10.x and, if building yourself, Gradle 1.8+
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
The project is available on the [Maven Central Repository](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.rockymadden.stringmetric%22). Adding a dependency to the core sub-project in various build systems (add other sub-projects as needed):


__Simple Build Tool:__
```scala
libraryDependencies += "com.rockymadden.stringmetric" % "stringmetric-core" % "0.26.1"
```

---

__Gradle:__
```groovy
compile 'com.rockymadden.stringmetric:stringmetric-core:0.26.1'
```

---

__Maven:__
```xml
<dependency>
	<groupId>com.rockymadden.stringmetric</groupId>
	<artifactId>stringmetric-core</artifactId>
	<version>0.26.1</version>
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

## Decorating
It is possible to decorate algorithms and metrics with additional functionality. This is provided by rich wrapping via implicits, and [StringAlgorithmDecorator](https://github.com/rockymadden/stringmetric/blob/master/core/source/main/scala/com/rockymadden/stringmetric/Algorithm.scala)/[StringMetricDecorator](https://github.com/rockymadden/stringmetric/blob/master/core/source/main/scala/com/rockymadden/stringmetric/Metric.scala). A handful of pre-built transforms are located in the [transform module](https://github.com/rockymadden/stringmetric/blob/master/core/source/main/scala/com/rockymadden/stringmetric/Transform.scala).

---

Non-decorated usage:
```scala
MetaphoneAlgorithm.compute("abc123")
MetaphoneMetric.compare("abc123", "abc456")
```

---

Single filter, so that we only examine alphabetical characters:
```scala
(MetaphoneAlgorithm withTransform StringTransform.filterAlpha).compute("abc123")
(MetaphoneMetric withTransform StringTransform.filterAlpha).compare("abc123", "abc456")
```

---

Functionally composed filter, so that we only examine alphabetical characters but the case won't matter:
```scala
val composedTransform = (StringTransform.filterAlpha andThen StringTransform.ignoreAlphaCase)

(MetaphoneAlgorithm withTransform composedTransform).compute("abc123")
(MetaphoneMetric withTransform composedTransform).compare("abc123", "abc456")
```

---

Make your own:
```scala
// StringTransform is a type alias for (Array[Char] => Array[Char])
val myTransform: StringTransform = (ca) => ca.filter(_ == 'x')

(MetaphoneAlgorithm withTransform myTransform).compute("abc123")
(MetaphoneMetric withTransform myTransform).compare("abc123", "abc456")
```

---

## Convenience objects
Convenience objects are available to make interactions with the library easier.

__StringAlgorithm:__
```scala
StringAlgorithm.computeWithMetaphone("string")
```
<sup>Located in the [algorithm module](https://github.com/rockymadden/stringmetric/blob/master/core/source/main/scala/com/rockymadden/stringmetric/Algorithm.scala).</sup>

---

__StringMetric:__
```scala
StringMetric.compareWithJaccard(1)("abc123", "abc456")
StringMetric.compareWithJaroWinkler("abc123", "abc456")
```
<sup>Located in the [metric module](https://github.com/rockymadden/stringmetric/blob/master/core/source/main/scala/com/rockymadden/stringmetric/Metric.scala).</sup>

---

## Building the CLIs
```shell
$ git clone https://github.com/rockymadden/stringmetric.git
$ cd stringmetric
$ gradle :stringmetric-cli:tar
```

Running the ```tar``` task will create a compressed archive and an unarchived copy of the built algorithms and metrics. The files can be found under the ```build``` directory that Gradle creates. The archive is named ```stringmetric-cli.tar.gz``` and the unarchived files can be found in the directory named ```stringmetric-cli```. You may need to chmod the files because of the inability for Gradle to do so reliably

---

To run a command from the current directory that you would be in from doing the above:

```shell
$ ./cli/build/stringmetric-cli/jarometric abc xyz
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

Get comparison with metrics:
```shell
$ jarowinklermetric dog dawg
0.75
```

---

Get representation with phonetic algorithms:
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
