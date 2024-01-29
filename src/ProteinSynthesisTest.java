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

        assertFalse(String.valueOf(genetics.transcribeDNA("GAATGCCGGTCAGCA").circularArray).contains("T"));
    }

    @Test
    void translateRNA() {
        assertEquals("MYS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGTATTCT")).circularArray));
        assertEquals("MS", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("AGGATGTCT")).circularArray));
        assertEquals("M\u0000\u0000", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ACAGAGATGTAATAC")).circularArray));
        assertEquals("MELPY", String.valueOf(genetics.translateRNA(genetics.transcribeDNA("ATGGAGTTGCCGTAC")).circularArray));
    }
}