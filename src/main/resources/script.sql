create table room
(
  id          bigserial    not null
    constraint room_pkey
      primary key,
  description varchar(355) not null,
  r_user      varchar(50)  not null,
  local_time  timestamp    not null
);

alter table room
  owner to postgres;


