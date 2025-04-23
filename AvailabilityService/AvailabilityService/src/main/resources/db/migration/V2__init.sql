CREATE TABLE t_availability (
    id VARCHAR(36) PRIMARY KEY,
    doctor_id VARCHAR(255) NOT NULL,
    start_time DATETIME NOT NULL,
    end_time DATETIME NOT NULL
);
