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

    public CharQueue translateRNA(CharQueue rna) {
        // TODO
        return null;
    }

}
