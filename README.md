# Sequence ID Generator

## Overview

The `SequenceIdGenerator` is a Java class designed to generate unique sequence IDs by combining the current timestamp, the machine's hostname, and a sequence number. While it is not an exact implementation of the Twitter Snowflake algorithm, it provides a simple and effective way to generate unique identifiers suitable for various applications.

## Features

- Generates unique sequence IDs based on the current timestamp.
- Incorporates the machine's hostname to ensure uniqueness across different machines.
- Maintains a sequence number to avoid collisions within the same millisecond.
- Thread-safe implementation to support concurrent ID generation.

## Usage

### Standalone Usage

To use the `SequenceIdGenerator`, you can call the `generateSeqId()` method directly from your application code. Here’s an example of how to use the class:

```java
String uniqueId = SequenceIdGenerator.generateSeqId();
System.out.println("Generated ID: " + uniqueId);
```


### Spring Boot Integration
The `SequenceIdGenerator` class can also be used independently in any Spring Boot application. To do this, add the `@Component` annotation to the class definition. This allows Spring to manage the lifecycle of the `SequenceIdGenerator` bean.

```
import org.springframework.stereotype.Component;

@Component
public class SequenceIdGenerator {
    // Existing code...
}
```

## Author
Ruban Divyaraj - [LinkedIn Profile](https://www.linkedin.com/in/rubandivyaraj)

## Acknowledgments
Inspired by the Twitter Snowflake algorithm for unique ID generation.

