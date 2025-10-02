package RespostaAdapter;
// Interface desejada
interface ConversorTemperatura {
    double celsiusParaFahrenheit(double celsius);
    double fahrenheitParaCelsius(double fahrenheit);
}

// Classe existente (só converte Celsius para Fahrenheit)
class ConversorCelsius {
    public double converterParaFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }
}

// ADAPTER - Conecta a interface desejada com a classe existente
class AdaptadorConversorTemperatura implements ConversorTemperatura {
    private ConversorCelsius conversorExistente;

    public AdaptadorConversorTemperatura() {
        this.conversorExistente = new ConversorCelsius();
    }

    @Override
    public double celsiusParaFahrenheit(double celsius) {
        // Usa diretamente o método existente
        return conversorExistente.converterParaFahrenheit(celsius);
    }

    @Override
    public double fahrenheitParaCelsius(double fahrenheit) {
        // Implementa a conversão inversa (Fahrenheit para Celsius)
        return (fahrenheit - 32) * 5/9;
    }
}
// Teste de funcionamento
public class MainAtvAdapter1 {
    public static void main(String[] args) {
        ConversorTemperatura conversor = new AdaptadorConversorTemperatura();

        System.out.println("=== Teste do Conversor de Temperatura ===");

        // Testando conversão de Celsius para Fahrenheit
        double f1 = conversor.celsiusParaFahrenheit(0);
        double f2 = conversor.celsiusParaFahrenheit(100);
        System.out.println("0°C = " + f1 + "°F");
        System.out.println("100°C = " + f2 + "°F");

        // Testando conversão de Fahrenheit para Celsius
        double c1 = conversor.fahrenheitParaCelsius(32);
        double c2 = conversor.fahrenheitParaCelsius(212);
        System.out.println("32°F = " + c1 + "°C");
        System.out.println("212°F = " + c2 + "°C");
    }
}