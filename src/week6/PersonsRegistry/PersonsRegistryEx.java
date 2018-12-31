package week6.PersonsRegistry;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PersonsRegistryEx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Registry Persons Application");

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("Add New Person");
        Menu menu2 = new Menu("Registry");

        Button btnAdd = new Button("Add Person");
        Button btnRefresh = new Button("Refresh");
        Tooltip tooltipAdd = new Tooltip("Registry New Person");
        Tooltip tooltipRefresh = new Tooltip("Registry Refresh");
        Tooltip.install(btnAdd, tooltipAdd);
        Tooltip.install(btnRefresh, tooltipRefresh);

        //Group group = new Group();
        menuBar.getMenus().add(menu1);
        menuBar.getMenus().add(menu2);
        HBox hBox = new HBox (btnAdd,btnRefresh);
        hBox.setPadding(new Insets (10));
        hBox.setSpacing(100);
        hBox.setAlignment( Pos.BASELINE_CENTER);

        ListView view = new ListView();
        VBox vBox = new VBox (view);
        vBox.setAlignment( Pos.BASELINE_CENTER);

        //group.getChildren().add(hBox);
        //group.getChildren().add(vBox);
        Scene scene = new Scene(hBox, 960, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
/*
public class PersonsRegistryEx extends Application {
    private BorderPane root;
    private final int SIZE = 60;

    class MyLabel extends Label {

        public MyLabel(String text) {
            super(text);

            setAlignment(Pos.BASELINE_CENTER);
        }
    }

    public static void main ( String[] args ) {
        launch ( args );
    }

    @Override
    public void start ( Stage stage ) {
        initUI(stage);
    }

    private void initUI(Stage stage) {

        HBox root = new HBox(100);
        root.setPadding(new Insets (10));
        root.setAlignment( Pos.BASELINE_CENTER);

        Scene scene = new Scene(root, 1000, 800);

        Button btnAdd = new Button("Add New Person");
        Button btnRefresh = new Button("Refresh Registry");
        Tooltip tooltipAdd = new Tooltip("Registry New Person");
        Tooltip tooltipRefresh = new Tooltip("Registry Refresh");
        Tooltip.install(btnAdd, tooltipAdd);
        Tooltip.install(btnRefresh, tooltipRefresh);
        //ListView view = new ListView();

        root.getChildren().addAll (btnAdd, btnRefresh);



        VBox root2 = new VBox(100);
        root2.setPadding(new Insets (10));
        root2.setAlignment( Pos.BASELINE_CENTER);

        Scene scene2 = new Scene(root2, 1000, 800);

        ListView view = new ListView();
        root2.getChildren().add (view);


        stage.setTitle("Persons Registry For Voting");
        stage.setScene(scene);
        stage.setScene ( scene2 );
        stage.show();
    }

    private Label getTopLabel() {

        Label lbl = new MyLabel("Top");
        lbl.setPrefHeight(SIZE);
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 1 0;"
                + "-fx-border-color: gray; -fx-font-weight: bold");

        return lbl;
    }
} */
