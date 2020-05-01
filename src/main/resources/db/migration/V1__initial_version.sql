CREATE TABLE hero (
    id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 11) PRIMARY KEY,
    name LONGVARCHAR
);

INSERT INTO hero (name) VALUES
      ('Mr. Nice'),
      ('Narco'),
      ('Bombasto'),
      ('Celeritas'),
      ('Magneta'),
      ('RubberMan'),
      ('Dynama'),
      ('Dr IQ'),
      ('Magma'),
      ('Tornado');
