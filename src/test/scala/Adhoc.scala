import graph_viz.GraphVisualizer
import rhea_music.ImplicitConversions._

import scala_dsl.ImplicitConversions._
import scala.languageFeature.implicitConversions
import scala.languageFeature.implicitConversions._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.chaos.{ChaosStream, ChaoticFunction}
import rhea_music.music_streams.PatternStream



/**
 * @author Orestis Melkonian
 */
class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
  }

//  @Test
  def zip(): Unit = {
  // TODO FIX
    GraphVisualizer.display(
      Stream.zip[Int, Int, Int](
        Stream.range(0, 1),
        Stream.range(0, 1),
        (i1: Int, i2: Int) => i1 + i2 : Int
      )
    )

      Threads.sleep()
  }

  @Test
  def jfugue() {

    ChaosStream.from(
      ChaoticFunction.f1(1.3),
      N = 100
    )
    .mapToNotes
    .setVoice(1)
    .play()

    ChaosStream.from(
      ChaoticFunction.f1(1.5),
      N = 100
    )
    .mapToNotes
    .setVoice(2)
    .play()

    ChaosStream.from(
      ChaoticFunction.f1(1.7),
      N = 100
    )
      .mapToNotes
      .setVoice(3)
      .play()

    /*ChaosStream.from(
      ChaoticFunction.f1(1.3),
      N = 100
    )
      .mapToNotes
      .setVoice(1)
      .play()*/


    Threads.sleep()
  }

}
