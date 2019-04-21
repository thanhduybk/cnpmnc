package layout;

import graph.GraphUI;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.Graph;
import observer.Observer;

public class Main extends Application {

    // Graph module
    private GraphUI graphUI = new GraphUI();
    private Graph graphData = new Graph();

    private UserGUIController guiController = new UserGUIController();

    // Must override this method for class that extends Application
    @Override
    public void start(Stage stage) {

        initObserver();

        // Root node
        HBox root = new HBox();

        // Add modules to root
        root.getChildren().addAll(
                graphUI.getView(),
                guiController.getView()
        );

        // Container associated with root node
        Rectangle2D ourScreen = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, ourScreen.getWidth() * 0.9, ourScreen.getHeight() * 0.9);

        // Set the scene for the stage
        stage.setScene(scene);

        // Set stage title
        stage.setTitle("Visualization");

        // Show the window
        stage.show();

    }

    private void initObserver() {
        this.guiController.attachObserver(graphUI);
        this.guiController.attachObserver(graphData);

        this.graphData.attachObserver(graphUI);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
