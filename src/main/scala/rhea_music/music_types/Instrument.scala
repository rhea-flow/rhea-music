package rhea_music.music_types

import org.rhea_core.Stream
import rhea_music.music_streams.MusicStream
import rhea_music.util.ImplicitConversions._

/**
  * @author Orestis Melkonian
  */
class Instrument(instrument: Int) extends MusicString with Wrapper {

  override def |>(s: String) = repr + " " + s
  def ||>(s: MusicStream): MusicStream = Stream.concat(Stream.just(this), s)

  override var repr: String = "I[" + Instrument.instrToString(instrument) + "]"
}

object Instrument {
  def instrToString[T](instr: Int): String =
    instr match {
      case 0 => "PIANO"
      case 1 => "BRIGHT_ACOUSTIC"
      case 2 => "ELECTRIC_GRAND"
      case 3 => "HONKEY_TONK"
      case 4 => "ELECTRIC_PIANO"
      case 5 => "ELECTRIC_PIANO_2"
      case 6 => "HARPSICHORD"
      case 7 => "CLAVINET"
      case 8 => "CELESTA"
      case 9 => "GLOCKENSPIEL"

      case 10 => "MUSIC_BOX"
      case 11 => "VIBRAPHONE"
      case 12 => "MARIMBA"
      case 13 => "XYLOPHONE"
      case 14 => "TUBULAR_BELLS"
      case 15 => "DULCIMER"
      case 16 => "DRAWBAR_ORGAN"
      case 17 => "PERCUSSIVE_ORGAN"
      case 18 => "ROCK_ORGAN"
      case 19 => "CHURCH_ORGAN"

      case 20 => "REED_ORGAN"
      case 21 => "ACCORDIAN"
      case 22 => "HARMONICA"
      case 23 => "TANGO_ACCORDIAN"
      case 24 => "GUITAR"
      case 25 => "STEEL_STRING_GUITAR"
      case 26 => "ELECTRIC_JAZZ_GUITAR"
      case 27 => "ELECTRIC_CLEAN_GUITAR"
      case 28 => "ELECTRIC_MUTED_GUITAR"
      case 29 => "OVERDRIVEN_GUITAR"

      case 30 => "DISTORTION_GUITAR"
      case 31 => "GUITAR_HARMONICS"
      case 32 => "ACOUSTIC_BASS"
      case 33 => "ELECTRIC_BASS_FINGER"
      case 34 => "ELECTRIC_BASS_PICK"
      case 35 => "FRETLESS_BASS"
      case 36 => "SLAP_BASS_1"
      case 37 => "SLAP_BASS_2"
      case 38 => "SYNTH_BASS_1"
      case 39 => "SYNTH_BASS_2"

      case 40 => "VIOLIN"
      case 41 => "VIOLA"
      case 42 => "CELLO"
      case 43 => "CONTRABASS"
      case 44 => "TREMOLO_STRINGS"
      case 45 => "PIZZICATO_STRINGS"
      case 46 => "ORCHESTRAL_STRINGS"
      case 47 => "TIMPANI"
      case 48 => "STRING_ENSEMBLE_1"
      case 49 => "STRING_ENSEMBLE_2"

      case 50 => "SYNTH_STRINGS_1"
      case 51 => "SYNTH_STRINGS_2"
      case 52 => "CHOIR_AAHS"
      case 53 => "VOICE_OOHS"
      case 54 => "SYNTH_VOICE"
      case 55 => "ORCHESTRA_HIT"
      case 56 => "TRUMPET"
      case 57 => "TROMBONE"
      case 58 => "TUBA"
      case 59 => "MUTED_TRUMPET"

      case 60 => "FRENCH_HORN"
      case 61 => "BRASS_SECTION"
      case 62 => "SYNTH_BRASS_1"
      case 63 => "SYNTH_BRASS_2"
      case 64 => "SOPRANO_SAX"
      case 65 => "ALTO_SAX"
      case 66 => "TENOR_SAX"
      case 67 => "BARITONE_SAX"
      case 68 => "OBOE"
      case 69 => "ENGLISH_HORN"

      case 70 => "BASSOON"
      case 71 => "CLARINET"
      case 72 => "PICCOLO"
      case 73 => "FLUTE"
      case 74 => "RECORDER"
      case 75 => "PAN_FLUTE"
      case 76 => "BLOWN_BOTTLE"
      case 77 => "SKAKUHACHI"
      case 78 => "WHISTLE"
      case 79 => "OCARINA"

      case 80 => "SQUARE"
      case 81 => "SAWTOOTH"
      case 82 => "CALLIOPE"
      case 83 => "CHIFF"
      case 84 => "CHARANG"
      case 85 => "VOICE"
      case 86 => "FIFTHS"
      case 87 => "BASS_LEAD"
      case 88 => "NEW_AGE"
      case 89 => "WARM"

      case 90 => "POLY_SYNTH"
      case 91 => "CHOIR"
      case 92 => "BOWED"
      case 93 => "METALLIC"
      case 94 => "HALO"
      case 95 => "SWEEP"
      case 96 => "RAIN"
      case 97 => "SOUNDTRACK"
      case 98 => "CRYSTAL"
      case 99 => "ATMOSPHERE"

      case 100 => "BRIGHTNESS"
      case 101 => "GOBLINS"
      case 102 => "ECHOES"
      case 103 => "SCI_FI"
      case 104 => "SITAR"
      case 105 => "BANJO"
      case 106 => "SHAMISEN"
      case 107 => "KOTO"
      case 108 => "KALIMBA"
      case 109 => "BAGPIPE"

      case 110 => "FIDDLE"
      case 111 => "SHANAI"
      case 112 => "TINKLE_BELL"
      case 113 => "AGOGO"
      case 114 => "STEEL_DRUMS"
      case 115 => "WOODBLOCK"
      case 116 => "TAIKO_DRUM"
      case 117 => "MELODIC_TOM"
      case 118 => "SYNTH_DRUM"
      case 119 => "REVERSE_CYMBAL"

      case 120 => "GUITAR_FRET_NOISE"
      case 121 => "BREATH_NOISE"
      case 122 => "SEASHORE"
      case 123 => "BIRD_TWEET"
      case 124 => "TELEPHONE_RING"
      case 125 => "HELICOPTER"
      case 126 => "APPLAUSE"
      case 127 => "GUNSHOT"
      case _   => "Piano"
    }
}
