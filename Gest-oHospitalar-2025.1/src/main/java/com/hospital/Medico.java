package com.hospital;

import java.time.LocalDate;

public class Medico {
    private final String nome;
    private long cpf;
    private String email;
    private long telefone;
    private String endereco;
    private long rg;
    private LocalDate dataNascimento;
    private char sexo;
    private String estadoCivil;
    private String especialidade;
    private long crm;

    // Construtor para inicializar todos os campos
    public Medico(String nome, long cpf, String email, long telefone, String endereco, long rg, 
                  LocalDate dataNascimento, char sexo, String estadoCivil, String especialidade, long crm) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    // Getters
    public String getNome() { return nome; }
    public long getCpf() { return cpf; }
    public String getEmail() { return email; }
    public long getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }
    public long getRg() { return rg; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public char getSexo() { return sexo; }
    public String getEstadoCivil() { return estadoCivil; }
    public String getEspecialidade() { return especialidade; }
    public long getCrm() { return crm; }
}
