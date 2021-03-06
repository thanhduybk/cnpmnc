package graph.internal.cell;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class CircleCell extends Cell {

    public CircleCell(String id) {
        super(id);

        Circle view = new Circle(20, 20,20);

        view.setStroke(Color.DODGERBLUE);
        view.setFill(Color.DODGERBLUE);

        Text text = new Text(id);
        text.setBoundsType(TextBoundsType.VISUAL);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(view, text);

        setView(stack);
    }
}
