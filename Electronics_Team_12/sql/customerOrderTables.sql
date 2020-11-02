create table ITEM (
	ID int auto_increment primary key,
	ITEM_NUMBER int, NAME varchar(255),
	DESCRIPTION varchar(255),
	AVAILABLE_QUANTITY int,
	UNIT_PRICE double
);

create table CUSTOMER_ORDER (
	ID int auto_increment primary key,
	CUSTOMER_NAME varchar(255),
	CUSTOMER_EMAIL varchar(255),
	SHIPPING_INFO_ID_FK int,
	PAYMENT_INFO_ID_FK int,
	STATUS varchar(255) default 'New'
);

create table CUSTOMER_ORDER_LINE_ITEM (
	ID int auto_increment primary key,
	ITEM_NUMBER int, ITEM_NAME varchar(255),
	QUANTITY int, CUSTOMER_ORDER_ID_FK int
);

create table PAYMENT_INFO (
	ID int auto_increment primary key,
	HOLDER_NAME varchar(255),
	CARD_NUM varchar(255),
	EXP_DATE varchar(255),
	CVV varchar(3)
);

create table SHIPPING_INFO (ID int auto_increment primary key,
	ADDRESS1 varchar(255),
	ADDRESS2 varchar(255),
	CITY varchar(255),
	STATE varchar(255),
	NAME varchar(255),
	POSTAL_CODE varchar(255), 
);