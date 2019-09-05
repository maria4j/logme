# Logme
[![MIT License](http://img.shields.io/badge/license-MIT-green.svg)](https://github.com/maria4j/logme/blob/master/LICENSE)

Logme is a Java library for building structured and readable logs 
created to make developers and support engineers happier :grinning:

Logs reading is accompanied by a strong desire to understand what is happening in the system. 
Comprehensible log messages usually obey the unified format stated in your Code Style Guide. 
Checking that logs correspond to the accepted rules requires a lot of attention during the code review 
and often makes both the reviewer and the developer sad. 
Logs described by a monosemantic grammar allow to avoid these excessive efforts and can be parsed and analyzed automatically.
Logme takes care of how your logs look like so you may focus on what they try to tell. 

## Features
* Unified logs format
* Automatic indentaion
* Multilining 

An example of the message built with Logme:
```text
[FORECASTER-THREAD-1] Requesting weather forecast {date=01.08.2019 17:45 GMT+7, location=Novosibirsk}
```

**_Note:_** The current version of Logme doesn't support the configuration of the message format.

## Requirements
1. Java: any 8 version or greater.
2. Maven: any 3 version or greater.

## Using with Maven
Add the dependency to your `pom.xml` file:

```xml
<dependencies>
  <dependency>
    <groupId>com.logme</groupId>
    <artifactId>logme</artifactId>
    <version>0.1.0-SNAPSHOT</version>
  </dependency>
</dependencies>
```

## Usage
Logme API consists of three basic classes designed as builders:
* `Message` - the starting point to create messages and append text, parameters and tags to them. 
Delegates the appending of the parameters to the classes below.
* `Parameters` - used to append single-line parameters to messages. 
* `MultilineParameters` - used to append parameters that are hardly readable and 
need to be formatted as multiline text. For example, a large application configuration. 

To create Logme message call the static method `message` of `Logme` class:
```java
Message message = Logme.message("Requesting weather forecast");
```

The output of the `System.out.println(message)` will be the following:
```text
Requesting weather forecast
```

### Appending text
To append text call `append` method of the created message:
```java
Message message = Logme.message()
                       .append("Requesting")
                       .append(" weather")
                       .append(" forecast");
```

### Appending single-line parameters
Frequently logs are quite compact and fit well on one line. 

To put a brief additional information call `appendParameters` method on the message:
```java
Message message = Logme.message("Requesting weather forecast ")
                       .appendParameters(parameters -> parameters
                           .append("date", today)
                           .append("location", location)
                       );
```

The output of the `System.out.println(message)` will be the following:
```text
Requesting weather forecast {date=01.08.2019 17:45 GMT+7, location=Novosibirsk}
```
Supported parameter types:
* Primitives: `boolean`, `byte`, `int`, `short`, `long`, `float`, `double`, `char`
* Objects
* Arrays
* Collections
* `Parameters`

Logme allows to specify the text to print if the parameter value is null:
```java
Message message = Logme.message("Requesting weather forecast ")
                       .appendParameters(parameters -> parameters
                           .append("date", today, "<not specified>")
                           .append("location", location)
                       );
```

If `today` is `null` the output of the `System.out.println(message)` will be the following:
```text
Requesting weather forecast {date=<not specified>, location=Novosibirsk}
```

### Appending multiline parameters
There may be cases when individual log messages are large and need to be structured.
E.g., printing system configuration during application startup or extended information for debugging.

To append parameters for large objects call `appendMultilineParameters` method on the message:
```java
Message message = Logme.message("System configuration: ")
                       .appendMultilineParameters(multilineParameters -> multilineParameters
                           .append("enabled", true)
                           .append("server.max-connections", 200)
                           .append("server.queue-size", 50)
                           .append("node.id", "brown-bear")
                       );
```

Logme takes care of text formatting and automatically builds the message with the proper indentation.

The output of the `System.out.println(message)` will be the following:
```text
System configuration: {
    enabled=true, 
    server.max-connections=200,
    server.queue-size=50,
    node.id=brown-bear
}
```
Supported parameter types:
* Primitives: `boolean`, `byte`, `int`, `short`, `long`, `float`, `double`, `char`
* Objects
* Arrays
* Collections
* `Parameters`
* `MultilineParameters`

If you need to multiline individual parameter value represented by array or collection call 
`append`, `appendParameters`, `appendMultilineParameters` on the message with ```multilineValue``` parameter set to ```true```:
```java
String[] stickedRegions = getStickedRegions(); 
Message message = Logme.message("System configuration: ")
                       .appendMultilineParameters(multilineParameters -> multilineParameters
                           .append("enabled", true)
                           .append("server.max-connections", 200)
                           .append("server.queue-size", 50)
                           .append("node.id", "brown-bear")
                           .append("node.sticked-regions", stickedRegions, true)
                       );
```

The output of the `System.out.println(message)` will be the following:
```text
System configuration: {
    enabled=true, 
    server.max-connections=200,
    server.queue-size=50,
    node.id=brown-bear,
    node.sticked-regions=[
        "West Siberia",
        "Far East"
    ]
}
```

### Appending tags
Tags are introduced to mark messages belonging to the same category. For example, to one thread in multi-threaded environment.

To append tag call `appendTag` method on the message:
```java
Message message = Logme.message("Requesting weather forecast ")
                       .appendTag(Thread.currentThread().getName())
                       .appendParameters(parameters -> parameters
                           .append("date", today)
                           .append("location", location)
                       );
```

The output of the `System.out.println(message)` will be the following:
```text
[FORECASTER-THREAD-1] Requesting weather forecast {date=01.08.2019 17:45 GMT+7, location=Novosibirsk}
```

## License

[MIT](LICENSE)
