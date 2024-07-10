import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    ContaCorrente account = new ContaCorrente(001, 123, "Gui", "09062004",0 );
    ContaCorrente accountTransfer = new ContaCorrente(002, 123, "Arthur", "23/03/2013",20 );

    int op = 0;

        while(op != 7){
            System.out.println("\n************************");
            System.out.println("1 - Sacar ");
            System.out.println("2 - Depositar ");
            System.out.println("3 - Consultar Saldo ");
            System.out.println("4 - Consultar Dados ");
            System.out.println("5 - Transferir Dinheiro ");
            System.out.println("6 - Cancelar Conta ");
            System.out.println("7 - Sair ");
            System.out.println("************************");

            System.out.println("O que deseja fazer?");
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();

            switch (op){
                case 1:
                    account.withdraw();
                    break;
                case 2:
                    account.deposit();
                    break;
                case 3:
                    account.viewSale();
                    break;
                case 4:
                    account.viewData(); // ver dados
                    break;
                case 5:
                    account.transferMoney(accountTransfer);
                    break;
                case 6:
                    account.calcelAccount();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
            }
        }

        System.out.println("\nA conta que irá receber o dinheiro ficou assim: ");
        accountTransfer.viewData();
    }
}