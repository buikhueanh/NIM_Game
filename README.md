# 🎮 NIM Game with Java & AI (Minimax + Alpha-Beta Pruning)

A console-based implementation of the classic **NIM stick game** with three modes: *Easy*, *Hard*, and *AI-Implemented*. This project showcases your understanding of user input validation, turn-based game logic, and artificial intelligence via the **Minimax algorithm** enhanced with **alpha-beta pruning**.

---

## 🧠 Game Overview

In NIM, players take turns removing 1 to `k` sticks from a pile. The player who removes the **last stick wins**. This Java-based implementation provides:

- 🎯 Easy Mode: computer moves randomly
- 🧠 Hard Mode: computer uses optimal modulo strategy
- 🤖 AI Mode: computer uses **Minimax with Alpha-Beta Pruning** to compute perfect moves

---

## ⚙️ Core Features

- ✅ Customizable start and max-move settings
- 👤 Human vs. Computer gameplay
- 🎮 3 Difficulty Modes:
  - *Easy*: Random moves
  - *Hard*: Modulo strategy to maintain winning positions
  - *AI*: Minimax + Alpha-Beta pruning for optimal decision-making
- 🧪 Robust input validation and user feedback
- 📉 Real-time visualization of remaining sticks

---

## 📂 Project Structure

```
NIM_Game/
│
├── Driver.java # Handles setup: user input, game mode selection
├── Game.java # Main game engine: gameplay, logic, AI, display
```
