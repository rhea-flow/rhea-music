package rhea_music.music_types

import rhea_music.ImplicitConversions._

import rhea_music.constants.ChordTypes.ChordType
import rhea_music.constants.Tones.Tone
import rhea_music.music_streams.MusicStream
import rhea_music.util.Random.randChord

/**
  * @author Orestis Melkonian
  */
class Chord(var note: Note,
            var chordType: ChordType,
            var inversion: Int = 0,
            var bass: Tone = null
           ) extends MusicString {

  override def repr: String =
    note + chordType + (
      if (bass != null) "^" + bass
      else "^" * inversion
    )

}

object Chord {
  def randChords: MusicStream = MusicStream.repeatFunc(randChord)
}
