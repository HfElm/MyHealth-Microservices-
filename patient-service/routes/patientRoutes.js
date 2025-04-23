const express = require('express');
const router = express.Router();
const Patient = require('../models/Patient');

router.post('/', async (req, res) => {
  const patient = new Patient(req.body);
  await patient.save();
  res.status(201).send(patient);
});

router.get('/', async (req, res) => {
  const patients = await Patient.find();
  res.send(patients);
});

module.exports = router;
