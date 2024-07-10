import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ContaCorrente {
    private int numConta;
    private int numAgencia;
    private String nameCli;
    private float sale;
    private String dateBirth; // colocar data do tipo Date
    private boolean accountActive;

    public ContaCorrente(int numConta, int numAgencia, String nameCli, String dateBirth, float sale){
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.nameCli = nameCli;
        this.sale = sale;
        this.dateBirth = dateBirth;
        this.accountActive = true;
    }

    public int getNumConta() {
        return numConta;
    }

    public boolean isAccountActive() {
        return accountActive;
    }

    public void setAccountActive(boolean accountActive) {
        this.accountActive = accountActive;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }

    public String getNameCli() {
        return nameCli;
    }

    public void setNameCli(String nameCli) {
        this.nameCli = nameCli;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public void deposit(){
        System.out.print("Entre com o valor que deseja depositar: ");
        Scanner sc = new Scanner(System.in);
        float valor = sc.nextInt();

        this.sale += valor;
        System.out.println("Valor depositado de R$" + valor + " com sucesso!");
    }

    public void withdraw(){
        System.out.print("Entre com o valor que deseja sacar: ");
        Scanner sc = new Scanner(System.in);
        float valor = sc.nextInt();

        if (valor > this.sale){
            System.out.println("Valor maior do que possui em saldo!");
        }else{
            this.sale -= valor;
            System.out.println("Valor de R$" + valor + " sacado com sucesso!");
        }
    }

    public void transferMoney(ContaCorrente conta){
        System.out.print("Entre com o valor que deseja transferir: ");
        Scanner sc = new Scanner(System.in);
        float valor = sc.nextInt();

        if (valor > this.sale){
            System.out.println("Valor maior do que possui em saldo!");
        }else{
            System.out.println("Deposito realizado com sucesso!");
            this.sale -= valor;
            conta.setSale(conta.getSale() + valor);
        }

    }

    public void viewSale(){
        System.out.println("O saldo atual é de R$" + this.sale);
    }

    public void viewData(){
        System.out.println("Nome Cliente: " + this.nameCli);
        System.out.println("Numero Conta: " + this.numConta);
        System.out.println("Numero Agencia: " + this.numAgencia);
        System.out.println("Saldo: " + this.sale);

        DateTimeFormatter saveFormatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate date = LocalDate.parse(this.dateBirth, saveFormatter);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //LocalDate data = LocalDate.of(dia,mes,ano);  salvar por dia mes e ano

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //String dataFormatada = data.format(formatter);


        System.out.println("Data Nascimento: " + formatter.format(date));
        System.out.println("Conta ativa? " + accountActive);
    }

    public void consultarExtratroEntreDatas(){

    }



    public void calcelAccount(){
        System.out.println("Por qual motivo deseja cancelar a conta?");
        Scanner sc = new Scanner(System.in);
        String description = sc.next();

        this.accountActive = false;
    }
}