
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.telas;

import br.ufsc.ine5605.trabalho.modelos.AssocVeiculoFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Diretor;
import br.ufsc.ine5605.trabalho.modelos.Funcionario;
import br.ufsc.ine5605.trabalho.modelos.FuncionarioComum;
import br.ufsc.ine5605.trabalho.modelos.Veiculo;
import br.ufsc.ine5605.trabalho.controladores.ControladorPrincipal;
import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorVeiculo;
import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author info
 */
public class TelaCadastroFuncionario {

   
    ControladorFuncionario ctrlFuncionario;
    Scanner sc = new Scanner(System.in);

    public TelaCadastroFuncionario(ControladorFuncionario ctrl) {
        this.ctrlFuncionario = ctrl;
        ctrlFuncionario.getMapeadorFuncionario().load();
    }

    public void exibeMenuInicial() {

        int opcao = -1;
        int i = 0;
        do {

            System.out.println("1 - Cadastrar Funcionario ");
            System.out.println("2 - Adicionar veículo ao funcionario");
            System.out.println("3 - Exibir lista de todos os funcionários ");
            System.out.println("4 - Exibir lista de Diretores ");
            System.out.println("5 - Excluir Funcionario ");
            System.out.println("6 - Alterar Funcionario");
            System.out.println("7 - Testa Persistencia");
            System.out.println("0 - para Encerrar ");
            try {
                if( i > 0){
                    sc.nextLine();
                }
                
                opcao = sc.nextInt();
                i = 0;
            } catch (InputMismatchException e) {
                System.out.println(" Digitou caracter inválido, favor inserir somente numeros ");
                System.out.println(" Repita a operação ");
                System.out.println(" ---------------------------------------------------------");
                opcao = -1;
                i++;
            }

            if (opcao > 7) {
                System.out.println(" Número inválido, escolha apenas numeros listados ");
                System.out.println(" Repita a operação");
                opcao = -1;
                i++;
            }
            
           
            switch (opcao) {
                case 1:
                    cadastraFuncionario();
                    break;
                case 2:
                    adcVeiculoNoFuncionario();
                    break;
                case 3:
                    exibeListaFuncionarioComum();
                    break;
                case 4:
                    exibeListaDiretores();
                    break;
                case 5:
                    excluirFuncionario();
                    break;
                case 6:
                    alteraFuncionario();
                    break;
                case 7:
                    testaPersistencia();
                    break;
                    
                
            }
           
           
        } while (opcao != 0);
    }
     public String pedeNome() {
        String nome = "";
        System.out.println(" Digite o nome ");
        nome = sc.nextLine();
        return nome;
    }

    public int pedeMatricula() {
        int matr = 0;

        System.out.println(" Digite a matricula ");
        matr = sc.nextInt();
        return matr;
    }

    public int pedeTelefone() {
        int tel = 0;

        System.out.println("Digite o numero do telefone");
        tel = sc.nextInt();
        return tel;
    }

    public String pedeCargo() {
        String cargo = " ";
        System.out.println(" Digite o cargo: ");
        sc.nextLine();
        cargo = sc.nextLine();

        return cargo;

    }

    public String pedeDataNascimento() {
        String data = "";
        System.out.println(" Digite a data de nascimento do Funcionario ");
        data = sc.nextLine();
        return data;
    }

    public int pedePlacaCarro() {
        int placa = 0;
        try {
            System.out.println(" Digite o numero da placa que voce deseja cadastrar para o funcionario ");
            placa = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Digitou caracter inválido, repita a operação ");
            System.out.println(" ---------------------------------------------- ");
            cadastraFuncionario();
        }
        return placa;
    }

