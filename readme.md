#stringmetric
A collection of string metrics implemented in Scala. Includes a light-weight core API and CLI for each string metric. The following string metrics are currently supported:

* __Dice / Sorensen__ (<http://en.wikipedia.org/wiki/Dice%27s_coefficient>)
	* _API namespace_: org.hashtree.stringmetric.similarity.DiceSorensenMetric
	* _CLI name_: diceSorensenMetric
* __Hamming__ (<http://en.wikipedia.org/wiki/Hamming_distance>)
	* _API namespace_: org.hashtree.stringmetric.similarity.HammingMetric
	* _CLI name_: hammingMetric
* __Jaro__ (<http://en.wikipedia.org/wiki/Jaro-Winkler_distance>)
	* _API namespace_: org.hashtree.stringmetric.similarity.JaroMetric
	* _CLI name_: jaroMetric
* __Jaro-Winkler__ (<http://en.wikipedia.org/wiki/Jaro-Winkler_distance>)
	* _API namespace_: org.hashtree.stringmetric.similarity.JaroWinklerMetric
	* _CLI name_: jaroWinklerMetric
* __Levenshtein__ (<http://en.wikipedia.org/wiki/Levenshtein_distance>)
	* _API namespace_: org.hashtree.stringmetric.similarity.LevenshteinMetric
	* _CLI name_: levenshteinMetric
* __Metaphone__ (<http://en.wikipedia.org/wiki/Metaphone>)
	* _API namespace_: org.hashtree.stringmetric.phonetic.MetaphoneMetric
	* _CLI name_: metaphoneMetric
* __NYSIIS__ (<http://en.wikipedia.org/wiki/New_York_State_Identification_and_Intelligence_System>)
	* _API namespace_: org.hashtree.stringmetric.phonetic.NysiisMetric
	* _CLI name_: nysiisMetric
* __Refined Soundex__ (<http://ntz-develop.blogspot.com/2011/03/phonetic-algorithms.html>)
	* _API namespace_: org.hashtree.stringmetric.phonetic.RefinedSoundexMetric
	* _CLI name_: refinedSoundexMetric
* __Soundex__ (<http://en.wikipedia.org/wiki/Soundex>)
	* _API namespace_: org.hashtree.stringmetric.phonetic.SoundexMetric
	* _CLI name_: soundexMetric

All phonetic string metrics have a stand alone algorithm counter part. They provide a means to extract the phonetic representation of the argument passed, rather than determining if two arguments sound the same phonetically.

* __Metaphone__
	* _API namespace_: org.hashtree.stringmetric.phonetic.MetaphoneAlgorithm
	* _CLI name_: metaphoneAlgorithm
* __NYSIIS__
	* _API namespace_: org.hashtree.stringmetric.phonetic.NysiisAlgorithm
	* _CLI name_: nysiisAlgorithm
* __Refined Soundex__
	* _API namespace_: org.hashtree.stringmetric.phonetic.RefinedSoundexAlgorithm
	* _CLI name_: refinedSoundexAlgorithm
* __Soundex__
	* _API namespace_: org.hashtree.stringmetric.phonetic.SoundexAlgorithm
	* _CLI name_: soundexAlgorithm

In addition to string metrics, several filters are available which clean up passed arguments prior to evaluation. Filtering rules can be composed via trait decoration.

* __Differing Case__ (Ignore ASCII letter case differences)
	* _API namespace_: org.hashtree.stringmetric.AsciiLetterCaseStringFilter
* __Non-Letters__ (Ignore all characters except for ASCII letters)
	* _API namespace_: org.hashtree.stringmetric.AsciiLetterOnlyStringFilter
* __Spaces__ (Ignore all spaces)
	* _API namespace_: org.hashtree.stringmetric.SpaceStringFilter

## Building the API
gradle jar

## Building the CLI
gradle tar

## Using the API
`// Import metric of choice.`  
`import org.hashtree.stringmetric.similarity.JaroWinklerMetric`  

`// Import some filters, if desired.`  
`import org.hashtree.stringmetric.{ AsciiCaseStringFilter, AsciiLetterOnlyStringFilter, StringFilterDelegate }`  

`// Invoke metric compare method without filters.`  
`val distance0 = JaroWinklerMetric.compare("string1", "string2")`

`// Invoke metric compare method with filters to ignore non-letter characters and case.`  
`val distance1 = JaroWinklerMetric.compare("string1", "string2")`  
`(new StringFilterDelegate with AsciiCaseStringFilter with AsciiLetterOnlyStringFilter)`

`// Invoke metric compare method with filters to ignore case.`  
`val distance2 = JaroWinklerMetric.compare("string1", "string2")`  
`(new StringFilterDelegate with AsciiCaseStringFilter)`

`// All metrics have an overloaded compare method which accepts character arrays.`  
`val distance3 = JaroWinklerMetric.compare("string1".toCharArray, "string2".toCharArray)`

`// Do something. In this case, distance is between 1.0 and 0.0.`  
`if (distance0 >= 0.9) println("It's likely you're a match!")`

## Using the CLI
Uncompress the built tar and ensure you have ability to execute the commands. Execute the metric of choice via the command line:

`// Pass the help option to any command to see syntax and usage.`  
`jaroWinklerMetric --help`  
`metaphoneMetric --help`  
`metaphoneAlgorithm --help`  

`// Compare "abc" to "xyz" using the Jaro-Winkler metric.`  
`jaroWinklerMetric abc xyz`  

`// Compare "abc "to "xyz" using the Metaphone metric.`  
`metaphoneMetric abc xyz`  

`// Get the phonetic representation of "abc", via the metaphone phonetic algorithm.`  
`metaphoneAlgorithm abc`  

## Requirements
* Scala 2.9.2
* Gradle 1.0 or above

## License
Apache License, Version 2.0