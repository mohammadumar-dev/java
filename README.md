# JDBC PostgreSQL Project

This project demonstrates how to compile and run a Java program using the PostgreSQL JDBC driver.

---

## 📌 Compile the Code

Use the following command to compile `Main.java`:

```sh
javac -cp .:lib/postgresql-42.7.8.jar Day-1/Main.java
```

## ▶️ Run the Program

Use the following command to execute the compiled Java class:

```sh
java -cp .:lib/postgresql-42.7.8.jar Day-1.Main
```

## 📝 Notes

* -cp stands for classpath

* . means current directory

* lib/postgresql-42.7.8.jar must exist inside the lib/ folder

* Day-1.Main uses dot notation, not slashes

## 📂 Project Structure
```
project/
│
├── lib/
│   └── postgresql-42.7.8.jar
│
├── Day-1/
│   └── Main.java
│
└── README.md
```
