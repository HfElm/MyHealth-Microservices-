const express = require('express');
const axios = require('axios');
const { createProxyMiddleware } = require('http-proxy-middleware');

const app = express();
const port = 3000;

// Définir l'URL des microservices auxquels l'API Gateway redirigera les requêtes
const service1Url = 'http://localhost:8080'; 
const service2Url = 'http://localhost:8081'; 
const service3Url = 'http://localhost:8082';

// Proxy vers le HealthService
app.use('/health-services', createProxyMiddleware({
    target: service1Url,
    changeOrigin: true,
    pathRewrite: { '^/health-services': '' }
  }));
  


// Proxy vers le AppointmentService
app.use('/appointment-service', createProxyMiddleware({
    target: service2Url,
    changeOrigin: true,
    pathRewrite: { '^/appointment-service': '' }
  }));
  
// Proxy vers le AvailabilityService
app.use('/availability-service', createProxyMiddleware({
    target: service3Url,
    changeOrigin: true,
    pathRewrite: { '^/availability-service': '' }
  }));
  

// Route de test
app.get('/', (req, res) => {
  res.send('API Gateway is up and running!');
});

// Démarre le serveur
app.listen(port, () => {
  console.log(`API Gateway running at http://localhost:${port}`);
});
