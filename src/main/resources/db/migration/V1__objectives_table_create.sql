CREATE TABLE objective
(
    objective_id SERIAL PRIMARY KEY,
    description  TEXT NOT NULL
);
ALTER SEQUENCE objective_objective_id_seq RESTART 1000000;