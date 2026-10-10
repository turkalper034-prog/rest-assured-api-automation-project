# REST Assured API Automation Project

## About the Project
This project contains API automation tests developed using REST Assured and Java. It uses the DummyJSON API to validate product endpoints and HTTP responses.

## Technologies
- Java
- REST Assured
- Maven
- JUnit 5
- Hamcrest

## Test Scenarios
- Retrieve all products and validate response data
- Verify the number of products returned
- Retrieve a single product by ID
- Search products by query
- Create a product using POST
- Update a product using PUT
- Delete a product using DELETE
- Check the response status code and body assertions

## API Under Test
[DummyJSON](https://dummyjson.com/)

## How to Run
1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Run the tests with Maven:

```bash
mvn test
```

## Notes
DummyJSON simulates create, update, and delete operations. These operations do not permanently modify the underlying product data.

## Author
QA Automation Practice Project