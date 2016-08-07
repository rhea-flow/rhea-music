import org.junit.{Before, Test}
import org.rhea_core.Stream
import rhea_music.ImplicitConversions._
import rhea_music.music_streams.NoteStream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads


/**
 * @author Orestis Melkonian
 */
class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
  }

  @Test
  def jfugue() {
    NoteStream.randNotes.take(1000).play()

    Threads.sleep()
  }

}
