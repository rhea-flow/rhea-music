package rhea_music.music_types

import rhea_music.ImplicitConversions._
import rhea_music.constants.ChordTypes.ChordType
import rhea_music.constants.Durations.{Duration, noDuration}
import rhea_music.constants.Intervals
import rhea_music.constants.ChordTypes.chordToIntervals
import rhea_music.music_streams.MusicStream
import rhea_music.util.Random.randChord

/**
  * @author Orestis Melkonian
  */
class Chord(var note: Note,
            var chordType: ChordType,
            var inversion: Int = 0,
            var bass: Tone = null,
            var duration: Duration = noDuration
           ) extends MusicString {

  override var repr: String =
    note.clean + chordType + (
      if (bass != null) "^" + bass
      else "^" * inversion
    ) + duration

  def getTones: Array[Tone] = Intervals.getTones(note.root, chordToIntervals.get(chordType).get)

}

object Chord {
  def randChords: MusicStream = MusicStream.repeatFunc(randChord)
}
