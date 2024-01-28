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
                String.valueOf(genetics.transcribeDNA("AAGAGAUGUCGGUUUGCUAGUUCACGUAAAGGU").circularArray));

        assertEquals("GCCUCGCGCCACCUCUAAGUAAGUGAGCCGUCGAGACAUUAUCCCUGAUUUUCUCACUACUAUUAGUACUCACGGCGCAAUACCACCACAGCCUUGUCU",
                String.valueOf(genetics.transcribeDNA("GCCTCGCGCCACCTCTAAGTAAGTGAGCCGTCGAGACATTATCCCTGATTTTCTCACTACTATTAGTACTCACGGCGCAATACCACCACAGCCTTGTCT").circularArray));

        assertThrows(IllegalArgumentException.class, () -> genetics.transcribeDNA("CGCCA"));

        assertFalse(String.valueOf(genetics.transcribeDNA("GAATGCCGGTCAGCA").circularArray).contains("T"));
    }

    @Test
    void translateRNA() {


    }
}