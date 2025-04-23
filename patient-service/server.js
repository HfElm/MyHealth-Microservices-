const express = require('express');
const mongoose = require('mongoose');
const patientRoutes = require('./routes/patientRoutes');

const app = express();
app.use(express.json());
app.use('/patients', patientRoutes);

app.get('/', (req, res) => {
    res.send('Patient Service is running!');
  });
  

mongoose.connect('mongodb://mongo:27017/patientdb')
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.error('MongoDB connection error:', err));

app.listen(3001, () => console.log('Patient Service on port 3001'));