    public void cadastraFuncionario() {
        String cargo = " ";
        String data;
        String nome = " ";
        int escolha = 0;
        int matr = 0;
        int tel = 0;
        int placa = 0;
        int adcVeiculo = 0;
        int ehDiretor = 0;
        boolean r1 = false;
        boolean r2 = false;
        Veiculo veiculo = null;

        //thread é um programa, cada cor em verde do slide é um ciclo
        // bolhas são atrasos q tinhamos que colocar quando tem caso de dependencia 
        // no multithread aproveita outros momentos s
        //registrador pc sempre mudado
        /*if( continua(pedeTelefone()) == true && continua(pedeMatricula() ) == true ){
      }*/
        sc.nextLine();
        do {
            nome = pedeNome();
        } while (nome.equals(""));

        boolean r = false;
        int i = 0;
        do {

            try {
                System.out.println("  Digite o telefone ");
                if (i > 0) {
                    sc.nextLine();
                }
                tel = sc.nextInt();
                r = true;

            } catch (InputMismatchException e) {
                r = false;
            }
            i++;

        } while (!r);

        i = 0;
        r = false;

        do {
            try {
                System.out.println("  Digite a Matricula  ");
                if (i > 0) {
                    sc.nextLine();
                }

                matr = sc.nextInt();
                r = true;

            } catch (InputMismatchException e) {
                r = false;
            }

            i++;
        } while (!r);
        sc.nextLine();

        do {
            data = pedeDataNascimento();
        } while (data.equals(""));
 
        i = 0;
        r = false;
        do{
        System.out.println(" Funcionario é diretor ?");
        System.out.println(" 1 - SIM ");
        System.out.println(" 2  - NÃO ");
        System.out.println(" ------------------------");
        
        try{
        if( i > 0){
            sc.nextLine();
           
        }
        ehDiretor = sc.nextInt();
         r = true;
        }catch(InputMismatchException e){
            System.out.println(" Digite apenas números ");
            
        }
        if( ehDiretor > 2 ){
            System.out.println(" Digite apenas 1 ou 2 ");
            r = false;
        }
        i++;
        }while( !r);
        
        
        
        if (ehDiretor == 2) {
            cargo = pedeCargo();

            ctrlFuncionario.addFuncionario(nome, matr, tel, cargo, data);
        } else {
            
            ctrlFuncionario.addDiretor(nome, matr, tel, data, cargo);
            
        }

    }

    public void exibeListaFuncionarioComum() {

        for (Funcionario funcionario : ctrlFuncionario.pegaListaDoMapeador()) {

            System.out.println("----------------------------------------- ");
            System.out.println(" Nome: " + funcionario.getNome());
            System.out.println(" Matricula: " + funcionario.getMatricula());
            System.out.println(" Telefone: " + funcionario.getTelefone());
            System.out.println(" Cargo: " + funcionario.getCargo());
            System.out.println(" Data de Nascimento: " + funcionario.getDataNascimento());
            exibeVeiculosFuncionario(funcionario);
            System.out.println("----------------------------------------- ");
        }
    }
    
    

   

