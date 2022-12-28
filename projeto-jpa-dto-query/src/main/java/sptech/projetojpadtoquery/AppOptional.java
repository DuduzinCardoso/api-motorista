package sptech.projetojpadtoquery;

import sptech.projetojpadtoquery.dominio.Motorista;

import java.util.Optional;

public class AppOptional {
    public static void main(String[] args) {
        Optional<Motorista> optMotorista = Optional.of(new Motorista());
        if (optMotorista.isPresent()) {
            System.out.println(optMotorista.get());
        } else {
            System.out.println("Sem motorista!");
        }
    }
}
