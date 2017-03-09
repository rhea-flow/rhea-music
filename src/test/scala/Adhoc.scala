import jm.constants.Durations._
import jm.music.data._
import org.junit.{Before, Test}
import org.rhea_core.Stream
import rhea_music.ImplicitConversions._
import rhea_music.cellular_automata.{HarmonyMapper, HarmonyRange, CellularAutomata => CA}
import rhea_music.chaos.{ChaosStream, ChaoticFunction, ComplexFunction}
import rhea_music.utils.constants.Chords._
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
  def chaoticMelody() {

    val rhythm: Stream[Double] =
      ChaosStream.from(
        ChaoticFunction.f1(1.7),
        100
      )
      .mapToRhythm(EIGHTH_NOTE_TRIPLET, WHOLE_NOTE)

    val rhythm2: Stream[Double] =
      ChaosStream.from(
        ChaoticFunction.f1(1.5),
        100
      )
      .mapToRhythm(EIGHTH_NOTE_TRIPLET, WHOLE_NOTE)

    val melody: Stream[Note] =
      ChaosStream.from(
        ChaoticFunction.f1(1.7),
        100
      ).mapToTenor

    val melody2: Stream[Note] =
      ChaosStream.from(
        ChaoticFunction.f1(1.7),
        100
      )
      .mapToTenor

    Stream.concat[Part](
      melody.setRhythm(rhythm).toPart,
      melody2.setRhythm(rhythm2).toPart
    )
    /*.audio(Array(
      new VibesInst(8000),
      new BowedPluckInst(8000)
    ))*/
//    .writeMidi("rhythm.midi")
    .notate()
    /*.writeAudio("rhythm.au", Array(
      new VibesInst(8000),
      new BowedPluckInst(8000)
    )*/


    /*.toPhrase
    .map[Score]((p: Phrase) => {
      val score: Score = new Score()
      score.addPart(new Part(p))
      score
    })
    .audio(new HarmonicsInst(8000))*/

    Threads.sleep()
  }

//  @Test
  def complexMelody() {

    val (s1: ChaosStream, s2: ChaosStream) =
      ChaosStream.from(ComplexFunction.f3(A=1.4, B=0.3), N=100)

    val rhythm1 =
      s1.mapToRhythm()

    val melody1 =
      s2.mapToTenor

    val (ss1: ChaosStream, ss2: ChaosStream) =
      ChaosStream.from(ComplexFunction.f3(A=1.1, B=0.3), N=100)

    val rhythm2 =
      ss1.mapToRhythm()

    val melody2 =
      ss2.mapToAlto

    Stream.concat[Part](
      melody1.setRhythm(rhythm1).toPart,
      melody2.setRhythm(rhythm2).toPart
    )
    .notate()
//    .writeMidi("duet.midi")
    /*.audio(Array(
      new VibesInst(8000),
      new HarmonicsInst(8000)
    ))*/
    /*.writeAudio("duet.au", Array(
      new VibesInst(8000),
      new BowedPluckInst(8000)
    ))*/
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
  def ca(): Unit = {
    val mapper: HarmonyMapper = new HarmonyMapper(
      new HarmonyRange(
        0, 0,
        4, 4,
        Cmaj7
      ),
      new HarmonyRange(
        5, 0,
        9, 4,
        Fmaj7
      ),
      new HarmonyRange(
        0, 5,
        4, 9,
        Am9
      ),
      new HarmonyRange(
        5, 5,
        9, 7,
        G7
      ),
      new HarmonyRange(
        5, 8,
        9, 9,
        Bdim7
      )
    )

    CA.from(N=1)
      .mapToHarmony(mapper)
      .toPart
//      .subscribe((p: Part) =>  println(p.getPhraseArray.length))
      .toScore
        .subscribe((s: Score) => println(s.getEndTime))
//      .notate()
//      .count().print()
      /*.setRhythm(
        ChaosStream.from(
          ChaoticFunction.f1(1.5),
          100
        ).mapToRhythm(EIGHTH_NOTE_TRIPLET, WHOLE_NOTE)
      )*/
//      .play()
//    .printAll()
//      .writeMidi("ca.midi")

    Threads.sleep()

  }

//  @Test
  def chord(): Unit = {
    Stream.just(Fmaj7)
        .play()
//      .toPart.print()
//      .notate()

    Threads.sleep()
  }

}
