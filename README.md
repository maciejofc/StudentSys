# StudentSys
Student System is program which has only one funcionality - logging and registering. The project is based on MVVM pattern.


## Built with
* Scene Builder
* JavaFx 11
* Java SDK 11
* Maven 3.6.3
* MySQL 8.0.24

### Configuration
#### 1. File->Project Settings->Project->Set proper language level and SDK 
#### 1.1 File->Settings->Modules->Dependecies->Set Module SDK
#### 2. To work with Scene Builder | Settings-> Languages & Frameworks->JavaFx->Paste path to Scene Builder
In my Scenario: D:\SceneBuilder\SceneBuilder.exe
#### 3. Run->VM options-> --module path (lib folder of sdk) --add-modules javafx.controls,javafx.fxml
In my scenario it is :--module-path /Users/Dell/Desktop/java-fx/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml 
#### 3.1. Run->VM options-> Set main class
#### 5. To work with database, change static data(password,login) in model.db.JdbcDao 
##### 5.1
 
 ```
CREATE TABLE Persons (
    id int NOT NULL,
    fullname varchar(255) ,
    email varchar(255),
    password varchar(255),
    PRIMARY KEY (id)
);
```
### Inspiration
The concept of MVVM pattern explained by great lecturer : https://www.youtube.com/watch?v=rLRcyshTKwQ 
