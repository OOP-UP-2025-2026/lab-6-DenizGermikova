package ua.opnu.list;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * Цей клас успадковується від стандартного класу Application.
 * Клас Application відповідає за роботу FX-додатку.
 * Якщо ви пишете додаток з використанням бібліотеки javaFX, то ви
 * повинні створити свій клас, який успадковується від класу Application
 */
public class SortingList extends Application {

    // Список студентів.
    // Інтерфейс ObservableList схожий на інтерфейс List, але
    // має можливість оповіщати інші об'єкти у тому, що він змінився
    private ObservableList<Student> students;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Заголовок вікна
        primaryStage.setTitle("Список студентів");

        // Заповнюємо список студентів даними
        students = populateList();

        // Це вертикальний ряд із елементами
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(5));
        vbox.setAlignment(Pos.CENTER);

        // Це віджет списку для відображення даних
        final ListView<Student> listView = new ListView<>(students);
        listView.setPrefSize(400, 240);

        // Настроюємо горизонтальний ряд кнопок
        final HBox hbox = setButtons();

        // Додаємо зверху віджет списку, після чого додаємо рядок з кнопками
        vbox.getChildren().addAll(listView, hbox);

        // Створюємо сцену і додаємо її до Stage
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Заповнюємо список даними вручну
    private ObservableList<Student> populateList() {
        Student student1 = new Student("Борис", "Іванов", 75);
        Student student2 = new Student("Петро", "Петренко", 92);
        Student student3 = new Student("Сергій", "Сергієнко", 61);
        Student student4 = new Student("Григорій", "Сковорода", 88);

        return FXCollections.observableArrayList(
                student1, student2, student3, student4);
    }

    // Налаштовуємо кнопки
    private HBox setButtons() {
        final Button sortByNameButton = new Button("Сортувати за ім'ям");
        final Button sortByLastNameButton = new Button("Сортувати за прізвищем");
        final Button sortByMarkButton = new Button("Сортувати за оцінкою");

        HBox.setHgrow(sortByNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByLastNameButton, Priority.ALWAYS);
        HBox.setHgrow(sortByMarkButton, Priority.ALWAYS);

        sortByNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByLastNameButton.setMaxWidth(Double.MAX_VALUE);
        sortByMarkButton.setMaxWidth(Double.MAX_VALUE);

        // Змінна для перемикання порядку сортування
        final boolean[] order = {true};

        // Обробка натискання на кнопку "Сортувати за ім'ям"
        sortByNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new NameSorter(order[0]));
                order[0] = !order[0];
            }
        });

        // Обробка натискання на кнопку "Сортувати за прізвищем"
        sortByLastNameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new SurnameSorter(order[0]));
                order[0] = !order[0];
            }
        });

        // Обробка натискання на кнопку "Сортувати за оцінкою"
        sortByMarkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                students.sort(new AverageSorter(order[0]));
                order[0] = !order[0];
            }
        });

        // Створюємо горизонтальний ряд і додаємо кнопки
        HBox hb = new HBox();
        hb.setSpacing(5);
        hb.getChildren().addAll(sortByNameButton, sortByLastNameButton, sortByMarkButton);
        hb.setAlignment(Pos.CENTER);

        return hb;
    }

    public static void main(String[] args) {
        // Метод запускає додаток
        launch(args);
    }
}
