public class Carro extends Veiculo implements realizarManutencao{
    @Override
    public void exibirDados() {
        System.out.println("Placa do carro: " +placa );
        System.out.println("Marca do carro: " + marca);
        System.out.println("Modelo do carro: " + modelo);
    }

    @Override
    public void realizarManutencao() {
        System.out.println("Manutenção do carro Necessária!");
    }
}
