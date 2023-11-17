CREATE TABLE IF NOT EXISTS public.color (
    dbid INT AUTO_INCREMENT,
    color VARCHAR(20),
    PRIMARY KEY (dbid)
);

INSERT INTO public.color (color) VALUES ('red');
INSERT INTO public.color (color) VALUES ('yellow');
INSERT INTO public.color (color) VALUES ('blue');
INSERT INTO public.color (color) VALUES ('cyan');
INSERT INTO public.color (color) VALUES ('purple');
INSERT INTO public.color (color) VALUES ('black');
INSERT INTO public.color (color) VALUES ('white');

-- Create the car table after the color table
CREATE TABLE IF NOT EXISTS public.car (
    dbid INT AUTO_INCREMENT,
    plate VARCHAR(6) UNIQUE,
    version BIGINT DEFAULT 0,
    color INT,
    PRIMARY KEY (dbid),
    FOREIGN KEY (color) REFERENCES color(dbid)
);

-- Insert data into the car table with color references
INSERT INTO public.car (plate, color) VALUES ('000AAA', 1);
INSERT INTO public.car (plate, color) VALUES ('001AAA', 2);
INSERT INTO public.car (plate, color) VALUES ('002AAA', 3);
