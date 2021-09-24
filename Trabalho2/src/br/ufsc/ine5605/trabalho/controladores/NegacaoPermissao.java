/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho.controladores;

/**
 *
 * @author LucasTS
 */
public enum NegacaoPermissao {
    
    Status1Chave("Chave liberada"),
    Status2Chave("Chave não liberada"),
    Status3Chave("Chave devolvida com sucesso"),
    Status1Emprestimo("Emprestimo efetuado com sucesso"),
    Status1Acesso("Acesso permitido"),
    Status2Acesso("Acesso negado"),
    Status1Funcionario("Funcionario não autorizado"),
    Status2Funcionario("Matricula não existe"),
    Status3Funcionario("Matricula de diretor não existe"),
    Status4Funcionario( " Funcionario não existe"),
    Status5Funcionario( " Funcionário excluído com sucesso "),
    StatusFuncionario8( " Alterado com sucesso "),
    Status1Carro("Carro já emprestado"),
    Status2Carro("Placa não existe"),
    Status3Carro("Carro está emprestado"),
    Status4Carro("Carro não está emprestado"),
    Status5Carro("Sem carro cadastrado"),
    Status7Carro("Quilometragem menor que a antiga "),
    Status6Carro(" Placa já cadastrada - Cadastro não efetuado - "),
    Status1Cadastro("Matricula já existente - cadastro não foi efetuado"),
    Status2Cadastro("Cadastrado com sucesso"),
    Status1Bloqueio("Funcionario bloqueado"),
    Status2Bloqueio("Funcionario desbloqueado"),
    Status3Bloqueio("Funcionario não está bloqueado"),
    
    AuxiliarTela( " ------------------------------------------------------------------  ");
    public String descricaoDoStatus;
    
    NegacaoPermissao(String descricaoStatus) {
        this.descricaoDoStatus = descricaoStatus;
    }
}
