CREATE TABLE IF NOT EXISTS armor (
                                     id BIGINT PRIMARY KEY,
                                     name VARCHAR(255) NOT NULL,
                                     icon LONGTEXT NOT NULL,
                                     picture LONGTEXT NOT NULL,
                                     type VARCHAR(255) NOT NULL,
                                     predicat LONGTEXT NOT NULL,
                                     exoticicon LONGTEXT NOT NULL,
                                     perkname VARCHAR(255) NOT NULL,
                                     perkdesc LONGTEXT NOT NULL,
                                     forclass VARCHAR(255) NOT NULL,
                                     lore LONGTEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS dungeon (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         icon LONGTEXT NOT NULL,
                         predicat LONGTEXT NOT NULL,
                         diff INT NOT NULL
);

CREATE TABLE IF NOT EXISTS dungeonenc (
                            id BIGINT PRIMARY KEY AUTO_INCREMENT,
                            iddungeon BIGINT NOT NULL,
                            encounternumber INT NOT NULL,
                            encountername LONGTEXT NOT NULL,
                            encounterdesc LONGTEXT NOT NULL,
                            FOREIGN KEY (iddungeon) REFERENCES dungeon(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS raid (
                      id BIGINT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL,
                      icon LONGTEXT NOT NULL,
                      predicat LONGTEXT NOT NULL,
                      diff INT NOT NULL
);

CREATE TABLE IF NOT EXISTS raidenc (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         idraid BIGINT NOT NULL,
                         encounternumber INT NOT NULL,
                         encountername VARCHAR(255) NOT NULL,
                         encounterdesc LONGTEXT NOT NULL,
                         FOREIGN KEY (idraid) REFERENCES raid(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS triumph (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         icon LONGTEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS triumphtasks (
                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                              fortriumph BIGINT NOT NULL,
                              triumphnumber INT NOT NULL,
                              triumphname VARCHAR(255) NOT NULL,
                              triumphdesc LONGTEXT NOT NULL,
                              FOREIGN KEY (fortriumph) REFERENCES triumph(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS weapon (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(255) NOT NULL,
                        icon LONGTEXT,
                        picture LONGTEXT,
                        type VARCHAR(255) NOT NULL,
                        element VARCHAR(255),
                        predicat LONGTEXT,
                        isexotic BOOLEAN,
                        exoticicon LONGTEXT,
                        perkname VARCHAR(255),
                        perkdesc LONGTEXT,
                        lore LONGTEXT
);

CREATE TABLE IF NOT EXISTS weaponstats (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             weapon_id BIGINT NOT NULL,
                             impact INT,
                             range_ INT,
                             stability INT,
                             handling INT,
                             reloadspeed INT,
                             aimassist INT,
                             airborne INT,
                             rpm INT,
                             mag INT,
                             FOREIGN KEY (weapon_id) REFERENCES weapon(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS news (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             article longtext NOT NULL,
                             date DATE NOT NULL,
                             link_ longtext NOT NULL
);