CREATE TABLE t_appoinments (

   id VARCHAR(36) PRIMARY KEY,
   patient_id VARCHAR(255) NOT NULL,
   doctor_id VARCHAR(255) NOT NULL,
   appointment_time DATETIME NOT NULL,
   status VARCHAR(255)

);
