CREATE TABLE job_data (
    skill VARCHAR(50),
    industry VARCHAR(50),
    year INT,
    total_employed INT,
    average_salary FLOAT,
    location VARCHAR(50),
    demand_score INT
);

INSERT INTO job_data (skill, industry, year, total_employed, average_salary, location, demand_score) VALUES
('Python', 'Tech', 2022, 100, 900000, 'India', 85),
('Java', 'Tech', 2022, 80, 950000, 'India', 80),
('SQL', 'Finance', 2022, 60, 850000, 'India', 70),
('PowerBI', 'Business', 2022, 40, 800000, 'India', 65),
('React', 'Tech', 2022, 50, 920000, 'India', 75),
('Python', 'Tech', 2023, 120, 950000, 'India', 90),
('Java', 'Tech', 2023, 90, 980000, 'India', 85),
('SQL', 'Finance', 2023, 70, 880000, 'India', 75),
('PowerBI', 'Business', 2023, 50, 820000, 'India', 70),
('React', 'Tech', 2023, 60, 940000, 'India', 80),
('Python', 'Tech', 2024, 130, 970000, 'India', 95),
('Java', 'Tech', 2024, 95, 1000000, 'India', 90),
('SQL', 'Finance', 2024, 75, 900000, 'India', 80),
('PowerBI', 'Business', 2024, 55, 840000, 'India', 75),
('React', 'Tech', 2024, 65, 960000, 'India', 85);

SELECT skill, total_employed
FROM job_data
WHERE year = 2024 AND location = 'India'
ORDER BY total_employed DESC;

SELECT industry, SUM(total_employed) as total_employment
FROM job_data
WHERE year = 2024 AND location = 'India'
GROUP BY industry
ORDER BY total_employment DESC;

SELECT skill, demand_score
FROM job_data
WHERE year = 2024 AND location = 'India'
ORDER BY demand_score DESC;