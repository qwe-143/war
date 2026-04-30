const express = require("express");
const app = express();

app.use(express.json()); // to read JSON

// Temporary data (acts like DB)
let students = [];

/* ---------- CRUD APIs ---------- */

// CREATE
app.post("/students", (req, res) => {
  students.push(req.body);
  res.send("Student Added");
});

// READ
app.get("/students", (req, res) => {
  res.json(students);
});

// UPDATE
app.put("/students/:id", (req, res) => {
  const id = req.params.id;
  students[id] = req.body;
  res.send("Student Updated");
});

// DELETE
app.delete("/students/:id", (req, res) => {
  const id = req.params.id;
  students.splice(id, 1);
  res.send("Student Deleted");
});

// Server
app.listen(3000, () => {
  console.log("Server running on port 3000");
});


//mkdir student-api
// //cd student-api
//npm init -y
// npm install express
//node server.js