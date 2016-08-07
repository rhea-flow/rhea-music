package rhea_music.cellular_automata

import org.rhea_core.Stream
import jm.music.tools.ca.{CellularAutomata => CA}

/**
  * @author Orestis Melkonian
  */
object CellularAutomata {

  def from(x: Int = 10, y: Int = 10, seed: Int = 25, N: Int = 10): Stream[CA] =
    Stream.just[CA](new CA(x, y, seed))
      .loopN((s: Stream[CA]) =>
        s.doOnNext((c: CA) =>
          c.evolve()
        ),
        N - 1
      )

}