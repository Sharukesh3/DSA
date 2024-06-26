import java.util.ArrayList;
import java.util.List;

public class compression {
    private String compressed;
    private List<Triple> compressedLZ77;
    private List<Integer> compressedLZW;

    public compression(String algorithm, String content){
        if (algorithm == "Huffman"){
            this.HuffmanEncoding(content);
        }
        else if (algorithm == "LZ77"){
            this.LZ77Encoding(content);
        }
        else if (algorithm == "LZW"){
            this.LZWEncoding(content);
        }
        else{
            this.getCompressed();
        }
    }

    private void HuffmanEncoding(String content){
        Huffman huffman = new Huffman(content);
        compressed = huffman.encode();
        System.out.println("\nTree visualisation");
        python python = new python(content);
        python.Huffman_tree_visualisation();
    }

    private void LZ77Encoding(String content){
        LZ77 LZ77 = new LZ77(content,10,5);
        compressedLZ77 = LZ77.getcompressedData();
    }

    private void LZWEncoding(String content){
        LZW LZW = new LZW(content);
        compressedLZW = LZW.getCompressed();
    }

    public String getCompressed() {
        return compressed;
    }

    public List<Triple> getCompressedLZ77() {
        return compressedLZ77;
    }

    public List<Integer> getCompressedLZW() {
        return compressedLZW;
    }

}
