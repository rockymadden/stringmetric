#stringmetric
A collection of string metrics implemented in Scala. Includes a light-weight core API and CLI for each string metric. The following string metrics are currently supported:

* Hamming
* Jaro
* Jaro-Winkler
* Levenshtein
* Soundex

## Building the API
gradle jar

## Building the CLI
gradle tar

## Using the API
`// Import metric of choice.`  
`import org.hashtree.stringmetric.JaroWinklerMetric`  
`// Optionally import metric implicit stringCleaner into scope.`  
`import org.hashtree.stringmetric.JaroWinklerMetric.stringCleaner`

`// Invoke metric compare method with implicit stringCleaner.`  
`val distance = JaroWinklerMetric.compare("string1", "string2")`

`// Do something. In this case, distance is between 1.0f and 0.0f.`  
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