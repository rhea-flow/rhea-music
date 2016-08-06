package rhea_music.cellular_automata

import jm.music.tools.ca.CellularAutomata

/**
  * @author Orestis Melkonian
  */
object CellurarAutomata {

  def from(x: Int = 100, y: Int = 100, seed: Int = 25, N: Int = 10): Stream[Array[Array[Boolean]]] =
    Stream.just[CellularAutomata](new CellularAutomata(x, y, seed))
      .loop((c: Cell))

}