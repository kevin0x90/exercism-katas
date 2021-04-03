import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class ProteinTranslator {

    private static final Map<String, String> RNA_TO_CODON = new HashMap<>();
    private static final Set<String> STOP_RNAS = Set.of("UAA", "UAG", "UGA");

    static {
        RNA_TO_CODON.put("AUG", "Methionine");
        RNA_TO_CODON.put("UUU", "Phenylalanine");
        RNA_TO_CODON.put("UUC", "Phenylalanine");
        RNA_TO_CODON.put("UUA", "Leucine");
        RNA_TO_CODON.put("UUG", "Leucine");
        RNA_TO_CODON.put("UCU", "Serine");
        RNA_TO_CODON.put("UCC", "Serine");
        RNA_TO_CODON.put("UCA", "Serine");
        RNA_TO_CODON.put("UCG", "Serine");
        RNA_TO_CODON.put("UAU", "Tyrosine");
        RNA_TO_CODON.put("UAC", "Tyrosine");
        RNA_TO_CODON.put("UGU", "Cysteine");
        RNA_TO_CODON.put("UGC", "Cysteine");
        RNA_TO_CODON.put("UGG", "Tryptophan");
    }

    List<String> translate(final String rnaSequence) {
        final List<String> result = new ArrayList<>();

        for (int i = 0; i < rnaSequence.length(); i += 3) {
            final String rna = rnaSequence.substring(i, i + 3);

            if (STOP_RNAS.contains(rna)) {
                break;
            }

            final String codon = RNA_TO_CODON.get(rna);

            if (codon != null) {
                result.add(codon);
            }
        }

        return result;
    }
}
