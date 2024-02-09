/*
    Name: Ken Ogihara
    PID:  A16969236
 */

import java.util.Arrays;

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
     *
     * @param dna a string of characters.
     * @return transcription which is an object of the CharQueue class.
     * @throws IllegalArgumentException if the length of the string is not divisible by 3.
     **/
    public CharQueue transcribeDNA(String dna) {
        if (dna.length() % GROUP != 0) {
            throw new IllegalArgumentException("Not divisible by 3");
        }
        CharQueue transcription = new CharQueue(dna.length());

        for (char nucleotide : dna.toCharArray()) {
            if (nucleotide == 'T') {
                transcription.enqueue('U');
            } else {
                transcription.enqueue(nucleotide);
            }
        }
        return transcription;
    }

    /**
     * Method that translates a given RNA to a protein.
     *
     * @param rna an object of CharQueue.
     * @return a queue that includes the RNA's corresponding amino acids.
     **/
    public CharQueue translateRNA(CharQueue rna) {
        CharQueue emptyQueue = new CharQueue();
        boolean startTranscription = false;
        if (rna.isEmpty()) {
            return emptyQueue;
        }
        String codon;
        CharQueue aminoAcidChain = new CharQueue();
        int group = rna.size() / GROUP;
        for (int i = 0; i < group; i++) {
            codon = String.format("%s%s%s", rna.dequeue(), rna.dequeue(), rna.dequeue());
            if (codon.equals("AUG")) {
                startTranscription = true;
            }
            if (startTranscription) {
                if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
                    aminoAcidChain.enqueue(CodonMap.getAminoAcid(codon));
                    break;
                } else {
                    aminoAcidChain.enqueue(CodonMap.getAminoAcid(codon));
                }
            }
        }
        return aminoAcidChain;
        }
    }
