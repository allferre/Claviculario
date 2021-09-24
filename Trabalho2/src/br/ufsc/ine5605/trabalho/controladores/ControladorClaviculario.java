/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

import br.ufsc.ine5605.trabalho.modelos.AssocVeiculoFuncionario;
import br.ufsc.ine5605.trabalho.modelos.Data;
import br.ufsc.ine5605.trabalho.modelos.Diretor;
import br.ufsc.ine5605.trabalho.modelos.Emprestimo;
import br.ufsc.ine5605.trabalho.modelos.Evento;
import br.ufsc.ine5605.trabalho.controladores.ControladorEvento;
import br.ufsc.ine5605.trabalho.controladores.ControladorFuncionario;
import br.ufsc.ine5605.trabalho.controladores.ControladorEmprestimo;
import br.ufsc.ine5605.trabalho.telas.TelaClaviculario;
import br.ufsc.ine5605.trabalho.telas.TelaClavicularioPrincipal;
import br.ufsc.ine5605.trabalho.telas.TelaEmprestaVeiculo;
// Versão 0906
public class ControladorClaviculario {

    TelaEmprestaVeiculo telaEmpresta;
    TelaClavicularioPrincipal telaPrincipal;
    private static ControladorClaviculario instancia;

    TelaClaviculario tela;

    private ControladorClaviculario() {
        this.tela = new TelaClaviculario(this);
        telaEmpresta = new TelaEmprestaVeiculo();
        telaPrincipal = new TelaClavicularioPrincipal();
    }

    public static ControladorClaviculario getInstancia() {
        if (instancia == null) {
            instancia = new ControladorClaviculario();
        }
        return instancia;
    }

    public void inicia() {
        telaPrincipal.setVisible(true);
    }
    
    public void iniciaEmprestimo(){
    telaEmpresta.setVisible(true);
   }
    
    public void FechaEmprestimo(){
    telaEmpresta.setVisible(false);
   }

    public void liberaChaves(int matricula) {
        int matr = 0;
        int placa = 0;
        String m = " ";
        String s = " ";
        int i = 0;
        
        

        if (ControladorPrincipal.getInstancia().getCtrlF().matriculaFuncionarioExiste(matricula)) {

           if(ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula) instanceof Diretor == false ){
            
            if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).getBloqueio().isBloqueado() == false) {

                if (ControladorPrincipal.getInstancia().getCtrlF().numeroDeCarrosAcessados(matricula) == 0) {
                    String mensagem = NegacaoPermissao.Status5Carro.descricaoDoStatus;
                   
                    

                } else if (ControladorPrincipal.getInstancia().getCtrlF().numeroDeCarrosAcessados(matricula) >= 1) {

                    placa = tela.PedePlaca();
                    
                    
                    if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(placa)) {

                        if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).autoriza(placa)) {

                            if (!ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(placa)) {
                                String mensagem = NegacaoPermissao.Status1Emprestimo.descricaoDoStatus;
                                tela.mensagem(mensagem);
                                m = " Emprestimo efetuado  ";
                                Data date = new Data(); // instancia um novo objeto data para sabermos a data do emprestimo 
                                AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlF().pegaCarroEspecifico(placa, matricula), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula)); // passa para uma classe associativa o carro que foi pegado no emprestimo junto com o objeto funcionario e junto com data que foi instanciada
                                s = " Acesso Permitido ";

                                Evento evento = new Evento(ass, s, date, m);
                                Emprestimo empre = new Emprestimo(ass, date); // criamos aqui um objeto emprestimo que vai ser adicionado informações via assocVeiculoFuncionario

