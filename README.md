```markdown
# Lab Assignment 11: Testing using JUnit and Mockito Frameworks

This repository contains the implementation for **Lab Assignment 11**, focusing on software component design, professional unit testing, test suite aggregation, and behavioral verification using custom mock environments compatible with modern Java setups.

---

## Part 1: Array Flattener Component

### Objective
Implement an `ArrayFlattener` component as a Java command-line application that flattens a two-dimensional (2-D) nested array into a one-dimensional (1-D) array.

### Requirements
- **Method**: `int[] flattenArray(int[][] nestedArray)`
- **Sample Input**: `[[1, 3], [0], [4, 5, 9]]`
- **Sample Output**: `[1, 3, 0, 4, 5, 9]`
- **Unit Testing**: Implement test cases covering:
  - Legitimate 2-D nested array input.
  - `null` input handling.
- **Suite Aggregation**: Create a comprehensive JUnit Test Suite to manage and execute both test cases.

---

## Part 2: Array Reversor Component with Remote Service Mocking

### Objective
Implement an `ArrayReversor` component that returns the flattened and reversed order of elements from an input 2-D array. This component utilizes an external, remote interface (`ArrayFlattenerService`) to execute the initial flattening operation. 

### Requirements
- **Method**: `int[] reverseArray(int[][] nestedArray)`
- **Sample Input**: `[[1, 3], [0], [4, 5, 9]]`
- **Sample Output**: `[9, 5, 4, 0, 3, 1]`
- **Dependency Isolation**: Mock the remote/unavailable `ArrayFlattenerService` layer using a specialized architecture engineered to prevent JVM bytecode injection conflicts in modern Java runtime environments (Java 21+).
- **Behavioral Verification**: Write unit tests verifying that the remote service is actively invoked with correct parameters rather than bypassed via hardcoded logic.
- **Suite Aggregation**: Bundle the verification scenarios into a dedicated JUnit Test Suite named `ArrayReversorTestCases`.

---

## Project Structure

```text
src/
├── main/
│   └── java/
│       └── edu/
│           └── miu/
│               └── cs/
│                   ├── ArrayFlattener.java          # Part 1 component
│                   ├── ArrayFlattenerService.java   # Part 2 structural service interface
│                   └── ArrayReversor.java           # Part 2 structural implementation
└── test/
    └── java/
        └── edu/
            └── miu/
                └── cs/
                    ├── ArrayFlattenerTest.java      # Part 1 unit tests
                    ├── ArrayFlattenerTestSuite.java # Part 1 suite wrapper
                    ├── ArrayReversorTest.java       # Part 2 unit tests with manual state mocking
                    └── ArrayReversorTestCases.java  # Part 2 suite wrapper
