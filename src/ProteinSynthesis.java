/*
    Name: Ken Ogihara
    PID:  A16969236
 */

/**
 * Protein Synthesis Class Implementation.
 *
 * @author Ken Ogihara
 * @since ${1/28/2024}
 */
class ProteinSynthesis {

    /* Magic numbers */

    public static final int GROUP = 3;

    /**
     * Method that transcribes DNA to RNA by replacing Thymine nucleotides with Uracil.
     * @param dna a string of characters.
     * @return transcription which is an object of the CharQueue class.
     * @throws IllegalArgumentException if the length of the string is not divisible by 3.
     **/
    public CharQueue transcribeDNA(String dna) {
        if (dna.length() % GROUP != 0) {
            throw new IllegalArgumentException("Not divisible by 3");
        }
        CharQueue transcription = new CharQueue(dna.length());

        for (char nucleotide: dna.toCharArray()) {
            if (nucleotide == 'T') {
                transcription.enqueue('U');
            } else {
                transcription.enqueue(nucleotide);
            }
        } return transcription;
    }

    /**
     * Method that transcribes DNA to RNA by replacing Thymine nucleotides with Uracil.
     * @param rna a string of characters.
     * @return transcription which is an object of the CharQueue class.
     * @throws IllegalArgumentException if the length of the string is not divisible by 3.
     **/
    public CharQueue translateRNA(CharQueue rna) {
        return null;
    }

}
