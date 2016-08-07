import compose.player.{ScalaColliderPlayer, Tempo}

import scala.concurrent.ExecutionContext.Implicits.global
import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._

import org.junit.{Before, Test}
import org.rhea_core.Stream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads

import rhea_music.music_streams.NoteStream
import rhea_music.random.Random._

import compose.core._
import compose.core.Pitch
import compose.core.Score
import compose.core.Pitch._
import compose.core.Score._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


/**
 * @author Orestis Melkonian
 */
class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
  }

  @Test
  def randNotes() {

    NoteStream.randNotes.take(100).play()

    /*// Create a player:
    ScalaColliderPlayer.withPlayer(4) { player: ScalaColliderPlayer =>

      // Start the song playing:
      val playing: Future[ScalaColliderPlayer.State] =
        player.play(E3.q, Tempo(180))

      // Wait for the song to finish:
      Await.result(playing, Duration.Inf)

    }*/

    Threads.sleep()
  }

}
