package jorgejr.list_manager.model.entity;

import jakarta.persistence.*;
import jorgejr.list_manager.model.dto.TaskListInput;

@Entity
@Table(name = "task_list")
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TaskList() {
    }
    public TaskList(TaskListInput input){
         this.nome = input.nome();
         this.descricao =  input.descricao();
    }
}
