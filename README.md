# 🛒 Item Management REST API

A simple **Spring Boot Backend Application** that provides RESTful APIs to manage a collection of items.

This project was built as part of a sample freelance task to demonstrate backend development skills including API design, validation, exception handling, and in‑memory data storage.

---

# 🚀 Features

- Add a new item
- Get item by ID
- Input validation
- Duplicate ID handling
- Proper HTTP status codes
- JSON error responses
- Simple HTML UI for testing APIs
- In‑memory storage (ArrayList)

---

# 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Validation
- Lombok
- Maven

---

# 📂 Project Structure

```
src/main/java/com/example/demo
│
├── controller
│   └── ItemController.java
│
├── service
│   └── ItemService.java
│
├── model
│   └── Item.java
│
└── DemoApplication.java

src/main/resources
└── static
    └── index.html   (Testing UI)
```

---

# 📦 Item Model

Each item contains:

| Field | Type | Description |
|------|------|-------------|
| id | Long | Unique identifier |
| name | String | Item name |
| description | String | Item description |
| price | Double | Item price |

Validation constraints:

- ID → Required
- Name → Not blank
- Price → Positive

---

# 🔌 API Endpoints

## 1️⃣ Add Item

**POST** `/items`

### Request Body

```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Apple Mobile",
  "price": 80000
}
```

### Success Response

**201 CREATED**

```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Apple Mobile",
  "price": 80000
}
```

### Duplicate ID

**409 CONFLICT**

```json
{
  "error": "Item with ID 1 already exists"
}
```

### Validation Error

**400 BAD REQUEST**

```json
{
  "error": "Price must be positive"
}
```

---

## 2️⃣ Get Item By ID

**GET** `/items/{id}`

### Example

```
GET /items/1
```

### Success Response

**200 OK**

```json
{
  "id": 1,
  "name": "iPhone 15",
  "description": "Apple Mobile",
  "price": 80000
}
```

### Not Found

**404 NOT FOUND**

```json
{
  "error": "Item not found"
}
```

---

# ⚠️ Error Handling

Errors are returned in JSON format:

```json
{
  "error": "Error message"
}
```

Handled scenarios:

- Duplicate item ID → 409
- Validation failure → 400
- Item not found → 404
- Server error → 500

---

# 🧠 In‑Memory Storage

This application uses:

```java
ArrayList<Item>
```

- Data is stored temporarily
- Data resets when server restarts
- No database required

---

# 🖥️ Simple HTML Testing UI

A basic HTML page is included inside:

```
src/main/resources/static/index.html
```

Features:

- Add item via form
- Fetch item by ID
- Displays success & error responses

Access in browser:

```
http://localhost:8080
```

---

# ▶️ How to Run the Application

## 1️⃣ Clone Repository

```bash
git clone <your-repo-link>
cd demo
```

## 2️⃣ Build Project

```bash
mvn clean install
```

## 3️⃣ Run Application

```bash
mvn spring-boot:run
```

OR run `DemoApplication.java` from IDE.

---

# 🌐 Server Details

| Property | Value |
|---------|-------|
| Base URL | http://localhost:8080 |
| API Base | /items |
| Content-Type | application/json |

---

# 🧪 Testing via Postman

### Add Item

- Method: POST
- URL: `http://localhost:8080/items`
- Body → JSON

### Get Item

- Method: GET
- URL: `http://localhost:8080/items/{id}`

---

# 🚀 Deployment

- URL: `https://github.com/mKumar82/demo-java-task`

---

