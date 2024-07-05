module org.example.examenpoo {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;


    opens org.example.examenpoo to javafx.fxml;
    exports org.example.examenpoo;
    exports org.example.examenpoo.DataBase;
    opens org.example.examenpoo.DataBase to javafx.fxml;
}