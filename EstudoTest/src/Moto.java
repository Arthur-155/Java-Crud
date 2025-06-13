public class Moto extends Veiculo implements realizarManutencao{
    @Override
    public void exibirDados() {
        System.out.println("Placa da moto: " +placa );
        System.out.println("Marca da moto: " + marca);
        System.out.println("Modelo da moto: " + modelo);
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Manutenção da moto necessária!");
    }
}
