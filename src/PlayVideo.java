import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * A sample media player which loops indefinitely over the same video or naw
 */
public class PlayVideo extends Application {
	private static final String MEDIA_URL = "http://instantcena.com/media/cena.mp4";
	//private static final String MEDIA_URL = "http://inception.davepedu.com/inception.mp3";

	public static void main(String[] args) {
		launch();
	}

	@Override public void start(Stage stage) {
		stage.setTitle("DOO DOOO DO DOOO");
		stage.getIcons().add(new Image("http://a3.files.biography.com/image/upload/c_fill,cs_srgb,dpr_1.0,g_face,h_300,q_80,w_300/MTIwNjA4NjMzNzAzNzI4NjUy.jpg"));

		// Create media player
		Media media = new Media(MEDIA_URL);

		javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(javafx.scene.media.MediaPlayer.INDEFINITE);

		// Print track and metadata information
		/*media.getTracks().addListener(new ListChangeListener<Track>() {
			public void onChanged(Change<? extends Track> change) {
				System.out.println("Track> "+change.getList());
			}
		});
		media.getMetadata().addListener(new MapChangeListener<String,Object>() {
			public void onChanged(MapChangeListener.Change<? extends String, ? extends Object> change) {
				System.out.println("Metadata> "+change.getKey()+" -> "+change.getValueAdded());
			}
		});*/

		// Add media display node to the scene graph
		MediaView mediaView = new MediaView(mediaPlayer);
		Group root = new Group();

		Scene scene = new Scene(root,1280,720);

		root.getChildren().add(mediaView);
		stage.setScene(scene);
		stage.show();
		mediaPlayer.setOnEndOfMedia(new Runnable() {
			@Override public void run() {
				Platform.exit();
			}
		});
	}


}