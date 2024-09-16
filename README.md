Features
JSON Parsing: Reads and decodes polynomial root points from a JSON format.
Base Conversion: Converts root values from various bases (e.g., binary, hexadecimal) to decimal.
Polynomial Reconstruction: Uses Lagrange interpolation to reconstruct the constant term of the polynomial.
Modular Arithmetic: Utilizes modular arithmetic to handle large numbers and avoid overflow issues.
Prerequisites
Java Development Kit (JDK) 8 or later.
Jackson library for JSON processing (used for parsing JSON).
Libraries
Jackson Core
Jackson Databind
You need to include these libraries in your project. If you're using Maven, add the following dependencies to your pom.xml:

xml
Copy code
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-core</artifactId>
    <version>2.13.4</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.13.4</version>
</dependency>
Usage
Create JSON File: Prepare a JSON file containing the polynomial root points and base information. For example, input.json:

json
Copy code
{
    "keys": {
        "n": 9,
        "k": 6
    },
    "1": {
        "base": "10",
        "value": "28735619723837"
    },
    "2": {
        "base": "16",
        "value": "1A228867F0CA"
    },
    "3": {
        "base": "12",
        "value": "32811A4AA0B7B"
    },
    "4": {
        "base": "11",
        "value": "917978721331A"
    },
    "5": {
        "base": "16",
        "value": "1A22886782E1"
    },
    "6": {
        "base": "10",
        "value": "28735619654702"
    },
    "7": {
        "base": "14",
        "value": "71AB5070CC4B"
    },
    "8": {
        "base": "9",
        "value": "122662581541670"
    },
    "9": {
        "base": "8",
        "value": "642121030037605"
    }
}
Compile the Code: Use the following command to compile the Java code:

sh
Copy code
javac OptimizedPolynomialSecretSharing.java
Run the Program: Execute the program with the compiled .class file. Make sure to place the input.json file in the same directory or specify the correct path.

sh
Copy code
java OptimizedPolynomialSecretSharing input.json
Example Output
For the provided JSON input, the program will print the reconstructed polynomial constant term for both test cases. The output will be similar to:

php
Copy code
Test Case 1 Reconstructed Secret: <computed_value>
Test Case 2 Reconstructed Secret: <computed_value>
Replace <computed_value> with the actual result computed by the program.

Code Description
OptimizedPolynomialSecretSharing.java: Contains the main class and methods for JSON parsing, base conversion, and polynomial reconstruction.
main Method: Reads the JSON file, parses the data, and initiates the polynomial reconstruction.
parseJson Method: Parses JSON input to extract polynomial root points.
convertBase Method: Converts number values from various bases to decimal.
reconstructSecret Method: Applies Lagrange interpolation to reconstruct the polynomial constant term.
License
This project is licensed under the MIT License. See the LICENSE file for details.

Contributing
Feel free to submit issues, suggestions, or pull requests. Contributions are welcome!

Contact
For any questions or further assistance, please contact [Your Name] at [Your Email].
