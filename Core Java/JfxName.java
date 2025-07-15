import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JfxName extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Letter B
        Rectangle bStem = new Rectangle(20, 50, 10, 100);
        Circle bTop = new Circle(40, 75, 25);
        Circle bBottom = new Circle(40, 125, 25);
        bTop.setFill(Color.TRANSPARENT);
        bTop.setStroke(Color.BLACK);
        bBottom.setFill(Color.TRANSPARENT);
        bBottom.setStroke(Color.BLACK);

        // Letter E
        Rectangle eStem = new Rectangle(80, 50, 10, 100);
        Line eTop = new Line(80, 50, 110, 50);
        Line eMiddle = new Line(80, 100, 100, 100);
        Line eBottom = new Line(80, 150, 110, 150);

        // Letter N
        Line nLeft = new Line(130, 50, 130, 150);
        Line nDiagonal = new Line(130, 50, 160, 150);
        Line nRight = new Line(160, 50, 160, 150);

        // Letter J
        Line jStem = new Line(180, 50, 180, 130);
        Circle jHook = new Circle(180, 150, 20);
        jHook.setFill(Color.TRANSPARENT);
        jHook.setStroke(Color.BLACK);

        // Letter A
        Line aLeft = new Line(210, 150, 230, 50);
        Line aRight = new Line(230, 50, 250, 150);
        Line aMiddle = new Line(220, 100, 240, 100);

        // Letter M
        Line mLeft = new Line(270, 150, 270, 50);
        Line mMiddle = new Line(270, 50, 290, 100);
        Line mRight = new Line(290, 100, 310, 50);
        Line mOuterRight = new Line(310, 50, 310, 150);

        // Letter I
        Rectangle iStem = new Rectangle(330, 50, 10, 100);

        // Letter N
        Line n2Left = new Line(360, 50, 360, 150);
        Line n2Diagonal = new Line(360, 50, 390, 150);
        Line n2Right = new Line(390, 50, 390, 150);

        // Adding all shapes to the pane
        pane.getChildren().addAll(
                bStem, bTop, bBottom,
                eStem, eTop, eMiddle, eBottom,
                nLeft, nDiagonal, nRight,
                jStem, jHook,
                aLeft, aRight, aMiddle,
                mLeft, mMiddle, mRight, mOuterRight,
                iStem,
                n2Left, n2Diagonal, n2Right
        );

        Scene scene = new Scene(pane, 450, 250);
        primaryStage.setTitle("Benjamin in Shapes");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
