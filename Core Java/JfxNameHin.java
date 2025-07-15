import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle; 
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JfxNameHin extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // ब
        Line bStem = new Line(20, 50, 20, 150);
        Arc bTop = new Arc(40, 75, 20, 20, 0, -180);
        bTop.setType(ArcType.OPEN);
        bTop.setStroke(Color.BLACK);
        bTop.setFill(Color.TRANSPARENT);
        Line bBottom = new Line(40, 75, 40, 150);

        // े
        Arc eArc = new Arc(80, 50, 20, 20, 30, 120);
        eArc.setType(ArcType.OPEN);
        eArc.setStroke(Color.BLACK);
        eArc.setFill(Color.TRANSPARENT);

        // ं
        Circle dot = new Circle(100, 30, 5);
        dot.setFill(Color.BLACK);

        // ज
        Line jStem = new Line(130, 50, 130, 150);
        Arc jBottom = new Arc(130, 150, 20, 20, 180, 180);
        jBottom.setType(ArcType.OPEN);
        jBottom.setStroke(Color.BLACK);
        jBottom.setFill(Color.TRANSPARENT);

        // ा
        Line aaStem = new Line(160, 50, 160, 150);
        Arc aaArc = new Arc(180, 100, 20, 20, -90, 180);
        aaArc.setType(ArcType.OPEN);
        aaArc.setStroke(Color.BLACK);
        aaArc.setFill(Color.TRANSPARENT);

        // म
        Line mStem = new Line(210, 50, 210, 150);
        Arc mTop = new Arc(230, 100, 20, 20, -90, 180);
        mTop.setType(ArcType.OPEN);
        mTop.setStroke(Color.BLACK);
        mTop.setFill(Color.TRANSPARENT);
        Line mRight = new Line(250, 50, 250, 150);

        // ि
        Line iStem = new Line(270, 50, 270, 150);
        Arc iArc = new Arc(290, 50, 20, 20, -90, 180);
        iArc.setType(ArcType.OPEN);
        iArc.setStroke(Color.BLACK);
        iArc.setFill(Color.TRANSPARENT);

        // न
        Line nStem = new Line(310, 50, 310, 150);
        Arc nArc = new Arc(330, 100, 20, 20, -90, 180);
        nArc.setType(ArcType.OPEN);
        nArc.setStroke(Color.BLACK);
        nArc.setFill(Color.TRANSPARENT);
        Line nRight = new Line(350, 50, 350, 150);

        // Adding all shapes to the pane
        pane.getChildren().addAll(
                bStem, bTop, bBottom,
                eArc, dot,
                jStem, jBottom,
                aaStem, aaArc,
                mStem, mTop, mRight,
                iStem, iArc,
                nStem, nArc, nRight
        );

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle("benjamin in hindi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
