import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class caixa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite quantos R$ deseja sacar:");
        int valor = Integer.parseInt(scanner.nextLine());

        List<Integer> notas = new ArrayList<>();
        notas.add(200);
        notas.add(100);
        notas.add(50);
        notas.add(20);
        notas.add(10);
        notas.add(5);
        notas.add(2);

        // Usamos LinkedHashMap para manter a ordem de inserção dos elementos
        Map<Integer, Integer> dict = new LinkedHashMap<>();

        for (int obj : notas) {
            int calculadora = valor / obj;
            if (calculadora > 0) {
                if (obj == 5) {
                    if ((valor % 5) % 2 != 0) {
                        continue;
                    }
                }
                dict.put(obj, calculadora);
                valor = valor % obj;
            }
        }

        for (Map.Entry<Integer, Integer> entry : dict.entrySet()) {
            int chave = entry.getKey();
            int valorNota = entry.getValue();
            System.out.println(valorNota + " X R$" + chave);
        }

        scanner.close();
    }
}