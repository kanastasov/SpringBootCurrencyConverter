DROP TABLE IF EXISTS TBL_CURRENCIES;
 
CREATE TABLE TBL_CURRENCIES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  currency_from VARCHAR(250) NOT NULL,
  currency_to VARCHAR(250) NOT NULL,
  value VARCHAR(250) DEFAULT NULL
);