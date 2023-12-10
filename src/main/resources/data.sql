INSERT INTO armor (id, name, icon, picture, type, predicat, exoticicon, perkname, perkdesc, forclass, lore) VALUES
                                         (1,
                                          'Звездный Полуночник',
                                          'https://www.bungie.net/common/destiny2_content/icons/a7c3ee955c5e8b1c20122206d1bf60ff.jpg',
                                          'https://bungie.net/common/destiny2_content/screenshots/1321354573.jpg',
                                          'Шлем',
                                          'Тебя ведет звездный свет. Никакой вакуум тебе не помеха.
«Я отбрасываю в сторону свой панцирь, чтобы возродиться, как и наш славный Риис», – Атракс-1, падшая экзо
У меня не хватит мастерства починить Галанор
…Я что-нибудь придумаю.","Вот что поможет мне одолеть Геракла.
Замечай опасность, даже когда она не замечает тебя.
Это честь для меня. — Чалко Йонг — Икоре Рей
Никогда, никогда не оглядывайся.',
                                          'https://www.bungie.net/common/destiny2_content/icons/22e4a1934ecb6b95295ebcc2d5139ff4.png',
                                          'Орлиный глаз',
                                          'Модифицирует Золотой пистолет так, чтобы он делал мощный одиночный выстрел. Враги, уничтоженные выстрелом, взрываются и восстанавливают энергию суперспособности.\n',
                                          'Охотник',
                                          'Тебя ведет звездный свет. Никакой вакуум тебе не помеха.
Я стою на земле наполовину в защите Мэв. К счастью, внутри моя верхняя половина. Звезды надо мной гаснут одна за другой, но, возможно, это просто слизь одержимых заслоняет обзор.
Этот гигантский одноглазый урод, которого мы разбудили, совсем не рад нас видеть. Это не входило в наши планы. Мы просто хотели его ограбить.
На Луне пусто. Рог затупился. Мэв то ли смеется, то ли умоляет о пощаде, поливая округу свинцом. Она проплывает мимо псионов, которые постоянно делятся. ХВАТИТ ДЕЛИТЬСЯ.
У нас осталось совсем мало времени. Это наш последний шанс.
Я показываю уроду средний палец.Один раскаленный докрасна палец.');

-- Inserting a record into dungeon table
INSERT INTO dungeon (name, icon, predicat, diff) VALUES
    ('Example Dungeon', 'Icon URL', 'Example Predicate', 3);

-- Retrieving the inserted dungeon id for reference in dungeonenc table
SET @last_dungeon_id = LAST_INSERT_ID();

-- Inserting a record into dungeonenc table
INSERT INTO dungeonenc (iddungeon, encounternumber, encountername, encounterdesc) VALUES
    (@last_dungeon_id, 1, 'Encounter 1', 'Description for Encounter 1');

-- Inserting a record into raid table
INSERT INTO raid (name, icon, predicat, diff) VALUES
    ('Example Raid', 'Icon URL', 'Example Predicate', 5);

-- Retrieving the inserted raid id for reference in raidenc table
SET @last_raid_id = LAST_INSERT_ID();

-- Inserting a record into raidenc table
INSERT INTO raidenc (idraid, encounternumber, encountername, encounterdesc) VALUES
    (@last_raid_id, 1, 'Encounter 1', 'Description for Encounter 1');

-- Inserting a record into triumph table
INSERT INTO triumph (name, icon) VALUES
    ('Example Triumph', 'Icon URL');

-- Retrieving the inserted triumph id for reference in triumphtasks table
SET @last_triumph_id = LAST_INSERT_ID();

-- Inserting a record into triumphtasks table
INSERT INTO triumphtasks (fortriumph, triumphnumber, triumphname, triumphdesc, isdone) VALUES
    (@last_triumph_id, 1, 'Task 1', 'Description for Task 1', false);

-- Inserting a record into weapon table
INSERT INTO weapon (name, icon, picture, type, element, predicat, isexotic, exoticicon, perkname, perkdesc, lore) VALUES
    ('Example Weapon', 'Icon URL', 'Picture URL', 'Type Example', 'Element Example', 'Predicat Example', true, 'Exotic Icon URL', 'Perk Name Example', 'Perk Description Example', 'Lore Example');

-- Retrieving the inserted weapon id for reference in weaponstats table
SET @last_weapon_id = LAST_INSERT_ID();

-- Inserting a record into weaponstats table
INSERT INTO weaponstats (weapon_id, impact, range_, stability, handling, reloadspeed, aimassist, airborne, rpm, mag) VALUES
    (@last_weapon_id, 10, 50, 70, 80, 100, 90, 20, 600, 30);