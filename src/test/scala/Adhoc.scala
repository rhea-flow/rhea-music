import jm.constants.Instruments._
import jm.constants.ProgramChanges
import jm.music.data.{Part, Phrase, Score}
import org.junit.Test
import org.rhea_core.Stream
import rx_eval.RxjavaEvaluationStrategy
import rhea_music.MusicStreams._
import test_data.utilities.Threads

import scala_dsl.ImplicitConversions._

/**
 * @author Orestis Melkonian
 */
class Adhoc {
  @Test
  def twelveTone() {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy

    val R: Double = 1.5

    NoteStream
      .generateChaoticMelody(
        (x: Double) => 1 - R * x * x,
//        (x: Double) => R * x * (1 - x),
//        (i: Double) => 1 - R * i * i,
        init = 0.4,
        N = 100
      )
      .transpose(-5)
      .toPart(ProgramChanges.CLEAN_GUITAR)
      .play()
      /*.toPhrase
      .map[Score]((p: Phrase) => {
        val score: Score = new Score()
        score.addPart(new Part(p))
        score
      })
      .audio(new BreathyFluteInst(8000))*/

    Threads.sleep()
  }
}
