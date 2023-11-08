package com.ubscuidebem;

import com.ubscuidebem.db.PacienteDAO;
import com.ubscuidebem.model.Paciente;

public class Main {
    public static void main(String[] args) {
        
        Paciente paciente = new Paciente();
        paciente.setNome("Antonio");
        paciente.setTelefone("123456789");
        paciente.setUnidadeSUS("01");
        
        PacienteDAO.getInstance().criarPaciente(paciente);

        Paciente buscaPaciente = PacienteDAO.getInstance().buscarPaciente(1); 
        if (buscaPaciente != null) {
            System.out.println(buscaPaciente);
        }
        paciente.setNome("julio");
        PacienteDAO.getInstance().atualizarPaciente(1,paciente);
        System.out.println(paciente);

    }
}