                                ControladorPrincipal.getInstancia().getCtrlE().addEmprestimo(empre);// adicionamos numa lista de emprestimos para futuros relatórios
                                ControladorPrincipal.getInstancia().getCtrlEv().addPermitido(evento);
                               
                                ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).addEmprestimo(empre);

                            } else {
                                int k = 1;
                                String mensagem = NegacaoPermissao.Status1Carro.descricaoDoStatus;
                                tela.mensagem(mensagem);
                                Data date = new Data();
                                AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                                m = " Acesso negado ";
                                Evento evento = new Evento(ass, s, date, m);
                                ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().add(evento);
                                
  

                            }
                        } else {
                        int tentativaNegada = 1;
                        String mensagem = NegacaoPermissao.Status1Funcionario.descricaoDoStatus;
                        tela.mensagem(mensagem);
                        s = " Funcionario não autorizado  ";
                        Data date = new Data();
                        AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                        m = " Acesso negado ";
                        Evento evento = new Evento(ass, s, date, m);
                        ControladorPrincipal.getInstancia().getCtrlEv().addListaNegadoAutorizacao(evento);
                        ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).getBloqueio().addTentativa(tentativaNegada);
                                if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).getBloqueio().getControle() == 3) {
                                    ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).getBloqueio().setBloqueado(true);
                                }
                        }
                    } else {
                        String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
                        tela.mensagem(mensagem);
                        s = " Placa nao existe ";

                        Data date = new Data();
                        AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                        m = " Acesso negado ";
                        Evento evento = new Evento(ass, s, date, m);
                        ControladorPrincipal.getInstancia().getCtrlEv().listaNegadoPlacaInexistente(evento);
                   
                    }

                }

            } else {
                String mensagem = NegacaoPermissao.Status1Bloqueio.descricaoDoStatus;
                tela.mensagem(mensagem);
                Data date = new Data();
                AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                m = " Acesso negado ";
                Evento evento = new Evento(ass, s, date, m);
                ControladorPrincipal.getInstancia().getCtrlEv().listaNegadoAcessoBloqueado(evento);
                
            }
            
           }else{
               placa = tela.PedePlaca();
               if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(placa)) {

                        if (!ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(placa)) {

                            if (ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).autoriza(placa)) {
                                m = " Chave Liberada ";
                                tela.mensagem(m);
                                m = " Emprestimo efetuado com sucesso - Acesso Permitido -  ";
                                tela.mensagem(m);
                                m = " --------------------------------- ";
                                tela.mensagem(m);
                                Data date = new Data(); // instancia um novo objeto data para sabermos a data do emprestimo 
                                AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula)); // passa para uma classe associativa o carro que foi pegado no emprestimo junto com o objeto funcionario e junto com data que foi instanciada
                                s = " Acesso Permitido ";

                                Evento evento = new Evento(ass, s, date, m);
                                Emprestimo empre = new Emprestimo(ass, date); // criamos aqui um objeto emprestimo que vai ser adicionado informações via assocVeiculoFuncionario

                                ControladorPrincipal.getInstancia().getCtrlE().addEmprestimo(empre);// adicionamos numa lista de emprestimos para futuros relatórios
                                ControladorPrincipal.getInstancia().getCtrlEv().addPermitido(evento);
                             
                                ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula).addEmprestimo(empre);

                            }
                        }else{
                        String mensagem = NegacaoPermissao.Status1Carro.descricaoDoStatus;
                        tela.mensagem(mensagem);
                        s = " Veiculo emprestado  ";
                        Data date = new Data();
                        AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                        m = " Acesso negado ";
                        Evento evento = new Evento(ass, s, date, m);
                        ControladorPrincipal.getInstancia().getCtrlEv().getListaNegadosPorEstarEmprestado().add(evento);
                        }
               }else{
                   String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
                   tela.mensagem(mensagem);
                   
                        s = " Placa nao existe ";
                        Data date = new Data();
                        AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
                        m = " Acesso negado ";
                        Evento evento = new Evento(ass, s, date, m);
                        ControladorPrincipal.getInstancia().getCtrlEv().listaNegadoPlacaInexistente(evento);
                       
               }
               
           }
        
        
        
        }else {

            String mensagem = NegacaoPermissao.Status2Funcionario.descricaoDoStatus;
            tela.mensagem(mensagem);
            Data date = new Data();

            AssocVeiculoFuncionario ass = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa), ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matricula));
            m = " Acesso negado ";
            s = " Matricula não existe ";
            Evento evento = new Evento(ass, s, date, m,matricula );
            ControladorPrincipal.getInstancia().getCtrlEv().listaNegadoMatriculaInexistente(evento);

        }
    } 
    
  
    
 

    public void devolveChave(int matr) {
        int placa = 0;
        double quilometragem = 0.0;
        if (ControladorPrincipal.getInstancia().getCtrlF().matriculaFuncionarioExiste(matr)) {
            placa = tela.PedePlaca();
            if (ControladorPrincipal.getInstancia().getCtrlV().existeEssaPlaca(placa)) {
                if (ControladorPrincipal.getInstancia().getCtrlE().verificaSeCarroEstaEmprestado(placa)) {
                    quilometragem = tela.pedeQuilometragem();
                    
                    
                   // mudar quilometragem do veículo, nem igual
                    if( ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa).quilometragemEhvalida(quilometragem)) {
                    Emprestimo emprestimo = ControladorPrincipal.getInstancia().getCtrlE().pegaEmprestimoPelaPlaca(placa);
                    ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa).atualizaQuiloemtragem(quilometragem);
                    ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matr).delEmprestimo(emprestimo);
                    ControladorPrincipal.getInstancia().getCtrlE().getListaEmprestimo().remove(emprestimo);
                    String mensagem = NegacaoPermissao.Status3Chave.descricaoDoStatus;
                    tela.mensagem(mensagem);
                    AssocVeiculoFuncionario assoc = new AssocVeiculoFuncionario(ControladorPrincipal.getInstancia().getCtrlV().pegaVeiculoPelaPlaca(placa),ControladorPrincipal.getInstancia().getCtrlF().pegaFuncionarioPelaMatricula(matr));
                    String situacao = " Veículo devolvido ";
                    String motivo = " Devolução efetuada com sucesso ";
                     Data data = new Data();
                    Emprestimo  devolucao = new Emprestimo(assoc,data);
                   
                    
                    ControladorPrincipal.getInstancia().getCtrlE().getDevolucoes().add(devolucao);
                    }else {
                        
                       String mensagem =  NegacaoPermissao.Status7Carro.descricaoDoStatus;
                       tela.mensagem(mensagem);
                    }
                    
                    
                }else{
                    String mensagem = " Carro não foi emprestado ";
                    //String mensagem = NegacaoPermissao.Status1Carro.descricaoDoStatus;
                    tela.mensagem(mensagem);
                    
                }
                
            } else {
                String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
                tela.mensagem(mensagem);
               
            }
        } else {
            String mensagem = NegacaoPermissao.Status2Carro.descricaoDoStatus;
            tela.mensagem(mensagem);
            
        }

    }
}     

               
   