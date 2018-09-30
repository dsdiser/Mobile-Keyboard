# Mobile Device Keyboard (With Autocomplete)

This is a keyboard autocomplete algorithm to be used in various mobile devices. This algorithm will analyze the passages 
typed by the user in order to suggest a set of candidate autocomplete words given a word fragment.

This project makes use of the java.util library's concurrentHashMap object in order to store and retrieve words from training strings.
Unlike regular hash maps, concurrent hash maps make it possible for the user to enter text to train the algorithm and simultaneously 
retrieve results from the algorithm. Hash maps have the advantage of time efficient insertions and retrieval.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for testing purposes. 

### Prerequisites

Ensure you have Apache Maven installed as well as Java Development Kit (JDK) 1.8 on your system. To test if maven is installed, you may use:

```
mvn -v
```

### Installing

Once you have cloned the directory on your home machine, enter the directory where it was installed and use:

```
mvn compile
```

Once that is completed, navigate to the directory and run Autocompleter-0.1.0.jar with the command:

```
java -jar Autocompleter-0.1.0.jar
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency and Build Management
* [JDK 1.8.0](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Development Kit 1.8.0_181

## Author

* **Daniel Diseroad** - [dsdiser](https://github.com/dsdiser)


