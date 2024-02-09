import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    ProteinSynthesis genetics;
    @BeforeEach
    void setUp() {
        genetics = new ProteinSynthesis();
    }
    @Test
    void transcribeDNA() {
        assertEquals("AAGAGAUGUCGGUUUGCUAGUUCACGUAAAGGU",
                String.valueOf(genetics.transcribeDNA("AAGAGATGTCGGTTTGCTAGTTCACGTAAAGGT").circularArray));

        assertEquals("GCCUCGCGCCACCUCUAAGUAAGUGAGCCGUCGAGACAUUAUCCCUGAUUUUCUCACUACUAUUAGUACUCACGGCGCAAUACCACCACAGCCUUGUCU",
                String.valueOf(genetics.transcribeDNA("GCCTCGCGCCACCTCTAAGTAAGTGAGCCGTCGAGACATTATCCCTGATTTTCTCACTACTATTAGTACTCACGGCGCAATACCACCACAGCCTTGTCT").circularArray));

        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("CGCCA"));
        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("TACAT"));

        assertEquals("", String.valueOf(genetics.transcribeDNA("").circularArray));
        assertFalse(String.valueOf(genetics.transcribeDNA("GAATGCCGGTCAGCA").circularArray).contains("T"));
    }

    @Test
    void translateRNA() {
        assertEquals("MYS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).circularArray));
        assertEquals("MS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).circularArray));
        assertEquals("M*", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).circularArray));
        assertEquals("MELPY", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).circularArray));
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());


        assertEquals("MIS*", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGATCTCGTAA")).circularArray));
        assertEquals("", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("CCCCTGTCATAA")).circularArray));
        assertEquals("MLC", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGCTATGT")).circularArray));



    }
}