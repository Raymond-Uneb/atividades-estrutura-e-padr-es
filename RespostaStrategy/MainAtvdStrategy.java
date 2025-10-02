package RespostaStrategy;

interface CompressionStrategy {
    void compress(String fileName);
}

class RarCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Comprimindo " + fileName + " em RAR...");
    }
}

class SevenZCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Comprimindo " + fileName + " em sevenZ...");
    }
}

class ZipCompression implements CompressionStrategy {
    @Override
    public void compress(String fileName) {
        System.out.println("Comprimindo " + fileName + " em  ZIP...");
    }
}

class Compressor {
    private CompressionStrategy strategy;

    public void setStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compressFile(String fileName) {
        if (strategy == null) {
            System.out.println("Nenhuma estratégia definida!");
            return;
        }
        strategy.compress(fileName);
    }
}

public class MainAtvdStrategy {
    public static void main(String[] args) {
        Compressor compressor = new Compressor();
        compressor.setStrategy(new ZipCompression());
        compressor.compressFile("documento.txt");
        compressor.setStrategy(new RarCompression());
        compressor.compressFile("imagem.png");
        compressor.setStrategy(new SevenZCompression());
        compressor.compressFile("video.mp4");
    }
}