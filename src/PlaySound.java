import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class PlaySound extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		
		//final Media media = new Media("http://inception.davepedu.com/inception.mp3");
		final Media media = new Media("http://www.myinstants.com/media/sounds/and-his-name-is-john-cena-1.mp3");
		final MediaPlayer mediaPlayer = new MediaPlayer(media);

		mediaPlayer.play();
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				Platform.exit();
			}
		});

	}
}
