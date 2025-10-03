package RespostaAdapter;
// A interface ae oh
interface ConversorTemperatura {
    double celsiusParaFahrenheit(double celsius);
    double fahrenheitParaCelsius(double fahrenheit);
}

// Classe de conversão (só converte Celsius para Fahrenheit)
class ConversorCelsius {
    public double converterParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}

// ADAPTER conectando a interface com a classe
class AdaptadorConversorTemperatura implements ConversorTemperatura {
    private ConversorCelsius conversorExistente;

    public AdaptadorConversorTemperatura() {
        this.conversorExistente = new ConversorCelsius();
    }

    @Override
    public double celsiusParaFahrenheit(double celsius) {
        // método existente sendo usado diretamente
        return conversorExistente.converterParaFahrenheit(celsius);
    }

    @Override
    public double fahrenheitParaCelsius(double fahrenheit) {
        // converte invertido (Fahrenheit para Celsius)
        return (fahrenheit - 32) * 5/9;
    }
}
// Teste básico
public class MainAtvAdapter1 {
    public static void main(String[] args) {
        ConversorTemperatura conversor = new AdaptadorConversorTemperatura();

        System.out.println("=== Teste do Conversor de Temperatura ===");

        // Teste de conversão de Celsius para Fahrenheit
        double f1 = conversor.celsiusParaFahrenheit(0);
        double f2 = conversor.celsiusParaFahrenheit(100);
        System.out.println("0°C = " + f1 + "°F");
        System.out.println("100°C = " + f2 + "°F");

        // Teste de conversão de Fahrenheit para Celsius
        double c1 = conversor.fahrenheitParaCelsius(32);
        double c2 = conversor.fahrenheitParaCelsius(212);
        System.out.println("32°F = " + c1 + "°C");
        System.out.println("212°F = " + c2 + "°C");
    }
}