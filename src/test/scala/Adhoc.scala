import graph_viz.GraphVisualizer

import scala_dsl.ImplicitConversions._
import rhea_music.ImplicitConversions._
import jm.constants.Instruments._
import jm.constants.ProgramChanges
import jm.music.data.{Note, Part, Phrase, Score}
import jm.constants.Pitches._
import org.junit.Test
import org.rhea_core.Stream
import rx_eval.RxjavaEvaluationStrategy
import rhea_music.{ChaoticFunctions, ChaoticMelodies}
import test_data.utilities.Threads


/**
 * @author Orestis Melkonian
 */
class Adhoc {

//  @Test
  def chaoticMelody() {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy


    ChaoticMelodies.generateChaoticMelody(
      func = ChaoticFunctions.f1(1.7),
      init = 0.4,
      N = 100
    )
//    .transpose(-5)

    /*.toPart(ProgramChanges.CLEAN_GUITAR)
    .play()*/

    .toPhrase
    .map[Score]((p: Phrase) => {
      val score: Score = new Score()
      score.addPart(new Part(p))
      score
    })
    .audio(new HarmonicsInst(8000))

    Threads.sleep()
  }

//  @Test
  def zip(): Unit = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy

    Stream.zip[Int, Int, Int](
      Stream.just(0,1,2),
      Stream.range(0, 10),
      (i1: Int, i2: Int) => i1 + i2 : Int
    ).printAll()
  }

  @Test
  def complexMelody() {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy

    val (s1: Stream[Note], s2: Stream[Note]) =
      ChaoticMelodies.generateComplexMelody(
        func = ChaoticFunctions.f3(1.4, 0.3),
        init = (0, 0),
        N = 100,
        rangeMinX = -1.28,
        rangeMaxX = 1.28,
        rangeMinY = -0.35,
        rangeMaxY = 0.35,

        pitchMinX = E5,
        pitchMaxX = E7,
        pitchMinY = E1,
        pitchMaxY = E3
      )

    Stream.concat[Part](
      s1.randomRhythm().toPart,
      s2.randomRhythm(0.6).toPart
    ).toScore
      .writeAudio("duet.au", Array(
        new VibesInst(8000),
        new BowedPluckInst(8000)
      ))
      //.play()

    /*Stream.zip[Part, Part, Integer](
      s1.toPart(ProgramChanges.ACOUSTIC_GRAND),
      s2.toPart(ProgramChanges.ALTO_SAXOPHONE),
      (part1: Part, part2: Part) => {
        /*val score: Score = new Score()
        println("S: " + score)
        score.addPart(part1)
        score.addPart(part2)
        score*/
        1
      } : Integer
    ).printAll()//.play()*/

    Threads.sleep()
  }

//  @Test
  def range() = {
    Stream.evaluationStrategy = new RxjavaEvaluationStrategy

    Stream.just((0.0, 0.0)).loop(
      (entry: Stream[(Double, Double)]) => {
        entry.map((p: (Double, Double)) => {
          (1.0 + p._2 - 1.4 * p._1 * p._1, 0.3 * p._1)
        } : (Double, Double))
      } : Stream[(Double, Double)]).print()
  }
}
