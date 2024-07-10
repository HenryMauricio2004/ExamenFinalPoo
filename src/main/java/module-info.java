module com.mateouca.examen_finalpoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.mateouca.examen_finalpoo to javafx.fxml;
    exports com.mateouca.examen_finalpoo;
}