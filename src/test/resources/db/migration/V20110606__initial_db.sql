CREATE TABLE EmailAddress (
       id SERIAL NOT NULL PRIMARY KEY,
       address VARCHAR(254) NOT NULL UNIQUE
);

CREATE TABLE ActiveEmailAddress (
       e_id INTEGER NOT NULL REFERENCES EmailAddress (id),
       created Timestamp NOT NULL,
       UNIQUE (e_id, created)
);

CREATE TABLE HistoricalEmailAddress (
       id SERIAL NOT NULL PRIMARY KEY,
       e_id INTEGER NOT NULL REFERENCES EmailAddress (id),
       created Timestamp NOT NULL,
       deleted Timestamp NOT NULL,
       UNIQUE (e_id, created, deleted)
);