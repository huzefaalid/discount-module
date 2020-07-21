
This project is a simple Java Based application applying some retail site Business conditions which as per the following logic:

1. If the user is an employee of the store, he gets a 30% discount
2. If the user is an affiliate of the store, he gets a 10% discount
3. If the user has been a customer for over 2 years, he gets a 5% discount.
4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
as a discount).
5. The percentage based discounts do not apply on groceries.
6. A user can get only one of the percentage based discounts on a bill.
Assumptions :
1. User can either be an employee, affiliate or a customer .(One to One mapping with Role)
2. The person will know before calculation what is the type of user (Employee, Affiliate or Customer)


Note: In order to run the project, kindly download the source code and run the code as mvn clean install 

#####Assumptions:
 Assumed that the 5$ discount per 100$ on total of Gross bill amount for a customer/
 employee/Affiliate will be made on the total Gross bill and then if any other 3 discounts(% discounts) will be made as per UserType based on Employee(30%),
 Affiliate(10%) and customers(loyalty>2 years 5%) on the non grocery items.
 
 
## UML Digram
Outside the Project :Shared in the path 
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Approach Discussion
Its a standalone application consist of all Possible test cases. Following are the approach has been taken to address this assignment
1. Strategy Pattern which change the strategy based on the User Type
2. Each Discount Policy segregated based on single responsibility concern and can be part of the calculation if it satisfy support method.
3. Designed in a way that each Discount policy can be tested independently.
4. Addition and Removal of New Discount Policy will be like plug and play with minimum code changes.

## How to Run
```shell
mvn clean test
```



