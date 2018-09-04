create table if not exists trafficconfig
(
    id integer not null,
    day varchar(255) not null,
    starttime TIME(3) not null,
    endtime TIME(3) not null,
    primary key(id)
);