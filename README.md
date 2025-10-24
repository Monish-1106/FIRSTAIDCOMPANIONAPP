# 🩹 First Aid Companion – Emergency Guide App

### 🚑 Project Type: Java Swing Desktop Application  
### 👩‍💻 Developed for: Project Review 2 (GUI Implementation)  
### 💡 Platform: NetBeans IDE / VS Code (Java)

---

## 🧠 Overview

**First Aid Companion** is an interactive desktop application designed to provide **quick first aid instructions** and **emergency contact access** during medical emergencies.  
Originally conceptualized as an Android app, this version is implemented using **Java Swing** for GUI demonstration in **Project Review 2**.

---

## 🧩 Modules Implemented

| Module | Description |
|--------|-------------|
| 🧍 **User Module** | Allows the user to select a symptom (e.g., Burn, Cut, Choking) and view the appropriate remedy. |
| 📖 **Instruction Module** | Displays general first aid instructions and safety tips. |
| ☎️ **Emergency Contacts Module** | Provides quick-access buttons for Ambulance, Police, and Fire services. |
| 🔐 **Admin Module** | Enables adding and updating remedies dynamically during runtime. |

---

## 🖥️ Features

- Simple, clean **GUI using Java Swing**
- **Symptom-based remedy** lookup
- **Editable remedies** via admin panel
- **Popup emergency contact window**
- Modular design (each module in separate JFrame)
- Easily extendable to Android (future scope)

---

## 📂 Project Structure

FirstAidCompanion/
│
├── src/
│ └── firstaidapp/
│ ├── FirstAidApp.java # Main menu screen
│ ├── SymptomWindow.java # Symptom selection + remedies
│ ├── InstructionWindow.java # General instructions
│ ├── EmergencyWindow.java # Emergency contact buttons
│ └── AdminWindow.java # Add/update remedies
│
├── README.md # Project documentation
└── .gitignore # Ignore compiled files and IDE metadata


---

## ⚙️ How to Run

### 🧩 Option 1: **Using NetBeans**
1. Open **NetBeans IDE** → *New Project → Java with Ant → Java Application*
2. Name it: `FirstAidCompanion`
3. Package name: `firstaidapp`
4. Copy all `.java` files into `src/firstaidapp/`
5. Right-click **FirstAidApp.java → Run File**

### 💻 Option 2: **Using VS Code**
1. Install **Java Extension Pack** (by Microsoft)
2. Create folder `FirstAidCompanion`
3. Inside, create folder: `src/firstaidapp`
4. Copy all `.java` files into that folder
5. Open terminal and run:
   ```bash
   javac src/firstaidapp/*.java
   java -cp src firstaidapp.FirstAidApp

🧮 Technical Details

Language: Java

GUI Framework: Swing

IDE: NetBeans / VS Code

Storage: HashMap (for remedies; can be replaced by SQLite in Android version)

Event Handling: ActionListeners

Error Handling: JOptionPane popups for validation

🚀 Future Enhancements

Convert to Android application using XML layouts and SQLite database

Integrate Google Maps API to locate nearest hospitals

Add images and animations for visual first aid guides

Implement voice assistant support for accessibility

📸 Screens (in Swing Prototype)

1️⃣ Main Menu
2️⃣ Symptom Selection
3️⃣ Instructions Page
4️⃣ Emergency Contacts
5️⃣ Admin Panel

(You can add screenshots later after running project in /assets or GitHub preview.)

👨‍🏫 Project Demonstration 

During your review:

Run FirstAidApp.java

Show navigation:

Symptom → Remedy

Instructions → General guide

Emergency Contacts → Popup numbers

Admin Panel → Add new remedy

Conclude by saying:

“This Swing version is a prototype of the planned Android app implementation with database and API integration.”

🧑‍💻 Author

Name: R.R Monish Raj
Course: B.Tech CSE – AI/ML
Institute: SRM Institute of Science and Technology
Project: First Aid Companion – Emergency Guide App

🛠️ License

This project is created for educational purposes.
You are free to modify, reuse, and extend it for academic demonstrations.