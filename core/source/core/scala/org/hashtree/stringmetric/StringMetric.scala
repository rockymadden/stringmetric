package org.hashtree.stringmetric

import org.hashtree.stringmetric.phonetic.{ MetaphoneMetric, NysiisMetric, RefinedSoundexMetric, SoundexMetric }
import org.hashtree.stringmetric.similarity.{ DiceSorensenMetric, HammingMetric, JaroMetric, JaroWinklerMetric, LevenshteinMetric }

/** Marks those which leverage traits of a string based [[org.hashtree.stringmetric.Metric]]. */
trait StringMetric extends Metric[String, StringFilter] {
	def compare(charArray1: Array[Char], charArray2: Array[Char])(implicit stringFilter: StringFilter): Option[AnyVal]
}

/** Convenience object for those extending [[org.hashtree.stringmetric.StringMetric]]. */
object StringMetric {
	def compareDiceSorensen(charArray1: Array[Char], charArray2: Array[Char]): Option[Double] =
		DiceSorensenMetric.compare(charArray1, charArray2)

	def compareDiceSorensen(string1: String, string2: String): Option[Double] =
		DiceSorensenMetric.compare(string1, string2)

	def compareHamming(charArray1: Array[Char], charArray2: Array[Char]): Option[Int] =
		HammingMetric.compare(charArray1, charArray2)

	def compareHamming(string1: String, string2: String): Option[Int] =
		HammingMetric.compare(string1, string2)

	def compareJaro(charArray1: Array[Char], charArray2: Array[Char]): Option[Double] =
		JaroMetric.compare(charArray1, charArray2)

	def compareJaro(string1: String, string2: String): Option[Double] =
		JaroMetric.compare(string1, string2)

	def compareJaroWinkler(charArray1: Array[Char], charArray2: Array[Char]): Option[Double] =
		JaroWinklerMetric.compare(charArray1, charArray2)

	def compareJaroWinkler(string1: String, string2: String): Option[Double] =
		JaroWinklerMetric.compare(string1, string2)

	def compareLevenshtein(charArray1: Array[Char], charArray2: Array[Char]): Option[Int] =
		LevenshteinMetric.compare(charArray1, charArray2)

	def compareLevenshtein(string1: String, string2: String): Option[Int] =
		LevenshteinMetric.compare(string1, string2)

	def compareMetaphone(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		MetaphoneMetric.compare(charArray1, charArray2)

	def compareMetaphone(string1: String, string2: String): Option[Boolean] =
		MetaphoneMetric.compare(string1, string2)

	def compareNysiis(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		NysiisMetric.compare(charArray1, charArray2)

	def compareNysiis(string1: String, string2: String): Option[Boolean] =
		NysiisMetric.compare(string1, string2)

	def compareRefinedSoundex(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		RefinedSoundexMetric.compare(charArray1, charArray2)

	def compareRefinedSoundex(string1: String, string2: String): Option[Boolean] =
		RefinedSoundexMetric.compare(string1, string2)

	def compareSoundex(charArray1: Array[Char], charArray2: Array[Char]): Option[Boolean] =
		SoundexMetric.compare(charArray1, charArray2)

	def compareSoundex(string1: String, string2: String): Option[Boolean] =
		SoundexMetric.compare(string1, string2)

	def diceSorensen: DiceSorensenMetric.type = DiceSorensenMetric

	def hamming: HammingMetric.type = HammingMetric

	def jaro: JaroMetric.type = JaroMetric

	def jaroWinkler: JaroWinklerMetric.type = JaroWinklerMetric

	def levenshtein: LevenshteinMetric.type = LevenshteinMetric

	def metaphone: MetaphoneMetric.type = MetaphoneMetric

	def nysiis: NysiisMetric.type = NysiisMetric

	def refinedSoundex: RefinedSoundexMetric.type = RefinedSoundexMetric

	def soundex: SoundexMetric.type = SoundexMetric
}