package com.hospital;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cadastrar-medico")
public class MedicoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Coletando os dados do formulário
        String nome = request.getParameter("nome_medico");
        long cpf = Long.parseLong(request.getParameter("CPF_medico"));
        String email = request.getParameter("email_medico");
        long telefone = Long.parseLong(request.getParameter("telefone_medico"));
        String endereco = request.getParameter("endereco_medico");
        long rg = Long.parseLong(request.getParameter("RG_medico"));
        String dataNascimentoStr = request.getParameter("dt_nasc_medico");
        String sexo = request.getParameter("sexo_medico");
        String estadoCivil = request.getParameter("est_civil_medico");
        String especialidade = request.getParameter("especialidade_medico");
        long crm = Long.parseLong(request.getParameter("CRM_medico"));

        // Convertendo a data de nascimento de String para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Criando um objeto Medico com os dados do formulário
        Medico medico = new Medico(nome, cpf, email, telefone, endereco, rg, 
                                   dataNascimento, sexo.charAt(0), estadoCivil, especialidade, crm);

        // Chamando o MedicoDAO para inserir o médico no banco
        boolean sucesso = MedicoDAO.inserirMedico(medico);

        // Respondendo ao usuário com sucesso ou falha
        if (sucesso) {
            response.getWriter().println("Médico cadastrado com sucesso!");
        } else {
            response.getWriter().println("Erro ao cadastrar o médico.");
        }
    }
}
