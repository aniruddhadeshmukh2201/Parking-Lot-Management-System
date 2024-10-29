# 🚗 Parking Lot Management System

A **Parking Lot Management System** built to efficiently manage parking slots for various types of vehicles, calculate parking fees and streamline entry and exit operations. This project showcases **Low-Level Design (LLD)** using **Object-Oriented Design** principles, **design patterns**, and best practices in **code organization**.

## 📝 Table of Contents
- [Features](#features)
- [Design Patterns Used](#design-patterns-used)
- [Class Diagram](#class-diagram)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [License](#license)

---

## ✨ Features

- **Vehicle Parking and Exit**: Supports various vehicle types, such as bikes, cars, and trucks.
- **Real-Time Availability**: Shows real-time slot availability.
- **Parking Fees Calculation**: Calculates charges based on parking duration and vehicle type.
- **Admin and User Modes**: Separate permissions and functionality for admins (e.g., configuring parking charges).
- **Design Patterns**: Utilizes several design patterns to demonstrate best practices in object-oriented programming.

---

## 🛠️ Design Patterns Used

- **Singleton Pattern**: Ensures only one instance of the Parking Lot class to manage entries, exits, and available slots.
- **Strategy Pattern**: Used for flexible calculation of parking charges based on vehicle type and duration.
- **Factory Pattern**: Creates instances of different vehicle types (e.g., Bike, Car, Truck) based on user input.
- **Observer Pattern**: Notifies admin users or displays alerts when the parking lot reaches a specific capacity threshold.

---

## 🗂️ Class Diagram

Here's a high-level view of the class design:

ParkingLot │ ├── SlotManager │ ├── ParkingSlot │ ├── SlotType (enum for types of parking slots) │ ├── VehicleFactory │ ├── Vehicle (abstract) │ ├── Car │ ├── Bike │ └── Truck │ ├── PricingStrategy │ ├── BasePricing │ ├── HourlyPricing │ └── DailyPricing │ └── Ticket



---

## 📂 Project Structure

ParkingLotManagementSystem/ ├── src/ │ ├── main/ │ │ ├── java/ │ │ │ └── com/parkinglot/ │ │ │ ├── ParkingLot.java │ │ │ ├── SlotManager.java │ │ │ ├── Vehicle.java │ │ │ ├── ParkingSlot.java │ │ │ ├── PricingStrategy.java │ │ │ ├── Ticket.java │ │ │ └── enums/ │ │ │ ├── SlotType.java │ │ │ └── VehicleType.java │ └── test/ │ └── java/com/parkinglot/ (Unit tests) ├── README.md └── pom.xml (for Maven users)

---

## 🚀 Getting Started

### Prerequisites

- **Java 11+**
- **Maven** (for building and managing dependencies)

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/ParkingLotManagementSystem.git
   cd ParkingLotManagementSystem







## 📜 License

This project is licensed under the **MIT License**. You are free to use, modify, and distribute this code. See the [LICENSE](LICENSE) file for more details.

---

### 📢 Contributions

We welcome contributions to improve and extend the **Parking Lot Management System**!

If you’d like to contribute:
1. **Fork the repository**: Click on the "Fork" button in the top right corner of this page.
2. **Create a new branch**: Use a descriptive name for your branch.
   ```bash
   git checkout -b feature/your-feature-name
3. Make your changes: Commit your modifications with descriptive commit messages.
