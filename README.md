# **Object-Oriented Programming Lab (OOPlab)**  

This repository contains three Java applications developed as part of an **Object-Oriented Programming (OOP)** course. 
The projects demonstrate key **OOP principles**, such as **encapsulation, inheritance, polymorphism, event handling, and graphical user interface (GUI) programming**.  

---

## **Applications**  

### **Application One: Vacuum Cleaner Simulation - package V1**  
**Description:**  
A **vacuum cleaner** in the shape of a triangle moves around the window, collecting **black circles** that appear when the user clicks the left mouse button.
Every **10 seconds**, the vacuum cleaner automatically moves to the **left corner** to **recharge its battery**.  

**Features:**  
✔️ Interactive **mouse-controlled** object spawning  
✔️ Automated **movement and obstacle interaction**  
✔️ Periodic **battery recharge behavior**  
✔️ **Graphical user interface (GUI)** using Java Awt  

**Usage:**  
1. **Run** `GrafickaSimulacija.java` as a Java application.  
2. **Click the left mouse button** to generate black circles.  
3. The **vacuum cleaner will move and collect** the circles.  
4. Every **10 seconds**, the vacuum cleaner will **recharge** itself.  

---

### **Application Two: Canalization Pipe Grid - package v2**  
**Description:**  
A **grid layout** where the user can add **canalization pipes** by pressing a button. 
The system simulates the **placement and connection** of pipes to form a pipeline network within the grid.  

**Features:**  
✔️ **Grid-based layout** for easy pipe placement  
✔️ **Button-controlled pipe addition**  
✔️ **Dynamic pipe connections** to form a canalization system  
✔️ **Graphical user interface (GUI)** using Java Awt 

## **Usage**  
1. **Run** `Aplikacija.java` as a Java application.  
2. Choose which **pipe type** you want to place.  
3. Click the **"Add Pipe"** button to place a new pipe on the grid.  
4. Pipes will be positioned sequentially to form a **pipeline structure**. 

---

### **Application Three: Game of Balls - package v3**  
**Description:**  
Game of Balls is an interactive game where your goal is to **break all the bricks** by controlling bouncing balls. 
You can move the **blue paddle** using the **'A'** and **'D'** keys to deflect balls and break bricks.  
- When a brick is hit, it **changes color to gray** and falls down.  
- You can add **multiple balls** by pressing **left-click**, and each new ball starts moving in a **random direction**.  
- Balls bounce off all window edges **except the bottom**, where they disappear.  

**Features:**  
✔️ **Multithreading System**: Each ball runs on a separate thread, ensuring smooth gameplay.  
✔️ **Physics Simulation**: The balls bounce realistically off surfaces.  
✔️ **Dynamic Gameplay**: Add unlimited balls to increase your chances of breaking all bricks.  
✔️ **Graphical user interface (GUI)** using Java Awt.  

## **Usage**  
1. **Run** `IgraLoptica.java` as a Java application.  
2. **Launch Balls**: Press **left-click** to spawn a new ball.  
3. **Move the Paddle**: Use the **'A'** and **'D'** keys to control the **blue paddle**.  
4. **Break All Bricks**: Aim to destroy all bricks before you run out of balls.  
5. **Adjust Your Strategy**: If you need more balls, just add them!

---

## **Technologies Used**  
- **Java** (Object-Oriented Programming)  
- **Awt** (Graphical User Interface)  
- **Event Handling** (Mouse & Timer events)

## **Future Improvements**  
💡 **Vacuum Cleaner Simulation:**  
- Introduce **different object types** (e.g., obstacles the vacuum must avoid).  
- Implement **power-ups** that give the vacuum special abilities.  
- Add **sound effects** when the vacuum collects objects.  
- Improve **battery mechanics** (e.g., battery level display, variable depletion rates).  

💡 **Canalization Pipe Grid:**  
- Enable **drag-and-drop** functionality for manual pipe placement.  
- Add **different pipe types** with unique properties (e.g., curved pipes).  
- Implement a **water flow simulation** to check if the pipeline works correctly.  
- Introduce **level-based challenges** (e.g., complete a pipeline under a time limit).

💡 **Game of Balls:**  
- **Power-Ups**: Add special items that drop when breaking bricks (extra balls, paddle size increase, slow-motion, etc.).  
- **Scoring System**: Introduce a points system based on bricks destroyed.  
- **Lives System**: Give players limited attempts before game over.  
- **Different Ball Speeds**: Some balls could move faster/slower for added challenge.  
- **Varied Brick Types**: Implement bricks that take multiple hits to break or provide power-ups.  
- **Sound Effects & Music**: Add game sounds for better immersion.  
- **Levels & Progression**: Introduce multiple levels with increasing difficulty.
