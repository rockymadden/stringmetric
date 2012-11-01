#stringmetric
A collection of string metrics and algorithms implemented in Scala. All phonetic string metrics have a standalone algorithm counterpart. They provide a means to determine the phonetic representation of the argument passed, rather than evaluating if two arguments sound the same phonetically. __Each metric and algorithm has a CLI.__

## Metrics and Algorithms
* __[Dice / Sorensen](http://en.wikipedia.org/wiki/Dice%27s_coefficient)__
	* API: org.hashtree.stringmetric.similarity.DiceSorensenMetric
	* CLI: diceSorensenMetric
* __[Hamming](http://en.wikipedia.org/wiki/Hamming_distance)__
	* API: org.hashtree.stringmetric.similarity.HammingMetric
	* CLI: hammingMetric
* __[Jaro](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__
	* API: org.hashtree.stringmetric.similarity.JaroMetric
	* CLI: jaroMetric
* __[Jaro-Winkler](http://en.wikipedia.org/wiki/Jaro-Winkler_distance)__
	* API: org.hashtree.stringmetric.similarity.JaroWinklerMetric
	* CLI: jaroWinklerMetric
* __[Levenshtein](http://en.wikipedia.org/wiki/Levenshtein_distance)__
	* API: org.hashtree.stringmetric.similarity.LevenshteinMetric
	* CLI: levenshteinMetric
* __[Metaphone](http://en.wikipedia.org/wiki/Metaphone)__
	* API: org.hashtree.stringmetric.phonetic.MetaphoneMetric and org.hashtree.stringmetric.phonetic.MetaphoneAlgorithm
	* CLI: metaphoneMetric and metaphoneAlgorithm
* __[NYSIIS](http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System)__
	* API: org.hashtree.stringmetric.phonetic.NysiisMetric and org.hashtree.stringmetric.phonetic.NysiisAlgorithm
	* CLI: nysiisMetric and nysiisAlgorithm
* __[Refined Soundex](http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html)__
	* API: org.hashtree.stringmetric.phonetic.RefinedSoundexMetric and org.hashtree.stringmetric.phonetic.RefinedSoundexAlgorithm
	* CLI: refinedSoundexMetric and refinedSoundexAlgorithm
* __[Soundex](http://en.wikipedia.org/wiki/Soundex)__
	* API: org.hashtree.stringmetric.phonetic.SoundexMetric and org.hashtree.stringmetric.phonetic.SoundexAlgorithm
	* CLI: soundexMetric and soundexAlgorithm

## Filters
Filters, which can optionally be applied, clean up arguments prior to evaluation. Filtering rules can be composed via trait decoration.

* __Ensures only ASCII control characters matter__
	* API: org.hashtree.stringmetric.filter.AsciiControlOnlyStringFilter
* __Ensures ASCII controls do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiControlStringFilter
* __Ensures ASCII letter case-sensitivity does not matter__
	* API: org.hashtree.stringmetric.filter.AsciiLetterCaseStringFilter
* __Ensures only ASCII letters and numbers matter__
	* API: org.hashtree.stringmetric.filter.AsciiLetterNumberOnlyStringFilter
* __Ensures ASCII letters and numbers do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiLetterNumberStringFilter
* __Ensures only ASCII letters matter__
	* API: org.hashtree.stringmetric.filter.AsciiLetterOnlyStringFilter
* __Ensures ASCII letters do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiLetterStringFilter
* __Ensures only ASCII numbers matter__
	* API: org.hashtree.stringmetric.filter.AsciiNumberOnlyStringFilter
* __Ensures ASCII numbers do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiNumberStringFilter
* __Ensures ASCII spaces do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiSpaceStringFilter
* __Ensures only ASCII symbols matter__
	* API: org.hashtree.stringmetric.filter.AsciiSymbolOnlyStringFilter
* __Ensures ASCII symbols do not matter__
	* API: org.hashtree.stringmetric.filter.AsciiSymbolStringFilter

## Versioning
[SemVer](http://semver.org/)

## Building the API
gradle :stringmetric-core:jar

## Building the CLI
gradle :stringmetric-cli:tar

## Using the API
`// Import metric of choice.`  
`import org.hashtree.stringmetric.similarity.JaroWinklerMetric`  

`// Import some filters, optionally.`  
`import org.hashtree.stringmetric.{ AsciiLetterCaseStringFilter, AsciiLetterOnlyStringFilter, StringFilterDelegate }`  

`// Invoke metric compare method without filters.`  
`val distance0 = JaroWinklerMetric.compare("string1", "string2")`

`// Invoke metric compare method with filters to ignore non-letter characters and case.`  
`val distance1 = JaroWinklerMetric.compare("string1", "string2")`  
`(new StringFilterDelegate with AsciiLetterCaseStringFilter with AsciiLetterOnlyStringFilter)`

`// Invoke metric compare method with filters to ignore case.`  
`val distance2 = JaroWinklerMetric.compare("string1", "string2")`  
`(new StringFilterDelegate with AsciiLetterCaseStringFilter)`

`// All metrics have an overloaded compare method which accepts character arrays.`  
`val distance3 = JaroWinklerMetric.compare("string1".toCharArray, "string2".toCharArray)`

`// Do something. In this case, distance is between 1.0 and 0.0.`  
`if (distance0 >= 0.9) println("It's likely you're a match!")`

## Using the CLI
Uncompress the built tar and ensure you have ability to execute the commands. Execute the metric of choice via the command line:

`// The help option prints command syntax and usage.`  
`jaroWinklerMetric --help`  
`metaphoneMetric --help`  
`metaphoneAlgorithm --help`  

`// Compare "abc" to "xyz" using the Jaro-Winkler metric.`  
`jaroWinklerMetric abc xyz`  

`// Compare "abc "to "xyz" using the Metaphone metric.`  
`metaphoneMetric abc xyz`  

`// Get the phonetic representation of "abc" via the metaphone phonetic algorithm.`  
`metaphoneAlgorithm abc`  

## Requirements
* Scala 2.9.2
* Gradle 1.0 or above

## License
Apache License, Version 2.0