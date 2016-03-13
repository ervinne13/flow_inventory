CREATE TABLE IF NOT EXISTS Users (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,    
    email TEXT UNIQUE,
    is_active INTEGER,
    display_name TEXT,
    password TEXT,
    description TEXT,
    server TEXT
);