    public void adcVeiculoNoFuncionario() {
        Funcionario func = null;
        Veiculo veic = null;
        int matricula = 0;
        int placa = 0;
        System.out.println(" Digite a matricula do Funcionario ");
        try{
        matricula = sc.nextInt();
        if (ctrlFuncionario.matriculaFuncionarioExiste(matricula)) {

            System.out.println(" - Matricula Encontrada - ");

            System.out.println(" Digite a placa do carro que voce deseja cadastrar ao funcionario");
            placa = sc.nextInt();
            if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(placa)) {
                System.out.println(" Placa encontrada ");
                func = ctrlFuncionario.pegaFuncionarioPelaMatricula(matricula);
                veic = ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa);
                func.addVeiculo(veic);
              
               
            }
        
        } else {
            System.out.println(" ------------------------------------------------------------------------------ ");
            System.out.println(" Matricula não existe favor cadastrar primeiro o funcionario com essa matricula ");
            System.out.println(" ------------------------------------------------------------------------------ ");

        }
    }catch(InputMismatchException e){
            System.out.println(" Digitou caracter inválido,digite apenas numéros ");
            System.out.println("  ------------------------------------------------- ");
    }
    }

    public void exibeVeiculosFuncionario(Funcionario funcionario) {
        for (Veiculo veiculo : funcionario.getListaVeiculos()) {
            try {
                System.out.println(" Veiculo que tem acesso : " + "Placa: " + veiculo.getPlaca() + "  " + "Ano: " + veiculo.getAno() + " " + "Quilometragem: " + veiculo.getQuilometragemAtual() + " " + " Modelo :" + veiculo.getModelo()+ " Marca:" + veiculo.getMarca());

            } catch (NullPointerException e) {
                System.out.println(" Sem cadastro de veículo ");
            }
        }
    }

    public void exibeListaDiretores() {

        for (Funcionario funcionario : ctrlFuncionario.pegaListaDoMapeador()) {
            if( funcionario instanceof Diretor ){
            System.out.println(" ------------------------------------------- ");
            System.out.println(" Nome: " + funcionario.getNome());
            System.out.println(" Cargo: " + funcionario.getCargo());
            System.out.println(" Matricula: " + funcionario.getMatricula());
            System.out.println(" Data de Nascimento: " + funcionario.getDataNascimento());
            System.out.println(" ------------------------------------------- ");
        }
        }
    }

    public void mensagem(String mensagem) {
        System.out.println(mensagem);
    }

    
   
    public void desbloqueiaFuncionario() {
        int matricula = 0;
        System.out.println(" Digite a matricula do funcionario que voce deseja desbloquear ");
        try {
            matricula = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(" Digitou caracter inválido, digite apenas numeros ");
        }
        ctrlFuncionario.desbloqueia(matricula);

    }

   
    public void alteraFuncionario() {
        String nome = null;
        String cargo = null;
        int telefone = 0;
        String dataNascimento = null;
        int opcao = -1;
        int matricula = 0;
        int i = 0;
        
        do{
            
            System.out.println("1 - Alterar nome do funcionario ");
            System.out.println("2 - Alterar cargo ");
            System.out.println("3 - Alterar telefone");
            System.out.println("4 - Alterar data de nascimento ");
            System.out.println("0 - para Encerrar ");
            try {
                if( i > 0){
                    sc.nextLine();
                }
                
                opcao = sc.nextInt();
                i = 0;
            } catch (InputMismatchException e) {
                System.out.println(" Digitou caracter inválido, favor inserir somente numeros ");
                System.out.println(" Selecione a opção de cadastro novamente e tente outra vez ");
                System.out.println(" Tente denovo ");
                System.out.println(" ---------------------------------------------------------");
                opcao = -1;
                i++;

            }

            if (opcao > 4) {
                System.out.println(" Numero inválido, digite apenas os numeros listados");
                opcao = -1;
                i++;
            }
            switch(opcao) {
                case 1:
                    alteraNome();
                    break;
                case 2:
                    alteraCargo();
                    break;
                case 3:
                    alteraTelefone();
                    break;
                case 4:
                    alteraDataNascimento();
            }
        } while (opcao != 0);
    }
    
    public void alteraNome() {
        int matr = 0;
        String nome = null;
        System.out.println(" Digite a matricula ");
        try{
        matr = sc.nextInt();
        System.out.println("Digite o novo nome do funcionario: ");
        sc.nextLine();
        nome = sc.nextLine();
            
        ctrlFuncionario.alteraNome(matr,nome);
    }catch( InputMismatchException e){
            System.out.println(" Digitou caracter inválido ");
    }
    }
    
    public void alteraCargo() {
        String cargo = null;
        
        try{
        int matricula = pedeMatricula();
        if(ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula) instanceof Diretor == false){
        System.out.println("Digite o novo cargo do funcionario: ");
        sc.nextLine();
        cargo = sc.nextLine();
         
        ctrlFuncionario.alteraCargo(matricula, cargo);
        }else{
            System.out.println(" Funcionário é um diretor - Troca Proibida - ");
        }
        }catch(InputMismatchException e){
            System.out.println(" Digitou caracter Inválido ");
        }
    }
    
    public void alteraTelefone() {
        int telefone = 0;
       try{
        int matricula = pedeMatricula();
        System.out.println("Digite o novo telefone do funcionario: ");
        telefone = sc.nextInt();
        
        ctrlFuncionario.alteraTelefone(matricula, telefone);
    }catch(InputMismatchException e){
        System.out.println(" Digitou caracter inválido ");
    }
    }
    
    public void alteraDataNascimento() {
        String dataNascimento = null;
        try{
        int matricula = pedeMatricula();
        System.out.println("Digite a nova data de nascimento do funcionario: ");
        sc.nextLine();
        dataNascimento = sc.nextLine();
         
        ctrlFuncionario.alteraDataNascimento(matricula, dataNascimento);
    }catch(InputMismatchException e){
            System.out.println(" Digitou caracter inválido ");
    }
    }



    public void excluirFuncionario(){
        int matr = 0;
        Funcionario funcionario = null;
     
     
        System.out.println(" Digite a matricula do funcionario ");
        try{
        matr = sc.nextInt();
      //  if(ctrlFuncionario.pegaFuncionarioPelaMatricula(matr) != null ){
        funcionario = ctrlFuncionario.pegaFuncionarioPelaMatricula(matr);
        ctrlFuncionario.delFuncionario(funcionario);
            
        }catch(InputMismatchException e ){
                System.out.println(" Digite apenas números ");
        }
        
        //
    }
    public Map<Integer,Funcionario> pegaObjetoSalvo() {
        Map<Integer,Funcionario> saida =   ControladorFuncionario.getInstancia().getMapeadorFuncionario().pegaListaAtualizada();
        return saida;
    }
    
    private void testaPersistencia() {
      
       Map<Integer,Funcionario>  saida =  pegaObjetoSalvo();
       Set<Integer> chaves = saida.keySet();
       

       
        for (int aux : chaves) {
            
             System.out.println(saida.get(aux).getNome());
        }
       
    }
}