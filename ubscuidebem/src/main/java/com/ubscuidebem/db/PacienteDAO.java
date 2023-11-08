package com.ubscuidebem.db;

import com.ubscuidebem.model.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PacienteDAO {

    private static PacienteDAO instance;
    private EntityManager entityManager;

    public static PacienteDAO getInstance(){
        if(instance==null)
        instance = new PacienteDAO();
        
        return instance; 
    }
    private PacienteDAO(){
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_exemplo");
        if(entityManager==null)
            entityManager= factory.createEntityManager();
        
        return entityManager;
    }

    //Lê todos os pacientes
    // public List<Paciente> getTodosPacientes() {
    //     List<Paciente> pacientes = new ArrayList<>();
    //     }
    

    //Cria um novo paciente
    public void criarPaciente(Paciente paciente) {
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(paciente);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    //Atualiza um paciente existente
    public void atualizarPaciente(int id,Paciente paciente) {
        try{
            entityManager.getTransaction().begin();

            Paciente pacienteAntigo = entityManager.find(Paciente.class, id);
            if (pacienteAntigo!=null){
                entityManager.merge(pacienteAntigo);
                entityManager.getTransaction().commit();
            }else{
                System.out.println("Paciente não existe");
                entityManager.getTransaction().rollback();

            }
        }catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    //Busca um paciente da lista
    public Paciente buscarPaciente(int id){
        return entityManager.find(Paciente.class, id);
    }

    //Deleta um paciente da lista
    public void deletarPaciente(int id) {
        try{
            entityManager.getTransaction().begin();
            Paciente paciente = entityManager.find(Paciente.class, id);
            if(paciente!=null){
                entityManager.remove(paciente);
            }else{
                System.out.println("Paciente não existe");
                entityManager.getTransaction().rollback();

            }

        }  catch(Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

}