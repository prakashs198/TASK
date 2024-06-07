const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');
const mysql = require('mysql2');

const app = express();
const port = 5000;
const secretKey = 'your_secret_key';

const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root123',
  database: 'task2'
});

db.connect(err => {
  if (err) throw err;
  console.log('MySQL Connected...');
});

app.use(cors());
app.use(bodyParser.json());

app.post('/register', (req, res) => {
  const { name, password } = req.body;
  const hashedPassword = bcrypt.hashSync(password, 8);

  const sql = `INSERT INTO users (name, password) VALUES (?, ?)`;
  db.query(sql, [name, hashedPassword], (err, result) => {
    if (err) return res.status(500).send('Server error');
    res.status(200).send({ message: 'User registered successfully!' });
  });
});

app.post('/login', (req, res) => {
  const { name, password } = req.body;
  const sql = `SELECT * FROM users WHERE name = ?`;
  
  db.query(sql, [name], (err, result) => {
    if (err) return res.status(500).send('Server error');
    if (result.length === 0) return res.status(404).send('User not found');

    const user = result[0];
    const passwordIsValid = bcrypt.compareSync(password, user.password);
    if (!passwordIsValid) return res.status(401).send({ auth: false, token: null });

    const token = jwt.sign({ id: user.id }, secretKey, { expiresIn: 86400 });
    res.status(200).send({ auth: true, token });
  });
});

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});
