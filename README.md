## Inventory Management System Entity-Relationship Diagram

### Description

The Inventory Management System (IMS) Entity-Relationship Diagram (ERD) illustrates the structure and relationships among key entities within the IMS. This diagram provides a visual representation of how products, warehouses, orders, and transactions interact within the system.

### Entities

1. **Product**: Represents individual products available in the inventory. Each product is characterized by attributes such as ProductID, Name, Description, Price, and Quantity.

2. **Warehouse**: Represents physical locations where inventory items are stored. Warehouses have attributes including WarehouseID, Name, Location, and Capacity.

3. **Order**: Represents customer orders placed for products. Each order is identified by attributes such as OrderID, CustomerID, OrderDate, Status, and TotalAmount.

4. **Transaction**: Represents inventory-related transactions such as purchases, sales, or transfers. Transactions are identified by attributes including TransactionID, Type, Quantity, and Timestamp.

### Relationships

- **Product - Order**: Indicates that products can be included in one or more orders, representing the products purchased by customers.

- **Product - Warehouse**: Indicates that products can be stored in one or more warehouses, representing the physical locations where products are kept.

- **Product - Transaction**: Indicates that products can be involved in one or more transactions, representing inventory movements or changes.

- **Warehouse - Transaction**: Indicates that warehouses can be involved in one or more transactions, representing inventory-related activities within warehouses.

- **Warehouse - Order**: Indicates that warehouses can fulfill one or more orders, representing the process of shipping products from warehouses to fulfill orders.

- **Order - Transaction**: Indicates that orders can result in one or more transactions, representing inventory changes resulting from order fulfillment.

### Usage

The IMS ERD serves as a reference for understanding the structure and relationships within the Inventory Management System. It aids developers, stakeholders, and users in comprehending how different components of the system interact and function.

![ER diagram](ASS1.png)
# prudect table
| ID | HTTP request | (method URI) | Operation Description | HTTP status codes | Request sample | Response sample |
|----|--------------|--------------|-----------------------|-------------------|----------------|-----------------|
| 1  | POST         | /products    | Create a Product      | 201 (Created): <br> The product is successfully created. <br> 400 (Bad Request): The request is invalid. <br> 409 (Conflict): A product with the same ID already exists. | Sample POST request body | Sample POST response body |
| 2  | GET          | /products    | Retrieve all Products | 200 (OK): <br> Successfully retrieved the list of products. <br> 404 (Not Found): No products found. | - | Sample GET response body |
| 3  | GET          | /products/{id} | Retrieve a Product  | 200 (OK): <br> Successfully retrieved the product details. <br> 404 (Not Found): Product with the given ID not found. | - | Sample GET response body |
| 4  | PUT          | /products/{id} | Update a Product    | 200 (OK): <br> Product details successfully updated. <br> 400 (Bad Request): The request is invalid. <br> 404 (Not Found): Product with the given ID not found. | Sample PUT request body | Sample PUT response body |
| 5  | DELETE       | /products/{id} | Delete a Product    | 204 (No Content): <br> Product successfully deleted. <br> 404 (Not Found): Product with the given ID not found. | - | - |
# warehouses table 
| ID | HTTP request | (method URI) | Operation Description | HTTP status codes | Request sample | Response sample |
|----|--------------|--------------|-----------------------|-------------------|----------------|-----------------|
| 1  | POST         | /warehouses  | Create a Warehouse   | 201 (Created): <br> The warehouse is successfully created. <br> 400 (Bad Request): The request is invalid. <br> 409 (Conflict): A warehouse with the same ID already exists. | Sample POST request body | Sample POST response body |
| 2  | GET          | /warehouses  | Retrieve all Warehouses | 200 (OK): <br> Successfully retrieved the list of warehouses. <br> 404 (Not Found): No warehouses found. | - | Sample GET response body |
| 3  | GET          | /warehouses/{id} | Retrieve a Warehouse | 200 (OK): <br> Successfully retrieved the warehouse details. <br> 404 (Not Found): Warehouse with the given ID not found. | - | Sample GET response body |
| 4  | PUT          | /warehouses/{id} | Update a Warehouse | 200 (OK): <br> Warehouse details successfully updated. <br> 400 (Bad Request): The request is invalid. <br> 404 (Not Found): Warehouse with the given ID not found. | Sample PUT request body | Sample PUT response body |
| 5  | DELETE       | /warehouses/{id} | Delete a Warehouse | 204 (No Content): <br> Warehouse successfully deleted. <br> 404 (Not Found): Warehouse with the given ID not found. | - | - |
# orders table 
| ID | HTTP request | (method URI) | Operation Description | HTTP status codes | Request sample | Response sample |
|----|--------------|--------------|-----------------------|-------------------|----------------|-----------------|
| 1  | POST         | /orders      | Create an Order       | 201 (Created): <br> The order is successfully created. <br> 400 (Bad Request): The request is invalid. | Sample POST request body | Sample POST response body |
| 2  | GET          | /orders      | Retrieve all Orders   | 200 (OK): <br> Successfully retrieved the list of orders. <br> 404 (Not Found): No orders found. | - | Sample GET response body |
| 3  | GET          | /orders/{id} | Retrieve an Order    | 200 (OK): <br> Successfully retrieved the order details. <br> 404 (Not Found): Order with the given ID not found. | - | Sample GET response body |
| 4  | PUT          | /orders/{id} | Update an Order      | 200 (OK): <br> Order details successfully updated. <br> 400 (Bad Request): The request is invalid. <br> 404 (Not Found): Order with the given ID not found. | Sample PUT request body | Sample PUT response body |
| 5  | DELETE       | /orders/{id} | Delete an Order      | 204 (No Content): <br> Order successfully deleted. <br> 404 (Not Found): Order with the given ID not found. | - | - |
# transactions table
| ID | HTTP request | (method URI) | Operation Description | HTTP status codes | Request sample | Response sample |
|----|--------------|--------------|-----------------------|-------------------|----------------|-----------------|
| 1  | POST         | /transactions | Create a Transaction | 201 (Created): <br> The transaction is successfully created. <br> 400 (Bad Request): The request is invalid. | Sample POST request body | Sample POST response body |
| 2  | GET          | /transactions | Retrieve all Transactions | 200 (OK): <br> Successfully retrieved the list of transactions. <br> 404 (Not Found): No transactions found. | - | Sample GET response body |
| 3  | GET          | /transactions/{id} | Retrieve a Transaction | 200 (OK): <br> Successfully retrieved the transaction details. <br> 404 (Not Found): Transaction with the given ID not found. | - | Sample GET response body |
| 4  | PUT          | /transactions/{id} | Update a Transaction | 200 (OK): <br> Transaction details successfully updated. <br> 400 (Bad Request): The request is invalid. <br> 404 (Not Found): Transaction with the given ID not found. | Sample PUT request body | Sample PUT response body |
| 5  | DELETE       | /transactions/{id} | Delete a Transaction | 204 (No Content): <br> Transaction successfully deleted. <br> 404 (Not Found): Transaction with the given ID not found. | - | - |

# my API 
https://app.swaggerhub.com/apis/yazanzidan/Inventory-Management-System/3.1.0
