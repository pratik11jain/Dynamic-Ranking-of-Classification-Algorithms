drop database droca;
CREATE DATABASE DROCA;
USE DROCA;

CREATE TABLE RF_table(Dname varchar(50) NOT NULL,ACC10 float NOT NULL,ACC5 FLOAT NOT NULL,prec float not null);

Create table passtab(name varchar(20) ,pass varchar(20) ,flag boolean);
INSERT INTO passtab VALUES("droca","droca",true);
INSERT INTO passtab VALUES("user","user",false);
CREATE TABLE DATASET(Did INT PRIMARY KEY,NAME VARCHAR(100) NOT NULL);

CREATE TABLE CLASSIFIER(Cid INT NOT NULL PRIMARY KEY,NAME VARCHAR(20) NOT NULL);

CREATE TABLE Sorted_best_accd1(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_best_accd2(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_best_accd3(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_best5(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);


CREATE TABLE Sorted_best_acc(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_bestp(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_bestr(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);

CREATE TABLE Sorted_best_time(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);


CREATE TABLE Sorted_bestpra(Did INT NOT NULL ,Best1 varchar(20) not null,Best2 varchar(20) not null,Best3 varchar(20) not null,Best4 varchar(20) not null,Best5 varchar(20) not null,Best6 varchar(20) not null,Best7 varchar(20) not null,Best8 varchar(20) not null,Best9 varchar(20) not null,Best10 varchar(20) not null);



CREATE TABLE CHAR_TAB(Did INT,NO_attr INT NOT NULL,no_inst int not null,no_symb int not null,no_num int not null,misval int not null,distval int not null,mispercent float not null,dimen float not null,symbpercent float not null,numpercent float not null,kurt float not null,skew float not null,maxprob float not null,no_class int not null ,std_dev float not null,snr float not null,entropy float not null,FOREIGN KEY(DID) REFERENCES DATASET(DID));

CREATE TABLE NORM_TAB(Did INT NOT NULL PRIMARY KEY,NO_attr float NOT NULL,no_inst float not null,no_symb float not null,no_num float not null,misval float not null,distval float not null,mispercent float not null,dimen float not null,symbpercent float not null,numpercent float not null,kurt float not null,skew float not null,maxprob float not null,no_class int not null ,std_dev float not null,snr float not null,entropy float not null,FOREIGN KEY(DID) REFERENCES DATASET(DID));


create table dataset_table(Did INT NOT NULL,Cid INT NOT NULL ,ACCURACY FLOAT NOT NULL,Prec FLOAT NOT NULL ,Recall FLOAT NOT NULL  ,TRAINING_TIME FLOAT NOT NULL,TESTING_TIME5 FLOAT NOT NULL,TESTING_TIME10 FLOAT NOT NULL,ACCURACY5 FLOAT NOT NULL,PRIMARY KEY(DID,CID)); 



INSERT INTO RF_table values("anneal",98.88,99.66,0.989);
INSERT INTO RF_table values("audiology",77.43,99.66,0.72);
INSERT INTO RF_table values("balance-scale",80.96,80.64,0.821);
INSERT INTO RF_table values("breast-cancer",67.83,68.88,0.659);
INSERT INTO RF_table values("breast-w",95.13,96.28,0.951);
INSERT INTO RF_table values("bridges_version1",53.33,52.38,0.454);
INSERT INTO RF_table values("bridges_version2",51.42,56.19,0.559);
INSERT INTO RF_table values("car",94.04,92.41,0.94);
INSERT INTO RF_table values("colic",84.78,86.14,0.847);
INSERT INTO RF_table values("credit-a",85.09,84.63,0.851);
INSERT INTO RF_table values("credit-g",73.6,74.1,0.718);
INSERT INTO RF_table values("cylinder-bands",75.37,70.37,0.768);
INSERT INTO RF_table values("diabetes",73.95,75.52,0.733);
INSERT INTO RF_table values("ecoli",84.82,84.22,0.837);
INSERT INTO RF_table values("flags",61.85,53.6,0.574);
INSERT INTO RF_table values("glass",75.23,77.57,0.741);
INSERT INTO RF_table values("heart-c",82.50,80.19,0.825);
INSERT INTO RF_table values("heart-h",80.95,78.91,0.807);
INSERT INTO RF_table values("heart-statlog",81.11,76.66,0.811);
INSERT INTO RF_table values("hepatitis",85.80,84.51,0.848);
INSERT INTO RF_table values("hypothyroid",99.2,98.96,0.991);
INSERT INTO RF_table values("ionosphere",92.87,91.73,0.929);
INSERT INTO RF_table values("iris",94,95.33,0.94);
INSERT INTO RF_table values("labor",84.21,89.47,0.845);
INSERT INTO RF_table values("lymph",83.78,77.02,0.816);
INSERT INTO RF_table values("segment",97.66,97.14,0.977);
INSERT INTO RF_table values("sick",98.11,98.03,0.981);
INSERT INTO RF_table values("sonar",80.76,81.25,0.808);
INSERT INTO RF_table values("soybean",90.77,93.55,0.916);
INSERT INTO RF_table values("sponge",94.73,94.73,0.911);
INSERT INTO RF_table values("tic-tac-toe",92.27,89.45,0.922);
INSERT INTO RF_table values("ToPlayOrNotToPlay",64.28,57.14,0.629);
INSERT INTO RF_table values("trains",40,70,0.400);
INSERT INTO RF_table values("vehicle",75.05,74.70,0.741);
INSERT INTO RF_table values("vote",95.4,96.09,0.954);
INSERT INTO RF_table values("vowel",95.45,93.93,0.955);
INSERT INTO RF_table values("weather",57.14,50,0.528);
INSERT INTO RF_table values("zoo",91.08,86.13,0.924);
INSERT INTO RF_table values("anneal.ORIG",94.87,94.32,0.948);
INSERT INTO RF_table values("arrhythmia",64.82,65.48,0.561);
INSERT INTO RF_table values("autos",83.41,80.97,0.836);
INSERT INTO RF_table values("cmc",50.57,49.96,0.500);
INSERT INTO RF_table values("colic.ORIG",69.83,69.83,0.690);
INSERT INTO RF_table values("dermatology",95.90,94.80,0.960);
INSERT INTO RF_table values("haberman",66.33,70.58,0.637);
INSERT INTO RF_table values("hayes-roth_test",42.85,42.85,0.411);
INSERT INTO RF_table values("hayes-roth_train",81.81,81.06,0.818);
INSERT INTO RF_table values("heart-statlog",77.77,79.25,0.780);
INSERT INTO RF_table values("kr-vs-kp",98.71,98.49,0.987);
INSERT INTO RF_table values("liver-disorders",68.40,67.53,0.691);
INSERT INTO RF_table values("lung-cancer",71.87,68.75,0.694);
INSERT INTO RF_table values("tae",65.56,62.25,0.658);
INSERT INTO RF_table values("spect_train",60,66.25,0.575);
INSERT INTO RF_table values("spect_test",65.77,64.70,0.657);
INSERT INTO RF_table values("solar-flare_1",96.90,99.28,0.978);
INSERT INTO RF_table values("solar-flare_2",99.43,99.43,0.991);
INSERT INTO RF_table values("shuttle-landing-control",93.33,93.33,0.871);
INSERT INTO RF_table values("primary-tumor",40.70,40.70,0.370);
INSERT INTO RF_table values("postoperative-patient-data",64.44,60.00,0.497);
INSERT INTO RF_table values("molecular-biology_promoters",29.24,28.30,0.271);
INSERT INTO RF_table values("mfeat-morphological",69.35,69.40,0.695);

INSERT INTO Classifier VALUES(1,"NB"); 
INSERT INTO Classifier VALUES(2,"Simplelogistic");
INSERT INTO Classifier VALUES(3,"SMO");
INSERT INTO Classifier VALUES(4,"IBK");
INSERT INTO Classifier VALUES(5,"ADABOOST");
INSERT INTO Classifier VALUES(6,"LOGITBOOST");
INSERT INTO Classifier VALUES(7,"PART");
INSERT INTO Classifier VALUES(8,"J48");
INSERT INTO Classifier VALUES(9,"RaF");
INSERT INTO Classifier VALUES(10,"BAGGING");

commit;
