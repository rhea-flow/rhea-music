import java.io.FileWriter
import java.util.concurrent.TimeUnit

import org.jfugue.integration.MusicXmlParserListener
import org.jfugue.midi.MidiParser
import rhea_music.ImplicitConversions._

import scala_dsl.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import org.jfugue.pattern.{Pattern, PatternProducer}
import org.jfugue.theory.Note
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import org.rhea_core.optimization.OptimizationStrategy
import rx_eval.RxjavaEvaluationStrategy
import test_data.utilities.Threads
import rhea_music.chaos.{ChaosStream, ChaoticFunction}
import rhea_music.music_streams.{DurationStream, PatternStream}


/**
 * @author Orestis Melkonian
 */
class Adhoc {

  @Before
  def setEval(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

  @Test
  def jfugue() {

    ChaosStream.chaoticHarmony(100)
      .play()

//    val s3: PatternStream = ChaosStream.from(
//      ChaoticFunction.f1(1.5),
//      N = 50
//    )
//    .mapToChords
//    .setVoice(3)
//
//    val s4: PatternStream = ChaosStream.from(
//      ChaoticFunction.f1(1.5),
//      N = 50
//    )
//    .mapToNotes
//    .setVoice(4)

//    PatternStream.sync4(s1, s2, s3, s4)

//      PatternStream.sync(s1, s2)
//      .notate("test")

//      .withTimestep(500, TimeUnit.MILLISECONDS).play()

    Threads.sleep()
  }

}
