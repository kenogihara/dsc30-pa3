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

        assertEquals("", genetics.transcribeDNA("").toString());
        assertFalse(String.valueOf(genetics.transcribeDNA("GAATGCCGGTCAGCA").circularArray).contains("T"));
    }



    @Test
    void translateRNA() {
        assertEquals("MIS*", genetics.translateRNA(genetics.transcribeDNA("ATGATCTCGTAA")).toString());
        assertEquals("MYS", genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).toString());
        assertEquals("MS", genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).toString());
        assertEquals("M*", genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).toString());
        assertEquals("MELPY",genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).toString());
        assertTrue(genetics.translateRNA(genetics.transcribeDNA("GAATGCCGGTCAGCA")).isEmpty());
        assertEquals("", genetics.translateRNA(genetics.transcribeDNA("CCCCTGTCATAA")).toString());
        assertEquals("MLC", genetics.translateRNA(genetics.transcribeDNA("ATGCTATGT")).toString());
    }
}