# Student Record Management System

A Java-based application for managing student records with support for multiple file formats including text files, binary files, and serialized objects.

## Project Overview

This system allows you to:
- Add and manage student records
- Store records in different formats (Text, Binary, Serialized Objects)
- Generate reports
- Create and restore backups
- Efficiently manage student data

## Project Structure

```
StudentRecordManagementSystem/
├── src/
│   ├── main/
│   │   └── Main.java              # Entry point of the application
│   ├── model/
│   │   └── Student.java           # Student data model
│   ├── service/
│   │   ├── StudentTextFileManager.java        # Text file handling
│   │   ├── StudentBinaryFileManager.java      # Binary file handling
│   │   ├── StudentObjectFileManager.java      # Serialized object handling
│   │   ├── ReportGenerator.java               # Report generation
│   │   └── BackupManager.java                 # Backup operations
│   └── util/
│       └── FileUtility.java       # File utility functions
├── data/
│   └── students.txt               # Student data storage
├── backup/                        # Backup directory
└── README.md                      # This file
```

## Components

### Student Model
- Stores student information (ID, Name, Grade, etc.)
- Serializable for object file storage

### File Managers
- **StudentTextFileManager**: Manages student records in text format
- **StudentBinaryFileManager**: Manages student records in binary format
- **StudentObjectFileManager**: Manages serialized student objects

### Service Classes
- **ReportGenerator**: Generates reports from student data
- **BackupManager**: Creates and restores backups of student records

### Utilities
- **FileUtility**: Helper functions for file operations

## Building and Running

### Prerequisites
- Java Development Kit (JDK) 8 or higher

### Build
```bash
javac -d bin src/main/java/com/example/**/*.java
```

### Run
```bash
java -cp bin com.example.Main
```

## Data Formats

### Text Format
Student records stored in plain text files for easy viewing and editing.

### Binary Format
Student records stored in binary format for efficient storage and faster access.

### Object Format
Student records stored as serialized Java objects for direct object reconstruction.

## Features

- **Multiple Storage Formats**: Choose between text, binary, or object serialization
- **Backup System**: Automatically backup and restore student records
- **Report Generation**: Generate detailed reports from student data
- **File Utilities**: Helper functions for file operations
- **Persistent Storage**: Data persists between application runs

## Usage

Run the Main application to access the menu-driven interface for managing student records.

---

**Last Updated**: June 2026