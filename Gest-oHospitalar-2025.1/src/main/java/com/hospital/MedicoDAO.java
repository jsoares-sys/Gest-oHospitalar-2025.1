package com.hospital;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
    public static boolean inserirMedico(Medico medico) {
        String sql = "INSERT INTO tb_medicos (nome_medico, CPF_medico, email_medico, telefone_medico, endereco_medico, " +
                     "RG_medico, dt_nasc_medico, sexo_medico, est_civil_medico, especialidade_medico, CRM_medico) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setLong(2, medico.getCpf());
            stmt.setString(3, medico.getEmail());
            stmt.setLong(4, medico.getTelefone());
            stmt.setString(5, medico.getEndereco());
            stmt.setLong(6, medico.getRg());
            stmt.setDate(7, java.sql.Date.valueOf(medico.getDataNascimento()));
            stmt.setString(8, String.valueOf(medico.getSexo()));
            stmt.setString(9, medico.getEstadoCivil());
            stmt.setString(10, medico.getEspecialidade());
            stmt.setLong(11, medico.getCrm());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir médico: " + e.getMessage());
            return false;
        }
    }
}
