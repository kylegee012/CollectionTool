DROP TABLE IF EXISTS todo;

CREATE TABLE gadget (
  `gadgetId` bigint auto_increment primary key,
  `gadgetName` varchar(256),
);

CREATE TABLE bucket (
  `bucketId` bigint auto_increment primary key,
  `bucketName` varchar(256),
  `gadgetId` bigint,
  FOREIGN KEY (gadgetId) REFERENCES gadget(gadgetId)
);


