create table event (event_id varchar(255) not null, created_at datetime(6), updated_at datetime(6), event_capacity integer, event_name varchar(50), event_occupation integer, location varchar(20), time datetime(6), primary key (event_id)) engine=InnoDB;
create table event_ticket (event_id varchar(255) not null, created_at datetime(6), updated_at datetime(6), age integer, event_name varchar(255), name varchar(20), surname varchar(20), ticket_name varchar(255), ticket_price decimal(19,2), primary key (event_id)) engine=InnoDB;
create table event (event_id varchar(255) not null, created_at datetime(6), updated_at datetime(6), event_capacity integer, event_name varchar(50), event_occupation integer, location varchar(20), time datetime(6), primary key (event_id)) engine=InnoDB;
create table event_ticket (event_id varchar(255) not null, created_at datetime(6), updated_at datetime(6), age integer, event_name varchar(255), name varchar(20), surname varchar(20), ticket_name varchar(255), ticket_price decimal(19,2), primary key (event_id)) engine=InnoDB;
