create table article
(
    id            int auto_increment
        primary key,
    url           varchar(255) not null,
    title         varchar(255) not null,
    `description` varchar(255) not null,
    image_url      varchar(255) not null
);
