#stringmetric
A collection of string metrics implemented in Scala. Includes a light-weight core API and CLI for each string metric. The following string metrics are currently supported:

* Dice / Sorensen
* Hamming
* Jaro
* Jaro-Winkler
* Levenshtein
* Metaphone
* NYSIIS
* Refined Soundex
* Soundex

## Building the API
gradle jar

## Building the CLI
gradle tar

## Using the API
`// Import metric of choice.`  
`import org.hashtree.stringmetric.similarity.JaroWinklerMetric`  

`// Optionally import filters, which clean up arguments prior to evaluation.`  
`import org.hashtree.stringmetric.{ AsciiCaseStringFilter, AsciiLetterOnlyStringFilter, StringFilterDelegate }`  

`// Invoke metric compare method.`  
`val distance = JaroWinklerMetric.compare("string1", "string2")`

`// Optionally invoke metric compare method with filters. In this case, non-letter characters and case do not matter.`  
`val filteredDistance = JaroWinklerMetric.compare("string1", "string2")(new StringFilterDelegate with AsciiCaseStringFilter with AsciiLetterOnlyStringFilter)`

`// Do something. In this case, distance is between 1.0 and 0.0.`  
`if (distance >= 0.9) println("It's likely you're a match!")`

## Using the CLI
Uncompress the built tar and ensure you have ability to execute the commands. Execute the metric of choice via the command line:

`jaroWinklerMetric --help`  
`jaroWinklerMetric abc xyz`

## Requirements
* Scala 2.9.2
* Gradle 1.2 or above

## License
Apache License, Version 2.0