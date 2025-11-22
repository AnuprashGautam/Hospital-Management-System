# 🏥 Hospital Management System (JDBC Project)

A simple **console-based Hospital Management System** built using **Java + JDBC + MySQL**.  
This project demonstrates database operations, user input handling, and relational data management while enabling **patients to book appointments with available doctors**.

---

## ✨ Features
- ➕ Register a new patient
- 📅 Book appointments with available doctors  
- 🔍 Check doctor availability  
- 📄 View patient and doctor details  
- 🗂 List all appointments
- 🔗 JDBC connectivity with SQL queries  
- 🖥 Clean and interactive console-based menu system  

---

## 🛠 Tech Stack
- **Java (JDK 8+)**  
- **JDBC API**  
- **MySQL Database**  
- **MySQL Connector/J driver**  
- **IntelliJ IDEA**  

---

## 📦 Prerequisites
Make sure you have:

- ☕ Java (8 or above)  
- 🐬 MySQL installed and running  
- 🔌 MySQL JDBC Driver  
- 🖥 Any IDE (recommended: IntelliJ)  

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/AnuprashGautam/Hospital-Management-System
cd Hospital-Management-System
````

### 2️⃣ Open in IntelliJ IDEA

### 3️⃣ Add the MySQL JDBC Driver

If not using Maven:

* Download `mysql-connector-java.jar`
* Add it in **Project Structure → Libraries**

### 4️⃣ Configure database connection

Inside your connection class:

```java
String url = "jdbc:mysql://localhost:3306/hospitaldb";
String username = "root";
String password = "yourpassword";
```

### 5️⃣ Run `Main.java` 🎉

---

---

## ▶️ How It Works

1. User runs the program and sees a menu
2. Patients can be registered and doctors can be added
3. Patient selects a doctor and books an appointment on a chosen date
4. System checks availability and stores the appointment
5. User can view, update, or cancel appointments

---

## 🚀 Future Enhancements

* 💊 Add treatment & prescription module
* 📋 Generate patient reports
* 🏥 Add room/bed management
* 🧾 Add billing system
* 🌐 Convert console UI to a web app using Spring Boot
* 🔐 Add authentication & role management

---

## 🤝 Contributing

Contributions are welcome!
Feel free to submit a pull request or open an issue.
