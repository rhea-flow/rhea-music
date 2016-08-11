import java.util.concurrent.TimeUnit

import rhea_music.ImplicitConversions._

import scala_dsl.ImplicitConversions._
import scala.languageFeature.implicitConversions._
import org.jfugue.pattern.{Pattern, PatternProducer}
import org.junit.{Before, Test}
import org.rhea_core.Stream
import org.rhea_core.internal.graph.FlowGraph
import org.rhea_core.optimization.OptimizationStrategy
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
    Stream.optimizationStrategy = (graph: FlowGraph) => ()
  }

  @Test
  def jfugue() {

    val s1: PatternStream = ChaosStream.from(
      ChaoticFunction.f1(1.3),
      N = 100
    )
    .mapToRhythm
    .setVoice(1)

    val s2: PatternStream = ChaosStream.from(
      ChaoticFunction.f1(1.5),
      N = 100
    )
    .mapToRhythm
    .setVoice(2)

    val s3: PatternStream = ChaosStream.from(
      ChaoticFunction.f1(1.5),
      N = 50
    )
      .mapToChords
      .setVoice(3)

    s3.withTimestep(1, TimeUnit.SECONDS).play()

    val s4: PatternStream = ChaosStream.from(
      ChaoticFunction.f1(1.5),
      N = 200
    )
      .mapToNotes
      .setVoice(4)

    s4.withTimestep(250, TimeUnit.MILLISECONDS).play()

    Stream.zip[PatternProducer, PatternProducer, PatternProducer](s1, s2, (p1: PatternProducer, p2: PatternProducer) => {
      val pat: Pattern = new Pattern
      pat.add(p1, p2)
      pat
    }: PatternProducer).withTimestep(500, TimeUnit.MILLISECONDS).play()

    Threads.sleep()
  }

}
